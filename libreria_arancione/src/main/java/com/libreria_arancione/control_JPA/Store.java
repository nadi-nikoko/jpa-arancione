package com.libreria_arancione.control_JPA;

import com.libreria_arancione.entity.BookShop;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.libreria_arancione.entity.BookTransaction;
import com.libreria_arancione.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.JOptionPane;

public class Store {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
    private static EntityManager em = emf.createEntityManager();

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

    public static Student findStudentById(int id) {
        return em.createQuery("SELECT s FROM Student s WHERE s.id =:id  AND s.activate=true", Student.class)
                .setParameter("id", id)
                .getSingleResult();
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

    public static BookShop findBookById(int id) {
        return em.createQuery("SELECT l FROM BookShop l WHERE l.id =:id AND available=true", BookShop.class)
                .setParameter("id", id)
                .getSingleResult();
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
