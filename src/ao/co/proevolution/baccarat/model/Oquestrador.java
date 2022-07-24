/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.model;

import ao.co.proevolution.baccarat.enumerador.Status;
import java.util.Date;

/**
 *
 * @author filme
 */
public class Oquestrador  {

    private Long id;
    private String password;
    private Date data_ultima_check= new Date();

   
    private boolean isLogado = false;
    private String nome;
    private String user_name;
    private Status status = Status.ACTIVADO;

    public Oquestrador() {
    }

    public Oquestrador(Long id) {
        this.id = id;
    }
     public Oquestrador(Long id, String password, Date data_ultima_check, String nome, String user_name) {
        this.id = id;
        this.password = password;
        this.data_ultima_check = data_ultima_check;
        this.nome = nome;
        this.user_name = user_name;
    }

    public Oquestrador(Long id, Date dataCheck) {
        this.id = id;
        this.data_ultima_check = dataCheck;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsLogado() {
        return isLogado;
    }

    public void setIsLogado(boolean isLogado) {
        this.isLogado = isLogado;
    }

    public Date getData_ultima_check() {
        return data_ultima_check;
    }

    public void setData_ultima_check(Date data_ultima_check) {
        this.data_ultima_check = data_ultima_check;
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

        return nome.trim().isEmpty() || user_name.trim().isEmpty() || password.trim().isEmpty();

    }

    @Override
    public String toString() {
        return nome;
    }

}
