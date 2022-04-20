/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import koneksi.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author USER
 */
public class FdataKU extends javax.swing.JFrame {
    public static String id;
    Connection connection;
    DefaultTableModel model;
    /**
     * Creates new form FdataKU
     */
    public FdataKU() {
        initComponents();
        connection = koneksi.getConnection();
        btnUbah.setVisible(false);
        btnHapus.setVisible(false);
        refresh();
    }
    
    private void getDataTable(){
        model = (DefaultTableModel) table.getModel();
        try{
            Statement stat = connection.createStatement();
            String sql = "SELECT * FROM karyawan inner JOIN divisi ON divisi.kd_divisi = karyawan.kd_divisi "
                    +" inner JOIN user ON user.kd_karyawan=karyawan.kd_karyawan";
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                Object[ ] obj = new Object[7];
                obj[0] = res.getString("kd_karyawan");
                obj[1] = res.getString("nama");
                obj[2] = res.getString("gender");
                obj[3] = res.getString("nama_div");
                obj[4] = res.getString("username");
                obj[5] = res.getString("password");
                obj[6] = res.getString("level");
                model.addRow(obj);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    private void refresh(){
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        txtCari.setText(null);
        getDataTable();
    }
    
    private void deleteKaryawan(){
        PreparedStatement statement = null;
        String sql = "DELETE FROM karyawan WHERE kd_karyawan=?";
        try{
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    private void deleteuser(){
        PreparedStatement statement = null;
        String sql = "DELETE FROM user WHERE kd_karyawan=?";
        try{
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    private void search(){
        model = (DefaultTableModel) table.getModel();
        PreparedStatement statement = null;
        try{
            String sql = "SELECT * FROM karyawan inner JOIN divisi ON divisi.kd_divisi = karyawan.kd_divisi "
                    +" inner JOIN user ON user.kd_karyawan=karyawan.kd_karyawan WHERE nama LIKE?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + txtCari.getText() + "%");
            ResultSet res = statement.executeQuery();
            while(res.next()){
                Object[ ] obj = new Object[7];
                obj[0] = res.getString("kd_karyawan");
                obj[1] = res.getString("nama");
                obj[2] = res.getString("gender");
                obj[3] = res.getString("nama_div");
                obj[4] = res.getString("username");
                obj[5] = res.getString("password");
                obj[6] = res.getString("level");
                model.addRow(obj);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Karyawan & User");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Data Karyawan & User");

        jLabel2.setText("Cari Data");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Karyawan", "Nama Karyawan", "Jenis Kelamin", "Divisi", "Username", "Password", "Level"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCari)
                        .addGap(18, 18, 18)
                        .addComponent(btnCari)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnUbah)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        if(!txtCari.getText().trim().isEmpty()){
            model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            search();
            txtCari.setText(null);
        }else{
            JOptionPane.showMessageDialog(this, "Masukan Nama Prodi",
                    "Notifikasi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        btnUbah.setVisible(true);
        btnHapus.setVisible(true);
    }//GEN-LAST:event_tableMouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        FubahKU.id = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
        FubahKU.nama = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
        FubahKU.jk = table.getModel().getValueAt(table.getSelectedRow(), 2).toString();
        FubahKU.divisi = table.getModel().getValueAt(table.getSelectedRow(), 3).toString();
        FubahKU.username = table.getModel().getValueAt(table.getSelectedRow(), 4).toString();
        FubahKU.password = table.getModel().getValueAt(table.getSelectedRow(), 5).toString();
        FubahKU.lvl = table.getModel().getValueAt(table.getSelectedRow(), 6).toString();
        this.dispose();
        FubahKU a = new FubahKU();
        a.setVisible(true);
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        id = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
        if(id != null){
            int alert = JOptionPane.showConfirmDialog(this, "menghapus karyawan ini akan ikut menghapus akun usernya, yakin unutk hapus?",
                    "Notifikasi", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(alert == JOptionPane.YES_OPTION){
                deleteKaryawan();
                deleteuser();
                refresh();
                JOptionPane.showMessageDialog(this, "karyawan dan user terhapus",
                        "Notifikasi", JOptionPane.INFORMATION_MESSAGE);
                btnUbah.setVisible(false);
                btnHapus.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "Pilih data dulu",
                    "Notifikasi", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(FdataKU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FdataKU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FdataKU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FdataKU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FdataKU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}