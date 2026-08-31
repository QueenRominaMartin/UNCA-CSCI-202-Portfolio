package csci202project;

public class RationalTest {

	public static void main(String[] args) {
		
		Rational rational1 = new Rational(18, 4);
		Rational rational2 = new Rational(5, 7);
		Rational rational3 = new Rational(9, 2);
		
		System.out.println("Rational 1: " + rational1.toString());
		System.out.println("The GDC for Rat 1 is: " + rational1.getGCD());
		System.out.println("Rational 2: " + rational2.toString());
		System.out.println("The GDC for Rat 2 is: " + rational2.getGCD());
		System.out.println("Rational 3: " + rational3.toString());
		
		System.out.println("Rational 1 + Rational 2 = " + rational1.add(rational2));
		System.out.println("Rational 1 - Rational 2 = " + rational1.subtract(rational2));
		
		System.out.println("Rational 1 * Rational 2 = " + rational1.multiply(rational2));
		System.out.println("Rational 1 / Rational 2 = " + rational1.divide(rational2));
		
		System.out.println("Rational 1 == Rational 2 : " + rational1.equals(rational2));
		System.out.println("Rational 1 == Rational 3 : " + rational1.equals(rational3));
		
				
		
	}

}
