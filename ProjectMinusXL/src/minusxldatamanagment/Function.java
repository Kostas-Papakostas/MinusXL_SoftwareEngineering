package minusxldatamanagment;

public abstract class Function {
    
    public abstract String CalculateValue(double Source,String mathematics);
    public abstract String CalculateValue(String input,String function);
    public abstract String CalculateValue(String input1,String input2,String function);
    public int checkValidity(String function){
        if(function.equals("pow")){
     	   return 1;
        }
        if(function.equals("min")||function.equals("max")||function.equals("mult")||function.equals("sum")
        		||function.equals("Mean")||function.equals("Median")||function.equals("StdDev")){
     	   return 2;
        }
        if(function.equals("sin")||function.equals("cos")||function.equals("tan")||function.equals("abs")
     		   ||function.equals("log")||function.equals("log10")){
     	   return 3;
        }
        if(function.equals("not")){
      	   return 4;
        }
        if(function.equals("and")||function.equals("xor")||function.equals("or")){
      	   return 5;
        }
        if(function.equals("Concat")||function.equals("Includes")||function.equals("Remove")){
        	return 6;
        }
        if(function.equals("Trim")){
        	return 7;
        }
        return 0;
    };
     
}