package minusxlgui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;


public class SaveWorkbook {

	private JFrame frame;
	private JTextField txtTheNewSpreadsheet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveWorkbook window = new SaveWorkbook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SaveWorkbook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtTheNewSpreadsheet = new JTextField();
		txtTheNewSpreadsheet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTheNewSpreadsheet.setHorizontalAlignment(SwingConstants.CENTER);
		txtTheNewSpreadsheet.setText("Do you want to save the contents of your workbook? ");
		txtTheNewSpreadsheet.setEditable(false);
		txtTheNewSpreadsheet.setBorder(null);
		txtTheNewSpreadsheet.setBounds(10, 66, 414, 73);
		frame.getContentPane().add(txtTheNewSpreadsheet);
		txtTheNewSpreadsheet.setColumns(10);
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.setBounds(46, 171, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNo = new JButton("No");
		btnNo.setBounds(253, 171, 89, 23);
		frame.getContentPane().add(btnNo);
	}
}
