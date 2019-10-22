/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.AdminLibrarian.reports;

import BALClasses.BooksBAL;
import BeanClasses.Books;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ali.ashique
 */
public class ShowAllBooksDialog extends javax.swing.JDialog {

    private BooksBAL booksBAL = new BooksBAL();

    public ShowAllBooksDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadTable(booksBAL.getBooks(),tblBooks);
    }

        public static void loadTable(List<Books> books,JTable tblBooks) {

        DefaultTableModel model = (DefaultTableModel) tblBooks.getModel();
        model.setRowCount(0);
        for (Books books1 : books) {
            Vector v = new Vector();
            v.add(books1.getBookNameString());
            v.add(books1.getBookAuthorString());
            v.add(books1.getBookPublisherString());
            v.add(books1.getBookCategoryString());
            v.add(books1.getBookPublishingDate());
            v.add(books1.getBookIssueLimit());
            v.add(books1.getBookLocation());
            v.add(books1.getIsbn());
            v.add(BooksBAL.countTotalBooks(books1.getIsbn()));
            v.add(books1.getPages());
            v.add(books1.getPic());
            model.addRow(v);
        }
        tblBooks.setModel(model);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDtlBook = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(236, 236, 236));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "All Books", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        tblDtlBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Number", "ISBN"
            }
        ));
        jScrollPane2.setViewportView(tblDtlBook);

        jSplitPane1.setLeftComponent(jScrollPane2);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblBooks.setAutoCreateRowSorter(true);
        tblBooks.setBorder(null);
        tblBooks.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        tblBooks.setForeground(new java.awt.Color(0, 0, 0));
        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Author", "Publisher", "Category", "Publishing Date", "Issue Limit In Days ", "Location", "ISBN", "No. of copies", "Pages", "Pic"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBooks.setOpaque(false);
        tblBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBooksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBooks);

        jSplitPane1.setRightComponent(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
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

    private void loadTblBookDtl(ArrayList<Books> books) {

        DefaultTableModel model = (DefaultTableModel) tblDtlBook.getModel();
        model.setRowCount(0);
        for (Books books1 : books) {
            Vector v = new Vector();
            v.add(books1.getBookNumber());
            v.add(books1.getIsbn());
            model.addRow(v);
        }
        tblDtlBook.setModel(model);
    }
    private void tblBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBooksMouseClicked
        int rowNumber = tblBooks.getSelectedRow();
        if (rowNumber >= 0) {
            String isbn = Optional.ofNullable(tblBooks.getValueAt(rowNumber, 7)).orElse("").toString();
            ArrayList<Books> availBooks = null;
            availBooks = booksBAL.getTotalLibraryBooks(isbn);
            loadTblBookDtl(availBooks);
        }
    }//GEN-LAST:event_tblBooksMouseClicked

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ShowAllBooksDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ShowAllBooksDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ShowAllBooksDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ShowAllBooksDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ShowAllBooksDialog dialog = new ShowAllBooksDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTable tblDtlBook;
    // End of variables declaration//GEN-END:variables
}
