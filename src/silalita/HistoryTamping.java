/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silalita;

import java.awt.Color;
import javax.swing.JOptionPane;
import Config.Config;
import Config.Utils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class HistoryTamping extends javax.swing.JFrame {

    /**
     * Creates new form HistoryTamping
     */
    public HistoryTamping() {
        
        
        initComponents();
        setResizable(false);
        btnHome.setBackground(new Color(0,0,0,0));
        btnInput.setBackground(new Color(0,0,0,0));
        
        showData();
    }
    
    void showData() {
        DefaultTableModel model = new DefaultTableModel();
        Color color = UIManager.getColor("Table.gridColor");
        
        MatteBorder border = new MatteBorder(1, 1, 0, 0, color);


        model.addColumn("Tanggal");
        model.addColumn("Nama Tamping");
        model.addColumn("Nama Petugas");
        model.addColumn("Jumlah Tamping");
        model.addColumn("Keperluan");
        model.addColumn("Waktu Berangkat");
        model.addColumn("Waktu Kembali");
        
        try {
            String sql = "SELECT tamping.nama_tamping, petugas.petugas, history.* FROM `history` JOIN tamping ON history.id_tamping=tamping.id JOIN petugas ON history.id_petugas = petugas.id";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            System.err.println(res);
            while(res.next()){
                model.addRow(new Object[]{Utils.setwaktu(res.getString(10)),res.getString(1),res.getString(2),res.getString(6),res.getString(7),res.getString(8),res.getString(9)});
            }
            tableHistory.setModel(model);
            tableHistory.setBorder(border);
        } catch (Exception e) {
            System.out.println(e);
    }}
    
    void showDataFilter() {
        DefaultTableModel model = new DefaultTableModel();
        Color color = UIManager.getColor("Table.gridColor");
        
        MatteBorder border = new MatteBorder(1, 1, 0, 0, color);


        model.addColumn("Tanggal");
        model.addColumn("Nama Tamping");
        model.addColumn("Nama Petugas");
        model.addColumn("Jumlah Tamping");
        model.addColumn("Keperluan");
        model.addColumn("Waktu Berangkat");
        model.addColumn("Waktu Kembali");
        String tgl = "", bln="";
        if (cmbTanggal.getSelectedIndex() < 10) {
            tgl = "0"+cmbTanggal.getSelectedIndex();
        } else {
            tgl = ""+cmbTanggal.getSelectedIndex();
        }
        if (cmbBulan.getSelectedIndex() < 10) {
            bln = "0"+cmbBulan.getSelectedIndex();
        } else {
            bln = ""+cmbBulan.getSelectedIndex();
        }
        String date = cmbTahun.getSelectedItem()+"-"+bln+"-"+tgl;
        try {
            String sql = "SELECT tamping.nama_tamping, petugas.petugas, history.* FROM `history` JOIN tamping ON history.id_tamping=tamping.id JOIN petugas ON history.id_petugas = petugas.id WHERE DATE(history.created_at) ='"+date+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            System.out.println(sql);
            while(res.next()){
                model.addRow(new Object[]{Utils.setwaktu(res.getString(10)),res.getString(1),res.getString(2),res.getString(6),res.getString(7),res.getString(8),res.getString(9)});
            }
            tableHistory.setModel(model);
            tableHistory.setBorder(border);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tanggal tidak valid");
    }}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JPanel();
        btnInput = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHistory = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false; //Disallow the editing of any cell
            }
        };
        cmbTahun = new javax.swing.JComboBox<>();
        cmbTanggal = new javax.swing.JComboBox<>();
        cmbBulan = new javax.swing.JComboBox<>();
        btnFilter = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setForeground(new java.awt.Color(102, 255, 0));
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
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 40));

        btnInput.setBackground(new java.awt.Color(255, 255, 255));
        btnInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInputMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnInputLayout = new javax.swing.GroupLayout(btnInput);
        btnInput.setLayout(btnInputLayout);
        btnInputLayout.setHorizontalGroup(
            btnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        btnInputLayout.setVerticalGroup(
            btnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(btnInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 210, 40));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        tableHistory.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tableHistory.setModel(new javax.swing.table.DefaultTableModel(
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
        tableHistory.setEnabled(false);
        tableHistory.setRowHeight(25);
        jScrollPane1.setViewportView(tableHistory);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 760, 460));

        cmbTahun.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cmbTahun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tahun", "2022", "2023", "2024", "2025", "2026" }));
        getContentPane().add(cmbTahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 150, 40));

        cmbTanggal.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cmbTanggal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tanggal", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(cmbTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 150, 40));

        cmbBulan.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cmbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bulan", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        getContentPane().add(cmbBulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 150, 40));

        btnFilter.setText("Filter");
        btnFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFilterMouseClicked(evt);
            }
        });
        getContentPane().add(btnFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 159, 100, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/HistoryTamping.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        dispose();
        Dashboard dashboardPage = new Dashboard();
        dashboardPage.setVisible(true);
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInputMouseClicked
        dispose();
        InputData inputPage = new InputData();
        inputPage.setVisible(true);
    }//GEN-LAST:event_btnInputMouseClicked

    private void btnFilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFilterMouseClicked
        if (cmbTanggal.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Harap pilih tanggal");
        } else if (cmbBulan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Harap pilih bulan");
        } else if (cmbTahun.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Harap pilih tahun");
        } else {
            showDataFilter();
        }
    }//GEN-LAST:event_btnFilterMouseClicked

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
            java.util.logging.Logger.getLogger(HistoryTamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoryTamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoryTamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryTamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new HistoryTamping().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JPanel btnHome;
    private javax.swing.JPanel btnInput;
    private javax.swing.JComboBox<String> cmbBulan;
    private javax.swing.JComboBox<String> cmbTahun;
    private javax.swing.JComboBox<String> cmbTanggal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableHistory;
    // End of variables declaration//GEN-END:variables

    private Color Color(int i, int i0, int i1, int i2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
