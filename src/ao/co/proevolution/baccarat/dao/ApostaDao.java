/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.dao;

import ao.co.proevolution.baccarat.util.IDao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.model.Aposta;
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
public class ApostaDao implements Serializable, IDao<Aposta> {

    public Aposta findByMesa(Mesa mesa, Status status) throws Exception {

        Aposta aposta = null;

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "SELECT \"id\",\"status\",\"valor_maximo_aposta\",\"valor_minimo_aposta\",\"mesa_id\",\"jogadas\" FROM public.aposta where \"status\" = '" + status.toString() + "' AND mesa_id=" + mesa.getId() + "  ORDER BY 1 DESC";

            System.out.println(sql);
            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            MesaDao mesaDao = new MesaDao();

            if (rs.next()) {

                aposta = new Aposta();
                aposta.setId(rs.getLong(1));

                aposta.setId(rs.getLong(1));
                aposta.setStatus(Status.valueOf(rs.getString(2)));
                aposta.setValor_maximo_aposta(rs.getDouble(3));
                aposta.setValor_minimo_aposta(rs.getDouble(4));
                aposta.setMesa(mesaDao.findByID(rs.getLong(5)));
                aposta.setJogadas(rs.getString(6));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ApostaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ApostaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aposta;

    }

    public List<Aposta> findByMesa(Mesa mesa) throws Exception {

        List<Aposta> lista = new ArrayList();

        Aposta aposta = null;

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "SELECT \"id\",\"status\",\"valor_maximo_aposta\",\"valor_minimo_aposta\",\"mesa_id\",\"jogadas\" FROM public.aposta where \"status\" = 'ACTIVADO' AND mesa_id=" + mesa.getId() + "  ORDER BY 1 DESC";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            MesaDao mesaDao = new MesaDao();

            if (rs.next()) {

                aposta = new Aposta();
                aposta.setId(rs.getLong(1));

                aposta.setId(rs.getLong(1));
                aposta.setStatus(Status.valueOf(rs.getString(2)));
                aposta.setValor_maximo_aposta(rs.getDouble(3));
                aposta.setValor_minimo_aposta(rs.getDouble(4));
                aposta.setMesa(mesaDao.findByID(rs.getLong(5)));
                aposta.setJogadas(rs.getString(6));

                lista.add(aposta);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ApostaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ApostaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public List<Aposta> findByMesa(Status status) throws Exception {

        List<Aposta> lista = new ArrayList();

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "SELECT  \n"
                    + "	aposta.\"id\",\n"
                    + "	aposta.\"status\",\n"
                    + "	aposta.\"valor_maximo_aposta\",\n"
                    + "	aposta.\"valor_minimo_aposta\",\n"
                    + "	aposta.\"jogadas\",\n"
                    + "	mesa.\"id\",\n"
                    + "	mesa.\"designacao\",\n"
                    + "from public.aposta\n"
                    + "	INNER JOIN public.mesa ON mesa.id = aposta.mesa_id\n"
                    + "WHERE\n"
                    + "	aposta.status = 'ACTIVADO'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            MesaDao mesaDao = new MesaDao();

            while (rs.next()) {

                Aposta aposta = new Aposta();
                aposta.setId(rs.getLong(1));

                aposta.setId(rs.getLong(1));
                aposta.setStatus(Status.valueOf(rs.getString(2)));
                aposta.setValor_maximo_aposta(rs.getDouble(3));
                aposta.setValor_minimo_aposta(rs.getDouble(4));

                aposta.setJogadas(rs.getString(5));

                aposta.setMesa(new Mesa(rs.getLong(5), rs.getString(6)));

                lista.add(aposta);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ApostaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ApostaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    @Override
    public boolean save(Aposta obj) {

        boolean flag = false;

        try {
            String sql = "INSERT INTO public.aposta(\"status\",\"valor_maximo_aposta\",\"valor_minimo_aposta\",\"mesa_id\",\"jogadas\")"
                    + "VALUES(?,?,?,?,?)";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getStatus().toString());
            ps.setDouble(2, obj.getValor_maximo_aposta());
            ps.setDouble(3, obj.getValor_minimo_aposta());
            ps.setLong(4, obj.getMesa().getId());
            ps.setString(5, obj.getJogadas());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ApostaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flag;
    }

    @Override
    public boolean update(Aposta obj) {

        boolean flag = false;

        try {
            String sql = "UPDATE public.aposta SET \"status\"=?,\"valor_maximo_aposta\"=?,\"valor_minimo_aposta\"=?,\"mesa_id\"=?,\"jogadas\"=?"
                    + " WHERE \"id\"=?";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getStatus().toString());
            ps.setDouble(2, obj.getValor_maximo_aposta());
            ps.setDouble(3, obj.getValor_minimo_aposta());
            ps.setLong(4, obj.getMesa().getId());
            ps.setString(5, obj.getJogadas());
            ps.setLong(6, obj.getId());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ApostaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return flag;

    }

    @Override
    public boolean saveOrUpdate(Aposta obj) {
        return obj.getId() != null ? update(obj) : save(obj);
    }

    @Override
    public List<Aposta> findAll() {

        List<Aposta> lista = new ArrayList();

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "SELECT \"id\",\"status\",\"valor_maximo_aposta\",\"valor_minimo_aposta\",\"mesa_id\",\"jogadas\" FROM public.aposta where \"status\" = 'ACTIVADO'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            MesaDao mesaDao = new MesaDao();

            while (rs.next()) {

                Aposta aposta = new Aposta();
                aposta.setId(rs.getLong(1));

                aposta.setId(rs.getLong(1));
                aposta.setStatus(Status.valueOf(rs.getString(2)));
                aposta.setValor_maximo_aposta(rs.getDouble(3));
                aposta.setValor_minimo_aposta(rs.getDouble(4));
                aposta.setMesa(mesaDao.findByID(rs.getLong(5)));
                aposta.setJogadas(rs.getString(6));

                lista.add(aposta);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ApostaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ApostaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public boolean delete(Long id) {

        return false;

    }

}
