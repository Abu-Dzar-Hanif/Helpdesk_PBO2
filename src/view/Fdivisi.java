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
public class Fdivisi extends javax.swing.JFrame {
    Connection connection;
    DefaultTableModel model;
    /**
     * Creates new form Fdivisi
     */
    public Fdivisi() {
        initComponents();
        connection = koneksi.getConnection();
        refresh();
        auto_code();
        tId.requestFocus();
        btnflase();
    }
    
    public void btnflase(){
        btnHapus.setEnabled(false);
        btnUbah.setEnabled(false);
    }
    
    public void btntrue(){
        btnHapus.setEnabled(true);
        btnUbah.setEnabled(true);
    }
    
    private void getDataTable(){
        model = (DefaultTableModel) table.getModel();
        try{
            Statement stat = connection.createStatement();
            String sql = "SELECT * FROM divisi";
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                Object[ ] obj = new Object[2];
                obj[0] = res.getString("kd_divisi");
                obj[1] = res.getString("nama_div");
                model.addRow(obj);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
     private void refresh(){
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        tCari.setText(null);
        getDataTable();
    }
    
    private void reset(){
        tId.setText(null);
        tDivisi.setText(null);
        auto_code();
        btnSimpan.setEnabled(true);
        btnflase();
    }
    
    private void insert(){
        PreparedStatement statment = null;
        String sql = "INSERT INTO divisi(kd_divisi,nama_div) VALUES(?,?)";
        try{
            statment = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statment.setString(1, tId.getText());
            statment.setString(2, tDivisi.getText());
            statment.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statment.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }       
    }
    
    private void update(){
        PreparedStatement statement = null;
        String sql = "UPDATE divisi SET nama_div=? WHERE kd_divisi=?";
        try{
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, tDivisi.getText());
            statement.setString(2, tId.getText());
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
    
    private void delete(){
        PreparedStatement statement = null;
        String sql = "DELETE FROM divisi WHERE kd_divisi=?";
        try{
            statement = connection.prepareStatement(sql);
            statement.setString(1, tId.getText());
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
            String sql = "SELECT * FROM divisi WHERE nama_div like ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + tCari.getText() + "%");
            ResultSet res = statement.executeQuery();
            while(res.next()){
                Object[ ] obj = new Object[2];
                obj[0] = res.getString("kd_divisi");
                obj[1] = res.getString("nama_div");
                model.addRow(obj);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    private void auto_code(){
        try{
            Statement stat = connection.createStatement();
            String sql = "SELECT MAX(kd_divisi) as id FROM divisi";
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                Object[ ] obj = new Object[1];
                obj[0] = res.getString("id");
                if(obj[0] == null){
                    obj[0] = "00";
                }
                String str_kd = (String) obj[0];
                String kd = str_kd.substring(1, 2);
                int int_code = Integer.parseInt(kd);
                int_code++;
                String aa = String.format("%02d", int_code);
                String b = aa;
                tId.setText(b);
                tId.setEditable(false);
            }
            //Table.setModel(model);
        }catch(SQLException err){
            err.printStackTrace();
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
        tId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tDivisi = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Divisi");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Data Divisi");

        jLabel2.setText("ID Divisi");

        jLabel3.setText("Nama Divisi");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.setMaximumSize(new java.awt.Dimension(67, 23));
        btnUbah.setMinimumSize(new java.awt.Dimension(67, 23));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.setMaximumSize(new java.awt.Dimension(67, 23));
        btnHapus.setMinimumSize(new java.awt.Dimension(67, 23));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.setMaximumSize(new java.awt.Dimension(67, 23));
        btnReset.setMinimumSize(new java.awt.Dimension(67, 23));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tDivisi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tId)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Cari");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Divisi", "Nama Divisi"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        btnCari.setText("Cari");
        btnCari.setMaximumSize(new java.awt.Dimension(67, 23));
        btnCari.setMinimumSize(new java.awt.Dimension(67, 23));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.setMaximumSize(new java.awt.Dimension(67, 23));
        btnRefresh.setMinimumSize(new java.awt.Dimension(67, 23));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(!tId.getText().trim().isEmpty() && !tDivisi.getText().trim().isEmpty()){
            insert();
            refresh();
            reset();
            JOptionPane.showMessageDialog(this, "Divisi ditambahkan",
                    "Notifikasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Lengkapi data",
                    "Notifikasi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if(!tId.getText().trim().isEmpty()){
            int alert = JOptionPane.showConfirmDialog(this, "Hapus Data ini?",
                    "Notifikasi", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(alert == JOptionPane.YES_OPTION){
                delete();
                refresh();
                reset();
                JOptionPane.showMessageDialog(this, "Data terhapus",
                        "Notifikasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Pilih data dulu",
                    "Notifikasi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        if(!tId.getText().trim().isEmpty()){
            if(!tId.getText().trim().isEmpty() && !tDivisi.getText().trim().isEmpty()){
                update();
                refresh();
                reset();
                JOptionPane.showMessageDialog(this, "Data Berhasil diubah",
                        "Notifikasi", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Pilih data dulu",
                    "Notifikasi", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        if(!tCari.getText().trim().isEmpty()){
            model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            search();
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
        tId.setText(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
        tDivisi.setText(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
        tId.setEditable(false);
        btnSimpan.setEnabled(false);
        btntrue();
    }//GEN-LAST:event_tableMouseClicked

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
            java.util.logging.Logger.getLogger(Fdivisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fdivisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fdivisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fdivisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fdivisi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tCari;
    private javax.swing.JTextField tDivisi;
    private javax.swing.JTextField tId;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
