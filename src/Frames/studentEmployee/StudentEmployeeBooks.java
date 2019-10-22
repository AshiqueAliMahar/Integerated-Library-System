package Frames.studentEmployee;

import BALClasses.BookissueDetailBAL;
import BALClasses.BooksBAL;
import BALClasses.PolicyBAL;
import BeanClasses.Books;
import BeanClasses.Policy;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StudentEmployeeBooks extends javax.swing.JInternalFrame {

    BooksBAL booksBAL = new BooksBAL();
    BookissueDetailBAL bookissueDetailBAL = new BookissueDetailBAL();

    String idString = "";

    public StudentEmployeeBooks(String idString) {
        initComponents();
        this.idString = idString;
        rdBtnGroup.add(rdTotalBooks);
        rdBtnGroup.add(rdAvailableBooks);
        loadTable(booksBAL.getBooks());
    }
    private void clear(){
        txtBookAuthor.setText("");
        txtBookCategory.setText("");
        txtBookName.setText("");
        txtBookPublisher.setText("");
        txtISBN.setText("");
        txtIssueLimit.setText("");
        txtNoOfCopies.setText("");
        txtPages.setText("");
        txtPublishingDate.setText("");
        txtShelfNumber.setText("");
        lblPic.setIcon(new ImageIcon(new byte[0]));
        tblBooks.clearSelection();
        
    }

    private void loadTable(ArrayList<Books> books) {

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
            if (rdTotalBooks.isSelected()) {
                v.add(BooksBAL.countTotalBooks(books1.getIsbn()));
            } else {
                v.add(BooksBAL.countAvailBooks(books1.getIsbn()));
            }
            v.add(books1.getPages());
            v.add(books1.getPic());
            model.addRow(v);
        }
        tblBooks.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdBtnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        cmbSearchBy = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnReserveBook = new javax.swing.JButton();
        rdTotalBooks = new javax.swing.JRadioButton();
        rdAvailableBooks = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNoOfCopies = new javax.swing.JTextField();
        txtBookCategory = new javax.swing.JTextField();
        txtPublishingDate = new javax.swing.JTextField();
        txtBookName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBookAuthor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIssueLimit = new javax.swing.JTextField();
        txtBookPublisher = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtShelfNumber = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPages = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblPic = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 51, 0));

        jPanel1.setBackground(new java.awt.Color(236, 236, 236));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Books", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 1, 18), new java.awt.Color(0, 153, 0))); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblBooks.setAutoCreateRowSorter(true);
        tblBooks.setBorder(null);
        tblBooks.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Author", "Publisher", "Category", "Publishing Date", "Issue Limit In Days ", "Location", "ISBN", "No. Of Copies", "Pages", "Pic"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBooksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBooks);

        cmbSearchBy.setBackground(new java.awt.Color(255, 255, 255));
        cmbSearchBy.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        cmbSearchBy.setForeground(new java.awt.Color(255, 255, 255));
        cmbSearchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ISBN", "Name", "Author", "Category" }));
        cmbSearchBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSearchByActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel8.setText("Search");

        jLabel9.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel9.setText("Search By");

        btnReserveBook.setBackground(new java.awt.Color(0, 102, 153));
        btnReserveBook.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnReserveBook.setForeground(new java.awt.Color(255, 255, 255));
        btnReserveBook.setText("RESERVE BOOK");
        btnReserveBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReserveBookActionPerformed(evt);
            }
        });

        rdTotalBooks.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        rdTotalBooks.setText("Total Books");
        rdTotalBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTotalBooksActionPerformed(evt);
            }
        });

        rdAvailableBooks.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        rdAvailableBooks.setSelected(true);
        rdAvailableBooks.setText("Available Books");
        rdAvailableBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAvailableBooksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSearchBy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdTotalBooks)
                .addGap(18, 18, 18)
                .addComponent(rdAvailableBooks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReserveBook)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdTotalBooks)
                    .addComponent(rdAvailableBooks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReserveBook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(236, 236, 236));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Books Detail", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel1.setText("No. Of Copies");

        txtNoOfCopies.setEditable(false);
        txtNoOfCopies.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        txtBookCategory.setEditable(false);
        txtBookCategory.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        txtPublishingDate.setEditable(false);
        txtPublishingDate.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        txtBookName.setEditable(false);
        txtBookName.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel6.setText("Publishing Date");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setText("Book Category");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel2.setText("Book Name");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("Book Author");

        txtBookAuthor.setEditable(false);
        txtBookAuthor.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel7.setText("Issue Limit(Days)");

        txtIssueLimit.setEditable(false);
        txtIssueLimit.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        txtBookPublisher.setEditable(false);
        txtBookPublisher.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("Book Publisher");

        jLabel10.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel10.setText("Location");

        txtShelfNumber.setEditable(false);
        txtShelfNumber.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel11.setText("ISBN");

        txtISBN.setEditable(false);
        txtISBN.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel12.setText("Pages");

        txtPages.setEditable(false);
        txtPages.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNoOfCopies)
                    .addComponent(txtBookName)
                    .addComponent(txtBookAuthor)
                    .addComponent(txtBookPublisher)
                    .addComponent(txtISBN))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPages)
                    .addComponent(txtBookCategory)
                    .addComponent(txtPublishingDate)
                    .addComponent(txtIssueLimit)
                    .addComponent(txtShelfNumber))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoOfCopies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBookCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPublishingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIssueLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtShelfNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBookPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))))
        );

        jPanel3.setBackground(new java.awt.Color(236, 236, 236));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 0, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        lblPic.setBackground(new java.awt.Color(236, 236, 236));
        lblPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPic.setLabelFor(this);
        lblPic.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblPic.setName(""); // NOI18N
        lblPic.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPic, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPic, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

        String cmbSearchString = cmbSearchBy.getSelectedItem().toString();
        String txtSearchString = txtSearch.getText();
        String fieldNameString = "";
        if (cmbSearchString.equals("Name")) {
            fieldNameString = "bk_name";
        } else if (cmbSearchString.equals("ISBN")) {
            fieldNameString = "isbn";
        } else if (cmbSearchString.equals("Category")) {
            fieldNameString = "bk_category";
        } else if (cmbSearchString.equals("Author")) {
            fieldNameString = "bk_author";
        }
        if (rdTotalBooks.isSelected()) {
            loadTable(booksBAL.getTotalLibraryBooks(txtSearchString, fieldNameString));
        } else {
            loadTable(booksBAL.getBooks(txtSearchString, fieldNameString));
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnReserveBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReserveBookActionPerformed

        ArrayList<Books> availBooks = booksBAL.getAvailBooks(txtISBN.getText());
        
        int reservationLimit = Integer.valueOf(PolicyBAL.getValue(Policy.policies.NO_OF_BOOK_RESERVATION.toString()).getPolicyVal());
        if (!availBooks.isEmpty() && availBooks.get(0)!=null && (availBooks.get(0).getBookNumber()+"").length() > 0) {
            String bookNumberString = availBooks.get(0).getBookNumber() + "";
            if (!bookissueDetailBAL.isReserved(bookNumberString)) {
                if (bookissueDetailBAL.getNoOfReservedBooks(idString) < reservationLimit) {
                    if (rdAvailableBooks.isSelected()) {
                        int bookNumber = Integer.parseInt(bookNumberString);
                        bookissueDetailBAL.issueBook(bookNumber, idString, "reserved");
                        loadTable(booksBAL.getBooks());
                        clear();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Select Available Books");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "You Had Already Reserved " + reservationLimit + " Books");
                }
            } else {
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a Book From Table");
        }

    }//GEN-LAST:event_btnReserveBookActionPerformed

    private void rdTotalBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTotalBooksActionPerformed
        loadTable(booksBAL.getTotalLibraryBooks());
        clear();
    }//GEN-LAST:event_rdTotalBooksActionPerformed

    private void rdAvailableBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAvailableBooksActionPerformed
        loadTable(booksBAL.getBooks());
        clear();
    }//GEN-LAST:event_rdAvailableBooksActionPerformed

    private void tblBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBooksMouseClicked
        int rowNumber = tblBooks.getSelectedRow();
        if (rowNumber >= 0) {

            String bookNameString = tblBooks.getValueAt(rowNumber, 0).toString();
            String bookAuthorString = tblBooks.getValueAt(rowNumber, 1).toString();
            String bookPublisherString = tblBooks.getValueAt(rowNumber, 2).toString();
            String bookCategoryString = tblBooks.getValueAt(rowNumber, 3).toString();
            String bookPublishingDateString = tblBooks.getValueAt(rowNumber, 4).toString();
            String bookIssueLimitString = tblBooks.getValueAt(rowNumber, 5).toString();
            String bookShelfString = tblBooks.getValueAt(rowNumber, 6).toString();
            String isbn = tblBooks.getValueAt(rowNumber, 7).toString();
            String noOfCopies = tblBooks.getValueAt(rowNumber, 8).toString();
            String pages = tblBooks.getValueAt(rowNumber, 9).toString();
            byte[] pic = Optional.ofNullable((byte[]) tblBooks.getValueAt(rowNumber, 10)).orElse(new byte[0]);
            txtNoOfCopies.setText(noOfCopies);
            txtBookAuthor.setText(bookAuthorString);
            txtBookCategory.setText(bookCategoryString);
            txtBookName.setText(bookNameString);
            txtBookPublisher.setText(bookPublisherString);
            txtIssueLimit.setText(bookIssueLimitString);
            txtPublishingDate.setText(bookPublishingDateString);
            txtShelfNumber.setText(bookShelfString);
            txtISBN.setText(isbn);
            txtPages.setText(pages);
            ImageIcon imageIcon = new ImageIcon(pic);
            Image image = imageIcon.getImage();
            Image scaledInstance = image.getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH);
            imageIcon.setImage(scaledInstance);
            lblPic.setIcon(imageIcon);
        }
    }//GEN-LAST:event_tblBooksMouseClicked

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        clear();
    }//GEN-LAST:event_txtSearchMouseClicked

    private void cmbSearchByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSearchByActionPerformed
        clear();
    }//GEN-LAST:event_cmbSearchByActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReserveBook;
    private javax.swing.JComboBox<String> cmbSearchBy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPic;
    private javax.swing.JRadioButton rdAvailableBooks;
    private javax.swing.ButtonGroup rdBtnGroup;
    private javax.swing.JRadioButton rdTotalBooks;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTextField txtBookAuthor;
    private javax.swing.JTextField txtBookCategory;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtBookPublisher;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtIssueLimit;
    private javax.swing.JTextField txtNoOfCopies;
    private javax.swing.JTextField txtPages;
    private javax.swing.JTextField txtPublishingDate;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtShelfNumber;
    // End of variables declaration//GEN-END:variables
}
