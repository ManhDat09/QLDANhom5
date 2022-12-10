package xulyloi;

public class ThrowTest {
	static void validate (int age) {
		try {
		if (age < 0)
			throw new ArithmeticException("not valid");
			else 
				System.out.println("valid");
	 } catch (ArithmeticException ex) {
		System.out.println(ex.getMessage());
	}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		validate(-2);
		System.out.println("rest of the code...");

	}

}
