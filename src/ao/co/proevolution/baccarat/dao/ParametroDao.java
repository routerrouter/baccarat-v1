/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.dao;

import ao.co.proevolution.baccarat.util.IDao;
import ao.co.proevolution.baccarat.enumerador.ParametroDesignacao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.model.Parametro;
import ao.co.proevolution.baccarat.util.Conexao;
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
public class ParametroDao implements Serializable, IDao<Parametro> {

    public Parametro findByDesignacao(ParametroDesignacao designacao) {

        Parametro parametro = null;

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "select \"id\",\"status\",\"descricao\",\"designacao\",\"valor\"\n"
                    + "from public.parametro WHERE \"status\"='ACTIVADO' AND \"designacao\"='" + designacao.toString() + "';";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                parametro = new Parametro();
                parametro.setId(rs.getLong(1));

                parametro.setStatus(Status.valueOf(rs.getString(2)));
                parametro.setDescricao(rs.getString(3));
                parametro.setDesignacao(ParametroDesignacao.valueOf(rs.getString(4)));
                parametro.setValor(rs.getString(5));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ParametroDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return parametro;
    }

    @Override
    public boolean save(Parametro obj) {

        boolean flag = false;

        try {
            String sql = "INSERT INTO public.parametro(\"status\",\"descricao\",\"designacao\",\"valor\")"
                    + "VALUES(?,?,?,?)";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getStatus().toString());
            ps.setString(2, obj.getDescricao());
            ps.setString(3, obj.getDesignacao().toString());
            ps.setString(4, obj.getValor());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ParametroDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flag;
    }

    @Override
    public boolean update(Parametro obj) {

        boolean flag = false;

        try {
            String sql = "UPDATE public.parametro SET \"status\"=?,\"descricao\"=?,\"designacao\"=?,\"valor\"=?"
                    + " WHERE \"id\"=?";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getStatus().toString());
            ps.setString(2, obj.getDescricao());
            ps.setString(3, obj.getDesignacao().toString());
            ps.setString(4, obj.getValor());
            ps.setLong(5, obj.getId());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ParametroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return flag;

    }

    @Override
    public boolean saveOrUpdate(Parametro obj) {
        return obj.getId() != null ? update(obj) : save(obj);
    }

    @Override
    public List<Parametro> findAll() {

        List<Parametro> lista = new ArrayList();

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "select \"id\",\"status\",\"descricao\",\"designacao\",\"valor\"\n"
                    + "from public.parametro WHERE \"status\"='ACTIVADO';";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Parametro parametro = new Parametro();
                parametro.setId(rs.getLong(1));

                parametro.setStatus(Status.valueOf(rs.getString(2)));
                parametro.setDescricao(rs.getString(3));
                parametro.setDesignacao(ParametroDesignacao.valueOf(rs.getString(4)));
                parametro.setValor(rs.getString(5));

                lista.add(parametro);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ParametroDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public boolean delete(Long id) {

        return false;

    }

}
