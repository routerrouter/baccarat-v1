/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.bean;

import ao.co.proevolution.baccarat.dao.CorDao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.enumerador.TipoMensagem;
import ao.co.proevolution.baccarat.model.Cor;
import ao.co.proevolution.baccarat.util.ComputerInfoUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filme
 */
public class CorBean {

    private CorDao dao;
    private Cor model;

    public TipoMensagem saveOrUpdate() throws Exception {

        if (model != null) {

            if (!model.isEmpty()) {

                dao = new CorDao();

                if (dao.saveOrUpdate(model)) {

                    return TipoMensagem.SUCESSO;
                }

                return TipoMensagem.ERRO_INESPERADO;
            }

            return TipoMensagem.EMPTY;
        }

        return TipoMensagem.NULL;

    }

    public List<Cor> findAll() throws Exception {

        dao = new CorDao();
        return dao.findAll();

    }

    public Cor findCorUse() throws Exception {

        dao = new CorDao();
        return dao.findByIsUse();

    }

    public void definirCorUsar(Cor model) throws Exception {

        dao = new CorDao();

        model.setIsUse(true);

        Cor usadaAnterior = findCorUse();
        if (usadaAnterior != null) {
            usadaAnterior.setIsUse(false);

            dao.update(usadaAnterior);
        }
        dao.update(model);
    }

    public TipoMensagem delete() throws Exception {

        if (model != null) {

            model.setStatus(Status.ELIMINADO);
            dao = new CorDao();

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
            dao = new CorDao();

            if (dao.update(model)) {

                return TipoMensagem.SUCESSO;
            }

            return TipoMensagem.ERRO_INESPERADO;
        }

        return TipoMensagem.NULL;

    }

    public void print() {

    }

    public Cor getModel() {
        return model;
    }

    public void setModel(Cor model) {
        this.model = model;
    }

}
