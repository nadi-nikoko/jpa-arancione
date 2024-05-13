package com.libreria_arancione.entity;

import jakarta.persistence.Column;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NamedQueries({
        @NamedQuery(name = Library.FIND_BOOK_BY_TITLE, query = "SELECT l from Library l WHERE l.title LIKE :title AND available=true"),
        @NamedQuery(name = Library.FIND_BOOK_BY_AUTHOR, query = "SELECT l FROM Library l WHERE l.author LIKE :author AND available=true")
})
@Table(name = "library")
public class Library implements Serializable {

    public final static String FIND_BOOK_BY_TITLE = "Library.findBookByTitle";
    public final static String FIND_BOOK_BY_AUTHOR = "Library.findBookByAuthor";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable=false)
    @NotBlank (message = "The title field is required")
    private String title;
    @Column(nullable=false)
    @NotBlank (message = "The author field is required")
    private String author;
    @Column(nullable=false)
    private int yearOfPublication;
    @Column(nullable=false)
    private int ISBN;
    @Column(nullable=false)
    private CoverType coverType;
    @Column(nullable=false)
    @NotBlank (message = "The publisher field is required")
    private String publisher;
    private boolean available;

    public Library() {
    }

    public Library(String title, String author, int yearOfPublication, int ISBN, CoverType coverType,
            String publisher) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.ISBN = ISBN;
        this.coverType = coverType;
        this.publisher = publisher;
        available = true;
    }

}
