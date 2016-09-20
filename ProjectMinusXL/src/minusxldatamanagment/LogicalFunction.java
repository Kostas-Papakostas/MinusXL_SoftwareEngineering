package minusxldatamanagment;

public class LogicalFunction extends Function{
	
    private String resultString;
 
    @Override
    public String CalculateValue(double Source, String Mathematics) {
        int binary=(int)Source;
        int mask = (1 << 32) - 1;
         
        if(Mathematics.equals("not")){
            binary = ~binary & mask;
            resultString=String.valueOf(binary);
            return resultString;
        }
        return null;
    }
 
    public String CalculateValue(double Source, double Source2, String Mathematics) {
        int binary,binary1=(int)Source,binary2=(int)Source2;
         
        if(Mathematics.equals("and")){
            binary=binary1&binary2;
            resultString=String.valueOf(binary);
            return resultString;
        }
        if(Mathematics.equals("xor")){
            binary=binary1^binary2;
            resultString=String.valueOf(binary);
            return resultString;          
        }
        if(Mathematics.equals("or")){
            binary=binary1|binary2;
            resultString=String.valueOf(binary);
            return resultString;          
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