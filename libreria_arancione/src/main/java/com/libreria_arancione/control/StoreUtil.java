package com.libreria_arancione.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.libreria_arancione.entity.BookShop;

public class StoreUtil {

    public static BookShop bookSetter(ResultSet rs) {
        BookShop book = null;
        try {
            if (rs.next()) {
                book = new BookShop();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setYearOfPublication(rs.getInt("yearOfPublication"));
                book.setISBN(rs.getInt("ISBN"));
                book.setPublisher(rs.getString("publisher"));
                book.setAvailable(rs.getBoolean("available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

}
