/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import koneksi.koneksi;

/**
 *
 * @author USER
 */
public class Fmenu extends javax.swing.JFrame {
    public static String levelUser, id, nama;
    Connection connection;
    /**
     * Creates new form Fmenu
     */
    public Fmenu() {
        initComponents();
        connection = koneksi.getConnection();
        loginGagal();
    }
    
    
    public static void loginGagal(){
        Mdivisi.setVisible(false);
        Mkaryawan.setVisible(false);
        Mtiket.setVisible(false);
        Mlaporan.setVisible(false);
        SMlogin.setText("Login");
        jPanel1.setVisible(false);
    }
    
    public static void loginSukses(){
        Mdivisi.setVisible(true);
        Mkaryawan.setVisible(true);
        Mtiket.setVisible(true);
        Mlaporan.setVisible(true);
        SMdattik.setVisible(true);
        SMbuattiket.setVisible(false);
        SMriwayattiket.setVisible(false);
        jPanel1.setVisible(true);
        lblnama.setText(nama);
        lbllevel.setText(levelUser);
        if(levelUser.equals("user")){
            Mdivisi.setVisible(false);
            Mkaryawan.setVisible(false);
            Mlaporan.setVisible(false);
            SMdattik.setVisible(false);
            SMbuattiket.setVisible(true);
            SMriwayattiket.setVisible(true);
            jPanel1.setVisible(true);
        }
        SMlogin.setText("Logout");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblnama = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbllevel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        SMlogin = new javax.swing.JMenuItem();
        SMkeluar = new javax.swing.JMenuItem();
        Mdivisi = new javax.swing.JMenu();
        SMdatdiv = new javax.swing.JMenuItem();
        Mkaryawan = new javax.swing.JMenu();
        SMaddkaruser = new javax.swing.JMenuItem();
        SMdatKU = new javax.swing.JMenuItem();
        Mtiket = new javax.swing.JMenu();
        SMdattik = new javax.swing.JMenuItem();
        SMbuattiket = new javax.swing.JMenuItem();
        SMriwayattiket = new javax.swing.JMenuItem();
        Mlaporan = new javax.swing.JMenu();
        SMlaptiket = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");

        jLabel1.setText("Welcome back");

        lblnama.setText("none");

        jLabel3.setText("Anda Login Sebagai");

        lbllevel.setText("none");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblnama))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lbllevel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblnama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbllevel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Option");

        SMlogin.setText("Login");
        SMlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMloginActionPerformed(evt);
            }
        });
        jMenu1.add(SMlogin);

        SMkeluar.setText("Keluar");
        SMkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMkeluarActionPerformed(evt);
            }
        });
        jMenu1.add(SMkeluar);

        jMenuBar1.add(jMenu1);

        Mdivisi.setText("Divisi");

        SMdatdiv.setText("Data Divisi");
        SMdatdiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMdatdivActionPerformed(evt);
            }
        });
        Mdivisi.add(SMdatdiv);

        jMenuBar1.add(Mdivisi);

        Mkaryawan.setText("Karyawan & User");

        SMaddkaruser.setText("Tambah Karyawan & User");
        SMaddkaruser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMaddkaruserActionPerformed(evt);
            }
        });
        Mkaryawan.add(SMaddkaruser);

        SMdatKU.setText("Data Karyawan & User");
        SMdatKU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMdatKUActionPerformed(evt);
            }
        });
        Mkaryawan.add(SMdatKU);

        jMenuBar1.add(Mkaryawan);

        Mtiket.setText("Tiket");

        SMdattik.setText("Data Tiket");
        SMdattik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMdattikActionPerformed(evt);
            }
        });
        Mtiket.add(SMdattik);

        SMbuattiket.setText("Buat Tiket");
        SMbuattiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMbuattiketActionPerformed(evt);
            }
        });
        Mtiket.add(SMbuattiket);

        SMriwayattiket.setText("Riwayat Tiket");
        SMriwayattiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMriwayattiketActionPerformed(evt);
            }
        });
        Mtiket.add(SMriwayattiket);

        jMenuBar1.add(Mtiket);

        Mlaporan.setText("Laporan");

        SMlaptiket.setText("Tiket");
        SMlaptiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMlaptiketActionPerformed(evt);
            }
        });
        Mlaporan.add(SMlaptiket);

        jMenuBar1.add(Mlaporan);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SMdatdivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMdatdivActionPerformed
        // TODO add your handling code here:
        Fdivisi a = new Fdivisi();
        a.setVisible(true);
    }//GEN-LAST:event_SMdatdivActionPerformed

    private void SMaddkaruserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMaddkaruserActionPerformed
        // TODO add your handling code here:
        FaddKU a = new FaddKU();
        a.setVisible(true);
    }//GEN-LAST:event_SMaddkaruserActionPerformed

    private void SMdatKUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMdatKUActionPerformed
        // TODO add your handling code here:
        FdataKU a = new FdataKU();
        a.setVisible(true);
    }//GEN-LAST:event_SMdatKUActionPerformed

    private void SMloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMloginActionPerformed
        // TODO add your handling code here:
        if("Login".equals(Fmenu.SMlogin.getText())){
            Flogin login = new Flogin();
            login.setVisible(true);
        }else{
            Fmenu.loginGagal();
        }
    }//GEN-LAST:event_SMloginActionPerformed

    private void SMbuattiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMbuattiketActionPerformed
        // TODO add your handling code here:
        FbuatTiket a = new FbuatTiket();
        a.setVisible(true);
    }//GEN-LAST:event_SMbuattiketActionPerformed

    private void SMriwayattiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMriwayattiketActionPerformed
        // TODO add your handling code here:
        FriwayatTiket a = new FriwayatTiket();
        a.setVisible(true);
    }//GEN-LAST:event_SMriwayattiketActionPerformed

    private void SMdattikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMdattikActionPerformed
        // TODO add your handling code here:
        FdataTiket a = new FdataTiket();
        a.setVisible(true);
    }//GEN-LAST:event_SMdattikActionPerformed

    private void SMlaptiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMlaptiketActionPerformed
        // TODO add your handling code here:
        FlaporanTiket a = new FlaporanTiket();
        a.setVisible(true);
    }//GEN-LAST:event_SMlaptiketActionPerformed

    private void SMkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMkeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_SMkeluarActionPerformed

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
            java.util.logging.Logger.getLogger(Fmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Fmenu x = new Fmenu();
                x.setExtendedState(JFrame.MAXIMIZED_BOTH);
                x.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JMenu Mdivisi;
    private static javax.swing.JMenu Mkaryawan;
    private static javax.swing.JMenu Mlaporan;
    private static javax.swing.JMenu Mtiket;
    private javax.swing.JMenuItem SMaddkaruser;
    private static javax.swing.JMenuItem SMbuattiket;
    private javax.swing.JMenuItem SMdatKU;
    private javax.swing.JMenuItem SMdatdiv;
    private static javax.swing.JMenuItem SMdattik;
    private javax.swing.JMenuItem SMkeluar;
    private javax.swing.JMenuItem SMlaptiket;
    private static javax.swing.JMenuItem SMlogin;
    private static javax.swing.JMenuItem SMriwayattiket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private static javax.swing.JPanel jPanel1;
    private static javax.swing.JLabel lbllevel;
    private static javax.swing.JLabel lblnama;
    // End of variables declaration//GEN-END:variables
}