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
public enum Jogada {
    
    
    B ("Banker"),P("Player"),T("Tie");
    
    private String designacao;

    private Jogada(String designacao) {
        this.designacao = designacao;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    @Override
    public String toString() {
        return designacao ;
    }
    
    
    
    
}
