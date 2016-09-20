package minusxlgui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import minusxldatamanagment.*;
import net.miginfocom.swing.MigLayout;


public class SaveSpreadsheetAsCSV {

    private JDialog dialog;
    JTextField spreadsheet;
    private static Workbook workbook=Workbook.getInstance();
    private static int inputSpreadsheet;   //to noumero tou spreadsheet ap tin eisodo
    private static Spreadsheet spreadToSave;
    private static SaveSpreadsheet saveIt=new SaveSpreadsheet();
    private static SaveSpreadsheetAsCSV input;

	public SaveSpreadsheetAsCSV (String title, JFrame frame){
	    dialog = new JDialog(frame, title, true);
	    dialog.setMaximumSize(new Dimension(200, 2147483647));
	    dialog.setResizable(false);
	    dialog.setTitle("Save Spreadsheet");
	    dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	    init();
	}
	
	public void setVisible(Boolean flag){
	    dialog.setVisible(flag);
	}
	
	public static void getInput(String title, JFrame frame){
		input = new SaveSpreadsheetAsCSV (title, frame);
	    input.setVisible(true);
	}
	
	private void init(){
	    JLabel spreadsheetLabel = new JLabel("Spreadsheet");
	    dialog.getContentPane().setLayout(new MigLayout("", "[89px][5px][][][89px][][][][]", "[78px][34px]"));
	
	    dialog.getContentPane().add(spreadsheetLabel, "cell 0 0,grow");
	    
	    spreadsheet = new JTextField(5);
	    dialog.getContentPane().add(spreadsheet, "cell 2 0 6 1,growx,aligny center");
	    JButton okButton = new JButton("OK");
	    okButton.setPreferredSize(new Dimension(20,10));
	    okButton.addActionListener(new ActionListener(){
	
	            @Override
	            /**************************new code****************************/
	            public void actionPerformed(ActionEvent e) {

	            	inputSpreadsheet=Integer.parseInt(input.spreadsheet.getText());
	        	    spreadToSave = workbook.getRequestedSpreadsheet(inputSpreadsheet-1);
	            	saveIt.setFilename(spreadToSave.getName());
	            	saveIt.saveAspreadsheet(spreadToSave);
	                dialog.dispose();
	            }
	    });
	    dialog.getContentPane().add(okButton, "cell 3 1,alignx center,growy");
	    dialog.pack();     
	}
	
	public static void main(String args []){
	    //int s = getInput("Dialog",null);
	    //System.out.println(s);
	}
}