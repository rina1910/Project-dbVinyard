/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class Form_Faktur extends javax.swing.JFrame {
DefaultTableModel tabelModel;
    /**
     * Creates new form Form_Faktur
     */
    public Form_Faktur() {
        initComponents();
        tabelModel = new DefaultTableModel(); 
        tblFaktur.setModel(tabelModel);
        
        tabelModel.addColumn("NoFaktur");
        tabelModel.addColumn("KodePembeli");
        tabelModel.addColumn("KodeWine");
        tabelModel.addColumn("Tgl");
        tabelModel.addColumn("Jam");
        cmbTgl.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        
        tampilTabel();
        setJam();
    }

    public void tampilTabel() {
        tabelModel.getDataVector().removeAllElements();
        tabelModel.fireTableDataChanged();
    
        try
        {
            Connection konek = Koneksi.getKoneksi();
            Statement state = konek.createStatement();
            String query = "SELECT * FROM tb_faktur";
            
            ResultSet rs = state.executeQuery(query);
            
            while(rs.next())
            {
              Object obj[] = new Object[5];
              obj[0] = rs.getString(1);
              obj[1] = rs.getString(2);
              obj[2] = rs.getString(3);
              obj[3] = rs.getString(4);
              obj[4] = rs.getString(5);

               tabelModel.addRow(obj);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);

        }
    }
    
    public final void setJam(){
ActionListener taskPerformer = new ActionListener() {

            @Override
public void actionPerformed(ActionEvent evt) {
String nol_jam = "", nol_menit = "",nol_detik = "";

java.util.Date dateTime = new java.util.Date();
int nilai_jam = dateTime.getHours();
int nilai_menit = dateTime.getMinutes();
int nilai_detik = dateTime.getSeconds();

if(nilai_jam <= 9) nol_jam= "0";
if(nilai_menit <= 9) nol_menit= "0";
if(nilai_detik <= 9) nol_detik= "0";

String jam = nol_jam + Integer.toString(nilai_jam);
String menit = nol_menit + Integer.toString(nilai_menit);
String detik = nol_detik + Integer.toString(nilai_detik);

lblwaktu.setText(jam+":"+menit+":"+detik+"");
}
};
new Timer(1000, taskPerformer).start();
}
    public void simpan(){
    try {
        Connection konek = Koneksi.getKoneksi();
        String query = "INSERT INTO tb_faktur VALUES(?,?,?,?,?)";
        PreparedStatement prepare = konek.prepareStatement(query);

        prepare.setString(1, txtNoF.getText());
        prepare.setString(2, txtKodeP.getText());
        prepare.setString(3, txtKodeM.getText());
         prepare.setString(4, (String) cmbTgl.getSelectedItem());
        prepare.setString(5, txtJam.getText());
        prepare.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        prepare.close();
       }catch(Exception ex){
        JOptionPane.showMessageDialog(null, "Data gagal disimpan");
        System.out.println(ex);
       } finally
    { 
       tampilTabel();
       refresh();
       setJam();
}
}
    public void ubah(){
      try {
           Connection konek = Koneksi.getKoneksi();
            String query = "UPDATE tb_faktur SET KodePembeli = ?, KodeWine = ?, Tgl = ?, Jam = ? WHERE NoFaktur = ?";
            PreparedStatement prepare = konek.prepareStatement(query);
            
            prepare.setString(1,txtKodeP.getText());
            prepare.setString(2,txtKodeM.getText());
            prepare.setString(3,(String)cmbTgl.getSelectedItem());
            prepare.setString(4,txtJam.getText());
            prepare.setString(5,txtNoF.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            prepare.close();
           } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah");
            System.out.println(ex);
           } finally {
            refresh();
            tampilTabel();
      }
     }
    public void hapus(){
        try {
        Connection konek = Koneksi.getKoneksi();
        String query = "DELETE FROM tb_faktur WHERE NoFaktur = ?";
        PreparedStatement prepare = konek.prepareStatement(query);
        
        prepare.setString(1, txtNoF.getText());
        prepare.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        prepare.close();
       } catch(Exception ex) {
        JOptionPane.showMessageDialog(null, "Data gagal dihapus");
        System.out.println(ex);
       } finally {
       refresh();
       tampilTabel();
       setJam();
}
}
    public void refresh() {
        txtNoF.setText(" ");
        txtKodeP.setText(" ");
        txtKodeM.setText(" ");
        txtJam.setText(" ");
        txtNoF.requestFocus();
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblwaktu = new javax.swing.JLabel();
        txtNoF = new javax.swing.JTextField();
        txtKodeP = new javax.swing.JTextField();
        txtKodeM = new javax.swing.JTextField();
        txtJam = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFaktur = new javax.swing.JTable();
        cmbTgl = new org.freixas.jcalendar.JCalendarCombo();
        jLabel10 = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("FORM FAKTUR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel2.setText("No Faktur :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel3.setText("Kode Pembeli :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel4.setText("JAM :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jLabel5.setText("Kode Wine :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel6.setText("Tanggal :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel7.setText("Jam :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        lblwaktu.setText("lblwaktu");
        jPanel1.add(lblwaktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));
        jPanel1.add(txtNoF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 160, -1));

        txtKodeP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodePActionPerformed(evt);
            }
        });
        jPanel1.add(txtKodeP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 160, -1));
        jPanel1.add(txtKodeM, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 160, -1));
        jPanel1.add(txtJam, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 160, -1));

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel1.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, -1));

        btnKeluar.setText("KELUAR");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        jPanel1.add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        tblFaktur.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFaktur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFakturMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFaktur);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 440, -1));
        jPanel1.add(cmbTgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 160, -1));

        jLabel10.setText("jLabel10");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKodePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodePActionPerformed

    private void tblFakturMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFakturMouseClicked
        // TODO add your handling code here:
         int a = tblFaktur.getSelectedRow();
        if(a == -1) {
            return;
        }
        String noFaktur = (String) tabelModel.getValueAt(a, 0);
        txtNoF.setText(noFaktur);
        String KodePemb = (String) tabelModel.getValueAt(a, 1);
        txtKodeP.setText(KodePemb);
        String KodeMot = (String) tabelModel.getValueAt(a, 2);
        txtKodeM.setText(KodeMot);
        String tgl = (String) tabelModel.getValueAt(a, 3);
        cmbTgl.setSelectedItem(tgl);
        String jm = (String) tabelModel.getValueAt(a, 4);
        txtJam.setText(jm);
    }//GEN-LAST:event_tblFakturMouseClicked

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        int jawab = javax.swing.JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin mau Keluar ?", "Konfirmasi",javax.swing.JOptionPane.YES_NO_OPTION);
        if(jawab==0)this.dispose();
        new Form_Utama_Admin().show();
    }//GEN-LAST:event_btnKeluarActionPerformed
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
       simpan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        hapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        ubah();
    }//GEN-LAST:event_btnUbahActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Faktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Faktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Faktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Faktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Faktur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private org.freixas.jcalendar.JCalendarCombo cmbTgl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblwaktu;
    private javax.swing.JTable tblFaktur;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextField txtKodeM;
    private javax.swing.JTextField txtKodeP;
    private javax.swing.JTextField txtNoF;
    // End of variables declaration//GEN-END:variables
}
