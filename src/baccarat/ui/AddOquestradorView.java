/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baccarat.ui;

import ao.co.proevolution.baccarat.bean.LogApostaOquestradorBean;
import ao.co.proevolution.baccarat.bean.MesaBean;
import ao.co.proevolution.baccarat.bean.OquestradorBean;
import ao.co.proevolution.baccarat.enumerador.StatusMesa;
import ao.co.proevolution.baccarat.enumerador.TipoMensagem;
import ao.co.proevolution.baccarat.model.Aposta;
import ao.co.proevolution.baccarat.model.LogApostaOquestrador;
import ao.co.proevolution.baccarat.model.Mesa;
import ao.co.proevolution.baccarat.model.Oquestrador;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ao.co.proevolution.baccarat.util.DefinirCorUtil;

/**
 *
 * @author filme
 */
public class AddOquestradorView extends javax.swing.JFrame {

    /**
     * Creates new form CorView
     */
    private DefinirCorUtil definirCorUtil;

    private LogApostaOquestradorBean mesaBean;
    private LogApostaOquestrador model = new LogApostaOquestrador();

    private Aposta _aposta;
    private boolean isUse = false;

    public AddOquestradorView() {
        initComponents();
        init();
        iconeSistema();

    }
 public void iconeSistema() {
        URL caminho = this.getClass().getResource("icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminho);
        this.setIconImage(iconeTitulo);
    }
    public AddOquestradorView(Aposta aposta) {
        initComponents();
        init();
        _aposta = aposta;
        mesaPausa();
        iconeSistema();

    }

    public AddOquestradorView(Aposta aposta, Boolean isUse) {
        initComponents();
        init();
        _aposta = aposta;
        this.isUse = isUse;
        mesaPausa();
        iconeSistema();

    }

    private void init() {

        //DEFINIR COR COMPONENTE
        definirCorUtil = new DefinirCorUtil();
        definirCorUtil.backGroundComponte(panelRodape);
        definirCorUtil.backGroundComponte(panelTopo);

        //INIT OBJECT
        //CHAMADA DE METODO
    }

    private void mesaPausa() {

        try {
            Mesa mesa = _aposta.getMesa();
            mesa.setStatus_mesa(StatusMesa.PAUSA_TROCA_OQUESTRADOR);

            MesaBean bean = new MesaBean();
            bean.setModel(mesa);
            bean.saveOrUpdate();
        } catch (Exception ex) {
            Logger.getLogger(AddOquestradorView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void mesaOnline() {

        try {
            Mesa mesa = _aposta.getMesa();
            mesa.setStatus_mesa(StatusMesa.ONLINE);

            MesaBean bean = new MesaBean();
            bean.setModel(mesa);
            bean.saveOrUpdate();
        } catch (Exception ex) {
            Logger.getLogger(AddOquestradorView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Oquestrador autenticacao() {

        OquestradorBean bean = new OquestradorBean();
        
        System.out.println("");
        
        return bean.findByUsuarioSenha(txtUsuario.getText(), String.valueOf(txtSenha.getPassword()));

    }

    private boolean isOquestradorOutraMesa(Oquestrador modelo) {

        if (modelo != null) {

            LogApostaOquestradorBean apostaOquestradorBean = new LogApostaOquestradorBean();
            try {
                LogApostaOquestrador logApostaOquestrador = apostaOquestradorBean.findByOquestrador(modelo, _aposta.getMesa());

                return logApostaOquestrador != null;

            } catch (Exception ex) {
                Logger.getLogger(AddOquestradorView.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return false;

    }

    private void salva() {

        try {

            model.setAposta(_aposta);
            model.setOquestrador(autenticacao());

            if (model.getOquestrador() != null) {

                if (!isOquestradorOutraMesa(model.getOquestrador())) {

                   
                    model.getOquestrador().setData_ultima_check(new Date());
                    model.getOquestrador().getData_ultima_check().setMinutes(model.getOquestrador().getData_ultima_check().getMinutes() + 15); //AUMENTAR 15 MINUTOS

                    mesaBean = new LogApostaOquestradorBean();
                    mesaBean.setModel(model);

                    mesaBean.desactivar(_aposta.getMesa());

                    TipoMensagem mensagem = mesaBean.saveOrUpdate();

                    if (mensagem == TipoMensagem.SUCESSO) {

                        OquestradorBean oquestradorBean = new OquestradorBean();
                        oquestradorBean.setModel(model.getOquestrador());
                        oquestradorBean.saveOrUpdate();

                        mesaOnline();

                        MainTable.flagMostrarTelaOquestrador = true;
//                        home_game_video.flagMostrarTelaOquestrador = true;

                        if (!isUse) {

                            new MainTable(_aposta).setVisible(true);
//                             new home_game_video(_aposta).setVisible(true);
                        }

                        this.dispose();
                    }
                }else {
                JOptionPane.showMessageDialog(this, "Oquestrador se encontra logado em outra mesa");
            }
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha Incorrecto");
            }

        } catch (Exception ex) {
            Logger.getLogger(AddOquestradorView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTopo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelRodape = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        panelTopo.setBackground(new java.awt.Color(0, 0, 0));
        panelTopo.setPreferredSize(new java.awt.Dimension(367, 28));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INSPECTOR");

        javax.swing.GroupLayout panelTopoLayout = new javax.swing.GroupLayout(panelTopo);
        panelTopo.setLayout(panelTopoLayout);
        panelTopoLayout.setHorizontalGroup(
            panelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTopoLayout.setVerticalGroup(
            panelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopoLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        panelRodape.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelRodapeLayout = new javax.swing.GroupLayout(panelRodape);
        panelRodape.setLayout(panelRodapeLayout);
        panelRodapeLayout.setHorizontalGroup(
            panelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRodapeLayout.setVerticalGroup(
            panelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jLabel1.setText("Usuário");

        jLabel3.setText("Senha");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/btn/a77cca0bedb1df55ab2c0bddd0020bbf (1).png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
            .addComponent(panelRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1)
                        .addComponent(txtUsuario)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
         salva();
    }//GEN-LAST:event_jLabel4MouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddOquestradorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOquestradorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOquestradorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOquestradorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOquestradorView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panelRodape;
    private javax.swing.JPanel panelTopo;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
