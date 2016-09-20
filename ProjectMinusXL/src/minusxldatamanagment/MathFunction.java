package minusxldatamanagment;


import java.util.Arrays;

public class MathFunction extends Function{ 
   private double result;
   private String resultString;
  
   
   public String getresultString() {
       return resultString;
   }
   
   public double getresult() {		
       return result;
   }
    
   public String CalculateValue(double source,String Mathematics) {
       if(Mathematics.equals("sin")){
           result=Math.sin(source);
       }else if(Mathematics.equals("cos")){
           result=Math.cos(source);
       }else if(Mathematics.equals("tan")){
           result=Math.tan(source);
       }else if(Mathematics.equals("abs")){
           result=Math.abs(source);
       }else if(Mathematics.equals("log")){
           result=Math.log(source)/Math.log(2);
       }else if(Mathematics.equals("log10")){
           result=Math.log10(source);
       }
       resultString=String.valueOf(result);
       return resultString;
   }

   public String CalculateValue(double Source, double power, String Mathematics) {
       if(Mathematics.equals("pow")){
           result=Math.pow(Source,power);
           resultString=String.valueOf(result);
           return resultString;
       }
       return null;
   }
   
   
   public String CalculateValue(double[] Source, String Mathematics,int f) {
       double sum=0;
       double mult=1.0;
       double a[]=Source;
       double max = a[0];
       double min=999999999;
       double mean;
       if(Mathematics.equals("sum")){
           for(double i:Source){
               sum+=i;
           }
           result=sum;
           resultString=String.valueOf(result);
           return resultString;
       }
       if(Mathematics.equals("mult")){
    	    System.out.println("res1    "+mult);
           for(int i=0;i<f;i++){
               mult=mult*a[i];
               System.out.println("res    "+mult);
           }
           result=mult;
           resultString=String.valueOf(result);
           return resultString;
       }if(Mathematics.equals("max")){
           for (int i = 1; i < a.length; i++) {
               if (a[i] > max) {
                 max = a[i];
               }
           }
           resultString=String.valueOf(max);
           return resultString;
       }
       if(Mathematics.equals("min")){
           for (int i = 0; i < f; i++) {
               if (a[i] <= min) {
                 min = a[i];
               }
           }
           resultString=String.valueOf(min);
           return resultString;
       }
       if(Mathematics.equals("Mean")){
    	   for (int i = 0; i < f; i++) {
    		   sum+=a[i];
    	   }
    	   mean=sum/f;
           resultString=String.valueOf(mean);
           return resultString;
       }
       if(Mathematics.equals("Median")){
    	   Arrays.sort(a);
    	   int middle = a.length/2;
    	    if (a.length%2 == 1) {
    	        return String.valueOf(a[middle]);
    	    } else {
    	        return String.valueOf((a[middle-1] + a[middle]) / 2.0);
    	    }
       }if(Mathematics.equals("StdDev")){
    	   Arrays.sort(a);
    	   int middle = a.length/2;
    	   double temp = 0;
    	   if (a.length%2 == 1) {
    	       mean=a[middle];
    	   } else {
    	       mean=(a[middle-1] + a[middle]) / 2.0;
    	   }
           
           for(double i :a){
               temp += (mean-i)*(mean-i);
           }
           return String.valueOf(temp);
       }
       return null;
   }
	@Override
	public String CalculateValue(String input, String function) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String CalculateValue(String input1, String input2, String function) {
		// TODO Auto-generated method stub
		return null;
	}
      
}