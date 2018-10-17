package demoguru99;

import java.io.File;
// Needed to make Selenium work with Excel
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Util1 {
	    
    public static final String FILE_PATH = "/home/kadadmin/Downloads/Selenium - Practise/Day03/testData.xls"; // File Path
    public static final String SHEET_NAME = "Data"; // Sheet name
    public static final String TABLE_NAME = "testData"; // Name of data table

    public static final int WAIT_TIME = 30; // Delay time to wait the website
					    // launch completely
    public static final String BASE_URL = "http://www.demo.guru99.com/";

    public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
    public static final String EXPECT_ERROR = "User or Password is not valid";

    public static String[][] getDataFromExcel (String xlFilePath,
			String sheetName, String tableName) throws Exception {
		
		String[][] tabArray = null;

		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		Sheet sheet = workbook.getSheet(sheetName);

		int startRow, startCol, endRow, endCol, ci, cj;

		Cell tableStart = sheet.findCell(tableName);
		startRow = tableStart.getRow();
		startCol = tableStart.getColumn();

		Cell tableEnd = sheet.findCell(tableName);
		endRow = tableEnd.getRow();
		endCol = tableEnd.getColumn();
		
		tabArray = new String[endRow-startRow-1][endCol-startCol-1];
		ci = 0;

		for (int i = startRow + 1; i < endRow; i++, ci++) {
			cj = 0;
			for (int j = startCol + 1; j < endCol; j++, cj++) {
				tabArray[ci][cj] = sheet.getCell(j, i).getContents();
			}
		}
System.out.println(tabArray);
		return (tabArray);
	}
 

}