/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silalita;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class PreviewTimer extends javax.swing.JFrame {
    JFrame frame;
    JLabel t = new JLabel();
    /**
     * Creates new form PreviewTimer
     */
    public PreviewTimer() {
        initComponents();
        txtJumlah.setText(t.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNamaTamping = new javax.swing.JLabel();
        txtNamaPetugas = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JLabel();
        txtKeperluan = new javax.swing.JLabel();
        txtTimerGo = new javax.swing.JLabel();
        txtTimerBack = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(960, 700));
        setMinimumSize(new java.awt.Dimension(960, 700));
        setPreferredSize(new java.awt.Dimension(960, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNamaTamping.setText("-");
        getContentPane().add(txtNamaTamping, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 170, -1));

        txtNamaPetugas.setText("-");
        getContentPane().add(txtNamaPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 170, -1));

        txtJumlah.setText("-");
        getContentPane().add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 140, -1));

        txtKeperluan.setText("-");
        getContentPane().add(txtKeperluan, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, 170, -1));

        txtTimerGo.setFont(new java.awt.Font("Arial Hebrew", 1, 48)); // NOI18N
        txtTimerGo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTimerGo.setText("00:00:00");
        getContentPane().add(txtTimerGo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 200, 40));

        txtTimerBack.setFont(new java.awt.Font("Arial Hebrew", 1, 48)); // NOI18N
        txtTimerBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTimerBack.setText("00:00:00");
        getContentPane().add(txtTimerBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 310, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/PreviewTimer.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PreviewTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreviewTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreviewTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreviewTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreviewTimer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txtJumlah;
    private javax.swing.JLabel txtKeperluan;
    private javax.swing.JLabel txtNamaPetugas;
    private javax.swing.JLabel txtNamaTamping;
    private javax.swing.JLabel txtTimerBack;
    private javax.swing.JLabel txtTimerGo;
    // End of variables declaration//GEN-END:variables
}
