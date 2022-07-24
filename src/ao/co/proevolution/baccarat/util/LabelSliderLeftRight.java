 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author filme
 */
public class LabelSliderLeftRight implements Runnable{

    private boolean isLeftRight = true;
    private double pontoX = 0;
    private double salto = 0;
    private JPanel panel;
    private JLabel lbl;
    double larguraJanela = 0;

    public LabelSliderLeftRight(JPanel panel,double larguraJanela, double salto)  {

        this.panel = panel;

        this.lbl = (JLabel) panel.getComponent(0);

        this.salto = salto;
        this.larguraJanela = larguraJanela - lbl.getPreferredSize().width;


    }
    

    public LabelSliderLeftRight(JPanel panel, double salto) throws Exception {

        this.panel = panel;

        this.lbl = (JLabel) panel.getComponent(0);

        this.salto = salto;

        larguraJanela = panel.getPreferredSize().getWidth();

        leftRight();

    }

    private void leftRight() throws Exception {

        Point lblPoint = new Point(0, 0);

        Timer tm = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                if (isLeftRight) {
                    pontoX += salto;
                    isLeftRight = pontoX < larguraJanela+264;
                } else {
                    pontoX =-164;
                    isLeftRight = true;
                }

              

                lbl.setLocation((int) pontoX, (int) lblPoint.getY());

            }
        });
        tm.start();

    }

    @Override
    public void run() {
        try {
            leftRight();
        } catch (Exception ex) {
            Logger.getLogger(LabelSliderLeftRight.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
