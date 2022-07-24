/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import baccarat.commons.Constants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

/**
 *
 * @author filme
 */
public class PanelMangerUtil {

    private  int TOTAL_LINHA = 6;
    private final int TOTAL_DIVI = 69;
    private int INDEX_COLUMN_PUSH = 10;
    private final int COLUMN_PUSH = 30;
    private int totalColuna = 0;
    private JPanel[][] listBtns = new JPanel[TOTAL_LINHA][0];
    ;
    private final int WIDTH_BTN_DEFAULT = 33;
    int count = 2;
    int k = 0;
    boolean flagMove = false;

    private String jogadaAnterior;

    private JScrollPane scrollPane;

    private JPanel panelBtn;
    private int larguraPanel;

    private int maiorColuna;
    private int menorColuna;

    private boolean flag;
    private int count_flag = 1;
    int pointXBtn = 0;

    int x = 1173;
    int countMove = 1;
    int indexUltimaJogada = 0;
    boolean flagVolta = false;
    int prev = 0;
    int next = 1;
    private Paginator paginator = new Paginator();

    public class Paginator {

        private int totalPage = 0;
        private int pageActual = 0;
        private List<JPanel> lista = new ArrayList();

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPageActual() {
            return pageActual;
        }

        public void setPageActual(int pageActual) {
            this.pageActual = pageActual;
        }

        public List<JPanel> getLista() {
            return lista;
        }

        public void setLista(List<JPanel> lista) {
            this.lista = lista;
        }

    }

    public PanelMangerUtil(JScrollPane scrollPane, JPanel panelBtn, int totalColuna, int INDEX_COLUMN_PUSH) {

        this.panelBtn = panelBtn;

        this.totalColuna = totalColuna;

        larguraPanel = totalColuna;
//        larguraPanel = totalColuna * WIDTH_BTN_DEFAULT;

        this.scrollPane = scrollPane;
        this.INDEX_COLUMN_PUSH = INDEX_COLUMN_PUSH;

    }
    public PanelMangerUtil( JPanel panelBtn, int totalColuna, int INDEX_COLUMN_PUSH) {

        this.panelBtn = panelBtn;

        this.totalColuna = totalColuna;

        larguraPanel = totalColuna;
//        larguraPanel = totalColuna * WIDTH_BTN_DEFAULT;

        this.scrollPane = scrollPane;
        this.INDEX_COLUMN_PUSH = INDEX_COLUMN_PUSH;

    }
    public PanelMangerUtil( JPanel panelBtn, int totalColuna, int INDEX_COLUMN_PUSH,int totalLinha) {

        this.panelBtn = panelBtn;

        this.totalColuna = totalColuna;

        larguraPanel = totalColuna;
//        larguraPanel = totalColuna * WIDTH_BTN_DEFAULT;

        this.scrollPane = scrollPane;
        this.INDEX_COLUMN_PUSH = INDEX_COLUMN_PUSH;
        this.TOTAL_LINHA = totalLinha;

    }
    
     public JPanel createBtn() {
  
        JPanel bt = new JPanel();
        bt.setBackground(Constants.BG_BUTTONS_PANEL1);
        bt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, false));
        JLabel lb = new JLabel("");
        //lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/banker.PNG")));
        bt.add(lb);
        return bt;
    }

//    private JPanel createBtn() {
//
//        JPanel btn = new JPanel("<html><center></html>");
//        btn.setBackground(new Color(158, 158, 156));
//        btn.setSize(new Dimension(40, 40));
//
//        return btn;
//    }

    private void habiltarPrev(JLabel lbl, int colum) {

        if (colum % totalColuna == 0) {
            lbl.setVisible(true);
        }
    }

//    private JPanel createBtn(String text) {
//
//        JPanel btn = new JPanel(text);
//        btn.setSize(new Dimension(40, 40));
//
//        return btn;
//    }

    public void create() {
        createPaintJogo(larguraPanel);

    }

    public void next(int indecColuna, JPanel[][] lista) {

        this.panelBtn.removeAll();
        this.panelBtn.setLayout(new GridLayout(TOTAL_LINHA, totalColuna));
        JPanel btn = null;

        int indexStart = (totalColuna - 1) * next;

        if (indecColuna > indexStart) {
            for (int i = 0; i < TOTAL_LINHA; i++) {

                for (int count = indexStart; count < lista[0].length; count++) {

                    try {
                        if (lista[i].length < totalColuna) {
                            btn = createBtn();
                        } else {
                            btn = lista[i][count];
                        }
                    } catch (IndexOutOfBoundsException ex) {
                        btn = createBtn();
                    }

                    this.panelBtn.repaint();
                    this.panelBtn.add(btn);
                    this.panelBtn.validate();

                }

            }

        }

        next++;

    }

    public void prev(int indecColuna, JPanel[][] lista) {

        int index = indecColuna / totalColuna;
        // int div = lista[0].length / prev
        if (prev >= 0) {

            index -= prev;
            mostrarAnterior(index, lista);
        }
        prev++;

    }

    public void Add() {

        createPanel(this.panelBtn, totalColuna, TOTAL_LINHA, 0);
    }
//    public boolean add( JPanel[][] lista){
//        
//         createPanel(panelBtn, lista, indexColumn);
//        
//    }

    public boolean Add(int indexColumn, JPanel[][] lista) {

        if (indexUltimaJogada > (indexColumn + 1) ) {

            int indexStart = indexColumn / totalColuna;

            this.panelBtn.removeAll();
            mostrarAnterior(indexStart, lista);

            flagVolta = true;

        } else {

            if ((indexColumn + 1) == totalColuna) {

                System.out.println("indexColumn >>> " + indexColumn + " ");
                if (flagVolta) {
                    flag = false;
                    createPanel(panelBtn, lista, indexColumn);
                } else {
                    createPanel(this.panelBtn, totalColuna, TOTAL_LINHA, indexColumn);
                    return true;
                }
            }

        }
        indexUltimaJogada = indexColumn;
        return false;
    }

    public boolean AddJogada(int indexColumn, JPanel[][] lista) {

        if ((indexColumn + 1) == totalColuna) {

            createPanel(this.panelBtn, totalColuna, TOTAL_LINHA, indexColumn);
            return true;

        }

        indexUltimaJogada = indexColumn;
        return false;
    }

    private void mostrarAnterior(int indexStart, JPanel[][] lista) {

        this.panelBtn.removeAll();
        this.panelBtn.setLayout(new GridLayout(TOTAL_LINHA, totalColuna));

        for (int i = 0; i < TOTAL_LINHA; i++) {

            for (int j = indexStart; j < totalColuna; j++) {

                if (j != 0) {
                    this.panelBtn.repaint();
                    this.panelBtn.add(lista[i][j]);
                    this.panelBtn.validate();

                    System.out.println("MOSTRAR");

                }

            }

        }

    }

    private void createPanel(JPanel panel, JPanel[][] lista, int indexColuna) {

        panel.removeAll();
        panel.setLayout(new GridLayout(TOTAL_LINHA, totalColuna));

        for (int i = 0; i < lista.length; i++) {

            for (int j = indexColuna; j < lista[i].length; j++) {

                JPanel btn = lista[i][j];

                if (j != 0) {

                    panel.repaint();
                    panel.add(btn);
                    panel.validate();

                }
            }

        }

        paginator.setPageActual(paginator.getPageActual() + 1);
        paginator.setTotalPage(paginator.getTotalPage() + 1);

    }

    private void createPanel(JPanel panel, int totalColuna, int totalLinha, int indexColuna) {

        panel.removeAll();
        panel.setLayout(new GridLayout(totalLinha, totalColuna));
//        panel.setSize(new Dimension(larguraPanel, panelBtn.getSize().height));

        paginator.getLista().add(new JPanel(new GridLayout(totalLinha, totalColuna)));
        // int lengthColumn = (indexColuna+1) > listBtns[0].length ? listBtns[0].length + totalColuna : listBtns[0].length;
        JPanel[][] listBtnAux = new JPanel[totalLinha][listBtns[0].length + totalColuna];

        paginator.getLista().add(new JPanel(new GridLayout(totalLinha, totalColuna)));

        for (int i = 0; i < listBtnAux.length; i++) {

            for (int j = 0; j < listBtnAux[i].length; j++) {

                if (listBtns.length > 0 && listBtns[0].length > 0 && listBtns.length > i && listBtns[0].length > j) {

                    listBtnAux[i][j] = listBtns[i][j];
                    System.out.println("listBtns.length > 0");

                } else {
                    JPanel btn = createBtn();
                    System.out.println("createBtn >> [" + i + "] [" + j + "]");
                    listBtnAux[i][j] = btn;

                    if (j != 0) {

                        panel.repaint();
                        panel.add(btn);

                        panel.validate();
                        paginator.getLista().get(paginator.getLista().size() - 1).add(createBtn());
                    }
                }
            }

        }

        listBtns = new JPanel[listBtns.length + totalLinha][listBtns[0].length + totalColuna];
        listBtns = listBtnAux;

        System.out.println("componenst >>> " + paginator.getLista().get(paginator.getLista().size() - 1).getComponentCount());

        // paginator.getLista().add(panel);
        paginator.setPageActual(paginator.getPageActual() + 1);
        paginator.setTotalPage(paginator.getTotalPage() + 1);

    }

    private void createPaintJogo(int larguraPanel) {

        listBtns = new JPanel[TOTAL_LINHA][totalColuna];

        panelBtn.removeAll();
        panelBtn.setLayout(new GridLayout(TOTAL_LINHA, totalColuna));
        panelBtn.setSize(new Dimension(larguraPanel, panelBtn.getSize().height));

        for (int i = 0; i < TOTAL_LINHA; i++) {

            for (int j = 0; j < totalColuna; j++) {

                JPanel btn = createBtn();

                listBtns[i][j] = btn;

                if (j != 0) {

                    panelBtn.repaint();
                    panelBtn.add(btn);
                    panelBtn.validate();
                }
            }

        }

    }

    private void aumentarMatriz() {

        int l = 0, c = 0;

        listBtns = new JPanel[TOTAL_LINHA][totalColuna * 2];

        Component[] lista = panelBtn.getComponents();

        for (Component comp : lista) {

            if (c >= totalColuna) {

                c = 0;
                l++;
            }

            listBtns[l][c] = (JPanel) comp;

        }

    }

    private void viewPort(JScrollPane scrollPane) {

        viewPort(scrollPane, 3);

    }

    private void viewPort(JScrollPane scrollPane, int salto) {

        JViewport jViewport = scrollPane.getViewport();

        Point p = jViewport.getViewPosition();

        p.x += salto;
        //  p.x = salto;

        jViewport.setViewPosition(p);

    }

//    public void moveScrollRight(int positionX) {
//
//        viewPort(scrollPane, positionX);
//    }
    public void moveScrollRight() {

        viewPort(scrollPane, WIDTH_BTN_DEFAULT * 20);
    }

    private void controleJogada(String jogada, int pointXBtn) {

        if (!jogada.equals(jogadaAnterior)) {

            this.viewPort(scrollPane, pointXBtn);
        } else {

            JViewport jViewport = scrollPane.getViewport();

            Point p = jViewport.getViewPosition();

            this.viewPort(scrollPane, (int) (p.getX() + 15));
        }

    }

    public boolean aumentar(int colunaCount, JPanel btnJogada) {

        pointXBtn = btnJogada.getLocation().x;

        if ((colunaCount + 1) % INDEX_COLUMN_PUSH == 0) {
            pointXBtn = (pointXBtn * totalColuna * 2);
            pointXBtn = (int) Math.pow(pointXBtn, 2);
            this.viewPort(scrollPane, pointXBtn);
            //  aumentarMatriz();
            panelBtn.removeAll();
            // panelBtn.setLayout(new GridLayout(TOTAL_LINHA, totalColuna));
            // panelBtn.setSize(new Dimension(btnJogada.getPreferredSize().width * INDEX_COLUMN_PUSH, panelBtn.getSize().height));

            //  double max = panelBtn.getMaximumSize().width + btnJogada.getPreferredSize().width * INDEX_COLUMN_PUSH;
            //  panelBtn.setMaximumSize(new Dimension((int) max, (int) panelBtn.getMaximumSize().getHeight()));
            JPanel[][] listaAux = new JPanel[TOTAL_LINHA][totalColuna * 2];

            int k = 0;

            JPanel btn = null;

            for (int i = 0; i < TOTAL_LINHA; i++) {

                for (int j = 0; j < totalColuna + COLUMN_PUSH; j++) {

                    if (j < listBtns[0].length) {

                        btn = listBtns[i][j];

                    } else {

                        btn = createBtn();
                    }

                    if (j != 0) {

                        panelBtn.repaint();
                        panelBtn.add(btn);
                        panelBtn.validate();
                    }

                    listaAux[i][j] = btn;

                }

            }

            listBtns = new JPanel[TOTAL_LINHA][totalColuna * 2];
            listBtns = listaAux;

            totalColuna += COLUMN_PUSH;
            larguraPanel *= 2;
            flag = true;

            return true;
        }

        if (x == pointXBtn) {

        }

        k++;
        count_flag++;
        return false;

    }

    public int getTotalColuna() {
        return totalColuna;
    }

    public void setTotalColuna(int totalColuna) {
        this.totalColuna = totalColuna;
    }

    public JPanel[][] getListBtns() {
        return listBtns;
    }

    public void setListBtns(JPanel[][] listBtns) {
        this.listBtns = listBtns;
    }

    public JPanel getPanelBtn() {
        return panelBtn;
    }

    public void setPanelBtn(JPanel panelBtn) {
        this.panelBtn = panelBtn;
    }

}
