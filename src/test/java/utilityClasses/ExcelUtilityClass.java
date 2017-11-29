package utilityClasses;



import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import libraryClasses.FuncitonLibrary;

public class ExcelUtilityClass extends FuncitonLibrary {
			
	public int gtRwCnt(int sheetNum) throws IOException{
		File file =  new File(System.getProperty("user.dir")+"/Reports/"+applicationname+"/"+datestamp()+"/TestData"+applicationname+".xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		XSSFSheet ws1 = wb1.getSheetAt(sheetNum);
		int rwCnt = ws1.getLastRowNum()-ws1.getFirstRowNum();
		System.out.println(rwCnt);
		return rwCnt;
		
	}
	
	@SuppressWarnings("resource")
	public String getStrExcelData(int RowNum,int ColNum,int sheetNum) throws IOException{
		try{ 
			
		File file = new File(System.getProperty("user.dir")+"/Reports/"+applicationname+"/"+datestamp()+"/TestData"+applicationname+".xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		XSSFSheet ws1 = wb1.getSheetAt(sheetNum);
		Cell cell = ws1.getRow(RowNum).getCell(ColNum);
		String CellData = cell.getStringCellValue();
		return CellData;
		}
		catch (Exception  e) {
	        e.printStackTrace();
	     } 
		return "";
	}
	


	public void writeToExcel(String val,int Row,int Col, int SheetNum) throws Exception 
    {
		try{
			File file =  new File(System.getProperty("user.dir")+"/Reports/"+applicationname+"/"+datestamp()+"/TestData"+applicationname+".xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		XSSFSheet ws1 = wb1.getSheetAt(SheetNum);
		
		Row row  = ws1.getRow(Row);
		Cell cell2 = row.createCell(Col);
	    cell2.setCellValue(val);
	    System.out.println(val);
	    fis.close();
	    FileOutputStream outFile =new FileOutputStream(file);
	    wb1.write(outFile);
		}
		catch (Exception  e) {
	        e.printStackTrace();
	     } 
    }
	
	public int getRowCount (int SheetNum) throws Exception 
    {
		try{
		File file = new File(System.getProperty("user.dir")+"/Reports/"+applicationname+"/"+datestamp()+"/TestData"+applicationname+".xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		XSSFSheet ws1 = wb1.getSheetAt(SheetNum);
		int rowCount = ws1.getLastRowNum();
		fis.close();
		return rowCount;
		}
	    catch (Exception  e) {
	        e.printStackTrace();
	     } 
	       
		return 0;
		
    }

	public String getExcelData(int RowNum,String ColName,String sheetName) throws IOException{
		try{ 
			String CellData=null;
		File file =  new File(System.getProperty("user.dir")+"/Reports/"+applicationname+"/"+datestamp()+"/TestData"+applicationname+".xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		XSSFSheet ws1 = wb1.getSheet(sheetName.trim());
		Row row1 = ws1.getRow(0);
		
		for (Cell cell : row1) {
            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                if (cell.getRichStringCellValue().getString().trim().equals(ColName.trim())) {
                 CellData = ws1.getRow(RowNum).getCell(cell.getColumnIndex()).getStringCellValue(); 
                break; 
                }
                                                             }
                                }
		
		fis.close();
		return CellData;
		}
		 catch  (Exception  e) {
		        e.printStackTrace();
		     } 
		return "";
	}
	public void writeExceldata(int RowNum,String ColName,String sheetName,String value) throws IOException{
		try{ 
			String CellData=null;
//			value=value.replaceAll("\\s+","");
		File file =  new File(System.getProperty("user.dir")+"/Reports/"+applicationname+"/"+datestamp()+"/TestData"+applicationname+".xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		XSSFSheet ws1 = wb1.getSheet(sheetName);
		Row row1 = ws1.getRow(0);
		
		for (Cell cell : row1) {
            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                if (cell.getRichStringCellValue().getString().trim().equals(ColName)) {

              ws1.getRow(RowNum).getCell(cell.getColumnIndex()).setCellValue(value);
                break; 
                }
                                                             }
                                }
		
		 fis.close();
		    FileOutputStream outFile =new FileOutputStream(file);
		    wb1.write(outFile);
		    outFile.close();
		}
		catch (Exception  e) {
	        System.out.println(" data has not written in the sheet name of  :"+sheetName+"and Column Name :"+ColName);
	     } 

	}
	public String datestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
public boolean addColumn(String colName,String sheetName){
		
		try{
			File file =  new File(System.getProperty("user.dir")+"/Reports/"+applicationname+"/"+datestamp()+"/TestData"+applicationname+".xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb1 = new XSSFWorkbook(fis);
			XSSFSheet ws1 = wb1.getSheet(sheetName);
			Row row1 = ws1.getRow(0);
			Cell cell;
			
//			fis = new FileInputStream(path); 
//			workbook = new XSSFWorkbook(fis);
			int index = wb1.getSheetIndex(sheetName);
			if(index==-1)
				return false;
			
		XSSFCellStyle style = wb1.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
		ws1=wb1.getSheetAt(index);
		
		row1 = ws1.getRow(0);
		if (row1 == null)
			row1 = ws1.createRow(0);
	
		if(row1.getLastCellNum() == -1)
			cell = row1.createCell(0);
		else
			cell = row1.createCell(row1.getLastCellNum());
	        
	        cell.setCellValue(colName);
	        cell.setCellStyle(style);
	        
	        FileOutputStream outFile =new FileOutputStream(file);
		    wb1.write(outFile);
		    outFile.close();
//	        
//	        
//	        fileOut = new FileOutputStream(path);
//			workbook.write(fileOut);
//		    fileOut.close();		    

		}catch(Exception e){
			System.out.println("excel column creating problem");
			return false;
		}
		
		return true;
		
	}

}
