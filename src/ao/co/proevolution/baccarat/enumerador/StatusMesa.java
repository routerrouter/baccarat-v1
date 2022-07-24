/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.enumerador;

/**
 *
 * @author filme
 */
public enum StatusMesa {
    
    OFFLINE(1),
    ONLINE(0),
    PAUSA_TROCA_OQUESTRADOR(2)  ;
    
    
    private int cod;

    private StatusMesa(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    
    
    
    
}
