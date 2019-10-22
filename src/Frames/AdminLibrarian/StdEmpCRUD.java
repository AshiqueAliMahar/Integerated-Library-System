package Frames.AdminLibrarian;

import BALClasses.DepartmentBAL;
import BALClasses.GeneralBAL;
import BALClasses.StdEmpPostBAL;
import BALClasses.StudentTeacherBAL;
import BeanClasses.Department;
import BeanClasses.StdEmployeePosts;
import BeanClasses.StudentTeacher;
import BeanClasses.StudentTeacherChild;
import Frames.AdminLibrarian.reports.Reports;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class StdEmpCRUD extends javax.swing.JInternalFrame {

    private File fileName;

    StdEmpPostBAL stdEmpPostBAL = new StdEmpPostBAL();
    StdEmployeePosts stdEmployeePosts = new StdEmployeePosts();
    Department department = new Department();
    DepartmentBAL departmentBAL = new DepartmentBAL();
    StudentTeacher studentTeacher = new StudentTeacher();
    StudentTeacherBAL stbal = new StudentTeacherBAL();
    GeneralBAL generalBAL = new GeneralBAL();
    List<StudentTeacher> studentTeachers =new LinkedList<>();
    public StdEmpCRUD() {
        initComponents();
        setBtnGroup();
        loadCmbDeptt();
        loadCmbPost();
        loadTable();
    }

    private void setBtnGroup() {
        btnGroup.add(rdBtnFemale);
        btnGroup.add(rdBtnMale);
        btnGroup.add(rdBtnOther);
    }

    private String getGender() {
        String gender;
        if (rdBtnFemale.isSelected()) {
            gender = "Female";
        } else if (rdBtnMale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Other";
        }
        return gender;
    }

    private void setGender(String gender) {

        if (gender.equals(rdBtnMale.getText())) {
            rdBtnMale.setSelected(true);
        } else if (gender.equals(rdBtnFemale.getText())) {
            rdBtnFemale.setSelected(true);
        } else {
            rdBtnOther.setSelected(true);
        }
    }

    private void setCmbPost(String post, JComboBox cmbBox) {
        for (int i = 0; i < cmbBox.getItemCount(); i++) {
            if (cmbBox.getItemAt(i).toString().equals(post)) {
                cmbBox.setSelectedIndex(i);
                break;
            }
        }
    }

    private void loadTable() {
        studentTeachers = stbal.getStdTeacher();
        DefaultTableModel dtm = (DefaultTableModel) tblStdEmp.getModel();
        dtm.setRowCount(0);
        for (StudentTeacher st : studentTeachers) {
            Vector v = new Vector();
            v.add(st.getIdString());
            v.add(st.getNameString());
            v.add(st.getEmailString());
            v.add(st.getAddressString());
            v.add(st.getPostString());
            v.add(st.getGenderString());
            v.add(st.getDepartmentName());
            v.add(st.getContactNoString());
            v.add(st.getCNICString());
            v.add(st.getDateOfBirthDate());
            v.add(st.getDateOfAdmission());
            dtm.addRow(v);
        }
        tblStdEmp.setModel(dtm);
    }
    private void loadTable(List<StudentTeacher> stdTeacher) {
        DefaultTableModel dtm = (DefaultTableModel) tblStdEmp.getModel();
        dtm.setRowCount(0);
        for (StudentTeacher st : stdTeacher) {
            Vector v = new Vector();
            v.add(st.getIdString());
            v.add(st.getNameString());
            v.add(st.getEmailString());
            v.add(st.getAddressString());
            v.add(st.getPostString());
            v.add(st.getGenderString());
            v.add(st.getDepartmentName());
            v.add(st.getContactNoString());
            v.add(st.getCNICString());
            v.add(st.getDateOfBirthDate());
            v.add(st.getDateOfAdmission());
            dtm.addRow(v);
        }
        tblStdEmp.setModel(dtm);
    }
    private void loadCmbPost() {
        ArrayList<StdEmployeePosts> stdEmpPosts = stdEmpPostBAL.getPost();
        cmbPosts.removeAllItems();
        for (StdEmployeePosts object : stdEmpPosts) {
            cmbPosts.addItem(object);
        }
    }

    private void loadCmbDeptt() {
        ArrayList<Department> allDeptt = departmentBAL.getDeptt();
        cmbDeptt.removeAllItems();
        for (Department object : allDeptt) {
            cmbDeptt.addItem(object);
        }
    }

    private void refresh() {
        loadCmbPost();
        loadCmbDeptt();
        loadTable();
        txtAddress.setText("");
        txtCNIC.setText("");
        txtContact.setText("");
        txtEmail.setText("");
        txtId.setText("");
        txtName.setText("");
        pwd.setText("");
        pwd1.setText("");
        dtDOB.setDate(new java.sql.Date(new java.util.Date().getTime()));
        dtDateOfAdm.setDate(new java.sql.Date(new java.util.Date().getTime()));
        cmbDeptt.setSelectedIndex(0);
        cmbPosts.setSelectedIndex(0);
        rdBtnMale.setSelected(true);
        lblPic.setText("");
        lblPic.setIcon(null);
        
    }

    private boolean isAvailStdEmp(String id) {
        boolean check = false;
        studentTeacher = stbal.getStudentTeacher(id);
        try {
            if (studentTeacher.getIdString().equals(id)) {
                check = true;
            }
        } catch (NullPointerException ex) {
            check = false;
        }
        return check;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        btnGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        lblPic = new javax.swing.JLabel();
        btnAttachImage = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtAddress = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtCNIC = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblDOA = new javax.swing.JLabel();
        rdBtnMale = new javax.swing.JRadioButton();
        rdBtnFemale = new javax.swing.JRadioButton();
        rdBtnOther = new javax.swing.JRadioButton();
        pwd = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        dtDOB = new com.toedter.calendar.JDateChooser();
        dtDateOfAdm = new com.toedter.calendar.JDateChooser();
        cmbDeptt = new javax.swing.JComboBox();
        pwd1 = new javax.swing.JPasswordField();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cmbPosts = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStdEmp = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        cmbSearchBy = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnExportExcel = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuOccupation = new javax.swing.JMenu();
        mnuDepartments = new javax.swing.JMenu();
        mnuDownloadExcelPattern = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jPanel2.setBackground(new java.awt.Color(236, 236, 236));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operations", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        lblPic.setBackground(new java.awt.Color(0, 153, 0));
        lblPic.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        lblPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnAttachImage.setBackground(new java.awt.Color(0, 102, 153));
        btnAttachImage.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnAttachImage.setForeground(new java.awt.Color(255, 255, 255));
        btnAttachImage.setText("ATTACH IMAGE");
        btnAttachImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttachImageActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 102, 153));
        btnAdd.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 102, 153));
        btnRefresh.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 102, 153));
        btnDelete.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnImport.setBackground(new java.awt.Color(0, 102, 153));
        btnImport.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnImport.setForeground(new java.awt.Color(255, 255, 255));
        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnAttachImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(lblPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAttachImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnImport))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(236, 236, 236));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "My Account", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        txtAddress.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        txtContact.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        txtId.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        txtName.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        txtCNIC.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel1.setText("Id");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setText("CNIC No");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel6.setText("Date Of Birth");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel7.setText("Contact");

        jLabel8.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel8.setText("Address");

        jLabel10.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel10.setText("Deptt: Name");

        jLabel11.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel11.setText("Gender");

        jLabel12.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel12.setText("Post");

        lblDOA.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        lblDOA.setText("Date of Appointment");

        rdBtnMale.setBackground(new java.awt.Color(255, 255, 255));
        rdBtnMale.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        rdBtnMale.setSelected(true);
        rdBtnMale.setText("Male");
        rdBtnMale.setContentAreaFilled(false);
        rdBtnMale.setFocusPainted(false);
        rdBtnMale.setFocusable(false);

        rdBtnFemale.setBackground(new java.awt.Color(255, 255, 255));
        rdBtnFemale.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        rdBtnFemale.setText("Female");
        rdBtnFemale.setContentAreaFilled(false);
        rdBtnFemale.setFocusPainted(false);
        rdBtnFemale.setFocusable(false);

        rdBtnOther.setBackground(new java.awt.Color(255, 255, 255));
        rdBtnOther.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        rdBtnOther.setText("Other");
        rdBtnOther.setContentAreaFilled(false);
        rdBtnOther.setFocusPainted(false);
        rdBtnOther.setFocusable(false);

        pwd.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/showPassword.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });

        dtDOB.setBackground(new java.awt.Color(255, 255, 255));
        dtDOB.setDateFormatString("yyyy-MM-dd");

        dtDateOfAdm.setBackground(new java.awt.Color(255, 255, 255));
        dtDateOfAdm.setDateFormatString("yyyy-MM-dd");

        cmbDeptt.setBackground(new java.awt.Color(255, 255, 255));

        pwd1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/showPassword.png"))); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel9.setText("Confirm");

        cmbPosts.setBackground(new java.awt.Color(255, 255, 255));
        cmbPosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPostsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtName)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pwd, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCNIC)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pwd1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtContact)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12)
                        .addComponent(lblDOA)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtDateOfAdm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addComponent(cmbPosts, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdBtnOther, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(rdBtnMale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdBtnFemale))
                    .addComponent(cmbDeptt, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10)
                    .addComponent(cmbDeptt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11)
                    .addComponent(rdBtnMale)
                    .addComponent(rdBtnFemale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(rdBtnOther))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel12)
                        .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbPosts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pwd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblDOA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dtDateOfAdm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtCNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(236, 236, 236));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Students", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        tblStdEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Email", "Address", "Post", "Gender", "Department ", "Contact No", "CNIC No", "Date Of Birth", "Date Of Admission/Appointment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStdEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStdEmpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStdEmp);

        jLabel13.setText("Search By:");

        cmbSearchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Name", "Post", "Email", "Gender", "Dept_Name", "CNIC" }));

        jLabel14.setText("Search Text:");

        txtSearch.setName("searchText"); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnExportExcel.setBackground(new java.awt.Color(0, 102, 153));
        btnExportExcel.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnExportExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExportExcel.setText("Export Excel");
        btnExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSearchBy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnExportExcel)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExportExcel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 102, 0));
        jMenuBar1.setForeground(new java.awt.Color(0, 102, 0));

        mnuOccupation.setBackground(new java.awt.Color(255, 255, 255));
        mnuOccupation.setForeground(new java.awt.Color(255, 0, 0));
        mnuOccupation.setText("Occupation");
        mnuOccupation.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        mnuOccupation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuOccupationMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuOccupation);

        mnuDepartments.setBackground(new java.awt.Color(255, 255, 255));
        mnuDepartments.setForeground(new java.awt.Color(255, 0, 0));
        mnuDepartments.setText("Departments");
        mnuDepartments.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        mnuDepartments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuDepartmentsMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuDepartments);

        mnuDownloadExcelPattern.setBackground(new java.awt.Color(255, 255, 255));
        mnuDownloadExcelPattern.setForeground(new java.awt.Color(255, 0, 0));
        mnuDownloadExcelPattern.setText("Download Excel Pattern");
        mnuDownloadExcelPattern.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        mnuDownloadExcelPattern.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuDownloadExcelPatternMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuDownloadExcelPattern);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAttachImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttachImageActionPerformed
        File f = null;
        String filePathsString = "";
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        f = chooser.getSelectedFile();
        fileName = f;
        filePathsString = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filePathsString).getImage().getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_DEFAULT));
        lblPic.setText("");
        lblPic.setIcon(imageIcon);
    }//GEN-LAST:event_btnAttachImageActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        File f = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Choose xlsx", "xlsx"));
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.showOpenDialog(null);
        f = chooser.getSelectedFile();
        if (f != null) {
            try {
                Workbook workbook = WorkbookFactory.create(new FileInputStream(f));
                Sheet sheet = workbook.getSheetAt(0);
                Row row = sheet.getRow(0);
                int count = 0;
                boolean checkHeading = row.getCell(count++).getStringCellValue().equals("id") && row.getCell(count++).getStringCellValue().equals("name") && row.getCell(count++).getStringCellValue().equals("email") && row.getCell(count++).getStringCellValue().equals("password") && row.getCell(count++).getStringCellValue().equals("cnic") && row.getCell(count++).getStringCellValue().equals("date of birth") && row.getCell(count++).getStringCellValue().equals("contact no") && row.getCell(count++).getStringCellValue().equals("address") && row.getCell(count++).getStringCellValue().equals("date of admission") && row.getCell(count++).getStringCellValue().equals("department") && row.getCell(count++).getStringCellValue().equals("gender") && row.getCell(count++).getStringCellValue().equals("post") && row.getCell(count++).getStringCellValue().equals("details");

                if (checkHeading) {
                    int failed=0;
                    int passed=0;
                    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                        count = 0;
                        row = sheet.getRow(i);
                        String id = checkNumStr(row.getCell(count++));
                        String name = checkNumStr(row.getCell(count++));
                        String email = checkNumStr(row.getCell(count++));
                        String password = checkNumStr(row.getCell(count++));
                        String cnic = checkNumStr(row.getCell(count++));
                        Date dateOfBirth = row.getCell(count++).getDateCellValue();
                        String contactNumber = checkNumStr(row.getCell(count++));
                        String address = checkNumStr(row.getCell(count++));
                        Date dateOfAdmission = row.getCell(count++).getDateCellValue();
                        String department = checkNumStr(row.getCell(count++));
                        String gender = checkNumStr(row.getCell(count++));
                        String post = checkNumStr(row.getCell(count++));
                        String details = checkNumStr(row.getCell(count++));
                        
                        boolean insertStdEmp = stbal.insertStdEmp(new StudentTeacherChild(null,id, name, email, password, cnic, new java.sql.Date(dateOfBirth.getTime()), contactNumber, address, new java.sql.Date(dateOfAdmission.getTime()), null, department, gender, post, details));
                        if (insertStdEmp) {
                            passed++;
                        }else{
                            failed++;
                        }
                    }
                    JOptionPane.showMessageDialog(rootPane, passed+" PATRONS INSERTED SUCCESSFULLY & "+failed+" Patrons Insertion Failed" );
                    loadTable();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Download Excel Pattern Put data carefully");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(StdEmpCRUD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | InvalidFormatException ex) {
                Logger.getLogger(StdEmpCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("File Not Selected");
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        pwd.setEchoChar((char) 0);
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        pwd.setEchoChar('*');
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        pwd1.setEchoChar((char) 0);
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
        pwd1.setEchoChar('*');
    }//GEN-LAST:event_jButton4MouseReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (!isAvailStdEmp(txtId.getText())) {

            java.sql.Date DOA = new java.sql.Date(dtDateOfAdm.getDate().getTime());
            java.sql.Date DOB = new java.sql.Date(dtDOB.getDate().getTime());

            StudentTeacherChild stc = new StudentTeacherChild();

            stc.setIdString(txtId.getText());
            stc.setNameString(txtName.getText());
            stc.setAddressString(txtAddress.getText());
            stc.setCNICString(txtCNIC.getText());
            stc.setEmailString(txtEmail.getText());
            stc.setPaswordString(pwd.getText());
            stc.setDepartmentName(cmbDeptt.getSelectedItem().toString());
            stc.setGenderString(getGender());
            stc.setPostString(cmbPosts.getSelectedItem().toString());
            stc.setDateOfAdmission(DOA);
            stc.setDateOfBirthDate(DOB);
            stc.setContactNoString(txtContact.getText());
            stc.setPicFile(fileName);

            if (generalBAL.isEmailCorrect(txtEmail.getText())) {
                if (pwd.getText().equals(pwd1.getText()) && pwd.getText().length() > 0) {
                    stbal.insertStdEmp(stc);
                    loadTable();
                    refresh();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Password Is Not Matching And Password Should Not be Empty");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Email is Not Correct");
            }
        } else if (isAvailStdEmp(txtId.getText())) {

            java.sql.Date DOA = new java.sql.Date(dtDateOfAdm.getDate().getTime());
            java.sql.Date DOB = new java.sql.Date(dtDOB.getDate().getTime());

            StudentTeacherChild stc = new StudentTeacherChild();

            stc.setIdString(txtId.getText());
            stc.setNameString(txtName.getText());
            stc.setAddressString(txtAddress.getText());
            stc.setCNICString(txtCNIC.getText());
            stc.setEmailString(txtEmail.getText());
            stc.setPaswordString(pwd.getText());
            stc.setDepartmentName(cmbDeptt.getSelectedItem().toString());
            stc.setGenderString(getGender());
            stc.setPostString(cmbPosts.getSelectedItem().toString());
            stc.setDateOfAdmission(DOA);
            stc.setDateOfBirthDate(DOB);
            stc.setContactNoString(txtContact.getText());
            stc.setPicFile(fileName);

            if (generalBAL.isEmailCorrect(txtEmail.getText())) {

                if (fileName == null) {
                    stbal.setStdTchrDetail(stc);
                } else {
                    stbal.setStdTchrDetail(stc, fileName);
                }
                loadTable();
                refresh();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Email is Not Correct");
            }
        }
//        else {
//            JOptionPane.showMessageDialog(rootPane, "Add Record First");
//        }
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "This Is Already There");
//        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String id = txtId.getText();
        if (isAvailStdEmp(id)) {
            stbal.deleteStdEmp(id);
            loadTable();
            refresh();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Person with that Id Is Not There");
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void mnuOccupationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuOccupationMouseClicked

        Occupations occupations = new Occupations();
        if (!occupations.isVisible()) {
            occupations.setVisible(true);
        }
    }//GEN-LAST:event_mnuOccupationMouseClicked

    private void mnuDepartmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuDepartmentsMouseClicked

        Departments departments = new Departments();
        departments.setVisible(true);

    }//GEN-LAST:event_mnuDepartmentsMouseClicked

    private void tblStdEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStdEmpMouseClicked

        int row = tblStdEmp.getSelectedRow();
        if (row >= 0) {
            if (tblStdEmp.getValueAt(row, 4).toString().equalsIgnoreCase("student")) {
                lblDOA.setText("Date Of Admission");
            } else {
                lblDOA.setText("Date Of Appointment");
            }
            String id = tblStdEmp.getValueAt(row, 0).toString();
            txtId.setText(id);
            txtName.setText(tblStdEmp.getValueAt(row, 1).toString());
            txtEmail.setText(tblStdEmp.getValueAt(row, 2).toString());
            txtAddress.setText(tblStdEmp.getValueAt(row, 3).toString());
            setCmbPost(tblStdEmp.getValueAt(row, 4).toString(), cmbPosts);
            setGender(tblStdEmp.getValueAt(row, 5).toString());
            setCmbPost(tblStdEmp.getValueAt(row, 6).toString(), cmbDeptt);
            txtContact.setText(tblStdEmp.getValueAt(row, 7).toString());
            txtCNIC.setText(tblStdEmp.getValueAt(row, 8).toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            StudentTeacher studentTeacher1 = stbal.getStudentTeacher(id);

            if (studentTeacher1.getPicBlob() != null) {
                ImageIcon imageIcon = generalBAL.getImageIcon(studentTeacher1.getPicBlob());
                lblPic.setText("");
                lblPic.setIcon(imageIcon);
            } else {
                lblPic.setText("Not Found");
                lblPic.setIcon(null);
            }

            try {
                dtDOB.setDate(new java.sql.Date(sdf.parse(tblStdEmp.getValueAt(row, 9).toString()).getTime()));
                dtDateOfAdm.setDate(new java.sql.Date(sdf.parse(tblStdEmp.getValueAt(row, 10).toString()).getTime()));

            } catch (ParseException ex) {
                Logger.getLogger(StdEmpCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblStdEmpMouseClicked

    private void cmbPostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPostsActionPerformed
        if (cmbPosts.getSelectedIndex()>-1 && cmbPosts.getSelectedItem().toString().equalsIgnoreCase("student")) {
            lblDOA.setText("Date Of Admission");
        } else {
            lblDOA.setText("Date Of Appointment");
        }
    }//GEN-LAST:event_cmbPostsActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchString = txtSearch.getText();
        if (searchString.length()>0) {
            String searchBy = cmbSearchBy.getSelectedItem().toString();
            studentTeachers = stbal.findByFieldName(searchBy, searchString);
            loadTable(studentTeachers);
        }else loadTable();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed
        Workbook workbook=new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row = sheet.createRow(0);
        int count=0;
        row.createCell(count++).setCellValue("ID");
        row.createCell(count++).setCellValue("Name");
        row.createCell(count++).setCellValue("Email");
        row.createCell(count++).setCellValue("Address");
        row.createCell(count++).setCellValue("Post");
        row.createCell(count++).setCellValue("Gender");
        row.createCell(count++).setCellValue("Department");
        row.createCell(count++).setCellValue("Contact No");
        row.createCell(count++).setCellValue("CNIC No");
        row.createCell(count++).setCellValue("Date of Birth");
        row.createCell(count++).setCellValue("Date Of Admission/Appointment");
        row.createCell(count++).setCellValue("Pic");
        int rowCount=1;
        for (StudentTeacher studentTeacher : studentTeachers) {
            count=0;
            row=sheet.createRow(rowCount++);
            row.createCell(count++).setCellValue(studentTeacher.getIdString()+"");
            row.createCell(count++).setCellValue(studentTeacher.getNameString()+"");
            row.createCell(count++).setCellValue(studentTeacher.getEmailString()+"");
            row.createCell(count++).setCellValue(studentTeacher.getAddressString()+"");
            row.createCell(count++).setCellValue(studentTeacher.getPostString()+"");
            row.createCell(count++).setCellValue(studentTeacher.getGenderString()+"");
            row.createCell(count++).setCellValue(studentTeacher.getDepartmentName()+"");
            row.createCell(count++).setCellValue(studentTeacher.getContactNoString()+"");
            row.createCell(count++).setCellValue(studentTeacher.getCNICString()+"");
            row.createCell(count++).setCellValue(studentTeacher.getDateOfBirthDate()+"");
            row.createCell(count++).setCellValue(studentTeacher.getDateOfAdmission()+"");
            
            if (studentTeacher.getPicBlob()!=null) {
                int addPicture = workbook.addPicture(studentTeacher.getPicBlob(), Workbook.PICTURE_TYPE_JPEG);
                HSSFPatriarch createDrawingPatriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();
                
                HSSFClientAnchor hssfClientAnchor = new HSSFClientAnchor();
                hssfClientAnchor.setAnchor((short)count, rowCount-1, 1, 1, (short)(count+1), rowCount, 2, 2);
                
                HSSFPicture createPicture = createDrawingPatriarch.createPicture(hssfClientAnchor, addPicture);
            }
            
        }
        try {
            String path = Reports.getPathForSave();
            if (!path.equals("")) workbook.write(new FileOutputStream(path));
            else JOptionPane.showMessageDialog(rootPane, "Save Failed");
        } catch (IOException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportExcelActionPerformed

    private void mnuDownloadExcelPatternMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuDownloadExcelPatternMouseClicked
        JFileChooser jfc=new JFileChooser();
        jfc.setDialogType(JFileChooser.SAVE_DIALOG);
        int showSaveDialog = jfc.showSaveDialog(this);
        if (showSaveDialog==JFileChooser.APPROVE_OPTION) {
            String name = jfc.getSelectedFile().getAbsolutePath()+".xlsx";
            try {
                FileUtils.copyFile(new File("Patron Pattern.xlsx"), new File(name));
            } catch (IOException ex) {
                Logger.getLogger(AdminLibBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuDownloadExcelPatternMouseClicked
    
    private String checkNumStr(Cell cell) {
        String resultString = "";
        switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_NUMERIC:
                resultString = String.valueOf((long)cell.getNumericCellValue());
                break;
            case XSSFCell.CELL_TYPE_STRING:
                resultString = cell.getStringCellValue();
                break;
        }
        return resultString;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAttachImage;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExportExcel;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox cmbDeptt;
    private javax.swing.JComboBox cmbPosts;
    private javax.swing.JComboBox<String> cmbSearchBy;
    private com.toedter.calendar.JDateChooser dtDOB;
    private com.toedter.calendar.JDateChooser dtDateOfAdm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDOA;
    private javax.swing.JLabel lblPic;
    private javax.swing.JMenu mnuDepartments;
    private javax.swing.JMenu mnuDownloadExcelPattern;
    private javax.swing.JMenu mnuOccupation;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JPasswordField pwd1;
    private javax.swing.JRadioButton rdBtnFemale;
    private javax.swing.JRadioButton rdBtnMale;
    private javax.swing.JRadioButton rdBtnOther;
    private javax.swing.JTable tblStdEmp;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCNIC;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
