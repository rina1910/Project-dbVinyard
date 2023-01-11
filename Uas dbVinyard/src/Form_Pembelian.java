/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement; import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat; import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class Form_Pembelian extends javax.swing.JFrame {
DefaultTableModel tabelModel;
    /**
     * Creates new form Form_Pembelian
     */
    public Form_Pembelian() {
        initComponents();
        
        tabelModel = new DefaultTableModel(); 
        tblPembelian.setModel(tabelModel);
        
        tabelModel.addColumn("No Pembelian");
        tabelModel.addColumn("No Faktur");
        tabelModel.addColumn("Tanggal");
        tabelModel.addColumn("Jam");
        tabelModel.addColumn("Kode Pembeli");
        tabelModel.addColumn("Nama Pembeli");
        tabelModel.addColumn("Kode Penjual");
        tabelModel.addColumn("Nama Penjual");
        tabelModel.addColumn("Kode Wine");
        tabelModel.addColumn("Nama Wine");
        tabelModel.addColumn("Merk");
        tabelModel.addColumn("Warna");
        tabelModel.addColumn("Tahun");
        tabelModel.addColumn("Harga");
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
            String query = "SELECT * FROM tb_pembelian";
            
            ResultSet rs = state.executeQuery(query);
            
            while(rs.next())
            {
              Object obj[] = new Object[14];
              obj[0] = rs.getString(1);
              obj[1] = rs.getString(2);
              obj[2] = rs.getString(3);
              obj[3] = rs.getString(4);
              obj[4] = rs.getString(5);
              obj[5] = rs.getString(6);
              obj[6] = rs.getString(7);
              obj[7] = rs.getString(8);
              obj[8] = rs.getString(9);
              obj[9] = rs.getString(10);
              obj[10] = rs.getString(11);
              obj[11] = rs.getString(12);
              obj[12] = rs.getString(13);
              obj[13] = rs.getString(14);

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
        String query = "INSERT INTO tb_pembelian VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement prepare = konek.prepareStatement(query);

        prepare.setString(1, txtNoP.getText());
        prepare.setString(2, txtNoF.getText());
        prepare.setString(3, (String) cmbTgl.getSelectedItem());
        prepare.setString(4, txtJam.getText());
        prepare.setString(5, txtKodePembeli.getText());
        prepare.setString(6, txtNamaPembeli.getText());
        prepare.setString(7, txtKodePenjual.getText());
        prepare.setString(8, txtNamaPenjual.getText());
        prepare.setString(9, txtKodeWine.getText());
        prepare.setString(10, txtNamaWine.getText());
        prepare.setString(11, txtMerk.getText());
        prepare.setString(12, txtWarna.getText());
        prepare.setString(13, txtTahun.getText());
        prepare.setString(14, txtHarga.getText());
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
            String query = "UPDATE tb_pembelian SET no_faktur = ?, tgl = ?, jam = ?, kode_pembeli = ?, nama_pembeli = ?, kode_penjual = ?, nama_penjual = ?, kode_wine = ?, nama_wine = ?, merk = ?, warna = ?, tahun = ?, Harga = ? WHERE no_pembelian = ?";
            PreparedStatement prepare = konek.prepareStatement(query);
        
        prepare.setString(1, txtNoF.getText());
        prepare.setString(2, (String) cmbTgl.getSelectedItem());
        prepare.setString(3, txtJam.getText());
        prepare.setString(4, txtKodePembeli.getText());
        prepare.setString(5, txtNamaPembeli.getText());
        prepare.setString(6, txtKodePenjual.getText());
        prepare.setString(7, txtNamaPenjual.getText());
        prepare.setString(8, txtKodeWine.getText());
        prepare.setString(9, txtNamaWine.getText());
        prepare.setString(10, txtMerk.getText());
        prepare.setString(11, txtWarna.getText());
        prepare.setString(12, txtTahun.getText());
        prepare.setString(13, txtHarga.getText());
        prepare.setString(14, txtNoP.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            prepare.close();
           } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah");
            System.out.println(ex);
           } finally {
            refresh();
            tampilTabel();
            setJam();
      }
     }
      
       public void hapus(){
        try {
        Connection konek = Koneksi.getKoneksi();
        String query = "DELETE FROM tb_pembelian WHERE no_pembelian = ?";
        PreparedStatement prepare = konek.prepareStatement(query);
        
        prepare.setString(1, txtNoP.getText());
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
       
    public void refresh (){
      txtNoP.setText(" ");
      txtNoF.setText(" ");
      txtJam.setText(" ");
      txtKodePembeli.setText(" ");
      txtNamaPembeli.setText(" ");
      txtKodePenjual.setText(" ");
      txtNamaPenjual.setText(" ");
      txtKodeWine.setText(" ");
      txtNamaWine.setText(" ");
      txtMerk.setText(" ");
      txtWarna.setText(" ");
      txtTahun.setText(" ");
      txtHarga.setText(" ");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPembelian = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        txtNoP = new javax.swing.JTextField();
        txtNoF = new javax.swing.JTextField();
        cmbTgl = new org.freixas.jcalendar.JCalendarCombo();
        txtJam = new javax.swing.JTextField();
        txtKodePembeli = new javax.swing.JTextField();
        txtKodePenjual = new javax.swing.JTextField();
        txtNamaPenjual = new javax.swing.JTextField();
        txtKodeWine = new javax.swing.JTextField();
        txtNamaWine = new javax.swing.JTextField();
        txtMerk = new javax.swing.JTextField();
        txtWarna = new javax.swing.JTextField();
        txtTahun = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNamaPembeli = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblwaktu = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("FORM TRANSAKSI PEMBELIAN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("No Pembelian :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 140, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("No Faktur :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 110, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Tanggal :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 110, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Jam :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 60, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Kode pembeli :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 120, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Kode Penjual :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 70, 110, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Nama Penjual :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 124, 140, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Kode Wine :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 170, 120, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Nama Wine :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 220, 120, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Merk :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 270, 80, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Warna :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 320, 90, 20));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Tahun :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 370, 100, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Harga :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 420, 70, 20));

        tblPembelian.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPembelianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPembelian);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 1390, 270));

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 100, 40));

        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel1.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 350, 100, 40));

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 420, 100, 40));

        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 100, 40));

        btnKeluar.setText("KELUAR");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        jPanel1.add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 110, 40));
        jPanel1.add(txtNoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 180, 30));
        jPanel1.add(txtNoF, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 180, 30));

        cmbTgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTglActionPerformed(evt);
            }
        });
        jPanel1.add(cmbTgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 180, 30));
        jPanel1.add(txtJam, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 180, 30));
        jPanel1.add(txtKodePembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 180, 30));
        jPanel1.add(txtKodePenjual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 70, 180, 30));
        jPanel1.add(txtNamaPenjual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 120, 180, 30));
        jPanel1.add(txtKodeWine, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 170, 180, 30));
        jPanel1.add(txtNamaWine, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 220, 180, 30));
        jPanel1.add(txtMerk, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 270, 180, 30));
        jPanel1.add(txtWarna, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 320, 180, 30));
        jPanel1.add(txtTahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 370, 180, 30));
        jPanel1.add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 420, 180, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Nama Pembeli :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 150, 30));
        jPanel1.add(txtNamaPembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 180, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("JAM");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        lblwaktu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblwaktu.setText("lblwaktu");
        jPanel1.add(lblwaktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));

        jLabel18.setText("jLabel18");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, -310, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1470, 870));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPembelianMouseClicked
        // TODO add your handling code here:
        int a = tblPembelian.getSelectedRow();
        if(a == -1) {
            return;
        }
         String NoPembelian = (String) tabelModel.getValueAt(a, 0);
        txtNoP.setText(NoPembelian);
         String NoFaktur = (String) tabelModel.getValueAt(a, 1);
        txtNoF.setText(NoFaktur);
         String tgl = (String) tabelModel.getValueAt(a, 2);
        cmbTgl.setSelectedItem(tgl);
         String Jam = (String) tabelModel.getValueAt(a, 3);
        txtJam.setText(Jam);
         String KodePembeli = (String) tabelModel.getValueAt(a, 4);
        txtKodePembeli.setText(KodePembeli);
         String NamaPembeli = (String) tabelModel.getValueAt(a, 5);
        txtNamaPembeli.setText(NamaPembeli);
         String KodePenjual = (String) tabelModel.getValueAt(a, 6);
        txtKodePenjual.setText(KodePenjual);
         String NamaPenjual = (String) tabelModel.getValueAt(a, 7);
        txtNamaPenjual.setText(NamaPenjual);
         String KodeWine = (String) tabelModel.getValueAt(a, 8);
        txtKodeWine.setText(KodeWine);
         String NamaWine = (String) tabelModel.getValueAt(a, 9);
        txtNamaWine.setText(NamaWine);
         String Merk = (String) tabelModel.getValueAt(a, 10);
        txtMerk.setText(Merk);
         String Warna = (String) tabelModel.getValueAt(a, 11);
        txtWarna.setText(Warna);
         String Tahun = (String) tabelModel.getValueAt(a, 12);
        txtTahun.setText(Tahun);
         String Harga = (String) tabelModel.getValueAt(a, 13);
        txtHarga.setText(Harga);
        
    }//GEN-LAST:event_tblPembelianMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        simpan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        ubah();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        hapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
        int jawab = javax.swing.JOptionPane.showConfirmDialog(null, "yakin mau keluar","Konfirmasi", javax.swing.JOptionPane.YES_NO_OPTION);
        if (jawab==0) this.dispose();
        new Form_Utama_Member().show();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void cmbTglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTglActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Pembelian().setVisible(true);
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblwaktu;
    private javax.swing.JTable tblPembelian;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextField txtKodePembeli;
    private javax.swing.JTextField txtKodePenjual;
    private javax.swing.JTextField txtKodeWine;
    private javax.swing.JTextField txtMerk;
    private javax.swing.JTextField txtNamaPembeli;
    private javax.swing.JTextField txtNamaPenjual;
    private javax.swing.JTextField txtNamaWine;
    private javax.swing.JTextField txtNoF;
    private javax.swing.JTextField txtNoP;
    private javax.swing.JTextField txtTahun;
    private javax.swing.JTextField txtWarna;
    // End of variables declaration//GEN-END:variables
}
