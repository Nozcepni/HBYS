/**
 *
 * @author Nahit
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class PerKullaniciGirisEkrani extends javax.swing.JFrame {

    HbysIslem islemler = new HbysIslem();  //Database'e baglanmak icin 
    
    int tc_uzunluk = 11;
    
    public PerKullaniciGirisEkrani()
    
    {
    
        setTitle("Kullanıcı Giriş Ekranı");
        
        initComponents();
        
        // Pencereyi ekranin ortasina alabilmek icin 
        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        
        
    }
    
    public static void main(String[] args) {
        new PerKullaniciGirisEkrani().setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jRadioButton1 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        tc_kimlik_label = new javax.swing.JLabel();
        sifre_label = new javax.swing.JLabel();
        tc_kimlik_alanı = new javax.swing.JTextField();
        sifre_alani = new javax.swing.JPasswordField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jRadioButton2 = new javax.swing.JRadioButton();
        giris = new javax.swing.JButton();
        hbys_label = new javax.swing.JLabel();
        personel_giris_label = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(400, 200, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tc_kimlik_label.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tc_kimlik_label.setForeground(new java.awt.Color(0, 51, 255));
        tc_kimlik_label.setText("TC Kimlik Numarası:");

        sifre_label.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        sifre_label.setForeground(new java.awt.Color(0, 51, 255));
        sifre_label.setText("Şifre:");

        tc_kimlik_alanı.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tc_kimlik_alanıKeyTyped(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 51, 51));
        jRadioButton2.setText("Şifreyi Göster");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRadioButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseReleased(evt);
            }
        });

        giris.setForeground(new java.awt.Color(0, 51, 51));
        giris.setText("Giriş Yap");
        giris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girisActionPerformed(evt);
            }
        });

        hbys_label.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        hbys_label.setForeground(new java.awt.Color(255, 0, 0));
        hbys_label.setText("Hastane Bilgi Yönetim Sistemi   ");

        personel_giris_label.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        personel_giris_label.setForeground(new java.awt.Color(255, 51, 51));
        personel_giris_label.setText("Personel Girişi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(giris))
                            .addComponent(hbys_label)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tc_kimlik_label)
                                    .addComponent(sifre_label))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sifre_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tc_kimlik_alanı, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(personel_giris_label)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(hbys_label, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(personel_giris_label)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tc_kimlik_label)
                    .addComponent(tc_kimlik_alanı, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sifre_label)
                    .addComponent(sifre_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jRadioButton2)
                .addGap(30, 30, 30)
                .addComponent(giris)
                .addGap(124, 124, 124)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 634, 512);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MousePressed
        
        sifre_alani.setEchoChar((char)0);    // Karakterleri görünür yapmak için
        
        jRadioButton2.doClick();                 // Radiobutton tıklanmış şekilde dursun diye
        
        
    }//GEN-LAST:event_jRadioButton2MousePressed

    private void jRadioButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseReleased
       
        sifre_alani.setEchoChar('*');      // Karakterleri gizlemek için
        
       jRadioButton2.doClick(0);              // Radiobutton tıklanmış halden çıkması için
       
        
    }//GEN-LAST:event_jRadioButton2MouseReleased

    private void girisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girisActionPerformed
        
        String tc = tc_kimlik_alanı.getText();
        String sifre = new String(sifre_alani.getPassword());
        
        if(tc.length() <11 )
        {
            JOptionPane.showMessageDialog(this,"TC Kimlik Numaranızı Eksik Tuşladınız","UYARI",JOptionPane.WARNING_MESSAGE);
            
            return;
        }
        
        boolean giristc = islemler.girisYapTc(tc);
        boolean girissifre = islemler.girisYapSifre(sifre);
        
         
        if(giristc == true && girissifre == true)
        {
          Personel_islemleri_Ekrani ekran = new Personel_islemleri_Ekrani();
            ekran.setVisible(true);
            this.setVisible(false);
        }
        
       
        
        else if (giristc == true && girissifre != true)
        {
           JOptionPane.showMessageDialog(this,"Girdiğiniz TC'ye Ait Şifre Hatalı Girilmiştir!","UYARI",JOptionPane.WARNING_MESSAGE);
           return;
        }
        else
        {
             JOptionPane.showMessageDialog(this,"Giriş Başarısız Oldu Tekrar Deneyiniz","UYARI",JOptionPane.WARNING_MESSAGE);
             return;
        }
        
        
    }//GEN-LAST:event_girisActionPerformed

    private void tc_kimlik_alanıKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tc_kimlik_alanıKeyTyped
        String metin = tc_kimlik_alanı.getText();
            tc_uzunluk = metin.length();

        char karakter = evt.getKeyChar();

        if( !(Character.isDigit(karakter)) || tc_uzunluk==11  )
        {
            evt.consume();
        }
        
        //Sadece numerık ıfade girilebilsin ve uzunluk 11
        
    }//GEN-LAST:event_tc_kimlik_alanıKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton giris;
    private javax.swing.JLabel hbys_label;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JLabel personel_giris_label;
    private javax.swing.JPasswordField sifre_alani;
    private javax.swing.JLabel sifre_label;
    private javax.swing.JTextField tc_kimlik_alanı;
    private javax.swing.JLabel tc_kimlik_label;
    // End of variables declaration//GEN-END:variables
}
