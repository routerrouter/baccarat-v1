/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import java.io.Serializable;

public class FileMangerModel implements Serializable {

  
    private String user = "postgres";
    private String password="root";
    private String driver = "org.postgresql.Driver";
    private String ip = "localhost";

    public FileMangerModel() {
    }
    
    
    
    public FileMangerModel(String ip,String user,String password){
        
        
        this.user = user;
        this.ip = ip ;
        this.password = password;
        
        
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    
    


   

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

  

    public boolean isEmpty() {

        return ip.isEmpty() || user.isEmpty() || driver.isEmpty();
    }

}
