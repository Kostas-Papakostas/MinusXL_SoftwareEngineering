package minusxlgui;
	
	import java.awt.*;
	
	import java.awt.event.*;
	import javax.swing.*;
	
public class SaveWorkbookOrNot {	
	    private JDialog dialog;
	    
	
	public SaveWorkbookOrNot(String title, JFrame frame){
	    dialog = new JDialog(frame, title, true);
	    dialog.setTitle("New Workbook");
	    dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);  
	    dialog.setMinimumSize(new Dimension(300, 160));
	    init();
	}
	
	public void setVisible(Boolean flag){
	    dialog.setVisible(flag);
	}
	
	public static String getInput(String title, JFrame frame){
		SaveWorkbookOrNot input = new SaveWorkbookOrNot (title, frame);
	    input.setVisible(true);
	    String workbookName=null;
	    return workbookName;
	}
	
	
	
	
	private void init(){
	    dialog.getContentPane().setLayout(null);
	    
	    JLabel lblName = new JLabel("Save Current workbook or not\r\n");
	    lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblName.setBounds(40, 31, 234, 14);
	    dialog.getContentPane().add(lblName);
	    
	    JButton btnYes = new JButton("Yes");
	    btnYes.setBounds(40, 73, 89, 23);
	    dialog.getContentPane().add(btnYes);
	    btnYes.addActionListener(new ActionListener(){
	    	
            @Override
            /**************************new code****************************/
            public void actionPerformed(ActionEvent e) {
            	SaveWorkbookDialog.getInput("Save workbook", null);
                dialog.dispose();
            }
	    });
	    
	    JButton btnNo = new JButton("No");
	    btnNo.addActionListener(new ActionListener(){
	    	
            @Override
            /**************************new code****************************/
            public void actionPerformed(ActionEvent e) {
            //	SaveWorkbookDialog.getInput("Save workbook", null);
                dialog.dispose();
            }
	    });
	    btnNo.setBounds(155, 73, 89, 23);
	    dialog.getContentPane().add(btnNo);
	    dialog.pack();     
	}
	
	public static void main(String args []){
	    String s = getInput("Dialog",null);
	    System.out.println(s);
	}
}


