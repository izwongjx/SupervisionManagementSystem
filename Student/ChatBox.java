
package student;

import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

public class ChatBox extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ChatBox.class.getName());

    private DefaultTableModel model = new DefaultTableModel();
    private final String chatFile = "C:\\Users\\renew\\OneDrive - Asia Pacific University\\APU\\APU CLASSES\\SEM 3\\OOP\\chat.txt";
    private final String studentID = "ST001"; // Replace with dynamic ID
    private final String supervisorID = "SP001"; // Replace with dynamic ID

    public ChatBox() {
        initComponents();
        setupChatTable();
        loadChatHistory();
    }

    private void setupChatTable() {
        model = new DefaultTableModel(new String[]{"Time", "Sender", "Message"}, 0);
        jTable1.setModel(model);
        jTable1.setEnabled(false); // Disable editing
    }
    
    private void loadChatHistory() {
        try {
            if (!Files.exists(Path.of(chatFile))) return;
            List<String> lines = Files.readAllLines(Path.of(chatFile));
            for (String line : lines) {
                // Split by ", " (comma + space), only 3 parts now
                String[] parts = line.split(", ", 3);
                if (parts.length == 3) {
                    String time = parts[0];
                    String sender = parts[1];
                    String message = parts[2];

                    model.addRow(new Object[]{time, sender, message});
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error loading chat history!");
        }
    }


    private void sendMessage() {
        String message = jTextField1.getText().trim();
        if (message.isEmpty()) return;

        String time = java.time.LocalDateTime.now()
                        .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        model.addRow(new Object[]{time, studentID, message});

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(chatFile, true))) {
            writer.write(time + "，" + studentID + "，" + message);
            writer.newLine();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error writing to chat file!");
        }

        jTextField1.setText(""); // clear input
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sendButton = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        Dashboard3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ApptDashboard1 = new javax.swing.JButton();
        ViewFeedback1 = new javax.swing.JButton();
        Chatbox1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Settings1 = new javax.swing.JButton();
        Logout1 = new javax.swing.JButton();
        Profile1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel6.setText("Messages");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel7.setText("Communicate With Your Supervisor");

        sendButton.setText("SEND");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(model);
        jScrollPane2.setViewportView(jTable1);

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

        jLabel8.setText("ACCOUNT");

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
                    .addComponent(jLabel8)
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
                .addComponent(jLabel8)
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
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        sendMessage();
    }//GEN-LAST:event_sendButtonActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ChatBox().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApptDashboard1;
    private javax.swing.JButton Chatbox1;
    private javax.swing.JButton Dashboard3;
    private javax.swing.JButton Logout1;
    private javax.swing.JButton Profile1;
    private javax.swing.JButton Settings1;
    private javax.swing.JButton ViewFeedback1;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton sendButton;
    // End of variables declaration//GEN-END:variables
}
