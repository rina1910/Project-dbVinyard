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
 *
 * @author ASUS
 */
public class Form_Penjual extends javax.swing.JFrame {
DefaultTableModel tabelModel;
    /**
     * Creates new form Form_Penjual
     */
    public Form_Penjual() {
        initComponents();
        tabelModel = new DefaultTableModel(); 
        tblPenjual.setModel(tabelModel);
        
        tabelModel.addColumn("Kode");
        tabelModel.addColumn("Nama");
        tabelModel.addColumn("Alamat");
        tabelModel.addColumn("Pekerjaan");
        tabelModel.addColumn("Telp");
        
        tampilTabel();    }

    public void tampilTabel() {
        tabelModel.getDataVector().removeAllElements();
        tabelModel.fireTableDataChanged();
    
        try
        {
            Connection konek = Koneksi.getKoneksi();
            Statement state = konek.createStatement();
            String query = "SELECT * FROM tb_penjual";
            
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
    
    public void simpan(){
    try {
        Connection konek = Koneksi.getKoneksi();
        String query = "INSERT INTO tb_penjual VALUES(?,?,?,?,?)";
        PreparedStatement prepare = konek.prepareStatement(query);

        prepare.setString(1, txtKode.getText());
        prepare.setString(2, txtNama.getText());
        prepare.setString(3, TaAlamat.getText());
        prepare.setString(4, txtPkjn.getText());
        prepare.setString(5, txtTlp.getText());
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
            String query = "UPDATE tb_penjual SET Nama = ?, Alamat = ?, Pekerjaan = ?, Telp = ? WHERE Kode = ?";
            PreparedStatement prepare = konek.prepareStatement(query);
            prepare.setString(1, txtNama.getText());
            prepare.setString(2, TaAlamat.getText());
            prepare.setString(3, txtPkjn.getText());
            prepare.setString(4, txtTlp.getText());
            prepare.setString(5, txtKode.getText());
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
        String query = "DELETE FROM tb_penjual WHERE Kode = ?";
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
      TaAlamat.setText(" ");
      txtPkjn.setText(" ");
      txtTlp.setText(" ");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TaAlamat = new javax.swing.JTextArea();
        txtPkjn = new javax.swing.JTextField();
        txtTlp = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPenjual = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("FORM PENJUAL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel2.setText("Kode Penjual :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel3.setText("Nama :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel4.setText("Alamat :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel5.setText("Pekerjaan :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel6.setText("No Telepon :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));
        jPanel1.add(txtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 140, -1));
        jPanel1.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 140, -1));

        TaAlamat.setColumns(20);
        TaAlamat.setRows(5);
        TaAlamat.setText("\n");
        jScrollPane1.setViewportView(TaAlamat);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 140, 60));
        jPanel1.add(txtPkjn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 140, -1));
        jPanel1.add(txtTlp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, -1));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel1.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 70, -1));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 70, -1));

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        jPanel1.add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 70, -1));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 80, -1));

        tblPenjual.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPenjual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPenjualMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPenjual);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 530, -1));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        simpan ();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tblPenjualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPenjualMouseClicked
        // TODO add your handling code here:
        int a = tblPenjual.getSelectedRow();
        if(a == -1) {
            return;
        }
        String Kode = (String) tabelModel.getValueAt(a, 0);
        txtKode.setText(Kode);
         String Nama = (String) tabelModel.getValueAt(a, 1);
        txtNama.setText(Nama);
         String alamat = (String) tabelModel.getValueAt(a, 2);
        TaAlamat.setText(alamat);
         String Pekerjaan = (String) tabelModel.getValueAt(a, 3);
        txtPkjn.setText(Pekerjaan);
         String telp = (String) tabelModel.getValueAt(a, 4);
        txtTlp.setText(telp);
    }//GEN-LAST:event_tblPenjualMouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        ubah ();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        hapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        int jawab = javax.swing.JOptionPane.showConfirmDialog(null, "yakin mau keluar","Konfirmasi", javax.swing.JOptionPane.YES_NO_OPTION);
        if (jawab==0) this.dispose();
        new Form_Utama_Member().show();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Penjual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Penjual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Penjual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Penjual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Penjual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TaAlamat;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPenjual;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPkjn;
    private javax.swing.JTextField txtTlp;
    // End of variables declaration//GEN-END:variables
}