/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import ao.co.proevolution.baccarat.model.Cliente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//
//import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author filme
 */
public class ExcelUtil {

    private static int lastRow = 0;
    private static int lastCell = 0;
    private static int indexCountColumn = 0;
    private static int index = 0;

    private static List<Cliente> lista = new ArrayList();
    private static Cliente model;

    public static void main(String[] args) {

        try {
            int rowStart = 3;
          List<Cliente> lista =  read(3,4,2,3,2, rowStart,"C:\\Users\\filme\\Downloads\\relatorio (5).xls");
          
          for(int i = 0 ; i < lista.size() ; i++){
              
              System.out.println(lista.get(i));
              
          }
          
        } catch (Exception ex) {
            Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    public static List<Cliente> read(int indexNome, int indexTelefone, int indexEmail, int indexNif, int indexEndereco, int rowStart, String file) throws Exception {

//        Workbook workbook = new HSSFWorkbook(new FileInputStream(new File(file)));
//
//        Sheet sheet = workbook.getSheetAt(0);
//        lastRow = sheet.getLastRowNum();
//
//        sheet.forEach((row) -> {
//            lastCell = row.getLastCellNum();
//
//            
//            indexCountColumn = 0;
//            model = new Cliente();
//            row.forEach((cell) -> {
//
//                String valor = cell.getStringCellValue();
//                if (indexCountColumn == indexNome) {
//
//                    model.setNome(valor);
//
//                } else if (indexCountColumn == indexTelefone) {
//
//                    model.setTelefone(valor);
//
//                } else if (indexCountColumn == indexEndereco) {
//
//                    model.setEndereco(valor);
//
//                } else if (indexCountColumn == indexNif) {
//
//                    model.setNif(valor);
//
//                } else if (indexCountColumn == indexEmail) {
//
//                    model.setEmail(valor);
//
//                }
//                indexCountColumn++;
//            });
//            
//            lista.add(model);
//        });
        /*
        Cell cell = sheet.createRow(lastRow + 2)
                .createCell(lastCell++);
        cell.setCellType(CellType.STRING.getCode());
        cell.setCellValue("b5");*/

        //  workbook.write(new FileOutputStream(new File(FILE)));
        
        return lista;
    }

}
