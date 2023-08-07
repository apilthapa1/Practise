package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException{
		String path = System.getProperty("user.dir") + "//testdata//UserData.xlsx";
		ExcelUtility xlU = new ExcelUtility(path);
		
		int rowNumber = xlU.getRowCount("Sheet1");
		int columnCount = xlU.getCellCount("Sheet1", 1);
		
		String apiData[][] = new String[rowNumber][columnCount];
		for (int i = 0; i < rowNumber; i++) {
			for (int j = 0; j < columnCount; j++) {
				apiData[i][j] = xlU.getCellData("Sheet1", i + 1, j);
			}
		}
		return apiData;
	}
	
	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException{
		String path = System.getProperty("user.dir") + "//testdata//UserData.xlsx";
		ExcelUtility xlU = new ExcelUtility(path);
		
		int rowNum = xlU.getRowCount("Sheet1");
		String apiData[] = new String[rowNum];
		
		for (int i = 0; i < rowNum; i++) {
			apiData[i] = xlU.getCellData("Sheet1", i + 1, 1);
		}
		return apiData;
	}
}
