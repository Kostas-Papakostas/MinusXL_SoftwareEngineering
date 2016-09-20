package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import minusxldatamanagment.*;

public class StringFunctionTest {

	StringFunction function = new StringFunction();
	
	@Test
	public void test1() {
		String someFunction[] = {"Concat","Includes","Remove"};
		String functionExpectedResults[] = {"Hi mom mom","true","Hi"};
		String output;
		for(int i=0; i<someFunction.length;i++){
			output = function.CalculateValue("Hi mom" ," mom" , someFunction[i]);
			System.out.println(output);
			assertEquals(functionExpectedResults[i] ,output);
		}		
		output = function.CalculateValue("Hey lad","Trim");
		assertEquals("Heylad",output);
	}
}
