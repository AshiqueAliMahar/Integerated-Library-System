package Frames.AdminLibrarian.reports;

import BALClasses.BookissueDetailBAL;
import BALClasses.BooksBAL;
import BALClasses.LibrarianBAL;
import BALClasses.StudentTeacherBAL;
import BeanClasses.BookIssueDetail;
import BeanClasses.Books;
import BeanClasses.Librarian;
import BeanClasses.StudentTeacher;
import ConnectionOfMySql.MySQLConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Reports extends javax.swing.JInternalFrame {

    private StudentTeacherBAL stbal = new StudentTeacherBAL();
    private LibrarianBAL librarianBAL = new LibrarianBAL();
    private BooksBAL booksBAL = new BooksBAL();
    private BookissueDetailBAL bookissueDetailBAL = new BookissueDetailBAL();
    private Connection msqlc=MySQLConnection.getCon();
    public Reports() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnTotalLibBooks = new javax.swing.JButton();
        btnAvailBooks = new javax.swing.JButton();
        btnNoIssuedBks = new javax.swing.JButton();
        btnNoReservedBks = new javax.swing.JButton();
        btnNoOfLib = new javax.swing.JButton();
        btnTotalPatrons = new javax.swing.JButton();
        btnBooksExcel = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btnLibExcel = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btnShowAllBks = new javax.swing.JButton();
        btnTotalPatrons1 = new javax.swing.JButton();
        btnBkIssueExcel = new javax.swing.JButton();
        btnAvailBooks1 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        btnAvailBooks2 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        btnAvailBooks3 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(236, 236, 236));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reports", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        btnTotalLibBooks.setBackground(new java.awt.Color(0, 102, 153));
        btnTotalLibBooks.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnTotalLibBooks.setForeground(new java.awt.Color(255, 255, 255));
        btnTotalLibBooks.setText("Total Library Books");
        btnTotalLibBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalLibBooksActionPerformed(evt);
            }
        });

        btnAvailBooks.setBackground(new java.awt.Color(0, 102, 153));
        btnAvailBooks.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnAvailBooks.setForeground(new java.awt.Color(255, 255, 255));
        btnAvailBooks.setText("Available Library Books");
        btnAvailBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvailBooksActionPerformed(evt);
            }
        });

        btnNoIssuedBks.setBackground(new java.awt.Color(0, 102, 153));
        btnNoIssuedBks.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnNoIssuedBks.setForeground(new java.awt.Color(255, 255, 255));
        btnNoIssuedBks.setText("Number Of Issued Books");
        btnNoIssuedBks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoIssuedBksActionPerformed(evt);
            }
        });

        btnNoReservedBks.setBackground(new java.awt.Color(0, 102, 153));
        btnNoReservedBks.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnNoReservedBks.setForeground(new java.awt.Color(255, 255, 255));
        btnNoReservedBks.setText("Number Of Reserved Books");
        btnNoReservedBks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoReservedBksActionPerformed(evt);
            }
        });

        btnNoOfLib.setBackground(new java.awt.Color(0, 102, 153));
        btnNoOfLib.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnNoOfLib.setForeground(new java.awt.Color(255, 255, 255));
        btnNoOfLib.setText("Number Of Librarian");
        btnNoOfLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoOfLibActionPerformed(evt);
            }
        });

        btnTotalPatrons.setBackground(new java.awt.Color(0, 102, 153));
        btnTotalPatrons.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnTotalPatrons.setForeground(new java.awt.Color(255, 255, 255));
        btnTotalPatrons.setText("Total Patrons");
        btnTotalPatrons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalPatronsActionPerformed(evt);
            }
        });

        btnBooksExcel.setBackground(new java.awt.Color(0, 102, 153));
        btnBooksExcel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnBooksExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnBooksExcel.setText("Export Total Books Excel");
        btnBooksExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBooksExcelActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 102, 153));
        jButton8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Export Patrons Excel");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btnLibExcel.setBackground(new java.awt.Color(0, 102, 153));
        btnLibExcel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnLibExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnLibExcel.setText("Export Librarian Excel");
        btnLibExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibExcelActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 102, 153));
        jButton10.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Show Patrons");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        btnShowAllBks.setBackground(new java.awt.Color(0, 102, 153));
        btnShowAllBks.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnShowAllBks.setForeground(new java.awt.Color(255, 255, 255));
        btnShowAllBks.setText("Show All Books");
        btnShowAllBks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllBksActionPerformed(evt);
            }
        });

        btnTotalPatrons1.setBackground(new java.awt.Color(0, 102, 153));
        btnTotalPatrons1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnTotalPatrons1.setForeground(new java.awt.Color(255, 255, 255));
        btnTotalPatrons1.setText("List Books Issued");
        btnTotalPatrons1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalPatrons1ActionPerformed(evt);
            }
        });

        btnBkIssueExcel.setBackground(new java.awt.Color(0, 102, 153));
        btnBkIssueExcel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnBkIssueExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnBkIssueExcel.setText("Books Issued Excel");
        btnBkIssueExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkIssueExcelActionPerformed(evt);
            }
        });

        btnAvailBooks1.setBackground(new java.awt.Color(0, 102, 153));
        btnAvailBooks1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnAvailBooks1.setForeground(new java.awt.Color(255, 255, 255));
        btnAvailBooks1.setText("Patron Visualization(Pie Chart)");
        btnAvailBooks1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvailBooks1ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 102, 153));
        jButton11.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Total Books Visualization(Pie Chart)");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        btnAvailBooks2.setBackground(new java.awt.Color(0, 102, 153));
        btnAvailBooks2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnAvailBooks2.setForeground(new java.awt.Color(255, 255, 255));
        btnAvailBooks2.setText("Available Books Visualization(Pie Chart)");
        btnAvailBooks2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvailBooks2ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 102, 153));
        jButton12.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Issued Books Visualization(Pie Chart)");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        btnAvailBooks3.setBackground(new java.awt.Color(0, 102, 153));
        btnAvailBooks3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnAvailBooks3.setForeground(new java.awt.Color(255, 255, 255));
        btnAvailBooks3.setText("Reserved Books Visualization(Pie Chart)");
        btnAvailBooks3.setToolTipText("");
        btnAvailBooks3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvailBooks3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTotalLibBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTotalPatrons1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTotalPatrons, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShowAllBks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLibExcel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAvailBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNoIssuedBks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBooksExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNoOfLib, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBkIssueExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNoReservedBks, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                    .addComponent(btnAvailBooks2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvailBooks1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvailBooks3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTotalLibBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNoReservedBks, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBooksExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLibExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNoIssuedBks, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowAllBks, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNoOfLib, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTotalPatrons, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkIssueExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTotalPatrons1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAvailBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAvailBooks1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAvailBooks2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAvailBooks3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTotalLibBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalLibBooksActionPerformed
        JOptionPane.showInternalMessageDialog(rootPane, "Total Library Books :" + BooksBAL.countTotalBooks(), "Total Library Books", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnTotalLibBooksActionPerformed

    private void btnAvailBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvailBooksActionPerformed
        JOptionPane.showInternalMessageDialog(rootPane, "Available Library Books :" + BooksBAL.countAvailBooks(), "Available Library Books", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAvailBooksActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        ShowPatronsDialogReport showPatronsDialogReport = new ShowPatronsDialogReport(null, true);
        showPatronsDialogReport.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnNoIssuedBksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoIssuedBksActionPerformed
        JOptionPane.showInternalMessageDialog(rootPane, "Number Of Issued Books :" + BooksBAL.countIssuedBks(), "Number Of Issued Books ", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnNoIssuedBksActionPerformed

    private void btnNoReservedBksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoReservedBksActionPerformed
        JOptionPane.showInternalMessageDialog(rootPane, "Number Of Reserved Books :" + BooksBAL.countReservedBks(), "Number Of Reserved Books ", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnNoReservedBksActionPerformed

    private void btnShowAllBksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllBksActionPerformed
        ShowAllBooksDialog showAllBooksDialog = new ShowAllBooksDialog(null, true);
        showAllBooksDialog.setVisible(Boolean.TRUE);
    }//GEN-LAST:event_btnShowAllBksActionPerformed

    private void btnNoOfLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoOfLibActionPerformed
        JOptionPane.showInternalMessageDialog(rootPane, "Total Number Of Librarian :" + LibrarianBAL.countLibrarian(), "Number Of Librarian", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnNoOfLibActionPerformed

    private void btnTotalPatronsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalPatronsActionPerformed
        JOptionPane.showInternalMessageDialog(rootPane, "Total Number Of Patrons :" + StudentTeacherBAL.countTotalPatrons(), "Number Of Patrons", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnTotalPatronsActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet();
        Row row = sheet.createRow(0);
        int count = 0;
        row.createCell(count++).setCellValue("ID");
        row.createCell(count++).setCellValue("Name");
        row.createCell(count++).setCellValue("Email");
        row.createCell(count++).setCellValue("CNIC");
        row.createCell(count++).setCellValue("Date Of Birth");
        row.createCell(count++).setCellValue("Contact No.");
        row.createCell(count++).setCellValue("Address");
        row.createCell(count++).setCellValue("Date Of Admission");
        row.createCell(count++).setCellValue("Department Name");
        row.createCell(count++).setCellValue("Gender");
        row.createCell(count++).setCellValue("Post");
        row.createCell(count++).setCellValue("Pic");
        ArrayList<StudentTeacher> stdTeacher = stbal.getStdTeacher();
        for (int i = 0; i < stdTeacher.size(); i++) {
            count = 0;
            row = sheet.createRow(i + 1);
            row.createCell(count++).setCellValue(stdTeacher.get(i).getIdString() + "");
            row.createCell(count++).setCellValue(stdTeacher.get(i).getNameString() + "");
            row.createCell(count++).setCellValue(stdTeacher.get(i).getEmailString() + "");
            row.createCell(count++).setCellValue(stdTeacher.get(i).getCNICString() + "");
            row.createCell(count++).setCellValue(stdTeacher.get(i).getDateOfBirthDate() + "");
            row.createCell(count++).setCellValue(stdTeacher.get(i).getContactNoString() + "");
            row.createCell(count++).setCellValue(stdTeacher.get(i).getAddressString() + "");
            row.createCell(count++).setCellValue(stdTeacher.get(i).getDateOfAdmission() + "");
            row.createCell(count++).setCellValue(stdTeacher.get(i).getDepartmentName() + "");
            row.createCell(count++).setCellValue(stdTeacher.get(i).getGenderString() + "");
            row.createCell(count++).setCellValue(stdTeacher.get(i).getPostString() + "");
            byte[] picBlob = stdTeacher.get(i).getPicBlob();
            if (picBlob != null) {
                int addPicture = workbook.addPicture(picBlob, Workbook.PICTURE_TYPE_JPEG);
                HSSFPatriarch hSSFPatriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();
                HSSFClientAnchor hssfClientAnchor = new HSSFClientAnchor();
                hssfClientAnchor.setAnchor((short) count, i + 1, 1, 1, (short) (count + 1), i + 2, 2, 2);
                hSSFPatriarch.createPicture(hssfClientAnchor, addPicture);

            }

        }
        try {
            String path = getPathForSave();
            if (!path.equals("")) {
                workbook.write(new FileOutputStream(path));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Save Failed");
            }
        } catch (IOException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnLibExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibExcelActionPerformed
        Workbook libExcel = HSSFWorkbook.create(InternalWorkbook.createWorkbook());
        Sheet sheet = libExcel.createSheet();
        Row row = sheet.createRow(0);
        int count = 0;
        row.createCell(count++).setCellValue("Id");
        row.createCell(count++).setCellValue("Name");
        row.createCell(count++).setCellValue("CNIC");
        row.createCell(count++).setCellValue("Address");
        row.createCell(count++).setCellValue("Contact No");
        row.createCell(count++).setCellValue("Email");
        row.createCell(count++).setCellValue("Gender");
        List<Librarian> librarians = librarianBAL.getLibrarians("Librarian");
        int rowCount = 1;
        for (Librarian librarian : librarians) {
            count = 0;
            row = sheet.createRow(rowCount);
            row.createCell(count++).setCellValue(librarian.getLibId());
            row.createCell(count++).setCellValue(librarian.getLibName());
            row.createCell(count++).setCellValue(librarian.getLibCNIC());
            row.createCell(count++).setCellValue(librarian.getLibAddress());
            row.createCell(count++).setCellValue(librarian.getLibContactNo());
            row.createCell(count++).setCellValue(librarian.getLibEmail());
            row.createCell(count++).setCellValue(librarian.getGender());
            rowCount++;
        }
        try {
            String path = getPathForSave();
            if (!path.equals("")) {
                libExcel.write(new FileOutputStream(path));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Save Failed");
            }
        } catch (IOException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLibExcelActionPerformed

    private void btnBooksExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBooksExcelActionPerformed
        saveBookExcel(booksBAL.getTotalLibraryBooks());
    }//GEN-LAST:event_btnBooksExcelActionPerformed
    private void saveBookExcel(List<Books> books) {
        Workbook workbook = HSSFWorkbook.create(InternalWorkbook.createWorkbook());
        Sheet sheet = workbook.createSheet();
        Row row = sheet.createRow(0);
        int count = 0;
        row.createCell(count++).setCellValue("Book No");
        row.createCell(count++).setCellValue("Book Name");
        row.createCell(count++).setCellValue("Book Author");
        row.createCell(count++).setCellValue("Book Category");
        row.createCell(count++).setCellValue("Book Publisher");
        row.createCell(count++).setCellValue("Book Location");
        row.createCell(count++).setCellValue("Book Publishing Date");
        row.createCell(count++).setCellValue("Book Issue Limit(Days)");
        row.createCell(count++).setCellValue("ISBN");
        row.createCell(count++).setCellValue("Pages");
        row.createCell(count++).setCellValue("Picture");

        int rowCount = 1;
        for (Books book : books) {
            count = 0;
            row = sheet.createRow(rowCount++);
            row.createCell(count++).setCellValue(book.getBookNumber() + "");
            row.createCell(count++).setCellValue(book.getBookNameString() + "");
            row.createCell(count++).setCellValue(book.getBookAuthorString() + "");
            row.createCell(count++).setCellValue(book.getBookCategoryString() + "");
            row.createCell(count++).setCellValue(book.getBookPublisherString() + "");
            row.createCell(count++).setCellValue(book.getBookLocation() + "");
            row.createCell(count++).setCellValue(book.getBookPublishingDate() + "");
            row.createCell(count++).setCellValue(book.getBookIssueLimit() + "");
            row.createCell(count++).setCellValue(book.getIsbn() + "");
            row.createCell(count++).setCellValue(book.getPages() + "");
            byte[] pic = book.getPic();
            if (pic != null) {
                int index = workbook.addPicture(pic, Workbook.PICTURE_TYPE_JPEG);
                HSSFPatriarch hSSFPatriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();
                HSSFClientAnchor anchor = new HSSFClientAnchor(1, 1, 2, 2, (short) count, rowCount - 1, (short) (count + 1), rowCount);
                hSSFPatriarch.createPicture(anchor, index);
            }
        }
        try {
            String path = getPathForSave();
            if (!path.equals("")) {
                workbook.write(new FileOutputStream(path));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Save Failed");
            }
        } catch (IOException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnTotalPatrons1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalPatrons1ActionPerformed
        ShowIssuedBooks showAllBooksDialog = new ShowIssuedBooks(null, true);
        showAllBooksDialog.setVisible(Boolean.TRUE);
    }//GEN-LAST:event_btnTotalPatrons1ActionPerformed

    private void btnBkIssueExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBkIssueExcelActionPerformed
        List<Books> bookses = new LinkedList<>();
        ArrayList<BookIssueDetail> booksDetail = bookissueDetailBAL.getBooksDetail("issued");
//        if (booksDetail != null) {
        for (BookIssueDetail bid : booksDetail) {
            bookses.add(booksBAL.getBooks(bid.getBookNo() + ""));
        }
        saveBookExcel(bookses);
//        }else{
//            JOptionPane.showMessageDialog(rootPane, "No Any Book Issued");
//        }

    }//GEN-LAST:event_btnBkIssueExcelActionPerformed

    private void btnAvailBooks1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvailBooks1ActionPerformed
        showJasper("All Patrons.jrxml", msqlc);
    }//GEN-LAST:event_btnAvailBooks1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        showJasper("total books.jrxml", msqlc);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void btnAvailBooks2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvailBooks2ActionPerformed
        showJasper("Available books.jrxml", msqlc);
    }//GEN-LAST:event_btnAvailBooks2ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        showJasper("Issued Books.jrxml", msqlc);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void btnAvailBooks3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvailBooks3ActionPerformed
        showJasper("Reserve.jrxml", msqlc);
    }//GEN-LAST:event_btnAvailBooks3ActionPerformed

    public static String getPathForSave() {
        String pathString = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
        int approveOpt = fileChooser.showSaveDialog(new Reports());
        if (approveOpt == JFileChooser.APPROVE_OPTION) {
            pathString = fileChooser.getSelectedFile() + ".xls";
        }
        return pathString;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvailBooks;
    private javax.swing.JButton btnAvailBooks1;
    private javax.swing.JButton btnAvailBooks2;
    private javax.swing.JButton btnAvailBooks3;
    private javax.swing.JButton btnBkIssueExcel;
    private javax.swing.JButton btnBooksExcel;
    private javax.swing.JButton btnLibExcel;
    private javax.swing.JButton btnNoIssuedBks;
    private javax.swing.JButton btnNoOfLib;
    private javax.swing.JButton btnNoReservedBks;
    private javax.swing.JButton btnShowAllBks;
    private javax.swing.JButton btnTotalLibBooks;
    private javax.swing.JButton btnTotalPatrons;
    private javax.swing.JButton btnTotalPatrons1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
    private void showJasper(String reportFileName, Connection connection) {
        JasperReport compileReport;
        try {
            compileReport = JasperCompileManager.compileReport(reportFileName);
            JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, null, connection);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
