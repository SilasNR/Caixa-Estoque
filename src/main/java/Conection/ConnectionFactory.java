/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conection;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ConnectionFactory {

    private static String host = "banco-solicitacao-silasnas2018-a72f.c.aivencloud.com",
            port = "25355", db = "defaultdb", user = "avnadmin", password = "AVNS_NRR0dTeI-96TZd2u-Jh";
    private static String url = "mysql://avnadmin:AVNS_NRR0dTeI-96TZd2u-Jh@banco-solicitacao-silasnas2018-a72f.c.aivencloud.com:25355/defaultdb";

    public ConnectionFactory() {

    }

//    public ConnectionFactory(String host, String port, String db, String user, String password) {
//        this.host = ;
//        ConnectionFactory.port = ;
//        ConnectionFactory.db = ;
//        ConnectionFactory.user = ;
//        ConnectionFactory.password = ;
//    }
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //mysql://user.password@host:port/database  
    private static final String URL
            = String.format(String.format(
                    "jdbc:mysql://%s:%s@%s:%s/%s",
                    user,
                    password,
                    host,
                    port,
                    db
            ));

    public static Connection Conectar(String deonde) {
        try {   
            System.out.println("Iniciando Conexão"+ deonde);
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL);
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            throw new RuntimeException("Erro ao conectar : ", ex);
        }

    }

    public static void closeConection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void closeConection(Connection con, PreparedStatement stmt) {
        closeConection(con);

        try {
            if (stmt != null) {

                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConection(con, stmt);

        try {
            if (rs != null) {

                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
