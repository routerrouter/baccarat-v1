/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import baccarat.ui.ConfigDatabaseView;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static Connection conn;

    private static String ip;
    private static String drive;
    private static String user;
    private static String password;

    public static Connection getConnection() {
        if (conn == null) {

            try {

                try {

                    FileManager<FileMangerModel> file = new FileManager<FileMangerModel>("configDatabase.data");
                    List<FileMangerModel> lista = file.getAll();

                    if (lista != null) {

                        if (!lista.isEmpty()) {

                            FileMangerModel modelo = lista.get(0);

                            if (modelo != null) {

                                ip = modelo.getIp();
                                drive = modelo.getDriver();
                                user = modelo.getUser();
                                password = modelo.getPassword();

                            }

                        } else {

                            FileMangerModel modelo = new FileMangerModel();
                            ip = modelo.getIp();
                            drive = modelo.getDriver();
                            user = modelo.getUser();
                            password = modelo.getPassword();

                        }
                    } else {

                        FileMangerModel modelo = new FileMangerModel();
                        ip = modelo.getIp();
                        drive = modelo.getDriver();
                        user = modelo.getUser();
                        password = modelo.getPassword();

                    }

                } catch (Exception ex) {
                    Logger.getLogger(ConfigDatabaseView.class.getName()).log(Level.SEVERE, null, ex);
                }

//                Configuracao cm =  new Configuracao().ler("file");
                Class.forName(drive);
//                conn = java.sql.DriverManager.getConnection("jdbc:postgresql://localhost:5432/gestaoGarrafas", "postgres", "1234");
//                conn = java.sql.DriverManager.getConnection(ConfigDBUtil.JDBC_URL, ConfigDBUtil.USER_NAME, ConfigDBUtil.PASS_WORD);
                conn = java.sql.DriverManager.getConnection("jdbc:postgresql://" + ip + ":5432/baccarat", user, password);
// conn = java.sql.DriverManager.getConnection("jdbc:postgresql://10.10.10.50:5432/gestaoGarrafas", "postgres", "devtec2017");

            } catch (ClassNotFoundException ex) {
                System.out.println("Erro ConnectFactory: " + ex);
//                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return conn;
    }

}
