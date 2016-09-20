package minusxlgui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import minusxldatamanagment.SaveSpreadsheet;
import minusxldatamanagment.Spreadsheet;
import minusxldatamanagment.Workbook;
import net.miginfocom.swing.MigLayout;

public class SaveWorkbookDialog {
	private JDialog dialog;
    private static Workbook workbook=Workbook.getInstance();
    private static Spreadsheet spreadToSave;
    private static SaveSpreadsheet saveIt=new SaveSpreadsheet();
    private static SaveWorkbookDialog input;

	public SaveWorkbookDialog (String title, JFrame frame){
	    dialog = new JDialog(frame, title, true);
	    dialog.setMaximumSize(new Dimension(180, 2147483647));
	    dialog.setResizable(false);
	    dialog.setTitle("Save Workbook");
	    dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	    init();
	}
	
	public void setVisible(Boolean flag){
	    dialog.setVisible(flag);
	}
	
	public static void getInput(String title, JFrame frame){
		input = new SaveWorkbookDialog (title, frame);
	    input.setVisible(true);
	}
	
	private void init(){
	    dialog.getContentPane().setLayout(new MigLayout("", "[89px][][5px][][][89px][][][][]", "[78px][34px]"));
	    JLabel spreadsheetLabel = new JLabel("Your workbook has been saved");
	    
	    dialog.getContentPane().add(spreadsheetLabel, "cell 1 0,grow");
	    JButton okButton = new JButton("OK");
	    okButton.setPreferredSize(new Dimension(20,10));
	    okButton.addActionListener(new ActionListener(){
	
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	for(int i=0;i<workbook.getNumberOfSpreadsheets();i++){
		        	    spreadToSave = workbook.getRequestedSpreadsheet(i);
		        	    saveIt.setFilename(spreadToSave.getName());
		            	saveIt.saveAspreadsheet(spreadToSave);
	            	}
	                dialog.dispose();
	            }
	    });
	    dialog.getContentPane().add(okButton, "cell 1 1,alignx center,growy");
	    dialog.pack();     
	}
	
	public static void main(String args []){
	    getInput("Dialog",null);
	}
}
