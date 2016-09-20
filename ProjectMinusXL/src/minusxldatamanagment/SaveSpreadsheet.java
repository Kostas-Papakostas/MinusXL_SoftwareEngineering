package minusxldatamanagment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JTable;

import minusxlfilemanagment.CSVFilegenerator;

public class SaveSpreadsheet {

	private JTable tmptable;
	private CSVFilegenerator filegen=new CSVFilegenerator();
	public String filename;
	//takes input a Spreadsheet object and saves each value seperated with semi-column
	public void saveAspreadsheet(Spreadsheet aSpreadsheet){
		tmptable=aSpreadsheet.getSheettable();
		filename= aSpreadsheet.getName();
		filename=filename+".csv";
        Path file=Paths.get(filename);    //destination= "./file.csv"
        if(Files.exists(file)){
        	try {
				Files.delete(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.format("IOException: %s%n", e);
			}
        }
		for(int i=0;i<tmptable.getRowCount();i++){
			for(int j=0;j<tmptable.getColumnCount();j++){
				filegen.createCSV(filename,String.valueOf(tmptable.getValueAt(i, j)));
			}
			filegen.createCSV(filename, " ");
		}
	}
	
	public void setFilename(String filename){
		this.filename=filename;
	}
	
	public String getFilename(){
		return filename;
	}
}
