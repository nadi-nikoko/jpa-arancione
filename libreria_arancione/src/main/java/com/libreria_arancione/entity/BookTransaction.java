package com.libreria_arancione.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "book_transaction")
public class BookTransaction extends BaseEntity implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Library book;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;
    private Date soldDate;
    private int price;

    public BookTransaction(Library book, Student student, int price) {
        this.book = book;
        this.student = student;
        this.price = price;
        this.soldDate = new Date();
    }
    
    @Override
    public String toString() {
        return "Student: " + getStudent().getName() + "; Book: " + getBook().getTitle() + "; Price: " + getPrice() + "; Sold: " + getSoldDate();
    }

}
