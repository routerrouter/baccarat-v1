/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baccarat.ui;

import ao.co.proevolution.baccarat.bean.MediaBean;
import ao.co.proevolution.baccarat.enumerador.TipoMedia;
import ao.co.proevolution.baccarat.enumerador.TipoMensagem;
import ao.co.proevolution.baccarat.model.Media;
import ao.co.proevolution.baccarat.util.ComputerInfoUtil;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import ao.co.proevolution.baccarat.util.CopyFileUtil;
import ao.co.proevolution.baccarat.util.DefinirCorUtil;
import ao.co.proevolution.baccarat.util.ManipularImagem;
import ao.co.proevolution.baccarat.util.Mp4PlayerUtil;

/**
 *
 * @author filme
 */
public class MediaView extends javax.swing.JFrame {

    /**
     * Creates new form MediaView
     */
    private DefinirCorUtil definirCorUtil;

    private MediaBean mesaBean;
    private Media model = new Media();

    public MediaView() {
        initComponents();
        init();
        iconeSistema();

    }
 public void iconeSistema() {
        URL caminho = this.getClass().getResource("icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminho);
        this.setIconImage(iconeTitulo);
    }
    private void init() {

        //DEFINIR COR COMPONENTE
        definirCorUtil = new DefinirCorUtil();
        definirCorUtil.backGroundComponte(panelRodape);
        definirCorUtil.backGroundComponte(panelTopo);

        //INIT OBJECT
        //CHAMADA DE METODO
        carregar();
        carregarTipo();

    }
private void carregarTipo(){
    
    List<TipoMedia> lista =new ArrayList();
    lista.add(TipoMedia.IMAGEM);
    lista.add(TipoMedia.VIDEO);
    
    cboTipoMedia.setModel(new DefaultComboBoxModel(lista.toArray()));
    
}
    private void carregar() {

        try {
            DefaultTableModel tb = (DefaultTableModel) tbMedia.getModel();

            tb.setRowCount(0);

            mesaBean = new MediaBean();
            List<Media> lista = mesaBean.findAll();

            for (Media m : lista) {

                tb.addRow(new Object[]{
                    m,
                    m.getName(),
                    m.getDuracao_segundo()

                });

            }

        } catch (Exception ex) {
            Logger.getLogger(MediaView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Integer getValue(String value) {

        if (value != null) {

            if (!value.trim().isEmpty()) {

                return Integer.parseInt(value.trim());
            }

        }

        return 0;

    }

    private void salva() {

        try {

            model.setDuracao_segundo(Integer.parseInt(txtDuracao.getText().trim()));

            mesaBean = new MediaBean();
            mesaBean.setModel(model);
            TipoMensagem mensagem = mesaBean.saveOrUpdate();

            if (mensagem == TipoMensagem.SUCESSO) {

                JOptionPane.showMessageDialog(this, "Operação Realizada com Sucesso");
                jTabbedPane1.setSelectedIndex(0);
                carregar();
                model = new Media();
                limpar();
            }

        } catch (Exception ex) {
            Logger.getLogger(MediaView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void editar() {

        model = select();

        if (model != null) {

            carregarDado(model);
            jTabbedPane1.setSelectedIndex(1);

        }

    }

    private Media select() {

        int row = tbMedia.getSelectedRow();
        if (row >= 0) {
            Media model = (Media) tbMedia.getValueAt(row, 0);

            return model;
        } else {
            JOptionPane.showMessageDialog(this, "Selecione a Media", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

        return null;
    }

    private void carregarDado(Media model) {

        cboTipoMedia.setSelectedItem(model.getTipo_media());
        txtDuracao.setText(String.valueOf(model.getDuracao_segundo()));
        preViewFile(model.getTipo_media(), model.getName());

    }
    
    private void limpar(){
        new MediaView().setVisible(true);
        this.dispose();
    }

    private void delele() {

        try {
            model = select();

            if (model != null) {

                int op = JOptionPane.showConfirmDialog(this, "Deseja Realmente Eliminar a Media ?", "Alerta", JOptionPane.YES_NO_OPTION);

                if (op == JOptionPane.YES_OPTION) {

                    mesaBean = new MediaBean();
                    mesaBean.setModel(model);

                    TipoMensagem mensagem = mesaBean.delete();

                    if (mensagem == TipoMensagem.SUCESSO) {

                        JOptionPane.showMessageDialog(this, "Operação Realizada com Sucesso");

                        carregar();
                        model = null;

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(MediaView.class.getName()).log(Level.SEVERE, null, ex);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMedia = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        cboTipoMedia = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        lblImagem = new javax.swing.JLabel();
        btnCarregarLogoTipo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtDuracao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        panelTopo.setBackground(new java.awt.Color(0, 0, 0));
        panelTopo.setPreferredSize(new java.awt.Dimension(367, 28));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MEDIA");

        javax.swing.GroupLayout panelTopoLayout = new javax.swing.GroupLayout(panelTopo);
        panelTopo.setLayout(panelTopoLayout);
        panelTopoLayout.setHorizontalGroup(
            panelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTopoLayout.setVerticalGroup(
            panelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
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

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbMedia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Ficheiro", "Duracao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbMedia);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/btn/icons8-edit-30.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/btn/icons8-remove-30.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar))
                .addGap(45, 45, 45))
        );

        jTabbedPane1.addTab("Lista", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Tipo de Media");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/btn/icons8-save-30.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        lblImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/logo_baccarat.png"))); // NOI18N
        lblImagem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblImagem, java.awt.BorderLayout.CENTER);

        btnCarregarLogoTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/IPesquisa.png"))); // NOI18N
        btnCarregarLogoTipo.setText("Carregar Logotipo");
        btnCarregarLogoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarLogoTipoActionPerformed(evt);
            }
        });

        jLabel3.setText("Tempo de Visualizar(Segundo)");

        txtDuracao.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboTipoMedia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCarregarLogoTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(txtDuracao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cboTipoMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnCarregarLogoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registar", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
            .addComponent(panelRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salva();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:

        editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        delele();
    }//GEN-LAST:event_btnEliminarActionPerformed
    public void addLogotipo() {
        String correspon = "";

        String logotipo = "";

        try {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "PDF & PNG Images", "pdf", "png", "jpg", "gif", "tif");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(this);
            String pathFinal;

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File f = chooser.getSelectedFile();
                pathFinal = f.getAbsolutePath();

                correspon = f.getName();

                String aux = f.getName();
                logotipo = aux;

                String file = null;

                if (!logotipo.trim().isEmpty()) {
                    file = logotipo;
                }
                //aux = "BannerFarmaciaSaudePopular.jpg";

                TipoMedia tipoMedia = (TipoMedia) cboTipoMedia.getSelectedItem();
                model.setTipo_media(tipoMedia);

                if (tipoMedia == TipoMedia.IMAGEM) {

                    File fileDistino = new File("imagem\\slide\\" + aux);

                    CopyFileUtil.copiarArquivos(f, fileDistino);

                    ManipularImagem.setImagemDimensao(f.getAbsolutePath(), 160, 160);

                    lblImagem.setIcon(new ImageIcon(file));
                } else {

                    File fileDistino = new File("video\\" + aux);

                    CopyFileUtil.copiarArquivos(f, fileDistino);

                    jPanel1.removeAll();
                    Mp4PlayerUtil mp4PlayerUtil = new Mp4PlayerUtil(jPanel1, pathFinal);
                    mp4PlayerUtil.autoPlay();
                }

                model.setName(aux);

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    private void preViewFile(TipoMedia tipoMedia, String name) {

        if (tipoMedia == TipoMedia.IMAGEM) {

            File fileDistino = new File("imagem\\slide\\" + name);

            ManipularImagem.setImagemDimensao(fileDistino.getAbsolutePath(), 160, 160);

            lblImagem.setIcon(new ImageIcon(fileDistino.getAbsolutePath()));
        } else {

            File fileDistino = new File("video\\" + name);

            jPanel1.removeAll();
            Mp4PlayerUtil mp4PlayerUtil = new Mp4PlayerUtil(jPanel1, fileDistino.getAbsolutePath());
            mp4PlayerUtil.autoPlay();
        }

    }
    private void btnCarregarLogoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarLogoTipoActionPerformed
        //        JFileChooser fc = new JFileChooser();
        //        int res = fc.showOpenDialog(null);
        //
        //        if (res == JFileChooser.APPROVE_OPTION) {
        //            arquivo = fc.getSelectedFile();
        //
        //            try {
        //                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 160, 160);
        //
        //                lblImagem.setIcon(new ImageIcon(imagem));
        //
        //            } catch (Exception ex) {
        //                // System.out.println(ex.printStackTrace().toString());
        //            }
        //
        //        } else {
        //            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        //        }

        addLogotipo();
    }//GEN-LAST:event_btnCarregarLogoTipoActionPerformed

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
            java.util.logging.Logger.getLogger(MediaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MediaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MediaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MediaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new MediaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarregarLogoTipo;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cboTipoMedia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JPanel panelRodape;
    private javax.swing.JPanel panelTopo;
    private javax.swing.JTable tbMedia;
    private javax.swing.JTextField txtDuracao;
    // End of variables declaration//GEN-END:variables
}
