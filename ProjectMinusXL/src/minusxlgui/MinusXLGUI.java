package minusxlgui;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.jfree.ui.RefineryUtilities;
import minusxlcharts.*;
import minusxldatamanagment.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.table.TableModel;
import javax.swing.event.*;


public class MinusXLGUI{
	private JFrame MinusXL;
	private JMenuBar menuBar;
	private JMenu menuEdit;
	private JMenu menuFile;
	private JMenu menuSpreadsheet;
	private JMenu menuTools;
	private JMenu menuHelp;
	private JMenu menuCharts;
	private JMenuItem menuItemNew;
	private JMenuItem menuItemOpen;
	private JMenuItem menuItemSave;
	private JMenuItem menuItemExit;
	private JMenuItem menuItemUndo;
	private JMenuItem menuItemLineChart;
	private JMenuItem menuItemSaveWorkbook;
	private JMenuItem menuItempreadsheet;
	private JMenuItem menuItemHelpForMinusxl;
	private JMenuItem menuItemFunctions;
	private JMenuItem menuItemSpreadsheet;
	private JMenuItem menuItemBarChart;
	private JTable table;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane;
	private JPanel tablePanel;
	private Spreadsheet sp1;
	private LineChart lineChart;
	private BarChart barChart;
	Workbook workbook;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MinusXLGUI window = new MinusXLGUI();
					window.MinusXL.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	public MinusXLGUI() {
		initialize();
	}
	
	private void initialize() {
		MinusXL = new JFrame();
		MinusXL.setSize(new Dimension(1366, 768));
		MinusXL.setMaximumSize(new Dimension(1366, 768));
		MinusXL.setTitle("MinusXL");
		MinusXL.setBounds(0,0, 1366, 730);
		MinusXL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
		workbook = Workbook.getInstance();
		
		menuBar = new JMenuBar();
		MinusXL.setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		menuItemNew = new JMenuItem("New Workbook");
		menuItemNew.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				MinusXL.setTitle(NewWorkbookDialog.getInput("New Workbook", MinusXL));
				while (tabbedPane.getTabCount() > 1) {
					tabbedPane.remove(1);
				}
				tabbedPane.remove(0);
				sp1=workbook.updateSpreadsheetList();
				workbook.printNames();
				workbook.addSpreadsheet(sp1);
				newSpreadsheetGui("Spreadsheet");
			}
			
		});
		menuFile.add(menuItemNew);
		
		menuItemSaveWorkbook = new JMenuItem("Save Workbook");
		menuItemSaveWorkbook.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				SaveWorkbookDialog.getInput("Save workbook", MinusXL);
			}
		});	
		menuFile.add(menuItemSaveWorkbook);
			
		menuItemOpen = new JMenuItem("Open...");
		menuItemOpen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				LoadSpreadsheetFromCSVFile.getInput("New Spreadsheet", MinusXL);
			}
		});
		menuFile.add(menuItemOpen);
		
		menuItemSave = new JMenuItem("Save");
		menuItemSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				SaveSpreadsheetAsCSV.getInput("New Spreadsheet", MinusXL);
			}
		});	
		menuFile.add(menuItemSave);
		
		menuItemExit = new JMenuItem("Exit");
		menuItemExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
		    }
		});
		menuFile.add(menuItemExit);
		
		menuSpreadsheet = new JMenu("Spreadsheet");
		menuBar.add(menuSpreadsheet);
		
		menuItemSpreadsheet = new JMenuItem("Add SpreadSheet");
		menuItemSpreadsheet.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				String array[] =  NewSpreadsheetDialog.getInput("New Spreadsheet", MinusXL);
				sp1=new Spreadsheet(Integer.parseInt(array[0]),Integer.parseInt(array[1]),(array[2]));
				workbook.addSpreadsheet(sp1);
				newSpreadsheetGui(array[2]);
		
			}
		});
		menuSpreadsheet.add(menuItemSpreadsheet);
		
		menuTools = new JMenu("Tools");
		menuBar.add(menuTools);
		
		menuItemFunctions = new JMenuItem("Functions");
		menuItemFunctions.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				int selectedTab=tabbedPane.getSelectedIndex();
				FunctionDialog.getInput("New Workbook", MinusXL,selectedTab);
			}
		});
		menuTools.add(menuItemFunctions);
		
		menuItempreadsheet = new JMenuItem("Close spreadsheet");
		menuItempreadsheet.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e) {
					int spreadsheetToDelete = DeleteSpreadsheetDialog.getInput("New Spreadsheet", MinusXL);
					if(spreadsheetToDelete>=0 && spreadsheetToDelete<workbook.getNumberOfSpreadsheets()){
						workbook.deleteSpreadsheet(spreadsheetToDelete);
						tabbedPane.remove(spreadsheetToDelete);
					}else{
						JOptionPane.showMessageDialog(null, "Insert the valid number of a spreadsheet", "Warning",
			                    JOptionPane.WARNING_MESSAGE);
					}
				}
		});	
		menuSpreadsheet.add(menuItempreadsheet);
		
		menuCharts = new JMenu("Charts");
		menuBar.add(menuCharts);
		
        menuItemLineChart = new JMenuItem("LineChart");
        menuItemLineChart.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e) {
					String input = CreateChartDialog.getInput("Chart", MinusXL);
					lineChart = new LineChart();
					lineChart.identifyInput(input);
					Spreadsheet spr=workbook.getRequestedSpreadsheet(tabbedPane.getSelectedIndex());
					int selectedRows[] = spr.getSheettable().getSelectedRows();
					int selectedColumns[] = spr.getSheettable().getSelectedColumns();	
					String valuesOfSelectedCells[][] = new String[selectedColumns.length][selectedRows.length];				
					try{
						for(int i=0;i<valuesOfSelectedCells.length;i++){
							for(int j=0;j<valuesOfSelectedCells[i].length;j++){
								valuesOfSelectedCells[i][j] = spr.getSheettable().getValueAt(selectedRows[j], selectedColumns[i]).toString();
							}
						}
						lineChart.createLineChart(valuesOfSelectedCells);
						lineChart.pack();
						lineChart.setVisible(true);
					}catch(NullPointerException message)	{
						JOptionPane.showMessageDialog(null, "Wrong Input : empty cell", "Warning",
			                    JOptionPane.INFORMATION_MESSAGE);
					}
					catch(NumberFormatException message)	{
						JOptionPane.showMessageDialog(null, "Wrong Input : you used a non-numeric character", "Warning",
			                    JOptionPane.INFORMATION_MESSAGE);
					}
				}
		});	
		menuCharts.add(menuItemLineChart);
		
		
		menuItemBarChart = new JMenuItem("BarChart");
		menuItemBarChart.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e) {
					String input = CreateChartDialog.getInput("Chart", MinusXL);
					barChart = new BarChart();
					barChart.identifyInput(input);
					Spreadsheet spr=workbook.getRequestedSpreadsheet(tabbedPane.getSelectedIndex());
					int selectedRows[] = spr.getSheettable().getSelectedRows();
					int selectedColumns[] = spr.getSheettable().getSelectedColumns();	
					String valuesOfSelectedCells[][] = new String[selectedColumns.length][selectedRows.length];
					try{
						for(int i=0;i<valuesOfSelectedCells.length;i++){
							for(int j=0;j<valuesOfSelectedCells[i].length;j++){
								if(spr.getSheettable().getValueAt(selectedRows[j], selectedColumns[i]) !=null){
									valuesOfSelectedCells[i][j] = spr.getSheettable().getValueAt(selectedRows[j], selectedColumns[i]).toString();
								}
							}
						}
						barChart.createChart(valuesOfSelectedCells);
						barChart.pack();
						RefineryUtilities.centerFrameOnScreen(barChart);
						barChart.setVisible(true);
					}catch(NullPointerException message)	{
						JOptionPane.showMessageDialog(null, "Wrong Input : empty cell", "Warning",
			                    JOptionPane.INFORMATION_MESSAGE);
					}
					catch(NumberFormatException message)	{
						JOptionPane.showMessageDialog(null, "Wrong Input : you used a non-numeric character", "Warning",
			                    JOptionPane.INFORMATION_MESSAGE);
					}	
				}
		});	
		menuCharts.add(menuItemBarChart);
		
		menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		
		menuItemHelpForMinusxl = new JMenuItem("Help for MinusXL");
		menuItemHelpForMinusxl.setRolloverEnabled(true);
		menuItemHelpForMinusxl.setIcon(null);
		menuItemHelpForMinusxl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String[] hlpArray = new String[2];
				hlpArray[1]=".//HELP-FOR-MINUSXL.pdf";
				hlpArray[0]="C:\\Program Files (x86)\\Adobe\\Acrobat Reader DC\\Reader\\AcroRd32.exe";
				try {
					Process process = Runtime.getRuntime().exec(hlpArray,null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		menuHelp.add(menuItemHelpForMinusxl);
		
		tablePanel = new JPanel(new BorderLayout());
		MinusXL.getContentPane().setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane();
		MinusXL.getContentPane().add(tabbedPane);
		
		sp1=new Spreadsheet(150,160,"Spreadsheet_1");
		workbook.addSpreadsheet(sp1);
		
	    table = sp1.getSheettable();
        table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));     
        table.setEditingRow(-1);
        table.setEditingColumn(-1);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setAutoCreateRowSorter(true);
        table.setBorder(UIManager.getBorder("TextField.border"));
        table.setSurrendersFocusOnKeystroke(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setPreferredScrollableViewportSize(new Dimension(450, 63));
        table.setFillsViewportHeight(true); 
        table.add(table.getTableHeader(),BorderLayout.NORTH);
        table.getTableHeader().setReorderingAllowed(false);
         
        tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
         
        scrollPane = new JScrollPane();
        tabbedPane.addTab("SpreadSheet_1", null, scrollPane, null);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS); 
        
        JTable rowTable = new RowNumberTable(table);
        scrollPane.setRowHeaderView(rowTable);
        scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER,rowTable.getTableHeader());
        
        scrollPane.setViewportView(table);             
        
  
	    MinusXL.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{table}));
		MinusXL.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{table, MinusXL.getContentPane(), menuBar, menuFile,
									menuItemNew, menuItemOpen, menuItemSave, menuItemExit, menuEdit,
												menuItemUndo, menuSpreadsheet, menuTools,  menuHelp}));
        
	     
	}
	
	private void newSpreadsheetGui(String name){
		JTable newTable = sp1.getSheettable();		    
		newTable.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		newTable.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));     
		newTable.setEditingRow(-1);
		newTable.setEditingColumn(-1);
		newTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		newTable.setAutoCreateRowSorter(true);
		newTable.setBorder(UIManager.getBorder("TextField.border"));
		newTable.setSurrendersFocusOnKeystroke(true);
		newTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		newTable.setColumnSelectionAllowed(true);
		newTable.setCellSelectionEnabled(true);
		newTable.setPreferredScrollableViewportSize(new Dimension(450, 63));
		newTable.setFillsViewportHeight(true); 
		newTable.getTableHeader().setReorderingAllowed(false);
		
		tablePanel.add(newTable.getTableHeader(), BorderLayout.NORTH);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		tabbedPane.addTab(name, null, scrollPane_8, null);	
		scrollPane_8.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS); 
		
		JTable rowTable8 = new RowNumberTable(newTable);
		scrollPane_8.setRowHeaderView(rowTable8);
		scrollPane_8.setCorner(JScrollPane.UPPER_LEFT_CORNER,rowTable8.getTableHeader());
		
		scrollPane_8.setViewportView(newTable);
		
	}
}
