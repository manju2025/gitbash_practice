package alterrio_retro_project;

import org.tyss.sales_and_inventory_Generic_script.ExcelUtility;
import org.tyss.sales_and_inventory_Generic_script.Iconstants;

public class FetchDataFromExelThroughMap {
	public static void main(String[] args) 
	{
		 ExcelUtility getdata = new ExcelUtility();
		getdata.openExcelPage(Iconstants.EXCEL);
	         String map = getdata.getDataFromExcel("commondata","firstname");
	         System.out.println(map);
	}
}
