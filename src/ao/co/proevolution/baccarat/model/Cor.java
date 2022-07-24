/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.model;

import ao.co.proevolution.baccarat.enumerador.Status;
import java.awt.Color;

/**
 *
 * @author filme
 */
public class Cor {

    private Long id;
    private String designacao;
    private Status status = Status.ACTIVADO;
    private Color color;

    private boolean isUse = false;

    public boolean isIsUse() {
        return isUse;
    }

    public void setIsUse(boolean isUse) {
        this.isUse = isUse;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
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

    @Override
    public String toString() {
        return designacao;
    }

    public boolean isEmpty() {

        return designacao.trim().isEmpty() || color == null;
    }

}
