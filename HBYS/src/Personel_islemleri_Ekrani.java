/**
 *
 * @author samet
 */
import java.awt.Dimension;
import java.awt.Toolkit;

public class Personel_islemleri_Ekrani extends javax.swing.JFrame {

    public static void main(String[] args) {
        new Personel_islemleri_Ekrani().setVisible(true);
    }
    
    public Personel_islemleri_Ekrani() {
        initComponents();
        
        setTitle("Personel İşlemleri Ekranı");
        
        //Pencereyi ekranin ortasina alabilmek icin
        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        ozluk = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        kimlik_bilgileri_kayit = new javax.swing.JMenuItem();
        kimlik_bilgileri_arama = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        sistem = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        tanimlamalar = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu2.setText("jMenu2");

        jMenu5.setText("jMenu5");

        jMenu1.setText("jMenu1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenu3.setText("File");
        jMenuBar3.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar3.add(jMenu4);

        jMenu6.setText("File");
        jMenuBar4.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("File");
        jMenuBar5.add(jMenu8);

        jMenu9.setText("Edit");
        jMenuBar5.add(jMenu9);

        jMenuItem6.setText("jMenuItem6");

        jMenu15.setText("jMenu15");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jMenuItem17.setText("jMenuItem17");

        jMenuItem9.setText("jMenuItem9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(153, 153, 153));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tip.png"))); // NOI18N

        ozluk.setText("Özlük");
        ozluk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ozlukActionPerformed(evt);
            }
        });

        jMenu10.setText("Kimlik Bilgileri Ekranı");

        kimlik_bilgileri_kayit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        kimlik_bilgileri_kayit.setText("Kimlik Bilgileri Kayıt Ekranı");
        kimlik_bilgileri_kayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kimlik_bilgileri_kayitActionPerformed(evt);
            }
        });
        jMenu10.add(kimlik_bilgileri_kayit);

        kimlik_bilgileri_arama.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        kimlik_bilgileri_arama.setText("Kimlik Bilgileri Arama Ekranı");
        kimlik_bilgileri_arama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kimlik_bilgileri_aramaActionPerformed(evt);
            }
        });
        jMenu10.add(kimlik_bilgileri_arama);

        ozluk.add(jMenu10);

        jMenuItem7.setText("Nüfus Bilgileri Giriş Ekranı");
        ozluk.add(jMenuItem7);

        jMenuItem8.setText("Görev Kaydı Giriş Ekranı");
        ozluk.add(jMenuItem8);

        jMenuBar2.add(ozluk);

        sistem.setText("Sistem");

        jMenuItem15.setText("Kullanıcı Tanımlama");
        sistem.add(jMenuItem15);

        jMenuItem16.setText("Rol Grupları Tanımlama");
        sistem.add(jMenuItem16);

        jMenuBar2.add(sistem);

        tanimlamalar.setText("Tanımlamalar");

        jMenuItem5.setText("İl");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        tanimlamalar.add(jMenuItem5);

        jMenuItem10.setText("İlçe");
        tanimlamalar.add(jMenuItem10);

        jMenuItem11.setText("Ünvan");
        tanimlamalar.add(jMenuItem11);

        jMenuItem13.setText("Görev");
        tanimlamalar.add(jMenuItem13);

        jMenuItem12.setText("Görev Yeri");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        tanimlamalar.add(jMenuItem12);

        jMenuItem14.setText("Sözlük");
        tanimlamalar.add(jMenuItem14);

        jMenuBar2.add(tanimlamalar);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void ozlukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ozlukActionPerformed
     
      
        
    }//GEN-LAST:event_ozlukActionPerformed

    private void kimlik_bilgileri_kayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kimlik_bilgileri_kayitActionPerformed
      
        this.setVisible(false);
        
        KimlikBilgileriEkrani ekran = new KimlikBilgileriEkrani();
        
        ekran.setVisible(true);
        
    }//GEN-LAST:event_kimlik_bilgileri_kayitActionPerformed

    private void kimlik_bilgileri_aramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kimlik_bilgileri_aramaActionPerformed
      
        this.setVisible(false);
        
        Kimlik_bilgileri_arama_ekrani ekran = new Kimlik_bilgileri_arama_ekrani();
        
        ekran.setVisible(true);
        
    }//GEN-LAST:event_kimlik_bilgileri_aramaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem kimlik_bilgileri_arama;
    private javax.swing.JMenuItem kimlik_bilgileri_kayit;
    private javax.swing.JMenu ozluk;
    private javax.swing.JMenu sistem;
    private javax.swing.JMenu tanimlamalar;
    // End of variables declaration//GEN-END:variables
}
