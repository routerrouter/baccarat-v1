/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import ao.co.proevolution.baccarat.bean.CorBean;
import ao.co.proevolution.baccarat.model.Cor;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author filme
 */
public class DefinirCorUtil {

    public void backGroundComponte(JComponent component) {
        Color color = Color.black;
        if (component != null) {

            try {
                CorBean corBean = new CorBean();
                Cor cor = corBean.findCorUse();
                System.out.println("cor >>> "+cor);
                if (cor != null) {

                    color = cor.getColor();

                } 

                component.setBackground(color);
            } catch (Exception ex) {
                Logger.getLogger(DefinirCorUtil.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
