package minusxldatamanagment;

import javax.swing.*;

public class Spreadsheet {
	
	private String name,content[][];
	private int rows,collumns;
	private JTable Sheettable;
	
	public String[][] getContent() {
		return content;
	}

	public JTable getSheettable(){
		return Sheettable;
	}
	
	public Spreadsheet(int rows,int collumns,String name){
		this.rows = rows;
		this.collumns = collumns;
		this.name = name;
		Sheettable=new JTable(rows,collumns){
		    
            private static final long serialVersionUID = 1L;
          
            public boolean isCellEditable(int row, int column) {
                return true;
            }

		};
	}
	
	public void setSize(int rows,int collumns){
		this.rows = rows;
		this.collumns = collumns;
	}
	
	
	public int getRows(){
		return rows;
	}
	
	
	public int getCollumns(){
		return collumns;
	}
	
	
	public void setName(String name){
		this.name = name;
	}
	
	
	public String getName(){
		return name;
	}
}
