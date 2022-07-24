/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.bean;

import ao.co.proevolution.baccarat.dao.MesaDao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.enumerador.TipoMensagem;
import ao.co.proevolution.baccarat.model.Mesa;
import ao.co.proevolution.baccarat.util.ComputerInfoUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filme
 */
public class MesaBean {

    private MesaDao dao;
    private Mesa model;

    public TipoMensagem saveOrUpdate() throws Exception {

        if (model != null) {

            if (!model.isEmpty()) {

                dao = new MesaDao();

                if (dao.saveOrUpdate(model)) {

                    return TipoMensagem.SUCESSO;
                }

                return TipoMensagem.ERRO_INESPERADO;
            }

            return TipoMensagem.EMPTY;
        }

        return TipoMensagem.NULL;

    }
    public TipoMensagem definirMesa() throws Exception {

        if (model != null) {

            if (!model.isEmpty()) {

                model.setMac_add(ComputerInfoUtil.getMc());
                dao = new MesaDao();

                if (dao.saveOrUpdate(model)) {

                    return TipoMensagem.SUCESSO;
                }

                return TipoMensagem.ERRO_INESPERADO;
            }

            return TipoMensagem.EMPTY;
        }

        return TipoMensagem.NULL;

    }
    
    public Mesa identificarMesaMacAdd(){
        
        try {
            dao = new MesaDao();
            return dao.findByMacAdd(ComputerInfoUtil.getMc());
        } catch (Exception ex) {
            Logger.getLogger(MesaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public List<Mesa> findAll() throws Exception{
        
        
        dao = new MesaDao();
        return dao.findAll();
        
    }
    
    public TipoMensagem delete() throws Exception{
        
        
        if(model != null){
            
            model.setStatus(Status.ELIMINADO);
            dao = new MesaDao();
            
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
            dao = new MesaDao();
            
            if(dao.update(model)){
                
                return TipoMensagem.SUCESSO;
            }
            
            return TipoMensagem.ERRO_INESPERADO;
        }
        
        return TipoMensagem.NULL;
        
    }
    
    public void print(){
        
        
    }

    public MesaDao getDao() {
        return dao;
    }

    public void setDao(MesaDao dao) {
        this.dao = dao;
    }

    public Mesa getModel() {
        return model;
    }

    public void setModel(Mesa model) {
        this.model = model;
    }

}
