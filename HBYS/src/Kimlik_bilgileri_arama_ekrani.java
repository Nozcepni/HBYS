/**
 *
 * @author Nahit
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

public class Kimlik_bilgileri_arama_ekrani extends javax.swing.JFrame {
   
    
    public static void main(String[] args) {
        new Kimlik_bilgileri_arama_ekrani().setVisible(true);
    }
    
   HbysIslem islem = new HbysIslem();
        
    public Connection con = islem.con;
    public Statement statement = null;
    public PreparedStatement preparedstatement= null;
     
    public  ResultSet resultset = null;
     
     Object item=null;
     
     public Kimlik_bilgileri_arama_ekrani() {
    
       setTitle("Kimlik Bilgileri Arama Ekranı");
        
        initComponents();
        
         //Pencereyi ekranın ortasına alabilmek için 
        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
         //BÜYÜK HARF EKLEME ALANI
        DocumentFilter filter = new UppercaseDocumentFilter();
        
        AbstractDocument Ad_field_doc = (AbstractDocument) ad_field.getDocument();
        Ad_field_doc.setDocumentFilter(filter);
        
        AbstractDocument Soyad_field_doc = (AbstractDocument) soyad_field.getDocument();
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
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        kimlik_bilgileri_tablo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tc_field = new javax.swing.JTextField();
        ad_field = new javax.swing.JTextField();
        soyad_field = new javax.swing.JTextField();
        sicil_field = new javax.swing.JTextField();
        gorev_yeri_combo_box = new javax.swing.JComboBox();
        gorev_combo_box = new javax.swing.JComboBox();
        unvan_combo_box = new javax.swing.JComboBox();
        gorev_durumu_combo_box = new javax.swing.JComboBox();
        istihdam_combo_box = new javax.swing.JComboBox();
        arama_butonu = new javax.swing.JButton();
        yeni_arama_buton = new javax.swing.JButton();
        personel_islem_ekran = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpanel.setMinimumSize(new java.awt.Dimension(1381, 672));

        kimlik_bilgileri_tablo.setAutoCreateRowSorter(true);
        kimlik_bilgileri_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TC", "AD", "SOYAD", "SİCİL NUMARASI", "GÖREV YERİ", "GÖREV", "ÜNVAN", "İSTİHDAM TİPİ", "GÖREV DURUMU"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(kimlik_bilgileri_tablo);
        if (kimlik_bilgileri_tablo.getColumnModel().getColumnCount() > 0) {
            kimlik_bilgileri_tablo.getColumnModel().getColumn(0).setResizable(false);
            kimlik_bilgileri_tablo.getColumnModel().getColumn(1).setResizable(false);
            kimlik_bilgileri_tablo.getColumnModel().getColumn(2).setResizable(false);
            kimlik_bilgileri_tablo.getColumnModel().getColumn(3).setResizable(false);
            kimlik_bilgileri_tablo.getColumnModel().getColumn(4).setResizable(false);
            kimlik_bilgileri_tablo.getColumnModel().getColumn(5).setResizable(false);
            kimlik_bilgileri_tablo.getColumnModel().getColumn(6).setResizable(false);
            kimlik_bilgileri_tablo.getColumnModel().getColumn(7).setResizable(false);
            kimlik_bilgileri_tablo.getColumnModel().getColumn(8).setResizable(false);
        }

        jLabel1.setText("Tc:");

        jLabel2.setText("Ad:");

        jLabel3.setText("Soyad:");

        jLabel4.setText("Sicil Numarası:");

        jLabel5.setText("Görev Yeri:");

        jLabel6.setText("Görev:");

        jLabel7.setText("Ünvan:");

        jLabel8.setText("İstihdam Tipi:");

        jLabel9.setText("Görev Durumu:");

        tc_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tc_fieldKeyTyped(evt);
            }
        });

        ad_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ad_fieldKeyTyped(evt);
            }
        });

        soyad_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soyad_fieldKeyTyped(evt);
            }
        });

        sicil_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sicil_fieldKeyTyped(evt);
            }
        });

        gorev_yeri_combo_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Görev Yerleri-" }));

        gorev_combo_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Görevler-" }));

        unvan_combo_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Ünvanlar-" }));

        gorev_durumu_combo_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Görev Durumları-" }));

        istihdam_combo_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-İstihdam Tipleri-" }));

        arama_butonu.setForeground(new java.awt.Color(51, 51, 255));
        arama_butonu.setText("Arama Yap");
        arama_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arama_butonuActionPerformed(evt);
            }
        });

        yeni_arama_buton.setForeground(new java.awt.Color(51, 51, 255));
        yeni_arama_buton.setText("Yeni Arama");
        yeni_arama_buton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yeni_arama_butonActionPerformed(evt);
            }
        });

        personel_islem_ekran.setForeground(new java.awt.Color(51, 51, 255));
        personel_islem_ekran.setText("Personel İşlemleri Ekranı");
        personel_islem_ekran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personel_islem_ekranActionPerformed(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setText("Tüm Kayıtlar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jpanelLayout);
        jpanelLayout.setHorizontalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpanelLayout.createSequentialGroup()
                                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createSequentialGroup()
                                                .addComponent(sicil_field, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9)
                                                .addGap(20, 20, 20))
                                            .addGroup(jpanelLayout.createSequentialGroup()
                                                .addComponent(soyad_field, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jpanelLayout.createSequentialGroup()
                                            .addComponent(ad_field, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel6)
                                            .addGap(35, 35, 35)))
                                    .addGroup(jpanelLayout.createSequentialGroup()
                                        .addComponent(tc_field, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gorev_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(unvan_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gorev_durumu_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gorev_yeri_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpanelLayout.createSequentialGroup()
                                .addComponent(istihdam_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(arama_butonu)
                                .addGap(18, 18, 18)
                                .addComponent(yeni_arama_buton)))
                        .addGap(27, 27, 27)
                        .addComponent(jButton1))
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(personel_islem_ekran)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gorev_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tc_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(unvan_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ad_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(soyad_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(gorev_yeri_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(23, 23, 23)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sicil_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gorev_durumu_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(istihdam_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arama_butonu)
                    .addComponent(yeni_arama_buton)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(personel_islem_ekran)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void arama_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arama_butonuActionPerformed
      
        Object item = null;
        
        int gorev_index = gorev_combo_box.getSelectedIndex();
        int unvan_index = unvan_combo_box.getSelectedIndex();
        int gorev_yeri_index = gorev_yeri_combo_box.getSelectedIndex();
        int istihdam_index = istihdam_combo_box.getSelectedIndex();
        int gorev_durumu_index = gorev_durumu_combo_box.getSelectedIndex();
                
        
        String tc = tc_field.getText();
        String ad = ad_field.getText();
        String soyad = soyad_field.getText();
        String sicil = sicil_field.getText();
        String gorev = gorev_combo_box.getSelectedItem().toString();
        String unvan = unvan_combo_box.getSelectedItem().toString();
        String gorev_yeri = gorev_yeri_combo_box.getSelectedItem().toString();
        String istihdam = istihdam_combo_box.getSelectedItem().toString();
        String gorev_durumu = gorev_durumu_combo_box.getSelectedItem().toString();
        
        if(gorev_index==0 && unvan_index==0 && gorev_yeri_index==0 && istihdam_index==0 && gorev_durumu_index==0 && tc.equals("") && ad.equals("") && soyad.equals("") && sicil.equals("") )
        {
          
            JOptionPane.showMessageDialog(this,"Lütfen en az bir tane en az bir tane arama kriteri giriniz.","UYARI", JOptionPane.WARNING_MESSAGE);
            
            tc_field.requestFocus();
            
            return;
        }      
    
                       
             String sorgu
                     = " SELECT "      
                     + "sanal_tablo.pkb_tc_no,"
                     + "sanal_tablo.pkb_ad,"
                     + "sanal_tablo.pkb_soyad,"
                     + "sanal_tablo.pkb_sicil_no,"
                     + "gorev_yerleri.pg_Ad,"
                     + "unvan.Unv_Adi,"
                     + "gorev.gorev_Adi,"
                     + "istihdam.Pst_Ele_Adi,"
                     + "gorev_durumu.Pst_Ele_Adi AS Gorev_Durumu "                
                     + "FROM  "
                     + "(SELECT concat ('/tc:' ,per.pkb_tc_no, '/ad:' , per.pkb_ad , '/soyad:' , per.pkb_soyad , '/sicil:' , per.pkb_sicil_no , "
                     + "'/gorev_yeri:' , per.pkb_gorev_yeri , '/unvan_kodu:' , per.pkb_unvan_k , '/gorev_kodu:',"
                     + "per.pkb_gorev_k , '/istihdam_tipi:' , per.pkb_istihdam_tipi ,'/gorev_durumu:', per.pkb_gor_drm) arama "
                     + ", per.* from per_kimlik_bilgileri per) sanal_tablo"
                     + ", per_unvanlar unvan, per_gorevler gorev,"
                     + "per_gorev_yerleri gorev_yerleri, per_sozluk_tablo istihdam, per_sozluk_tablo gorev_durumu "          
                     + "WHERE ((sanal_tablo.pkb_unvan_k=unvan.Unv_Kodu)  AND "
                     + "(sanal_tablo.pkb_gorev_k=gorev.gorev_kodu)  "
                     + "AND (sanal_tablo.pkb_gorev_yeri=gorev_yerleri.pg_kod)  "
                     + "AND ( (sanal_tablo.pkb_istihdam_tipi=istihdam.Pst_Ele_Kodu)  "
                     + "AND istihdam.Pst_Tablo_Kodu=1 ) "
                     + "AND (  (sanal_tablo.pkb_gor_drm=gorev_durumu.Pst_Ele_Kodu)"
                     + "AND gorev_durumu.Pst_Tablo_Kodu=3 ))";  
           
        
             
        if( !(tc.equals("")) ) 
        {
           
           if(tc.length()!=11) 
           {
             JOptionPane.showMessageDialog(this,"TC Kimlik Numarasını 11 Hane Olarak Giriniz","UYARI",JOptionPane.WARNING_MESSAGE);  
             
             tc_field.requestFocus();
             
             return;
             
           }
           
           else
           {
            sorgu = sorgu.concat(" AND sanal_tablo.arama LIKE '%/tc:"+tc+"%' ");  
               
           }
           
           
        } 
        
        if( !(sicil.equals("")) ) 
        {
            
          if(sicil.length()!=6) 
           {
             JOptionPane.showMessageDialog(this,"Sicil Numarasını 6 Hane Olarak Giriniz","UYARI",JOptionPane.WARNING_MESSAGE);  
             
             sicil_field.requestFocus();
             
             return;
            
             
           }
           
           else
           {
            sorgu = sorgu.concat(" AND sanal_tablo.arama LIKE '%/sicil:"+sicil+"%' ");
           
           }    
          
          
        }
        
        if( !(ad.equals("")) ) 
        {

           sorgu = sorgu.concat(" AND sanal_tablo.arama LIKE '%/ad:"+ad+"%' ");
        } 
         
        if( !(soyad.equals("")) ) 
        {
           
           sorgu = sorgu.concat(" AND sanal_tablo.arama LIKE '%/soyad:"+soyad+"%' ");
        } 
         
         
        if( !(gorev.equals("-Görevler-")  ) ) 
        {
             
             item = gorev_combo_box.getSelectedItem();
             gorev = ((ComboItem)item).getValue();     
             
             sorgu = sorgu.concat(" AND sanal_tablo.arama LIKE '%/gorev_kodu:"+gorev+"%' ");
        } 
         
         
         if( !(unvan.equals("-Ünvanlar-")) ) 
        {
           
           item = unvan_combo_box.getSelectedItem();
           unvan = ((ComboItem)item).getValue();    
            
           sorgu = sorgu.concat(" AND sanal_tablo.arama LIKE '%/unvan_kodu:"+unvan+"%' ");
         
        } 
         
        if( !(gorev_yeri.equals("-Görev Yerleri-")) ) 
        {
            
           item = gorev_yeri_combo_box.getSelectedItem();
           gorev_yeri = ((ComboItem)item).getValue();    
            
           sorgu = sorgu.concat(" AND sanal_tablo.arama LIKE '%/gorev_yeri:"+gorev_yeri+"%' ");
        }  
        
         
        if( !(istihdam.equals("-İstihdam Tipleri-")) ) 
        {
           
           item = istihdam_combo_box.getSelectedItem();
           istihdam = ((ComboItem)item).getValue();     
            
           sorgu = sorgu.concat(" AND sanal_tablo.arama LIKE '%/istihdam_tipi:"+istihdam+"%' ");
        }   
         
        if( !(gorev_durumu.equals("-Görev Durumları-")) ) 
        {
            
           item = gorev_durumu_combo_box.getSelectedItem();
           gorev_durumu = ((ComboItem)item).getValue();    
            
           sorgu = sorgu.concat(" AND sanal_tablo.arama LIKE '%/gorev_durumu:"+gorev_durumu+"%' ");
        }  
        
     
             
       try 
       {
               
             statement=con.createStatement();
             
             resultset = statement.executeQuery(sorgu);
             
             resultSetToTableModel(resultset, kimlik_bilgileri_tablo);
             
             
       } 
       
       catch (SQLException ex) 
       {
           
           Logger.getLogger(Kimlik_bilgileri_arama_ekrani.class.getName()).log(Level.SEVERE, null, ex);
       }
    
      
              
    }//GEN-LAST:event_arama_butonuActionPerformed

     public void resultSetToTableModel(ResultSet rs, JTable table) throws SQLException {
        
        //Yeni bir table model oluşturuyoruz
        DefaultTableModel tableModel = new DefaultTableModel();

        //Result Setten meta verileri alıyoruz
        ResultSetMetaData metaData = rs.getMetaData();

        //Meta verilerden sütun sayısını alıyoruz
        int columnCount = metaData.getColumnCount();

        //Tüm sütun adlarını meta veriden alıyoruz ve tablo modeline sütun ekliyoruz
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
            tableModel.addColumn(metaData.getColumnLabel(columnIndex));
        }

        //Meta verilerden sütun sayısının büyüklüğüyle Nesneler dizisi yaratıyoruz
        Object[] row = new Object[columnCount];

        //Result set'te arama sonuçlarında geziniyoruz
        while (rs.next()){
            //Nesneler dizisine ayarlanmış belirli bir sonuç dizini ile sütundan nesneyi alıyoruz
            for (int i = 0; i < columnCount; i++){
                row[i] = rs.getObject(i+1);
            }
            //Şimdi, bu nesne dizisini içeren tablo modeline satır olarak ekliyoruz
            tableModel.addRow(row);
        }

        //Şimdi bu tablo modelini kendi tablomuza ekliyoruz 
        
       
        
        table.setModel(tableModel);

        tablo_basliklarini_duzenle(table);
        
        table.setDefaultEditor(Object.class, null);    // Gelen veriler ekranda değiştirilemesin diye
        
        
    }
     
   
     
     public void tablo_basliklarini_duzenle(JTable table)  //Veritabaninda verileri cektikten sonra sütun başlıklarını yeniden adlandırmak için
     {
         
        String header[] = {"TC", "AD", "SOYAD", "SİCİL NUMARASI", "GÖREV YERİ", "GÖREV","ÜNVAN","İSTİHDAM TİPİ","GÖREV DURUMU"};
  
        for(int i=0;i<table.getColumnCount();i++)
        {
        TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(i);

        column1.setHeaderValue(header[i]);
        }  
         
         
     }
             
    private void tc_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tc_fieldKeyTyped
       
        String metin = tc_field.getText();
        int tc_uzunluk = metin.length();
                
        char karakter = evt.getKeyChar();

        if( !(Character.isDigit(karakter)) || tc_uzunluk==11)
        {
        evt.consume();
        }
        
    }//GEN-LAST:event_tc_fieldKeyTyped

    private void ad_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ad_fieldKeyTyped
      
        String metin = ad_field.getText();
        int ad_uzunluk = metin.length();

        char karakter = evt.getKeyChar();

        if( !(Character.isAlphabetic(karakter)) || ad_uzunluk==30)
        {
            evt.consume();
        }
        
    }//GEN-LAST:event_ad_fieldKeyTyped

    private void soyad_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soyad_fieldKeyTyped

        String metin = soyad_field.getText();
        int soyad_uzunluk = metin.length();

        char karakter = evt.getKeyChar();
        
        if( !(Character.isAlphabetic(karakter))  || soyad_uzunluk == 30  )
        {
          evt.consume();
        }
        
    }//GEN-LAST:event_soyad_fieldKeyTyped

    private void sicil_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sicil_fieldKeyTyped
       
        String metin = sicil_field.getText();
        int sicil_no = metin.length();

        char karakter = evt.getKeyChar();

        if( !(Character.isDigit(karakter)) || sicil_no==6 )
        {
         evt.consume();
        } 
        
    }//GEN-LAST:event_sicil_fieldKeyTyped

    private void yeni_arama_butonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yeni_arama_butonActionPerformed
      
       tc_field.setText("");
       ad_field.setText("");
       soyad_field.setText("");
       sicil_field.setText("");
       
       unvan_combo_box.setEditable(true);
       unvan_combo_box.setSelectedItem("-Ünvanlar-");
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
       
       //kimlik_bilgileri_tablo
        ((DefaultTableModel)kimlik_bilgileri_tablo.getModel()).setRowCount(0);
        
    }//GEN-LAST:event_yeni_arama_butonActionPerformed

    private void personel_islem_ekranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personel_islem_ekranActionPerformed
          
        this.setVisible(false);
        
        Personel_islemleri_Ekrani ekran = new Personel_islemleri_Ekrani();
        ekran.setVisible(true);
    }//GEN-LAST:event_personel_islem_ekranActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        String sorgu
                     = " SELECT "      
                     + "sanal_tablo.pkb_tc_no,"
                     + "sanal_tablo.pkb_ad,"
                     + "sanal_tablo.pkb_soyad,"
                     + "sanal_tablo.pkb_sicil_no,"
                     + "gorev_yerleri.pg_Ad,"
                     + "unvan.Unv_Adi,"
                     + "gorev.gorev_Adi,"
                     + "istihdam.Pst_Ele_Adi,"
                     + "gorev_durumu.Pst_Ele_Adi AS Gorev_Durumu "                
                     + "FROM  "
                     + "(SELECT concat ('/tc:' ,per.pkb_tc_no, '/ad:' , per.pkb_ad , '/soyad:' , per.pkb_soyad , '/sicil:' , per.pkb_sicil_no , "
                     + "'/gorev_yeri:' , per.pkb_gorev_yeri , '/unvan_kodu:' , per.pkb_unvan_k , '/gorev_kodu:',"
                     + "per.pkb_gorev_k , '/istihdam_tipi:' , per.pkb_istihdam_tipi ,'/gorev_durumu:', per.pkb_gor_drm) arama "
                     + ", per.* from per_kimlik_bilgileri per) sanal_tablo"
                     + ", per_unvanlar unvan, per_gorevler gorev,"
                     + "per_gorev_yerleri gorev_yerleri, per_sozluk_tablo istihdam, per_sozluk_tablo gorev_durumu "          
                     + "WHERE ((sanal_tablo.pkb_unvan_k=unvan.Unv_Kodu)  AND "
                     + "(sanal_tablo.pkb_gorev_k=gorev.gorev_kodu)  "
                     + "AND (sanal_tablo.pkb_gorev_yeri=gorev_yerleri.pg_kod)  "
                     + "AND ( (sanal_tablo.pkb_istihdam_tipi=istihdam.Pst_Ele_Kodu)  "
                     + "AND istihdam.Pst_Tablo_Kodu=1 ) "
                     + "AND (  (sanal_tablo.pkb_gor_drm=gorev_durumu.Pst_Ele_Kodu)"
                     + "AND gorev_durumu.Pst_Tablo_Kodu=3 ))";  
        
        try 
       {
               
             statement=con.createStatement();
             
             resultset = statement.executeQuery(sorgu);
             
             resultSetToTableModel(resultset, kimlik_bilgileri_tablo);
             
             
       } 
       
       catch (SQLException ex) 
       {
           
           Logger.getLogger(Kimlik_bilgileri_arama_ekrani.class.getName()).log(Level.SEVERE, null, ex);
       }
    
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /*public void dinamik_ara(String ara)
    {
        
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        
        kimlik_bilgileri_tablo.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(ara));
        
    }*/
            
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ad_field;
    private javax.swing.JButton arama_butonu;
    private javax.swing.JComboBox gorev_combo_box;
    private javax.swing.JComboBox gorev_durumu_combo_box;
    private javax.swing.JComboBox gorev_yeri_combo_box;
    private javax.swing.JComboBox istihdam_combo_box;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpanel;
    private javax.swing.JTable kimlik_bilgileri_tablo;
    private javax.swing.JButton personel_islem_ekran;
    private javax.swing.JTextField sicil_field;
    private javax.swing.JTextField soyad_field;
    private javax.swing.JTextField tc_field;
    private javax.swing.JComboBox unvan_combo_box;
    private javax.swing.JButton yeni_arama_buton;
    // End of variables declaration//GEN-END:variables
}
