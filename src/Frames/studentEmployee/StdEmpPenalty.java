package Frames.studentEmployee;

import BALClasses.AccountsBAL;
import BALClasses.BookissueDetailBAL;
import BALClasses.BooksBAL;
import BALClasses.GeneralBAL;
import BALClasses.PenaltyBAL;
import BALClasses.PolicyBAL;
import BALClasses.StudentTeacherBAL;
import BeanClasses.Accounts;
import BeanClasses.BookIssueDetail;
import BeanClasses.Books;
import BeanClasses.PenaltyBean;
import BeanClasses.Policy;
import BeanClasses.StudentTeacher;
import ConnectionOfMySql.MySQLConnection;
import Frames.AdminLibrarian.ReturnBooks;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class StdEmpPenalty extends javax.swing.JInternalFrame {

    GeneralBAL generalBAL = new GeneralBAL();
    BookissueDetailBAL bookissueDetailBAL = new BookissueDetailBAL();
    MySQLConnection msqlc = new MySQLConnection();
    AccountsBAL accountsBAL = new AccountsBAL();
    Accounts accounts = new Accounts();
    PenaltyBAL penaltyBAL = new PenaltyBAL();
    BooksBAL booksBAL = new BooksBAL();
    Books books = new Books();
    String id;
    StudentTeacherBAL studentTeacherBAL = new StudentTeacherBAL();

    public StdEmpPenalty(String id) {
        initComponents();
        this.id = id;
        loadTable("issued", tblPenalty, "penalty");
        lblAccNo.setText(lblAccNo.getText() + accountsBAL.getAccount("727902593207").getAccountNumber());
    }

    private void loadTable(String statusString, JTable jTable, String tblName) {

        ArrayList<BookIssueDetail> booksDetailBAL = bookissueDetailBAL.getBooksDetail(statusString);
        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        dtm.setRowCount(0);

        for (BookIssueDetail bookIssueDetail : booksDetailBAL) {

            long days = generalBAL.getIssueToNowDays(bookIssueDetail.getBookIssueDate());
            books = booksBAL.getBooks(String.valueOf(bookIssueDetail.getBookNo()));
            int issueLimit = books.getBookIssueLimit();
            long totalAmount = (days - issueLimit) * Integer.valueOf(PolicyBAL.getValue(Policy.policies.PENALTY_PER_DAY.toString()).getPolicyVal());

            int paidAmount = penaltyBAL.getPAmount(String.valueOf(bookIssueDetail.getBookNo()), bookIssueDetail.getIdString()).getAmount();
            long remainingAmount = totalAmount - paidAmount;

            if (days > issueLimit) {

                if (bookIssueDetail.getIdString().equals(id)) {

                    Vector v = new Vector();
                    v.add(bookIssueDetail.getIdString());
                    v.add(bookIssueDetail.getBookNo());
                    v.add(bookIssueDetail.getBookIssueDate());
                    v.add(days);
                    v.add(days - issueLimit);
                    v.add(totalAmount);
                    v.add(paidAmount);
                    if (((days - issueLimit) - paidAmount) > 0) {
                        v.add(remainingAmount);
                    } else {
                        v.add(0);
                    }
                    dtm.addRow(v);
                }
            }
        }
        jTable.setModel(dtm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPenalty = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBookNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        spnAmount = new javax.swing.JSpinner();
        btnBankPay = new javax.swing.JButton();
        txtAccNo = new javax.swing.JTextField();
        pwdAccNo = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblAccNo = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(236, 236, 236));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Penalty Books", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        tblPenalty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Number", "Issue Date", "Total Days", "Penalty Days", "Total Amount(PKR)", "Paid", "Remaining"
            }
        ));
        tblPenalty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPenaltyMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPenalty);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(236, 236, 236));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel1.setText("Id");

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel2.setText("Book Number");

        txtBookNumber.setEditable(false);
        txtBookNumber.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("Amount");

        btnBankPay.setBackground(new java.awt.Color(0, 102, 153));
        btnBankPay.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnBankPay.setForeground(new java.awt.Color(255, 255, 255));
        btnBankPay.setText("Bank Pay");
        btnBankPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBankPayActionPerformed(evt);
            }
        });

        txtAccNo.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        pwdAccNo.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("Acc.No");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setText("Password");

        jButton2.setBackground(new java.awt.Color(0, 102, 153));
        jButton2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Print Challan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblAccNo.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        lblAccNo.setText("Acc No.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblAccNo, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBookNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAccNo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pwdAccNo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBankPay))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblAccNo)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAccNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(spnAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBookNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwdAccNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnBankPay))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tblPenaltyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPenaltyMouseClicked
        int selectedRow = tblPenalty.getSelectedRow();
        if (selectedRow >= 0) {
            txtId.setText(tblPenalty.getValueAt(selectedRow, 0).toString());
            txtBookNumber.setText(tblPenalty.getValueAt(selectedRow, 1).toString());
            spnAmount.setValue(Integer.parseInt(tblPenalty.getValueAt(selectedRow, 7).toString()));
        }
    }//GEN-LAST:event_tblPenaltyMouseClicked

    private void btnBankPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBankPayActionPerformed

        Accounts accountAvail = accountsBAL.getAccount(txtAccNo.getText());

        try {
            if (accountAvail.getAccountNumber().equals(txtAccNo.getText()) && accountAvail.getAccountPassword().equals(pwdAccNo.getText())) {
                if (Integer.parseInt(spnAmount.getValue().toString()) > 0) {

                    if (accountAvail.getAccountAmount() > Integer.parseInt(spnAmount.getValue().toString())) {
                        accountsBAL.payAmount(accountAvail, "727902593207", Integer.parseInt(spnAmount.getValue().toString()));
                        PenaltyBean penaltyBean = new PenaltyBean();
                        penaltyBean.setAmount(Integer.parseInt(spnAmount.getValue().toString()));
                        penaltyBean.setBkNumber(Integer.parseInt(txtBookNumber.getText()));
                        penaltyBean.setId(txtId.getText());
                        penaltyBAL.setPenalty(penaltyBean);
                        loadTable("issued", tblPenalty, "penalty");
                        clear();

                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient Amount");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Enter Positive Amount");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password Incorrect");
            }
        } catch (NullPointerException ex) {

            JOptionPane.showMessageDialog(null, "Account Is Not Available");
        }
    }//GEN-LAST:event_btnBankPayActionPerformed
    private void clear() {
        txtAccNo.setText("");
        txtBookNumber.setText("");
        txtId.setText("");
        pwdAccNo.setText("");
        spnAmount.setValue(0);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            //String reportString = "ChallanMuet.jrxml";
            //InputStream is=this.getClass().getResourceAsStream(reportString);

            StudentTeacher st = studentTeacherBAL.getStudentTeacher(id);
            if (txtBookNumber.getText().length()>0) {
                
            
            if (Integer.valueOf(spnAmount.getValue().toString()) > 0) {
                
                Map<String, Object> challanP = new HashMap<>();
                challanP.put("name", st.getNameString());
                challanP.put("rollNo", id);
                challanP.put("amount", spnAmount.getValue().toString());

                JasperReport compileReport = JasperCompileManager.compileReport("ChallanMuet.jrxml");
                JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, challanP, msqlc.getCon());
                JasperViewer.viewReport(jasperPrint, false);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Can't Print Challan when penality is 0");
            }
            }else{
                JOptionPane.showMessageDialog(rootPane, "FIRST SELECT BOOK");
            }
        } catch (JRException ex) {
            Logger.getLogger(ReturnBooks.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBankPay;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAccNo;
    private javax.swing.JPasswordField pwdAccNo;
    private javax.swing.JSpinner spnAmount;
    private javax.swing.JTable tblPenalty;
    private javax.swing.JTextField txtAccNo;
    private javax.swing.JTextField txtBookNumber;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
