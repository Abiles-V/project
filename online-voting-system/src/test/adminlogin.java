package test;


import test.menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Kms somesh
 */
public class adminlogin extends javax.swing.JFrame {

    /**
     * Creates new form adminlogin
     */
    public adminlogin() {
        initComponents();
        back.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        }
});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        back = new javax.swing.JToggleButton();
        uLabel2 = new javax.swing.JLabel();
        pLabel3 = new javax.swing.JLabel();
        usernameF = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        Login = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/admin.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 120, 640, 140));

        show.setText("(oo)");
        show.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                showMouseReleased(evt);
            }
        });
        getContentPane().add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, -1, 20));

        back.setText("Go Back");
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        uLabel2.setText("Username");
        getContentPane().add(uLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, -1, -1));

        pLabel3.setText("Password");
        getContentPane().add(pLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, -1, -1));

        usernameF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFActionPerformed(evt);
            }
        });
        getContentPane().add(usernameF, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 110, -1));

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 90, -1));

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/bg.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMousePressed
        show.setVisible(true);
        jPasswordField1.setEchoChar((char)0);        // TODO add your handling code here:
    }//GEN-LAST:event_showMousePressed

    private void showMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseReleased
        show.setVisible(true);
        jPasswordField1.setEchoChar('*');        // TODO add your handling code here:
    }//GEN-LAST:event_showMouseReleased

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
       String username = usernameF.getText();
    String password = new String(jPasswordField1.getPassword());

    // JDBC connection variables
    String url = "jdbc:mysql://localhost:3306/login";
    String user = "root";
    String dbPassword = "1234";
    
    try {
        // Create a JDBC connection
        Connection connection = DriverManager.getConnection(url, user, dbPassword);

        // Prepare a SQL query to check username and password in the table
        String query = "SELECT * FROM user WHERE username = ? AND password = ? AND admin = 'Y'";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);

        // Execute the query
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            // Login successful
            dispose(); // Close the current window
            resultpublish Resultpublish = new resultpublish();
            Resultpublish.setVisible(true);
        } else {
            // Invalid credentials
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.WARNING_MESSAGE);
        }

        // Close JDBC resources
        resultSet.close();
        statement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_LoginActionPerformed

    private void usernameFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFActionPerformed

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
            java.util.logging.Logger.getLogger(adminlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminlogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Login;
    private javax.swing.JToggleButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel pLabel3;
    private javax.swing.JLabel show;
    private javax.swing.JLabel uLabel2;
    private javax.swing.JTextField usernameF;
    // End of variables declaration//GEN-END:variables
}
