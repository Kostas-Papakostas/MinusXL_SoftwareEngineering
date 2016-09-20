package minusxlgui;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;

import minusxldatamanagment.*;
import minusxlfilemanagment.*;
import net.miginfocom.swing.MigLayout;


public class LoadSpreadsheetFromCSVFile {
	
    private JDialog dialog;
    private JTextField file;
    private static String filename;
    private static String value;
    private static int offset;
	private static int i=0;
	private static int j=0;
    private static LoadSpreadsheetFromCSVFile input;
    private static Workbook workbook=Workbook.getInstance();
    private static CSVFilereader readFile=new CSVFilereader();
	    
	
	public LoadSpreadsheetFromCSVFile(String title, JFrame frame){
	    dialog = new JDialog(frame, title, true);
	    dialog.setResizable(false);
	    dialog.setTitle("Load Spreadsheet");
	    dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);   //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    dialog.setMinimumSize(new Dimension(240, 160));
	    init();
	}
	
	public void setVisible(Boolean flag){
	    dialog.setVisible(flag);
	}
	
	public static void getInput(String title, JFrame frame){
		input = new LoadSpreadsheetFromCSVFile (title, frame);
	    input.setVisible(true);
	}
	
	private void init(){
	    dialog.getContentPane().setLayout(new MigLayout("", "[89px][2px][][][89px]", "[78px][36px][]"));
	    JLabel spreadsheetLabel = new JLabel("Filename");
	
	    dialog.getContentPane().add(spreadsheetLabel, "cell 0 0,grow");
	    JButton okButton = new JButton("OK");
	    okButton.addActionListener(new ActionListener(){
	
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	filename=input.file.getText();
	            	Path file1=Paths.get(filename);
	                Charset charset = Charset.forName("US-ASCII");
	                String[] cell=null;
	                try(BufferedReader Reader=Files.newBufferedReader(file1,charset)){
	                    Reader.skip(offset);
	                    while (readFile.isStop()==true){
	                    	i=0;
	                    	value=readFile.readCSV(filename, j);
	                    	if(value!=null){
	                    		cell=value.split(";", 2);
	                    	}
	                    	
	                    	/*na allazw to megethos tou table analoga me to arxeio*/

	                    	while(cell[1].contains(";")==true){
	                    		workbook.getRequestedSpreadsheet(0).getSheettable().setValueAt(cell[0], j, i);
	                    		
	                			i++;            		
	                    		if((i-2)!=(workbook.getRequestedSpreadsheet(0).getSheettable().getColumnCount())){
	                    			cell=cell[1].split(";", 2);
	                    			workbook.getRequestedSpreadsheet(0).getSheettable().setValueAt(cell[0], j, i);
	                    		}
	                    	}
	                    	j++;
	                    }
	                }catch (IOException x) {
	                	JOptionPane.showMessageDialog(null, "An error occured while loading .csv file", "Error",
	                            JOptionPane.ERROR_MESSAGE);
	                }

	            	dialog.dispose();
	            }
	
	    });
	    file = new JTextField(5);
	    dialog.getContentPane().add(file, "cell 2 0 3 1,growx,aligny center");
	    dialog.getContentPane().add(okButton, "cell 2 1,alignx center,growy");
	    dialog.pack();     
	}
	
	public static void main(String args []){
	    getInput("Dialog",null);
	}

}