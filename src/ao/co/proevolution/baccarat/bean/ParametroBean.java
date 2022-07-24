/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.bean;

import ao.co.proevolution.baccarat.dao.ParametroDao;
import ao.co.proevolution.baccarat.enumerador.ParametroDesignacao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.enumerador.TipoMensagem;
import ao.co.proevolution.baccarat.model.Parametro;
import ao.co.proevolution.baccarat.util.ComputerInfoUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filme
 */
public class ParametroBean {
    
    private ParametroDao dao;
    private Parametro model;
    
    public TipoMensagem saveOrUpdate() throws Exception {
        
        if (model != null) {
            
            if (!model.isEmpty()) {
                
                dao = new ParametroDao();
                
                if (dao.saveOrUpdate(model)) {
                    
                    return TipoMensagem.SUCESSO;
                }
                
                return TipoMensagem.ERRO_INESPERADO;
            }
            
            return TipoMensagem.EMPTY;
        }
        
        return TipoMensagem.NULL;
        
    }
    
    private List<ParametroDesignacao> getParametroDefault() {
        
        List<ParametroDesignacao> lista = new ArrayList();
        lista.add(ParametroDesignacao.MAXIMO_BANKER);
        lista.add(ParametroDesignacao.MAXIMO_EMPATE);
        lista.add(ParametroDesignacao.MAXIMO_NATURAIS);
        lista.add(ParametroDesignacao.MAXIMO_PARES);
        lista.add(ParametroDesignacao.MINIMO_BANKER);
        lista.add(ParametroDesignacao.MINIMO_EMPATE);
        lista.add(ParametroDesignacao.MINIMO_NATURAIS);
        lista.add(ParametroDesignacao.MINIMO_PARES);
        
        lista.add(ParametroDesignacao.VALOR_MAXIMO_APOSTA_POR_MESA);
        lista.add(ParametroDesignacao.VALOR_MINIMO_APOSTA_POR_MESA);
        
        lista.add(ParametroDesignacao.LOGO_TIPO);
        
        
        lista.add(ParametroDesignacao.INDEX_COLUMN_EMAIL_CLIENTE);
        lista.add(ParametroDesignacao.INDEX_COLUMN_ENDERECO_CLIENTE);
        lista.add(ParametroDesignacao.INDEX_COLUMN_NIF_CLIENTE);
        lista.add(ParametroDesignacao.INDEX_COLUMN_NOME_CLIENTE);
        lista.add(ParametroDesignacao.INDEX_COLUMN_TELEFONE_CLIENTE);
        
        lista.add(ParametroDesignacao.IMAGEM_BANKER);
        lista.add(ParametroDesignacao.IMAGEM_PLAYER);
        lista.add(ParametroDesignacao.IMAGEM_TIE);
        
        return lista;
        
    }
    
    public void saveDefault() throws Exception {
        
        boolean flag = true;
        List<ParametroDesignacao> lista = getParametroDefault();
        
        dao = new ParametroDao();
        
        List<Parametro> listaParametro = dao.findAll();
        
        if (listaParametro != null) {
            
            if (!listaParametro.isEmpty()) {
                
                flag = false;
            }
        }
        
        if (flag) {
            
            for (ParametroDesignacao p : lista) {
                
                try {
                    Parametro modelo = new Parametro();
                    modelo.setDesignacao(p);
                    
                    dao.save(modelo);
                } catch (Exception ex) {
                    Logger.getLogger(ParametroBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
        
    }
    
    public List<Parametro> findAll() throws Exception {
        
        dao = new ParametroDao();
        return dao.findAll();
        
    }
    
    public Parametro findByDesignacao(ParametroDesignacao designacao) throws Exception {
        
        dao = new ParametroDao();
        return dao.findByDesignacao(designacao);
        
    }
    
    public boolean update(ParametroDesignacao designacao, Double valor) throws Exception {
        
        Parametro modelo = findByDesignacao(designacao);
        
        if (modelo != null) {
            
            modelo.setValor(String.valueOf(valor));
            
            dao.saveOrUpdate(modelo);
            
        }
        
        return false;
        
    }
    
    public boolean update(ParametroDesignacao designacao, String valor) throws Exception {
        
        Parametro modelo = findByDesignacao(designacao);
        
        if (modelo != null) {
            
            modelo.setValor(valor);
            
            dao.update(modelo);
            
        }
        
        return false;
        
    }
    
    public TipoMensagem delete() throws Exception {
        
        if (model != null) {
            
            model.setStatus(Status.ELIMINADO);
            dao = new ParametroDao();
            
            if (dao.update(model)) {
                
                return TipoMensagem.SUCESSO;
            }
            
            return TipoMensagem.ERRO_INESPERADO;
        }
        
        return TipoMensagem.NULL;
        
    }
    
    public TipoMensagem desactivar() throws Exception {
        
        if (model != null) {
            
            model.setStatus(Status.DESACTIVADO);
            dao = new ParametroDao();
            
            if (dao.update(model)) {
                
                return TipoMensagem.SUCESSO;
            }
            
            return TipoMensagem.ERRO_INESPERADO;
        }
        
        return TipoMensagem.NULL;
        
    }
    
    public void print() {
        
    }
    
}
