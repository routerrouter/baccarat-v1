/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baccarat.ui;

import ao.co.proevolution.baccarat.bean.MediaBean;
import ao.co.proevolution.baccarat.bean.ParametroBean;
import ao.co.proevolution.baccarat.enumerador.ParametroDesignacao;
import ao.co.proevolution.baccarat.enumerador.TipoMedia;
import ao.co.proevolution.baccarat.model.Media;
import ao.co.proevolution.baccarat.model.Parametro;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
//import net.sourceforge.barbecue.Main;
import ao.co.proevolution.baccarat.util.Mp4PlayerUtil;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author filme
 */
public class ImageAnimationView extends javax.swing.JPanel implements ActionListener {

    ImageIcon images[];
    int totalImages, totalVideo, currentImage = 0;
    private int animationDelay = 1000;
    Timer animationTimer;

    File[] file_imgs = null;
    File[] file_video = null;

    int count_img = 0;
    int count_video = 0;
    int count = 0;
    Media media = null;
    int currentVideo = 0;

    private MediaBean mediaBean;
    Mp4PlayerUtil mp4PlayerUtil;

    private final String PATH_VIDEO = "video/";
    private List<MediaImg> listaImage;
    List<Media> listaVideo;

    JPanel panelVideo;

    private class MediaImg {

        private final String PATH_IMG = "imagem/slide/";

        ImageIcon img;
        int delay;

        public MediaImg(String name, int delay) {

            File file = new File(PATH_IMG + name);

            this.img = new ImageIcon(file.getAbsolutePath());
            this.delay = delay;
        }

        public ImageIcon getImg() {
            return img;
        }

        public int getDelay() {
            return delay;
        }

    }

    public static void addImage(JButton lbl, String name) throws Exception {

        File file = new File("imagem\\btn_jogada\\" + name);

        ImageIcon img = new ImageIcon(file.getAbsolutePath());

        lbl.setIcon(img);

    }

    public static boolean addImage(JButton lbl, ParametroDesignacao parametro) {

        try {
            String name = getValor(parametro);
            if (name != null) {

                if (!name.trim().equals("0")) {
                    File file = new File("imagem\\btn_jogada\\" + name);

                    ImageIcon img = new ImageIcon(file.getAbsolutePath());
                    System.out.println("IMG >>> " + img);
                    lbl.setIcon(img);
                    return true;
                }
            }
        } catch (Exception ex) {

        }
        return false;
    }
    public static boolean addImage(JLabel lbl, ParametroDesignacao parametro) {

        try {
            String name = getValor(parametro);
            if (name != null) {

                if (!name.trim().equals("0")) {
                    File file = new File("imagem\\btn_jogada\\" + name);

                    ImageIcon img = new ImageIcon(file.getAbsolutePath());
                    System.out.println("IMG >>> " + img);
                    lbl.setIcon(img);
                    return true;
                }
            }
        } catch (Exception ex) {

        }
        return false;
    }

    static String getValor(ParametroDesignacao designacao) throws Exception {

        ParametroBean parametroBean = new ParametroBean();
        Parametro p = parametroBean.findByDesignacao(designacao);

        if (p != null) {

            return p.getValor();
        }
        return null;
    }

    boolean flag = true;

    public ImageAnimationView() {
        initComponents();
        montarImg();
        montarVideo();
        startAnimation();
    }

    private void montarImg() {

        try {
            mediaBean = new MediaBean();
            List<Media> lista = mediaBean.findByTipoMedia(TipoMedia.IMAGEM);
            listaImage = new ArrayList();
            for (int i = 0; i < lista.size(); i++) {
                Media media = lista.get(i);
                listaImage.add(new MediaImg(media.getName(), media.getDuracao_segundo()));
            }
            totalImages = lista.size();

        } catch (Exception ex) {
            Logger.getLogger(ImageAnimationView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void montarVideo() {

        try {

            mediaBean = new MediaBean();
            listaVideo = mediaBean.findByTipoMedia(TipoMedia.VIDEO);
            if (listaVideo == null) {
                listaVideo = new ArrayList();
            }

        } catch (Exception ex) {
            Logger.getLogger(ImageAnimationView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        MediaImg mediaImg = null;
        ImageIcon img = null;

        if (!listaImage.isEmpty()) {

            mediaImg = listaImage.get(currentImage);
            img = mediaImg.getImg();

            if (img.getImageLoadStatus() == MediaTracker.COMPLETE) {

                img.paintIcon(this, g, 0, 0);
                if (count_img >= mediaImg.delay) {
                    currentImage = (currentImage + 1) % totalImages;
                    count_img = 0;
                    count++;
                }
                count_img++;

            }
        }

//        if (count < totalImages ) {
//        } else if (listaVideo != null) {
//
//            if (!listaVideo.isEmpty()) {
//
//                if (flag) {
//                    media = listaVideo.get(currentVideo);
//                }
//
//                if (count - 1 == listaImage.size()) {
//
//                    //  home_game_video.panelMedia.removeAll();
//                    // panelVideo = new JPanel(new BorderLayout());
//                    // this.add(panelVideo);
//                }
//
//                if (count_video == media.getDuracao_segundo() || currentVideo == 0) {
//                    mp4PlayerUtil = new Mp4PlayerUtil(home_game_video.panelMedia, PATH_VIDEO + media.getName());
//                    // panelVideo.removeAll();
//                    // panelVideo = new JPanel(new BorderLayout());
//                    System.out.println("entrei no video >>> " + count_video);
//                    count_video = 0;
//                    currentVideo++;
//                    flag = false;
//
//                }
//                count_video++;
//
//            }
//
//        }
//
//        if (count >= listaImage.size() && count >= listaVideo.size()) {
//
//            count_img = 0;
//            count_video = 0;
//
//        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void startAnimation() {
        if (animationTimer == null) {
            currentImage = 0;
            animationTimer = new Timer(animationDelay, this);
            animationTimer.start();
        } else if (!animationTimer.isRunning()) {
            animationTimer.restart();
        }
    }

    public void stopAnimation() {
        animationTimer.stop();
    }

    public static void main(String args[]) {
        ImageAnimationView anim = new ImageAnimationView();
        JFrame app = new JFrame("Animator test");
        app.add(anim, BorderLayout.CENTER);
        app.setSize(300, 300);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(anim.getPreferredSize().width + 10, anim.getPreferredSize().height + 30);
        app.setVisible(true);
    }

    /**
     * Creates new form ImageAnimationView
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
