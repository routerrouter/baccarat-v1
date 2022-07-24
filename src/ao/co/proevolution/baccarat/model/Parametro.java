/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.model;

import ao.co.proevolution.baccarat.enumerador.ParametroDesignacao;
import ao.co.proevolution.baccarat.enumerador.Status;

/**
 *
 * @author filme
 */

public class Parametro  {
    
    private Long id;
    private Status status = Status.ACTIVADO;
  
    private ParametroDesignacao designacao;
    private String valor = "0";
    private String descricao="sem informação";

    public ParametroDesignacao getDesignacao() {
        return designacao;
    }

    public void setDesignacao(ParametroDesignacao designacao) {
        this.designacao = designacao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isEmpty() {
       return designacao == null || valor == null;
    }
    
    
}
