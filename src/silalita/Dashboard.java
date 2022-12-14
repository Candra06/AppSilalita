/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silalita;

import Config.Config;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Dashboard extends javax.swing.JFrame {
    
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
       JFrame frame = new JFrame();
        try {
            Config.configDB();
        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.setIconImage(new ImageIcon("C:/Program Files/Silalita/logo.ico").getImage());
        setResizable(false);
        btnHistory.setBackground(new Color(0,0,0,0));
        btnInput.setBackground(new Color(0,0,0,0));
        btnHide.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInput = new javax.swing.JPanel();
        btnHistory = new javax.swing.JPanel();
        btnHide = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInput.setPreferredSize(new java.awt.Dimension(100, 50));
        btnInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInputMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnInputLayout = new javax.swing.GroupLayout(btnInput);
        btnInput.setLayout(btnInputLayout);
        btnInputLayout.setHorizontalGroup(
            btnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        btnInputLayout.setVerticalGroup(
            btnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(btnInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 220, -1));

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

        btnHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHideMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnHideLayout = new javax.swing.GroupLayout(btnHide);
        btnHide.setLayout(btnHideLayout);
        btnHideLayout.setHorizontalGroup(
            btnHideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        btnHideLayout.setVerticalGroup(
            btnHideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(btnHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/HomePage.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInputMouseClicked
        
        InputData inputPage = new InputData();
        inputPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnInputMouseClicked

    private void btnHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistoryMouseClicked
        this.setVisible(false);
        HistoryTamping ht = new HistoryTamping();
        ht.setVisible(true);
    }//GEN-LAST:event_btnHistoryMouseClicked

    private void btnHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHideMouseClicked
        inputDataTamping();
    }//GEN-LAST:event_btnHideMouseClicked

    void inputDataTamping(){
        try {
            String sql = "INSERT INTO tamping(nama_tamping, status) VALUES " +
            "('TAMPING/PEKERJA P2U','Show')," +
            "('TAMPING TU','Show')," +
            "('TAMPING KAMTIB','Show')," +
            "('TAMPING KPLP','Show')," +
            "('TAMPING REGISTRASI','Show')," +
            "('TAMPING POLIKLINIK','Show')," +
            "('TAMPING MUSHOLA','Show')," +
            "('TAMPING BIMPAS','Show')," +
            "('TAMPING KRT BIMPAS','Show')," +
            "('TAMPING SALON','Show')," +
            "('TAMPING POS','Show')," +
            "('TAMPING PERPUSTAKAAN','Show')," +
            "('TAMPING GEREJA','Show')," +
            "('TAMPING OLAHRGA','Show')," +
            "('TAMPING WARTEL','Show')," +
            "('TAMPING BENGKER','Show')," +
            "('PEKERJA LAUNDRY','Show')," +
            "('PEKERJA KERIPIK','Show')," +
            "('PEKERJA BAKERY','Show')," +
            "('PEKERJA DAPUR BENGER','Show')," +
            "('TAMPING KOPERASI','Show')," +
            "('TAMPING DAPUR','Show')," +
            "('TAMPING PENDIDIKAN','Show')," +
            "('TAMPING BLOK','Show')," +
            "('CREATIVE','Show')";
            
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            try {
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Di Simpan "+e);
                System.out.println(e);
            }
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Di Simpan "+e);
        }
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                 
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnHide;
    private javax.swing.JPanel btnHistory;
    private javax.swing.JPanel btnInput;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
