/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.bean;

import ao.co.proevolution.baccarat.dao.MediaDao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.enumerador.TipoMedia;
import ao.co.proevolution.baccarat.enumerador.TipoMensagem;
import ao.co.proevolution.baccarat.model.Media;
import ao.co.proevolution.baccarat.util.ComputerInfoUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filme
 */
public class MediaBean {

    private MediaDao dao;
    private Media model;

    public TipoMensagem saveOrUpdate() throws Exception {

        if (model != null) {

            if (!model.isEmpty()) {

                dao = new MediaDao();

                if (dao.saveOrUpdate(model)) {

                    return TipoMensagem.SUCESSO;
                }

                return TipoMensagem.ERRO_INESPERADO;
            }

            return TipoMensagem.EMPTY;
        }

        return TipoMensagem.NULL;

    }
    
    public List<Media> findAll() throws Exception{
        
        
        dao = new MediaDao();
        return dao.findAll();
        
    }
    
    public TipoMensagem delete() throws Exception{
        
        
        if(model != null){
            
            model.setStatus(Status.ELIMINADO);
            dao = new MediaDao();
            
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
            dao = new MediaDao();
            
            if(dao.update(model)){
                
                return TipoMensagem.SUCESSO;
            }
            
            return TipoMensagem.ERRO_INESPERADO;
        }
        
        return TipoMensagem.NULL;
        
    }
    
    public List<Media> findByTipoMedia(TipoMedia tipoMedia) throws Exception{
        
        dao = new MediaDao();
        return dao.findByTipoMedia(tipoMedia);
        
    }
    
    public void print(){
        
        
    }

    public MediaDao getDao() {
        return dao;
    }

    public void setDao(MediaDao dao) {
        this.dao = dao;
    }

    public Media getModel() {
        return model;
    }

    public void setModel(Media model) {
        this.model = model;
    }

}
