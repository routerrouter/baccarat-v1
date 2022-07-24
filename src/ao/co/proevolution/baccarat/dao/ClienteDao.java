/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.dao;

import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.util.IDao;
import ao.co.proevolution.baccarat.model.Cliente;
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
public class ClienteDao implements Serializable,IDao<Cliente>{

    @Override
    public boolean save(Cliente obj) {

        boolean flag = false;

        try {
            String sql = "INSERT INTO public.cliente(\"status\",\"email\",\"endereco\",\"nif\",\"nome\",\"telefone\")"
                    + "VALUES(?,?,?,?,?,?)";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getStatus().toString());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getEndereco());
            ps.setString(4, obj.getNif());
            ps.setString(5, obj.getNome());
            ps.setString(6, obj.getTelefone());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flag;
    }

    @Override
    public boolean update(Cliente obj) {

        boolean flag = false;

        try {
            String sql = "UPDATE public.cliente SET \"status\"=?,\"email\"=?,\"endereco\"=?,\"nif\"=?,\"nome\"=?,\"telefone\"=?"
                    + " WHERE \"id\"=?";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getStatus().toString());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getEndereco());
            ps.setString(4, obj.getNif());
            ps.setString(5, obj.getNome());
            ps.setString(6, obj.getTelefone());
           
            ps.setLong(7, obj.getId());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return flag;

    }

    @Override
    public boolean saveOrUpdate(Cliente obj) {
        return obj.getId() != null ? update(obj) : save(obj);
    }

    @Override
    public List<Cliente> findAll() {

        List<Cliente> lista = new ArrayList();

        try {
            Connection con = new Conexao().ConexaoBD();
            String sql = "SELECT \"id\",\"status\",\"email\",\"endereco\",\"nif\",\"nome\",\"telefone\" FROM public.cliente where \"status\" = 'ACTIVADO'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cliente cor = new Cliente();
                cor.setId(rs.getLong(1));
                cor.setStatus(Status.valueOf(rs.getString(2)));
                cor.setEmail(rs.getString(3));
                cor.setEndereco(rs.getString(4));
                cor.setNif(rs.getString(5));
                cor.setNome(rs.getString(6));
                cor.setTelefone(rs.getString(7));
               

                lista.add(cor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public boolean delete(Long id) {

        return false;

    }

    
}
