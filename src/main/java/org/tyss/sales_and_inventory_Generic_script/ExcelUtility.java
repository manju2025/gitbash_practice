package org.tyss.sales_and_inventory_Generic_script;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
private Workbook page;

/**
 * this method is used to fetch data from the excel
 * @param excel
 * @param getsheet
 * @param getrow
 * @param getcell
 */
public String getDataFromExcel(String EXCEL,String getsheet,int row,int cell) 
{
	FileInputStream file = null;
	try {
	  file=new FileInputStream(EXCEL);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	Workbook book=null; 
	try {
	book = WorkbookFactory.create(file);
	} catch (EncryptedDocumentException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	Sheet pag = book.getSheet(getsheet);
	String data = new DataFormatter().formatCellValue(pag.getRow(row).getCell(cell));
	try {
		book.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return data;
}


/**
 * This method is used to navigate to the excel by converting physical address into java readable object and it will open the excel
 * @param excel
 * @return
 */
public Workbook openExcelPage(String excel)
{
	FileInputStream file=null;
	try {
		file=new FileInputStream(excel);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		page = WorkbookFactory.create(file);
	} catch (EncryptedDocumentException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return page;
}
/**
 * this method is used to get the data from excel based on specified sheet, row, cell
 * @param sheet1
 * @param row1
 * @param cell1
 * @return
 */
public String getDataFromExcelBySheet(String sheet1,int row1, int cell1)
{
	Sheet book = page.getSheet(sheet1);
	String value = new DataFormatter().formatCellValue(book.getRow(row1).getCell(cell1));
return value;
}

/**
 * this method is used to close the excel 
 */
public void closeExcelBook()
{
	try {
		page.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
 
/**
 * this method is used to set the data into particular cell
 * @param sheet2
 * @param row2
 * @param cell2
 * @param value1
 */
public void setDataToExcel(String sheet2, int row2, int cell2, String value1)
{
	Sheet sheet4 = page.getSheet(sheet2);
	sheet4.createRow(row2).createCell(cell2).setCellValue(value1);
}

/**
 * this method is used to save the data which is set to cell by passing the path of the excel
 * @param outputpath
 */
public void saveData(String outputpath)
{
	try {
		page.write(new FileOutputStream(outputpath));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

/**
 * this method is used to get the data based on the required key in a particular sheet.
 * @param sheet
 * @param Requirdkey
 * @return
 */
public String getDataFromExcel(String sheet,String Requirdkey)
{
	Sheet paper = page.getSheet(sheet);
	String value=null;
	for(int i=0;i<=paper.getLastRowNum();i++)
	{
		
		String key = paper.getRow(i).getCell(1).getStringCellValue();
		if(key.equalsIgnoreCase(Requirdkey))
		{
			value = paper.getRow(i).getCell(2).getStringCellValue();
			break;
		}
	}
	return value;
}

/**
 * this method is used to get the entire row key and value of one column and store it in a map refference variable(Map concept).
 * @param sheetname
 * @return
 */
public Map<String, String> getDataFromExcelByMap(String sheetname)
{
	Sheet book1 = page.getSheet(sheetname);	
	Map<String, String> map = new HashMap<String, String>();
	DataFormatter df = new DataFormatter();
	for(int i=0;i<=book1.getLastRowNum();i++)
	{
		map.put(df.formatCellValue(book1.getRow(i).getCell(0)),df.formatCellValue(book1.getRow(i).getCell(1)));
	}
	return map;
}

/**
 * this method is used to store entire record of particular sheet and store in list refference variable(collection concept).
 * @param sheet
 * @return
 */
public List<Map<String, String>> fetchDataExcelInList(String sheet)
{
	Sheet paper = page.getSheet(sheet);
	List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	DataFormatter df = new DataFormatter();
	for(int j=1;j<paper.getRow(0).getLastCellNum();j++)
	{
		Map<String, String> map = new HashMap<String, String>();
		for(int i=0;i<=paper.getLastRowNum();i++)
		{
			map.put(df.formatCellValue(paper.getRow(i).getCell(0)),df.formatCellValue(paper.getRow(i).getCell(j)));
		}
	list.add(map);
	}
return list;
}

/**
 * this method is used to get the value for particular testcase by specifying required key.
 * @param sheet4
 * @param testcasename
 * @param requiredkey
 * @return
 */
public String getDataFromExcel(String sheet4, String testcasename, String requiredkey)
{
	Sheet book2 = page.getSheet(sheet4);
	String value1=null;
	for(int i=0;i<=book2.getLastRowNum();i++)
	{
		String actualTestCaseName = book2.getRow(i).getCell(0).getStringCellValue();
		if(actualTestCaseName.equalsIgnoreCase(testcasename))
		{
			for(int j=1;j<book2.getRow(i).getLastCellNum();j++)
			{
				String actualkey = book2.getRow(i).getCell(j).getStringCellValue();
				if(actualkey.equalsIgnoreCase(requiredkey))
				{
					value1 = book2.getRow(i+1).getCell(j).getStringCellValue();
					break;
				}
			}
			break;
		}
	}
	return value1;
}

/**
 * this method is used to write/update the cell with specified value for particular sheet.
 */
public void writeDataToUpdatedExcel(String sheet2, int row2, int cell2, String value1)
{
	Sheet sheet5 = page.getSheet(sheet2);
	sheet5.getRow(row2).createCell(cell2).setCellValue(value1);
}
}

	
	
	
	
	
	
	
	
	
	

