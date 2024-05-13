package com.libreria_arancione;

import java.util.List;

import com.libreria_arancione.control.Store;
import com.libreria_arancione.entity.BookTransaction;
import com.libreria_arancione.entity.Library;
import com.libreria_arancione.entity.CoverType;
import com.libreria_arancione.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        Student student = new Student("nico", "nadi", "email", "545454", "4th grade");
        Store.saveStudent(student);

        Library bookItem = new Library("zero and ones", "sadie plath", 21, 5545, CoverType.HARDCOVER, "independent");
        Library bookItem2 = new Library("cyberborg manifest", "haraway", 45, 5465468, CoverType.HARDCOVER, "university db");
        Library bookItem3 = new Library("glitch feminism", "Legacy Russel", 23, 43423, CoverType.PAPERBACK, "independent");
        Library bookItem4 = new Library("an appartament in uranus", "paul preciado", 31, 23125, CoverType.HARDCOVER, "penguin");
      

        Store.saveLibrary(bookItem);
        Store.saveLibrary(bookItem2);
        Store.saveLibrary(bookItem3);
        Store.saveLibrary(bookItem4);
        
        BookTransaction bookTransaction = new BookTransaction(bookItem, student, 10);

        Store.saveBookTransaction(bookTransaction);

        String book = "zero and ones";
        List<Library> bookByTitle = Store.findBookByTitle(book);

        for (Library bk : bookByTitle) {
            System.out.println("title: " + bk.getTitle() + " author: " + bk.getAuthor());
        }

        System.out.println("THISSSSSS : " + Store.findStudentByName("nic"));
        
        
        List<Student> studentByName = Store.findStudentByName("nic");
        for (Student std : studentByName) {
            System.out.println("student: " + std.getName() + " " + std.getSurname());
        }

        List<Student> studentBySurname = Store.findStudentBySurname("nad");
        for (Student std : studentBySurname) {
            System.out.println("student: " + std.getName() + " " + std.getSurname());
        }

        // List<Library> bookByAuthor = Store.findBookByAuthor("sadi");
        // for (Library book : bookByAuthor) {
        // System.out.println("title: " + book.getTitle() + " author: " +
        // book.getAuthor());
        // }

    }
}
