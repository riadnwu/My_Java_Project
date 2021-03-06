/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javademo;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Md. Rashid Al Asif
 */
public class homeJFrame extends javax.swing.JFrame {

    String nameVal = null, deptVal = null, stuIdVal = null;

    DefaultTableModel model;
    String[] data = new String[5];

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    /**
     * Creates new form homeJFrame
     */
    public homeJFrame() {
        initComponents();
        showTable();

        disableButton();

    }

    /**
     * @author Asif
     * @name shoTable
     */
    void showTable() {
        resetInputField();
        disableButton();

        DefaultTableModel model = (DefaultTableModel) tblShowAll.getModel();

        ((DefaultTableModel) tblShowAll.getModel()).setNumRows(0);

        try {
            // make the connection
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();

            String query = "select* from students";
            rs = stmt.executeQuery(query);

            while (rs.next()) {

                data[0] = rs.getString("student_id");
                data[1] = rs.getString("name");
                data[2] = rs.getString("dept");

                model.addRow(data);
            }
            tblShowAll.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failure" + e);

        }

    }

    /**
     * @name resetInputField
     */
    void resetInputField() {
        student_id.setText("");
        name.setText("");
        dept.setSelectedIndex(0);
    }

    /**
     * @name disableButton
     */
    void disableButton() {

        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    /**
     * @name enableButton
     */
    void enableButton() {
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblShowAll = new javax.swing.JTable();
        btnShowAll = new javax.swing.JButton();
        btnAlert = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        student_id = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        dept = new javax.swing.JComboBox();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblShowAll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Student Id", "Name", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblShowAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblRowSelector(evt);
            }
        });
        jScrollPane1.setViewportView(tblShowAll);
        if (tblShowAll.getColumnModel().getColumnCount() > 0) {
            tblShowAll.getColumnModel().getColumn(0).setResizable(false);
            tblShowAll.getColumnModel().getColumn(1).setResizable(false);
            tblShowAll.getColumnModel().getColumn(2).setResizable(false);
        }

        btnShowAll.setText("Show All");
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });

        btnAlert.setText("Click Me");
        btnAlert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlertActionPerformed(evt);
            }
        });

        btnLogout.setText("Log Out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel1.setText("Student Id:");

        jLabel2.setText("Department:");

        jLabel3.setText("Name:");

        student_id.setEditable(false);

        dept.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "cse", "eee", "ce" }));

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(student_id))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dept, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnShowAll, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAlert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(student_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowAll)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlert)
                    .addComponent(btnLogout))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
        // TODO add your handling code here:

        showTable();
    }//GEN-LAST:event_btnShowAllActionPerformed

    private void btnAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlertActionPerformed
        // TODO add your handling code here:

        if (JOptionPane.showConfirmDialog(null, "Are you sure ?") == JOptionPane.YES_OPTION) {
            // JOptionPane.showMessageDialog(this,"YES clicked");
            JOptionPane.showMessageDialog(null, "ALERT MESSAGE", "TITLE", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "ALERT MESSAGE", "TITLE", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAlertActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:

        // close
        this.dispose();

        loginJFrame obj = new loginJFrame();
        obj.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void tblRowSelector(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRowSelector

        disableButton();

        try {

            int trow = tblShowAll.getSelectedRow();
            stuIdVal = tblShowAll.getValueAt(trow, 0).toString();
            nameVal = tblShowAll.getValueAt(trow, 1).toString();
            deptVal = tblShowAll.getValueAt(trow, 2).toString();

            student_id.setText(stuIdVal);
            name.setText(nameVal);
            dept.setSelectedItem(deptVal);

            enableButton();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_tblRowSelector

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        stuIdVal = student_id.getText().trim();
        nameVal = name.getText().trim();
        deptVal = (String) dept.getSelectedItem();

        if (stuIdVal.equals("") || nameVal.equals("") || deptVal.equals("")) {
            JOptionPane.showMessageDialog(null, "All Field are mandatory", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {

            DbOperation dbObj = new DbOperation();

            try {
                int flag = dbObj.editStudent(stuIdVal, nameVal, deptVal);
                if (flag == 1) {
                    showTable();
                    JOptionPane.showMessageDialog(this, "Edited Successfully...");
                } else {
                    JOptionPane.showMessageDialog(this, "Something Went Wrong...");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Are you sure ?") == JOptionPane.YES_OPTION) {
            stuIdVal = student_id.getText().trim();

            if (stuIdVal.equals("")) {
                JOptionPane.showMessageDialog(null, "Student Id Field is mandatory", "Warning", JOptionPane.INFORMATION_MESSAGE);
            } else {

                DbOperation dbObj = new DbOperation();

                try {
                    int flag = dbObj.deleteStudent(stuIdVal);
                    if (flag == 1) {
                        showTable();
                        resetInputField();
                        disableButton();
                        JOptionPane.showMessageDialog(this, "Deleted Successfully...");
                    } else {
                        JOptionPane.showMessageDialog(this, "Something Went Wrong...");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(homeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homeJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlert;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnShowAll;
    private javax.swing.JComboBox dept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField student_id;
    private javax.swing.JTable tblShowAll;
    // End of variables declaration//GEN-END:variables
}
