package com.libreria_arancione;

import java.util.List;

import com.libreria_arancione.boundary.LibreriaArancione;
import com.libreria_arancione.control.Store;
import com.libreria_arancione.entity.BookTransaction;
import com.libreria_arancione.entity.BookShop;
import com.libreria_arancione.entity.CoverType;
import com.libreria_arancione.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        LibreriaArancione.addStudent("nico", "nadi", "email@mail.com", "89454", "4th grade");

        LibreriaArancione.addBook("zero and ones", "sadie plath", 21, 5545, CoverType.HARDCOVER, "independent");
        LibreriaArancione.addBook("glitch feminism", "Legacy Russel", 23, 43423, CoverType.PAPERBACK, "independent");
        LibreriaArancione.addBook("an appartament in uranus", "paul preciado", 31, 23125, CoverType.HARDCOVER,
                "penguin");

        LibreriaArancione.Purchase(
                new BookShop("cyberborg manifest", "haraway", 45, 5465468, CoverType.HARDCOVER, "university db"),
                new Student("anna", "xxxx", "anax@mail.com", "456454", "6th grade"), 10);

    }
}
