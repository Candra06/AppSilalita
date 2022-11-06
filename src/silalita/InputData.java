/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silalita;

import Config.Config;
import java.awt.Color;
import java.awt.Container;
import java.sql.Connection;
import static java.lang.Thread.sleep;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class InputData extends javax.swing.JFrame {
    static int detik = 0,menit = 0,jam = 0, mili=0;
    static int detikBck = 0,menitBck = 0,jamBck = 0, miliBck=0, idTmp = -1;
    static String valueGo, valueBack;
    static boolean startGo = false, startBack = false;
    static Object[] data;
    
    
    List<Integer> idTamping = new ArrayList<Integer>();
    List<Integer> idPetugas = new ArrayList<Integer>();
    
    
    /**
     * Creates new form InputData
     */
    public InputData() {
        initComponents();
        setResizable(false);
        tampilCmbTamping();
        tableTmpData();
        btnHistory.setBackground(new Color(0,0,0,0));
        btnHome.setBackground(new Color(0,0,0,0));
        btnSave.setBackground(new Color(0,0,0,0));
        cmbTamping.setBounds(100,100,100,30);
        
    }
    
    public void tableTmpData(){
         try {
            
            DefaultTableModel model = new DefaultTableModel();
            Color color = UIManager.getColor("Table.gridColor");

            MatteBorder border = new MatteBorder(1, 1, 0, 0, color);

            model.addColumn("id");
            model.addColumn("idT");
            model.addColumn("idP");
            model.addColumn("jml");
            model.addColumn("status");
            model.addColumn("Nama Tamping");
            model.addColumn("Nama Pembantu");
            model.addColumn("Keperluan");
            model.addColumn("Jam Berangkat");
            model.addColumn("Jam Tiba");
            model.addColumn("Jam Kembali");
            model.addColumn("Jam Tiba");
            
            
            
//            tblTmpData.getColumnModel().getColumn(0).setResizable(true);
            
            
            tblTmpData.setShowHorizontalLines(true);
            tblTmpData.setShowVerticalLines(true);
            tblTmpData.setRowMargin(1);
            tblTmpData.setModel(model);
            tblTmpData.setBorder(border);
            tblTmpData.getColumnModel().getColumn(0).setMinWidth(0);
            tblTmpData.getColumnModel().getColumn(0).setMaxWidth(0);
            tblTmpData.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblTmpData.getColumnModel().getColumn(1).setMinWidth(0);
            tblTmpData.getColumnModel().getColumn(1).setMaxWidth(0);
            tblTmpData.getColumnModel().getColumn(1).setWidth(0);
            tblTmpData.getColumnModel().getColumn(2).setMinWidth(0);
            tblTmpData.getColumnModel().getColumn(2).setMaxWidth(0);
            tblTmpData.getColumnModel().getColumn(2).setWidth(0);
            tblTmpData.getColumnModel().getColumn(3).setMinWidth(0);
            tblTmpData.getColumnModel().getColumn(3).setMaxWidth(0);
            tblTmpData.getColumnModel().getColumn(3).setWidth(0);
            tblTmpData.getColumnModel().getColumn(4).setMinWidth(0);
            tblTmpData.getColumnModel().getColumn(4).setMaxWidth(0);
            tblTmpData.getColumnModel().getColumn(4).setWidth(0);
         } catch (Exception e) {
             System.out.print(e);
         }
    }
    
    public void tampilCmbTamping() {
        try {
            String sql = "SELECT * FROM tamping WHERE status='Show'";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();
            
            idTamping.add(0);
            while(rs.next()){
                cmbTamping.addItem(rs.getString("nama_tamping"));
                idTamping.add(rs.getInt("id"));
                
            }
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void tampilCmbPetugas(int index) {
        try {
            String sql = "SELECT * FROM petugas WHERE id_tamping="+index;
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();
            idPetugas.clear();
            cmbNama.removeAllItems();
            cmbNama.addItem("--Pilih Nama--");
            idPetugas.add(0);
            while(rs.next()){
                cmbNama.addItem(rs.getString("petugas"));
                idPetugas.add(rs.getInt("id"));
                index++;
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    void addNewRow(){
        try {
            DefaultTableModel model = (DefaultTableModel)tblTmpData.getModel();
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();

            int id = tblTmpData.getRowCount() +1;
            String tampingId = idTamping.get(cmbTamping.getSelectedIndex()).toString();
            String petugasId = idPetugas.get(cmbNama.getSelectedIndex()).toString();
            String namaTamping =  cmbTamping.getItemAt(cmbTamping.getSelectedIndex());
            String namaPetugas = cmbNama.getItemAt(cmbNama.getSelectedIndex());
            String jmlTamping = txtJumlahTamping.getText();
            String keperluan = txtKeperluan.getText();
            String status = "go"; // "stop", "back", "stopBack"
            String jamBerangkat = dtf.format(now).toString();
            String jamTiba1 = "";
            String jamKembali = "";
            String jamTiba2 = "";

            model.addRow(new Object[]{ 
                id, 
                tampingId, 
                petugasId,
                txtJumlahTamping.getText(),
                status,
                namaTamping, 
                namaPetugas,
                txtKeperluan.getText(),
                dtf.format(now).toString(),
                jamTiba1,
                jamKembali, 
                jamTiba2
            });       

            resetForm();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    void updateTable(int row){
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();
            String jam = dtf.format(now).toString();
            
            if (tblTmpData.getModel().getValueAt(row, 4).toString() == "go") {
                tblTmpData.getModel().setValueAt("stop", row, 4);
                tblTmpData.getModel().setValueAt(jam, row, 9); // set jam tiba
                data [4] = "stop";
                data [9] = jam;
            } else if (tblTmpData.getModel().getValueAt(row, 4).toString() == "stop") {
                tblTmpData.getModel().setValueAt("back", row, 4);
                tblTmpData.getModel().setValueAt(jam, row, 10); // set jam kembali
                data [4] = "back";
                data [10] = jam;
            } else if (tblTmpData.getModel().getValueAt(row, 4).toString() == "back"){
                tblTmpData.getModel().setValueAt("stopBack", row, 4);
                tblTmpData.getModel().setValueAt(jam, row, 11); // set jam selesai
                data [4] = "stopBack";
                data [11] = jam;
            }else{
                
            }
            resetForm();
        } catch (Exception e) {
            System.out.println(e);
        }
 
    }
    
    void saveData(){
        if (idTmp == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan disimpan");
        } else {
            // aksi simpan
            DefaultTableModel model = (DefaultTableModel)tblTmpData.getModel();
            model.removeRow(idTmp);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JPanel();
        btnHistory = new javax.swing.JPanel();
        btnSave = new javax.swing.JPanel();
        cmbTamping = new javax.swing.JComboBox<>();
        txtJumlahTamping = new javax.swing.JTextField();
        txtKeperluan = new javax.swing.JTextField();
        cmbNama = new javax.swing.JComboBox<>();
        btnMulai = new javax.swing.JButton();
        btnDataTamping = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTmpData = new javax.swing.JTable();
        btnSaveData = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnHomeLayout = new javax.swing.GroupLayout(btnHome);
        btnHome.setLayout(btnHomeLayout);
        btnHomeLayout.setHorizontalGroup(
            btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        btnHomeLayout.setVerticalGroup(
            btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 220, 50));

        btnHistory.setPreferredSize(new java.awt.Dimension(200, 100));
        btnHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistoryMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnHistoryLayout = new javax.swing.GroupLayout(btnHistory);
        btnHistory.setLayout(btnHistoryLayout);
        btnHistoryLayout.setHorizontalGroup(
            btnHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        btnHistoryLayout.setVerticalGroup(
            btnHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(btnHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 220, 50));

        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnSaveLayout = new javax.swing.GroupLayout(btnSave);
        btnSave.setLayout(btnSaveLayout);
        btnSaveLayout.setHorizontalGroup(
            btnSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        btnSaveLayout.setVerticalGroup(
            btnSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 230, 30));

        cmbTamping.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        cmbTamping.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Tamping--" }));
        cmbTamping.setToolTipText("Pilih Tamping");
        cmbTamping.setMinimumSize(new java.awt.Dimension(255, 30));
        cmbTamping.setPreferredSize(new java.awt.Dimension(214, 50));
        cmbTamping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTampingActionPerformed(evt);
            }
        });
        getContentPane().add(cmbTamping, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 170, 30));

        txtJumlahTamping.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtJumlahTamping.setBorder(null);
        txtJumlahTamping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahTampingActionPerformed(evt);
            }
        });
        getContentPane().add(txtJumlahTamping, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 150, 30));

        txtKeperluan.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtKeperluan.setBorder(null);
        txtKeperluan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeperluanActionPerformed(evt);
            }
        });
        getContentPane().add(txtKeperluan, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 210, 150, 30));

        cmbNama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Nama--" }));
        cmbNama.setToolTipText("Pilih Nama");
        getContentPane().add(cmbNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 170, 180, 30));

        btnMulai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/BtnMulai.png"))); // NOI18N
        btnMulai.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnMulai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMulaiMouseClicked(evt);
            }
        });
        getContentPane().add(btnMulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, -1, -1));

        btnDataTamping.setBackground(new java.awt.Color(255, 255, 255));
        btnDataTamping.setText("Data Tamping");
        btnDataTamping.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnDataTamping.setBorderPainted(false);
        btnDataTamping.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDataTampingMouseClicked(evt);
            }
        });
        btnDataTamping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataTampingActionPerformed(evt);
            }
        });
        getContentPane().add(btnDataTamping, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 140, 40));

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/BtnBerhenti.png"))); // NOI18N
        btnStop.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStopMouseClicked(evt);
            }
        });
        getContentPane().add(btnStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, -1, -1));

        tblTmpData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTmpData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTmpDataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTmpData);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 750, 350));

        btnSaveData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/BtnSave.png"))); // NOI18N
        btnSaveData.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(btnSaveData, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/InputTamping.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        dispose();
        Dashboard db = new Dashboard();
        db.setVisible(true);
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistoryMouseClicked
        dispose();
        HistoryTamping ht = new HistoryTamping();
        ht.setVisible(true);
    }//GEN-LAST:event_btnHistoryMouseClicked

    private void txtJumlahTampingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahTampingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahTampingActionPerformed

    private void cmbTampingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTampingActionPerformed

        tampilCmbPetugas(idTamping.get(cmbTamping.getSelectedIndex()));
    }//GEN-LAST:event_cmbTampingActionPerformed

    private void txtKeperluanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeperluanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeperluanActionPerformed

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        inputTamping();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnDataTampingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataTampingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDataTampingActionPerformed

    private void btnDataTampingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDataTampingMouseClicked
         InputTamping it = new InputTamping();
        it.setVisible(true);
    }//GEN-LAST:event_btnDataTampingMouseClicked

    private void btnMulaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMulaiMouseClicked
        if (idTmp == -1) {
            addNewRow();
        } else {
            updateTable(idTmp);
        }
    }//GEN-LAST:event_btnMulaiMouseClicked

    private void tblTmpDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTmpDataMouseClicked
        int row = tblTmpData.getSelectedRow();
        
        data = new Object[] {
            tblTmpData.getModel().getValueAt(row, 0).toString(),
            tblTmpData.getModel().getValueAt(row, 1).toString(),
            tblTmpData.getModel().getValueAt(row, 2).toString(),
            tblTmpData.getModel().getValueAt(row, 3).toString(),
            tblTmpData.getModel().getValueAt(row, 4).toString(),
            tblTmpData.getModel().getValueAt(row, 5).toString(),
            tblTmpData.getModel().getValueAt(row, 6).toString(),
            tblTmpData.getModel().getValueAt(row, 7).toString(),
            tblTmpData.getModel().getValueAt(row, 8).toString(),
            tblTmpData.getModel().getValueAt(row, 9).toString(),
            tblTmpData.getModel().getValueAt(row, 10).toString(),
            tblTmpData.getModel().getValueAt(row, 11).toString(),
        };
        int indexTamping = Integer.parseInt(tblTmpData.getModel().getValueAt(row, 1).toString());
        int indexnama = Integer.parseInt(tblTmpData.getModel().getValueAt(row, 2).toString());
        cmbTamping.setSelectedIndex(idTamping.indexOf(indexTamping));
        cmbNama.setSelectedIndex(idPetugas.indexOf(indexnama));
        txtJumlahTamping.setText(tblTmpData.getModel().getValueAt(row, 3).toString());
        txtKeperluan.setText(tblTmpData.getModel().getValueAt(row, 7).toString());
        idTmp = row;

    }//GEN-LAST:event_tblTmpDataMouseClicked

    private void btnStopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStopMouseClicked
        System.out.println(idTmp);
        updateTable(idTmp);
    }//GEN-LAST:event_btnStopMouseClicked
    
    private void inputTamping(){
        try {
            if (txtJumlahTamping.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Jumlah Tamping Tidak Boleh Kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else if(txtKeperluan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Keperluan Tidak Boleh Kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else if(startGo==true || startBack==true){
                JOptionPane.showMessageDialog(null, "Waktu masih berjalan", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                 String sql = "INSERT INTO history(id_tamping, id_petugas,keperluan, jumlah, waktu_berangkat, waktu_kembali, created_at) VALUES(?,?,?,?,?,?,?)";
                 
                java.sql.Connection conn = (Connection)Config.configDB();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                 try {
                    pst.setString(1, idTamping.get(cmbTamping.getSelectedIndex()).toString());
                    pst.setString(2, idPetugas.get(cmbNama.getSelectedIndex()).toString());
                    pst.setString(3, txtJumlahTamping.getText());
                    pst.setString(4, txtKeperluan.getText());
                    pst.setString(5, valueGo);
                    pst.setString(6, valueBack);
                    pst.setString(7, dtf.format(now).toString());
                    pst.executeUpdate();
                    resetForm();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Di Dimpan "+e);
                System.out.println(e);
            }
            pst.close();
                
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void resetForm(){
        txtJumlahTamping.setText("");
        txtKeperluan.setText("");
        cmbTamping.setSelectedIndex(0);
        cmbNama.setSelectedIndex(0);
        idTmp = -1;
//        txtTimerGo.setText("00:00:00");
//        txtTimerBack.setText("00:00:00");
        detik = 0;
        menit = 0;
        jam = 0; 
        mili=0;
        detikBck = 0;
        menitBck = 0;
        jamBck = 0;
        miliBck=0;
    }
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
            java.util.logging.Logger.getLogger(InputData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDataTamping;
    private javax.swing.JPanel btnHistory;
    private javax.swing.JPanel btnHome;
    private javax.swing.JButton btnMulai;
    private javax.swing.JPanel btnSave;
    private javax.swing.JButton btnSaveData;
    private javax.swing.JButton btnStop;
    private javax.swing.JComboBox<String> cmbNama;
    private javax.swing.JComboBox<String> cmbTamping;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTmpData;
    private javax.swing.JTextField txtJumlahTamping;
    private javax.swing.JTextField txtKeperluan;
    // End of variables declaration//GEN-END:variables
}
