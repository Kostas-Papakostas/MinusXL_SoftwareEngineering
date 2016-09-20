package minusxldatamanagment;

public class StringFunction extends Function{
	
	public String CalculateValue(String input1,String input2,String function){
		String result=null;
		boolean incl=false;
		if(function.equals("Concat")){
			result=input1.concat(input2);
			return result;
		}else if(function.equals("Includes")){
			if(input1.contains(input2)){
				incl=true;
				return String.valueOf(incl);
			}
		}else if(function.equals("Remove")){
			result=input1.replaceAll(input2, "");
		}
		return result;
	}
	
	public String CalculateValue(String input,String function){
		String result=null;
		if(function.equals("Trim")){
			result=input.replaceAll(" ", "");
		}
		return result;
	}

	@Override
	public String CalculateValue(double Source, String Mathematics) {
		return null;
	}

	
}
