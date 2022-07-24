/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.report;

import ao.co.proevolution.baccarat.dao.ApostaDao;
import ao.co.proevolution.baccarat.enumerador.ParametroDesignacao;
import ao.co.proevolution.baccarat.util.ConnectionFactory;
import ao.co.proevolution.baccarat.util.GenericReport;
import java.io.File;
import java.sql.Connection;
//import org.apache.commons.collections.map.HashedMap;

/**
 *
 * @author filme
 */
public class ApostaReport extends GenericReport {

    private ApostaDao dao;

    public void printAll() throws Exception {

//        HashedMap hashMap = new HashedMap();
//        String img = getValor(ParametroDesignacao.LOGO_TIPO);
//        File fileLogo = new File("imagem/" + img);
//        hashMap.put("LOGO", fileLogo.getAbsolutePath());
//        Connection con = ConnectionFactory.getConnection();
//        String path = "relatorio/aposta/ListaApostadoresMesa.jasper";
//        this.report(path, con, hashMap);

    }

}
