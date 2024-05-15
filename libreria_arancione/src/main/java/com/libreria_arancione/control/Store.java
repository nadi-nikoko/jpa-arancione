package com.libreria_arancione.control;

import com.libreria_arancione.entity.BookShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USR, JDBC_PWD);
    }

    // Student Methods

    public static void saveStudent(Student student) {
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO student (name, surname, email, phone, schoolYear) VALUES (?,?,?,?,?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                StoreUtil.studentConstructor(ps, student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void InvalidateStudent(Student student) {
        try (Connection conn = getConnection()) {
            String sql = "UPDATE student SET activate=false WHERE id=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setLong(1, student.getId());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> findStudentByNameOrSurname(String name) {
        List<Student> foundStudents = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE (name LIKE? OR surname LIKE?) AND activate=true";
        try (Connection conn = getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, "%" + name + "%");
                ps.setString(2, "%" + name + "%");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Student studentConstructor = StoreUtil.studentConstructor(rs);
                    foundStudents.add(studentConstructor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundStudents;
    }

    public static Optional<Student> findStudentById(int id) {
        Optional<Student> studentOptional = Optional.empty();
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM student WHERE id=? AND activate = true";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                studentOptional = StoreUtil.studentSetter(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentOptional;
    }

    // Books Methods

    public static void InvalidateBook(BookShop book) {
        try (Connection conn = getConnection()) {
            String sql = "UPDATE library SET available=false WHERE id=?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setLong(1, book.getId());
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<BookShop> findBookByTitleOrAuthor(String name) {
        List<BookShop> result = new ArrayList<>();
        String sql = "SELECT * FROM library WHERE (title LIKE? OR author LIKE?) AND available = true";
        try (Connection conn = getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, "%" + name + "%");
                ps.setString(2, "%" + name + "%");
                ResultSet resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    BookShop book = StoreUtil.bookConstructor(resultSet);
                    result.add(book);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Optional<BookShop> findBookById(int id) {
        Optional<BookShop> bookOptional = Optional.empty();
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM library WHERE id =? AND available = true";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                bookOptional = StoreUtil.bookSetter(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookOptional;
    }

    public static void saveBook(BookShop book) {
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO library (title, author, yearOfPublication, ISBN, publisher, available) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                StoreUtil.bookConstructor(pstmt, book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DEALING WITH DATA METHODS

    public static void saveBookTransaction(BookTransaction bookTransaction) {
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO book_transaction(id, price, book_id, student_id) VALUES (?,?,?,?) ";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setLong(1, bookTransaction.getId());
                ps.setInt(2, bookTransaction.getPrice());
                ps.setLong(3, bookTransaction.getBook().getId());
                ps.setLong(4, bookTransaction.getStudent().getId());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<BookTransaction> booksTransactionList() {
        List<BookTransaction> transactionList = new ArrayList<>();
        String sql = "SELECT bt.id AS transaction_id, b.title AS book_title, b.author AS book_author, b.yearOfPublication, b.ISBN, b.publisher, st.name AS student_name, st.surname AS student_surname, st.email, st.phone, st.schoolYear, bt.price, bt.soldDate FROM book_transaction bt JOIN library b ON bt.book_id = b.id JOIN student st ON bt.student_id = st.id";

        try (Connection conn = getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                while (rs.next()) {
                    BookTransaction transaction = new BookTransaction();
                    transaction.setId(rs.getLong("transaction_id"));
                    transaction.setBook(new BookShop(
                            rs.getString("book_title"),
                            rs.getString("book_author"),
                            rs.getInt("yearOfPublication"),
                            rs.getInt("ISBN"),
                            rs.getString("publisher")));

                    transaction.setStudent(new Student(
                            rs.getString("student_name"),
                            rs.getString("student_surname"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            rs.getString("schoolYear")));
                    transaction.setPrice(rs.getInt("price"));
                    transaction.setSoldDate(rs.getDate("soldDate"));

                    transactionList.add(transaction);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactionList;
    }

    public static int TotalBooksSold() {
        int totalBooksSold = 0;
        String sql = "SELECT COUNT(*) FROM book_transaction"; // Define the SQL query

        try (Connection conn = getConnection(); // Use semicolon to separate statements
                PreparedStatement ps = conn.prepareStatement(sql); // Pass the SQL query to prepareStatement
                ResultSet rs = ps.executeQuery()) { // Execute the prepared statement
            if (rs.next()) {
                totalBooksSold = rs.getInt(1); // Correctly retrieve the count value
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalBooksSold;
    }

    public static int TotalCash() {
        int totalCash = 0;
        String sql = "SELECT SUM(price) FROM book_transaction";
        try (Connection conn = getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    totalCash = rs.getInt(1); // Get the sum value
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalCash;// Convert to integer and round if necessary
    }
}
