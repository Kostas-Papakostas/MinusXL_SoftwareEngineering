package minusxldatamanagment;

import java.util.ArrayList;

public class Workbook {
	
	private static Workbook instance = null;
	private String name;
	private ArrayList<Spreadsheet> spreadsheetList = new ArrayList<Spreadsheet>();
	
	public static Workbook getInstance() {
	        if(instance == null){
	            instance = new Workbook();
	        }    
	        return instance;
	}
	
	public Spreadsheet updateSpreadsheetList(){
		spreadsheetList.clear();
		spreadsheetList.add(new Spreadsheet(50,30,"Spreadsheet"));
		return spreadsheetList.get(0);
	}
	

	public void addSpreadsheet(Spreadsheet spreadsheet){
		spreadsheetList.add(spreadsheet);
	}
	
	public void deleteSpreadsheet(int index){
		spreadsheetList.remove(index);
	}
	
	public Spreadsheet getRequestedSpreadsheet(int number){
		return spreadsheetList.get(number);
	}
	
	public int getNumberOfSpreadsheets(){
		return spreadsheetList.size();
	}
	
	public void SetName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void printNames(){
		for(Spreadsheet sp :spreadsheetList){
			System.out.println(sp.getName());
		}
		System.out.println();
	}

}
