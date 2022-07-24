/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.report;

import ao.co.proevolution.baccarat.dao.ClienteDao;
import ao.co.proevolution.baccarat.enumerador.ParametroDesignacao;
import ao.co.proevolution.baccarat.enumerador.TipoMensagem;
import ao.co.proevolution.baccarat.model.Cliente;
import ao.co.proevolution.baccarat.util.GenericReport;
import java.io.File;
import java.util.HashMap;
import java.util.List;
//import org.apache.commons.collections.map.HashedMap;

/**
 *
 * @author filme
 */
public class ClienteReport extends GenericReport {

    private ClienteDao dao;

    public void printAll() throws Exception {

        dao = new ClienteDao();
        List<Cliente> lista = dao.findAll();

//        HashedMap hashMap = new HashedMap();
//        String img = getValor(ParametroDesignacao.LOGO_TIPO);
//        File fileLogo = new File("imagem/" + img);
//        hashMap.put("LOGO", fileLogo.getAbsolutePath());
//
//        String path = "relatorio/cliente/ListaCliente.jasper";
//        this.report(path, hashMap, lista);

    }

}
