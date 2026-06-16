package tampilan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import tampilan.nota;
import koneksi.koneksi;

public class PopUp_Pelanggan extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    public nota plg = null;
    public PopUp_Pelanggan() {
        initComponents();
        datatable();
    }
    

    protected void datatable(){
        Object[] Baris = {"ID Pelanggan", "Nama", "Jenis Kelamin", "No. Telepon", "Alamat"};
        tabmode = new DefaultTableModel(null, Baris);

        String cariitem = tcari.getText();

        try {

            String sql = "SELECT * FROM pelanggan where id like '%"+cariitem+ "%' or nmplg like '%"+cariitem+"%' order by id asc";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()){
            tabmode.addRow(new Object[]{
            hasil.getString(1),
            hasil.getString(2),
            hasil.getString(3),
            hasil.getString(4),
            hasil.getString(5)
        });
    }

        tblPlg.setModel(tabmode);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlg = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();

        tblPlg.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblPlg.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPlg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlgMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPlg);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("Data Pelanggan");

        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tcariKeyPressed(evt);
            }
        });

        bcari.setText("cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bcari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPlgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlgMouseClicked
        int tabelPelanggan = tblPlg.getSelectedRow();
        plg.id = tblPlg.getValueAt(tabelPelanggan, 0).toString();
        plg.nama = tblPlg.getValueAt(tabelPelanggan, 1).toString();
        plg.jk = tblPlg.getValueAt(tabelPelanggan, 2).toString();
        plg.telp = tblPlg.getValueAt(tabelPelanggan, 3).toString();
        plg.almt = tblPlg.getValueAt(tabelPelanggan, 4).toString();
        plg.itemTerpilih();
        this.dispose();

    }//GEN-LAST:event_tblPlgMouseClicked

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        datatable();
    }//GEN-LAST:event_bcariActionPerformed

    private void tcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            datatable();
        }
    }//GEN-LAST:event_tcariKeyPressed

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
            java.util.logging.Logger.getLogger(PopUp_Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopUp_Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopUp_Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopUp_Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPlg;
    private javax.swing.JTextField tcari;
    // End of variables declaration//GEN-END:variables
}
