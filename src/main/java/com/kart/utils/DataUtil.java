package com.kart.utils;

public class DataUtil {

	public static Object[][] getData(String tcName,String sheetName,Xls_Reader x){
		int tcStartRow=0;
		while(!x.getCellData(sheetName, 0, tcStartRow).equals(tcName)){
			tcStartRow++;
			//System.out.println(tcStartRow);
		}
		
		System.out.println(tcStartRow);
		int colStartRow=tcStartRow+1;
		
		int cols=0;
		while(!x.getCellData(sheetName, cols, colStartRow).equals("N")){
			cols++;
			//System.out.println(tcStartRow);
		}
		System.out.println(cols);
		int dataStartRow=tcStartRow+2;
		int rows=0;
		while(!x.getCellData(sheetName, 0, dataStartRow+rows).equals("N")){
			rows++;
		}
		System.out.println(rows);
		Object[][] data=new Object[rows][cols];
		int index=0;
		for(int rNum=dataStartRow;rNum<dataStartRow+rows;rNum++){
			for(int cNum=0;cNum<cols;cNum++){
				System.out.println(x.getCellData(sheetName, cNum, rNum));
				data[index][cNum]=x.getCellData(sheetName, cNum, rNum);
			}
			index++;
		}
		return data;
		
	}
	
	public static void main(String[] args) {
		Xls_Reader x=new Xls_Reader();
		DataUtil.getData("TC3", "Sheet1", x);
	}
}
