/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import ao.co.proevolution.baccarat.bean.ParametroBean;
import ao.co.proevolution.baccarat.enumerador.ParametroDesignacao;
import ao.co.proevolution.baccarat.enumerador.TipoMensagem;
import ao.co.proevolution.baccarat.model.Parametro;
import java.io.File;
import java.sql.Connection;

import java.util.List;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperPrintManager;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.view.JasperViewer;
//import org.apache.commons.collections.map.HashedMap;

/**
 *
 * @author celso
 */
public abstract class GenericReport {

   public String getValor(ParametroDesignacao designacao) throws Exception {
        
        ParametroBean parametroBean = new ParametroBean();
        Parametro p = parametroBean.findByDesignacao(designacao);
        
        if (p != null) {
            
            return p.getValor();
        }
        return null;
    }
//    public TipoMensagem report(String relatorio, Connection connection, HashedMap hashMap) {
//
//        File file = new File(relatorio).getAbsoluteFile();
//        String obterCaminho = file.getAbsolutePath();

//        try {

//            JasperPrint jasperPrint = JasperFillManager.fillReport(obterCaminho, hashMap, connection);
//          
//            if (jasperPrint.getPages().size() >= 1) {
//
//                JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
//                jasperViewer.setVisible(true);
//                return TipoMensagem.SUCESSO;
//
//            } else {
//                return TipoMensagem.FOLHA_VAZIA;
//            }
//        } catch (JRException jex) {
//            jex.printStackTrace();
//            return TipoMensagem.ERRO_MOSTRAT_RELATORIO;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return TipoMensagem.ERRO_MOSTRAT_RELATORIO;
//        }

//    }
//    public TipoMensagem report(String relatorio, HashedMap hashMap,List<?> dataSource) {
//
//        File file = new File(relatorio).getAbsoluteFile();
//        String obterCaminho = file.getAbsolutePath();
//
//        try {
//
//            JasperPrint jasperPrint = JasperFillManager.fillReport(obterCaminho, hashMap,  new JRBeanCollectionDataSource(dataSource));
//          
//            if (jasperPrint.getPages().size() >= 1) {
//
//                JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
//                jasperViewer.setVisible(true);
//                return TipoMensagem.SUCESSO;
//
//            } else {
//                return TipoMensagem.FOLHA_VAZIA;
//            }
//        } catch (JRException jex) {
//            jex.printStackTrace();
//            return TipoMensagem.ERRO_MOSTRAT_RELATORIO;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return TipoMensagem.ERRO_MOSTRAT_RELATORIO;
//        }
//
//    }
//
//    public TipoMensagem report(String relatorio, Connection connection, HashedMap hashMap, boolean isPrintDireito) {
//
//        File file = new File(relatorio).getAbsoluteFile();
//        String obterCaminho = file.getAbsolutePath();
//
//        System.out.println("obterCaminho >>" + obterCaminho);
//        try {
//
//            JasperPrint jasperPrint = JasperFillManager.fillReport(obterCaminho, hashMap, connection);
//
//            if (isPrintDireito) {
//                
//                int numPagina = jasperPrint.getPages().size();
//                JasperPrintManager.printPages(jasperPrint, 0, numPagina - 1, false);
//                return TipoMensagem.SUCESSO;
//
//            } else if (jasperPrint.getPages().size() >= 1) {
//
//                JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
//                jasperViewer.setVisible(true);
//                return TipoMensagem.SUCESSO;
//
//            } else {
//                return TipoMensagem.FOLHA_VAZIA;
//            }
//        } catch (JRException jex) {
//            jex.printStackTrace();
//            return TipoMensagem.ERRO_MOSTRAT_RELATORIO;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return TipoMensagem.ERRO_MOSTRAT_RELATORIO;
//        }
//
//    }
//
//    public TipoMensagem reportDireito(String relatorio, Connection connection, HashedMap hashMap) {
//
//        File file = new File(relatorio).getAbsoluteFile();
//        String obterCaminho = file.getAbsolutePath();
//
//        System.out.println("obterCaminho >>" + obterCaminho);
//        try {
//
//            JasperPrint jasperPrint = JasperFillManager.fillReport(obterCaminho, hashMap, connection);
//            int numPagina = jasperPrint.getPages().size();
//
//            if (jasperPrint.getPages().size() >= 1) {
//
//                for (int i = 0; i < 2; i++) {
//                    JasperPrintManager.printPages(jasperPrint, 0, numPagina - 1, false);
//                }
//                return TipoMensagem.SUCESSO;
//
//            } else {
//                return TipoMensagem.FOLHA_VAZIA;
//            }
//        } catch (JRException jex) {
//            jex.printStackTrace();
//            return TipoMensagem.ERRO_MOSTRAT_RELATORIO;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return TipoMensagem.ERRO_MOSTRAT_RELATORIO;
//        }
//
//    }
//    public TipoMensagem reportDireito(String relatorio, Connection connection, HashedMap hashMap,int numvias) {
//
//        File file = new File(relatorio).getAbsoluteFile();
//        String obterCaminho = file.getAbsolutePath();
//
//        System.out.println("obterCaminho >>" + obterCaminho);
//        try {
//
//            JasperPrint jasperPrint = JasperFillManager.fillReport(obterCaminho, hashMap, connection);
//            int numPagina = jasperPrint.getPages().size();
//
//            if (jasperPrint.getPages().size() >= 1) {
//
//                for (int i = 1; i <= numvias; i++) {
//                    JasperPrintManager.printPages(jasperPrint, 0, numPagina - 1, false);
//                }
//                return TipoMensagem.SUCESSO;
//
//            } else {
//                return TipoMensagem.FOLHA_VAZIA;
//            }
//        } catch (JRException jex) {
//            jex.printStackTrace();
//            return TipoMensagem.ERRO_MOSTRAT_RELATORIO;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return TipoMensagem.ERRO_MOSTRAT_RELATORIO;
//        }
//
//    }
//
//    public TipoMensagem reportExport(String relatorio, Connection connection, HashedMap hashMap) {
//
//        File file = new File(relatorio).getAbsoluteFile();
//        String obterCaminho = file.getAbsolutePath();
//
//        try {
//
//            JasperPrint jasperPrint = JasperFillManager.fillReport(obterCaminho, hashMap, connection);
//
//            if (jasperPrint.getPages().size() >= 1) {
//
//                JasperExportManager.exportReportToPdf(jasperPrint);
//                return TipoMensagem.SUCESSO;
//
//            } else {
//                return TipoMensagem.FOLHA_VAZIA;
//            }
//        } catch (JRException jex) {
//            jex.printStackTrace();
//            return TipoMensagem.ERRO_MOSTRAT_RELATORIO;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return TipoMensagem.ERRO_MOSTRAT_RELATORIO;
//        }
//
//    }
}
