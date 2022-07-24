/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.dao;

import Util.DataComponent;
import ao.co.proevolution.baccarat.util.IDao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.model.Aposta;
import ao.co.proevolution.baccarat.model.LogApostaOquestrador;
import ao.co.proevolution.baccarat.model.Mesa;
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
public class LogApostaOquestradorDao implements Serializable, IDao<LogApostaOquestrador> {

    public List<LogApostaOquestrador> findByStatus(Status status) throws Exception {

        List<LogApostaOquestrador> lista = null;

        try {

//            this.entity = NewHibernateUtil.getSession();
//            TypedQuery<LogApostaOquestrador> query = this.entity.createQuery("SELECT u FROM LogApostaOquestrador u WHERE u.status=:status", LogApostaOquestrador.class);
//            query.setParameter("status", status);
//
//            lista = query.getResultList();
//            this.entity.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;

    }

    public List<LogApostaOquestrador> findByStatus(Status status, Mesa mesa) throws Exception {

        List<LogApostaOquestrador> lista = new ArrayList();

         LogApostaOquestrador log_aposta_oquestrador = null;

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "select log_aposta_oquestrador.\"id\",log_aposta_oquestrador.\"status\",log_aposta_oquestrador.\"aposta_id\",\"oquestrador_id\",oquestrador.\"password\",\n"
                    + "oquestrador.data_ultima_check,oquestrador.islogado,oquestrador.nome,oquestrador.user_name\n"
                    + "from public.log_aposta_oquestrador \n"
                    + "	INNER JOIN public.oquestrador ON oquestrador.id = log_aposta_oquestrador.oquestrador_id\n"
                    + "	INNER JOIN public.aposta ON aposta.id = log_aposta_oquestrador.aposta_id\n"
                    + "WHERE log_aposta_oquestrador.\"status\" = 'ACTIVADO' AND aposta.mesa_id ="+mesa.getId();

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                 log_aposta_oquestrador = new LogApostaOquestrador();
                log_aposta_oquestrador.setId(rs.getLong(1));
                log_aposta_oquestrador.setStatus(Status.valueOf(rs.getString(2)));
                log_aposta_oquestrador.setAposta(new Aposta(rs.getLong(3)));
                log_aposta_oquestrador.setOquestrador(new Oquestrador(rs.getLong(4), rs.getString(5), DataComponent.stringParaData(rs.getString(6)), rs.getString(7), rs.getString(8)));

                lista.add(log_aposta_oquestrador);

            }

        } catch (SQLException ex) {
            Logger.getLogger(LogApostaOquestradorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public LogApostaOquestrador findByApostaActivada(Aposta aposta) throws Exception {

        LogApostaOquestrador log_aposta_oquestrador = null;

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "select log_aposta_oquestrador.\"id\",log_aposta_oquestrador.\"status\",log_aposta_oquestrador.\"aposta_id\",\"oquestrador_id\",oquestrador.\"password\",\n"
                    + "oquestrador.data_ultima_check,oquestrador.islogado,oquestrador.nome,oquestrador.user_name\n"
                    + "from public.log_aposta_oquestrador \n"
                    + "	INNER JOIN public.oquestrador ON oquestrador.id = log_aposta_oquestrador.oquestrador_id\n"
                    + "	INNER JOIN public.aposta ON aposta.id = log_aposta_oquestrador.aposta_id\n"
                    + "WHERE log_aposta_oquestrador.\"status\" = 'ACTIVADO' AND aposta.id ="+aposta.getId()+" ORDER BY 1 DESC";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                 log_aposta_oquestrador = new LogApostaOquestrador();
                log_aposta_oquestrador.setId(rs.getLong(1));
                log_aposta_oquestrador.setStatus(Status.valueOf(rs.getString(2)));
                log_aposta_oquestrador.setAposta(new Aposta(rs.getLong(3)));
                log_aposta_oquestrador.setOquestrador(new Oquestrador(rs.getLong(4), rs.getString(5), DataComponent.stringParaData(rs.getString(6)), rs.getString(7), rs.getString(8)));

                

            }

        } catch (SQLException ex) {
            Logger.getLogger(LogApostaOquestradorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return log_aposta_oquestrador;

    }

    public LogApostaOquestrador findByOquestrador(Oquestrador oquestrador, Mesa mesa) throws Exception {

         LogApostaOquestrador log_aposta_oquestrador = null;

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "select log_aposta_oquestrador.\"id\",log_aposta_oquestrador.\"status\",log_aposta_oquestrador.\"aposta_id\",log_aposta_oquestrador.\"oquestrador_id\",oquestrador.\"password\",\n"
                    + "oquestrador.data_ultima_check,oquestrador.islogado,oquestrador.nome,oquestrador.user_name\n"
                    + "from public.log_aposta_oquestrador \n"
                    + "	INNER JOIN public.oquestrador ON oquestrador.id = log_aposta_oquestrador.oquestrador_id\n"
                    + "	INNER JOIN public.aposta ON aposta.id = log_aposta_oquestrador.aposta_id\n"
                    + "WHERE log_aposta_oquestrador.\"status\" = 'ACTIVADO' AND aposta.mesa_id NOT IN("+mesa.getId()+") AND oquestrador.id="+oquestrador.getId();

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                 log_aposta_oquestrador = new LogApostaOquestrador();
                log_aposta_oquestrador.setId(rs.getLong(1));
                log_aposta_oquestrador.setStatus(Status.valueOf(rs.getString(2)));
                log_aposta_oquestrador.setAposta(new Aposta(rs.getLong(3)));
                log_aposta_oquestrador.setOquestrador(new Oquestrador(rs.getLong(4), rs.getString(5), DataComponent.stringParaData(rs.getString(6)), rs.getString(7), rs.getString(8)));

                

            }

        } catch (SQLException ex) {
            Logger.getLogger(LogApostaOquestradorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return log_aposta_oquestrador;

    }

    @Override
    public boolean save(LogApostaOquestrador obj) {

        boolean flag = false;

        try {
            String sql = "INSERT INTO public.log_aposta_oquestrador(\"status\",\"aposta_id\",\"oquestrador_id\")"
                    + "VALUES(?,?,?)";
            System.out.println("INSERT");
            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, obj.getStatus().toString());
            ps.setLong(2, obj.getAposta().getId());
            ps.setLong(3, obj.getOquestrador().getId());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(LogApostaOquestradorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flag;
    }

    @Override
    public boolean update(LogApostaOquestrador obj) {

        boolean flag = false;
System.out.println("UPDATE");
        try {
            String sql = "UPDATE public.log_aposta_oquestrador SET \"status\"=?,\"aposta_id\"=?,\"oquestrador_id\"=?"
                    + " WHERE \"id\"=?";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getStatus().toString());
            ps.setLong(2, obj.getAposta().getId());
            ps.setLong(3, obj.getOquestrador().getId());
            ps.setLong(4, obj.getId());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(LogApostaOquestradorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return flag;

    }

    @Override
    public boolean saveOrUpdate(LogApostaOquestrador obj) {
        return obj.getId() != null ? update(obj) : save(obj);
    }

    @Override
    public List<LogApostaOquestrador> findAll() {

        List<LogApostaOquestrador> lista = new ArrayList();

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "select \"id\",\"status\",\"aposta_id\",\"oquestrador_id\","
                    + "oquestrador.\"password\",oquestrador.\"data_ultima_check\",oquestrador.\"islogado\","
                    + "oquestrador.\"nome\",oquestrador.\"user_name\"\n"
                    + "from public.log_aposta_oquestrador \n"
                    + "	INNER JOIN public.oquestrador ON oquestrador.id = log_aposta_oquestrador.oquestrador_id\n"
                    + "WHERE \"status\" = 'ACTIVADO'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                LogApostaOquestrador log_aposta_oquestrador = new LogApostaOquestrador();
                log_aposta_oquestrador.setId(rs.getLong(1));
                log_aposta_oquestrador.setStatus(Status.valueOf(rs.getString(2)));
                log_aposta_oquestrador.setAposta(new Aposta(rs.getLong(3)));
                log_aposta_oquestrador.setOquestrador(new Oquestrador(rs.getLong(4),rs.getString(5),DataComponent.stringParaData(rs.getString(6)),rs.getString(7),rs.getString(8)));

                lista.add(log_aposta_oquestrador);

            }

        } catch (SQLException ex) {
            Logger.getLogger(LogApostaOquestradorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public boolean delete(Long id) {

        return false;

    }

}
