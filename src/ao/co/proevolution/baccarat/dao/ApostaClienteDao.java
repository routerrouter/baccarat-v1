/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.dao;

import ao.co.proevolution.baccarat.util.IDao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.model.ApostaCliente;
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
public class ApostaClienteDao implements Serializable, IDao<ApostaCliente> {

    

    @Override
    public boolean save(ApostaCliente obj) {

        boolean flag = false;

        try {
            String sql = "INSERT INTO public.aposta_cliente(\"aposta_id\",\"clientes_id\")"
                    + "VALUES(?,?)";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, obj.getAposta().getId());
            ps.setLong(2, obj.getCliente().getId());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ApostaClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flag;
    }

    @Override
    public boolean update(ApostaCliente obj) {

        boolean flag = false;

        try {
            String sql = "UPDATE public.aposta_cliente SET \"clientes_id\"=?"
                    + " WHERE \"aposta_id\"=?";

            Connection con = new Conexao().ConexaoBD();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, obj.getCliente().getId());
            ps.setLong(2, obj.getAposta().getId());

            flag = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ApostaClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return flag;

    }

    @Override
    public boolean saveOrUpdate(ApostaCliente obj) {
        return  !update(obj) ? save(obj):true;
    }

    @Override
    public List<ApostaCliente> findAll() {

        
        return null;
    }

    @Override
    public boolean delete(Long id) {

        return false;

    }

}
