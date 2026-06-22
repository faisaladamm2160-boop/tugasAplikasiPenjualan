/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.*;
/**
 *
 * @author faisa
 */
public class koneksi {
    private Connection koneksi;
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("berhasil konek");
        }
        catch(ClassNotFoundException ex){
            System.out.println("gagal konek"+ex);
        }
        String url = "jdbc:mysql://localhost:3306/penjualan";
        try{
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("berhasil konek ke database");
        }
        catch(SQLException ex){
            System.out.println("gagal konek ke database"+ex);
        }
        return koneksi;
    }
}
