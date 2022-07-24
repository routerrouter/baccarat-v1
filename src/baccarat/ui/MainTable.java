/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package baccarat.ui;

import ao.co.proevolution.baccarat.bean.ApostaBean;
import ao.co.proevolution.baccarat.bean.LogApostaOquestradorBean;
import ao.co.proevolution.baccarat.model.Aposta;
import ao.co.proevolution.baccarat.model.LogApostaOquestrador;
import ao.co.proevolution.baccarat.util.ImagemUtil;
import ao.co.proevolution.baccarat.util.LabelSliderLeftRight;
import ao.co.proevolution.baccarat.util.PanelMangerUtil;
import baccarat.commons.Constants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * @author rufino.domingos
 */
public class MainTable extends javax.swing.JFrame {

    /**
     * Creates new form mainTable
     */
    private JPanel panelPrincipal;
    private JPanel panelPrincipal2;
    private JPanel painelGame3;

    private int qtButtonPanel1 = 0;
    private int qtButtonPanel1_2 = 0;
    private int qtButtonPanel2_2 = 0;
    private int qtButtonPanel3_2 = 0;
    private int qtButtonPanel2 = 0;
    private int jpainel1Width = 0;
    private int jpainel1Heigth = 0;

    private Point point = new Point();

    final int banker = 1;
    final int player = 2;
    final int tie = 3;

    //PARES
    final int p_pair = 1;
    final int b_pair = 2;
    final int natural = 4;
    int flag_par = 0;

    int b_count = 0;
    int p_count = 0;
    int t_count = 0;
    int total_count = 0;
    int natural_count = 0;
    int tie_count = 0;
    int pp_count = 0;
    int bp_count = 0;
    boolean a = false;

    int jogadaVez = banker;
//BANKER

    ImageIcon iconBanker = new ImageIcon(getClass().getResource("banker.png"));
    ImageIcon iconParePlayer_banker = new ImageIcon(getClass().getResource("pp_banker.png"));
    ImageIcon iconPareBanker_banker = new ImageIcon(getClass().getResource("bp_banker.png"));
    ImageIcon iconNatural_banker = new ImageIcon(getClass().getResource("natural_banker.png"));
    ImageIcon icon2Pares_banker = new ImageIcon(getClass().getResource("bp_pp_banker.png"));
    ImageIcon icon2ParesNatural_banker = new ImageIcon(getClass().getResource("bp_pp_natural_banker.png"));
    ImageIcon iconNaturalParesPlayer_banker = new ImageIcon(getClass().getResource("natural_pp_banker.png"));
    ImageIcon iconNaturalParesBanker_banker = new ImageIcon(getClass().getResource("natural_bp_banker.png"));
//    ImageIcon iconParesPlayerNatural_banker = new ImageIcon(getClass().getResource("bp_pp_banker.png"));
//    ImageIcon iconParesBankerNatural_banker = new ImageIcon(getClass().getResource("bp_pp_banker.png"));

    // PLAYER JOGADA
    ImageIcon iconPlayer = new ImageIcon(getClass().getResource("player.png"));
    ImageIcon iconParePlayer_player = new ImageIcon(getClass().getResource("pp_player.png"));
    ImageIcon iconPareBanker_player = new ImageIcon(getClass().getResource("bp_player.png"));
    ImageIcon iconNatural_player = new ImageIcon(getClass().getResource("natural_player.png"));
    ImageIcon icon2Pares_player = new ImageIcon(getClass().getResource("p_pair_b_pair_player.png"));
    ImageIcon icon2ParesNatural_player = new ImageIcon(getClass().getResource("b_pair_p_pair_natural_player.png"));
    ImageIcon iconNaturalParesPlayer_player = new ImageIcon(getClass().getResource("natural_player_ponto.png"));
    ImageIcon iconNaturalParesBanker_player = new ImageIcon(getClass().getResource("natural_bp_player.png"));
    // PLAYER JOGADA VIEW
    ImageIcon iconPlayerView = new ImageIcon(getClass().getResource("player2_.png"));
    ImageIcon iconPP_BB = new ImageIcon(getClass().getResource("pp_bb.png"));
    ImageIcon iconPP_player = new ImageIcon(getClass().getResource("pp_player2_.png"));
    ImageIcon iconBP_player = new ImageIcon(getClass().getResource("bp_player2_.png"));

    ImageIcon iconBankerView = new ImageIcon(getClass().getResource("banker2_.png"));
    ImageIcon iconTieView = new ImageIcon(getClass().getResource("tie2_.png"));

    // TIE
    ImageIcon iconTie = new ImageIcon(getClass().getResource("tie.png"));
    ImageIcon iconParePlayer_tie = new ImageIcon(getClass().getResource("p_pair_tie.png"));
    ImageIcon iconPareBanker_tie = new ImageIcon(getClass().getResource("b_pair_tie.png"));
    ImageIcon iconNatural_tie = new ImageIcon(getClass().getResource("natural_tie.png"));
    ImageIcon icon2Pares_tie = new ImageIcon(getClass().getResource("p_pair_b_pair_tie.png"));
    ImageIcon icon2ParesNatural_tie = new ImageIcon(getClass().getResource("pp_bp_natural_tie.png"));
    ImageIcon iconNaturalParesPlayer_tie = new ImageIcon(getClass().getResource("p_pair_natural_tie.png"));
    ImageIcon iconNaturalParesBanker_tie = new ImageIcon(getClass().getResource("b_pair_natural_tie.png"));

//    ImageIcon iconParePlayer_banker = new ImageIcon(getClass().getResource("bp_banker.png"));
    ImageIcon lastIcon = new ImageIcon();

    /*
     Adicionar aqui os Icons
     */
    JPanel painel_principal = new JPanel(new GridLayout(6, 40, 0, 0));
    JPanel[][] btn_principal;// Número de botões na area bead_road
    JPanel[][] btn_painelJogo3;// Número de botões na area bead_road
    JPanel[][] btn_painel_1_2;
    JPanel[][] btn_painel_2_2;
    JPanel[][] btn_painel_3_2;
    JPanel a2_ = new JPanel(new GridLayout(5, 1, 0, 0));
    JScrollPane scroll;
    JPanel p = new JPanel(new GridLayout(3, 1, 0, 0));
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel painel_secundario = new JPanel(new GridLayout(6, 43, 0, 0));
    
    LabelA2[] lbA2_ = new MainTable.LabelA2[5];
    ArrayList<String> lista;
    JButton btnBead;
    JButton btnbig;
    int j = 0, k = 0, l = 0, c = 1, ll = 0, cc = 1, c_raiz = 0, flag = 0;
    int quem_jogou = 0;
    KeyStroke stroke;
    private int pos = 0;
    private String urlImage = "/baccarat/imagem/";
    Timer tm;
    int x = 0;
    LabelSliderLeftRight labelSliderLeftRight;
    private int totalBtn = 36;
    PanelMangerUtil panelMangerUtil;
    PanelMangerUtil panelMangerUtilJogada;
    public static Aposta _aposta;
    public static boolean flagMostrarTelaOquestrador = true;
    private ImagemUtil imagemUtil;
    private JScrollPane jScrollPanePrincipal;

    public class LabelA2 extends JLabel {

        public LabelA2() {
            setBackground(Color.WHITE);
            setText("B");
            setForeground(Color.red);
        }
    }

    public MainTable() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jPanelPrincipal.setLayout(new GridLayout(3, 0));
        jPanelPrincipal.setBackground(Constants.BG_PRINCIPAL);
        initNewsComponents();
    }

    public void iconeSistema() {
        URL caminho = this.getClass().getResource("icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminho);
        this.setIconImage(iconeTitulo);
    }

    MainTable(Aposta aposta) {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jPanelPrincipal.setLayout(new GridLayout(3, 0));
        iconeSistema();
        checkOquestador();
        _aposta = aposta;
        DecimalFormat decimalFormat = new DecimalFormat("0,000.00");
        lblMaximoAposta.setText("MÁX: KZ: " + decimalFormat.format(_aposta.getValor_maximo_aposta()));
        lblMinimoAposta.setText("MIN: KZ: " + decimalFormat.format(_aposta.getValor_minimo_aposta()));
        initNewsComponents();
        this.key();
        lblMesa.setText(" TABLE: " + aposta.getMesa().getDesignacao());
        refresh();

    }

    public void paresBanker() {
        switch (flag_par) {
            case 1:
                iconBanker = iconParePlayer_banker;
                break;
            case 2:
                iconBanker = iconPareBanker_banker;
                break;
            case 3:
                iconBanker = icon2Pares_banker;
                break;
            case 4:
                iconBanker = iconNatural_banker;
                break;
            case 5:
                iconBanker = iconNaturalParesPlayer_banker;
                break;
            case 6:
                iconBanker = iconNaturalParesBanker_banker;
                break;
            case 7:
                iconBanker = icon2ParesNatural_banker;
                break;
            default:
                break;
        }
    }

    public String getStringIcon(String icon_nome) {
        icon_nome = icon_nome.replace(".png", "");
        System.out.println("icon_nome: " + icon_nome);
        if (icon_nome.contains("banker")) {
            return "banker";
        } else if (icon_nome.contains("player")) {
            return "player";
        } else if (icon_nome.contains("tie")) {
            return "tie";
        }
        return "";
    }

    private JLabel getBtnByPanel(JPanel panel) {
        return (JLabel) panel.getComponent(0);
    }

    public void setar(ImageIcon icon) {
        try {
            String nome_IconMais1Menos1 = "";
            String nome_IconMais1 = "";
            File file = new File("" + icon);
            String nome_ProximoIcon = file.getName();
            String result = getStringIcon(nome_ProximoIcon);
            File file1 = new File("" + getBtnByPanel(btn_principal[l][c]).getIcon());
            String actual = file1.getName();
            File file2 = new File("" + iconTie);
            String nome_IconTie = file2.getName().replace(".png", "");
            File file3 = new File("" + lastIcon);
            String nome_lastIcon = file3.getName();
            if ((l < 5) && getBtnByPanel(btn_principal[l + 1][c - 1]).getIcon() != null) {
                File file4 = new File("" + getBtnByPanel(btn_principal[l + 1][c - 1]).getIcon());
                nome_IconMais1Menos1 = file4.getName();
            }
            if ((l < 5) && getBtnByPanel(btn_principal[l + 1][c - 1]).getIcon() != null) {
                File file5 = new File("" + getBtnByPanel(btn_principal[l + 1][c]).getIcon());
                nome_IconMais1 = file5.getName();
            }
            if (getBtnByPanel(btn_principal[l][c]).getIcon() != null) {
                if ((l == 5) || (getBtnByPanel(btn_principal[l + 1][c]).getIcon() != null) || (verifyLine(result, l + 2, c)) || (getBtnByPanel(btn_principal[l + 1][c - 1]).getIcon() != null && (nome_IconMais1Menos1.contains(result)) && !nome_IconMais1Menos1.contains("tie"))) {
                    if ((actual.contains(result))
                            || result.contains("tie") || nome_lastIcon.contains(result)) {

                        c++;
                        if (flag == 0) {
                            System.out.println("flag");
                            flag++;
                            c_raiz = c;
                        }
                    } else {
                        System.out.println("trocou: " + c_raiz);
                        l = 0;
                        if (c_raiz != 0) {
                            c = c_raiz;
                        } else {
                            c++;

                        }
                        c_raiz = 0;
                        flag = 0;
                    }
                } else {
                    if (c_raiz != 0 && (!actual.contains(result) && !result.contains("tie") && !nome_lastIcon.contains(result))) {
                        System.out.println("diferente");
                        c = c_raiz - 1;
                        c_raiz = 0;
                    }
                    if (actual.contains(result) || result.contains("tie") || nome_lastIcon.contains(result)) {
                        System.out.println("normal mesma coluna");
                        l++;
                    } else {
                        System.out.println("result: " + result + " Tie: " + nome_IconTie);
                        System.out.println("normal muda coluna");
                        l = 0;
                        c++;
                        flag = 0;
                    }
                }
            }

            try {
                getBtnByPanel(btn_principal[l][c]).setIcon(icon);
            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                aumentarPanelJogoPrincipal();
                getBtnByPanel(btn_principal[l][c]).setIcon(icon);
            }
            setarTotais();
            if (!icon.equals(iconTie)) {
                lastIcon = icon;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public boolean verifyLine(String result, int linha, int coluna) {
        if (linha < 6 && (getBtnByPanel(btn_principal[linha][coluna]).getIcon() != null)) {
            File file = new File("" + getBtnByPanel(btn_principal[linha][coluna]).getIcon());
            String actual = file.getName();
            if (actual.contains(result) && !result.contains("tie")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private void jogada(ImageIcon icon) throws IndexOutOfBoundsException {
        if ((getBtnByPanel(btn_painelJogo3[ll][cc]).getIcon() != null) && ll < 5) {
            ll++;
        } else if (ll == 5) {
            ll = 0;
            cc++;
        }
        getBtnByPanel(btn_painelJogo3[ll][cc]).setIcon(icon);

    }

    public void setar2(ImageIcon icon) {
        try {
            jogada(icon);
        } catch (IndexOutOfBoundsException ex) {
            aumentarPanelJogada();
            jogada(icon);
        }
    }

    public void setarTotais() {
        jLabelTotal.setText("Total:" + String.valueOf(total_count));
        jLabelBanker.setText(String.valueOf(b_count));
        jLabelPlayer.setText(String.valueOf(p_count));
        jLabelTie.setText(String.valueOf(tie_count));
        jLabelNatural.setText(String.valueOf(natural_count));
        jLabelp_pair.setText(String.valueOf(pp_count));
        jLabelb_pair.setText(String.valueOf(bp_count));
    }

    public void paresPlayer() {
        System.out.println("paresPlayer");
        switch (flag_par) {
            case 1:
                iconPlayer = iconParePlayer_player;
                break;
            case 2:
                iconPlayer = iconPareBanker_player;
                break;
            case 3:
                iconPlayer = icon2Pares_player;
                break;
            case 4:
                iconPlayer = iconNatural_player;
                break;
            case 5:
                iconPlayer = iconNaturalParesPlayer_player;
                break;
            case 6:
                iconPlayer = iconNaturalParesBanker_player;
                break;
            case 7:
                iconPlayer = icon2ParesNatural_player;
                break;
            default:
                break;
        }
    }

    public void paresTie() {
        System.out.println("paresTie");
        switch (flag_par) {
            case 1:
                iconTie = iconParePlayer_tie;
                break;
            case 2:
                iconTie = iconPareBanker_tie;
                break;
            case 3:
                iconTie = icon2Pares_tie;
                break;
            case 4:
                iconTie = iconNatural_tie;
                break;
            case 5:
                iconTie = iconNaturalParesPlayer_tie;
                break;
            case 6:
                iconTie = iconNaturalParesBanker_tie;
                break;
            case 7:
                iconTie = icon2ParesNatural_tie;
                break;
            default:
                break;
        }
    }

    public void key() {
        String actionKey = "theAction";

        //BANKER
        stroke = KeyStroke.getKeyStroke("B");
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                paresBanker();
                File file = new File("" + iconBanker);
                String icons2 = file.getName();
                b_count++;
                total_count++;
                setar(iconBanker);
                iconBanker = new ImageIcon(getClass().getResource("/baccarat/icons2/" + icons2));
                setar2(iconBanker);
                new formIcon(iconBankerView).setVisible(true);
                iconBanker = new ImageIcon(getClass().getResource("banker.png"));
                registaJogada("B");
                flag_par = 0;
            }
        };
        InputMap inputMap = panelPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke, actionKey);
        ActionMap actionMap = panelPrincipal.getActionMap();
        actionMap.put(actionKey, action);

        //PLAYER
        stroke = KeyStroke.getKeyStroke("P");

        action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paresPlayer();
                File file = new File("" + iconPlayer);
                String icons2 = file.getName();
                p_count++;
                total_count++;
                setar(iconPlayer);
                registaJogada("P");
                iconPlayer = new ImageIcon(getClass().getResource("/baccarat/icons2/" + icons2));
                setar2(iconPlayer);
                new formIcon(iconPlayerView).setVisible(true);

                flag_par = 0;
                iconPlayer = new ImageIcon(getClass().getResource("player.png"));
            }
        };
        inputMap = panelPrincipal2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke, actionKey);
        actionMap = panelPrincipal2.getActionMap();
        actionMap.put(actionKey, action);

        //TIE
        stroke = KeyStroke.getKeyStroke("T");
        action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                paresTie();
                File file = new File("" + iconTie);
                String icons2 = file.getName();
                tie_count++;
                total_count++;
                registaJogada("T");
                setar(iconTie);
                iconTie = new ImageIcon(getClass().getResource("/baccarat/icons2/" + icons2));
                setar2(iconTie);
                new formIcon(iconTieView).setVisible(true);
                flag_par = 0;
                iconTie = new ImageIcon(getClass().getResource("tie.png"));
            }
        };
        inputMap = a2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke, actionKey);
        actionMap = a2.getActionMap();
        actionMap.put(actionKey, action);

        //NATURAL
        stroke = KeyStroke.getKeyStroke("F1");
        action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pp_count++;
                flag_par += p_pair;
            }
        };
        inputMap = jLabelTotal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke, actionKey);
        actionMap = jLabelTotal.getActionMap();
        actionMap.put(actionKey, action);
        //PAR BANKER
        stroke = KeyStroke.getKeyStroke("F2");

        action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bp_count++;
                flag_par += b_pair;
            }
        };
        inputMap = jLabelBanker.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke, actionKey);
        actionMap = jLabelBanker.getActionMap();
        actionMap.put(actionKey, action);
        //PAR PLAYER
        stroke = KeyStroke.getKeyStroke("N");

        action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                natural_count++;
                registaJogada("N");
                flag_par += natural;
            }
        };
        inputMap = jLabelPlayer.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke, actionKey);
        actionMap = jLabelPlayer.getActionMap();
        actionMap.put(actionKey, action);

    }

    private void registaJogada(String jogada) {
        try {
            _aposta.setJogadas(_aposta.getJogadas().concat(jogada));
            ApostaBean apostaBean = new ApostaBean();
            apostaBean.setModel(_aposta);
            apostaBean.saveOrUpdate();
        } catch (Exception ex) {
            Logger.getLogger(MainTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getLarguraForm() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        Locale idioma = Locale.getDefault();
        return d.width;
    }

    private void refresh() {

        LabelSliderLeftRight labelSliderLeftRight = new LabelSliderLeftRight(panelRodape, getLarguraForm(), 20);
        labelSliderLeftRight.run();

        Timer tempo = new Timer(1000, (ActionEvent e) -> {
            try {
                lblTrocaColor(jLabelTotal);
            } catch (Exception ex) {
                Logger.getLogger(MainTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        tempo.start();

    }

    private void lblTrocaColor(JLabel lbl) {

        Color c = lbl.getForeground();
        Color cTroca = Color.white;

        if (c == Color.white) {

            cTroca = Color.red;
        } else if (c == Color.red) {

            cTroca = Color.white;
        }

        lbl.setForeground(cTroca);

    }

    private void checkOquestador() {

        LogApostaOquestradorBean bean = new LogApostaOquestradorBean();

        Timer tm = new Timer(1000, (ActionEvent e) -> {
            try {

                LogApostaOquestrador model = bean.findByAposta(_aposta);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy HH:mm");
                String dataCheck = dateFormat.format(model.getOquestrador().getData_ultima_check());
                String data = dateFormat.format(new Date());
                if (dataCheck.equals(data)) {

                    if (flagMostrarTelaOquestrador) {
                        AddOquestradorView view = new AddOquestradorView(_aposta, true);
                        view.setVisible(true);
                        bloquiarTela();
                        flagMostrarTelaOquestrador = false;
                    }
                }

            } catch (Exception ex) {
                Logger.getLogger(MainTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        tm.start();

    }

    private void bloquiarTela() {

        this.setEnabled(false);
    }

    public void initNewsComponents() {
        jPanelPrincipal.setLayout(new GridLayout(3, 0));
        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Constants.BG_PRINCIPAL);
        panelPrincipal.setBorder(new javax.swing.border.LineBorder(Constants.BORDER_COLOR, 5, true));
        manipulePainel1();

        panelPrincipal2 = new JPanel();
        manipulePainel2();

        painelGame3 = new JPanel();
        manipulePainel3();

    }

    public void aumentarPanelJogoPrincipal() {

        JPanel[][] aux = new JPanel[Constants.MATRIZ_ROWS_PANEL1][Constants.MATRIZ_COLUMNS_PANEL1 + btn_principal[0].length];

        int div = (Constants.MATRIZ_COLUMNS_PANEL1 + btn_principal[0].length) / Constants.MATRIZ_COLUMNS_PANEL1;

        panelPrincipal = new JPanel();
        panelPrincipal.setPreferredSize(new Dimension(Constants.WIDTH_PANEL * div, Constants.HEIGTH_PANEL));
        panelPrincipal.setMaximumSize(new Dimension(Constants.WIDTH_PANEL * div, Constants.HEIGTH_PANEL));
        panelPrincipal.setMinimumSize(new Dimension(Constants.WIDTH_PANEL * div, Constants.HEIGTH_PANEL));
        panelPrincipal.setLayout(new GridLayout(Constants.MATRIZ_ROWS_PANEL1, Constants.MATRIZ_COLUMNS_PANEL1 + btn_principal[0].length));
        JPanel panel = null;
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[i].length; j++) {
                if (i < btn_principal.length && j < btn_principal[0].length) {
                    panel = aux[i][j] = btn_principal[i][j];
                } else {
                    panel = gerarButtonPainel1();
                    aux[i][j] = panel;
                }
                panelPrincipal.add(panel);
            }
        }

        btn_principal = new JPanel[Constants.MATRIZ_ROWS_PANEL1][Constants.MATRIZ_COLUMNS_PANEL1 + btn_principal[0].length];
        btn_principal = aux;
        JScrollPane panelPane = new JScrollPane(panelPrincipal);
        viewPort(panelPane);
        jPanelPrincipal.remove(0);
        jPanelPrincipal.add(panelPane, 0);
    }

    private void viewPort(JScrollPane scrollPane) {
        JViewport jViewport = scrollPane.getViewport();
        Point p = jViewport.getViewPosition();
        p.x += scrollPane.getPreferredSize().width;
        //  p.x = salto;
        jViewport.setViewPosition(p);

    }

    public void manipulePainel1() {
        int l = 0, c = 0;
        btn_principal = new JPanel[Constants.MATRIZ_ROWS_PANEL1][Constants.MATRIZ_COLUMNS_PANEL1];
        panelPrincipal.setPreferredSize(new Dimension(Constants.WIDTH_PANEL, Constants.HEIGTH_PANEL));
        panelPrincipal.setLayout(new GridLayout(Constants.MATRIZ_ROWS_PANEL1, Constants.MATRIZ_COLUMNS_PANEL1));
        for (int i = 0; i < Constants.MATRIZ_ROWS_PANEL1 * Constants.MATRIZ_COLUMNS_PANEL1; i++) {
            JPanel panel = gerarButtonPainel1();
            btn_principal[l][c] = panel;
            if (c > 0) {
                panelPrincipal.add(panel);
            }
            c++;

            if (c >= Constants.MATRIZ_COLUMNS_PANEL1) {
                l++;
                c = 0;
            }
        }

        JScrollPane panelPane = new JScrollPane(panelPrincipal);
        panelPane.setPreferredSize(new Dimension(Constants.WIDTH_PANEL, Constants.HEIGTH_PANEL));

        jPanelPrincipal.add(panelPane);
    }
    
//    public void createPanel1ForPanel2_1_(JPanel panel1) {
//        int l = 0, c = 0;
//        btn_painel_1_2 = new JPanel[4][2];
//        panel1.setBackground(Constants.BG_PRINCIPAL);
//        panel1.setPreferredSize(new Dimension(100, 300));
//        panel1.setLayout(new GridLayout(4, 2));
//        for (int i = 0; i < 8; i++) {
//            JPanel panel = gerarButtonPainel1_2_1();
//            btn_painel_1_2[l][c] = panel;
//            if (c > 0) {
//                panel1.add(panel);
//            }
//            c++;
//            if (c >= 2) {
//                l++;
//                c = 0;
//            }
//        }
//
////        JScrollPane panelPane = new JScrollPane(panel1);
//        panelPrincipal2.add(panel1, BorderLayout.WEST);
//    }
    public void createPanel1ForPanel2_1(JPanel panel1) {
        int l = 0, c = 0;
        btn_painel_1_2 = new JPanel[Constants.MATRIZ_ROWS_PANEL2][Constants.MATRIZ_COLUMNS_PANEL2];
        panel1.setBackground(new java.awt.Color(242, 242, 242));
        panel1.setPreferredSize(new Dimension(Constants.WIDTH_PANEL2, Constants.HEIGTH_PANEL2));
        panel1.setLayout(new GridLayout(Constants.MATRIZ_ROWS_PANEL2, Constants.MATRIZ_COLUMNS_PANEL2));
        for (int i = 0; i < Constants.MATRIZ_ROWS_PANEL2 * Constants.MATRIZ_COLUMNS_PANEL2; i++) {
            JPanel panel = gerarButtonPainel1_2();
            btn_painel_1_2[l][c] = panel;
            if (c > 0) {
                panel1.add(panel);
            }
            c++;
            if (c >= Constants.MATRIZ_COLUMNS_PANEL2) {
                l++;
                c = 0;
            }
        }

//        JScrollPane panelPane = new JScrollPane(panel1);
        panelPrincipal2.add(panel1, BorderLayout.CENTER);
    }
    public void createPanel1ForPanel2_2(JPanel panel1) {
        int l = 0, c = 0;
        btn_painel_2_2 = new JPanel[Constants.MATRIZ_ROWS_PANEL2][Constants.MATRIZ_COLUMNS_PANEL2];
        panel1.setBackground(new java.awt.Color(242, 242, 242));
        panel1.setPreferredSize(new Dimension(Constants.WIDTH_PANEL2, Constants.HEIGTH_PANEL2));
        panel1.setLayout(new GridLayout(Constants.MATRIZ_ROWS_PANEL2, Constants.MATRIZ_COLUMNS_PANEL2));
        for (int i = 0; i < Constants.MATRIZ_ROWS_PANEL2 * Constants.MATRIZ_COLUMNS_PANEL2; i++) {
            JPanel panel = gerarButtonPainel1_2();
            btn_painel_2_2[l][c] = panel;
            if (c > 0) {
                panel1.add(panel);
            }
            c++;
            if (c >= Constants.MATRIZ_COLUMNS_PANEL2) {
                l++;
                c = 0;
            }
        }

        JScrollPane panelPane = new JScrollPane(panel1);
        panelPrincipal2.add(panel1, BorderLayout.CENTER);
    }
    public void createPanel1ForPanel2_3(JPanel panel1) {
        int l = 0, c = 0;
        btn_painel_3_2 = new JPanel[Constants.MATRIZ_ROWS_PANEL3][Constants.MATRIZ_COLUMNS_PANEL2];
        panel1.setBackground(new java.awt.Color(242, 242, 242));
        panel1.setPreferredSize(new Dimension(Constants.WIDTH_PANEL2, Constants.HEIGTH_PANEL3));
        panel1.setLayout(new GridLayout(Constants.MATRIZ_ROWS_PANEL2, Constants.MATRIZ_COLUMNS_PANEL2));
        for (int i = 0; i < Constants.MATRIZ_ROWS_PANEL2 * Constants.MATRIZ_COLUMNS_PANEL2; i++) {
            JPanel panel = gerarButtonPainel1_2();
            btn_painel_3_2[l][c] = panel;
            if (c > 0) {
                panel1.add(panel);
            }
            c++;
            if (c >= Constants.MATRIZ_COLUMNS_PANEL2) {
                l++;
                c = 0;
            }
        }

        JScrollPane panelPane = new JScrollPane(panel1);
        panelPrincipal2.add(panel1, BorderLayout.CENTER);
    }

    public void manipulePainel2() {
        panelPrincipal2.setBackground(new java.awt.Color(242, 242, 242));
        panelPrincipal2.setLayout(new GridLayout(1, 0,10,10));
//
        JPanel panel1_2 = new JPanel();
        panel1_2.setBackground(Constants.BORDER_COLOR);
        panel1_2.setBorder(new javax.swing.border.LineBorder(Constants.BORDER_COLOR, 6, true));
        createPanel1ForPanel2_1(panel1_2);
//
        JPanel panel2_2 = new JPanel();
        panel2_2.setBackground(Constants.BORDER_COLOR);
        panel2_2.setBorder(new javax.swing.border.LineBorder(Constants.BORDER_COLOR, 6, true));
        createPanel1ForPanel2_2(panel2_2);
//
        JPanel panel3_2 = new JPanel();
        panel3_2.setBackground(Constants.BORDER_COLOR);
        panel3_2.setBorder(new javax.swing.border.LineBorder(Constants.BORDER_COLOR, 6, true));
        createPanel1ForPanel2_3(panel3_2);
        
        jPanelPrincipal.add(panelPrincipal2);

    }

    public void createPanelForPainelGame2() {
        JPanel panel1 = new JPanel();

        panel1.setBackground(Constants.BG_PRINCIPAL);
//        panel1.setPreferredSize(new Dimension(500, 200));
//        componentPanel2(panel1);
        panelPrincipal2.add(panel1, BorderLayout.WEST);

    }

    private void btnSecundario() {
        JScrollPane scroll = (JScrollPane) panelPrincipal2.getComponent(1);
        JViewport jViewport = (JViewport) scroll.getComponent(0);
        JPanel panelPreechido = (JPanel) scroll.getComponent(1);
        JPanel[] panelComp = (JPanel[]) panelPreechido.getComponents();

        int l = 0, c = 0;

        for (int i = 0; i < btn_painelJogo3.length * btn_painelJogo3[0].length; i++) {
            if (c >= btn_painelJogo3[0].length) {
                l++;
                c = 0;
            }
            btn_painelJogo3[l][c] = panelComp[i];
        }
    }

    public void aumentarPanelJogada() {

        JPanel[][] aux = new JPanel[Constants.MATRIZ_ROWS_PANEL3][Constants.MATRIZ_COLUMNS_PANEL3 + btn_painelJogo3[0].length];
        int div = (Constants.MATRIZ_COLUMNS_PANEL3 + btn_painelJogo3[0].length) / Constants.MATRIZ_COLUMNS_PANEL3;
        JPanel panel = null;
        JPanel panel2 = new JPanel();
        btn_painelJogo3 = new JPanel[Constants.MATRIZ_ROWS_PANEL3][Constants.MATRIZ_COLUMNS_PANEL3];
        panel2.setBackground(Constants.BG__PANEL3);
        panel2.setPreferredSize(new Dimension(Constants.WIDTH_PANEL3 * div, Constants.HEIGTH_PANEL3));
        panel2.setMaximumSize(new Dimension(Constants.WIDTH_PANEL3 * div, Constants.HEIGTH_PANEL3));
        panel2.setMinimumSize(new Dimension(Constants.WIDTH_PANEL3 * div, Constants.HEIGTH_PANEL3));
        panel2.setLayout(new GridLayout(Constants.MATRIZ_ROWS_PANEL3, Constants.MATRIZ_COLUMNS_PANEL3 + btn_painelJogo3[0].length));

        // btnSecundario();
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[i].length; j++) {
//                System.out.println("i :" + i + " j: " + j);
//                System.out.println("i < btn_secundario.length && j < btn_secundario[0].length >> " + (i < btn_secundario.length && j < btn_secundario[0].length));
                if (i < btn_painelJogo3.length && j < btn_painelJogo3[0].length) {
                    panel = aux[i][j] = btn_painelJogo3[i][j];
                } else {
                    panel = gerarButtonPainel1();
                    aux[i][j] = panel;
                    panel2.add(panel);
                }
            }
        }

        btn_painelJogo3 = new JPanel[Constants.MATRIZ_ROWS_PANEL3][Constants.MATRIZ_COLUMNS_PANEL3 + btn_painelJogo3[0].length];
        btn_painelJogo3 = aux;
        JScrollPane panelPane = new JScrollPane(panel2);
        viewPort(panelPane);
        painelGame3.remove(1);
        painelGame3.add(panelPane, 1);
        painelGame3.add(panelPane, BorderLayout.CENTER);

    }

    public void createPanel2ForPanel3(JPanel panel3) {
        int l = 0, c = 0;
        btn_painelJogo3 = new JPanel[Constants.MATRIZ_ROWS_PANEL3][Constants.MATRIZ_COLUMNS_PANEL3];
        panel3.setBackground(Constants.BG_PRINCIPAL);
        panel3.setPreferredSize(new Dimension(Constants.WIDTH_PANEL3, Constants.HEIGTH_PANEL3));
        panel3.setLayout(new GridLayout(Constants.MATRIZ_ROWS_PANEL3, Constants.MATRIZ_COLUMNS_PANEL3));
//        panel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        for (int i = 0; i < Constants.MATRIZ_ROWS_PANEL3 * Constants.MATRIZ_COLUMNS_PANEL3; i++) {
            JPanel panel = gerarButtonPainel1();
            btn_painelJogo3[l][c] = panel;
            if (c > 0) {
                panel3.add(panel);
            }
            c++;
            if (c >= Constants.MATRIZ_COLUMNS_PANEL3) {
                l++;
                c = 0;
            }
        }

        JScrollPane panelPane = new JScrollPane(panel3);
        painelGame3.add(panelPane, BorderLayout.CENTER);
    }

    public JPanel gerarButtonPainel1() {
        qtButtonPanel1++;
        JPanel bt = new JPanel(new BorderLayout());
        bt.setBackground(Constants.BG_BUTTONS_PANEL1);
        bt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, false));
        JLabel lb = new JLabel("");
        bt.add(lb, BorderLayout.CENTER);
        return bt;
    }
//    public JPanel gerarButtonPainel1_2_1() {
//        qtButtonPanel1_2++;
//        JPanel bt = new JPanel(new BorderLayout());
//        bt.setBackground(Constants.BG_BUTTONS_PANEL1);
//        bt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, false));
//        JLabel lb = new JLabel("");
//        bt.add(lb, BorderLayout.WEST);
//        return bt;
//    }
    public JPanel gerarButtonPainel1_2() {
        qtButtonPanel1_2++;
        JPanel bt = new JPanel(new BorderLayout());
        bt.setBackground(Constants.BG_BUTTONS_PANEL1);
        bt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, false));
        JLabel lb = new JLabel("");
        bt.add(lb, BorderLayout.CENTER);
        return bt;
    }

    public JPanel gerarButtonPainel2() {
        qtButtonPanel2++;
        JPanel bt = new JPanel();
        bt.setBackground(Constants.BG_BUTTONS_PANEL2);
        bt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, false));
        return bt;
    }

    public void manipulePainel3() {
        painelGame3.setBackground(new java.awt.Color(242, 242, 242));
        painelGame3.setLayout(new BorderLayout());
        createPanel3();
        jPanelPrincipal.add(painelGame3);
    }

    public void createPanel3() {

        JPanel panel1 = new ImageAnimationView();
        panel1.setPreferredSize(new Dimension(500, 500));
        panel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 15, false));
        painelGame3.add(panel1, BorderLayout.WEST);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Constants.BG_PRINCIPAL);
        panel3.setLayout(new GridLayout(0, 3));
        panel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 5, false));
        
        createPanel2ForPanel3(panel3);
        painelGame3.add(panel3, BorderLayout.CENTER);
    }
    
    

//    public void createPanel2ForPanel3(JPanel panel) {
//
//        ImageIcon image = new ImageIcon(getClass().getResource("/baccarat/icons/P.PNG"));
//        ImageIcon image1 = new ImageIcon(getClass().getResource("/baccarat/icons/B.PNG"));
//        ImageIcon image2 = new ImageIcon(getClass().getResource("/baccarat/icons/T.PNG"));
//
//        JButton bt1 = new JButton("");
//        JButton bt2 = new JButton();
//        JButton bt3 = new JButton("");
//
//        bt1.setBackground(Color.WHITE);
//        bt2.setBackground(Color.WHITE);
//        bt3.setBackground(Color.WHITE);
//        
//        if(!ImageAnimationView.addImage(bt1, ParametroDesignacao.IMAGEM_PLAYER)){
//            
//             bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/P.png"))); // NOI18N
//        }
//        if(!ImageAnimationView.addImage(bt2, ParametroDesignacao.IMAGEM_BANKER)){
//            
//             bt2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/B.png"))); // NOI18N
//        }
//        if(!ImageAnimationView.addImage(bt3, ParametroDesignacao.IMAGEM_TIE)){
//            
//             bt3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/T.png"))); // NOI18N
//        }
//
//        panel.add(bt1);
//        panel.add(bt2);
//
//        panel.add(bt3);
//
//    }
//    public void createPanel2ForPanel3(JPanel panel) {
//
//        createPanel2ForPanel2(panel);
////        panel.add(bt3);
//
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRodape = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelPrincipal = new javax.swing.JPanel();
        a2 = new javax.swing.JPanel();
        jLabelTotal = new javax.swing.JLabel();
        jLabelBanker = new javax.swing.JLabel();
        jLabelPlayer = new javax.swing.JLabel();
        jLabelTie = new javax.swing.JLabel();
        jLabelNatural = new javax.swing.JLabel();
        jLabelb_pair = new javax.swing.JLabel();
        jLabelp_pair = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelInfoJogo = new javax.swing.JPanel();
        lblMesa = new javax.swing.JLabel();
        lblMinimoAposta = new javax.swing.JLabel();
        lblMaximoAposta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Baccarat-Game");

        panelRodape.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to Golden Lion casino ... Good Luck");

        javax.swing.GroupLayout panelRodapeLayout = new javax.swing.GroupLayout(panelRodape);
        panelRodape.setLayout(panelRodapeLayout);
        panelRodapeLayout.setHorizontalGroup(
            panelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRodapeLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 890, Short.MAX_VALUE))
        );
        panelRodapeLayout.setVerticalGroup(
            panelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRodapeLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanelPrincipal.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );

        a2.setBackground(new java.awt.Color(8, 6, 6));
        a2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        a2.setPreferredSize(new java.awt.Dimension(6, 51));
        a2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTotal.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 36)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotal.setText("   Total: 0");
        jLabelTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelTotal.setPreferredSize(new java.awt.Dimension(160, 37));
        a2.add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1024, 2, 146, 66));

        jLabelBanker.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 36)); // NOI18N
        jLabelBanker.setForeground(new java.awt.Color(204, 0, 51));
        jLabelBanker.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelBanker.setText("Banker: 0");
        jLabelBanker.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelBanker.setPreferredSize(new java.awt.Dimension(80, 40));
        a2.add(jLabelBanker, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 156, 66));

        jLabelPlayer.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 36)); // NOI18N
        jLabelPlayer.setForeground(new java.awt.Color(153, 153, 153));
        jLabelPlayer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPlayer.setText("Player: 0");
        jLabelPlayer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelPlayer.setPreferredSize(new java.awt.Dimension(80, 40));
        a2.add(jLabelPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 2, 158, 66));

        jLabelTie.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 36)); // NOI18N
        jLabelTie.setForeground(new java.awt.Color(0, 204, 51));
        jLabelTie.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTie.setText("Tie: 0");
        jLabelTie.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelTie.setPreferredSize(new java.awt.Dimension(80, 40));
        a2.add(jLabelTie, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 2, 141, 66));

        jLabelNatural.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 36)); // NOI18N
        jLabelNatural.setForeground(new java.awt.Color(255, 204, 0));
        jLabelNatural.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelNatural.setText("Natural: 0");
        jLabelNatural.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelNatural.setPreferredSize(new java.awt.Dimension(80, 40));
        a2.add(jLabelNatural, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 2, 182, 66));

        jLabelb_pair.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 36)); // NOI18N
        jLabelb_pair.setForeground(new java.awt.Color(204, 0, 51));
        jLabelb_pair.setText("B.Pair: 0");
        jLabelb_pair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        a2.add(jLabelb_pair, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 2, 175, 66));

        jLabelp_pair.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 36)); // NOI18N
        jLabelp_pair.setForeground(new java.awt.Color(0, 102, 204));
        jLabelp_pair.setText("P.Pair: 0");
        jLabelp_pair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        a2.add(jLabelp_pair, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 2, 166, 66));

        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        a2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 66));

        panelInfoJogo.setBackground(new java.awt.Color(0, 0, 0));
        panelInfoJogo.setPreferredSize(new java.awt.Dimension(0, 48));

        lblMesa.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 36)); // NOI18N
        lblMesa.setForeground(new java.awt.Color(255, 255, 255));
        lblMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/btn/icons8-filtro-vazio-30.png"))); // NOI18N
        lblMesa.setText(" TABLE: MPBVIP-02");

        lblMinimoAposta.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 36)); // NOI18N
        lblMinimoAposta.setForeground(new java.awt.Color(255, 255, 255));
        lblMinimoAposta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinimoAposta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/btn/icons8-dinheiro-32.png"))); // NOI18N
        lblMinimoAposta.setText("MIN: $ 200");

        lblMaximoAposta.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 36)); // NOI18N
        lblMaximoAposta.setForeground(new java.awt.Color(255, 255, 255));
        lblMaximoAposta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaximoAposta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/btn/icons8-dinheiro-32.png"))); // NOI18N
        lblMaximoAposta.setText("MÁX: $ 6,000");

        javax.swing.GroupLayout panelInfoJogoLayout = new javax.swing.GroupLayout(panelInfoJogo);
        panelInfoJogo.setLayout(panelInfoJogoLayout);
        panelInfoJogoLayout.setHorizontalGroup(
            panelInfoJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoJogoLayout.createSequentialGroup()
                .addComponent(lblMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMinimoAposta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMaximoAposta, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelInfoJogoLayout.setVerticalGroup(
            panelInfoJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoJogoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMinimoAposta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMaximoAposta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInfoJogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1172, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panelInfoJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1200, 597));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel a2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelBanker;
    private javax.swing.JLabel jLabelNatural;
    private javax.swing.JLabel jLabelPlayer;
    private javax.swing.JLabel jLabelTie;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelb_pair;
    private javax.swing.JLabel jLabelp_pair;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JLabel lblMaximoAposta;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblMinimoAposta;
    private javax.swing.JPanel panelInfoJogo;
    private javax.swing.JPanel panelRodape;
    // End of variables declaration//GEN-END:variables
}
