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
public class HistoricoJogada {

    private Long id;
    private Status status = Status.ACTIVADO;

    private Aposta aposta;
    private String jogada;

    public Aposta getAposta() {
        return aposta;
    }

    public void setAposta(Aposta aposta) {
        this.aposta = aposta;
    }

    public String getJogada() {
        return jogada;
    }

    public void setJogada(String jogada) {
        this.jogada = jogada;
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
        return aposta == null || jogada == null;
    }
}
