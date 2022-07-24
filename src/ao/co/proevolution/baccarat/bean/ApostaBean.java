/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.bean;

import ao.co.proevolution.baccarat.dao.ApostaDao;
import ao.co.proevolution.baccarat.enumerador.ParametroDesignacao;
import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.enumerador.StatusMesa;
import ao.co.proevolution.baccarat.enumerador.TipoMensagem;
import ao.co.proevolution.baccarat.model.Aposta;
import ao.co.proevolution.baccarat.model.Cliente;
import ao.co.proevolution.baccarat.model.Parametro;
import ao.co.proevolution.baccarat.util.ComputerInfoUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filme
 */
public class ApostaBean {

    private ApostaDao dao;
    private Aposta model;

    public TipoMensagem saveOrUpdate() throws Exception {

        if (model != null) {

            if (!model.isEmpty()) {

                dao = new ApostaDao();

                if (dao.saveOrUpdate(model)) {

                    return TipoMensagem.SUCESSO;
                }

                return TipoMensagem.ERRO_INESPERADO;
            }

            return TipoMensagem.EMPTY;
        }

        return TipoMensagem.NULL;

    }

    private void terminaAnterior() {

        try {
            dao = new ApostaDao();
            Aposta apostaAnterior = dao.findByMesa(this.model.getMesa(), Status.ACTIVADO);
            if (apostaAnterior != null) {
                apostaAnterior.setStatus(Status.TERMINADO);
                dao.update(apostaAnterior);
            }
        } catch (Exception ex) {
//            Logger.getLogger(ApostaBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void terminaActual() throws Exception {

        dao = new ApostaDao();
        dao.saveOrUpdate(model);

    }

    public void nova() throws Exception {

        ParametroBean parametroBean = new ParametroBean();
        Parametro p_maximo_valor = parametroBean.findByDesignacao(ParametroDesignacao.VALOR_MAXIMO_APOSTA_POR_MESA);
        Parametro p_minimo_valor = parametroBean.findByDesignacao(ParametroDesignacao.VALOR_MINIMO_APOSTA_POR_MESA);

        MesaBean mesaBean = new MesaBean();

        model = new Aposta();

        model.setMesa(mesaBean.identificarMesaMacAdd());
        model.setValor_maximo_aposta(Double.parseDouble(p_maximo_valor.getValor()));
        model.setValor_minimo_aposta(Double.parseDouble(p_minimo_valor.getValor()));

        if (model.getMesa() != null) {

            model.setStatus(Status.ACTIVADO);

            this.terminaAnterior();

            model.getMesa().setStatus_mesa(StatusMesa.ONLINE);

            if (dao.save(model)) {

                mesaBean.setModel(model.getMesa());
                mesaBean.saveOrUpdate();

                model = dao.findByMesa(model.getMesa(), Status.ACTIVADO);

            }
        }

    }

    public TipoMensagem addApostador(Cliente cliente) throws Exception {

        if (cliente != null) {

            if (cliente.getId() == null) {

                ClienteBean clienteBean = new ClienteBean();
                clienteBean.setModel(cliente);
                clienteBean.saveOrUpdate();

            }

            model.getClientes().add(cliente);

            dao = new ApostaDao();

            if (dao.saveOrUpdate(model)) {

                return TipoMensagem.SUCESSO;

            }

            return TipoMensagem.ERRO_INESPERADO;
        }

        return TipoMensagem.NULL;

    }

    public List<Aposta> findAll() throws Exception {

        dao = new ApostaDao();
        return dao.findAll();

    }

    public TipoMensagem delete() throws Exception {

        if (model != null) {

            model.setStatus(Status.ELIMINADO);
            dao = new ApostaDao();

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
            dao = new ApostaDao();

            if (dao.update(model)) {

                return TipoMensagem.SUCESSO;
            }

            return TipoMensagem.ERRO_INESPERADO;
        }

        return TipoMensagem.NULL;

    }

    public void print() {

    }

    public Aposta getModel() {
        return model;
    }

    public void setModel(Aposta model) {
        this.model = model;
    }

}
