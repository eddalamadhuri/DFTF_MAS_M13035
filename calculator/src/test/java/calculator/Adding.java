package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class Adding {
	public class CalculatorTest {
		Calculator cal = new Calculator();
		@Test
		public void test() {
		assertEquals(30,cal.add(10, 20));
		}
	}

}
