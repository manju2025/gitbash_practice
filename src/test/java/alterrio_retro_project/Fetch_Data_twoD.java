package alterrio_retro_project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fetch_Data_twoD {
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook work=WorkbookFactory.create(fis);
		Sheet Sheet = work.getSheet("sales and inventory");
		DataFormatter df = new DataFormatter();
		String[][] arr=new String[Sheet.getLastRowNum()+1][Sheet.getRow(2).getLastCellNum()];
		for(int i=0;i<=Sheet.getLastRowNum();i++)
		{
			for(int j=0;j<Sheet.getRow(2).getLastCellNum();j++)
			{
				arr[i][j]=df.formatCellValue(Sheet.getRow(i).getCell(j));
			}
		}
		for(int i=0;i<=Sheet.getLastRowNum();i++)
		{
			for(int j=0;j<Sheet.getRow(2).getLastCellNum();j++)
			{
				System.out.println(arr[i][j]);
			}
		}
	}
}
