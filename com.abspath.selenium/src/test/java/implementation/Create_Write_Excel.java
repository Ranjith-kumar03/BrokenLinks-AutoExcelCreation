package implementation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Create_Write_Excel {
	static Workbook workbook;
	Sheet sheet;
	FileOutputStream fos;
	int rownum=1;
	private static String[] Column_Headers= {"S.NO","HYPERLINKS","STATUS"};
	
	
	public Create_Write_Excel()  {
	workbook =new XSSFWorkbook();
	sheet = workbook.createSheet("Testing_Broken_Links");
	Font font= workbook.createFont();
	 font.setBoldweight((short) 20);
	 font.setFontHeightInPoints((short) 20);
	 font.setColor(IndexedColors.DARK_RED.getIndex());
	 
	 
	  CellStyle  HeaderStyle = workbook.createCellStyle();
	  HeaderStyle.setFont(font);
	 
	  Row Header_row=sheet.createRow(0);
	  
	  for(int i=0;i<Column_Headers.length;i++)
	  {
		  Cell cell=Header_row.createCell(i);
		  cell.setCellValue(Column_Headers[i]);
		  cell.setCellStyle(HeaderStyle);
	  }
	  
	}
	 
	public FileOutputStream execute() throws FileNotFoundException
	{
	  
	  
	  
		  Row row=sheet.createRow(rownum++);
		  row.createCell(0).setCellValue(Selinium.count);
		  row.createCell(1).setCellValue(Selinium.testme);
		  row.createCell(2).setCellValue(Selinium.response);
				  
				 
	  fos=new FileOutputStream("Testing.xlsx");
	 
	 return fos;
	}
	

	
	 public void closing() throws IOException {
	 
		 workbook.write(fos);
		 fos.close();
	 
	}
	  
 
	}

