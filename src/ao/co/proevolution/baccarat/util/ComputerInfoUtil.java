/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author filme
 */
public class ComputerInfoUtil {
    
    
    public static String getMc() {
      String macAddr = null;
        List<String> Enderecomac = new ArrayList<String>();
        StringBuilder sb = null;
        try {
            Enumeration<NetworkInterface> eth = NetworkInterface
                    .getNetworkInterfaces();
            while (eth.hasMoreElements()) {
                NetworkInterface eth0 = eth.nextElement();
                byte[] mac = eth0.getHardwareAddress();
                sb = new StringBuilder();
                if (mac != null) {
                    for (int i = 0; i < mac.length; i++) {
                        String aux = String.format("%02X%s", mac[i],
                                (i < mac.length - 1) ? "-" : "");
                        sb.append(aux);
                    }
                    if (sb.toString().length() <= 18) {
                        macAddr = sb.toString();
                    }
                    String a = String.valueOf(sb);
//                    System.out.println("Mac 1 " + sb);
                    Enderecomac.add(a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Enderecomac.get(0).toString();
    }
    
}
