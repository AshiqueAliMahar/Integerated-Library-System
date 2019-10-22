package Frames.AdminLibrarian;

import BALClasses.StdEmpPostBAL;
import BeanClasses.StdEmployeePosts;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Occupations extends javax.swing.JFrame {
    
    StdEmployeePosts stdEmployeePosts=new StdEmployeePosts();
    StdEmpPostBAL stdEmpPostBAL=new StdEmpPostBAL();
    public Occupations() {
        initComponents();
        loadCmbCategory();
    }

    private void refresh() {
        loadCmbCategory();
        txtPostName.setText("");
        cmbPosts.setSelectedIndex(0);
    }

    private  boolean isPostAvail(String post){
        ArrayList<StdEmployeePosts> allPosts = stdEmpPostBAL.getPost();
        boolean check=false;
        for(StdEmployeePosts sep:allPosts){
            if(sep.getPostName().equals(post)){
                check=true;
                break;
            }
        }
        return check;
    }
    private void loadCmbCategory() {
        ArrayList<StdEmployeePosts> stdEmpPosts =stdEmpPostBAL.getPost();
        cmbPosts.removeAllItems();
        for (StdEmployeePosts object : stdEmpPosts) {
            cmbPosts.addItem(object);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbPosts = new javax.swing.JComboBox();
        txtPostName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(236, 236, 236));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Post", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 1, 18), new java.awt.Color(111, 178, 70))); // NOI18N

        jLabel1.setText("Post Name");

        cmbPosts.setBackground(new java.awt.Color(0, 102, 153));
        cmbPosts.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        cmbPosts.setForeground(new java.awt.Color(255, 255, 255));
        cmbPosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPostsActionPerformed(evt);
            }
        });

        jLabel2.setText("Post");

        btnAdd.setBackground(new java.awt.Color(0, 102, 153));
        btnAdd.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 102, 153));
        btnUpdate.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update Post");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
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

        btnDelete.setBackground(new java.awt.Color(0, 102, 153));
        btnDelete.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPosts, 0, 190, Short.MAX_VALUE)
                    .addComponent(txtPostName)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPosts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPostName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate))
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

    private void cmbPostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPostsActionPerformed
        if (cmbPosts.getSelectedIndex() >= 0) {
            txtPostName.setText(cmbPosts.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cmbPostsActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String post = txtPostName.getText();
        if(!isPostAvail(post)){
        if (post.length() > 0) {
            stdEmpPostBAL.setPost(post);
            refresh();
        }else{
            JOptionPane.showMessageDialog(rootPane,"Insert Post Name");
        }}else{
            JOptionPane.showMessageDialog(rootPane,"This is Already Available");
        }
    }//GEN-LAST:event_btnAddActionPerformed
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(cmbPosts.getSelectedIndex()>=0){
            String post=cmbPosts.getSelectedItem().toString();
            stdEmpPostBAL.deletePost(post);
            refresh();
        }else{
            JOptionPane.showMessageDialog(rootPane,"Select Post","Warning",0);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String oldPost=cmbPosts.getSelectedItem().toString();
            String newPost=txtPostName.getText();
        if(newPost.length()>0){    
            stdEmpPostBAL.updatePost(newPost, oldPost);
        }else{
            JOptionPane.showMessageDialog(rootPane,"Insert new Post Name");
        }
        refresh();
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbPosts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtPostName;
    // End of variables declaration//GEN-END:variables
}
