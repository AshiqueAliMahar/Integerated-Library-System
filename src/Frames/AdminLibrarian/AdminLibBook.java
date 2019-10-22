package Frames.AdminLibrarian;

import BALClasses.BooksBAL;
import BALClasses.BooksCategoryBAL;
import BeanClasses.Books;
import google.Books.OnlineBookData;
import java.awt.Image;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.MimetypesFileTypeMap;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AdminLibBook extends javax.swing.JInternalFrame {

    BooksBAL booksBAL = new BooksBAL();
    BooksCategoryBAL bcbal = new BooksCategoryBAL();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    boolean isImageOnline = false;
    boolean isManualImg = false;
    private File fileName;
    private Books books = new Books();

    public AdminLibBook() {
        initComponents();
        rdbtnGroup.add(rdTotalBooks);
        rdbtnGroup.add(rdAvailableBooks);
        loadTable(booksBAL.getBooks());
        loadCmbCategory();
        clear();
    }

    private void setTxtData(Books b) {
        try {
            txtBookAuthor.setText(b.getBookAuthorString());
            setCmbCategoryValue(b.getBookCategoryString());
            txtBookName.setText(b.getBookNameString());
            txtBookNumber.setText(String.valueOf(b.getBookNumber()));
            txtBookPublisher.setText(b.getBookPublisherString());
            txtIssueLimit.setText(String.valueOf(b.getBookIssueLimit()));
            Date parse = simpleDateFormat.parse(b.getBookPublishingDate().toString());
            datechPublishingdate.setDate(parse);
            txtLocation.setText(String.valueOf(b.getBookLocation()));
            txtISBN.setText(b.getIsbn());
        } catch (ParseException ex) {
            Logger.getLogger(AdminLibBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadTableAccRdBtn() {
        if (rdTotalBooks.isSelected()) {
            loadTable(booksBAL.getTotalLibraryBooks());
        } else {
            loadTable(booksBAL.getBooks());
        }
    }

    private void setCmbCategoryValue(String category) {
        int itemCount = cmbBookCategory.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (category.equals(cmbBookCategory.getItemAt(i))) {
                cmbBookCategory.setSelectedIndex(i);
                break;
            }
        }
    }

    private void clear() {

        try {
            txtBookAuthor.setText("");
            cmbBookCategory.setSelectedIndex(0);
            txtBookName.setText("");
            txtBookNumber.setText("");
            txtBookNumber.setEditable(true);
            txtBookPublisher.setText("");
            txtIssueLimit.setText("");
            java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
            Date parse = simpleDateFormat.parse(date.toString());
            datechPublishingdate.setDate(parse);
            txtSearch.setText("");
            txtLocation.setText("");
            txtISBN.setText("");
            txtNoOfCopies.setText("1");
            spnPages.setValue(1);
            loadCmbCategory();
            lblPic.setIcon(new ImageIcon(new byte[0]));
        } catch (ParseException ex) {
            Logger.getLogger(AdminLibBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadCmbCategory() {
        ArrayList totalLibraryBooks = bcbal.getBookCategories();
        cmbBookCategory.removeAllItems();
        for (Object object : totalLibraryBooks) {
            cmbBookCategory.addItem(object.toString());
        }
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

    private void loadTblBookDtl(ArrayList<Books> books) {

        DefaultTableModel model = (DefaultTableModel) tblDtlBook.getModel();
        model.setRowCount(0);
        for (Books books1 : books) {
            Vector v = new Vector();
            //v.add(books1.getBookNameString());
//            v.add(books1.getBookAuthorString());
//            v.add(books1.getBookPublisherString());
//            v.add(books1.getBookCategoryString());
//            v.add(books1.getBookPublishingDate());
//            v.add(books1.getBookIssueLimit());
//            v.add(books1.getBookLocation());
            v.add(books1.getBookNumber());
            v.add(books1.getIsbn());
            model.addRow(v);
        }
        tblDtlBook.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdbtnGroup = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        cmbSearchBy = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rdTotalBooks = new javax.swing.JRadioButton();
        rdAvailableBooks = new javax.swing.JRadioButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDtlBook = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBookNumber = new javax.swing.JTextField();
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
        txtLocation = new javax.swing.JTextField();
        cmbBookCategory = new javax.swing.JComboBox<>();
        datechPublishingdate = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        txtNoOfCopies = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        spnPages = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnNewBook = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnImportExcel = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblPic = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuBookCategories = new javax.swing.JMenu();
        menuDownloadExcel = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jPanel1.setBackground(new java.awt.Color(236, 236, 236));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Books", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        cmbSearchBy.setBackground(new java.awt.Color(0, 102, 153));
        cmbSearchBy.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        cmbSearchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ISBN", "Name", "Author", "Category" }));

        txtSearch.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
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

        jSplitPane1.setDividerLocation(700);

        tblDtlBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Number", "ISBN"
            }
        ));
        tblDtlBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDtlBookMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDtlBook);

        jSplitPane1.setRightComponent(jScrollPane2);

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

        jSplitPane1.setLeftComponent(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(rdTotalBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(181, 181, 181)
                .addComponent(rdAvailableBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(129, 129, 129))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSearchBy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(231, 231, 231)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch))
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdTotalBooks)
                    .addComponent(rdAvailableBooks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(236, 236, 236));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Books Detail", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel1.setText("Book Number");

        txtBookNumber.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        txtBookNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBookNumberKeyReleased(evt);
            }
        });

        txtBookName.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel6.setText("Publishing Date");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setText("Book Category");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel2.setText("Book Name");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("Book Author");

        txtBookAuthor.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel7.setText("Issue Limit(Days)");

        txtIssueLimit.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        txtBookPublisher.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("Book Publisher");

        jLabel10.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel10.setText("Location");

        txtLocation.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        cmbBookCategory.setBackground(new java.awt.Color(0, 102, 153));

        datechPublishingdate.setBackground(new java.awt.Color(0, 102, 153));
        datechPublishingdate.setDateFormatString("yyyy-MM-dd");

        jLabel11.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel11.setText("ISBN");

        txtISBN.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        txtISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtISBNKeyReleased(evt);
            }
        });

        txtNoOfCopies.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel12.setText("No: Of Copies");

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        spnPages.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel13.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel13.setText("Pages");

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBookAuthor)
                    .addComponent(txtBookName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBookPublisher)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtISBN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBookNumber, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLocation, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIssueLimit, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datechPublishingdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cmbBookCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNoOfCopies)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnPages)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBookNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(cmbBookCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(datechPublishingdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIssueLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBookPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNoOfCopies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(spnPages, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(btnFind)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(236, 236, 236));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        btnNewBook.setBackground(new java.awt.Color(0, 102, 153));
        btnNewBook.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnNewBook.setForeground(new java.awt.Color(255, 255, 255));
        btnNewBook.setText("Add Book");
        btnNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBookActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 102, 153));
        btnUpdate.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Modify Book");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 102, 153));
        btnDelete.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete Book");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 102, 153));
        btnRefresh.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnImportExcel.setBackground(new java.awt.Color(0, 102, 153));
        btnImportExcel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnImportExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnImportExcel.setText("Import Excel");
        btnImportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNewBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnImportExcel, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNewBook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImportExcel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(236, 236, 236));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 0, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        lblPic.setBackground(new java.awt.Color(255, 255, 255));
        lblPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/administrator.png"))); // NOI18N
        lblPic.setName(""); // NOI18N
        lblPic.setOpaque(true);
        lblPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPicMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        menuBookCategories.setText("Book Categories");
        menuBookCategories.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        menuBookCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBookCategoriesMouseClicked(evt);
            }
        });
        menuBookCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBookCategoriesActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuBookCategories);

        menuDownloadExcel.setText("Download Excel Pattern");
        menuDownloadExcel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        menuDownloadExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDownloadExcelMouseClicked(evt);
            }
        });
        menuDownloadExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDownloadExcelActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuDownloadExcel);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBooksMouseClicked
        int rowNumber = tblBooks.getSelectedRow();
        if (rowNumber >= 0) {
            try {

                String bookNameString = tblBooks.getValueAt(rowNumber, 0).toString();
                String bookAuthorString = tblBooks.getValueAt(rowNumber, 1).toString();
                String bookPublisherString = tblBooks.getValueAt(rowNumber, 2).toString();
                String bookCategoryString = tblBooks.getValueAt(rowNumber, 3).toString();
                String bookPublishingDateString = tblBooks.getValueAt(rowNumber, 4).toString();
                String bookIssueLimitString = tblBooks.getValueAt(rowNumber, 5).toString();
                String bookShelfString = tblBooks.getValueAt(rowNumber, 6).toString();
                String isbn = Optional.ofNullable(tblBooks.getValueAt(rowNumber, 7)).orElse("").toString();
                String noOfCopies = Optional.ofNullable(tblBooks.getValueAt(rowNumber, 8)).orElse("").toString();
                String pages = Optional.ofNullable(tblBooks.getValueAt(rowNumber, 9).toString()).orElse("0");
                byte[] pic = Optional.ofNullable((byte[]) tblBooks.getValueAt(rowNumber, 10)).orElse(new byte[0]);
                ArrayList<Books> availBooks = null;
                if (rdTotalBooks.isSelected()) {
                    availBooks = booksBAL.getTotalLibraryBooks(isbn);
                } else {
                    availBooks = booksBAL.getAvailBooks(isbn);
                }
                loadTblBookDtl(availBooks);
                txtBookAuthor.setText(bookAuthorString);
                setCmbCategoryValue(bookCategoryString);
                txtBookName.setText(bookNameString);
                txtBookPublisher.setText(bookPublisherString);
                txtIssueLimit.setText(bookIssueLimitString);
                Date parse = simpleDateFormat.parse(bookPublishingDateString);
                datechPublishingdate.setDate(parse);
                txtLocation.setText(bookShelfString);
                txtISBN.setText(isbn);
                txtNoOfCopies.setText(noOfCopies);
                spnPages.setValue(Integer.valueOf(pages));
                ImageIcon imageIcon = new ImageIcon(pic);
                Image image = imageIcon.getImage();
                Image scaledInstance = image.getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH);
                imageIcon.setImage(scaledInstance);
                lblPic.setIcon(imageIcon);
            } catch (ParseException ex) {
                Logger.getLogger(AdminLibBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblBooksMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

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
//        try {
//            org.apache.commons.io.FileUtils.copyURLToFile(new URL("http://books.google.com/books/content?id=hqKfQwAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"), new File("im.jpg"));
//        } catch (IOException  ex) {
//            Logger.getLogger(AdminLibBook.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void rdTotalBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTotalBooksActionPerformed
        loadTable(booksBAL.getTotalLibraryBooks());
    }//GEN-LAST:event_rdTotalBooksActionPerformed

    private void rdAvailableBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAvailableBooksActionPerformed
        loadTable(booksBAL.getBooks());
    }//GEN-LAST:event_rdAvailableBooksActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblBooks.getSelectedRow();
        if (txtBookNumber.getText().length() > 0) {
            if (booksBAL.isAvailable(txtBookNumber.getText())) {
                int bookNumber = Integer.parseInt(txtBookNumber.getText());
                booksBAL.deleteBook(bookNumber);
                loadTableAccRdBtn();
                ((DefaultTableModel) tblDtlBook.getModel()).setRowCount(0);
                clear();
            } else {
                JOptionPane.showMessageDialog(rootPane, "This Book Is not In Library");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Enter Book Number");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        clear();
        loadTableAccRdBtn();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private byte[] getImage() {
        byte[] img = new byte[0];
        if (isImageOnline) {
            img = books.getPic();
        }
        if (isManualImg) {
            try {
                FileInputStream is = new FileInputStream(fileName);
                img = new byte[is.available()];
                is.read(img);
            } catch (IOException ex) {
                Logger.getLogger(AdminLibBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return img;
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        if (booksBAL.isISBNAvailable(txtISBN.getText())) {
            java.sql.Date date = new java.sql.Date(datechPublishingdate.getDate().getTime());
            byte[] img = getImage();

            Books books = new Books(0, txtLocation.getText(), Integer.parseInt(txtIssueLimit.getText()), txtBookName.getText(), txtBookAuthor.getText(), cmbBookCategory.getSelectedItem().toString(), txtBookPublisher.getText(), date, txtISBN.getText(), Integer.valueOf(spnPages.getValue().toString()), img);
            booksBAL.updateBook(books);
            clear();
            loadTableAccRdBtn();
        } else {
            JOptionPane.showMessageDialog(rootPane, "You can/'t Modify.This Book is not present In Library");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBookActionPerformed
        //if (!booksBAL.isISBNAvailable(txtISBN.getText())) {
            int noOfCopies = Integer.valueOf(txtNoOfCopies.getText());
            java.sql.Date date = new java.sql.Date(datechPublishingdate.getDate().getTime());
            byte[] img = getImage();
            Books books = new Books(0, txtLocation.getText(), Integer.parseInt(txtIssueLimit.getText()), txtBookName.getText(), txtBookAuthor.getText(), cmbBookCategory.getSelectedItem().toString(), txtBookPublisher.getText(), date, txtISBN.getText(), Integer.valueOf(spnPages.getValue().toString()), img);
            for (int i = 0; i < noOfCopies; i++) {
                booksBAL.addBook(books);
            }
            JOptionPane.showMessageDialog(null, "New Book Inserted Successfully");
            clear();
            loadTableAccRdBtn();
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "You can/'t Add New Book.This Book is Already present In Library");
//        }
    }//GEN-LAST:event_btnNewBookActionPerformed

    private void txtBookNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBookNumberKeyReleased
        String bookNmber = txtBookNumber.getText();
        if (booksBAL.isAvailable(bookNmber)) {
            Books books = booksBAL.getBooks(bookNmber);
            setTxtData(books);
        }
    }//GEN-LAST:event_txtBookNumberKeyReleased

    private void txtISBNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtISBNKeyReleased
        String isbn = txtISBN.getText().trim();
        ArrayList<Books> totalLibraryBooks = booksBAL.getTotalLibraryBooks(isbn);
        if (totalLibraryBooks.size() > 0) {
            Books book = totalLibraryBooks.get(0);
            txtBookAuthor.setText(book.getBookAuthorString());
            setCmbCategoryValue(book.getBookCategoryString());
            txtBookName.setText(book.getBookNameString());
            txtBookPublisher.setText(book.getBookPublisherString());
            txtIssueLimit.setText(book.getBookIssueLimit() + "");
            Date parse = book.getBookPublishingDate();
            datechPublishingdate.setDate(parse);
            txtLocation.setText(book.getBookLocation());
            txtISBN.setText(isbn);
        }
    }//GEN-LAST:event_txtISBNKeyReleased

    private void tblDtlBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDtlBookMouseClicked
        int row = tblDtlBook.getSelectedRow();
        if (row >= 0) {
            String bookNumber = tblDtlBook.getValueAt(row, 0).toString();
            txtBookNumber.setText(bookNumber);
        }
    }//GEN-LAST:event_tblDtlBookMouseClicked

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String isbn = txtISBN.getText();
        isbn = isbn.trim();
        if (isbn.length() == 10) {
            isbn = "978" + isbn;
        }
        try {
            Books book = new OnlineBookData().setJsonData(Long.valueOf(isbn));
            this.books = book;
            txtBookAuthor.setText(book.getBookAuthorString());
            txtBookName.setText(book.getBookNameString());
            txtBookPublisher.setText(book.getBookPublisherString());
            Date parse = book.getBookPublishingDate();
            datechPublishingdate.setDate(parse);
            spnPages.setValue(book.getPages());
            lblPic.setIcon(new ImageIcon(book.getPic()));
            isImageOnline = true;
            isManualImg = false;
        } catch (MalformedURLException ex) {
            Logger.getLogger(AdminLibBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void lblPicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPicMouseClicked

        File f = null;

        String filePathsString = "";
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(new FileNameExtensionFilter("Select Image", "PNG", "JPEG"));
        int showOpenDialog = chooser.showOpenDialog(this);
        f = chooser.getSelectedFile();
        if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
            fileName = f;
            filePathsString = f.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(filePathsString).getImage().getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_DEFAULT));
            lblPic.setIcon(imageIcon);
            isImageOnline = false;
            isManualImg = true;
        } else {
            JOptionPane.showInternalMessageDialog(rootPane, "You haven't selected any image");
        }
    }//GEN-LAST:event_lblPicMouseClicked

    private void btnImportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportExcelActionPerformed

        List<Books> bsList = new LinkedList<>();
        File f = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Choose xlsx", "xlsx"));
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.showOpenDialog(null);
        f = chooser.getSelectedFile();
        try {
            if (f != null) {

                Workbook workbook = WorkbookFactory.create(new FileInputStream(f));
                Sheet sheet = workbook.getSheetAt(0);
                int firstRowNum = sheet.getFirstRowNum();
                int lastRowNum = sheet.getLastRowNum();
                for (int i = firstRowNum; i <= lastRowNum; i++) {
                    Row row = sheet.getRow(i);

                    if (i == 0) {
                        for (int j = 0; j < row.getLastCellNum(); j++) {
                            String value = row.getCell(j).getStringCellValue();
                            int index = 0;
                            if (index++ == j && !value.equals("Accession No")) {
                                throw new RuntimeException("Accession No Not Found");
                            } else if (index++ == j && !value.equals("Location")) {
                                throw new RuntimeException("Location");
                            } else if (index++ == j && !value.equals("issue limit")) {
                                throw new RuntimeException("issue limit");
                            } else if (index++ == j && !value.equals("title")) {
                                throw new RuntimeException("title");
                            } else if (index++ == j && !value.equals("author")) {
                                throw new RuntimeException("author");
                            } else if (index++ == j && !value.equals("category")) {
                                throw new RuntimeException("category");
                            } else if (index++ == j && !value.equals("publisher")) {
                                throw new RuntimeException("publisher");
                            } else if (index++ == j && !value.equals("publishing date")) {
                                throw new RuntimeException("publishing date");
                            } else if (index++ == j && !value.equals("isbn")) {
                                throw new RuntimeException("isbn");
                            } else if (index++ == j && !value.equals("pages")) {
                                throw new RuntimeException("pages");
                            }
                        }
                    } else {
                        int accessionNo = (int) row.getCell(0).getNumericCellValue();
                        String locString = row.getCell(1).getStringCellValue();
                        int issueLimit = (int) row.getCell(2).getNumericCellValue();
                        String title = row.getCell(3).getStringCellValue();
                        String author = row.getCell(4).getStringCellValue();
                        String category = row.getCell(5).getStringCellValue();
                        String publisher = row.getCell(6).getStringCellValue();
                        Date publishingDate = row.getCell(7).getDateCellValue();
                        double isbn = row.getCell(8).getNumericCellValue();
                        int pages = (int) row.getCell(9).getNumericCellValue();
                        Books book = new Books(accessionNo, locString, issueLimit, title, author, category, publisher, new java.sql.Date(publishingDate.getTime()), String.valueOf(isbn), pages, null);
                        bsList.add(book);
                    }
                }
                bsList.forEach((bk) -> {
                    booksBAL.addBook(bk);
                });
                System.out.println("Books Inserted Successfully");
            }
        } catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(AdminLibBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImportExcelActionPerformed

    private void menuBookCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBookCategoriesActionPerformed

    }//GEN-LAST:event_menuBookCategoriesActionPerformed

    private void menuBookCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBookCategoriesMouseClicked
        BooksCategories booksCategories = new BooksCategories();
        booksCategories.setVisible(true);
    }//GEN-LAST:event_menuBookCategoriesMouseClicked

    private void menuDownloadExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDownloadExcelMouseClicked
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogType(JFileChooser.SAVE_DIALOG);
        int showSaveDialog = jfc.showSaveDialog(this);
        if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
            String name = jfc.getSelectedFile().getAbsolutePath() + ".xlsx";
            try {
                FileUtils.copyFile(new File("book excel pattern.xlsx"), new File(name));
            } catch (IOException ex) {
                Logger.getLogger(AdminLibBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_menuDownloadExcelMouseClicked

    private void menuDownloadExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDownloadExcelActionPerformed

    }//GEN-LAST:event_menuDownloadExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnImportExcel;
    private javax.swing.JButton btnNewBook;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbBookCategory;
    private javax.swing.JComboBox<String> cmbSearchBy;
    private com.toedter.calendar.JDateChooser datechPublishingdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblPic;
    private javax.swing.JMenu menuBookCategories;
    private javax.swing.JMenu menuDownloadExcel;
    private javax.swing.JRadioButton rdAvailableBooks;
    private javax.swing.JRadioButton rdTotalBooks;
    private javax.swing.ButtonGroup rdbtnGroup;
    private javax.swing.JSpinner spnPages;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTable tblDtlBook;
    private javax.swing.JTextField txtBookAuthor;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtBookNumber;
    private javax.swing.JTextField txtBookPublisher;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtIssueLimit;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtNoOfCopies;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
