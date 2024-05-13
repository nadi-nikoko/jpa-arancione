/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.libreria_arancione;

import com.libreria_arancione.boundary.LibreriaArancione;
import com.libreria_arancione.control.Store;
import com.libreria_arancione.entity.CoverType;
import com.libreria_arancione.entity.Library;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

/**
 *
 * @author utentepc
 */
public class WindowGuiAddBook extends javax.swing.JDialog {

        private boolean update;
        private Library updateBook;

        public WindowGuiAddBook() {
                this.update = false;
                initComponents();
                addEventListeners();
        }

        public WindowGuiAddBook(int id) {
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

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                txAuthor = new javax.swing.JTextField();
                txYearOfPublication = new javax.swing.JTextField();
                txISBN = new javax.swing.JTextField();
                txPublisher = new javax.swing.JTextField();
                txTitle = new javax.swing.JTextField();
                jScrollPane1 = new javax.swing.JScrollPane();
                jShowCustomer = new javax.swing.JTextPane();
                btnAddStudent = new javax.swing.JButton();
                btnReturn = new javax.swing.JButton();
                jLabel6 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jLabel1.setText("Title");

                jLabel2.setText("Author");

                jLabel3.setText("Year Of Publication");

                jLabel4.setText("ISBN");

                jLabel5.setText("Publisher");

                jShowCustomer.setEditable(false);
                jScrollPane1.setViewportView(jShowCustomer);

                btnAddStudent.setText("click");
                btnReturn.setText("return");

                jLabel6.setText("Cover");

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
                                                                                                                .addComponent(jLabel4)
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addComponent(jLabel2)
                                                                                                                                .addComponent(jLabel1))
                                                                                                                .addComponent(jLabel5))
                                                                                                .addGap(40, 40, 40))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addContainerGap()
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addComponent(jLabel6)
                                                                                                                                .addComponent(jLabel3))
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
                                                                                                .addComponent(btnAddStudent)
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
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                557,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                                                                .addComponent(jLabel1))
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
                                                                                                                .addComponent(jLabel2)))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(53, 53, 53)
                                                                                                .addComponent(btnAddStudent)
                                                                                                .addComponent(btnReturn)))
                                                                .addGap(9, 9, 9)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(txYearOfPublication,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel3))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(txISBN,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel4))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(txPublisher,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel5))
                                                                .addGap(32, 32, 32)
                                                                .addComponent(jLabel6)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                121,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(30, Short.MAX_VALUE)));

                pack();
        }

        private void addEventListeners() {
                btnAddStudent.addActionListener(this::addBooks);
                btnReturn.addActionListener(this::returnPage);
        }

        private void returnPage(ActionEvent evt) {
                dispose();
                new WindowGuiSellingBook().setVisible(true);
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
                                LibreriaArancione.saveBook(title, author, ISBN, yearOfPublication, CoverType.HARDCOVER,
                                                publisher);
                        }
                        this.dispose();
                        new WindowGuiSellingBook().setVisible(true);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR: All Fields Required");
                }
        }

        /**
         * @param args the command line arguments
         */

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnAddStudent;
        private javax.swing.JButton btnReturn;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextPane jShowCustomer;
        private javax.swing.JTextField txAuthor;
        private javax.swing.JTextField txISBN;
        private javax.swing.JTextField txPublisher;
        private javax.swing.JTextField txTitle;
        private javax.swing.JTextField txYearOfPublication;
        // End of variables declaration//GEN-END:variables
}
