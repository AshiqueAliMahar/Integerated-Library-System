package Frames.AdminLibrarian;

import BALClasses.LoginMaintanceBAL;
import Frames.AdminLibrarian.reports.Reports;
import BeanClasses.Librarian;
import Frames.WelcomeForm;
import Frames.frame_size.FrameSize;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminLibForm extends javax.swing.JFrame {

    String idString = "";

    public AdminLibForm(Librarian librarian, Map<String, Integer> locationSize) {
        initComponents();
        idString = librarian.getLibId();
        lblLoginAs.setText(lblLoginAs.getText() + idString);
        lblLibType.setText(lblLibType.getText() + librarian.getLibType());
        openAdminLibBooks();
        LoginMaintanceBAL.logIn(idString);
        this.setSize(locationSize.get("sizex"), locationSize.get("sizeY"));
        this.setLocation(locationSize.get("locx"), locationSize.get("locy"));
    }

    private void openAdminLibBooks() {
        AdminLibBook adminLibBook = new AdminLibBook();

        if (dp.isAncestorOf(adminLibBook)) {
            adminLibBook.setVisible(true);
        } else {
            dp.add(adminLibBook);
            adminLibBook.setVisible(true);
        }
        try {
            adminLibBook.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AdminLibForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnBooks = new javax.swing.JButton();
        btnStdEmp = new javax.swing.JButton();
        btnMyAccount = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        lblLoginAs = new javax.swing.JLabel();
        btnReturnBook = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        lblLibType = new javax.swing.JLabel();
        btnStdEmp1 = new javax.swing.JButton();
        btnStdEmp2 = new javax.swing.JButton();
        btnStdEmp3 = new javax.swing.JButton();
        btnPolicies = new javax.swing.JButton();
        dp = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(250, 50));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(236, 236, 236));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        btnBooks.setBackground(new java.awt.Color(0, 102, 153));
        btnBooks.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnBooks.setForeground(new java.awt.Color(255, 255, 255));
        btnBooks.setText("BOOKS");
        btnBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBooksActionPerformed(evt);
            }
        });

        btnStdEmp.setBackground(new java.awt.Color(0, 102, 153));
        btnStdEmp.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnStdEmp.setForeground(new java.awt.Color(255, 255, 255));
        btnStdEmp.setText("ADD EMPLOYEE/STUDENT");
        btnStdEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStdEmpActionPerformed(evt);
            }
        });

        btnMyAccount.setBackground(new java.awt.Color(0, 102, 153));
        btnMyAccount.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnMyAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnMyAccount.setText("MY ACCOUNT");
        btnMyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyAccountActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(0, 102, 153));
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(0, 102, 153));
        btnHome.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setText("HOME");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        lblLoginAs.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblLoginAs.setForeground(new java.awt.Color(0, 102, 0));
        lblLoginAs.setText("ID:");

        btnReturnBook.setBackground(new java.awt.Color(0, 102, 153));
        btnReturnBook.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnReturnBook.setForeground(new java.awt.Color(255, 255, 255));
        btnReturnBook.setText("RETURN BOOKS");
        btnReturnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnBookActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 102, 153));
        jButton5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("ISSUE BOOKS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        lblLibType.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblLibType.setForeground(new java.awt.Color(0, 102, 0));
        lblLibType.setText("Logged In as:");

        btnStdEmp1.setBackground(new java.awt.Color(0, 102, 153));
        btnStdEmp1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnStdEmp1.setForeground(new java.awt.Color(255, 255, 255));
        btnStdEmp1.setText("GATE ENTRY");
        btnStdEmp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStdEmp1ActionPerformed(evt);
            }
        });

        btnStdEmp2.setBackground(new java.awt.Color(0, 102, 153));
        btnStdEmp2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnStdEmp2.setForeground(new java.awt.Color(255, 255, 255));
        btnStdEmp2.setText("REPORTS");
        btnStdEmp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStdEmp2ActionPerformed(evt);
            }
        });

        btnStdEmp3.setBackground(new java.awt.Color(0, 102, 153));
        btnStdEmp3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnStdEmp3.setForeground(new java.awt.Color(255, 255, 255));
        btnStdEmp3.setText("TIMING");
        btnStdEmp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStdEmp3ActionPerformed(evt);
            }
        });

        btnPolicies.setBackground(new java.awt.Color(0, 102, 153));
        btnPolicies.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnPolicies.setForeground(new java.awt.Color(255, 255, 255));
        btnPolicies.setText("POLICIES");
        btnPolicies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPoliciesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPolicies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(btnStdEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMyAccount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLoginAs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReturnBook, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLibType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStdEmp1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStdEmp2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStdEmp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblLoginAs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLibType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReturnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStdEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStdEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStdEmp2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStdEmp3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPolicies, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMyAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dp.setBackground(new java.awt.Color(255, 255, 255));
        dp.setOpaque(false);

        javax.swing.GroupLayout dpLayout = new javax.swing.GroupLayout(dp);
        dp.setLayout(dpLayout);
        dpLayout.setHorizontalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        dpLayout.setVerticalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dp)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBooksActionPerformed
        openAdminLibBooks();
    }//GEN-LAST:event_btnBooksActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        WelcomeForm welcomeForm = new WelcomeForm(FrameSize.getSizeLocation(this));
        welcomeForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    /*
        Issued reserved tab
        IssuedReservedBks stdEmpRsrvdBks = new IssuedReservedBks();
        if (dp.isAncestorOf(stdEmpRsrvdBks)) {
            stdEmpRsrvdBks.setVisible(true);
        } else {
            dp.add(stdEmpRsrvdBks);
            stdEmpRsrvdBks.setVisible(true);
        }
        try {
            stdEmpRsrvdBks.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AdminLibForm.class.getName()).log(Level.SEVERE, null, ex);
        }
     */

    private void btnMyAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyAccountActionPerformed
        AdminLibAccount adminLibAccount = new AdminLibAccount(idString);
        if (dp.isAncestorOf(adminLibAccount)) {
            adminLibAccount.setVisible(true);
        } else {
            dp.add(adminLibAccount);
            adminLibAccount.setVisible(true);
        }
        try {
            adminLibAccount.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AdminLibForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMyAccountActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        WelcomeForm welcomeForm = new WelcomeForm(FrameSize.getSizeLocation(this));
        welcomeForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        AdminLibLogin adminLibLogin = new AdminLibLogin();
        try (FileWriter fileWriter = new FileWriter("loginAL.txt")) {
            //fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setVisible(false);
        adminLibLogin.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        IssueBooks issueBooks = new IssueBooks();
        if (dp.isAncestorOf(issueBooks)) {
            issueBooks.setVisible(true);
        } else {
            dp.add(issueBooks);
            issueBooks.setVisible(true);
        }
        try {
            issueBooks.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AdminLibForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnStdEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStdEmpActionPerformed
        StdEmpCRUD stdEmpCRUD = new StdEmpCRUD();
        if (dp.isAncestorOf(stdEmpCRUD)) {
            stdEmpCRUD.setVisible(true);
        } else {
            dp.add(stdEmpCRUD);
            stdEmpCRUD.setVisible(true);
            try {
                stdEmpCRUD.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(AdminLibForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnStdEmpActionPerformed

    private void btnReturnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnBookActionPerformed
        ReturnBooks returnBooks = new ReturnBooks();
        if (dp.isAncestorOf(returnBooks)) {
            returnBooks.setVisible(true);
        } else {
            dp.add(returnBooks);
            returnBooks.setVisible(true);
            try {
                returnBooks.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(AdminLibForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnReturnBookActionPerformed

    private void btnStdEmp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStdEmp1ActionPerformed
        GateEntry gateEntry = new GateEntry();
        if (dp.isAncestorOf(gateEntry)) {
            gateEntry.setVisible(true);
        } else {
            dp.add(gateEntry);
            gateEntry.setVisible(true);
            try {
                gateEntry.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(AdminLibForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnStdEmp1ActionPerformed

    private void btnStdEmp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStdEmp2ActionPerformed
        Reports reports = new Reports();
        if (!dp.isAncestorOf(reports)) {
            dp.add(reports);
            try {
                reports.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(AdminLibForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        reports.setVisible(true);
    }//GEN-LAST:event_btnStdEmp2ActionPerformed

    private void btnStdEmp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStdEmp3ActionPerformed
        TimingIF tif = new TimingIF();
        if (!dp.isAncestorOf(tif)) {
            dp.add(tif);
            try {
                tif.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(AdminLibForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tif.setVisible(true);
    }//GEN-LAST:event_btnStdEmp3ActionPerformed

    private void btnPoliciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPoliciesActionPerformed
        PoliciesIF tif = new PoliciesIF();
        if (!dp.isAncestorOf(tif)) {
            dp.add(tif);
            try {
                tif.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(AdminLibForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tif.setVisible(true);
    }//GEN-LAST:event_btnPoliciesActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBooks;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMyAccount;
    private javax.swing.JButton btnPolicies;
    private javax.swing.JButton btnReturnBook;
    private javax.swing.JButton btnStdEmp;
    private javax.swing.JButton btnStdEmp1;
    private javax.swing.JButton btnStdEmp2;
    private javax.swing.JButton btnStdEmp3;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLibType;
    private javax.swing.JLabel lblLoginAs;
    // End of variables declaration//GEN-END:variables
}
