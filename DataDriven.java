import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream("C:\\Users\\vrgun\\Documents\\datadriven.xlsx");
		//XSSFWorkbook workbook =new XSSFWorkbook(fis);
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		//identify the "tescase" column from first row,from testcase column findout "purchase" testcase 
		//in "testcase" coloumn,and the retrieve data from purchase row.
		ArrayList<String> a= new ArrayList<String>();
		for(int i=0;i<workbook.getNumberOfSheets();i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
			
			XSSFSheet sheet = workbook.getSheetAt(i);
			Iterator<Row> rowiterator =sheet.iterator();
			  Row firstrow =rowiterator.next();
			Iterator<Cell> cells=firstrow.cellIterator();
			int k=0;
			while(cells.hasNext())
			{
				Cell coloumn=cells.next();
				System.out.println(coloumn.getStringCellValue());
				if(coloumn.getStringCellValue().equalsIgnoreCase("Testcases"))
				{
					//coloumn=k;
				//	System.out.println(k);
					break;
				}
				k++;
			}
	
		while(rowiterator.hasNext())
		{
			Row rowvalue=rowiterator.next();
			//System.out.println(rowvalue.getCell(k).getStringCellValue());
			if(rowvalue.getCell(k).getStringCellValue().equalsIgnoreCase("purchase"))
					{
						Iterator<Cell> cellvalue=rowvalue.cellIterator();
						while(cellvalue.hasNext()) {
						Cell data=cellvalue.next();
						switch(data.getCellType())	{
						case Cell.CELL_TYPE_STRING:
						a.add(data.getStringCellValue());
						System.out.println(data.getStringCellValue());
						break;
						case Cell.CELL_TYPE_NUMERIC:
							a.add(NumberToTextConverter.toText(data.getNumericCellValue()));
							System.out.println(data.getNumericCellValue());
							break;}
					}
		}
			
			
		}

			}}}}


