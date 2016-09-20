package minusxlgui;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;






public class NewSpreadsheetDialog {

    private JDialog dialog;
    private JTextField rows;
    private JTextField collumns;
    private JTextField name;
    private static NewSpreadsheetDialog input;
    private static String array[] = new String[3];

public NewSpreadsheetDialog (String title, JFrame frame){
    dialog = new JDialog(frame, title, true);
    dialog.setResizable(false);
    dialog.setTitle("New Spreadsheet");
    dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);   //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    dialog.setMinimumSize(new Dimension(350, 250));
    init();
}

public void setVisible(Boolean flag){
    dialog.setVisible(flag);
}

public static String[] getInput(String title, JFrame frame){
    input = new NewSpreadsheetDialog (title, frame);
    input.setVisible(true);

    return array;
}




private void init(){

    rows = new JTextField(5);
    rows.setBounds(120, 38, 86, 25);
    collumns = new JTextField(5);
    collumns.setBounds(120, 74, 86, 25);
    name = new JTextField(10);
    name.setBounds(120, 110, 184, 25);
    JButton okButton = new JButton("OK");
    okButton.setBounds(120, 164, 86, 32);
    okButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	boolean def=false;
                if(input.rows.getText().equals("")){
                	array[0] = "50";
                	def=true;
                }
                else{
                	array[0] = input.rows.getText();
                }
                if(input.collumns.getText().equals("")){
                	array[1] = "50";
                	def=true;
                }
                else{
                	array[1] = input.collumns.getText();
                }
                if(input.name.getText().equals("")){
                	array[2] = "defaultName";
                	def=true;
                }
                else{
                	array[2] = input.name.getText();
                }
                if (def==true){
					JOptionPane.showMessageDialog(null, "You have entered a default table", "Warning",
		                    JOptionPane.INFORMATION_MESSAGE);
                }
                dialog.dispose();
            }

    });
    dialog.getContentPane().setLayout(null);
    dialog.getContentPane().add(rows);
    dialog.getContentPane().add(collumns);
    dialog.getContentPane().add(name);
    dialog.getContentPane().add(okButton);
    
    JLabel lblRows = new JLabel("Rows");
    lblRows.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblRows.setBounds(10, 32, 66, 32);
    dialog.getContentPane().add(lblRows);
    
    JLabel lblCollumns = new JLabel("Collumns");
    lblCollumns.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblCollumns.setBounds(10, 78, 78, 14);
    dialog.getContentPane().add(lblCollumns);
    
    JLabel lblName = new JLabel("Name");
    lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblName.setBounds(10, 115, 46, 14);
    dialog.getContentPane().add(lblName);
    dialog.pack();     
}


public static void main(String args []){
    getInput("Dialog",null);
    //System.out.println(s);
}
}