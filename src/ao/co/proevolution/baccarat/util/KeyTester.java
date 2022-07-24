/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import baccarat.ui.MainTable;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author INE
 */
public class KeyTester extends AbstractAction {

    public KeyTester() {
    }

//    static class MyActionListener extends AbstractAction {
//
//        public MyActionListener() {
//        }
//
//       
//        MyActionListener(String s) {
//            super(s);
//        }
    public void actionPerformed(ActionEvent e) {
        MainTable home = new MainTable();
//        home.setar();
        System.out.println("ttt");
        System.out.println(getValue(Action.NAME));
//        JOptionPane.showMessageDialog(null, "teste");
    }

    public static void main(String[] args) {
//        String actionKey = "theAction";
//        JFrame f = new JFrame("Key Tester");
////        JButton jb1 = new JButton();
//        JPanel jb1 = new JPanel();
//       
//        Container pane = f.getContentPane();
//        pane.add(jb1, BorderLayout.NORTH);
//       
//
//        KeyStroke stroke = KeyStroke.getKeyStroke("typed B");
//
//        // Defaults to JComponent.WHEN_FOCUSED map
//        InputMap inputMap = jb1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
//
//        stroke = KeyStroke.getKeyStroke("F1");
//        Action action = new KeyTester();
//        ActionMap actionMap = jb1.getActionMap();
//        inputMap.put(stroke, actionKey);
//        actionMap.put(actionKey, action);
//
//        f.show();
    }
}
