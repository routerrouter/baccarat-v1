/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.model;

import ao.co.proevolution.baccarat.enumerador.Status;
import ao.co.proevolution.baccarat.enumerador.TipoMedia;

;

/**
 *
 * @author filme
 */
public class Media {

    private Long id;
    private Status status = Status.ACTIVADO;

    private TipoMedia tipo_media;
    private String name;
    private Integer duracao_segundo;

    public TipoMedia getTipo_media() {
        return tipo_media;
    }

    public void setTipo_media(TipoMedia tipo_media) {
        this.tipo_media = tipo_media;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuracao_segundo() {
        return duracao_segundo;
    }

    public void setDuracao_segundo(Integer duracao_segundo) {
        this.duracao_segundo = duracao_segundo;
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

        return name.trim().isEmpty() || duracao_segundo <= 0;

    }

    @Override
    public String toString() {
        return tipo_media.toString();
    }

}
