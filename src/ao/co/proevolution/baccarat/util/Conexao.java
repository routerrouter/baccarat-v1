/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * 
 */
public class Conexao {

    Connection con;
    Statement stmt;
    public ResultSet rs;

    public Connection ConexaoBD() {

        try {

            con = ConnectionFactory.getConnection();
            stmt = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro Conexao:" + e);
        }
        return con;
    }

    public void executaSQL(String sql) {
        try {
            stmt = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
        }
    }
    
    public ResultSet ejecutarSQLSelect(String sql) {
        ResultSet resultado;
        try {
            PreparedStatement sentencia = con.prepareStatement(sql);
            resultado = sentencia.executeQuery();
            return resultado;
        } catch (SQLException ex) {
            System.err.println("Error " + ex);
            return null;
        }
    }

}
