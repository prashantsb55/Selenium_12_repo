package genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author prashant
 */

public class ExcelUtility {
	/**
	 * This method is used to read String data from excel
	 * @param sheetName
	 * @param rowIndex
	 * @param collIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String getStringDataFromExcel(String sheetName,int rowIndex,int collIndex) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	return workbook.getSheet(sheetName).getRow(rowIndex).getCell(collIndex).getStringCellValue();
}
	
	public boolean getBooleanDataFromExcel(String sheetName,int rowIndex,int collIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(collIndex).getBooleanCellValue();
		
	}
	public double getNumberDataFromExcel(String sheetName,int rowIndex,int collIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(collIndex).getNumericCellValue();
	}
	public double getFromExcel(String sheetName,int rowIndex,int collIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(collIndex).getNumericCellValue();
	}
}
