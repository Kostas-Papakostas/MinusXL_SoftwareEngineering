package minusxldatamanagment;

import minusxlfilemanagment.CSVFilereader;

public class LoadSpreadsheet {

	private CSVFilereader readfile;
	private String value;
	private int offset;
	
	//takes the source the offset row,columns and a Spreadsheet object as input and sets the values
	public void loadAspreadsheet(String filename,int offset2,int row,int col,Spreadsheet settingspr){
		
		value=readfile.readCSV(filename, offset2);
		settingspr.getSheettable().setValueAt(value, row, col);
		
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
}
