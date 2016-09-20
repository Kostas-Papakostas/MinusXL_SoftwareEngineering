package minusxlcharts;


import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineChart extends JFrame {

   private static final long serialVersionUID = 1L;
   private String title="",titleX="",titleY="";
   private final XYSeriesCollection dataset;

   public LineChart() {
        super("Line Chart");
        dataset = new XYSeriesCollection();
   }
   
   public void windowClosing(final WindowEvent evt){
	   if(evt.getWindow() == this){
		   dispose();
	   }
	}
   
   
   public void createLineChart(String array[][]){
       JFreeChart pieChart = ChartFactory.createXYLineChart(title, titleX, titleY,
    		   		createDataset(array),PlotOrientation.VERTICAL, true, true, false);
       ChartPanel chartPanel = new ChartPanel(pieChart);
       chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
       setContentPane(chartPanel);
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
   private int[] getNumbers(String string){
	   int counter = 0,array[] = new int[2];
	   String temp = "";
	   string = string.replaceAll("[()]", "");
	   for(int i=0;i<string.length();i++){          // make them numbers
		   if(string.charAt(i) == ','){
			   array[counter] = Integer.parseInt(temp);
				   temp = "";
				   counter++;
		   }
		   else{ 
				   temp += string.charAt(i);
		   }
	   }
	   array[counter] = Integer.parseInt(temp);
	   return array;
   }
   
   private XYSeriesCollection createDataset(String array[][]){
	
	   for(int i=0;i<array.length;i++){
		   final XYSeries series = new XYSeries(array[i][0]);
		   for(int j=1;j<array[i].length;j++){
			  int tempArray[] = getNumbers(array[i][j]);
			  series.add(tempArray[0],tempArray[1]);
		   }
		   dataset.addSeries(series);
	   }
	   return dataset;
   }
  
}
