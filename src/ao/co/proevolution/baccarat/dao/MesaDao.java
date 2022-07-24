/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.dao;

import ao.co.proevolution.baccarat.util.IDao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.enumerador.StatusMesa;
import ao.co.proevolution.baccarat.model.Mesa;
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
public class MesaDao implements Serializable, IDao<Mesa> {

    public Mesa findByIp(String ip) throws Exception {

         Mesa cor = null;

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "select \"id\",\"status\",\"designacao\",\"status_mesa\",\"ip\",\"mac_add\" from public.mesa WHERE \"status\"='ACTIVADO' AND \"ip\"='"+ip+"'\n"
                    + "";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                 cor = new Mesa();
                cor.setId(rs.getLong(1));
                cor.setStatus(Status.valueOf(rs.getString(2)));
                cor.setDesignacao(rs.getString(3));
                cor.setStatus_mesa(rs.getInt(4) == 0 ? StatusMesa.OFFLINE : rs.getInt(4) == 1 ? StatusMesa.ONLINE : StatusMesa.PAUSA_TROCA_OQUESTRADOR );
                cor.setIp(rs.getString(5));
                cor.setMac_add(rs.getString(6));


            }

        } catch (SQLException ex) {
            Logger.getLogger(MesaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cor;

    }
    public Mesa findByID(Long id) throws Exception {

         Mesa cor = null;

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "select \"id\",\"status\",\"designacao\",\"status_mesa\",\"ip\",\"mac_add\" from public.mesa WHERE \"status\"='ACTIVADO' AND \"id\"="+id+"\n"
                    + "";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                 cor = new Mesa();
                cor.setId(rs.getLong(1));
                cor.setStatus(Status.valueOf(rs.getString(2)));
                cor.setDesignacao(rs.getString(3));
                cor.setStatus_mesa(rs.getInt(4) == 0 ? StatusMesa.OFFLINE : rs.getInt(4) == 1 ? StatusMesa.ONLINE : StatusMesa.PAUSA_TROCA_OQUESTRADOR );
                cor.setIp(rs.getString(5));
                cor.setMac_add(rs.getString(6));


            }

        } catch (SQLException ex) {
            Logger.getLogger(MesaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cor;

    }

    public Mesa findByMacAdd(String macAdd) throws Exception {

       Mesa cor = null;

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "select \"id\",\"status\",\"designacao\",\"status_mesa\",\"ip\",\"mac_add\" from public.mesa WHERE \"status\"='ACTIVADO' AND \"mac_add\"='"+macAdd+"'\n"
                    + "";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                 cor = new Mesa();
                cor.setId(rs.getLong(1));
                cor.setStatus(Status.valueOf(rs.getString(2)));
                cor.setDesignacao(rs.getString(3));
              cor.setStatus_mesa(rs.getInt(4) == 0 ? StatusMesa.OFFLINE : rs.getInt(4) == 1 ? StatusMesa.ONLINE : StatusMesa.PAUSA_TROCA_OQUESTRADOR );
                cor.setIp(rs.getString(5));
                cor.setMac_add(rs.getString(6));


            }

        } catch (SQLException ex) {
            Logger.getLogger(MesaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cor;

    }

    @Override
    public boolean save(Mesa obj) {

        boolean flag = false;

        try {
            String sql = "INSERT INTO public.mesa(\"status\",\"designacao\",\"status_mesa\",\"ip\",\"mac_add\")\n"
                    + "VALUES(?,?,?,?,?)";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getStatus().toString());
            ps.setString(2, obj.getDesignacao());
            ps.setInt(3, obj.getStatus_mesa().getCod());
            ps.setString(4, obj.getIp());
            ps.setString(5, obj.getMac_add());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(MesaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flag;
    }

    @Override
    public boolean update(Mesa obj) {

        boolean flag = false;

        try {
            String sql = "UPDATE public.mesa SET \"status\"=?,\"designacao\"=?,\"status_mesa\"=?,\"ip\"=?,\"mac_add\"=?\n"
                    + " WHERE \"id\"=?";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getStatus().toString());
            ps.setString(2, obj.getDesignacao());
            ps.setInt(3, obj.getStatus_mesa().getCod());
            ps.setString(4, obj.getIp());
            ps.setString(5, obj.getMac_add());
            ps.setLong(6, obj.getId());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(MesaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return flag;

    }

    @Override
    public boolean saveOrUpdate(Mesa obj) {
        return obj.getId() != null ? update(obj) : save(obj);
    }

    @Override
    public List<Mesa> findAll() {

        List<Mesa> lista = new ArrayList();

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "select \"id\",\"status\",\"designacao\",\"status_mesa\",\"ip\",\"mac_add\" from public.mesa WHERE \"status\"='ACTIVADO';\n"
                    + "";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Mesa cor = new Mesa();
                cor.setId(rs.getLong(1));
                cor.setStatus(Status.valueOf(rs.getString(2)));
                cor.setDesignacao(rs.getString(3));
                cor.setStatus_mesa(rs.getInt(4) == 0 ? StatusMesa.OFFLINE : rs.getInt(4) == 1 ? StatusMesa.ONLINE : StatusMesa.PAUSA_TROCA_OQUESTRADOR );
                cor.setIp(rs.getString(5));
                cor.setMac_add(rs.getString(6));

                lista.add(cor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(MesaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
