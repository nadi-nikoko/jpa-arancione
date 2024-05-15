
package com.libreria_arancione.GUI;

import com.libreria_arancione.boundary.LibreriaArancione;
import com.libreria_arancione.entity.BookShop;
import com.libreria_arancione.entity.Student;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author utentepc
 */
public class Homepage extends javax.swing.JDialog {

        private javax.swing.JButton btnAddBook;
        private javax.swing.JButton btnAddStudent;
        private javax.swing.JButton btnDeleteBook;
        private javax.swing.JButton btnDeleteStudent;
        private javax.swing.JButton btnUpdateBook;
        private javax.swing.JButton btnUpdateStudent;
        private javax.swing.JButton jBooksSold;
        private javax.swing.JButton jBtnSearchBook;
        private javax.swing.JButton jBtnSearchStudent;
        private javax.swing.JLabel jSearchBook;
        private javax.swing.JLabel jSearchStudent;
        private javax.swing.JLabel jPrice;
        private javax.swing.JList<String> jListBooks;
        private javax.swing.JList<String> jListStudents;
        private javax.swing.JButton btnPurchase;
        private javax.swing.JScrollPane jScrollPane4;
        private javax.swing.JScrollPane jScrollPane5;
        private javax.swing.JTextField txBook;
        private javax.swing.JTextField txPrice;
        private javax.swing.JTextField txStudent;

        String bookSelected;
        String studentSelected;

        public Homepage() {
                initComponents();
                addEventListeners();
        }

        public void addEventListeners() {
                btnPurchase.addActionListener(this::onPurchase);
                btnDeleteBook.addActionListener(this::btnDeleteBookActionPerformed);
                btnDeleteStudent.addActionListener(this::btnDeleteStudentActionPerformed);
                btnAddStudent.addActionListener(this::btnAddStudentActionPerformed);
                btnAddBook.addActionListener(this::btnAddBookActionPerformed);
                jBtnSearchBook.addActionListener(this::jBtnSearchBookActionPerformed);
                jBtnSearchStudent.addActionListener(this::jBtnSearchStudentActionPerformed);
                btnUpdateBook.addActionListener(this::btnUpdateBookActionPerformed);
                btnUpdateStudent.addActionListener(this::btnUpdateStudentActionPerformed);
                jBooksSold.addActionListener(this::jBooksSoldActionPerformed);
        }

        @SuppressWarnings("unchecked")
        private void initComponents() {

                this.getContentPane().setBackground(new java.awt.Color(173, 216, 230)); // Light Blue

                jSearchBook = new javax.swing.JLabel();
                jSearchStudent = new javax.swing.JLabel();
                jPrice = new javax.swing.JLabel();
                txStudent = new javax.swing.JTextField();
                txPrice = new javax.swing.JTextField();
                txBook = new javax.swing.JTextField();
                btnPurchase = new javax.swing.JButton();
                btnDeleteBook = new javax.swing.JButton();
                btnDeleteStudent = new javax.swing.JButton();
                btnAddStudent = new javax.swing.JButton();
                btnAddBook = new javax.swing.JButton();
                jBtnSearchBook = new javax.swing.JButton();
                jScrollPane4 = new javax.swing.JScrollPane();
                jListStudents = new javax.swing.JList<>();
                jBtnSearchStudent = new javax.swing.JButton();
                btnUpdateBook = new javax.swing.JButton();
                btnUpdateStudent = new javax.swing.JButton();
                jScrollPane5 = new javax.swing.JScrollPane();
                jListBooks = new javax.swing.JList<>();
                jBooksSold = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jSearchBook.setText("SEARCH BOOK");
                jSearchStudent.setText("SEARCH STUDENT");
                jPrice.setText("PRICE");
                btnPurchase.setText("PURCHASE");
                btnDeleteBook.setText("DELETE");
                btnDeleteStudent.setText("DELETE");
                btnAddStudent.setText("ADD");
                jBtnSearchBook.setText("SEARCH");
                btnAddBook.setText("ADD");
                jScrollPane4.setViewportView(jListStudents);
                jBtnSearchStudent.setText("SEARCH");
                btnUpdateBook.setText("UPDATE");
                btnUpdateStudent.setText("UPDATE");
                jScrollPane5.setViewportView(jListBooks);
                jBooksSold.setText("BOOKS SOLD");

                // Set text and background colors
                jPrice.setForeground(new java.awt.Color(0, 0, 255));
                btnPurchase.setBackground(new java.awt.Color(255, 165, 0));
                btnDeleteBook.setBackground(new java.awt.Color(255, 165, 0));
                btnDeleteStudent.setBackground(new java.awt.Color(255, 165, 0));
                btnAddStudent.setBackground(new java.awt.Color(255, 165, 0));
                btnAddBook.setBackground(new java.awt.Color(255, 165, 0));
                jBtnSearchBook.setBackground(new java.awt.Color(255, 165, 0));
                jBtnSearchStudent.setBackground(new java.awt.Color(255, 165, 0));
                btnUpdateBook.setBackground(new java.awt.Color(255, 165, 0));
                btnUpdateStudent.setBackground(new java.awt.Color(255, 165, 0));
                jBooksSold.setBackground(new java.awt.Color(255, 165, 0));

                jPrice.setFont(new java.awt.Font("Courier New", 1, 24));
                txStudent.setFont(new java.awt.Font("Courier New", 0, 14));
                txPrice.setFont(new java.awt.Font("Courier New", 0, 14));
                txBook.setFont(new java.awt.Font("Courier New", 0, 14));
                btnPurchase.setFont(new java.awt.Font("Courier New", 1, 16));
                btnDeleteBook.setFont(new java.awt.Font("Courier New", 1, 16));
                btnDeleteStudent.setFont(new java.awt.Font("Courier New", 1, 16));
                btnAddStudent.setFont(new java.awt.Font("Courier New", 1, 16));
                btnAddBook.setFont(new java.awt.Font("Courier New", 1, 16));
                jBtnSearchBook.setFont(new java.awt.Font("Courier New", 1, 16));
                jBtnSearchStudent.setFont(new java.awt.Font("Courier New", 1, 16));
                btnUpdateBook.setFont(new java.awt.Font("Courier New", 1, 16));
                btnUpdateStudent.setFont(new java.awt.Font("Courier New", 1, 16));
                jBooksSold.setFont(new java.awt.Font("Courier New", 1, 16));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(36, 36, 36)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(22, 22, 22)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(73, 73, 73)
                                                                                                                                .addComponent(jSearchBook,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                200,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(462, 462,
                                                                                                                                                462)
                                                                                                                                .addComponent(jSearchStudent)
                                                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(69, 69, 69)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(btnAddBook,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                130,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(btnDeleteBook,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                130,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(btnUpdateBook,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                130,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addGap(387, 387,
                                                                                                                                                387)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(btnDeleteStudent,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                130,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(btnUpdateStudent,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                130,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(btnAddStudent,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                130,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addContainerGap(
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE))))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(txBook,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                249,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addGap(79, 79, 79)
                                                                                                                                                                .addComponent(jPrice)
                                                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                                                .addComponent(txPrice,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                139,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                                                .addComponent(jBtnSearchBook)))
                                                                                                                                .addGap(34, 34, 34)
                                                                                                                                .addComponent(txStudent,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                275,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(jBtnSearchStudent))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(347, 347,
                                                                                                                                                347)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addGap(9, 9, 9)
                                                                                                                                                                .addComponent(btnPurchase,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                180,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addGap(37, 37, 37)
                                                                                                                                                                .addComponent(jScrollPane4,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                249,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                .addComponent(jBooksSold,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                180,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                                .addContainerGap(1131,
                                                                                                                Short.MAX_VALUE))))
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                                .addGap(46, 46, 46)
                                                                                .addComponent(jScrollPane5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                282,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addContainerGap(1749,
                                                                                                Short.MAX_VALUE))));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(33, 33, 33)
                                                                                                                                .addComponent(jSearchStudent))
                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                layout.createSequentialGroup()
                                                                                                                                                .addContainerGap()
                                                                                                                                                .addComponent(jSearchBook)))
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                                .addComponent(txBook,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                48,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(jBtnSearchBook)))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(12, 12, 12)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                                .addComponent(txStudent,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                48,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(jBtnSearchStudent))))
                                                                                                .addGap(27, 27, 27)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(jScrollPane4,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                                .addComponent(jPrice)
                                                                                                                                                .addComponent(txPrice,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                44,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addGap(36, 36, 36)
                                                                                                                                .addComponent(btnPurchase,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                38,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                68,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(btnAddBook,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                32,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(btnUpdateBook,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                32,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(btnDeleteBook,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                32,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(22, 22, 22))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                .addComponent(btnAddStudent,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                32,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(btnUpdateStudent,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                32,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(27, 27, 27)
                                                                                                                .addComponent(btnDeleteStudent,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                32,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(47, 47, 47)))
                                                                .addComponent(jBooksSold,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 101, Short.MAX_VALUE))
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                                .addGap(146, 146, 146)
                                                                                .addComponent(jScrollPane5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addContainerGap(351,
                                                                                                Short.MAX_VALUE))));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void onPurchase(java.awt.event.ActionEvent evt) {

                try {
                        int price = Integer.parseInt(txPrice.getText());
                        bookSelected = jListBooks.getSelectedValue();
                        studentSelected = jListStudents.getSelectedValue();

                        if (studentSelected != null && bookSelected != null) {
                                String[] parts = studentSelected.split(" - ");
                                int id = Integer.parseInt(parts[0]);
                                Student studentById = LibreriaArancione.findStudentById(id);

                                String[] partsBook = bookSelected.split(" - ");
                                int idBook = Integer.parseInt(partsBook[0]);
                                BookShop bookById = LibreriaArancione.findBookById(idBook);

                                LibreriaArancione.Purchase(bookById, studentById, price);

                                dispose();
                                JOptionPane.showMessageDialog(null, "BOOK SOLD");
                                new Homepage().setVisible(true);
                        } else {
                                JOptionPane.showMessageDialog(null, "Select a student and a book");
                        }

                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Price Field needs to be a number and cannot be empty");
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR: All Fields Required");

                }

        }

        private void btnAddStudentActionPerformed(java.awt.event.ActionEvent evt) {
                this.dispose();
                new AddStudent().setVisible(true);
        }

        private void jBtnSearchBookActionPerformed(java.awt.event.ActionEvent evt) {

                DefaultListModel<String> listModel = new DefaultListModel();
                String book = txBook.getText();

                List<BookShop> bookByTitle = LibreriaArancione.findBookByTitleOrAuthor(book);

                for (BookShop bk : bookByTitle) {
                        listModel.addElement(bk.getId() + " - " + bk.getTitle() + " by: " + bk.getAuthor());
                }

                jListBooks.setModel(listModel);
        }

        private void jBtnSearchStudentActionPerformed(java.awt.event.ActionEvent evt) {

                DefaultListModel<String> listStudentModel = new DefaultListModel();
                String student = txStudent.getText();

                List<Student> findStudentByName = LibreriaArancione.findStudentsByNameOrSurname(student);
                for (Student std : findStudentByName) {
                        listStudentModel.addElement(std.getId() + " - " + std.getName() + " " + std.getSurname());
                }

                jListStudents.setModel(listStudentModel);

        }

        private void btnDeleteBookActionPerformed(java.awt.event.ActionEvent evt) {

                bookSelected = jListBooks.getSelectedValue();
                if (bookSelected != null) {
                        String[] parts = bookSelected.split(" - ");
                        int id = Integer.parseInt(parts[0]);
                        LibreriaArancione.deleteBook(id);
                        jBtnSearchBookActionPerformed(evt);
                } else
                        JOptionPane.showMessageDialog(null, "Select a Book");

        }

        private void btnUpdateBookActionPerformed(java.awt.event.ActionEvent evt) {

                bookSelected = jListBooks.getSelectedValue();
                if (bookSelected != null) {
                        String[] parts = bookSelected.split(" - ");
                        int id = Integer.parseInt(parts[0]);
                        BookShop book = LibreriaArancione.findBookById(id);
                        dispose();
                        new AddBook(id).setVisible(true);
                } else
                        JOptionPane.showMessageDialog(null, "Select a Book");

        }

        private void btnAddBookActionPerformed(java.awt.event.ActionEvent evt) {
                this.dispose();
                new AddBook().setVisible(true);

        }

        private void btnDeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {
                studentSelected = jListStudents.getSelectedValue();
                if (studentSelected != null) {
                        String[] parts = studentSelected.split(" - ");
                        int id = Integer.parseInt(parts[0]);
                        LibreriaArancione.deleteStudent(id);
                        jBtnSearchStudentActionPerformed(evt);
                } else
                        JOptionPane.showMessageDialog(null, "Select a Student");
        }

        private void jBooksSoldActionPerformed(java.awt.event.ActionEvent evt) {
                if (LibreriaArancione.TotalBooksSold() > 0) {
                        this.dispose();
                        new BooksSold().setVisible(true);
                } else
                        JOptionPane.showMessageDialog(null, "There is NO book Transactions");
        }

        private void btnUpdateStudentActionPerformed(java.awt.event.ActionEvent evt) {

                studentSelected = jListStudents.getSelectedValue();
                if (studentSelected != null) {
                        String[] parts = studentSelected.split(" - ");
                        int id = Integer.parseInt(parts[0]);
                        Student student = LibreriaArancione.findStudentById(id);
                        dispose();
                        new AddStudent(id).setVisible(true);
                } else
                        JOptionPane.showMessageDialog(null, "Select a Student");
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {

                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                Homepage dialog = new Homepage();
                                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                                        @Override
                                        public void windowClosing(java.awt.event.WindowEvent e) {
                                                System.exit(0);
                                        }
                                });
                                dialog.setVisible(true);
                        }
                });
        }

}
