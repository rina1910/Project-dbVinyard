/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author ASUS
 */
public class Koneksi {
     private static Connection Koneksi;
    public static Connection getKoneksi ()
    {
        if(Koneksi==null)
        {
            try
                {
                String url="jdbc:mysql://localhost/penjualan_db";
                String username="root";
                String password="";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                Koneksi = DriverManager.getConnection (url,username,password);
                }
                    catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
        }
        return Koneksi;
    }
    
    static void getkoneksi (){
        throw new UnsupportedOperationException ("Not Supported yet.");
    }
}
