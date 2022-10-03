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
       //untuk koneksi ke database
       try{
           Class.forName("org.sqlite.JDBC");
           String url="jdbc:sqlite:C:/Program Files/Silalita/silalita.db";
           koneksi=DriverManager.getConnection(url);
       }catch(SQLException se){
           System.out.println("Gagal koneksi data"+se);
           JOptionPane.showMessageDialog(null,"Gagal Koneksi Database","Peringatan",JOptionPane.WARNING_MESSAGE);
       } catch (ClassNotFoundException ex) {
           System.out.println("Gagal koneksi "+ex);
           JOptionPane.showMessageDialog(null,"Gagal Koneksi Database","Peringatan",JOptionPane.WARNING_MESSAGE);
           System.exit(0);
        }
        return koneksi;
    }
}
