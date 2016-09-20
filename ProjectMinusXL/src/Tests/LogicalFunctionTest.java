package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import minusxldatamanagment.*;

public class LogicalFunctionTest {

	LogicalFunction function = new LogicalFunction();
	
	@Test
	public void test1() {
		String someFunction[] = {"and","xor","or"};
		String functionExpectedResults[] = {"0","1","1"};
		String output;
		for(int i=0; i<someFunction.length;i++){
			output = function.CalculateValue(0 ,1 , someFunction[i]);
			assertEquals(functionExpectedResults[i] ,output);
		}		
	}
}
