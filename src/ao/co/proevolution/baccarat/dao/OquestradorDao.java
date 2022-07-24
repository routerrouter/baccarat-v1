/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.dao;

import ao.co.proevolution.baccarat.util.IDao;
import Util.DataComponent;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.model.Oquestrador;
import ao.co.proevolution.baccarat.util.Conexao;
import java.awt.Color;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filme
 */
public class OquestradorDao implements Serializable, IDao<Oquestrador> {

    public Oquestrador findByUsuarioAndSenha(String usuario, String senha) {

        Oquestrador cor = null;

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "select \"id\",\"status\",\"data_ultima_check\",\"islogado\",\"nome\",\"password\",\"user_name\"\n"
                    + "from public.oquestrador WHERE \"status\"='ACTIVADO' AND \"user_name\"='" + usuario + "' AND \"password\"=MD5('" + senha + "') ;";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                cor = new Oquestrador();
                cor.setId(rs.getLong(1));
                cor.setStatus(Status.valueOf(rs.getString(2)));
                cor.setData_ultima_check(rs.getDate(3));
                cor.setIsLogado(rs.getBoolean(4));
                cor.setNome(rs.getString(5));
                cor.setPassword(rs.getString(6));
                cor.setUser_name(rs.getString(7));

            }

        } catch (SQLException ex) {
            Logger.getLogger(OquestradorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cor;

    }

    @Override
    public boolean save(Oquestrador obj) {

        boolean flag = false;

        try {
            String sql = "INSERT INTO public.oquestrador(\"status\",\"data_ultima_check\",\"islogado\",\"nome\",\"password\",\"user_name\")\n"
                    + "VALUES(?,?,?,?,MD5(?),?)";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getStatus().toString());
            ps.setString(2, DataComponent.getDataVencimento(obj.getData_ultima_check()));
            ps.setBoolean(3, obj.isIsLogado());
            ps.setString(4, obj.getNome());
            ps.setString(5, obj.getPassword());
            ps.setString(6, obj.getUser_name());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(OquestradorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flag;
    }

    @Override
    public boolean update(Oquestrador obj) {

        boolean flag = false;

        try {
            String sql = "UPDATE public.oquestrador SET \"status\"=?,\"data_ultima_check\"=?,\"islogado\"=?,\"nome\"=?,\"password\"=?,\"user_name\"=?\n"
                    + " WHERE \"id\"=?";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getStatus().toString());
            ps.setString(2, DataComponent.getDataVencimento(obj.getData_ultima_check()));
            ps.setBoolean(3, obj.isIsLogado());
            ps.setString(4, obj.getNome());
            ps.setString(5, obj.getPassword());
            ps.setString(6, obj.getUser_name());
            ps.setLong(7, obj.getId());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(OquestradorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return flag;

    }

    @Override
    public boolean saveOrUpdate(Oquestrador obj) {
        return obj.getId() != null ? update(obj) : save(obj);
    }

    @Override
    public List<Oquestrador> findAll() {

        List<Oquestrador> lista = new ArrayList();

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "select \"id\",\"status\",\"data_ultima_check\",\"islogado\",\"nome\",\"password\",\"user_name\"\n"
                    + "from public.oquestrador WHERE \"status\"='ACTIVADO';";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Oquestrador cor = new Oquestrador();
                cor.setId(rs.getLong(1));
                cor.setStatus(Status.valueOf(rs.getString(2)));
                cor.setData_ultima_check(rs.getDate(3));
                cor.setIsLogado(rs.getBoolean(4));
                cor.setNome(rs.getString(5));
                cor.setPassword(rs.getString(6));
                cor.setUser_name(rs.getString(7));

                lista.add(cor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(OquestradorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public boolean delete(Long id) {

        return false;

    }

}
