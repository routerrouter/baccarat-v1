/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author filme
 */
public class ImagemUtil {

    JPanel panel;
    private JLabel lbSlide;
    private int x = 0;

    private final String PATH_FOLDER = "imagem/slide";

    public ImagemUtil(JPanel panel) {

        lbSlide = new JLabel();

        Timer tm = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                slider(lbSlide);
            }
        });
        tm.start();

    }
    public ImagemUtil(JLabel lbSlide1) {

        this.lbSlide = lbSlide1;

        Timer tm = new Timer(900, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                slider(lbSlide);
            }
        });
        tm.start();

    }

    private void slider(JLabel lbSlide) {

        File[] ficheiros = getFicheiro();
        for (File f : ficheiros) {

           
            ImageIcon icon = new ImageIcon(f.getAbsolutePath());

            if (icon != null) {
                Image image = icon.getImage().getScaledInstance(lbSlide.getWidth(), lbSlide.getHeight(), Image.SCALE_SMOOTH);
                lbSlide.setIcon(new ImageIcon(image));
                x += 1;
                if (x >= ficheiros.length) {
                    x = 0;
                }

            }

        }
    }

    private File[] getFicheiro() {

        File folder = new File(PATH_FOLDER);
        return folder.listFiles();

    }

}
