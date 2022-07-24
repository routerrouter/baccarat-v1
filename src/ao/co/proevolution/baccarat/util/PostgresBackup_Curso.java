/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class PostgresBackup_Curso {
    
    private static final String PATH = "C:\\Program Files\\PostgreSQL\\11\\bin";

    public PostgresBackup_Curso() {

    }

    public static boolean realizaBackup() throws IOException, InterruptedException {
        final List<String> comandos = new ArrayList<String>();
        String dir = "C:/BKPCECOM";
        List<String> lista = new ArrayList<String>(9);
        File diretorio = new File(dir);
        File fList[] = diretorio.listFiles();
        if (fList.length == 0) {
            //comandos.add("C:\\Program Files (x86)\\PostgreSQL\\9.4\\bin\\pg_dump.exe"); //cecom
            //comandos.add("C:\\Arquivos de programas\\PostgreSQL\\9.2\\bin\\pg_dump.exe"); 
            comandos.add(PATH+"\\pg_dump.exe");

            //comandos.add("-i");      
            comandos.add("-h");
            comandos.add("localhost");
            //comandos.add("192.168.0.25");
            comandos.add("-p");
            comandos.add("5432");
            comandos.add("-U");
            comandos.add("postgres");
            comandos.add("-F");
            comandos.add("c");
            comandos.add("-b");
            comandos.add("-v");
            comandos.add("-f");

            //comandos.add("C:\\TesteHib4\\Backups do Banco de Dados\\"+JOptionPane.showInputDialog(null,"Digite o nome do Backup")+".backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
            //comandos.add("C:\\TesteHib4\\Backups do Banco de Dados\\"+(Character.getNumericValue(recebe)+1)+" "+getDateTime()+".backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
            comandos.add("C:\\BKPCECOM\\" + 1 + " " + getDateTime() + ".backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
            comandos.add("baccarat");
            ProcessBuilder pb = new ProcessBuilder(comandos);

            pb.environment().put("PGPASSWORD", ConfigDBUtil.PASS_WORD);

            try {
                final Process process = pb.start();

                final BufferedReader r = new BufferedReader(
                        new InputStreamReader(process.getErrorStream()));
                String line = r.readLine();
                while (line != null) {
                    System.err.println(line);
                    line = r.readLine();
                }
                r.close();

                process.waitFor();
                process.destroy();
                new RemoveBKP();
                return true;
                //JOptionPane.showMessageDialog(null, "backup realizado com sucesso.");

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        } else {
            for (int i = 0; i < fList.length; i++) {
                //JOptionPane.showMessageDialog(null,fList[i].getName());
                lista.add(fList[i].getName());
            }

            char recebe = Collections.max(lista).charAt(0);
            //JOptionPane.showMessageDialog(null,Character.getNumericValue(recebe)); 

            comandos.add(PATH+"\\pg_dump.exe");

            //comandos.add("-i");      
            comandos.add("-h");
            comandos.add("localhost");
            comandos.add("-p");
            comandos.add("5432");
            comandos.add("-U");
            comandos.add("postgres");
            comandos.add("-F");
            comandos.add("c");
            comandos.add("-b");
            comandos.add("-v");
            comandos.add("-f");

            //comandos.add("C:\\TesteHib4\\Backups do Banco de Dados\\"+JOptionPane.showInputDialog(null,"Digite o nome do Backup")+".backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
            //comandos.add("C:\\TesteHib4\\Backups do Banco de Dados\\"+(Character.getNumericValue(recebe)+1)+" "+getDateTime()+".backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
            comandos.add("C:\\BKPCECOM\\" + (Character.getNumericValue(recebe) + 1) + " " + getDateTime() + ".backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
            comandos.add("baccarat"); // DATABASE     
            ProcessBuilder pb = new ProcessBuilder(comandos);

            pb.environment().put("PGPASSWORD", ConfigDBUtil.PASS_WORD);

            try {
                final Process process = pb.start();

                final BufferedReader r = new BufferedReader(
                        new InputStreamReader(process.getErrorStream()));
                String line = r.readLine();
                while (line != null) {
                    System.err.println(line);
                    line = r.readLine();
                }
                r.close();

                process.waitFor();
                process.destroy();
                new RemoveBKP();
                return true;
//                JOptionPane.showMessageDialog(null, "backup realizado com sucesso.");

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        return false;
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        PostgresBackup_Curso b = new PostgresBackup_Curso();
        b.realizaBackup();
    }

    private static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy HHmm");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
