/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.dao;

import ao.co.proevolution.baccarat.util.IDao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.enumerador.TipoMedia;
import ao.co.proevolution.baccarat.model.Media;
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
public class MediaDao implements Serializable, IDao<Media> {

    public List<Media> findAllOrderByTipoMedia() throws Exception {

        List<Media> lista = new ArrayList<>();

        try {

//            this.entity = NewHibernateUtil.getSession();
//            TypedQuery<Media> query = this.entity.createQuery("SELECT u FROM Media u ORDER BY u.tipo_media ASC", Media.class);
//
//            lista = query.getResultList();
//            this.entity.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;

    }

    public List<Media> findByTipoMedia(TipoMedia tipoMedia) throws Exception {

       List<Media> lista = new ArrayList();

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "select \"id\",\"status\",\"duracao_segundo\",\"name\"\n"
                    + "from public.media WHERE \"status\"='ACTIVADO' AND \"tipo_media\"='"+tipoMedia.toString()+"';";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Media cor = new Media();
                cor.setId(rs.getLong(1));

                cor.setStatus(Status.valueOf(rs.getString(2)));

                cor.setDuracao_segundo(rs.getInt(3));
                cor.setName(rs.getString(4));

                cor.setTipo_media(tipoMedia);

                lista.add(cor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(MediaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    @Override
    public boolean save(Media obj) {

        boolean flag = false;

        try {
            String sql = "INSERT INTO public.media(\"status\",\"duracao_segundo\",\"name\",\"tipo_media\")"
                    + "VALUES(?,?,?,?)";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, obj.getStatus().toString());
            ps.setInt(2, obj.getDuracao_segundo());
            ps.setString(3, obj.getName());
            ps.setString(4, obj.getTipo_media().toString());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(MediaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flag;
    }

    @Override
    public boolean update(Media obj) {

        boolean flag = false;

        try {
            String sql = "UPDATE public.cor SET \"status\"=?,\"duracao_segundo\"=?,\"name\"=?,\"tipo_media\"=?"
                    + " WHERE \"id\"=?";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getStatus().toString());
            ps.setInt(2, obj.getDuracao_segundo());
            ps.setString(3, obj.getName());
            ps.setString(4, obj.getTipo_media().toString());
            ps.setLong(5, obj.getId());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(MediaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return flag;

    }

    @Override
    public boolean saveOrUpdate(Media obj) {
        return obj.getId() != null ? update(obj) : save(obj);
    }

    @Override
    public List<Media> findAll() {

        List<Media> lista = new ArrayList();

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "select \"id\",\"status\",\"duracao_segundo\",\"name\",\"tipo_media\"\n"
                    + "from public.media WHERE \"status\"='ACTIVADO';";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Media cor = new Media();
                cor.setId(rs.getLong(1));

                cor.setStatus(Status.valueOf(rs.getString(2)));

                cor.setDuracao_segundo(rs.getInt(3));
                cor.setName(rs.getString(4));

                cor.setTipo_media(TipoMedia.valueOf(rs.getString(5)));

                lista.add(cor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(MediaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public boolean delete(Long id) {

        return false;

    }

}
