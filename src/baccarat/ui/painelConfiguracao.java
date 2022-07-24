/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baccarat.ui;

import ao.co.proevolution.baccarat.bean.CorBean;
import ao.co.proevolution.baccarat.util.CopyFileUtil;
import ao.co.proevolution.baccarat.bean.ParametroBean;
import ao.co.proevolution.baccarat.enumerador.ParametroDesignacao;
import ao.co.proevolution.baccarat.model.Cor;
import ao.co.proevolution.baccarat.model.Parametro;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import ao.co.proevolution.baccarat.util.ManipularImagem;

/**
 *
 * @author Rufino Domingos
 */
public class painelConfiguracao extends javax.swing.JDialog {

    /**
     * Creates new form painelConfiguracao
     */
    BufferedImage imagem;
    private String urlImage = "/baccarat/imagem/";
    private final String IMG_NAME = "image.jpg";
    File arquivo;
    String img_name;
    
    public painelConfiguracao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.iconeSistema();
        carregarConfig();
        carregarCores();
    }
    
    public void iconeSistema() {
        URL caminho = this.getClass().getResource("icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminho);
        this.setIconImage(iconeTitulo);
    }
    
    private void carregarCores() {
        
        CorBean bean = new CorBean();
        try {
            
            List<Cor> lista = bean.findAll();
            cboCores.setModel(new DefaultComboBoxModel(lista.toArray()));
            
            Cor model = bean.findCorUse();
            
            cboCores.setSelectedItem(model);
            
        } catch (Exception ex) {
            Logger.getLogger(painelConfiguracao.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboCores = new javax.swing.JComboBox<>();
        txtValorMaximoAposta = new javax.swing.JTextField();
        txtValorMinimoAposta = new javax.swing.JTextField();
        txtMaximoEmpate = new javax.swing.JTextField();
        txtMinimoEmpate = new javax.swing.JTextField();
        lblImagem = new javax.swing.JLabel();
        btnCarregarLogoTipo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtMaximoNaturais = new javax.swing.JTextField();
        txtMinimoNaturais = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblSalvar = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMinimoPares = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMaximoPares = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Painel de Configurações");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Máximo de Aposta por Mesa:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Minimo de aposta po Mesa:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Máximo de Empates:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cor de Fundo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 90, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Minimo de Empates:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 170, 20));

        getContentPane().add(cboCores, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 220, -1));

        txtValorMaximoAposta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtValorMaximoAposta.setText("0");
        getContentPane().add(txtValorMaximoAposta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 190, -1));

        txtValorMinimoAposta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtValorMinimoAposta.setText("0");
        getContentPane().add(txtValorMinimoAposta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 190, -1));

        txtMaximoEmpate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMaximoEmpate.setText("0");
        getContentPane().add(txtMaximoEmpate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 190, -1));

        txtMinimoEmpate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMinimoEmpate.setText("0");
        getContentPane().add(txtMinimoEmpate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 190, -1));

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/logo_baccarat.png"))); // NOI18N
        lblImagem.setText("jLabel8");
        lblImagem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        getContentPane().add(lblImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 220, 210));

        btnCarregarLogoTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/IPesquisa.png"))); // NOI18N
        btnCarregarLogoTipo.setText("Carregar Logotipo");
        btnCarregarLogoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarLogoTipoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarregarLogoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 220, 50));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Máximo de Naturais");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 170, 20));

        txtMaximoNaturais.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMaximoNaturais.setText("0");
        getContentPane().add(txtMaximoNaturais, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 190, -1));

        txtMinimoNaturais.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMinimoNaturais.setText("0");
        getContentPane().add(txtMinimoNaturais, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 190, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Minimo de Naturais");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 170, 20));

        lblSalvar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblSalvar.setForeground(new java.awt.Color(255, 255, 255));
        lblSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/itemGuardar.png"))); // NOI18N
        lblSalvar.setText("Salvar");
        lblSalvar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        lblSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalvarMouseClicked(evt);
            }
        });
        getContentPane().add(lblSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 170, 30));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Minimo de Pares");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 170, 20));

        txtMinimoPares.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMinimoPares.setText("0");
        getContentPane().add(txtMinimoPares, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 190, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Maximo de Pares");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, 20));

        txtMaximoPares.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMaximoPares.setText("0");
        getContentPane().add(txtMaximoPares, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 190, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baccarat/icons/fundo_config.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        setSize(new java.awt.Dimension(718, 433));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
    
    private void salvarParametro() throws Exception {
        
        ParametroBean parametroBean = new ParametroBean();
        
        parametroBean.update(ParametroDesignacao.VALOR_MAXIMO_APOSTA_POR_MESA, Double.parseDouble(txtValorMaximoAposta.getText()));
        parametroBean.update(ParametroDesignacao.VALOR_MINIMO_APOSTA_POR_MESA, Double.parseDouble(txtValorMinimoAposta.getText()));
        
        parametroBean.update(ParametroDesignacao.MAXIMO_EMPATE, Double.parseDouble(txtMaximoEmpate.getText()));
        parametroBean.update(ParametroDesignacao.MINIMO_EMPATE, Double.parseDouble(txtMinimoEmpate.getText()));
        
        parametroBean.update(ParametroDesignacao.MAXIMO_NATURAIS, Double.parseDouble(txtMaximoNaturais.getText()));
        parametroBean.update(ParametroDesignacao.MINIMO_NATURAIS, Double.parseDouble(txtMinimoNaturais.getText()));
        
        parametroBean.update(ParametroDesignacao.MAXIMO_PARES, Double.parseDouble(txtMaximoPares.getText()));
        parametroBean.update(ParametroDesignacao.MINIMO_PARES, Double.parseDouble(txtMaximoPares.getText()));
        
        System.out.println("img_name");
       // parametroBean.update(ParametroDesignacao.NUMERO_MESA, Double.parseDouble(txtNumeroMesas.getText()));
        parametroBean.update(ParametroDesignacao.LOGO_TIPO, img_name);
        
    }
    
    String getValor(ParametroDesignacao designacao) throws Exception {
        
        ParametroBean parametroBean = new ParametroBean();
        Parametro p = parametroBean.findByDesignacao(designacao);
        
        if (p != null) {
            
            return p.getValor();
        }
        return null;
    }
    
    void carregarConfig() {
        
        try {
            txtValorMaximoAposta.setText(getValor(ParametroDesignacao.VALOR_MAXIMO_APOSTA_POR_MESA));
            txtValorMinimoAposta.setText(getValor(ParametroDesignacao.VALOR_MINIMO_APOSTA_POR_MESA));
            txtMaximoEmpate.setText(getValor(ParametroDesignacao.MAXIMO_EMPATE));
            txtMinimoEmpate.setText(getValor(ParametroDesignacao.MINIMO_EMPATE));
            txtMaximoNaturais.setText(getValor(ParametroDesignacao.MAXIMO_NATURAIS));
            txtMinimoNaturais.setText(getValor(ParametroDesignacao.MINIMO_NATURAIS));
            txtMaximoPares.setText(getValor(ParametroDesignacao.MAXIMO_PARES));
            txtMinimoPares.setText(getValor(ParametroDesignacao.MINIMO_PARES));
//            txtNumeroMesas.setText(getValor(ParametroDesignacao.NUMERO_MESA));
            
            String img = getValor(ParametroDesignacao.LOGO_TIPO);
            
            if (img != null) {
                if (!img.trim().equals("0")) {
                    
                    String path = "imagem\\" + img;
                    
                    imagem = ManipularImagem.setImagemDimensao(path, 160, 160);
                    
                    lblImagem.setIcon(new ImageIcon(imagem));
                    
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(painelConfiguracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void definirCorUsar(){
        
        try {
            CorBean bean = new CorBean();
            Cor model = (Cor) cboCores.getSelectedItem();
            bean.definirCorUsar(model);
        } catch (Exception ex) {
            Logger.getLogger(painelConfiguracao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
                
                if (!logotipo.trim().isEmpty()) {
                    img_name = logotipo;
                }
                //aux = "BannerFarmaciaSaudePopular.jpg";

                File fileDistino = new File("imagem\\" + aux);
                
                CopyFileUtil.copiarArquivos(f, fileDistino);
                
                imagem = ManipularImagem.setImagemDimensao(f.getAbsolutePath(), 160, 160);
                
                lblImagem.setIcon(new ImageIcon(imagem));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
        
    }
    
    private void manipularImagem() {
        
        try {

            //aux = "BannerFarmaciaSaudePopular.jpg";
            File destino = new File("imagem/");
            
            img_name = arquivo.getName();
            
            if (!destino.exists()) {
                destino.mkdir();
            }
            
            CopyFileUtil.copiarArquivos(arquivo, destino);
            
        } catch (IOException ex) {
            Logger.getLogger(painelConfiguracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void copiarImagem() {
        
        try {
            // TODO add your handling code here:
            String caminho = getClass().getResource(urlImage).toString().substring(5);
            File outputfile = new File(caminho + IMG_NAME);
            ImageIO.write(imagem, "jpg", outputfile);
            
            JOptionPane.showMessageDialog(rootPane, "Imagem enviada com sucesso");
            
        } catch (IOException ex) {
            //Logger.getLogger(EnviarImagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void lblSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalvarMouseClicked
        
        try {
            //     manipularImagem();
            salvarParametro();
            definirCorUsar();
            JOptionPane.showMessageDialog(this, "Operação realizada com sucesso");
        } catch (Exception ex) {
            Logger.getLogger(painelConfiguracao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblSalvarMouseClicked

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
            java.util.logging.Logger.getLogger(painelConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(painelConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(painelConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(painelConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                painelConfiguracao dialog = new painelConfiguracao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarregarLogoTipo;
    private javax.swing.JComboBox<String> cboCores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblSalvar;
    private javax.swing.JTextField txtMaximoEmpate;
    private javax.swing.JTextField txtMaximoNaturais;
    private javax.swing.JTextField txtMaximoPares;
    private javax.swing.JTextField txtMinimoEmpate;
    private javax.swing.JTextField txtMinimoNaturais;
    private javax.swing.JTextField txtMinimoPares;
    private javax.swing.JTextField txtValorMaximoAposta;
    private javax.swing.JTextField txtValorMinimoAposta;
    // End of variables declaration//GEN-END:variables
}