package Tests;

import static org.junit.Assert.*;
import minusxldatamanagment.*;
import minusxldatamanagment.MathFunction;

import org.junit.Test;

public class MathFunctionTest2 {

	@Test
	public void test() {
			MathFunction function = new MathFunction();
			double output = Double.parseDouble(function.CalculateValue(2 ,2 , "pow"));
			assertEquals(4 ,output ,Double.MIN_VALUE);	
	}
}
