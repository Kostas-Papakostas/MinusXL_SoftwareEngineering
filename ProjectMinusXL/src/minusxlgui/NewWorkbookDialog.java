package minusxlgui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewWorkbookDialog {

    private JDialog dialog;
    private JTextField name;
    

	public NewWorkbookDialog (String title, JFrame frame){
	    dialog = new JDialog(frame, title, true);
	    dialog.setTitle("New Workbook");
	    dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);   
	    dialog.setMinimumSize(new Dimension(230, 160));
	    init();
	}
	
	public void setVisible(Boolean flag){
	    dialog.setVisible(flag);
	}
	
	public static String getInput(String title, JFrame frame){
		NewWorkbookDialog input = new NewWorkbookDialog (title, frame);
	    input.setVisible(true);
	    String workbookName;
	    if(input.name.getText().equals("")){
	    	workbookName = "defaultName";
	    }
	    else{
	    	workbookName = input.name.getText();
	    }
	    return workbookName;
	}
	
	private void init(){
	    name = new JTextField(10);
	    name.setBounds(96, 31, 108, 20);
	    JButton okButton = new JButton("OK");
	    okButton.setBounds(69, 87, 89, 23);
	    okButton.addActionListener(new ActionListener(){
	
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	SaveWorkbookOrNot.getInput("Save Workbook Or Not", null);
	                dialog.dispose();
	            }
	
	    });
	    dialog.getContentPane().setLayout(null);
	    dialog.getContentPane().add(name);
	    dialog.getContentPane().add(okButton);
	    
	    JLabel lblName = new JLabel("Name");
	    lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblName.setBounds(10, 32, 46, 14);
	    dialog.getContentPane().add(lblName);
	    dialog.pack();     
	}
	
	public static void main(String args []){
	    String s = getInput("Dialog",null);
	    System.out.println(s);
	}
}