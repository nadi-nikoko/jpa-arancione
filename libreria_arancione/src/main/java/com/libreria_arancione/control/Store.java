package com.libreria_arancione.control;

import com.libreria_arancione.entity.BookShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.libreria_arancione.entity.BookTransaction;
import com.libreria_arancione.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.JOptionPane;

public class Store {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(Store.JPA_PU);
    private static EntityManager em = null;

    private static final String JPA_PU = "libreria";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/libreria";
    private static final String JDBC_USR = "libreria";
    private static final String JDBC_PWD = "libreria";

    static {
        System.out.println("create entity manager");
        em = emf.createEntityManager();
    }

    // Transaction Methods

    public static void beginTransaction() {
        if (em.getTransaction().isActive()) {
            throw new StoreException("There is already a Transation on going");
        }
        em.getTransaction().begin();
    }

    public static void commitTransaction() {
        if (!em.getTransaction().isActive()) {
            throw new StoreException("There is no transation on");
        }
        em.getTransaction().commit();
    }

    public static void rollTran() {
        if (!em.getTransaction().isActive()) {
            return;
        }
        em.getTransaction().rollback();
    }
    // Student Methods

    public static void saveStudent(Student student) {

        if (!em.getTransaction().isActive())
            beginTransaction();
        Student saved = em.merge(student);
        commitTransaction();
    }

    public static void InvalidateStudent(Student student) {

        student.setActivate(false);
        beginTransaction();
        em.merge(student);
        commitTransaction();
    }

    public static List<Student> findStudentByName(String name) {
        List<Student> resultListNames = em.createNamedQuery(Student.FIND_STUDENT_BY_NAME, Student.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
        List<Student> resultListSurname = em.createNamedQuery(Student.FIND_STUDENT_BY_SURNAME, Student.class)
                .setParameter("surname", "%" + name + "%")
                .getResultList();

        List<Student> combinedList = new ArrayList(resultListNames);
        combinedList.addAll(resultListSurname);

        return combinedList.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static Optional<Student> findStudentById(int id) {
        Optional<Student> studentOptional = Optional.empty();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USR, JDBC_PWD)) {
            String sql = "SELECT * FROM student WHERE id=? AND activate = true";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setSurname(rs.getString("surname"));
                    student.setEmail(rs.getString("email"));
                    student.setPhone(rs.getString("phone"));
                    student.setSchoolYear(rs.getString("schoolYear"));
                    student.setActivate(rs.getBoolean("activate"));
                    studentOptional = Optional.of(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentOptional;
    }

    // Books Methods

    public static void AddBook(BookShop book) {
        if (!em.getTransaction().isActive())
            beginTransaction();
        BookShop saved = em.merge(book);
        commitTransaction();
    }

    public static void saveBookTransaction(BookTransaction bookTransaction) {
        beginTransaction();
        BookTransaction saved = em.merge(bookTransaction);
        commitTransaction();
    }

    public static void InvalidateBook(BookShop book) {
        book.setAvailable(false);
        beginTransaction();
        em.merge(book);
        commitTransaction();
    }

    public static List<BookShop> findBookByTitleOrAuthor(String name) {

        List<BookShop> resultListTitle = em.createNamedQuery(BookShop.FIND_BOOK_BY_TITLE, BookShop.class)
                .setParameter("title", "%" + name + "%")
                .getResultList();
        List<BookShop> resultListAuthor = em.createNamedQuery(BookShop.FIND_BOOK_BY_AUTHOR, BookShop.class)
                .setParameter("author", "%" + name + "%")
                .getResultList();
        List<BookShop> combinedList = new ArrayList(resultListTitle);
        combinedList.addAll(resultListAuthor);

        return combinedList.stream()
                .distinct()
                .collect(Collectors.toList());

    }

    public static Optional<BookShop> findBookById(int id) {
        Optional<BookShop> bookOptional = Optional.empty();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USR, JDBC_PWD)) {
            String sql = "SELECT * FROM library WHERE id =? AND available = true";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                BookShop book = StoreUtil.bookSetter(rs);
                bookOptional = Optional.of(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookOptional;
    }

    public static void saveBook(BookShop book) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USR, JDBC_PWD)) {
            String sql = "INSERT INTO library (title, author, yearOfPublication, ISBN, publisher, available) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, book.getTitle());
                pstmt.setString(2, book.getAuthor());
                pstmt.setInt(3, book.getYearOfPublication());
                pstmt.setInt(4, book.getISBN());
                pstmt.setString(5, book.getPublisher());
                pstmt.setBoolean(6, book.isAvailable());

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void changeAvailabilityBook(BookShop book, boolean availability) {
        try {
            book.setAvailable(availability);
            beginTransaction();
            BookShop merge = em.merge(book);
            commitTransaction();
        } catch (StoreException e) {
            JOptionPane.showMessageDialog(null, "Change Availability didnt work");
        }
    }

    // DEALING WITH DATA METHODS

    public static List<BookTransaction> booksTransactionList() {
        return em.createQuery("SELECT bt FROM BookTransaction bt", BookTransaction.class)
                .getResultList();
    }

    public static int TotalBooksSold() {
        Number singleResult = (Number) em.createQuery("SELECT COUNT(*) FROM BookTransaction bt").getSingleResult();
        return singleResult.intValue();
    }

    public static int TotalCash() {
        Number singleResult = (Number) em.createQuery("SELECT SUM(price) FROM BookTransaction bt").getSingleResult();
        return singleResult.intValue();
    }
}
