package com.libreria_arancione.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.libreria_arancione.entity.BookShop;
import com.libreria_arancione.entity.Student;

public class StoreUtil {

    public static void bookConstructor(PreparedStatement pstmt, BookShop book) throws SQLException {
        pstmt.setString(1, book.getTitle());
        pstmt.setString(2, book.getAuthor());
        pstmt.setInt(3, book.getYearOfPublication());
        pstmt.setInt(4, book.getISBN());
        pstmt.setString(5, book.getPublisher());
        pstmt.setBoolean(6, book.isAvailable());
        pstmt.executeUpdate();
    }

    public static BookShop bookConstructor(ResultSet resultSet) throws SQLException {
        BookShop book = new BookShop();
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setYearOfPublication(resultSet.getInt("yearOfPublication"));
        book.setISBN(resultSet.getInt("ISBN"));
        book.setPublisher(resultSet.getString("publisher"));
        return book;
    }

    public static Student studentConstructor(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setSurname(resultSet.getString("surname"));
        student.setEmail(resultSet.getString("email"));
        student.setPhone(resultSet.getString("phone"));
        return student;
    }

    public static void studentConstructor(PreparedStatement ps, Student student) throws SQLException {
        ps.setString(1, student.getName());
        ps.setString(2, student.getSurname());
        ps.setString(3, student.getEmail());
        ps.setString(4, student.getPhone());
        ps.setString(5, student.getSchoolYear());
        ps.executeUpdate();
    }

    public static Optional<BookShop> bookSetter(ResultSet rs) throws SQLException {
        if (rs.next()) {
            BookShop book = new BookShop();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setYearOfPublication(rs.getInt("yearOfPublication"));
            book.setISBN(rs.getInt("ISBN"));
            book.setPublisher(rs.getString("publisher"));
            book.setAvailable(rs.getBoolean("available"));
            return Optional.of(book);
        }
        return Optional.empty();
    }

    public static Optional<Student> studentSetter(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setSurname(rs.getString("surname"));
            student.setEmail(rs.getString("email"));
            student.setPhone(rs.getString("phone"));
            student.setSchoolYear(rs.getString("schoolYear"));
            student.setActivate(rs.getBoolean("activate"));
            return Optional.of(student);
        }
        return Optional.empty();
    }

}
