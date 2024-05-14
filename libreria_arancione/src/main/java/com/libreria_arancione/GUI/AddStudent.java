package com.libreria_arancione.GUI;

import com.libreria_arancione.boundary.LibreriaArancione;
import com.libreria_arancione.control.Store;
import com.libreria_arancione.entity.Student;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

/**
 *
 * @author utentepc
 */
public class AddStudent extends javax.swing.JDialog {

        private javax.swing.JButton btnAddStudent;
        private javax.swing.JButton btnReturn;
        private javax.swing.JLabel jName;
        private javax.swing.JLabel jSurname;
        private javax.swing.JLabel jPhone;
        private javax.swing.JLabel jEmail;
        private javax.swing.JLabel jSchoolYear;
        private javax.swing.JTextField txEmail;
        private javax.swing.JTextField txName;
        private javax.swing.JTextField txPhone;
        private javax.swing.JTextField txSchoolYear;
        private javax.swing.JTextField txSurname;
        private boolean update;
        private Student updateStudent;

        public AddStudent() {
                this.update = false;
                initComponents();
                addEventListeners();
        }

        public AddStudent(int id) {
                this.update = true;
                updateStudent = LibreriaArancione.findStudentById(id);
                System.out.println(updateStudent);
                initComponents();
                txName.setText(updateStudent.getName());
                txSurname.setText(updateStudent.getSurname());
                txEmail.setText(updateStudent.getEmail());
                txPhone.setText(updateStudent.getPhone());
                txSchoolYear.setText(updateStudent.getPhone());
                addEventListeners();

        }

        @SuppressWarnings("unchecked")
        private void initComponents() {

                this.getContentPane().setBackground(new java.awt.Color(173, 216, 230)); // Light Blue

                jName = new javax.swing.JLabel();
                jSurname = new javax.swing.JLabel();
                jPhone = new javax.swing.JLabel();
                jEmail = new javax.swing.JLabel();
                jSchoolYear = new javax.swing.JLabel();
                txSurname = new javax.swing.JTextField();
                txPhone = new javax.swing.JTextField();
                txEmail = new javax.swing.JTextField();
                txSchoolYear = new javax.swing.JTextField();
                txName = new javax.swing.JTextField();
                btnAddStudent = new javax.swing.JButton();
                btnReturn = new javax.swing.JButton();

                btnAddStudent.setBackground(new java.awt.Color(255, 165, 0)); // Orange
                btnReturn.setBackground(new java.awt.Color(255, 165, 0)); // Orange

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jName.setText("NAME");
                jSurname.setText("SURNAME");
                jPhone.setText("PHONE");
                jEmail.setText("EMAIL");
                jSchoolYear.setText("SCHOOL YEAR");

                btnAddStudent.setText("SAVE");
                btnReturn.setText("return");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGap(178, 178, 178))
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(297, 297, 297)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jEmail)
                                                                                .addComponent(jPhone)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addComponent(jSurname)
                                                                                                .addComponent(jName))
                                                                                .addComponent(jSchoolYear))
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                33,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(txSurname,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                480,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(txName,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                480,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(txPhone,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                480,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(58, 58, 58)
                                                                                                .addComponent(btnAddStudent)
                                                                                                .addComponent(btnReturn)
                                                                                                .addContainerGap(76,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(31, 31, 31)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(txEmail,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                480,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(txSchoolYear))))));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(49, 49, 49)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(txName,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jName))
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(txSurname,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                48,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jSurname)))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(53, 53, 53)
                                                                                                .addComponent(btnAddStudent)
                                                                                                .addComponent(btnReturn)))
                                                                .addGap(9, 9, 9)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(txPhone,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jPhone))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(txEmail,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jEmail))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(txSchoolYear,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                48,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jSchoolYear))
                                                                .addGap(66, 66, 66)
                                                                .addContainerGap(30, Short.MAX_VALUE)));

                pack();
        }

        private void addEventListeners() {

                btnAddStudent.addActionListener(this::addStudent);
                btnReturn.addActionListener(this::returnPage);

        }

        private void returnPage(ActionEvent evt) {
                dispose();
                new Homepage().setVisible(true);
        }

        private void addStudent(ActionEvent evt) {

                String name = txName.getText();
                String surname = txSurname.getText();
                String phone = txPhone.getText();
                String email = txEmail.getText();
                String schoolYear = txSchoolYear.getText();
                try {

                        if (name.isEmpty() || surname.isEmpty() || phone.isEmpty() || email.isEmpty()
                                        || schoolYear.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "All fields Required");
                                return;
                        }
                        // checking if txPhone has only numbers on it
                        int phoneConvertion = Integer.parseInt(txPhone.getText());

                        if (!isValidEmail(email)) {
                                JOptionPane.showMessageDialog(null, "Invalid email address");
                                return;
                        }

                        if (update) {
                                updateStudent.setName(name);
                                updateStudent.setSurname(surname);
                                updateStudent.setPhone(phone);
                                updateStudent.setEmail(email);
                                updateStudent.setSchoolYear(schoolYear);
                                LibreriaArancione.updateStudent(updateStudent);
                        } else {
                                LibreriaArancione.addStudent(name, surname, email, phone, schoolYear);
                        }
                        this.dispose();
                        new Homepage().setVisible(true);

                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Phone needs to be a number");

                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "All Fields Required");
                }

        }

        private boolean isValidEmail(String email) {
                String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                Pattern pat = Pattern.compile(emailRegex);
                if (email == null)
                        return false;
                return pat.matcher(email).matches();
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {

                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                AddStudent dialog = new AddStudent();
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
