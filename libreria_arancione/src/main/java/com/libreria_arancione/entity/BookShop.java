package com.libreria_arancione.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NamedQueries({
        @NamedQuery(name = BookShop.FIND_BOOK_BY_TITLE, query = "SELECT l from BookShop l WHERE l.title LIKE :title AND available=true"),
        @NamedQuery(name = BookShop.FIND_BOOK_BY_AUTHOR, query = "SELECT l FROM BookShop l WHERE l.author LIKE :author AND available=true")
})
@Table(name = "library")
public class BookShop extends BaseEntity {

    public final static String FIND_BOOK_BY_TITLE = "BookShop.findBookByTitle";
    public final static String FIND_BOOK_BY_AUTHOR = "BookShop.findBookByAuthor";

    @Column(nullable = false)
    @NotBlank(message = "The title field is required")
    private String title;
    @Column(nullable = false)
    @NotBlank(message = "The author field is required")
    private String author;
    @Column(nullable = false)
    private int yearOfPublication;
    @Column(nullable = false)
    private int ISBN;
    @Column(nullable = false)
    @NotBlank(message = "The publisher field is required")
    private String publisher;
    private boolean available;

    public BookShop() {
    }

    public BookShop(String title, String author, int yearOfPublication, int ISBN,
            String publisher) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.ISBN = ISBN;
        this.publisher = publisher;
        available = true;
    }

}
