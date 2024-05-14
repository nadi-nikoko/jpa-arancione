package com.libreria_arancione.GUI;

import com.libreria_arancione.boundary.LibreriaArancione;
import com.libreria_arancione.control.Store;
import com.libreria_arancione.entity.BookShop;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

/**
 *
 * @author utentepc
 */
public class AddBook extends javax.swing.JDialog {

        private javax.swing.JButton btnAddBook;
        private javax.swing.JButton btnReturn;
        private javax.swing.JLabel jTitle;
        private javax.swing.JLabel jAuthor;
        private javax.swing.JLabel jYearOfPublication;
        private javax.swing.JLabel jISBN;
        private javax.swing.JLabel jPublisher;
        private javax.swing.JTextField txAuthor;
        private javax.swing.JTextField txISBN;
        private javax.swing.JTextField txPublisher;
        private javax.swing.JTextField txTitle;
        private javax.swing.JTextField txYearOfPublication;

        private boolean update;
        private BookShop updateBook;

        public AddBook() {
                this.update = false;
                initComponents();
                addEventListeners();
        }

        public AddBook(int id) {
                this.update = true;
                updateBook = Store.findBookById(id);
                initComponents();
                txAuthor.setText(updateBook.getAuthor());
                txISBN.setText(String.valueOf(updateBook.getISBN()));
                txPublisher.setText(updateBook.getPublisher());
                txTitle.setText(updateBook.getTitle());
                txYearOfPublication.setText(String.valueOf(updateBook.getYearOfPublication()));
                addEventListeners();
        }

        @SuppressWarnings("unchecked")
        private void initComponents() {

                this.getContentPane().setBackground(new java.awt.Color(173, 216, 230)); // Light Blue

                jTitle = new javax.swing.JLabel();
                jAuthor = new javax.swing.JLabel();
                jYearOfPublication = new javax.swing.JLabel();
                jISBN = new javax.swing.JLabel();
                jPublisher = new javax.swing.JLabel();
                txAuthor = new javax.swing.JTextField();
                txYearOfPublication = new javax.swing.JTextField();
                txISBN = new javax.swing.JTextField();
                txPublisher = new javax.swing.JTextField();
                txTitle = new javax.swing.JTextField();
                btnAddBook = new javax.swing.JButton();
                btnReturn = new javax.swing.JButton();

                btnAddBook.setBackground(new java.awt.Color(255, 165, 0)); // Orange
                btnReturn.setBackground(new java.awt.Color(255, 165, 0)); // Orange

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jTitle.setText("Title");
                jAuthor.setText("Author");
                jYearOfPublication.setText("Year Of Publication");
                jISBN.setText("ISBN");
                jPublisher.setText("Publisher");
                btnAddBook.setText("SAVE");
                btnReturn.setText("return");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(297, 297, 297)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jISBN)
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addComponent(jAuthor)
                                                                                                                                .addComponent(jTitle))
                                                                                                                .addComponent(jPublisher))
                                                                                                .addGap(40, 40, 40))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addContainerGap()
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addComponent(jYearOfPublication))
                                                                                                                .addGap(31, 31, 31)))
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                20,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(txAuthor,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                480,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(txTitle,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                480,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(txYearOfPublication,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                480,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(58, 58, 58)
                                                                                                .addComponent(btnAddBook)
                                                                                                .addComponent(btnReturn)
                                                                                                .addContainerGap(62,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(31, 31, 31)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(txISBN,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                480,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(txPublisher)))))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGap(178, 178, 178)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(49, 49, 49)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(txTitle,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jTitle))
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(txAuthor,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                48,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jAuthor)))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(53, 53, 53)
                                                                                                .addComponent(btnAddBook)
                                                                                                .addComponent(btnReturn)))
                                                                .addGap(9, 9, 9)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(txYearOfPublication,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jYearOfPublication))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(txISBN,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jISBN))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(txPublisher,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jPublisher))
                                                                .addGap(32, 32, 32)
                                                                .addGap(18, 18, 18)
                                                                .addContainerGap(30, Short.MAX_VALUE)));

                pack();
        }

        private void addEventListeners() {
                btnAddBook.addActionListener(this::addBooks);
                btnReturn.addActionListener(this::returnPage);
        }

        private void returnPage(ActionEvent evt) {
                dispose();
                new Homepage().setVisible(true);
        }

        private void addBooks(ActionEvent evt) {
                try {
                        String title = txTitle.getText();
                        String author = txAuthor.getText();
                        int yearOfPublication = Integer.parseInt(txYearOfPublication.getText());
                        int ISBN = Integer.parseInt(txISBN.getText());
                        String publisher = txPublisher.getText();

                        if (update) {
                                updateBook.setAuthor(author);
                                updateBook.setISBN(ISBN);
                                updateBook.setPublisher(publisher);
                                updateBook.setTitle(title);
                                updateBook.setYearOfPublication(yearOfPublication);
                                LibreriaArancione.updateBook(updateBook);
                        } else {
                                LibreriaArancione.addBook(title, author, ISBN, yearOfPublication,
                                                publisher);
                        }
                        this.dispose();
                        new Homepage().setVisible(true);
                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "ERROR: ISBN and Year of Publication must be numbers");
                }

                catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR: All Fields Required");
                }
        }

}
