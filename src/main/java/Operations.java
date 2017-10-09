public class Operations {
	public static void add(DoubleStack stack) {
		Double number1 = stack.pop();
		Double number2 = stack.pop();
		stack.push(number1 + number2);
	}

	public static void subtract(DoubleStack stack) {
		Double number1 = stack.pop();
		Double number2 = stack.pop();

		stack.push(number2 - number1);
	}

	public static void multiply(DoubleStack stack) {
		Double number1 = stack.pop();
		Double number2 = stack.pop();

		stack.push(number1 * number2);
	}

	public static void divide(DoubleStack stack) {
		Double number1 = stack.pop();
		Double number2 = stack.pop();

		stack.push(number2 / number1);
	}

	public static void power(DoubleStack stack) {
		Double power = stack.pop();
		Double number = stack.pop();

		stack.push(powerRecursion(number, power.intValue()));
	}

	private static Double powerRecursion(Double number, int power) {
		if (power == 1) {
			return number;
		}

		return (number * powerRecursion(number, power - 1));
	}
}