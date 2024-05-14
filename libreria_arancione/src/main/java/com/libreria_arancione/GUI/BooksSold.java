
package com.libreria_arancione.GUI;

import com.libreria_arancione.boundary.LibreriaArancione;
import com.libreria_arancione.entity.BookTransaction;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author utentepc
 */
public class BooksSold extends javax.swing.JDialog {

    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jTitle;
    private javax.swing.JList<String> jListofBooks;
    private javax.swing.JScrollPane jScrollPane;

    public BooksSold() {
        initComponents();
        updateList();
        addEventListeners();
    }

    private void addEventListeners() {
        btnReturn.addActionListener(this::btnReturnActionPerformed);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        this.getContentPane().setBackground(new java.awt.Color(173, 216, 230)); // Light Blue

        jTitle = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jListofBooks = new javax.swing.JList<>();

        btnReturn.setBackground(new java.awt.Color(255, 165, 0)); // Orange

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        int booksSold = LibreriaArancione.TotalBooksSold();
        int totalCash = LibreriaArancione.TotalCash();

        jTitle.setText("ARANCIONE - BOOKS SOLD: " + booksSold + " ---- TOTAL CASH: " + totalCash);

        btnReturn.setText("return");

        jScrollPane.setViewportView(jListofBooks);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 374, Short.MAX_VALUE)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 472,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 91,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 314,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(345, 345, 345)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(166, 166, 166)
                                                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 362,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(172, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new Homepage().setVisible(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BooksSold dialog = new BooksSold();
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

    private void updateList() {

        List<BookTransaction> booksTransaction = LibreriaArancione.booksTransactionList();
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (BookTransaction bt : booksTransaction) {
            listModel.addElement(bt.toString());
        }

        jListofBooks.setModel(listModel);
    }
}
