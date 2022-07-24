/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.dao;

import ao.co.proevolution.baccarat.util.IDao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.model.Cor;
import ao.co.proevolution.baccarat.util.BDConexao;
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
public class CorDao implements Serializable, IDao<Cor> {

    public Cor findByIsUse() throws Exception {
        
        Cor cor = null;

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "SELECT \"id\",\"designacao\",\"r\",\"g\",\"b\",\"a\",\"isuse\",\"status\" FROM public.cor where \"status\" = 'ACTIVADO' AND \"isuse\"=true";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                 cor = new Cor();
                cor.setId(rs.getLong(1));
                cor.setDesignacao(rs.getString(2));
                cor.setColor(new Color(rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
                cor.setIsUse(rs.getBoolean(7));
                  cor.setStatus(Status.valueOf(rs.getString(8)));
              

            }

        } catch (SQLException ex) {
            Logger.getLogger(CorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cor;

    }

    @Override
    public boolean save(Cor obj) {

        boolean flag = false;

        try {
            String sql = "INSERT INTO public.cor(\"designacao\",\"status\",\"r\",\"g\",\"b\",\"a\")"
                    + "VALUES(?,?,?,?,?,?)";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getDesignacao());
            ps.setString(2, obj.getStatus().toString());
            ps.setInt(3, obj.getColor().getRed());
            ps.setInt(4, obj.getColor().getGreen());
            ps.setInt(5, obj.getColor().getBlue());
            ps.setInt(6, obj.getColor().getAlpha());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(CorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flag;
    }

    @Override
    public boolean update(Cor obj) {

        boolean flag = false;

        try {
            String sql = "UPDATE public.cor SET \"designacao\"=?,\"status\"=?,\"r\"=?,\"g\"=?,\"b\"=?,\"a\"=?,\"isuse\"=?"
                    + " WHERE \"id\"=?";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getDesignacao());
            ps.setString(2, obj.getStatus().toString());
            ps.setInt(3, obj.getColor().getRed());
            ps.setInt(4, obj.getColor().getGreen());
            ps.setInt(5, obj.getColor().getBlue());
            ps.setInt(6, obj.getColor().getAlpha());
            ps.setBoolean(7, obj.isIsUse());
            ps.setLong(8, obj.getId());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(CorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return flag;

    }

    @Override
    public boolean saveOrUpdate(Cor obj) {
        return obj.getId() != null ? update(obj) : save(obj);
    }

    @Override
    public List<Cor> findAll() {

        List<Cor> lista = new ArrayList();

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "SELECT \"id\",\"designacao\",\"r\",\"g\",\"b\",\"a\",\"isuse\",\"status\" FROM public.cor where \"status\" = 'ACTIVADO'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cor cor = new Cor();
                cor.setId(rs.getLong(1));
                cor.setDesignacao(rs.getString(2));
                cor.setColor(new Color(rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
                cor.setIsUse(rs.getBoolean(7));
                cor.setStatus(Status.valueOf(rs.getString(8)));

                lista.add(cor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public boolean delete(Long id) {

        return false;

    }

}
