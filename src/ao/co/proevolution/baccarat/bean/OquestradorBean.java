/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.bean;

import ao.co.proevolution.baccarat.dao.OquestradorDao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.enumerador.TipoMensagem;
import ao.co.proevolution.baccarat.model.Oquestrador;
import java.util.List;

/**
 *
 * @author filme
 */
public class OquestradorBean {

    private OquestradorDao dao;
    private Oquestrador model;

    public TipoMensagem saveOrUpdate() throws Exception {

        if (model != null) {

            if (!model.isEmpty()) {

                dao = new OquestradorDao();
                
              //  model.setPassword(Security.encode1(model.getPassword()));

                if (dao.saveOrUpdate(model)) {

                    return TipoMensagem.SUCESSO;
                }

                return TipoMensagem.ERRO_INESPERADO;
            }

            return TipoMensagem.EMPTY;
        }

        return TipoMensagem.NULL;

    }
   
    public List<Oquestrador> findAll() throws Exception{
        
        
        dao = new OquestradorDao();
        return dao.findAll();
        
    }
    
    public TipoMensagem delete() throws Exception{
        
        
        if(model != null){
            
            model.setStatus(Status.ELIMINADO);
            dao = new OquestradorDao();
            
            if(dao.update(model)){
                
                return TipoMensagem.SUCESSO;
            }
            
            return TipoMensagem.ERRO_INESPERADO;
        }
        
        return TipoMensagem.NULL;
        
    }
    public Oquestrador findByUsuarioSenha(String usuario,String senha){
        System.out.println("senha >>> "+senha);
        dao = new OquestradorDao();
        return dao.findByUsuarioAndSenha(usuario,senha);
        
    }
    public TipoMensagem desactivar() throws Exception{
        
        
        if(model != null){
            
            model.setStatus(Status.DESACTIVADO);
            dao = new OquestradorDao();
            
            if(dao.update(model)){
                
                return TipoMensagem.SUCESSO;
            }
            
            return TipoMensagem.ERRO_INESPERADO;
        }
        
        return TipoMensagem.NULL;
        
    }
    
    public void print(){
        
        
    }

    public Oquestrador getModel() {
        return model;
    }

    public void setModel(Oquestrador model) {
        this.model = model;
    }

}
