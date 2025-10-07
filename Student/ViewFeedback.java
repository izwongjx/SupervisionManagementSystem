
package student;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ViewFeedback extends javax.swing.JFrame {
    
    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = {"AppointmentID", "Feedback"};     //ARRAY
    private int row = -1;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CheckAppointment.class.getName());

   
    public ViewFeedback() {
        model.setColumnIdentifiers(columnName);
        initComponents();
        loadSupervisorFeedback();
    }

    
    
    private void loadSupervisorFeedback() {
    String fileName = "C:\\Users\\renew\\OneDrive - Asia Pacific University\\APU\\APU CLASSES\\SEM 3\\OOP\\supervisorFB.txt";
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        DefaultTableModel model = (DefaultTableModel) jTableFeedback.getModel();
        
        jTableFeedback.getColumnModel().getColumn(0).setPreferredWidth(100);   // AppointmentID
        jTableFeedback.getColumnModel().getColumn(1).setPreferredWidth(400);  // Supervisor
        
        // clear existing rows
        model.setRowCount(0);
        
        // read each line and add to table
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",", 2); // split into 2 parts: ID, Supervisor
            model.addRow(data);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame2 = new javax.swing.JInternalFrame();
        Dashboard1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ApptDashboard = new javax.swing.JButton();
        ViewFeedback = new javax.swing.JButton();
        Chatbox = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Settings = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        History = new javax.swing.JButton();
        Profile = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFeedback = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        Dashboard3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ApptDashboard1 = new javax.swing.JButton();
        ViewFeedback1 = new javax.swing.JButton();
        Chatbox1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Settings1 = new javax.swing.JButton();
        Logout1 = new javax.swing.JButton();
        Profile1 = new javax.swing.JButton();

        jInternalFrame2.setVisible(true);

        Dashboard1.setText("Dashboard");
        Dashboard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dashboard1ActionPerformed(evt);
            }
        });

        jLabel2.setText("NAVIGATION");

        ApptDashboard.setText("Appointment Dashboard");
        ApptDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApptDashboardActionPerformed(evt);
            }
        });

        ViewFeedback.setText("View Feedback");
        ViewFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewFeedbackActionPerformed(evt);
            }
        });

        Chatbox.setText("Chat Box");
        Chatbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChatboxActionPerformed(evt);
            }
        });

        jLabel3.setText("ACCOUNT");

        Settings.setText("Settings");
        Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsActionPerformed(evt);
            }
        });

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        History.setText("History");
        History.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryActionPerformed(evt);
            }
        });

        Profile.setText("Profile");
        Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(ApptDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ViewFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Chatbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(History, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Settings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Dashboard1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ApptDashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ViewFeedback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Chatbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(History)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Profile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(Settings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Logout)
                .addGap(12, 12, 12))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel5.setText("Review feedback and ratings from your supervisors");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel6.setText("View Feedback");

        jTableFeedback.setModel(model);
        jScrollPane1.setViewportView(jTableFeedback);

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Open Chatbox");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jInternalFrame3.setVisible(true);

        Dashboard3.setText("Dashboard");
        Dashboard3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dashboard3ActionPerformed(evt);
            }
        });

        jLabel4.setText("NAVIGATION");

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

        jLabel7.setText("ACCOUNT");

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
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
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
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Dashboard3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ApptDashboard1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ViewFeedback1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Chatbox1)
                .addGap(44, 44, 44)
                .addComponent(jLabel7)
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Dashboard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dashboard1ActionPerformed
        StudentDashboard SDB = new StudentDashboard();
        SDB.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Dashboard1ActionPerformed

    private void ApptDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApptDashboardActionPerformed
        StudentAppointment SAPT = new StudentAppointment();
        SAPT.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ApptDashboardActionPerformed

    private void ViewFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewFeedbackActionPerformed
        ViewFeedback VFBack = new ViewFeedback();
        VFBack.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ViewFeedbackActionPerformed

    private void ChatboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChatboxActionPerformed
        ChatBox CB = new ChatBox();
        CB.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ChatboxActionPerformed

    private void SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsActionPerformed
        StudentSettings SSet = new StudentSettings();
        SSet.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SettingsActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "Are you sure do you want to exit");
        if (option == 0) {
            LoginPage lp = new LoginPage();
            lp.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_LogoutActionPerformed

    private void HistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryActionPerformed
        History Hist = new History();
        Hist.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HistoryActionPerformed

    private void ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileActionPerformed
        StudentProfile SP = new StudentProfile();
        SP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ProfileActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ChatBox cb = new ChatBox();
        cb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        StudentDashboard SDB = new StudentDashboard();
        SDB.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ViewFeedback().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApptDashboard;
    private javax.swing.JButton ApptDashboard1;
    private javax.swing.JButton Chatbox;
    private javax.swing.JButton Chatbox1;
    private javax.swing.JButton Dashboard1;
    private javax.swing.JButton Dashboard3;
    private javax.swing.JButton History;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Logout1;
    private javax.swing.JButton Profile;
    private javax.swing.JButton Profile1;
    private javax.swing.JButton Settings;
    private javax.swing.JButton Settings1;
    private javax.swing.JButton ViewFeedback;
    private javax.swing.JButton ViewFeedback1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFeedback;
    // End of variables declaration//GEN-END:variables
}
