package minusxlgui;

import java.awt.EventQueue;

import javax.swing.JDialog;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;


public class NewWorkbook {

	private JDialog dialog;
	private JTextField textField;
	private JLabel lblName;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewWorkbook window = new NewWorkbook();
					window.dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NewWorkbook() {
		initialize();
	}

	private void initialize() {
		dialog = new JDialog();
		dialog.setResizable(false);
		dialog.setMinimumSize(new Dimension(200, 200));
		dialog.setMaximumSize(new Dimension(200, 200));
		dialog.setBounds(100, 100, 304, 184);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setTitle("New Workbook");
		dialog.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(99, 47, 146, 30);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		dialog.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnYes = new JButton("Create");
		btnYes.setBounds(99, 104, 89, 23);
		btnYes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		dialog.getContentPane().add(btnYes);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblName.setBounds(10, 47, 57, 30);
		dialog.getContentPane().add(lblName);
		btnYes.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});		
		dialog.setVisible(true);
	}
}
