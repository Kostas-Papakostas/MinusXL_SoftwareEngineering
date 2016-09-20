package minusxlgui;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;





public class DeleteSpreadsheetDialog {

    private JDialog dialog;
    private JTextField spreadsheet;
    private static DeleteSpreadsheetDialog input;
    
	public DeleteSpreadsheetDialog (String title, JFrame frame){
	    dialog = new JDialog(frame, title, true);
	    dialog.setResizable(false);
	    dialog.setTitle("Delete Spreadsheet");
	    dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);   //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    dialog.setMinimumSize(new Dimension(300, 180));
	    init();
	}
	
	public void setVisible(Boolean flag){
	    dialog.setVisible(flag);
	}
	
	public static int getInput(String title, JFrame frame){
		input = new DeleteSpreadsheetDialog (title, frame);
	    input.setVisible(true);
	
	    if(input.spreadsheet.getText().equals("") 
	    		|| Integer.parseInt(input.spreadsheet.getText()) < 1){
	    	return -1;
	    }
	    else{
	    	return Integer.parseInt(input.spreadsheet.getText()) - 1 ;
	    }
	}
	
	private void init(){
	
	    spreadsheet = new JTextField(5);
	    spreadsheet.setBounds(183, 49, 101, 19);
	    JButton okButton = new JButton("OK");
	    okButton.setBounds(100, 91, 101, 32);
	    okButton.addActionListener(new ActionListener(){
	
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dialog.dispose();
	            }
	
	    });
	    
	    dialog.getContentPane().setLayout(null);
	    dialog.getContentPane().add(spreadsheet);
	    dialog.getContentPane().add(okButton);
	    
	    JLabel lblSpreadsheetNumber = new JLabel("Spreadsheet Number");
	    lblSpreadsheetNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblSpreadsheetNumber.setBounds(10, 49, 152, 14);
	    dialog.getContentPane().add(lblSpreadsheetNumber);
	    dialog.pack();     
	}
	
	public static void main(String args []){
	    int s = getInput("Dialog",null);
	    System.out.println(s);
	}
}