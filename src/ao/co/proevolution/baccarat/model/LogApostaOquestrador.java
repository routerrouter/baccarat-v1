/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.model;

import ao.co.proevolution.baccarat.enumerador.Status;

/**
 *
 * @author filme
 */
public class LogApostaOquestrador {

    private Long id;
    private Status status = Status.ACTIVADO;
    private Aposta aposta;

    private Oquestrador oquestrador;

    public Aposta getAposta() {
        return aposta;
    }

    public void setAposta(Aposta aposta) {
        this.aposta = aposta;
    }

    public Oquestrador getOquestrador() {
        return oquestrador;
    }

    public void setOquestrador(Oquestrador oquestrador) {
        this.oquestrador = oquestrador;
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

    public boolean isEmpty() {

        return aposta == null || oquestrador == null;
    }

}
