
package student;

import java.io.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CheckAppointment extends javax.swing.JFrame {
    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = {"AppointmentID", "Date", "Timeslot", "Status"};     //ARRAY
    private int row = -1;
    
    public CheckAppointment() {
        model.setColumnIdentifiers(columnName);
        initComponents();
        loadAppointmentStatus();
    
    
        jTableStatus.getColumnModel().getColumn(0).setPreferredWidth(80);   // AppointmentID
        jTableStatus.getColumnModel().getColumn(1).setPreferredWidth(150);  // Date
        jTableStatus.getColumnModel().getColumn(2).setPreferredWidth(400);  // Timeslot
        jTableStatus.getColumnModel().getColumn(3).setPreferredWidth(400);  // Status
        jTableStatus.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    
    private void loadAppointmentStatus() {
        String fileName = "C:\\Users\\renew\\OneDrive - Asia Pacific University\\APU\\APU CLASSES\\SEM 3\\OOP\\appointments.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            DefaultTableModel model = (DefaultTableModel) jTableStatus.getModel();

            // clear existing rows
            model.setRowCount(0);

            // read each line and add to table
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;  // 🚫 skip blank lines

                String[] parts = line.split(",", 4);
                if (parts.length == 4) {
                    // trim each value to avoid leading/trailing spaces
                    for (int i = 0; i < parts.length; i++) {
                        parts[i] = parts[i].trim();
                    }
                    model.addRow(parts);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStatus = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel4.setText("Check Appointment Status");

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTableStatus.setModel(model);
        jScrollPane1.setViewportView(jTableStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        StudentAppointment SAPT = new StudentAppointment();
        SAPT.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CheckAppointment().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableStatus;
    // End of variables declaration//GEN-END:variables
}
