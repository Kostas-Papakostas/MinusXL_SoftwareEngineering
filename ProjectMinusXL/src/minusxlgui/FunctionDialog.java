package minusxlgui;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

import minusxldatamanagment.*;

	public class FunctionDialog{
	
	    private JDialog dialog;
	    private JTextField function;
	    private JTextField fromCell;
	    private JTextField outputCell;
	    private JTextField toCell;
	    private static FunctionExecute exec=new FunctionExecute();
	    private static FunctionDialog input;
	    private int tableindex;
	    
	    
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public FunctionDialog (String title, JFrame frame){
	    dialog = new JDialog(frame, title, true);
	    dialog.setResizable(false);
	    dialog.setFont(new Font("Dialog", Font.PLAIN, 14));
	    dialog.setTitle("Functions");
	    dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);   //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    dialog.setMinimumSize(new Dimension(450, 320));
	    init();
	}
	
	public void setVisible(Boolean flag){
	    dialog.setVisible(flag);
	}
	
	public static String getInput(String title, JFrame frame,int tableindex){
		
		
		input = new FunctionDialog (title, frame);
	    input.setVisible(true);
	    tableindex=tableindex;
	    return null;
	}
	
	private void init(){
	
	    function = new JTextField(5);
	    function.setBounds(180, 126, 136, 23);
	    fromCell = new JTextField(10);
	    fromCell.setBounds(115, 74, 86, 23);
	    outputCell = new JTextField(5);
	    outputCell.setBounds(180, 183, 86, 31);
	    JLabel FunctionLabel = new JLabel("Input Function");
	    FunctionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    FunctionLabel.setBounds(58, 124, 143, 23);
	    JLabel InputLabel = new JLabel("Input Cell(s)\r\n");
	    InputLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    InputLabel.setBounds(115, 0, 86, 78);
	    JLabel outputLabel = new JLabel("Output Cell");
	    outputLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    outputLabel.setBounds(58, 183, 86, 31);
	    JButton okButton = new JButton("OK");
	    okButton.setBounds(211, 246, 86, 23);
	    okButton.addActionListener(new ActionListener(){
	
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	Workbook workbook=Workbook.getInstance();
	            	String from=input.fromCell.getText();
	        		String to=input.toCell.getText();
	        		String func=input.function.getText();
	        		String output=input.outputCell.getText();
	        		Spreadsheet spr;
	        		if(from.equals("")||func.equals("")||output.equals("")){
	        			JOptionPane.showMessageDialog(null, "Less inputs than expected ", "Error",
	                            JOptionPane.ERROR_MESSAGE);
	        		}else{
		        			        		
		            	spr=workbook.getRequestedSpreadsheet(tableindex);
		            	exec.execution(from,to,output,func,tableindex);
	        		}
	                dialog.dispose();
	            }
	
	    });
	    dialog.getContentPane().setLayout(null);
	
	    dialog.getContentPane().add(FunctionLabel);
	    dialog.getContentPane().add(function);
	    dialog.getContentPane().add(InputLabel);
	    dialog.getContentPane().add(fromCell);
	    dialog.getContentPane().add(outputLabel);
	    dialog.getContentPane().add(outputCell);
	    dialog.getContentPane().add(okButton);
	    
	    JLabel lblFrom = new JLabel("From");
	    lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    lblFrom.setBounds(58, 77, 46, 14);
	    dialog.getContentPane().add(lblFrom);
	    
	    JLabel label = new JLabel("-");
	    label.setFont(new Font("Tahoma", Font.BOLD, 22));
	    label.setBounds(223, 78, 46, 14);
	    dialog.getContentPane().add(label);
	    
	    JLabel lblTo = new JLabel("To/Power");
	    lblTo.setFont(new Font("Dialog", Font.PLAIN, 14));
	    lblTo.setBounds(255, 73, 69, 21);
	    dialog.getContentPane().add(lblTo);
	    
	    toCell = new JTextField();
	    toCell.setBounds(334, 75, 86, 20);
	    dialog.getContentPane().add(toCell);
	    toCell.setColumns(10);
	    dialog.pack();     
	}
	
	public static void main(String args []){
	    getInput("Dialog",null,(Integer) null);
	}
}