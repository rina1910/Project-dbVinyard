/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement; import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat; import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
/**
 *
 * @author ASUS
 */
public class Form_Penjualan extends javax.swing.JFrame {
DefaultTableModel tabelModel;
    /**
     * Creates new form Form_Penjualan
     */
    public Form_Penjualan() {
        initComponents();
        tabelModel = new DefaultTableModel(); 
        tblWine.setModel(tabelModel);
        
        tabelModel.addColumn("Kode");
        tabelModel.addColumn("Nama");
        tabelModel.addColumn("Merk");
        tabelModel.addColumn("Warna");
        tabelModel.addColumn("Tahun");
        tabelModel.addColumn("Harga");
        tampilTabel();
    }
    
    public void tampilTabel() {
        tabelModel.getDataVector().removeAllElements();
        tabelModel.fireTableDataChanged();
    
        try
        {
            Connection konek = Koneksi.getKoneksi();
            Statement state = konek.createStatement();
            String query = "SELECT * FROM tb_penjualan";
            
            ResultSet rs = state.executeQuery(query);
            
            while(rs.next())
            {
              Object obj[] = new Object[6];
              obj[0] = rs.getString(1);
              obj[1] = rs.getString(2);
              obj[2] = rs.getString(3);
              obj[3] = rs.getString(4);
              obj[4] = rs.getString(5);
              obj[5] = rs.getString(6);

               tabelModel.addRow(obj);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);

        }
    }
    
    public void simpan(){
    try {
        Connection konek = Koneksi.getKoneksi();
        String query = "INSERT INTO tb_penjualan VALUES(?,?,?,?,?,?)";
        PreparedStatement prepare = konek.prepareStatement(query);

        prepare.setString(1, txtKode.getText());
        prepare.setString(2, txtNama.getText());
        prepare.setString(3, txtMerk.getText());
        prepare.setString(4, txtWarna.getText());
        prepare.setString(5, txtThn.getText());
        prepare.setString(6, txtHarga.getText());
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
}
}
    public void ubah(){
      try {
            Connection konek = Koneksi.getKoneksi();
            String query = "UPDATE tb_penjualan SET Nama = ?, Merk = ?, Warna = ?, Tahun = ?, Harga = ? WHERE Kode = ?";
            PreparedStatement prepare = konek.prepareStatement(query);
            prepare.setString(1, txtNama.getText());
            prepare.setString(2, txtMerk.getText());
            prepare.setString(3, txtWarna.getText());
            prepare.setString(4, txtThn.getText());
            prepare.setString(5, txtHarga.getText());
            prepare.setString(6, txtKode.getText());
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
        String query = "DELETE FROM tb_penjualan WHERE Kode = ?";
        PreparedStatement prepare = konek.prepareStatement(query);
        
        prepare.setString(1, txtKode.getText());
        prepare.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        prepare.close();
       } catch(Exception ex) {
        JOptionPane.showMessageDialog(null, "Data gagal dihapus");
        System.out.println(ex);
       } finally {
       refresh();
       tampilTabel();
}
}
    
    public void refresh (){
      txtKode.setText(" ");
      txtNama.setText(" ");
      txtMerk.setText(" ");
      txtWarna.setText(" ");
      txtThn.setText(" ");
      txtHarga.setText(" ");
      txtNama.requestFocus();
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWine = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtMerk = new javax.swing.JTextField();
        txtWarna = new javax.swing.JTextField();
        txtThn = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("FORM PENJUALAN WINE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jLabel2.setText("Kode Wine :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 100, -1));

        jLabel3.setText("Nama Wine :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 110, 20));

        jLabel4.setText("Merk :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 60, 20));

        jLabel5.setText("Warna :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 60, 20));

        jLabel6.setText("Tahun :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 60, 20));

        jLabel7.setText("Harga :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 40, 20));

        tblWine.setModel(new javax.swing.table.DefaultTableModel(
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
        tblWine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblWineMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblWine);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 560, -1));

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 80, -1));

        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel1.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 80, -1));

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 80, -1));

        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 80, -1));

        btnKeluar.setText("KELUAR");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        jPanel1.add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 80, -1));
        jPanel1.add(txtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 180, -1));
        jPanel1.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 180, -1));
        jPanel1.add(txtMerk, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 180, -1));
        jPanel1.add(txtWarna, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 180, -1));
        jPanel1.add(txtThn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 180, -1));
        jPanel1.add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 180, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("DAFTAR WINE YANG DIJUAL");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/logo v.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, 360));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblWineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblWineMouseClicked
        // TODO add your handling code here:
        int a = tblWine.getSelectedRow();
        if(a == -1) {
            return;
        }
        String Kode = (String) tabelModel.getValueAt(a, 0);
        txtKode.setText(Kode);
         String Nama = (String) tabelModel.getValueAt(a, 1);
        txtNama.setText(Nama);
         String Merk = (String) tabelModel.getValueAt(a, 2);
        txtMerk.setText(Merk);
         String Warna = (String) tabelModel.getValueAt(a, 3);
        txtWarna.setText(Warna);
         String Tahun = (String) tabelModel.getValueAt(a, 4);
        txtThn.setText(Tahun);
         String Harga = (String) tabelModel.getValueAt(a, 5);
        txtHarga.setText(Harga);
    }//GEN-LAST:event_tblWineMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        simpan ();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        ubah ();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        hapus ();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        refresh ();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        int jawab = javax.swing.JOptionPane.showConfirmDialog(null, "yakin mau keluar","Konfirmasi", javax.swing.JOptionPane.YES_NO_OPTION);
        if (jawab==0) this.dispose();
        new Form_Utama_Member().show();
    }//GEN-LAST:event_btnKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblWine;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtMerk;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtThn;
    private javax.swing.JTextField txtWarna;
    // End of variables declaration//GEN-END:variables
}