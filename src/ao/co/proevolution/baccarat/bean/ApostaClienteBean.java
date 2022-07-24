/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.bean;

import ao.co.proevolution.baccarat.dao.ApostaClienteDao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.enumerador.TipoMensagem;
import ao.co.proevolution.baccarat.model.ApostaCliente;
import ao.co.proevolution.baccarat.util.ComputerInfoUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filme
 */
public class ApostaClienteBean {

    private ApostaClienteDao dao;
    private ApostaCliente model;

    public TipoMensagem saveOrUpdate() throws Exception {

        if (model != null) {

            if (!model.isEmpty()) {

                dao = new ApostaClienteDao();

                if (dao.saveOrUpdate(model)) {

                    return TipoMensagem.SUCESSO;
                }

                return TipoMensagem.ERRO_INESPERADO;
            }

            return TipoMensagem.EMPTY;
        }

        return TipoMensagem.NULL;

    }
   
    public List<ApostaCliente> findAll() throws Exception{
        
        
        dao = new ApostaClienteDao();
        return dao.findAll();
        
    }
    
   
    
   
    
    public void print(){
        
        
    }

    public ApostaCliente getModel() {
        return model;
    }

    public void setModel(ApostaCliente model) {
        this.model = model;
    }

}
