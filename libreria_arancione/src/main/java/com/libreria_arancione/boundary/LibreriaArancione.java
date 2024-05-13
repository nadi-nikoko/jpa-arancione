package com.libreria_arancione.boundary;

import java.util.List;
import com.libreria_arancione.control.Store;
import com.libreria_arancione.entity.BookTransaction;
import com.libreria_arancione.entity.CoverType;
import com.libreria_arancione.entity.Library;
import com.libreria_arancione.entity.Student;

public class LibreriaArancione {

    public static void addStudent(String name, String surname, String email, String phone, String schoolYear) {

        Student std = new Student(name, surname, email, phone, schoolYear);
        Store.saveStudent(std);
    }

    public static void saveBook(String title, String author, int iSBN, int yearOfPublication, CoverType hardcover,
            String publisher) {
        Library book = new Library(title, author, yearOfPublication, iSBN, hardcover, publisher);
        Store.saveLibrary(book);
    }

    public static void updateBook(Library book) {
        Store.saveLibrary(book);
    }

    public static void updateStudent(Student Student) {
        Store.saveStudent(Student);
    }

    public static Student findStudentById(int id) {
        Student studentBuyer = Store.findStudentById(id);
        return studentBuyer;
    }

    public static Library findBookById(int id) {
        Library book = Store.findBookById(id);
        return book;
    }

    public static void Purchase(Library bookById, Student studentById, int price) {
        BookTransaction purchase = new BookTransaction(bookById, studentById, price);
        Store.changeAvailabilityBook(bookById, false);
        Store.saveBookTransaction(purchase);
    }

    public static List<Library> findBookByTitle(String book) {
        List<Library> bookByTitle = Store.findBookByTitle(book);
        return bookByTitle;
    }

    public static List<Student> findStudentsByName(String student) {
        List<Student> studentsByName = Store.findStudentByName(student);
        return studentsByName;
    }

    public static void deleteBook(int id) {
        Library book = findBookById(id);
        Store.InvalidateBook(book);
    }

    public static void deleteStudent(int id) {
        Student student = findStudentById(id);
        Store.InvalidateStudent(student);
    }

    public static List<BookTransaction> booksTransaction() {
        return Store.booksTransaction();
    }

    public static int TotalBooksSold() {
        return Store.TotalBooksSold();
    }

    public static int TotalCash() {
        return Store.TotalCash();
    }

}
