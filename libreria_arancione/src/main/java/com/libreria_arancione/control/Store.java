package com.libreria_arancione.control;

import com.libreria_arancione.entity.Library;

import java.util.List;
import java.util.Optional;

import com.libreria_arancione.entity.BookTransaction;
import com.libreria_arancione.entity.CoverType;
import com.libreria_arancione.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javax.swing.JOptionPane;

public class Store {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
    private static EntityManager em = emf.createEntityManager();

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

    public static void saveStudent(Student student) {

        beginTransaction();
        Student saved = em.merge(student);
        commitTransaction();

        System.out.println("Student saved successfully!");
    }

    public static void saveLibrary(Library book) {

        beginTransaction();
        Library saved = em.merge(book);
        commitTransaction();
        System.out.println("book item saved");
    }

    public static void saveBookTransaction(BookTransaction bookTransaction) {
        beginTransaction();
        BookTransaction saved = em.merge(bookTransaction);
        commitTransaction();
        System.out.println("book Transaction valid");
    }
    
    public static void InvalidateStudent(Student student){
        
        student.setActivate(false);
        beginTransaction();
        em.merge(student);
        commitTransaction();
    }
    
     public static void InvalidateBook(Library book) {
         book.setAvailable(false);
         beginTransaction();
         em.merge(book);
         commitTransaction();
     }

    public static List<Library> findBookByTitle(String title) {
        return em.createNamedQuery(Library.FIND_BOOK_BY_TITLE, Library.class)
                .setParameter("title", "%" + title + "%")
                .getResultList();
    }

    public static List<Library> findBookByAuthor(String author) {
        return em.createNamedQuery(Library.FIND_BOOK_BY_AUTHOR, Library.class)
                .setParameter("author", "%" + author + "%")
                .getResultList();
    }

    public static List<Student> findStudentByName(String name) {
        return em.createNamedQuery(Student.FIND_STUDENT_BY_NAME, Student.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    public static List<Student> findStudentBySurname(String surname) {
        return em.createNamedQuery(Student.FIND_STUDENT_BY_SURNAME, Student.class)
                .setParameter("surname", "%" + surname + "%")
                .getResultList();
    }
    
    public static Student findStudentById (int id){
        return em.createQuery("SELECT s FROM Student s WHERE s.id =:id  AND s.activate=true", Student.class)
                .setParameter("id", id)
                .getSingleResult();       
    }
    public static Library findBookById(int id){
        return em.createQuery("SELECT l FROM Library l WHERE l.id =:id AND available=true", Library.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    
    public static void changeAvailabilityBook(Library book, boolean availability){
        try{
        book.setAvailable(availability);
        beginTransaction();
        Library merge = em.merge(book);
        commitTransaction();
        System.out.println("change availability");
        } catch (StoreException e){
            JOptionPane.showMessageDialog(null, "Change Availability didnt work");
        }
    }
    
    public static List<BookTransaction> booksTransaction(){
        return em.createQuery("SELECT bt FROM BookTransaction bt", BookTransaction.class)
                .getResultList();
    } 
}
