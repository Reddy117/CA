package com.kart.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kart.utils.Xls_Reader;

public class Xls_Reader {


		public FileInputStream f;
		private XSSFWorkbook w;
		private XSSFSheet s;
		private XSSFRow r;
		private XSSFCell c;
		public FileOutputStream out;
		
		
		public Xls_Reader(){
			try{
				f=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/TestData/TestData.xlsx");
				w=new XSSFWorkbook(f);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public String getCellData(String sheetName,int colNum,int rowNum){
			try{
				
				s=w.getSheet(sheetName);
				r=s.getRow(rowNum);
				c=r.getCell(colNum);
						
				return c.getStringCellValue();
		
			}catch(Exception e){
				return e.toString();
			}
		}
		
		public boolean setCellData(String sheetName,String colName,String data,String tcName){
		try{
			s = w.getSheet(sheetName);
			int tcStartRow=0;
			while(!getCellData(sheetName, 0, tcStartRow).equals(tcName)){
				tcStartRow++;
			}
			  r=s.getRow(tcStartRow+1);
			  int colNum=0;;
			  int index=2;
			  for(int i=0;i<r.getLastCellNum();i++){
			   System.out.println(r.getCell(i).getStringCellValue().trim());
			   if(r.getCell(i).getStringCellValue().trim().equals(colName))
			    colNum=i;
			  }
			  s.autoSizeColumn(colNum); 
			  r = s.getRow(tcStartRow+index);
			  if (r == null)
			   r = s.createRow(tcStartRow+index);
			  c = r.getCell(colNum); 
			  if (c == null)
			  c = r.createCell(colNum);
			  c.setCellValue(data);
			  out = new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/TestData/TestData.xlsx");
			  w.write(out);
			  out.close(); 
			  }
			  catch(Exception e){
			   e.printStackTrace();
			   return false;
			  }
			  return true;
			 }
			 
		public static void main(String[] args) {
			Xls_Reader x=new Xls_Reader();
			System.out.println(x.setCellData("Sheet1","ProdCode", "Success","TC1_addProductTokartVerify"));
		}
		
	}
	

