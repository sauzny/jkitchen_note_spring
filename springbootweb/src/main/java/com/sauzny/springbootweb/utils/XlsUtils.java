package com.sauzny.springbootweb.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public final class XlsUtils {

    private XlsUtils(){}
    
    /**
     * @描述: TODO
     * @param lists
     * @param dest - /mnt/a.xls
     * @返回 void
     * @创建人  ljx 创建时间 2018年3月14日 下午2:30:02
     */
    public static String buildExcel(List<List<String>> lists, String dest){

        try {

            // 1.创建Excel工作薄对象
            HSSFWorkbook wb = new HSSFWorkbook();
            // 2.创建Excel工作表对象
            HSSFSheet sheet = wb.createSheet("1");
            
            for(int i=0; i<lists.size(); i++){
                Row row = sheet.getRow(i);
                for(int j=0; j<lists.get(i).size(); j++){
                    row.createCell(j).setCellValue(lists.get(i).get(j));
                }
            }
            
            FileOutputStream fout = new FileOutputStream(dest);
            wb.write(fout);
            fout.close();
            wb.close();
            
            return dest;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    

    public static void buildExcel(List<List<String>> excelData, OutputStream out) throws IOException{

        // 1.创建Excel工作薄对象
        HSSFWorkbook wb = new HSSFWorkbook();
        
        try {

            // 2.创建Excel工作表对象
            HSSFSheet sheet = wb.createSheet("1");
            
            for(int i=0; i<excelData.size(); i++){
                Row row = sheet.createRow(i);
                for(int j=0; j<excelData.get(i).size(); j++){
                    row.createCell(j).setCellValue(excelData.get(i).get(j));
                }
            }
            
            wb.write(out);
        } finally {
            wb.close();
        }
    }
}
