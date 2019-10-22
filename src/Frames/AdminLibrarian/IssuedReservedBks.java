package Frames.AdminLibrarian;

import BALClasses.BookissueDetailBAL;
import BeanClasses.BookIssueDetail;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class IssuedReservedBks extends javax.swing.JInternalFrame {

    BookissueDetailBAL bookissueDetailBAL = new BookissueDetailBAL();

    public IssuedReservedBks() {
        initComponents();
        loadTable("reserved", tblReservedBooks);
        loadTable("issued", tblIssuedBooks);
    }

    private void loadTable(String statusString, JTable jTable) {

        ArrayList<BookIssueDetail> booksDetailBAL = bookissueDetailBAL.getBooksDetail(statusString);
        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        dtm.setRowCount(0);
         for(BookIssueDetail bookIssueDetail:booksDetailBAL){
            Vector v = new Vector();
            v.add(bookIssueDetail.getIdString());
            v.add(bookIssueDetail.getBookNo());
            v.add(bookIssueDetail.getBookIssueDate());
          dtm.addRow(v);
        }
        jTable.setModel(dtm);
    }

    private void loadTable(String value, String statusString, JTable jTable, String fieldName) {

        ArrayList<BookIssueDetail> booksDetailBAL = bookissueDetailBAL.getBooksDetailsSearch(value, statusString, fieldName);
        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        dtm.setRowCount(0);
        booksDetailBAL.stream().map((bookIssueDetail) -> {
            Vector v = new Vector();
            v.add(bookIssueDetail.getIdString());
            v.add(bookIssueDetail.getBookNo());
            v.add(bookIssueDetail.getBookIssueDate());
            return v;
        }).forEachOrdered((v) -> {
            dtm.addRow(v);
        });
        jTable.setModel(dtm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReservedBooks = new javax.swing.JTable();
        txtRsrveId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRsrvBookNo = new javax.swing.JTextField();
        txtRsrvDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbRsrvSearch = new javax.swing.JComboBox<>();
        txtRsrvSrch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIssuedBooks = new javax.swing.JTable();
        txtIssuedId = new javax.swing.JTextField();
        txtIssudBkNum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIssueDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbIssueSrch = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtIsueSrch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jpanel.setBackground(new java.awt.Color(236, 236, 236));
        jpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reserved Books", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        tblReservedBooks.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        tblReservedBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Book Number", "Resevation Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReservedBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReservedBooksMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblReservedBooks);

        txtRsrveId.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("ID:");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel6.setText("Book Number");

        txtRsrvBookNo.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        txtRsrvDate.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel7.setText("Reserved Date");

        cmbRsrvSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Book Number" }));

        txtRsrvSrch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRsrvSrchKeyReleased(evt);
            }
        });

        jLabel5.setText("Search");

        jLabel10.setText("Search By");

        javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jpanelLayout);
        jpanelLayout.setHorizontalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRsrveId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRsrvDate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRsrvBookNo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbRsrvSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRsrvSrch)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createSequentialGroup()
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRsrveId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtRsrvDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtRsrvBookNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbRsrvSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRsrvSrch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(236, 236, 236));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Issued Books", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        tblIssuedBooks.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        tblIssuedBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Book Number", "Issued Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIssuedBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIssuedBooksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIssuedBooks);

        txtIssuedId.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        txtIssudBkNum.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("Issued Date");

        txtIssueDate.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel2.setText("Book Number");

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel1.setText("ID:");

        cmbIssueSrch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Book Number" }));

        jLabel8.setText("Search");

        txtIsueSrch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIsueSrchKeyReleased(evt);
            }
        });

        jLabel9.setText("Search By");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIssuedId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIssudBkNum, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbIssueSrch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIsueSrch, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIssuedId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtIssudBkNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbIssueSrch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIsueSrch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblReservedBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReservedBooksMouseClicked

        int row = tblReservedBooks.getSelectedRow();
        txtRsrveId.setText(tblReservedBooks.getValueAt(row, 0).toString());
        txtRsrvBookNo.setText(tblReservedBooks.getValueAt(row, 1).toString());
        txtRsrvDate.setText(tblReservedBooks.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tblReservedBooksMouseClicked

    private void tblIssuedBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIssuedBooksMouseClicked

        int row = tblIssuedBooks.getSelectedRow();
        if (row >= 0) {
            String idString = tblIssuedBooks.getValueAt(row, 0).toString();
            String bookNumberString = tblIssuedBooks.getValueAt(row, 1).toString();
            String bookIssueDateString = tblIssuedBooks.getValueAt(row, 2).toString();
            txtIssuedId.setText(idString);
            txtIssudBkNum.setText(bookNumberString);
            txtIssueDate.setText(bookIssueDateString);
        }

    }//GEN-LAST:event_tblIssuedBooksMouseClicked

    private void txtRsrvSrchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRsrvSrchKeyReleased
        if (txtRsrvSrch.getText().length()>0) {
            String txt = cmbRsrvSearch.getSelectedItem().toString();
            String fieldName = "std_id";
            if (txt.equals("Book Number")) {
                fieldName = "bk_no";
            }
            loadTable(txtRsrvSrch.getText(), "reserved", tblReservedBooks, fieldName);
        }else{
            loadTable("reserved", tblReservedBooks);
        }
    }//GEN-LAST:event_txtRsrvSrchKeyReleased

    private void txtIsueSrchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIsueSrchKeyReleased
        if (txtIsueSrch.getText().length() > 0) {
            String txt = cmbIssueSrch.getSelectedItem().toString();
            String fieldName = "std_id";
            if (txt.equals("Book Number")) {
                fieldName = "bk_no";
            }
            loadTable(txtIsueSrch.getText(), "issued", tblIssuedBooks, fieldName);
        }else{
            loadTable("issued", tblIssuedBooks);
        }
    }//GEN-LAST:event_txtIsueSrchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbIssueSrch;
    private javax.swing.JComboBox<String> cmbRsrvSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpanel;
    private javax.swing.JTable tblIssuedBooks;
    private javax.swing.JTable tblReservedBooks;
    private javax.swing.JTextField txtIssudBkNum;
    private javax.swing.JTextField txtIssueDate;
    private javax.swing.JTextField txtIssuedId;
    private javax.swing.JTextField txtIsueSrch;
    private javax.swing.JTextField txtRsrvBookNo;
    private javax.swing.JTextField txtRsrvDate;
    private javax.swing.JTextField txtRsrvSrch;
    private javax.swing.JTextField txtRsrveId;
    // End of variables declaration//GEN-END:variables
}
