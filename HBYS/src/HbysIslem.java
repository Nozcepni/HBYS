/**
 *
 * @author samet
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HbysIslem {
     
    public Connection con = null;
    
    public Statement statement = null;
    
     public PreparedStatement preparedstatement= null;
             
     
       public HbysIslem() //DATABASE BAĞLANTI
    {
                 
           
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
         
        try 
        {
             Class.forName("com.mysql.jdbc.Driver");
        }
        
         catch(ClassNotFoundException ex) 
        {
            System.out.println("Driver Bulunamadı....");
        }
         
         try 
        {
            con = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
            System.out.println("Bağlantı Başarılı...");
        } 
         
        catch (SQLException ex) 
        {
            System.out.println("Bağlantı Başarısız...");
            ex.printStackTrace();
        }
        
    }
       
      public boolean girisYapTc(String tc)
     {
        String sorgu= " Select * "
                + "From per_kullanicilar"
                + " where Pkl_Tc_No = ?";
        
        try
        {
            preparedstatement = con.prepareStatement(sorgu);
            
            preparedstatement.setString(1, tc); //Soru işareti yerine tc gönderiyoruz
            
            ResultSet rs = preparedstatement.executeQuery();
            
            return rs.next(); 
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(HbysIslem.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
      }
        
     
     public boolean TcKontrol(String tc) //ARANAN TC'NİN VERİ TABANINDA BULUNUP BULUNMADIĞINA BAKMAK İÇİN
     {
         
       String sorgu= " Select * "
                + "From per_kimlik_bilgileri"
                + " where Pkb_Tc_No = ?";
        
        try
        {
            preparedstatement = con.prepareStatement(sorgu);
            
            preparedstatement.setString(1, tc); //Soru işareti yerine tc gönderiyoruz
            
            
            ResultSet rs = preparedstatement.executeQuery();
            
            return rs.next(); 
            
            
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(HbysIslem.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
        
      }  
         
       
      
     public boolean girisYapSifre(String sifre)
     {
        String sorgu= " Select * "
                + "From per_kullanicilar "
                + "where Pkl_Sifre = ?";
        
        try
        {
            preparedstatement = con.prepareStatement(sorgu);
            
            preparedstatement.setString(1, sifre); //Soru işareti yerine sifre gönderiyoruz
            
            
            ResultSet rs = preparedstatement.executeQuery();
            
            return rs.next(); 
            
            
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(HbysIslem.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
      }
         
         //Result Set ile Veri Tabanından dönen sonuçları getiriyoruz
        public ResultSet Getir(String sorgu)
        {
          
          ResultSet rs = null;

          try 
          {
              statement = con.createStatement();

              rs = statement.executeQuery(sorgu);
               return rs;

          }

          catch (SQLException ex)
          {
              Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
          } 

          return rs;

       }
    
}
