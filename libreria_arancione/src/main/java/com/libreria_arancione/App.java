package com.libreria_arancione;

import com.libreria_arancione.boundary.LibreriaArancione;
import com.libreria_arancione.entity.BookShop;
import com.libreria_arancione.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        /*
         * LibreriaArancione.saveStudent("ale", "xx", "xxxxl@mail.com", "8945434",
         * "4th grade");
         * LibreriaArancione.saveStudent("lukis", "alay", "ddsadas@mail.com", "4324324",
         * "7th grade");
         * 
         * LibreriaArancione.saveBook("zzzzzzero and ones", "sadie plath", 21, 5545,
         * "independent");
         * LibreriaArancione.saveBook("glitch feminism", "Legacy Russel", 23, 43423,
         * "independent");
         * LibreriaArancione.saveBook("an appartament in uranus", "paul preciado", 31,
         * 23125,
         * "penguin");
         */

        // LibreriaArancione.deleteStudent(2);

        // LibreriaArancione.Purchase(LibreriaArancione.findBookById(3),
        // LibreriaArancione.findStudentById(1), 10);

        // System.out.println(LibreriaArancione.findStudentById(1));
        // System.out.println(LibreriaArancione.findStudentsByNameOrSurname("a"));
        System.out.println(LibreriaArancione.booksTransactionList());
    }
}
