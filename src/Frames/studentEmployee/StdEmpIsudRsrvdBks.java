package Frames.studentEmployee;

import BALClasses.BookissueDetailBAL;
import BeanClasses.BookIssueDetail;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StdEmpIsudRsrvdBks extends javax.swing.JInternalFrame {

    BookissueDetailBAL bookissueDetailBAL = new BookissueDetailBAL();
    String IdString = "";

    public StdEmpIsudRsrvdBks(String idString) {
        initComponents();
        this.IdString = idString;
        loadTable(idString, "issued", tblIssuedBooks);
        loadTable(idString, "reserved", tblReservedBooks);                
    }

    private void loadTable(String id, String statusString, JTable jTable) {

        ArrayList<BookIssueDetail> booksDetailBAL = bookissueDetailBAL.getBooksDetailBAL(id, statusString,"std_id");
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
        btnDereserve = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIssuedBooks = new javax.swing.JTable();
        txtIssuedId = new javax.swing.JTextField();
        txtIssudBkNum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIssueDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jpanel.setBackground(new java.awt.Color(236, 236, 236));
        jpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reserved Books", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(0, 153, 0))); // NOI18N

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

        btnDereserve.setBackground(new java.awt.Color(0, 102, 153));
        btnDereserve.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnDereserve.setForeground(new java.awt.Color(255, 255, 255));
        btnDereserve.setText("DERESERVE");
        btnDereserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDereserveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jpanelLayout);
        jpanelLayout.setHorizontalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRsrveId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRsrvDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRsrvBookNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDereserve)
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
                    .addComponent(btnDereserve))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(236, 236, 236));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Issued Books", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(0, 153, 0))); // NOI18N

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIssuedId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIssueDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIssudBkNum)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIssuedId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtIssudBkNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblIssuedBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIssuedBooksMouseClicked
        
        int row=tblIssuedBooks.getSelectedRow();
        if(row>=0){
            String idString=tblIssuedBooks.getValueAt(row, 0).toString();
            String bookNumberString=tblIssuedBooks.getValueAt(row, 1).toString();
            String bookIssueDateString=tblIssuedBooks.getValueAt(row, 2).toString();
            txtIssuedId.setText(idString);
            txtIssudBkNum.setText(bookNumberString);
            txtIssueDate.setText(bookIssueDateString);
        }
        
    }//GEN-LAST:event_tblIssuedBooksMouseClicked

    private void tblReservedBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReservedBooksMouseClicked
        
        int row=tblReservedBooks.getSelectedRow();
        txtRsrveId.setText(tblReservedBooks.getValueAt(row, 0).toString());
        txtRsrvBookNo.setText(tblReservedBooks.getValueAt(row, 1).toString());
        txtRsrvDate.setText(tblReservedBooks.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tblReservedBooksMouseClicked

    private void btnDereserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDereserveActionPerformed
        String bkNo=txtRsrvBookNo.getText();
        
        if (bkNo.trim().length()>0) {
            int bkNoInt=Integer.valueOf(bkNo);
            boolean isRemovedRsrved = bookissueDetailBAL.removeRsrved(bkNoInt,IdString);
            if(isRemovedRsrved){
                JOptionPane.showMessageDialog(rootPane, "Book Dereserved Successfully");
                loadTable(IdString, "reserved", tblReservedBooks);
                clearDereservation();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Book Dereservation Failed");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "SELECT A BOOK");
        }
    }//GEN-LAST:event_btnDereserveActionPerformed
    private void clearDereservation(){
        txtRsrveId.setText("");
        txtRsrvBookNo.setText("");
        txtRsrvDate.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDereserve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpanel;
    private javax.swing.JTable tblIssuedBooks;
    private javax.swing.JTable tblReservedBooks;
    private javax.swing.JTextField txtIssudBkNum;
    private javax.swing.JTextField txtIssueDate;
    private javax.swing.JTextField txtIssuedId;
    private javax.swing.JTextField txtRsrvBookNo;
    private javax.swing.JTextField txtRsrvDate;
    private javax.swing.JTextField txtRsrveId;
    // End of variables declaration//GEN-END:variables
}
