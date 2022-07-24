/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author filme
 */
public class Mp4PlayerUtil {

    private JPanel panel;
    private JFrame windows;

    private int width = 400;
    private int height = 400;

    private String pathVideo;

    public Mp4PlayerUtil(int width, int height, JPanel panel) {

        this.width = width;
        this.height = height;
        this.panel = panel;

        // this.panel.setLayout(new BorderLayout());
    }

    public Mp4PlayerUtil(JPanel panel, String pathVideo) {

        this.pathVideo = pathVideo;
        this.panel = panel;

    }

    public void autoPlay() {

        Canvas c = new Canvas();
        c.setBackground(Color.black);

        File vlcInstallPath = new File("C:\\Program Files\\VideoLAN\\VLC");

        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), vlcInstallPath.getAbsolutePath());
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        MediaPlayerFactory mpf = new MediaPlayerFactory();

        EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        mediaPlayerComponent.add(c);
//        EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer();
        EmbeddedMediaPlayer emp = mediaPlayerComponent.getMediaPlayer();

        emp.setVideoSurface(mpf.newVideoSurface(c));

        emp.toggleFullScreen();

        emp.setEnableMouseInputHandling(false);

        emp.setEnableKeyInputHandling(false);

        String file = pathVideo;

        emp.prepareMedia(file);
        emp.setEnableKeyInputHandling(false);
        emp.setEnableMouseInputHandling(false);

        panel.add(mediaPlayerComponent);

        emp.play();

    }

    public void attachMediaPanel() {
        // MEDIA COMPONENT
        JPanel mediaPanel = new JPanel(new BorderLayout());
        JPanel progress = new JPanel(new BorderLayout());

        JButton playButton = new JButton();

        EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        EmbeddedMediaPlayer video = mediaPlayerComponent.getMediaPlayer();
        video.addMediaPlayerEventListener(
                new MediaPlayerEventAdapter() {
            @Override
            public void finished(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer) {

                playButton.setText("Play");
            }
        });

        JPanel progressPane = new JPanel(new BorderLayout());
        JLabel timeLbl1 = new JLabel("00:00");
        JLabel timeLbl2 = new JLabel("00:00");
        progressPane.add(timeLbl1, BorderLayout.WEST);
        progressPane.add(progress, BorderLayout.CENTER);
        progressPane.add(timeLbl2, BorderLayout.EAST);

        mediaPanel.add(mediaPlayerComponent, BorderLayout.CENTER);
        mediaPanel.add(progressPane, BorderLayout.SOUTH);

    }

}
