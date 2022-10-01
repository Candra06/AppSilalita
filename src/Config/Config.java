/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class Config {
    private static Connection mysqlconfig;
    private static Connection koneksi;
    public static Connection configDB() { 
       //untuk koneksidd ke database
       try{
           Class.forName("org.sqlite.JDBC");
           String url="jdbc:sqlite:silalita.db";
           koneksi=DriverManager.getConnection(url);
           return koneksi;
       }catch(SQLException se){
           System.out.println("Gagal koneksi "+se);
           
           JOptionPane.showMessageDialog(null,"Gagal Koneksi Database","Peringatan",JOptionPane.WARNING_MESSAGE);
       } catch (ClassNotFoundException ex) {
           System.out.println("Gagal koneksi "+ex);
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
       
//        try {
//            String url="jdbc:mysql://localhost:3306/silalita?zeroDateTimeBehavior=CONVERT_TO_NULL"; //url database
//            String user="root"; //user database
//            String pass="bismillah5758-"; //password database
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            mysqlconfig=DriverManager.getConnection(url, user, pass); 
//            
//        } catch (Exception e) {
//            System.err.println("koneksi gagal "+e.getMessage());
//        }
//        return mysqlconfig;
        return koneksi;
    }
}
