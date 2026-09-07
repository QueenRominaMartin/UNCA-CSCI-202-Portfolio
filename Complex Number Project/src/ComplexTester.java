package csci_complex_numbers;

public class ComplexTester {

	public static void main(String[] args) {

		Complex comp1 = new Complex(6.3, 4.9);
		Complex comp2 = new Complex(12.3, 8.3);
		//Complex comp1 = new Complex(6.383929, 4.934553);
		//Complex comp2 = new Complex(12.3, 8.3);
		
		Object obj = comp1;
		
		System.out.println("Complex 1 : " + comp1);
		System.out.println("Magnitude of Complex 1 : " + comp1.magnitude());
		System.out.println("Angle of Complex 1 : " + comp1.angle());
		
		System.out.println("Complex 2 : " + comp2);
		
		System.out.println("Complex 1 + Complex 2 = " + comp1.addition(comp2));
		System.out.println("Complex 1 + 3 = " + comp1.addition(3));
		System.out.println("Complex 1 - Complex 2 = " + comp1.subtraction(comp2));
		System.out.println("Complex 1 - 3 = " + comp1.subtraction(3));
		
		System.out.println("Complex 1 * Complex 2 = " + comp1.multiplication(comp2));
		System.out.println("Complex 1 * 3 = " + comp1.multiplication(3));
		System.out.println("Complex 1 / Complex 2 = " + comp1.division(comp2));
		System.out.println("Complex 1 / 3 = " + comp1.division(3));
		
		System.out.println("Complex 1 = Complex 2? " + comp1.equals(comp2));
		System.out.println("Complex 1 = obj? " +  comp1.equals(obj));
		
		System.out.println("Compare Complex 1 and Complex 2: " + comp2.compareTo(comp2));
		
	}

}
