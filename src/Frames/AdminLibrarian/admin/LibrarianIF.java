package Frames.AdminLibrarian.admin;

import BALClasses.GeneralBAL;
import BALClasses.LibrarianBAL;
import BeanClasses.Librarian;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.springframework.util.FileCopyUtils;

public class LibrarianIF extends javax.swing.JInternalFrame {

    LibrarianBAL lbal = new LibrarianBAL();
    byte[] image = new byte[0];

    public LibrarianIF() {
        initComponents();
        loadTable();
        btnGroup.add(rdBtnFemale);
        btnGroup.add(rdBtnMale);
    }

    private void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblLibrarians.getModel();
        dtm.setRowCount(0);
        List<Librarian> librarians = lbal.getLibrarians(Librarian.LibrarianRoles.Librarian.toString());
        librarians.forEach(lib -> {
            Object[] objects = {lib.getLibId(), lib.getLibName(), lib.getLibPassword(), lib.getLibCNIC(), lib.getLibAddress(), lib.getLibContactNo(), lib.getLibEmail(), lib.getGender()};
            dtm.addRow(objects);
        });
        tblLibrarians.setModel(dtm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibrarians = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNic = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rdBtnMale = new javax.swing.JRadioButton();
        rdBtnFemale = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        lblPic = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnDereserve1 = new javax.swing.JButton();
        btnDereserve2 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Librarians", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        tblLibrarians.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Password", "CNIC", "Address", "Contact No", "Email", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLibrarians.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibrariansMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLibrarians);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 12), new java.awt.Color(111, 178, 70))); // NOI18N

        jLabel1.setText("ID*");

        jLabel2.setText("Name*");

        jLabel3.setText("Password*");

        jLabel4.setText("CNIC*");

        jLabel5.setText("Address*");

        jLabel6.setText("Contact No*");

        jLabel7.setText("Email*");

        jLabel8.setText("Gender*");

        rdBtnMale.setSelected(true);
        rdBtnMale.setText("Male");

        rdBtnFemale.setText("Female");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(txtID)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNic)
                            .addComponent(txtPassword))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddress)
                    .addComponent(txtEmail)
                    .addComponent(txtContactNo)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdBtnMale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdBtnFemale)
                        .addGap(0, 172, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdBtnMale, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdBtnFemale, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 12), new java.awt.Color(111, 178, 70))); // NOI18N

        lblPic.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblPic.setText("NOT FOUND");
        lblPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPicMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnSave.setBackground(new java.awt.Color(0, 102, 153));
        btnSave.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDereserve1.setBackground(new java.awt.Color(0, 102, 153));
        btnDereserve1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnDereserve1.setForeground(new java.awt.Color(255, 255, 255));
        btnDereserve1.setText("DELETE");
        btnDereserve1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDereserve1ActionPerformed(evt);
            }
        });

        btnDereserve2.setBackground(new java.awt.Color(0, 102, 153));
        btnDereserve2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnDereserve2.setForeground(new java.awt.Color(255, 255, 255));
        btnDereserve2.setText("REFRESH");
        btnDereserve2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDereserve2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDereserve2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDereserve1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDereserve1)
                    .addComponent(btnDereserve2)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        String gender = btnGroup.isSelected(rdBtnMale.getModel()) ? "Male" : "Female";
        Librarian librarian = new Librarian(txtID.getText(), txtName.getText(), txtPassword.getText(), txtNic.getText(), txtAddress.getText(), txtContactNo.getText(), txtEmail.getText(), Librarian.LibrarianRoles.Librarian.toString(), image, gender);
        if (GeneralBAL.isEmailCorrect(librarian.getLibEmail())) {
                String msg = lbal.addLibrarian(librarian)?"Librarian saved successfully":"operation failed";
                JOptionPane.showMessageDialog(rootPane, msg);
                loadTable();
                refresh();
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    private byte[] chooseImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JPEG,PNG", "JPEG", "PNG", "jpeg", "png", "JPG"));
        fileChooser.setAcceptAllFileFilterUsed(Boolean.FALSE);
        int options = fileChooser.showOpenDialog(this);
        byte[] image = new byte[0];
        if (options == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();

            try {
                image = FileCopyUtils.copyToByteArray(file);

            } catch (IOException ex) {
                Logger.getLogger(LibrarianIF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return image;
    }
    private void btnDereserve1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDereserve1ActionPerformed
        int selectedRow = tblLibrarians.getSelectedRow();
        if (selectedRow>=0) {
            String id = tblLibrarians.getValueAt(selectedRow, 0).toString();
            String msg=lbal.deleteById(id)?"Deleted Successfully":"Deletion Failed";
            JOptionPane.showMessageDialog(rootPane, msg);
            loadTable();
            refresh();
        }else JOptionPane.showMessageDialog(rootPane, "Select librarian from table");
    }//GEN-LAST:event_btnDereserve1ActionPerformed

    private void btnDereserve2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDereserve2ActionPerformed
        refresh();
    }//GEN-LAST:event_btnDereserve2ActionPerformed

    private void tblLibrariansMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibrariansMouseClicked
        int selectedRow = tblLibrarians.getSelectedRow();
        if (selectedRow >= 0) {
            String id = tblLibrarians.getValueAt(selectedRow, 0).toString();
            Librarian librarian = lbal.getLibrarian(id);
            setObjectInDtl(librarian);
        }
    }//GEN-LAST:event_tblLibrariansMouseClicked

    private void lblPicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPicMouseClicked
        image = chooseImage();
        if (image.length > 0) {
            ImageIcon imageIcon = new ImageIcon(image);
            imageIcon.setImage(imageIcon.getImage().getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH));
            lblPic.setText("");
            lblPic.setIcon(imageIcon);

        } else {
            lblPic.setIcon(null);
            lblPic.setText("NOT FOUND");
        }

    }//GEN-LAST:event_lblPicMouseClicked
    private void setObjectInDtl(Librarian l) {
        txtID.setText(l.getLibId());
        txtAddress.setText(l.getLibAddress());
        txtContactNo.setText(l.getLibContactNo());
        txtEmail.setText(l.getLibEmail());
        txtName.setText(l.getLibName());
        txtNic.setText(l.getLibCNIC());
        txtPassword.setText(l.getLibPassword());
        String gender = l.getGender();
        if (gender.equalsIgnoreCase("Male")) {
            rdBtnMale.setSelected(true);
        } else {
            rdBtnFemale.setSelected(Boolean.TRUE);
        }
        byte[] libPic = l.getLibPic();
        if (libPic != null && libPic.length > 0) {
            ImageIcon icon = new ImageIcon(libPic);
            icon.setImage(icon.getImage().getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH));
            lblPic.setText("");
            lblPic.setIcon(icon);
        } else {
            lblPic.setText("NOT FOUND");
        }

    }

    private void refresh() {
        txtAddress.setText("");
        txtContactNo.setText("");
        txtEmail.setText("");
        txtID.setText("");
        txtName.setText("");
        txtNic.setText("");
        txtPassword.setText("");
        rdBtnMale.setSelected(true);
        lblPic.setIcon(null);
        lblPic.setText("NOT FOUND");
        tblLibrarians.clearSelection();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDereserve1;
    private javax.swing.JButton btnDereserve2;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPic;
    private javax.swing.JRadioButton rdBtnFemale;
    private javax.swing.JRadioButton rdBtnMale;
    private javax.swing.JTable tblLibrarians;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
