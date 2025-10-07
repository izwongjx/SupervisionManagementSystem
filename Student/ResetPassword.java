
package student;

import javax.swing.JOptionPane;
import java.io.*;

public class ResetPassword extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ResetPassword.class.getName());

    
    public ResetPassword() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        currentPass = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        updatedPass = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        reupdatedPass = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        Dashboard3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        ApptDashboard1 = new javax.swing.JButton();
        ViewFeedback1 = new javax.swing.JButton();
        Chatbox1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        Settings1 = new javax.swing.JButton();
        Logout1 = new javax.swing.JButton();
        Profile1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel4.setText("Reset Password");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel1.setText("Update your account information and security settings");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Current Password");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Updated Password");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Re-Enter Updated Password");

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Save Changes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jInternalFrame3.setVisible(true);

        Dashboard3.setText("Dashboard");
        Dashboard3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dashboard3ActionPerformed(evt);
            }
        });

        jLabel14.setText("NAVIGATION");

        ApptDashboard1.setText("Appointment Dashboard");
        ApptDashboard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApptDashboard1ActionPerformed(evt);
            }
        });

        ViewFeedback1.setText("View Feedback");
        ViewFeedback1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewFeedback1ActionPerformed(evt);
            }
        });

        Chatbox1.setText("Chat Box");
        Chatbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chatbox1ActionPerformed(evt);
            }
        });

        jLabel15.setText("ACCOUNT");

        Settings1.setText("Settings");
        Settings1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Settings1ActionPerformed(evt);
            }
        });

        Logout1.setText("Logout");
        Logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout1ActionPerformed(evt);
            }
        });

        Profile1.setText("Profile");
        Profile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Profile1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(ApptDashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ViewFeedback1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Chatbox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Settings1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Logout1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Profile1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Dashboard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Dashboard3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ApptDashboard1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ViewFeedback1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Chatbox1)
                .addGap(44, 44, 44)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Profile1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Settings1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Logout1)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(currentPass, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(updatedPass, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(reupdatedPass, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(currentPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updatedPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reupdatedPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String current = currentPass.getText();
        String update = updatedPass.getText();
        String reupdate = reupdatedPass.getText();

        boolean found = false;
        String filename = "C:\\Users\\renew\\OneDrive - Asia Pacific University\\APU\\APU CLASSES\\SEM 3\\OOP\\studentPassword.txt";

        try {
            // Read all lines first
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String fileUser = parts[0].trim();
                    String filePass = parts[1].trim();

                    // Check current password
                    if (current.equals(filePass)) {
                        found = true;

                        // Check if new passwords match
                        if (update.equals(reupdate)) {
                            line = fileUser + "," + update; // update password
                            JOptionPane.showMessageDialog(this, "Password updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(this, "New passwords do not match!");
                            reader.close();
                            return;
                        }
                    }
                }
                sb.append(line).append("\n");
            }
            reader.close();

            if (!found) {
                JOptionPane.showMessageDialog(this, "Current password is incorrect!");
                return;
            }

            // Write back the updated file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(sb.toString());
            writer.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading/writing file!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Dashboard3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dashboard3ActionPerformed
        StudentDashboard SDB = new StudentDashboard();
        SDB.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Dashboard3ActionPerformed

    private void ApptDashboard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApptDashboard1ActionPerformed
        StudentAppointment SAPT = new StudentAppointment();
        SAPT.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ApptDashboard1ActionPerformed

    private void ViewFeedback1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewFeedback1ActionPerformed
        ViewFeedback VFBack = new ViewFeedback();
        VFBack.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ViewFeedback1ActionPerformed

    private void Chatbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chatbox1ActionPerformed
        ChatBox CB = new ChatBox();
        CB.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Chatbox1ActionPerformed

    private void Settings1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Settings1ActionPerformed
        StudentSettings SSet = new StudentSettings();
        SSet.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Settings1ActionPerformed

    private void Logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout1ActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "Are you sure do you want to exit");
        if (option == 0) {
            LoginPage lp = new LoginPage();
            lp.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_Logout1ActionPerformed

    private void Profile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Profile1ActionPerformed
        StudentProfile SP = new StudentProfile();
        SP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Profile1ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ResetPassword().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApptDashboard1;
    private javax.swing.JButton Chatbox1;
    private javax.swing.JButton Dashboard3;
    private javax.swing.JButton Logout1;
    private javax.swing.JButton Profile1;
    private javax.swing.JButton Settings1;
    private javax.swing.JButton ViewFeedback1;
    private javax.swing.JTextField currentPass;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField reupdatedPass;
    private javax.swing.JTextField updatedPass;
    // End of variables declaration//GEN-END:variables
}
