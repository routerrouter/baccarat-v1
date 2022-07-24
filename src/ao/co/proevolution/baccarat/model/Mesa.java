/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.model;

import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.enumerador.StatusMesa;

/**
 *
 * @author filme
 */
public class Mesa {

    private Long id;
    private Status status = Status.ACTIVADO;
    private String designacao;

    public Mesa() {
    }

    public Mesa(Long id, String designacao) {
        this.id = id;
        this.designacao = designacao;
    }

    private StatusMesa status_mesa = StatusMesa.OFFLINE;

    private String ip;

    private String mac_add;

    public StatusMesa getStatus_mesa() {
        return status_mesa;
    }

    public void setStatus_mesa(StatusMesa status_mesa) {
        this.status_mesa = status_mesa;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac_add() {
        return mac_add;
    }

    public void setMac_add(String mac_add) {
        this.mac_add = mac_add;
    }

    public String getDesignacao() {
        return designacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    @Override
    public String toString() {
        return designacao;
    }

    public boolean isEmpty() {
        return designacao.trim().isEmpty();
    }
}
