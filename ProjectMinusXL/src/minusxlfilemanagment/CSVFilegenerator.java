package minusxlfilemanagment;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

import javax.swing.JOptionPane;

import static java.nio.file.StandardOpenOption.*;
 
 
public class CSVFilegenerator {
    private String spreadsheetTitle;
     
    public void createCSV(String filename,String value){   //writes the value of a cell
         
        Path file=Paths.get(filename);    //destination= "./file.csv"
        //if the value isn't space it is printed to the file else it prints newline
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset,CREATE,APPEND)) {
            if(value != " "){
            	if(value!="null"){
            		writer.write(value);
                }
                writer.write(";");
            }else{
                writer.newLine();
            }
            writer.close();
        } catch (IOException x) {
        	JOptionPane.showMessageDialog(null, "An error has occured while saving the file", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
     
    public String getSpreadsheetTitle(){
        return spreadsheetTitle;
    }
     
    public void setSpreadsheet(String spreadsheetTitle){
        this.spreadsheetTitle=spreadsheetTitle;
    }
}