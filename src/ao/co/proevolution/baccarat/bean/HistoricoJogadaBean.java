/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.bean;

import ao.co.proevolution.baccarat.dao.HistoricoJogadaDao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.enumerador.TipoMensagem;
import ao.co.proevolution.baccarat.model.HistoricoJogada;
import ao.co.proevolution.baccarat.util.ComputerInfoUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filme
 */
public class HistoricoJogadaBean {

    private HistoricoJogadaDao dao;
    private HistoricoJogada model;

    public TipoMensagem saveOrUpdate() throws Exception {

        if (model != null) {

            if (!model.isEmpty()) {

                dao = new HistoricoJogadaDao();

                if (dao.saveOrUpdate(model)) {

                    return TipoMensagem.SUCESSO;
                }

                return TipoMensagem.ERRO_INESPERADO;
            }

            return TipoMensagem.EMPTY;
        }

        return TipoMensagem.NULL;

    }
   
    public List<HistoricoJogada> findAll() throws Exception{
        
        
        dao = new HistoricoJogadaDao();
        return dao.findAll();
        
    }
    
    public TipoMensagem delete() throws Exception{
        
        
        if(model != null){
            
            model.setStatus(Status.ELIMINADO);
            dao = new HistoricoJogadaDao();
            
            if(dao.update(model)){
                
                return TipoMensagem.SUCESSO;
            }
            
            return TipoMensagem.ERRO_INESPERADO;
        }
        
        return TipoMensagem.NULL;
        
    }
    public TipoMensagem desactivar() throws Exception{
        
        
        if(model != null){
            
            model.setStatus(Status.DESACTIVADO);
            dao = new HistoricoJogadaDao();
            
            if(dao.update(model)){
                
                return TipoMensagem.SUCESSO;
            }
            
            return TipoMensagem.ERRO_INESPERADO;
        }
        
        return TipoMensagem.NULL;
        
    }
    
    public void print(){
        
        
    }

}
