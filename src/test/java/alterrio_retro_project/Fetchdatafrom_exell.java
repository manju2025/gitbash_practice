package alterrio_retro_project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fetchdatafrom_exell {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet Sheet = wb.getSheet("sheet2");
		DataFormatter df=new DataFormatter();
		String value=null;
		for(int i=0;i<Sheet.getLastRowNum();i++)
		{
			String 	key=df.formatCellValue(Sheet.getRow(i).getCell(2));
			if(key.equalsIgnoreCase("KiNg"))
			{
				value=df.formatCellValue(Sheet.getRow(i).getCell(2));
				break;
			}
		}
	System.out.println(value);
		}
}
