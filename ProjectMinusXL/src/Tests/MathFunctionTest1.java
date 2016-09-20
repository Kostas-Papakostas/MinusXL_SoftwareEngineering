package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import minusxldatamanagment.*;

public class MathFunctionTest1 {

	MathFunction function = new MathFunction();
	
	@Test
	public void test1() {
		String someFunction[] = {"sin","cos","tan","abs",};
		double functionExpectedResults[] = {0.0 ,1.0 ,0.0 ,0.0};
		double output;
		for(int i=0; i<someFunction.length;i++){
			output = Double.parseDouble(function.CalculateValue(0 , someFunction[i]));
			assertEquals(functionExpectedResults[i] ,output ,Double.MIN_VALUE);
		}
		output = Double.parseDouble(function.CalculateValue(1 ,"log10"));
		assertEquals(0.0 ,output ,Double.MIN_VALUE);
		
	}
}
