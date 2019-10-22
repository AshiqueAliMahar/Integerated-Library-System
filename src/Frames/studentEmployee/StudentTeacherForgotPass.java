package Frames.studentEmployee;

import BALClasses.GeneralBAL;
import BALClasses.StudentTeacherBAL;
import emailSending.EmailSend;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class StudentTeacherForgotPass extends javax.swing.JInternalFrame {

    String pinString = "";
    String email = "";
    String password = "";
    String empStudentString = "";
    StudentTeacherBAL studentTeacherBAL = new StudentTeacherBAL();
    GeneralBAL generalBAL = new GeneralBAL();

    public StudentTeacherForgotPass(String email) {
        initComponents();
        pinString = String.valueOf(Math.ceil(Math.random() * 10000));
        this.email=email;
        txtEmail.setText(email);
    }

    private void setTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                lblSearch.setEnabled(true);
            }
        }, 1 * 60 * 1000);
    }

    private void clear() {
        txtConfirmCode.setText("");
        txtEmail.setText("");
        pwdConfirmPasswod.setText("");
        pwdPassword.setText("");
        lblMatched.setIcon(null);
        lblConfirmMatch.setIcon(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtConfirmCode = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        pwdPassword = new javax.swing.JPasswordField();
        pwdConfirmPasswod = new javax.swing.JPasswordField();
        lblMatched = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        lblConfirmMatch = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(236, 236, 236));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forgot Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel1.setText("Email:");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel2.setText("Confirmation Code:");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("New Password:");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("Confirm Password:");

        txtConfirmCode.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtConfirmCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConfirmCodeKeyReleased(evt);
            }
        });

        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        pwdPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        pwdConfirmPasswod.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 12))); // NOI18N
        pwdConfirmPasswod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pwdConfirmPasswodKeyReleased(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        lblSearch.setText("Send Code");
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 102, 153));
        btnUpdate.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pwdConfirmPasswod, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addComponent(txtEmail)
                        .addComponent(txtConfirmCode)
                        .addComponent(pwdPassword)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblConfirmMatch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMatched, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(151, Short.MAX_VALUE))
                    .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMatched, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtConfirmCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pwdConfirmPasswod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(lblConfirmMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked

        boolean isEmailCorrect = false;
        EmailSend emailSend = new EmailSend();
        pinString = String.valueOf((int)(Math.random() * 100000));
        isEmailCorrect = generalBAL.isEmailCorrect(txtEmail.getText());

        if (isEmailCorrect) {
            email = txtEmail.getText();
            if (studentTeacherBAL.isEmail(email)) {
                
                lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/loading.gif")));
                lblSearch.setText("Sending Verification Code");
                JOptionPane.showMessageDialog(rootPane, "Verfication Code Process Started");
                emailSend.sendMail(email, "Confirmation Code", pinString, "Code Sent Successfully ");
                lblSearch.setText("Send Code");
                lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png")));
                setTimer();
            } else {
                JOptionPane.showMessageDialog(null, "This Email Address is not there in Library");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Enter Correct Email");
        }

    }//GEN-LAST:event_lblSearchMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (pwdPassword.getText().equals(pwdConfirmPasswod.getText()) && pinString.equals(txtConfirmCode.getText())) {
            password = pwdPassword.getText();
            boolean isEmailCorrect = false;
            isEmailCorrect = generalBAL.isEmailCorrect(email);
            if (isEmailCorrect) {
                if (studentTeacherBAL.isEmail(email)) {
                    studentTeacherBAL.setPassword(password, email);
                } else {
                    JOptionPane.showMessageDialog(null, "This Email Address is not there in Library");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Enter Correct Email");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password MisMatching/Incorrect Verification code");
        }
        clear();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtConfirmCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmCodeKeyReleased
        if (pinString.equals(txtConfirmCode.getText())) {
            lblMatched.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/correct.png")));
        } else if (txtConfirmCode.getText().length() >= 1) {
            lblMatched.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wrong.png")));
        }else{
            lblMatched.setIcon(null);
        }

    }//GEN-LAST:event_txtConfirmCodeKeyReleased

    private void pwdConfirmPasswodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwdConfirmPasswodKeyReleased
        if (pwdPassword.getText().equals(pwdConfirmPasswod.getText()) && pwdPassword.getText().length()>0) {
            lblConfirmMatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/correct.png")));
        } else if (pwdConfirmPasswod.getText().length() >= 1) {
            lblConfirmMatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wrong.png")));
        }else{
            lblConfirmMatch.setIcon(null);
        }
    }//GEN-LAST:event_pwdConfirmPasswodKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblConfirmMatch;
    private javax.swing.JLabel lblMatched;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JPasswordField pwdConfirmPasswod;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JTextField txtConfirmCode;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
