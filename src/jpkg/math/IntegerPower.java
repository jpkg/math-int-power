package jpkg.math;

public final class IntegerPower {

	private static transient final short bit_set[] = {
		0, 1, 2, 2, 3, 3, 3, 3,
		4, 4, 4, 4, 4, 4, 4, 4,
		5, 5, 5, 5, 5, 5, 5, 5,
		5, 5, 5, 5, 5, 5, 5, 5,
		6, 6, 6, 6, 6, 6, 6, 6,
		6, 6, 6, 6, 6, 6, 6, 6,
		6, 6, 6, 6, 6, 6, 6, 6,
		6, 6, 6, 6, 6, 6, 6, 6
	};

	public final static long intPower(int base, int exp) {
		// Edge cases and common use cases
		if(base == -1) return 1 - 2 * (exp & 1);
		if(base == 1) return 1;
		if(base == 0 && exp == 0) throw new ArithmeticException("Cannot raise 0 to the 0th power! ");
		if(base == 0) return 0;
		if(exp == 0) return 1;
		if(exp < 0) throw new ArithmeticException("Exponent cannot be negative! ");
		if(exp == 1) return base;
		if(exp > 63) throw new ArithmeticException("Overflow! ");
		
		long tmpbase = base;
		long result = 1;
		int set = bit_set[exp];
		
		if(set > 6)
			return result;

		for(int i = 0; i < set; i++) {
			if ((exp & 1) == 1) result *= tmpbase;
			exp >>= 1;
			tmpbase *= tmpbase;
		}
		
		return result;
	}
}
