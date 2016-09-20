package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import minusxldatamanagment.*;

public class AddSpreadsheetTest {
	
	Workbook workbook = Workbook.getInstance();
	
	@Test
	public void test() {
		workbook.updateSpreadsheetList();
		workbook.addSpreadsheet(new Spreadsheet(10 ,10 ,"Test"));
		String names = workbook.getRequestedSpreadsheet(0).getName(); 
		for(int i=1;i<workbook.getNumberOfSpreadsheets();i++){
			names += " " + workbook.getRequestedSpreadsheet(i).getName(); 
		}
		assertEquals("Spreadsheet Test",names);  //Spreadsheet einai h default
	}	
}
