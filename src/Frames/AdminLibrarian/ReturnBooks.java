package Frames.AdminLibrarian;

import BALClasses.BookissueDetailBAL;
import BALClasses.BooksBAL;
import BALClasses.GeneralBAL;
import BALClasses.PenaltyBAL;
import BALClasses.PolicyBAL;
import BALClasses.StudentTeacherBAL;
import BeanClasses.BookIssueDetail;
import BeanClasses.Books;
import BeanClasses.Policy;
import BeanClasses.StudentTeacher;
import ConnectionOfMySql.MySQLConnection;
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

public class ReturnBooks extends javax.swing.JInternalFrame {

    BookissueDetailBAL bookissueDetailBAL = new BookissueDetailBAL();
    PenaltyBAL penaltyBAL=new PenaltyBAL();
    Books books = new Books();
    BooksBAL booksBAL = new BooksBAL();
    GeneralBAL generalBAL = new GeneralBAL();
    StudentTeacherBAL studentTeacherBAL=new StudentTeacherBAL();
    MySQLConnection msqlc = new MySQLConnection();

    public ReturnBooks() {
        initComponents();
        loadTable("issued", tblPenalty, "penalty");
        loadTable("issued", tblWithoutPenaltyBooks, "");
    }

    private void loadTable(String statusString, JTable jTable, String tblName) {

        ArrayList<BookIssueDetail> booksDetailBAL = bookissueDetailBAL.getBooksDetail(statusString);
        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        dtm.setRowCount(0);

        for (BookIssueDetail bookIssueDetail : booksDetailBAL) {

            Vector v = new Vector();
            long days = generalBAL.getIssueToNowDays(bookIssueDetail.getBookIssueDate());
            books = booksBAL.getBooks(String.valueOf(bookIssueDetail.getBookNo()));

            int issueLimit = books.getBookIssueLimit();
            
            if (days > issueLimit && tblName.equals("penalty") /*&& remainingAmount>0*/) {
                long totalAmount=(days - issueLimit)*Integer.valueOf(PolicyBAL.getValue(Policy.policies.PENALTY_PER_DAY.toString()).getPolicyVal());
                int paidAmount = penaltyBAL.getPAmount(String.valueOf(bookIssueDetail.getBookNo()), bookIssueDetail.getIdString()).getAmount();
                long remainingAmount = totalAmount - paidAmount;
                v.add(bookIssueDetail.getIdString());
                v.add(bookIssueDetail.getBookNo());
                v.add(bookIssueDetail.getBookIssueDate());
                v.add(generalBAL.getIssueToNowDays(bookIssueDetail.getBookIssueDate()));
                v.add(days-issueLimit);
                v.add(totalAmount);
                v.add(paidAmount);
                v.add(remainingAmount);
                
                dtm.addRow(v);
                
            } else if (days <= issueLimit && tblName.equals("")) {
                v.add(bookIssueDetail.getIdString());
                v.add(bookIssueDetail.getBookNo());
                v.add(bookIssueDetail.getBookIssueDate());
                v.add(generalBAL.getIssueToNowDays(bookIssueDetail.getBookIssueDate()));
                dtm.addRow(v);
            }
        }
        jTable.setModel(dtm);
    }

    private void loadTable(String id, String statusString, JTable jTable, String tblName) {

        ArrayList<BookIssueDetail> booksDetailBAL = bookissueDetailBAL.getBooksDetailsSearch(id, statusString, "std_id");
        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        dtm.setRowCount(0);
        for (BookIssueDetail bookIssueDetail : booksDetailBAL) {

            Vector v = new Vector();

            long days = generalBAL.getIssueToNowDays(bookIssueDetail.getBookIssueDate());
            books = booksBAL.getBooks(String.valueOf(bookIssueDetail.getBookNo()));

            int issueLimit = books.getBookIssueLimit();

            if (days > issueLimit && tblName.equals("penalty")) {
                v.add(bookIssueDetail.getIdString());
                v.add(bookIssueDetail.getBookNo());
                v.add(bookIssueDetail.getBookIssueDate());
                v.add(generalBAL.getIssueToNowDays(bookIssueDetail.getBookIssueDate()));
                v.add(days - 30);
                dtm.addRow(v);
            } else if (days <= issueLimit && tblName.equals("")) {
                v.add(bookIssueDetail.getIdString());
                v.add(bookIssueDetail.getBookNo());
                v.add(bookIssueDetail.getBookIssueDate());
                v.add(generalBAL.getIssueToNowDays(bookIssueDetail.getBookIssueDate()));
                dtm.addRow(v);
            }
        }
        jTable.setModel(dtm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWithoutPenaltyBooks = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPenalty = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBookNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        spnAmount = new javax.swing.JSpinner();

        jPanel3.setBackground(new java.awt.Color(236, 236, 236));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Books Without Penalty", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        tblWithoutPenaltyBooks.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblWithoutPenaltyBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Book Number", "Issue Date", "Days"
            }
        ));
        tblWithoutPenaltyBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblWithoutPenaltyBooksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblWithoutPenaltyBooks);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(236, 236, 236));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Penalty Books", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        tblPenalty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Number", "Issue Date", "Total Days", "Penalty(Days)", "Total Amount(Pkr)", "Paid", "Remaining"
            }
        ));
        tblPenalty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPenaltyMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPenalty);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(236, 236, 236));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(248, 197, 9)));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("ID:");

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Amount:");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Book Number:");

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Print Challan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 153));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Return Book");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 102, 153));
        btnRefresh.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        spnAmount.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnAmount.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBookNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(spnAmount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBookNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRefresh)
                        .addComponent(spnAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased
        if (txtId.getText().length() > 0) {
            loadTable(txtId.getText(), "issued", tblPenalty, "penalty");
            loadTable(txtId.getText(), "issued", tblWithoutPenaltyBooks, "");
        } else {
            loadTable("issued", tblPenalty, "penalty");
            loadTable("issued", tblWithoutPenaltyBooks, "");
        }
    }//GEN-LAST:event_txtIdKeyReleased

    private void tblPenaltyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPenaltyMouseClicked
        int selectedRow = tblPenalty.getSelectedRow();
        if (selectedRow >= 0) {
            txtId.setText(tblPenalty.getValueAt(selectedRow, 0).toString());
            txtBookNumber.setText(tblPenalty.getValueAt(selectedRow, 1).toString());
            spnAmount.setValue(Integer.parseInt(tblPenalty.getValueAt(selectedRow, 7).toString()));
        }
    }//GEN-LAST:event_tblPenaltyMouseClicked

    private void tblWithoutPenaltyBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblWithoutPenaltyBooksMouseClicked
        int selectedRow = tblWithoutPenaltyBooks.getSelectedRow();
        if (selectedRow >= 0) {
            txtId.setText(tblWithoutPenaltyBooks.getValueAt(selectedRow, 0).toString());
            txtBookNumber.setText(tblWithoutPenaltyBooks.getValueAt(selectedRow, 1).toString());
            spnAmount.setValue(0);
        }
    }//GEN-LAST:event_tblWithoutPenaltyBooksMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (Integer.valueOf(spnAmount.getValue().toString()) == 0 && txtId.getText().length() > 0 && txtBookNumber.getText().length() > 0) {
            bookissueDetailBAL.returnBook(txtId.getText(), txtBookNumber.getText(), "issued");
            loadTable("issued", tblPenalty, "penalty");
            loadTable("issued", tblWithoutPenaltyBooks, "");
            btnRefreshActionPerformed(evt);
        } else if (Integer.valueOf(spnAmount.getValue().toString()) > 0 && txtId.getText().length() > 0 && txtBookNumber.getText().length() > 0) {
            int check = JOptionPane.showInternalConfirmDialog(this, "Is Challan Paid", "Info", 0);
            if (check == 0) {
                penaltyBAL.deletePenalty(txtBookNumber.getText());
                bookissueDetailBAL.returnBook(txtId.getText(), txtBookNumber.getText(), "issued");
                loadTable("issued", tblPenalty, "penalty");
                loadTable("issued", tblWithoutPenaltyBooks, "");
                btnRefreshActionPerformed(evt);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            //String reportString = "ChallanMuet.jrxml";
            //InputStream is=this.getClass().getResourceAsStream(reportString);
            if(Integer.parseInt(spnAmount.getValue()+"")>0){
                StudentTeacher st = studentTeacherBAL.getStudentTeacher(txtId.getText());
                Map<String,Object> challanP=new HashMap<>();
                challanP.put("name",st.getNameString());
                challanP.put("rollNo",st.getIdString());
                challanP.put("amount",spnAmount.getValue()+"");
                JasperReport compileReport = JasperCompileManager.compileReport("ChallanMuet.jrxml");
                JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, challanP, msqlc.getCon());
                JasperViewer.viewReport(jasperPrint,false);
            }else{
                JOptionPane.showMessageDialog(rootPane, "No need to Print Challan Because Penalty is 0");
                
            }
        } catch (JRException ex) {
            Logger.getLogger(ReturnBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        txtBookNumber.setText("");
        txtId.setText("");
        spnAmount.setValue(0);
        tblPenalty.clearSelection();
        tblWithoutPenaltyBooks.clearSelection();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spnAmount;
    private javax.swing.JTable tblPenalty;
    private javax.swing.JTable tblWithoutPenaltyBooks;
    private javax.swing.JTextField txtBookNumber;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
