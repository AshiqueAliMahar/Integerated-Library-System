package Frames;

import BALClasses.DayBAL;
import BALClasses.LibrarianBAL;
import BALClasses.StudentTeacherBAL;
import BeanClasses.Day;
import BeanClasses.Librarian;
import BeanClasses.StudentTeacher;
import Frames.AdminLibrarian.AdminLibForm;
import Frames.AdminLibrarian.AdminLibLogin;
import Frames.AdminLibrarian.admin.AdminDashboard;
import Frames.frame_size.FrameSize;
import Frames.studentEmployee.EmployeeStudentForm;
import Frames.studentEmployee.StudentLogin;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class WelcomeForm extends javax.swing.JFrame {

    public WelcomeForm(Map<String, Integer> locationSize) {
        initComponents();
        loadTbl();
        this.setSize(locationSize.get("sizex"), locationSize.get("sizeY"));
        this.setLocation(locationSize.get("locx"), locationSize.get("locy"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBooks = new javax.swing.JLabel();
        lblAdminLibrarian = new javax.swing.JLabel();
        lblStudents = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDays = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(250, 50));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MAIN PORTAL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("American Typewriter", 0, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 0, 51));

        lblBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/books.png"))); // NOI18N
        lblBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBooksMouseClicked(evt);
            }
        });

        lblAdminLibrarian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/administrator.png"))); // NOI18N
        lblAdminLibrarian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdminLibrarianMouseClicked(evt);
            }
        });

        lblStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/student.jpg"))); // NOI18N
        lblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStudentsMouseClicked(evt);
            }
        });
        lblStudents.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblStudentsKeyPressed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 0));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Library Timing", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 0, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        tblDays.setBorder(null);
        tblDays.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        tblDays.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "Time"
            }
        ));
        tblDays.setShowGrid(true);
        jScrollPane1.setViewportView(tblDays);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdminLibrarian, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
            .addComponent(lblStudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblAdminLibrarian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("American Typewriter", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(111, 178, 70));
        jLabel4.setText("WELCOME TO MUET LIBRARY");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBooksMouseClicked
        BooksForm booksForm = new BooksForm(FrameSize.getSizeLocation(this));
        booksForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblBooksMouseClicked

    private void lblStudentsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblStudentsKeyPressed

    }//GEN-LAST:event_lblStudentsKeyPressed

    private void lblStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStudentsMouseClicked
        File file = new File("lES.txt");

        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(WelcomeForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {

            String id = bufferedReader.readLine();
            if (id != null && id.length() > 0) {
                StudentTeacherBAL stbal = new StudentTeacherBAL();
                StudentTeacher studentTeacher = stbal.getStudentTeacher(id);
                EmployeeStudentForm employeeStudentForm = new EmployeeStudentForm(id, FrameSize.getSizeLocation(this));
                employeeStudentForm.setVisible(true);
            } else {
                StudentLogin studentLogin = new StudentLogin();
                studentLogin.setVisible(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(WelcomeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_lblStudentsMouseClicked

    private void lblAdminLibrarianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminLibrarianMouseClicked
        BufferedReader bufferedReader = null;
        try {
            File file = new File("loginAL.txt");
            file.createNewFile();
            bufferedReader = new BufferedReader(new FileReader(file));
            String id = bufferedReader.readLine();
            
            if (id != null && id.length() > 0) {
                Librarian librarian = new LibrarianBAL().getLibrarian(id);
                
                if (librarian.getLibType().equals(Librarian.LibrarianRoles.Admin.toString())) {
                    AdminDashboard adminDashboard = new AdminDashboard(librarian, FrameSize.getSizeLocation(this));
                    adminDashboard.setVisible(Boolean.TRUE);
                } else if (librarian.getLibType().equals(Librarian.LibrarianRoles.Librarian.toString())) {
                    AdminLibForm adminLibForm = new AdminLibForm(librarian, FrameSize.getSizeLocation(this));
                    adminLibForm.setVisible(true);
                }

            } else {
                
                AdminLibLogin adminLibLogin = new AdminLibLogin();
                adminLibLogin.setVisible(true);
                
            }
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeForm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(WelcomeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lblAdminLibrarianMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

    }//GEN-LAST:event_formMousePressed

    private void loadTbl() {
        DefaultTableModel dtm = (DefaultTableModel) tblDays.getModel();
        dtm.setRowCount(0);
        List<Day> days = DayBAL.getDays();
        for (Day day : days) {
            Object[] ob = {day.getDayName(), day.getTime()};
            dtm.addRow(ob);
        }
        tblDays.setModel(dtm);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdminLibrarian;
    private javax.swing.JLabel lblBooks;
    private javax.swing.JLabel lblStudents;
    private javax.swing.JTable tblDays;
    // End of variables declaration//GEN-END:variables
}
