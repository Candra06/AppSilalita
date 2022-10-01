/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author admin
 */
public class Utils {
     public static String setwaktu(String tanggal){
        String waktunya;
        String[] splitwaktu = tanggal.split(" ");
        String[] splittanggal =splitwaktu[0].split("-");
        String[] bulan = {"bln","Januari","Februari","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember"};
        waktunya = splittanggal[2] +" "+bulan[Integer.parseInt(splittanggal[1])]+" "+splittanggal[0];
        return waktunya;
    }

  
}
