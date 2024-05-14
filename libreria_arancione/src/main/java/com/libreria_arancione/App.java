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

        LibreriaArancione.saveStudent("ale", "xx", "xxxxl@mail.com", "8945434", "4th grade");

        LibreriaArancione.saveBook("zzzzzzero and ones", "sadie plath", 21, 5545, "independent");
        LibreriaArancione.saveBook("glitch feminism", "Legacy Russel", 23, 43423,
        "independent");
        LibreriaArancione.saveBook("an appartament in uranus", "paul preciado", 31,
        23125,
        "penguin");

        // LibreriaArancione.Purchase(
        // new BookShop("cyberborg manifest", "haraway", 45, 5465468, "university db"),
        // new Student("anna", "xxxx", "anax@mail.com", "456454", "6th grade"), 10);

        System.out.println(LibreriaArancione.findBookById(1));
        System.out.println(LibreriaArancione.findStudentById(1));
    }
}
