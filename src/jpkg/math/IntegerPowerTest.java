package jpkg.math;

import org.junit.Test;

import jpkg.test.TestManager;
import static jpkg.math.IntegerPower.intPower;
import static org.junit.Assert.*;

public class IntegerPowerTest {

	public static void main(String[] args) {
		test();
		TestManager.runTests();
	}
	
	public static void test() {
		TestManager.addTest(IntegerPowerTest.class);
	}
	
	@Test
	public void testPowerEdgeCases() {
		assertEquals(0, intPower(0, 1));
		assertEquals(0, intPower(0, 71));
		assertEquals(1, intPower(1, 0));
		assertEquals(1, intPower(100, 0));
		assertEquals(1, intPower(-1, 0));
		assertEquals(-1, intPower(-1, 71));
	}
	
	@Test
	public void testPowerLargeNums() {
		assertEquals(1_048_576, intPower(4, 10));
		assertEquals(244_140_625, intPower(25, 6));
		assertEquals(244_140_625, intPower(25, 6));
		assertEquals(165_312_903_998_914_816L, intPower(142, 8));
		assertEquals(4_611_686_014_132_420_609L, intPower(Integer.MAX_VALUE, 2));
	}
}
