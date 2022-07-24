/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.bean;

import ao.co.proevolution.baccarat.dao.LogApostaOquestradorDao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.enumerador.TipoMensagem;
import ao.co.proevolution.baccarat.model.Aposta;
import ao.co.proevolution.baccarat.model.LogApostaOquestrador;
import ao.co.proevolution.baccarat.model.Mesa;
import ao.co.proevolution.baccarat.model.Oquestrador;
import ao.co.proevolution.baccarat.util.ComputerInfoUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filme
 */
public class LogApostaOquestradorBean {

    private LogApostaOquestradorDao dao;
    private LogApostaOquestrador model;

    public TipoMensagem saveOrUpdate() throws Exception {

        if (model != null) {

            if (!model.isEmpty()) {

                dao = new LogApostaOquestradorDao();

                if (dao.saveOrUpdate(model)) {

                    return TipoMensagem.SUCESSO;
                }

                return TipoMensagem.ERRO_INESPERADO;
            }

            return TipoMensagem.EMPTY;
        }

        return TipoMensagem.NULL;

    }

    public List<LogApostaOquestrador> findAll() throws Exception {

        dao = new LogApostaOquestradorDao();
        return dao.findAll();

    }

    public TipoMensagem delete() throws Exception {

        if (model != null) {

            model.setStatus(Status.ELIMINADO);
            dao = new LogApostaOquestradorDao();

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
            dao = new LogApostaOquestradorDao();

            if (dao.update(model)) {

                return TipoMensagem.SUCESSO;
            }

            return TipoMensagem.ERRO_INESPERADO;
        }

        return TipoMensagem.NULL;

    }
    
    public LogApostaOquestrador findByAposta(Aposta aposta) throws Exception{
        
        dao = new LogApostaOquestradorDao();
        return dao.findByApostaActivada(aposta);
        
    }
    public LogApostaOquestrador findByOquestrador(Oquestrador oquestrador,Mesa mesa) throws Exception{
        
        dao = new LogApostaOquestradorDao();
        return dao.findByOquestrador(oquestrador, mesa);
        
    }

    public void desactivar(Mesa mesa) throws Exception {

        dao = new LogApostaOquestradorDao();

        List<LogApostaOquestrador> lista = dao.findByStatus(Status.ACTIVADO, mesa);

        for (LogApostaOquestrador model : lista) {
            
            if (model != null) {

                model.setStatus(Status.DESACTIVADO);
                dao.update(model);

            }
        }

    }

    public void print() {

    }

    public LogApostaOquestrador getModel() {
        return model;
    }

    public void setModel(LogApostaOquestrador model) {
        this.model = model;
    }

}
