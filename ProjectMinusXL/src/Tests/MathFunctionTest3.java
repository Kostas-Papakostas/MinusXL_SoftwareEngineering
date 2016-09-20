package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import minusxldatamanagment.*;

public class MathFunctionTest3 {

	@Test
	public void test() {
		MathFunction function = new MathFunction();
		String someFunction[] = {"sum","mult","max","min","Mean","Median"};
		double functionInput[] = {1.0 ,2.0 ,3.0 ,4.0};
		double functionExpectedResults[] = {10.0 ,24.0 ,4.0 ,1.0 ,2.5 ,2.5};
		double output;
		for(int i=0; i<someFunction.length;i++){
			output = Double.parseDouble(function.CalculateValue(functionInput , someFunction[i] ,4));
			assertEquals(functionExpectedResults[i] ,output ,Double.MIN_VALUE);
		}		
	}
}
