/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import ao.co.proevolution.baccarat.bean.ParametroBean;

/**
 *
 * @author filme
 */
public class InsertDadoDefault {
    
    
    public  static void init() throws Exception{
        
        
        ParametroBean parametroBean = new ParametroBean();
        parametroBean.saveDefault();
        
        
    }
    
}
