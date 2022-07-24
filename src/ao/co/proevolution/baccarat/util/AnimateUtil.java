/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author filme
 */
public class AnimateUtil extends javax.swing.JApplet implements Runnable {

    File[] animação = null;
    int atual = 0;
    Thread corredor = null;
    JFrame jPanel;

    public void start() {
        if (corredor == null) {
            corredor = new Thread(this);
            corredor.start();
        }
    }
    
  
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
