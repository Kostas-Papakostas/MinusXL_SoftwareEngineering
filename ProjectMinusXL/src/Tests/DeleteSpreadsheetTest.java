package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import minusxldatamanagment.*;

public class DeleteSpreadsheetTest {

	Workbook workbook = Workbook.getInstance();
	
	@Test
	public void test() {
		workbook.updateSpreadsheetList();
		workbook.addSpreadsheet(new Spreadsheet(10 ,10 ,"Test"));  //prepei na periexei Spreadsheet + Test ----spreadsheet einai h default
		workbook.deleteSpreadsheet(0);
		String names = workbook.getRequestedSpreadsheet(0).getName(); 
		for(int i=1;i<workbook.getNumberOfSpreadsheets();i++){
			names += " " + workbook.getRequestedSpreadsheet(i).getName(); 
		}
		assertEquals("Test",names);

	}

}
