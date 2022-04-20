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
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author USER
 */
public class FaddKU extends javax.swing.JFrame {
    Connection connection;
    /**
     * Creates new form FaddKU
     */
    public FaddKU() {
        initComponents();
        connection = koneksi.getConnection();
        auto_code();
        getGender();
        getLevel();
        getDivisi();
        txtId.requestFocus();
    }
    
    private void getLevel(){
        cmbLevel.removeAllItems();
        cmbLevel.addItem("Pilih Level");
        cmbLevel.addItem("admin");
        cmbLevel.addItem("user");
    }
    
    private void getGender(){
        cmbJk.removeAllItems();
        cmbJk.addItem("Pilih Jenis Kelamin");
        cmbJk.addItem("laki-laki");
        cmbJk.addItem("perempuan");
    }
    
    private void getDivisi(){
        cmbDivisi.removeAllItems();
        cmbDivisi.addItem("Pilih Divisi");
        try{
            Statement stat = connection.createStatement();
            String sql = "SELECT * FROM divisi";
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                cmbDivisi.addItem(res.getString("nama_div"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    private String getIDdiv(String nama_div){
        String id = null;
        try{
            PreparedStatement st = connection.prepareStatement("SELECT kd_divisi FROM divisi WHERE nama_div=?",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, nama_div);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                id = rs.getString("kd_divisi");
            }
            return id;
        }catch(SQLException ex){
            Logger.getLogger(FaddKU.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    private void auto_code(){
        try{
            Statement stat = connection.createStatement();
            SimpleDateFormat mn = new SimpleDateFormat("MM");
            SimpleDateFormat yr = new SimpleDateFormat("yy");
            String bln = mn.format(new Date());
            String th = yr.format(new Date());
            String sql = "SELECT MAX(kd_karyawan) as id FROM karyawan";
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                Object[ ] obj = new Object[1];
                obj[0] = res.getString("id");
                if(obj[0] == null){
                    obj[0] = "0000000";
                }
                String str_kd = (String) obj[0];
                String kd = str_kd.substring(4, 7);
                int int_code = Integer.parseInt(kd);
                int_code++;
                String aa = String.format("%03d", int_code);
                String b = bln+th+aa;
                txtId.setText(b);
                txtId.setEditable(false);
                
            }
        }catch(SQLException err){
            err.printStackTrace();
        }
    }
    
    private void insertKaryawan(){
        PreparedStatement statment = null;
        String sql = "INSERT INTO karyawan(kd_karyawan,nama,gender,kd_divisi) VALUES(?,?,?,?)";
        try{
            statment = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statment.setString(1, txtId.getText());
            statment.setString(2, txtNama.getText());
            statment.setString(3, cmbJk.getSelectedItem().toString());
            statment.setString(4, getIDdiv(cmbDivisi.getSelectedItem().toString()));
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
    
    private void insertUser(){
        PreparedStatement statment = null;
        String sql = "INSERT INTO user(kd_karyawan,username,password,level) VALUES(?,?,?,?)";
        try{
            statment = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statment.setString(1, txtId.getText());
            statment.setString(2, txtUsername.getText());
            statment.setString(3, txtPassword.getText());
            statment.setString(4, cmbLevel.getSelectedItem().toString());
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
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbJk = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbDivisi = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        cmbLevel = new javax.swing.JComboBox<>();
        btnTambah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Tambah karyawan & user");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Tambah Karyawan & User");

        jLabel2.setText("ID Karyawan");

        jLabel3.setText("Nama Karyawan");

        jLabel4.setText("Jenis Kelamin");

        cmbJk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Divisi");

        cmbDivisi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Username");

        jLabel7.setText("Password");

        jLabel8.setText("Level");

        cmbLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(cmbJk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(cmbDivisi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(cmbLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(34, 34, 34))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbJk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        if(!txtId.getText().trim().isEmpty() && !txtNama.getText().trim().isEmpty() && cmbJk.getSelectedItem() !="Pilih Jenis Kelamin"
                && cmbDivisi.getSelectedItem() !="Pilih Divisi" && cmbLevel.getSelectedItem() !="Pilih Level" 
                && !txtUsername.getText().trim().isEmpty() && !txtPassword.getText().trim().isEmpty()){
            insertKaryawan();
            insertUser();
            JOptionPane.showMessageDialog(this, "Karyawan & User ditambahkan",
                    "Notifikasi", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            FdataKU a = new FdataKU();
            a.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Lengkapi data",
                    "Notifikasi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

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
            java.util.logging.Logger.getLogger(FaddKU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FaddKU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FaddKU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FaddKU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FaddKU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbDivisi;
    private javax.swing.JComboBox<String> cmbJk;
    private javax.swing.JComboBox<String> cmbLevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNama;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
