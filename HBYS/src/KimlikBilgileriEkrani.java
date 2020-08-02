import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;


    public class KimlikBilgileriEkrani extends javax.swing.JFrame {
        
     
     HbysIslem islem = new HbysIslem();
     
     int tc_uzunluk = 11;
     int sicil_no = 6;
     int ad_uzunluk = 30;
     int soyad_uzunluk = 30;
     public String deger = "";
     public Object item = null;
     
     public Connection con = islem.con;
    
     public Statement statement = null;
    
     public PreparedStatement preparedstatement= null;
     
     public  ResultSet resultset = null;
    
    public KimlikBilgileriEkrani() {
        
        
        
        setTitle("Kimlik Bilgileri Kayıt Ekranı");
        
        initComponents();
        
        //Pencereyi ekranın ortasına alabilmek için 
        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
         //BÜYÜK HARF EKLEME ALANI
        DocumentFilter filter = new UppercaseDocumentFilter();
        
        AbstractDocument Ad_field_doc = (AbstractDocument) Ad_field.getDocument();
        Ad_field_doc.setDocumentFilter(filter);
        
        AbstractDocument Soyad_field_doc = (AbstractDocument) Soyad_field.getDocument();
        Soyad_field_doc.setDocumentFilter(filter);
        
         //GOREV COMBOBOX DOLDURMA İŞLEMLERİ
        String gorev_sorgu ="Select gorev_kodu,gorev_adi"
                      + " from per_gorevler";
    
        HbysIslem islem = new HbysIslem();
    
        ResultSet rs = islem.Getir(gorev_sorgu );
        
         try 
        {
            while (rs.next())
            { 
                
                gorev_combo_box.addItem(new ComboItem(rs.getString("gorev_adi"),rs.getString("gorev_kodu")));
            }

        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(HbysIslem.class.getName()).log(Level.SEVERE, null, ex);
        }
     
         //UNVAN COMBOBOX DOLDURMA İŞLEMLERİ
         String unvan_sorgu ="Select unv_kodu,unv_adi"
                       + " from per_unvanlar";
    
    
        rs = islem.Getir(unvan_sorgu);
    
        try 
        {
            while (rs.next())
            { 
                
                unvan_combo_box.addItem(new ComboItem(rs.getString("unv_adi"),rs.getString("unv_kodu")));
            }

        } 
            catch (SQLException ex)
            {
            Logger.getLogger(HbysIslem.class.getName()).log(Level.SEVERE, null, ex);
            }
     
     
         //ISTIHDAM COMBOBOX DOLDURMA İŞLEMLERİ
            String istihdam_sorgu ="Select pst_ele_kodu,pst_ele_adi"
                                              + " from per_sozluk_tablo "
                                              + "where pst_tablo_kodu=1";
    
    
             rs = islem.Getir(istihdam_sorgu);
    
      
      
             try 
            {
            while (rs.next())
            { 
                
                istihdam_combo_box.addItem(new ComboItem(rs.getString("pst_ele_adi").toUpperCase(),rs.getString("pst_ele_kodu")));
            }

             } 
             catch (SQLException ex) 
             {
            Logger.getLogger(HbysIslem.class.getName()).log(Level.SEVERE, null, ex);
             }
     
             //GOREV DURUMU COMBOBOX DOLDURMA İŞLEMLERİ
     
            String gorev_durumu ="Select pst_ele_kodu,pst_ele_adi"
                                              + " from per_sozluk_tablo "
                                              + "where pst_tablo_kodu=3";
    
      
              rs = islem.Getir(gorev_durumu);
    
             try 
            {
            while (rs.next())
            { 
                
                gorev_durumu_combo_box.addItem(new ComboItem(rs.getString("pst_ele_adi").toUpperCase(),rs.getString("pst_ele_kodu")));
            }

            } 
             catch (SQLException ex) 
             {
            Logger.getLogger(HbysIslem.class.getName()).log(Level.SEVERE, null, ex);
             } 
     
            //GOREV YERİ COMBOBOX DOLDURMA İŞLEMLERİ
     
             String gorev_yeri= "Select "
                        + "pg_kod,pg_ad "
                        + "from per_gorev_yerleri";
     
            rs = islem.Getir(gorev_yeri);
    
            try 
            {
            while (rs.next())
            { 
                
               gorev_yeri_combo_box.addItem(new ComboItem(rs.getString("pg_ad"),rs.getString("pg_kod")));
            }

            }
             catch (SQLException ex) 
              {
            Logger.getLogger(HbysIslem.class.getName()).log(Level.SEVERE, null, ex);
              } 
            
           kimlik_ekran_Temizle(); //Ekranın kullanıma hazır bir şekilde açılması için
           
           //TAB VE ENTER TUŞUNUN GEREKLİ ALANLARDA ÇALIŞMASI İÇİN
           Tc_field.setFocusTraversalKeysEnabled(false);
           Ad_field.setFocusTraversalKeysEnabled(false);
           Soyad_field.setFocusTraversalKeysEnabled(false);
           Sicil_field.setFocusTraversalKeysEnabled(false);
           unvan_combo_box.setFocusTraversalKeysEnabled(false);
           gorev_combo_box.setFocusTraversalKeysEnabled(false);
           gorev_durumu_combo_box.setFocusTraversalKeysEnabled(false);
           gorev_yeri_combo_box.setFocusTraversalKeysEnabled(false);
           istihdam_combo_box.setFocusTraversalKeysEnabled(false);
           kaydet_buton.setFocusTraversalKeysEnabled(false);
           guncelle_buton.setFocusTraversalKeysEnabled(false);
           yeni_kayit_buton.setFocusTraversalKeysEnabled(false);
           
           
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tc_kimlik_label = new javax.swing.JLabel();
        ad_label = new javax.swing.JLabel();
        soyad_label = new javax.swing.JLabel();
        sicil_no_label = new javax.swing.JLabel();
        gorev_yeri_label = new javax.swing.JLabel();
        unvan_label = new javax.swing.JLabel();
        istihdam_tipi_label = new javax.swing.JLabel();
        gorev_durumu_label = new javax.swing.JLabel();
        gorev_label = new javax.swing.JLabel();
        Tc_field = new javax.swing.JTextField();
        Ad_field = new javax.swing.JTextField();
        Soyad_field = new javax.swing.JTextField();
        Sicil_field = new javax.swing.JTextField();
        gorev_yeri_combo_box = new javax.swing.JComboBox();
        gorev_combo_box = new javax.swing.JComboBox();
        istihdam_combo_box = new javax.swing.JComboBox();
        gorev_durumu_combo_box = new javax.swing.JComboBox();
        unvan_combo_box = new javax.swing.JComboBox();
        kaydet_buton = new javax.swing.JButton();
        getir_buton = new javax.swing.JButton();
        guncelle_buton = new javax.swing.JButton();
        yeni_kayit_buton = new javax.swing.JButton();
        personel_islem_ekran = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(651, 340));

        tc_kimlik_label.setText("Tc Kimlik Numarası:");

        ad_label.setText("Ad:");

        soyad_label.setText("Soyad:");

        sicil_no_label.setText("Sicil No:");

        gorev_yeri_label.setText("Görev Yeri:");

        unvan_label.setText("Ünvan:");

        istihdam_tipi_label.setText("İstihdam Tipi:");

        gorev_durumu_label.setText("Görev Durumu:");

        gorev_label.setText("Görev :");

        Tc_field.setNextFocusableComponent(Ad_field);
        Tc_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Tc_fieldKeyTyped(evt);
            }
        });

        Ad_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Ad_fieldKeyTyped(evt);
            }
        });

        Soyad_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Soyad_fieldKeyTyped(evt);
            }
        });

        Sicil_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Sicil_fieldKeyTyped(evt);
            }
        });

        gorev_yeri_combo_box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gorev_yeri_combo_boxKeyPressed(evt);
            }
        });

        gorev_combo_box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gorev_combo_boxKeyPressed(evt);
            }
        });

        istihdam_combo_box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                istihdam_combo_boxKeyPressed(evt);
            }
        });

        gorev_durumu_combo_box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gorev_durumu_combo_boxKeyPressed(evt);
            }
        });

        unvan_combo_box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                unvan_combo_boxKeyPressed(evt);
            }
        });

        kaydet_buton.setForeground(new java.awt.Color(51, 51, 255));
        kaydet_buton.setText("Kaydet");
        kaydet_buton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaydet_butonActionPerformed(evt);
            }
        });
        kaydet_buton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kaydet_butonKeyPressed(evt);
            }
        });

        getir_buton.setForeground(new java.awt.Color(51, 51, 255));
        getir_buton.setText("Getir");
        getir_buton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getir_butonActionPerformed(evt);
            }
        });

        guncelle_buton.setForeground(new java.awt.Color(51, 51, 255));
        guncelle_buton.setText("Güncelle");
        guncelle_buton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelle_butonActionPerformed(evt);
            }
        });
        guncelle_buton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                guncelle_butonKeyPressed(evt);
            }
        });

        yeni_kayit_buton.setForeground(new java.awt.Color(51, 51, 255));
        yeni_kayit_buton.setText("Yeni Kayıt");
        yeni_kayit_buton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yeni_kayit_butonActionPerformed(evt);
            }
        });
        yeni_kayit_buton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                yeni_kayit_butonKeyPressed(evt);
            }
        });

        personel_islem_ekran.setForeground(new java.awt.Color(51, 51, 255));
        personel_islem_ekran.setText("Personel İşlemleri Ekranı");
        personel_islem_ekran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personel_islem_ekranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ad_label, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(tc_kimlik_label)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Ad_field, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(103, 103, 103)
                                        .addComponent(gorev_label)
                                        .addGap(63, 63, 63)
                                        .addComponent(gorev_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Tc_field, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(getir_buton)
                                        .addGap(26, 26, 26)
                                        .addComponent(unvan_label)
                                        .addGap(65, 65, 65)
                                        .addComponent(unvan_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(soyad_label)
                                .addGap(92, 92, 92)
                                .addComponent(Soyad_field, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addComponent(gorev_durumu_label)
                                .addGap(18, 18, 18)
                                .addComponent(gorev_durumu_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sicil_no_label)
                                .addGap(85, 85, 85)
                                .addComponent(Sicil_field, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(istihdam_tipi_label)
                                        .addGap(26, 26, 26)
                                        .addComponent(istihdam_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(gorev_yeri_label)
                                        .addGap(41, 41, 41)
                                        .addComponent(gorev_yeri_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kaydet_buton)
                                .addGap(18, 18, 18)
                                .addComponent(guncelle_buton)
                                .addGap(18, 18, 18)
                                .addComponent(yeni_kayit_buton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(personel_islem_ekran)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(getir_buton)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(unvan_label))
                    .addComponent(unvan_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tc_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tc_kimlik_label))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(gorev_label))
                            .addComponent(gorev_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Ad_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ad_label)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(gorev_durumu_label))
                            .addComponent(gorev_durumu_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Soyad_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soyad_label))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Sicil_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sicil_no_label))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gorev_yeri_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gorev_yeri_label)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(istihdam_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(istihdam_tipi_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kaydet_buton)
                    .addComponent(guncelle_buton)
                    .addComponent(yeni_kayit_buton))
                .addGap(18, 18, 18)
                .addComponent(personel_islem_ekran)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void kimlik_ekran_Temizle()
    {  
       Tc_field.setText("");
       Ad_field.setText("");
       Soyad_field.setText("");
       Sicil_field.setText("");
       
       unvan_combo_box.setEditable(true);
       unvan_combo_box.setSelectedItem("-Unvanlar-");
       unvan_combo_box.setEditable(false);
       
       gorev_combo_box.setEditable(true);
       gorev_combo_box.setSelectedItem("-Görevler-");
       gorev_combo_box.setEditable(false);
       
       gorev_durumu_combo_box.setEditable(true);
       gorev_durumu_combo_box.setSelectedItem("-Görev Durumları-");
       gorev_durumu_combo_box.setEditable(false);
       
       gorev_yeri_combo_box.setEditable(true);
       gorev_yeri_combo_box.setSelectedItem("-Görev Yerleri-");
       gorev_yeri_combo_box.setEditable(false);
       
       istihdam_combo_box.setEditable(true);
       istihdam_combo_box.setSelectedItem("-İstihdam Tipleri-");
       istihdam_combo_box.setEditable(false);
    }
    private void kaydet_butonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaydet_butonActionPerformed

        tc_uzunluk=Tc_field.getText().length();
        sicil_no=Sicil_field.getText().length();
        
         if(tc_uzunluk<11)
            {
                JOptionPane.showMessageDialog(this, "Lütfen Tc Kimlik Numaranızı 11 hane olacak şekilde giriniz.","UYARI",JOptionPane.WARNING_MESSAGE);
                
                Tc_field.requestFocus();
                
                return;
            }
         
         if(Ad_field.getText().length() < 2)
         {
              JOptionPane.showMessageDialog(this, "Lütfen Ad alanını doldurunuz.","UYARI",JOptionPane.WARNING_MESSAGE);
                
                Ad_field.requestFocus();
                
                return;
         }
         
          if(Soyad_field.getText().length() < 2)
         {
              JOptionPane.showMessageDialog(this, "Lütfen Soyad alanını doldurunuz.","UYARI",JOptionPane.WARNING_MESSAGE);
                
                Soyad_field.requestFocus();
                
                return;
         }
        
        
         if(sicil_no<6)
            {
               JOptionPane.showMessageDialog(this, "Lütfen sicil numaranızı 6 hane olacak şekilde giriniz.","UYARI",JOptionPane.WARNING_MESSAGE);
               
               Sicil_field.requestFocus();
               
               return;
            }
         
         if(unvan_combo_box.getSelectedIndex() == -1)
         {
             JOptionPane.showMessageDialog(this, "Lütfen bir Unvan seçiniz.","UYARI",JOptionPane.WARNING_MESSAGE);
             unvan_combo_box.requestFocus();
             return;
         }
         
         if(gorev_combo_box.getSelectedIndex() == -1)
         {
             JOptionPane.showMessageDialog(this, "Lütfen bir Görev seçiniz.","UYARI",JOptionPane.WARNING_MESSAGE);
             gorev_combo_box.requestFocus();
             return;
         }
         
         if(gorev_durumu_combo_box.getSelectedIndex() == -1)
         {
             JOptionPane.showMessageDialog(this, "Lütfen bir Görev Durumu seçiniz.","UYARI",JOptionPane.WARNING_MESSAGE);
             gorev_durumu_combo_box.requestFocus();
             return;
         }
         
         if(gorev_yeri_combo_box.getSelectedIndex() == -1)
         {
             JOptionPane.showMessageDialog(this, "Lütfen bir Görev Yeri seçiniz.","UYARI",JOptionPane.WARNING_MESSAGE);
             gorev_yeri_combo_box.requestFocus();
             return;
         }
         
         if(istihdam_combo_box.getSelectedIndex() == -1)
         {
             JOptionPane.showMessageDialog(this, "Lütfen bir İstihdam Tipi seçiniz.","UYARI",JOptionPane.WARNING_MESSAGE);
             istihdam_combo_box.requestFocus();
             return;
         }
        
         String sorgu = " insert into per_kimlik_bilgileri"
                 + " (pkb_tc_no,pkb_ad,pkb_soyad,pkb_sicil_no,pkb_gorev_yeri,pkb_unvan_k,pkb_gorev_k,pkb_istihdam_tipi,pkb_gor_drm)"
                 + " values (?, ?, ?, ?, ?, ?, ? , ? , ?)";
        
         
         String Tc = Tc_field.getText();
         String ad = Ad_field.getText();
         String soyad = Soyad_field.getText();
         String sicil = Sicil_field.getText();
         
         item = gorev_combo_box.getSelectedItem();
         String gorev = ((ComboItem)item).getValue();
         
         item = unvan_combo_box.getSelectedItem();
         String unvan = ((ComboItem)item).getValue();
         
         item = gorev_durumu_combo_box.getSelectedItem();
         String gorev_durumu = ((ComboItem)item).getValue();
         
         item = gorev_yeri_combo_box.getSelectedItem();
         String gorev_yeri = ((ComboItem)item).getValue();
         
         item = istihdam_combo_box.getSelectedItem();
         String istihdam = ((ComboItem)item).getValue();
         
         try 
         {
      
            preparedstatement = con.prepareStatement(sorgu); 
             
            preparedstatement.setString(1,Tc);
            preparedstatement.setString(2,ad);
            preparedstatement.setString(3,soyad);
            preparedstatement.setString(4,sicil);
            preparedstatement.setString(5,gorev_yeri);
            preparedstatement.setString(6,unvan);
            preparedstatement.setString(7,gorev);
            preparedstatement.setString(8,istihdam);
            preparedstatement.setString(9,gorev_durumu);
            
            preparedstatement.execute();
             
         }
         
         catch (SQLException ex) 
         {
                    //Logger.getLogger(KimlikBilgileriEkrani.class.getName()).log(Level.SEVERE, null, ex);
             
                    String hata_mesajı = ex.getMessage();
              
                    boolean tc_no_kontrol = hata_mesajı.contains("PRIMARY");
                    boolean sicil_no_kontrol = hata_mesajı.contains("Pkb_Sicil_No");
                      
                    if(tc_no_kontrol == true)
                    {
                     JOptionPane.showMessageDialog(this, "Girdiğiniz Tc kayitlarda mevcuttur!","UYARI",JOptionPane.WARNING_MESSAGE);
                     
                     Tc_field.requestFocus();
                     
                     return;
                    }
                    
                     if(sicil_no_kontrol == true)
                    {
                     JOptionPane.showMessageDialog(this, "Girdiğiniz Sicil No kayitlarda mevcuttur!","UYARI",JOptionPane.WARNING_MESSAGE);
                     
                     Sicil_field.requestFocus();
                     
                     return;
                    }
            
                     return;
         }
         
                JOptionPane.showMessageDialog(this,"Kayit Başarıyla Eklendi!");
                
                
    }//GEN-LAST:event_kaydet_butonActionPerformed

   
    private void Tc_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tc_fieldKeyTyped
        
       String metin = Tc_field.getText();
       tc_uzunluk = metin.length();
       
       char karakter = evt.getKeyChar();
        
    
       if( evt.getKeyChar() == KeyEvent.VK_TAB ) //Tab tuşuna basıldığında ad alanına gitmek için
        {
            Ad_field.requestFocus();
        }
     
       if( !(Character.isDigit(karakter)) || tc_uzunluk == 11 )
        {
         evt.consume();
        }
    }//GEN-LAST:event_Tc_fieldKeyTyped

    private void Ad_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Ad_fieldKeyTyped
        
        String metin = Ad_field.getText();
        ad_uzunluk = metin.length();
       
        char karakter = evt.getKeyChar();
        
         if( evt.getKeyChar() == KeyEvent.VK_TAB )//Tab tuşuna basıldığında soyad alanına gitmek için
        {
            Soyad_field.requestFocus();
        }

        if( !(Character.isAlphabetic(karakter)) || ad_uzunluk==30)
        {
            evt.consume();
        }
    }//GEN-LAST:event_Ad_fieldKeyTyped

    private void Soyad_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Soyad_fieldKeyTyped
       
        String metin = Soyad_field.getText();
        soyad_uzunluk = metin.length();

        char karakter = evt.getKeyChar();
        
         if( evt.getKeyChar() == KeyEvent.VK_TAB )//Tab tuşuna basıldığında sicil alanına gitmek için
        {
            Sicil_field.requestFocus();
        }
        
        if( !(Character.isAlphabetic(karakter))  || soyad_uzunluk == 30  )
        {
          evt.consume();
        }
    }//GEN-LAST:event_Soyad_fieldKeyTyped

    private void Sicil_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Sicil_fieldKeyTyped
        
        String metin = Sicil_field.getText();
        sicil_no = metin.length();

        char karakter = evt.getKeyChar();
        
         if( evt.getKeyChar() == KeyEvent.VK_TAB ) //Tab tuşuna basıldığında unvan combobox alanına gitmek için
        {
            unvan_combo_box.requestFocus();
        }

        if( !(Character.isDigit(karakter)) || sicil_no==6 )
        {
         evt.consume();
        }
    }//GEN-LAST:event_Sicil_fieldKeyTyped

    private void getir_butonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getir_butonActionPerformed
        
         if(Tc_field.getText().equals(""))
        {
           JOptionPane.showMessageDialog(this,"Lütfen Bir Tc Kimlik Numarası Giriniz","UYARI", JOptionPane.WARNING_MESSAGE);
           
           Tc_field.requestFocus();
           
           return;
          
        }
        
        else if(Tc_field.getText().length()<11)
        {
          JOptionPane.showMessageDialog(this,"Tc Kimlik Numaranız 11 Haneden Oluşmalıdır!","UYARI", JOptionPane.WARNING_MESSAGE);  
          
          Tc_field.requestFocus();
          
          return;
        }
        
        String Tc = Tc_field.getText().trim();
         
        boolean tc_kontrol = islem.TcKontrol(Tc);
         
        if(tc_kontrol==false)
        {
             
         JOptionPane.showMessageDialog(this,"Girmiş Olduğunuz Tc Kimlik Numarası Kayıtlarda Bulunmamaktadır!","UYARI", JOptionPane.WARNING_MESSAGE); 
         
         Tc_field.requestFocus();
         
         return;   
         
        }
        
        Tc_field.setEnabled(false);
        kaydet_buton.setEnabled(false);
        
        String ad="";
        String soyad="";
        String sicil="";
        String gorev_yeri="";
        String unvan="";
        String gorev="";
        String istihdam="";
        String gorev_durumu="";
        
        
        
        String sorgu= " Select * "
                + "From per_kimlik_bilgileri"
                + " where Pkb_Tc_No = ?";
        
        
        
         try 
         {
             preparedstatement=con.prepareStatement(sorgu);
             
             preparedstatement.setString(1,Tc);
             
             resultset = preparedstatement.executeQuery();
             
              while(resultset.next())
              {
                 ad=resultset.getString("pkb_ad");
                 soyad=resultset.getString("pkb_soyad");
                 sicil=resultset.getString("pkb_sicil_no");
                 gorev_yeri=resultset.getString("pkb_gorev_yeri");
                 unvan=resultset.getString("pkb_unvan_k");
                 gorev=resultset.getString("pkb_gorev_k");
                 istihdam=resultset.getString("pkb_istihdam_tipi");
                 gorev_durumu=resultset.getString("pkb_gor_drm");               
              }
              
         }
         
         catch (SQLException ex) 
         {
             Logger.getLogger(KimlikBilgileriEkrani.class.getName()).log(Level.SEVERE, null, ex);
         }
            
         
         //GOREV YERİ ADINI VERİ TABANINDAN ALMAK İÇİN
         String sorgu_gorev_yeri= " Select pg_ad "
                + "From per_gorev_yerleri"
                + " where Pg_kod=?";
   
         try 
         {
             preparedstatement=con.prepareStatement(sorgu_gorev_yeri);
             
             preparedstatement.setString(1,gorev_yeri);
             
             resultset = preparedstatement.executeQuery();
             
             while(resultset.next())
             {
                 
               gorev_yeri=resultset.getString("pg_ad");
                 
             }
                 
         }
         
         catch (SQLException ex) 
         {
             Logger.getLogger(KimlikBilgileriEkrani.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         //UNVAN ADINI VERİ TABANINDAN ALMAK İÇİN
         
         String sorgu_unvan= " Select unv_adi "
                + "From per_unvanlar"
                + " where unv_kodu=?";
   
         
         try 
         {
             preparedstatement=con.prepareStatement(sorgu_unvan);
             
             preparedstatement.setString(1,unvan);
             
             resultset = preparedstatement.executeQuery();
             
             while(resultset.next())
             {
                 
               unvan=resultset.getString("unv_adi");
                 
             }
                 
         }
         
         catch (SQLException ex) 
         {
             Logger.getLogger(KimlikBilgileriEkrani.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         //GOREV ADINI VERİ TABANINDAN ALMAK İÇİN
         
         String sorgu_gorev= " Select gorev_adi "
                + "From per_gorevler"
                + " where gorev_kodu=?";
   
         
         try 
         {
             preparedstatement=con.prepareStatement(sorgu_gorev);
             
             preparedstatement.setString(1,gorev);
             
             resultset = preparedstatement.executeQuery();
             
             while(resultset.next())
             {
                 
               gorev=resultset.getString("gorev_adi");
                 
             }
                 
         }
         
         catch (SQLException ex) 
         {
             Logger.getLogger(KimlikBilgileriEkrani.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        //İSTİHDAM ADINI VERİ TABANINDAN ALMAK İÇİN 
         
         String sorgu_istihdam= " Select pst_ele_adi "
                + "From per_sozluk_tablo"
                + " where pst_ele_kodu=? AND pst_tablo_kodu=?";
   
         
         try 
         {
             preparedstatement=con.prepareStatement(sorgu_istihdam);
             
             preparedstatement.setString(1,istihdam);
             preparedstatement.setString(2,"1");     //Sozluk tablosunda istihdamin tablo kodu 1 
             
             resultset = preparedstatement.executeQuery();
             
             while(resultset.next())
             {
                 
               istihdam=resultset.getString("pst_ele_adi");
                 
             }
                 
         }
         
         catch (SQLException ex) 
         {
             Logger.getLogger(KimlikBilgileriEkrani.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         //GOREV DURUM ADINI VERİ TABANINDAN ALMAK İÇİN
         
          String sorgu_gorev_durumu= " Select pst_ele_adi "
                + "From per_sozluk_tablo"
                + " where pst_ele_kodu=? AND pst_tablo_kodu=?";
   
         
         try 
         {
             preparedstatement=con.prepareStatement(sorgu_gorev_durumu);
             
             preparedstatement.setString(1,gorev_durumu);
             preparedstatement.setString(2,"3");     //Sozluk tablosunda görev durumunun tablo kodu 2
             
             resultset = preparedstatement.executeQuery();
             
             while(resultset.next())
             {
                 
               gorev_durumu=resultset.getString("pst_ele_adi");
                 
             }
                 
         }
         
         catch (SQLException ex) 
         {
             Logger.getLogger(KimlikBilgileriEkrani.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         Ad_field.setText(ad);
         Soyad_field.setText(soyad);
         Sicil_field.setText(sicil);
           
        
         gorev_combo_box.setEditable(true);
         int index_gorev=gorev_combo_icerik(gorev);
         gorev_combo_box.setSelectedIndex(index_gorev);
         gorev_combo_box.setEditable(false);
         
         
         unvan_combo_box.setEditable(true);
         int index_unvan=unvan_combo_icerik(unvan);
         unvan_combo_box.setSelectedIndex(index_unvan);
         unvan_combo_box.setEditable(false);

         
         gorev_yeri_combo_box.setEditable(true);
         int index_gorev_yeri = gorev_yeri_combo_icerik(gorev_yeri);
         gorev_yeri_combo_box.setSelectedIndex(index_gorev_yeri);
         gorev_yeri_combo_box.setEditable(false);
         
         
         istihdam_combo_box.setEditable(true);
         int index_istihdam = istihdam_combo_icerik(istihdam);
         istihdam_combo_box.setSelectedIndex(index_istihdam);
         istihdam_combo_box.setEditable(false);
         
         
         gorev_durumu_combo_box.setEditable(true);
         int index_gorev_durumu = gorev_durumu_combo_icerik(gorev_durumu);
         gorev_durumu_combo_box.setSelectedIndex(index_gorev_durumu);
         gorev_durumu_combo_box.setEditable(false);
                 
         
    }//GEN-LAST:event_getir_butonActionPerformed

    private int gorev_combo_icerik(String icerik)
    {
        int sayac=0; 
         
       while(!gorev_combo_box.getItemAt(sayac).toString().equals(icerik))
       {
        sayac++;
       }    
       return sayac;
    }
    
    private int unvan_combo_icerik(String icerik)
    {
       int sayac=0; 
         
       while(!unvan_combo_box.getItemAt(sayac).toString().equals(icerik))
       {
          sayac++;
        }    
       return sayac;
    }
    
    private int gorev_durumu_combo_icerik(String icerik)
    {
        int sayac=0; 
         
       while(!gorev_durumu_combo_box.getItemAt(sayac).toString().equals(icerik.toUpperCase()))
       {
         sayac++;
        }    
       return sayac;
    }
     
    private int istihdam_combo_icerik(String icerik)
    {
       
       int sayac = 0; 
        
        System.out.println(icerik);
       
       while(!istihdam_combo_box.getItemAt(sayac).toString().equals(icerik.toUpperCase()))
       {
         System.out.println(istihdam_combo_box.getItemAt(sayac));  
           
         sayac++;
        }    
        return sayac;
       
    }
     
    private int gorev_yeri_combo_icerik(String icerik)
    {
       
       int sayac=0; 
         
       while(!gorev_yeri_combo_box.getItemAt(sayac).toString().equals(icerik))
       {
         sayac++;
       }    
        return sayac;
    } 
     
    
            
    
    private void guncelle_butonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelle_butonActionPerformed

          
          tc_uzunluk=Tc_field.getText().length();
          sicil_no=Sicil_field.getText().length();
        
          if(tc_uzunluk<11)
            {
                JOptionPane.showMessageDialog(this, "Lütfen Tc Kimlik Numaranızı 11 hane olacak şekilde giriniz.","UYARI",JOptionPane.WARNING_MESSAGE);
                
                Tc_field.requestFocus();
                
                return;
            }    
        
        
          if(sicil_no<6)
            {
               JOptionPane.showMessageDialog(this, "Lütfen sicil numaranızı 6 hane olacak şekilde giriniz.","UYARI",JOptionPane.WARNING_MESSAGE);
               
               Sicil_field.requestFocus();
               
               return;
            }   
        
         String Tc = Tc_field.getText();
         
         boolean tc_kontrol = islem.TcKontrol(Tc);
         
         if(tc_kontrol==false)
         {
             
          JOptionPane.showMessageDialog(this,"Girmiş Olduğunuz Tc Kimlik Numarası Kayıtlarda Bulunmamaktadır!","UYARI", JOptionPane.WARNING_MESSAGE); 
          
          Tc_field.requestFocus();
          
          return;   
         }
         
          if(unvan_combo_box.getSelectedIndex() == -1)
         {
             JOptionPane.showMessageDialog(this, "Lütfen bir Unvan seçiniz.","UYARI",JOptionPane.WARNING_MESSAGE);
             unvan_combo_box.requestFocus();
             return;
         }
         
         if(gorev_combo_box.getSelectedIndex() == -1)
         {
             JOptionPane.showMessageDialog(this, "Lütfen bir Görev seçiniz.","UYARI",JOptionPane.WARNING_MESSAGE);
             gorev_combo_box.requestFocus();
             return;
         }
         
         if(gorev_durumu_combo_box.getSelectedIndex() == -1)
         {
             JOptionPane.showMessageDialog(this, "Lütfen bir Görev Durumu seçiniz.","UYARI",JOptionPane.WARNING_MESSAGE);
             gorev_durumu_combo_box.requestFocus();
             return;
         }
         
         if(gorev_yeri_combo_box.getSelectedIndex() == -1)
         {
             JOptionPane.showMessageDialog(this, "Lütfen bir Görev Yeri seçiniz.","UYARI",JOptionPane.WARNING_MESSAGE);
             gorev_yeri_combo_box.requestFocus();
             return;
         }
         
         if(istihdam_combo_box.getSelectedIndex() == -1)
         {
             JOptionPane.showMessageDialog(this, "Lütfen bir İstihdam Tipi seçiniz.","UYARI",JOptionPane.WARNING_MESSAGE);
             istihdam_combo_box.requestFocus();
             return;
         }
         
         //Ekrandan veri tabanındaki verilerimizi güncellemek için gerekli alanların değerlerini alıyoruz
         String ad = Ad_field.getText();
         String soyad = Soyad_field.getText();
         String sicil = Sicil_field.getText();
         
         item = gorev_combo_box.getSelectedItem();
         String gorev = ((ComboItem)item).getValue();
         
         item = unvan_combo_box.getSelectedItem();
         String unvan = ((ComboItem)item).getValue();
         
         item = gorev_durumu_combo_box.getSelectedItem();
         String gorev_durumu = ((ComboItem)item).getValue();
         
         item = gorev_yeri_combo_box.getSelectedItem();
         String gorev_yeri = ((ComboItem)item).getValue();
         
         item = istihdam_combo_box.getSelectedItem();
         String istihdam = ((ComboItem)item).getValue();
        
        try
        {
        // create our java preparedstatement using a sql update query
        preparedstatement=con.prepareStatement(
          "UPDATE per_kimlik_bilgileri"
                  + " SET pkb_ad = ?,pkb_soyad=?,pkb_sicil_no=?,pkb_gorev_yeri=?,pkb_unvan_k=?,pkb_gorev_k=?,pkb_istihdam_tipi=?,pkb_gor_drm = ?"
                  + " WHERE pkb_tc_no=?");

        // set the preparedstatement parameters
        preparedstatement.setString(1,ad);
        preparedstatement.setString(2,soyad);
        preparedstatement.setString(3,sicil);
        preparedstatement.setString(4,gorev_yeri);
        preparedstatement.setString(5,unvan);
        preparedstatement.setString(6,gorev);
        preparedstatement.setString(7,istihdam);
        preparedstatement.setString(8,gorev_durumu);
        preparedstatement.setString(9,Tc);
        // call executeUpdate to execute our sql update statement
        preparedstatement.executeUpdate();
        preparedstatement.close();
      }
         
        catch (SQLException e)
       {
           
        String hata_mesajı = e.getMessage();   
           
        if(hata_mesajı.contains("Pkb_Sicil_No"))
        {
          JOptionPane.showMessageDialog(this,"Bu sicil numarası sistemde kayıtlıdır başka bir sicil numarası giriniz!","HATA", JOptionPane.WARNING_MESSAGE);    
          
          Sicil_field.requestFocus();
          
          return;
          
        }
            
        e.printStackTrace();
        
        return;
        
       }   
         JOptionPane.showMessageDialog(this,"Kayıt Başarı İle Güncellendi","BAŞARILI", WIDTH);
        
    }//GEN-LAST:event_guncelle_butonActionPerformed

    private void yeni_kayit_butonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yeni_kayit_butonActionPerformed
        
        Tc_field.setEnabled(true);
        kaydet_buton.setEnabled(true);
        kimlik_ekran_Temizle(); //Yeni kayıt oluşturmak istediğimizde ekranı temizlemek için
       
    }//GEN-LAST:event_yeni_kayit_butonActionPerformed

    private void unvan_combo_boxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unvan_combo_boxKeyPressed
        
         if( evt.getKeyChar() == KeyEvent.VK_TAB ) //Tab tuşuna basıldığında gorev combobox alanına gitmek için
        {
            gorev_combo_box.requestFocus();
        }
    }//GEN-LAST:event_unvan_combo_boxKeyPressed

    private void gorev_combo_boxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gorev_combo_boxKeyPressed
         
        if( evt.getKeyChar() == KeyEvent.VK_TAB )//Tab tuşuna basıldığında gorev durumu combobox alanına gitmek için
        {
            gorev_durumu_combo_box.requestFocus();
        }
    }//GEN-LAST:event_gorev_combo_boxKeyPressed

    private void gorev_durumu_combo_boxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gorev_durumu_combo_boxKeyPressed
         
        if( evt.getKeyChar() == KeyEvent.VK_TAB )//Tab tuşuna basıldığında gorev yeri combobox alanına gitmek için
        {
            gorev_yeri_combo_box.requestFocus();
        }
    }//GEN-LAST:event_gorev_durumu_combo_boxKeyPressed

    private void gorev_yeri_combo_boxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gorev_yeri_combo_boxKeyPressed
         
        if( evt.getKeyChar() == KeyEvent.VK_TAB )//Tab tuşuna basıldığında istihdam combobox alanına gitmek için
        {
            istihdam_combo_box.requestFocus();
        }
    }//GEN-LAST:event_gorev_yeri_combo_boxKeyPressed

    private void istihdam_combo_boxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_istihdam_combo_boxKeyPressed
        
        if( evt.getKeyChar() == KeyEvent.VK_TAB )//Tab tuşuna basıldığında kaydet butonuna gitmek için
        {
            kaydet_buton.requestFocus();
        }
    }//GEN-LAST:event_istihdam_combo_boxKeyPressed

    private void kaydet_butonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kaydet_butonKeyPressed
         
        if( evt.getKeyChar() == KeyEvent.VK_TAB )//Tab tuşuna basıldığında guncelle butonuna gitmek için
        {
            guncelle_buton.requestFocus();
        }
         
         if( evt.getKeyChar() == KeyEvent.VK_ENTER ) //Enter tuşuna basıldığında kayıt işlemini yapmak için
        {
            kaydet_butonActionPerformed(null);
        }
    }//GEN-LAST:event_kaydet_butonKeyPressed

    private void guncelle_butonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_guncelle_butonKeyPressed
         
        if( evt.getKeyChar() == KeyEvent.VK_TAB )//Tab tuşuna basıldığında yeni kayıt butonuna gitmek için
        {
            yeni_kayit_buton.requestFocus();
        }
         
         if( evt.getKeyChar() == KeyEvent.VK_ENTER )//Enter tuşuna basıldığında guncelleme işlemini yapmak için
        {
            guncelle_butonActionPerformed(null);
        }
    }//GEN-LAST:event_guncelle_butonKeyPressed

    private void yeni_kayit_butonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yeni_kayit_butonKeyPressed
        
        if( evt.getKeyChar() == KeyEvent.VK_TAB )//Tab tuşuna basıldığında tc alanına gitmek için
        {
            Tc_field.requestFocus();
        }
        
         if( evt.getKeyChar() == KeyEvent.VK_ENTER ) //Enter tuşuna basıldığında yeni kayıt işlemini yapmak için
        {
            yeni_kayit_butonActionPerformed(null);
        }
    }//GEN-LAST:event_yeni_kayit_butonKeyPressed

    private void personel_islem_ekranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personel_islem_ekranActionPerformed
        
        this.setVisible(false);
        
        Personel_islemleri_Ekrani ekran = new Personel_islemleri_Ekrani();
        ekran.setVisible(true);
    }//GEN-LAST:event_personel_islem_ekranActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ad_field;
    private javax.swing.JTextField Sicil_field;
    private javax.swing.JTextField Soyad_field;
    private javax.swing.JTextField Tc_field;
    private javax.swing.JLabel ad_label;
    private javax.swing.JButton getir_buton;
    private javax.swing.JComboBox gorev_combo_box;
    private javax.swing.JComboBox gorev_durumu_combo_box;
    private javax.swing.JLabel gorev_durumu_label;
    private javax.swing.JLabel gorev_label;
    private javax.swing.JComboBox gorev_yeri_combo_box;
    private javax.swing.JLabel gorev_yeri_label;
    private javax.swing.JButton guncelle_buton;
    private javax.swing.JComboBox istihdam_combo_box;
    private javax.swing.JLabel istihdam_tipi_label;
    private javax.swing.JButton kaydet_buton;
    private javax.swing.JButton personel_islem_ekran;
    private javax.swing.JLabel sicil_no_label;
    private javax.swing.JLabel soyad_label;
    private javax.swing.JLabel tc_kimlik_label;
    private javax.swing.JComboBox unvan_combo_box;
    private javax.swing.JLabel unvan_label;
    private javax.swing.JButton yeni_kayit_buton;
    // End of variables declaration//GEN-END:variables
}
