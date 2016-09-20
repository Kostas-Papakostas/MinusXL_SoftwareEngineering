package minusxlcharts;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class BarChart extends ApplicationFrame {

	   private static final long serialVersionUID = 1L;
	   private String title="",titleX="",titleY="",rowKeys[],columnKeys[];
	   final DefaultCategoryDataset dataset;
		
	   public BarChart() {
	       super("Bar Chart");
	       dataset = new DefaultCategoryDataset();
	   }
	   
	   public void createChart(String array[][]) {
	       
		   CategoryDataset dataset2 = createDataset(array); 
	       final JFreeChart chart = ChartFactory.createBarChart(title,titleX,titleY,dataset2,PlotOrientation.VERTICAL,true,true,false);
	       final ChartPanel chartPanel = new ChartPanel(chart);
	       chartPanel.setPreferredSize(new Dimension(500, 270));
	       setContentPane(chartPanel);
	       
	   }
   
	   public void windowClosing(final WindowEvent evt){
		  if(evt.getWindow() == this){
			  dispose();
		 }
	   }


	   private CategoryDataset createDataset(String array[][]) {
	       int counter1 = -1 , counter2 = 0;
	       columnKeys = new String[array.length-1];
	       rowKeys = new String[array[0].length-1];
	       
		   for(int i=1;i<array.length;i++){
			   columnKeys[i-1] = array[0][i];
		   }
		   for(int i=1;i<array[0].length;i++){
			   rowKeys[i-1] = array[i][0];
		   }	   
		   for(int i=1;i<array.length;i++){
			   counter1++;
			   for(int j=1;j<array[0].length;j++){
				   dataset.addValue(Double.parseDouble(array[i][j]), columnKeys[counter1],rowKeys[counter2] );
				   counter2++;
			   }
			   counter2=0;
		   }
	       return dataset;  
	   }
   
	   
	   public void identifyInput(String output){
			int counter = 0;
			for (int i = 0; i < output.length(); i++){
				if(output.charAt(i) != '/'){
					title += output.charAt(i);
					counter++;
				}
				else{
					counter++;
					break;
				}
			}
			output = output.substring(counter);
			counter = 0;
			for (int i = 0; i < output.length(); i++){
				if(output.charAt(i) != '/'){
					titleX += output.charAt(i);
					counter++;
				}
				else{
					counter++;
					break;
				}
			}
			output = output.substring(counter);
			counter = 0;
			for (int i = 0; i < output.length(); i++){
				if(output.charAt(i) != '/'){
					titleY += output.charAt(i);
					counter++;
				}
				else{
					counter++;
					break;
				}
			}
	  }
}

