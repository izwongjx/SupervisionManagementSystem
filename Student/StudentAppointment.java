
package student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class StudentAppointment extends javax.swing.JFrame {
    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = {"AppointmentID", "Date", "Timeslot"};     //ARRAY
    private int row = -1;
    private DefaultComboBoxModel dropdownModel = new DefaultComboBoxModel();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(StudentAppointment.class.getName());

    
    public StudentAppointment() {
        String fileName = "C:\\Users\\renew\\OneDrive - Asia Pacific University\\APU\\APU CLASSES\\SEM 3\\OOP\\appointments.txt";
        model.setColumnIdentifiers(columnName);
        initComponents();
        loadAppointmentStatus();
        jAppointTable.setModel(model);
        
        
        
        //table length 
        jAppointTable.getColumnModel().getColumn(0).setPreferredWidth(200);   // AppointmentID
        jAppointTable.getColumnModel().getColumn(1).setPreferredWidth(200);  // Date
        jAppointTable.getColumnModel().getColumn(2).setPreferredWidth(300);  // Timeslot
        
    }
    
    private void loadAppointmentStatus() {
        model.setRowCount(0); // 🔹 Clear existing rows first
        String fileName = "C:\\Users\\renew\\OneDrive - Asia Pacific University\\APU\\APU CLASSES\\SEM 3\\OOP\\appointments.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    model.addRow(new Object[]{parts[0], parts[1], parts[2]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        jAppointTable.setModel(model);
}
    
    
    private void makeAppointment() {
        String fileName = "C:\\Users\\renew\\OneDrive - Asia Pacific University\\APU\\APU CLASSES\\SEM 3\\OOP\\appointments.txt";

        String date = DATE.getText().trim();
        String timeslot = TIMESLOT.getSelectedItem().toString();

        // Validation
        if (date.isEmpty() || timeslot.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both Date and Timeslot!");
            return;
        }

        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Please enter a correct date format (yyyy-mm-dd)");
            return;
        }

        // Generate new ID
        String lastID = getLastAppointmentID(fileName);
        int nextNum = Integer.parseInt(lastID.substring(3)) + 1;
        String newID = String.format("APT%03d", nextNum);

        String status = "Pending";
        String newRecord = newID + "," + date + "," + timeslot + "," + status;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            if (new File(fileName).length() > 0) {
                bw.newLine();  // ✅ make sure new entry goes to next line
            }
            bw.write(newRecord);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Refresh dashboard table
        loadAppointmentStatus();

        // Mark slot booked
        bookSlot(date, timeslot);

        JOptionPane.showMessageDialog(this, "Appointment Created Successfully!");

        DATE.setText("");
        TIMESLOT.setSelectedIndex(0);
    }


    private void bookSlot(String selectedDate, String selectedTime) {
        String filename = "C:\\Users\\renew\\OneDrive - Asia Pacific University\\APU\\APU CLASSES\\SEM 3\\OOP\\timeslot.txt";
        File inputFile = new File(filename);
        File tempFile = new File("timeslot_temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 5);

                // data format assumption: [id, spid, date, time, status]
                if (data[1].equals("SP001") && data[2].equals(selectedDate) && data[3].equals(selectedTime)) {
                    // mark slot as booked
                    line = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + ",booked";
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // replace original file
        if (inputFile.delete()) {
            tempFile.renameTo(inputFile);
        }
    }

    private void loadSlot(String date) {
        String filename = "C:\\Users\\renew\\OneDrive - Asia Pacific University\\APU\\APU CLASSES\\SEM 3\\OOP\\timeslot.txt";

        // 🔹 Clear old items before adding fresh ones
        TIMESLOT.removeAllItems();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String slotDate = parts[2].trim();
                    String timeRange = parts[3].trim();
                    String status = parts[4].trim();

                    // Only add available slots
                    if (slotDate.equals(date) && status.equalsIgnoreCase("available")) {
                        TIMESLOT.addItem(timeRange);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    private String getLastAppointmentID(String fileName) {
        String lastID = "APT000";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && line.startsWith("APT")) {
                    lastID = line.split(",")[0].trim(); // update only if valid
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastID;
    }

    
    private void cancelAppointment(String appointmentID) {
        String appointFile = "C:\\Users\\renew\\OneDrive - Asia Pacific University\\APU\\APU CLASSES\\SEM 3\\OOP\\appointments.txt";
        String timeslotFile = "C:\\Users\\renew\\OneDrive - Asia Pacific University\\APU\\APU CLASSES\\SEM 3\\OOP\\timeslot.txt";

        File inputFile = new File(appointFile);
        File tempFile = new File("appointments_temp.txt");

        String cancelledDate = null;
        String cancelledTime = null;

        // Step 1: Remove appointment + capture its date & time
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(appointmentID + ",")) {
                    // Example line: APT011, 2025-11-01, 09:00-10:00, Pending
                    String[] parts = line.split(",\\s*");
                    if (parts.length >= 4) {
                        cancelledDate = parts[1];
                        cancelledTime = parts[2];
                    }
                    // Skip writing this line (cancelled)
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (inputFile.delete()) {
            tempFile.renameTo(inputFile);
        }

        // Step 2: Update timeslot.txt to mark it available again
        if (cancelledDate != null && cancelledTime != null) {
            File timeslotInput = new File(timeslotFile);
            File timeslotTemp = new File("timeslot_temp.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader(timeslotInput));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(timeslotTemp))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",\\s*");
                    // Example timeslot line: S1,SP001,2025-11-01,09:00-10:00,booked
                    if (parts.length >= 5 && parts[2].equals(cancelledDate) && parts[3].equals(cancelledTime)) {
                        // Rewrite with available
                        writer.write(parts[0] + "," + parts[1] + "," + parts[2] + "," + parts[3] + ",available");
                    } else {
                        writer.write(line);
                    }
                    writer.newLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (timeslotInput.delete()) {
                timeslotTemp.renameTo(timeslotInput);
            }
        }

        // Step 3: Refresh UI table
        loadAppointmentStatus();
    }


    private void rescheduleAppointment() {
        int row = jAppointTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select an appointment to reschedule!");
            return;
        }

        String apptID = model.getValueAt(row, 0).toString(); // Appointment ID from table
        String oldDate = model.getValueAt(row, 1).toString();
        String oldTimeslot = model.getValueAt(row, 2).toString();
        String newDate = DATE.getText();
        String newTimeslot = TIMESLOT.getSelectedItem().toString();

        // ✅ Update table row (Dashboard only has 3 columns)
        model.setValueAt(newDate, row, 1);
        model.setValueAt(newTimeslot, row, 2);

        // ✅ Update appointments.txt
        String apptFile = "C:\\Users\\renew\\OneDrive - Asia Pacific University\\APU\\APU CLASSES\\SEM 3\\OOP\\appointments.txt";
        List<String> apptLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(apptFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(apptID + ",")) {
                    String[] parts = line.split(",\\s*");
                    String status = (parts.length >= 4) ? parts[3] : "Pending"; 
                    line = apptID + ", " + newDate + ", " + newTimeslot + ", " + status;
                }
                apptLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(apptFile))) {
            for (String l : apptLines) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ✅ Update timeslot.txt
        String slotFile = "C:\\Users\\renew\\OneDrive - Asia Pacific University\\APU\\APU CLASSES\\SEM 3\\OOP\\timeslot.txt";
        List<String> slotLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(slotFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String slotDate = parts[2].trim();
                    String timeRange = parts[3].trim();

                    // Free up the old slot
                    if (slotDate.equals(oldDate) && timeRange.equals(oldTimeslot)) {
                        parts[4] = "available";
                        line = String.join(",", parts);
                    }

                    // Book the new slot
                    if (slotDate.equals(newDate) && timeRange.equals(newTimeslot)) {
                        parts[4] = "booked";
                        line = String.join(",", parts);
                    }
                }
                slotLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(slotFile))) {
            for (String l : slotLines) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(this, "Appointment Rescheduled Successfully!");
        DATE.setText("");
        TIMESLOT.setSelectedItem(null);
        
        loadAppointmentStatus();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        makeAppt = new javax.swing.JButton();
        cancelAppt = new javax.swing.JButton();
        rescheduleAppt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jAppointTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TIMESLOT = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        DATE = new javax.swing.JTextField();
        checkAvailability = new javax.swing.JButton();
        rescheduleAppt1 = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        Dashboard1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ApptDashboard1 = new javax.swing.JButton();
        ViewFeedback1 = new javax.swing.JButton();
        Chatbox1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Settings1 = new javax.swing.JButton();
        Logout1 = new javax.swing.JButton();
        Profile1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("Welcome Back !");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel6.setText("Choose to Make, Reschedule or Cancel Appointment ");

        makeAppt.setText("Make Appointment");
        makeAppt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeApptActionPerformed(evt);
            }
        });

        cancelAppt.setText("Cancel Appointment");
        cancelAppt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelApptActionPerformed(evt);
            }
        });

        rescheduleAppt.setText("Reschedule Appointment");
        rescheduleAppt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rescheduleApptActionPerformed(evt);
            }
        });

        jAppointTable.setModel(model);
        jAppointTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jAppointTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jAppointTable);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel7.setText("Appointment Dashboard");

        jLabel8.setText("Timeslot");

        TIMESLOT.setModel(dropdownModel);
        TIMESLOT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIMESLOTActionPerformed(evt);
            }
        });

        jLabel9.setText("Date");

        DATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DATEActionPerformed(evt);
            }
        });

        checkAvailability.setText("Check Availability");
        checkAvailability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAvailabilityActionPerformed(evt);
            }
        });

        rescheduleAppt1.setText("Check Appointment Status");
        rescheduleAppt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rescheduleAppt1ActionPerformed(evt);
            }
        });

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        jInternalFrame3.setVisible(true);

        Dashboard1.setText("Dashboard");
        Dashboard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dashboard1ActionPerformed(evt);
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

        jLabel5.setText("ACCOUNT");

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
                    .addComponent(jLabel5)
                    .addComponent(ApptDashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ViewFeedback1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Chatbox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Settings1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Logout1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Profile1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Dashboard1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ApptDashboard1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ViewFeedback1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Chatbox1)
                .addGap(44, 44, 44)
                .addComponent(jLabel5)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(DATE, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(checkAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8)
                            .addComponent(TIMESLOT, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(makeAppt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelAppt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rescheduleAppt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rescheduleAppt1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Refresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6))
                            .addComponent(jLabel7))
                        .addGap(0, 236, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkAvailability))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TIMESLOT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(makeAppt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelAppt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rescheduleAppt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rescheduleAppt1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Refresh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAppointTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAppointTableMouseReleased
        int row = jAppointTable.getSelectedRow();
        if (row >= 0) {
        String date = model.getValueAt(row, 1).toString(); // column 1 = Date
        DATE.setText(date);

        // Refresh dropdown for this date
        loadSlot(date);
    }


    }//GEN-LAST:event_jAppointTableMouseReleased

    private void rescheduleApptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rescheduleApptActionPerformed
        rescheduleAppointment();
    }//GEN-LAST:event_rescheduleApptActionPerformed

    private void cancelApptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelApptActionPerformed
        int row = jAppointTable.getSelectedRow();

        if (row >= 0) {
            // Column 0 is the Appointment ID
            String appointmentID = jAppointTable.getValueAt(row, 0).toString();

            cancelAppointment(appointmentID);

            JOptionPane.showMessageDialog(this, "Appointment " + appointmentID + " cancelled successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Please select an appointment to cancel.");
        }
    }//GEN-LAST:event_cancelApptActionPerformed

    private void makeApptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeApptActionPerformed
        makeAppointment();
    }//GEN-LAST:event_makeApptActionPerformed

    private void TIMESLOTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIMESLOTActionPerformed

    }//GEN-LAST:event_TIMESLOTActionPerformed

    private void checkAvailabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAvailabilityActionPerformed
        String date = DATE.getText().trim();
        if (!date.isEmpty()) {
            loadSlot(date);
}

    }//GEN-LAST:event_checkAvailabilityActionPerformed

    private void DATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DATEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DATEActionPerformed

    private void rescheduleAppt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rescheduleAppt1ActionPerformed
        CheckAppointment CAPT = new CheckAppointment();
        CAPT.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_rescheduleAppt1ActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        loadAppointmentStatus(); 
    }//GEN-LAST:event_RefreshActionPerformed

    private void Dashboard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dashboard1ActionPerformed
        StudentDashboard SDB = new StudentDashboard();
        SDB.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Dashboard1ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new StudentAppointment().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApptDashboard1;
    private javax.swing.JButton Chatbox1;
    private javax.swing.JTextField DATE;
    private javax.swing.JButton Dashboard1;
    private javax.swing.JButton Logout1;
    private javax.swing.JButton Profile1;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton Settings1;
    private javax.swing.JComboBox<String> TIMESLOT;
    private javax.swing.JButton ViewFeedback1;
    private javax.swing.JButton cancelAppt;
    private javax.swing.JButton checkAvailability;
    private javax.swing.JTable jAppointTable;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton makeAppt;
    private javax.swing.JButton rescheduleAppt;
    private javax.swing.JButton rescheduleAppt1;
    // End of variables declaration//GEN-END:variables
}
