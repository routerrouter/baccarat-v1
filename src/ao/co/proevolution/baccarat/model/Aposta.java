/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.model;

import ao.co.proevolution.baccarat.enumerador.Status;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author filme
 */

public class Aposta  implements Serializable{
    
   private Long id;
   
    private Mesa mesa;
   
    private Double valor_minimo_aposta =0.0;

    private Double valor_maximo_aposta=0.0;
    
    private String jogadas="";
private Status status = Status.ACTIVADO;

    public Aposta(Long id) {
        this.id = id;
    }

    public Aposta() {
    }
    
    
    private List<Cliente> clientes = new ArrayList();

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Double getValor_minimo_aposta() {
        return valor_minimo_aposta;
    }

    public void setValor_minimo_aposta(Double valor_minimo_aposta) {
        this.valor_minimo_aposta = valor_minimo_aposta;
    }

    public Double getValor_maximo_aposta() {
        return valor_maximo_aposta;
    }

    public void setValor_maximo_aposta(Double valor_maximo_aposta) {
        this.valor_maximo_aposta = valor_maximo_aposta;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getJogadas() {
        return jogadas;
    }

    public void setJogadas(String jogadas) {
        this.jogadas = jogadas;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    public boolean isEmpty(){
        
        
        return mesa == null || valor_maximo_aposta == 0 || valor_minimo_aposta == 0;
        
    }
    
    
    
    
}
