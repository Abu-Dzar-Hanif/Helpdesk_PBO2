/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author USER
 */
public class rSTS extends javax.swing.JFrame {
JasperReport jasRep;
JasperPrint jasPrint;
Map param = new HashMap();
JasperDesign jasdes;
 Connection connection;
    /**
     * Creates new form rSTS
     */
    public rSTS() {
        initComponents();
        connection = koneksi.getConnection();
        addcombo();
    }
    
    public void addcombo(){
        cmbSTS.removeAllItems();
        cmbSTS.addItem("all");
        cmbSTS.addItem("waiting");
        cmbSTS.addItem("on proses");
        cmbSTS.addItem("done");
    }
    
    public void laporan(){
        try{
            File report = new File("src/report/report1.jrxml");
            HashMap hash = new HashMap(1);
            String sts = cmbSTS.getSelectedItem().toString();
            hash.put("sts",sts);
            jasdes = JRXmlLoader.load(report);
            jasRep = JasperCompileManager.compileReport(jasdes);
            jasPrint = JasperFillManager.fillReport(jasRep, hash,connection);
            JasperViewer.viewReport(jasPrint,false);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Gagal Membuka Laporan", "Cetak Laporan",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void laporan_all(){
        try{
            File report = new File("src/report/report2.jrxml");
            jasdes = JRXmlLoader.load(report);
            jasRep = JasperCompileManager.compileReport(jasdes);
            jasPrint = JasperFillManager.fillReport(jasRep, null,connection);
            JasperViewer.viewReport(jasPrint,false);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Gagal Membuka Laporan", "Cetak Laporan",
                    JOptionPane.ERROR_MESSAGE);
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

        cmbSTS = new javax.swing.JComboBox<>();
        btn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbSTS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn1.setText("jButton1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        jLabel1.setText("staus");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btn1)
                    .addComponent(cmbSTS, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(251, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbSTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn1)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        String a = "all";
        if(a.equals(cmbSTS.getSelectedItem().toString())){
            laporan_all();
        }else{
        laporan();    
        }
        
    }//GEN-LAST:event_btn1ActionPerformed

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
            java.util.logging.Logger.getLogger(rSTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rSTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rSTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rSTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rSTS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JComboBox<String> cmbSTS;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
