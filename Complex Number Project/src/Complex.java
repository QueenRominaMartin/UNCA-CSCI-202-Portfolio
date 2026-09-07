package csci_complex_numbers;

public class Complex {
	
	double real;
	double imaginary;
	double magnitude;
	double angle;
	
	/**
	 * Creates an object representing a complex number in the format of <br>
	 * a + bi <br>
	 * in which: <br>
	 * a = the real number <br>
	 * b = the coefficient of the imaginary number <br>
	 * i = the imaginary number, √-1
	 * @param r - the real number
	 * @param imag - the coefficient of i, the imaginary number
	 */
	public Complex(double r, double imag) {
		real = r;
		imaginary = imag;
		magnitude = magnitude();
		angle = angle();
	}
	
	public Complex(double r) {
		this(r, 0);
	}
	
	/* METHODS */
	
	public double getReal() {
		return real;
	}
	public double getImaginary() {
		return imaginary;
	}
	
	public void setReal(double r) {
		real = r;
	}
	public void setImaginary(double imag) {
		imaginary = imag;
	}
	
	/* Arithmetic Methods */
	
	/**
	 * Calculates the magnitude of the complex number <br>
	 * |Z| = √(a^2 + b^2)
	 * @return the magnitude
	 */
	public double magnitude() {
		return Math.sqrt( 
				(Math.pow(real, 2)) + (Math.pow(imaginary, 2)) );
	}
	
	/**
	 * Calculates the angle of the complex number <br>
	 * θ = arctan(b / a )
	 * @return the angle
	 */
	public double angle() {
		return Math.atan2(imaginary, real);
	}
	
	/**
	 * Adding two complex numbers together.
	 * To add two complex numbers together you add the real parts together and the imaginary parts
	 * together.
	 * @param comp2 - The second complex number to add to the first one
	 * @return the complex number resulting from the addition
	 */
	public Complex addition(Complex comp2) {
		return new Complex(real + comp2.getReal(), imaginary + comp2.getImaginary());
	}
	
	/**
	 * An overload function of the addition method to add a real number to the complex number
	 * @see addition
	 */
	public Complex addition(double r) {
		return new Complex(real + r, imaginary);
	}
	
	/**
	 * Subtracting one complex number from another
	 * To subtract two complex numbers, distribute the subtraction sign and then sum up the real numbers
	 * and then sum up the imaginary numbers.
	 * @param comp2 - the complex number to subtract from the first one
	 * @return - the complex number resulting from the 
	 */
	public Complex subtraction(Complex comp2) {
		double real2 = -1 * comp2.getReal();
		double imag2 = -1 * comp2.getImaginary();
		return new Complex(real + real2, imaginary + imag2);
	}
	
	/**
	 * An overload function of the subtraction method
	 * @see subtraction
	 */
	public Complex subtraction(double r) {
		return new Complex(real - r, imaginary);
	}
	
	/**
	 * Multiplies two complex numbers together
	 * ( a1 + b1i ) * ( a2 + b2i )
	 * @param comp2 - the second complex number to multiply by
	 * @return the product of the multiplication
	 */
	public Complex multiplication(Complex comp2) {
		double realSum = real * comp2.getReal();
		double imag1 = real * comp2.getImaginary();
		double imag2 = imaginary * comp2.getReal();
		double realSum2 = -1 * imaginary * comp2.getImaginary();
		return new Complex(realSum + realSum2, imag1+imag2);
	}
	
	/**
	 * Overload function of the multiplication function for multiplying by a real number
	 * r( a + bi)
	 * @see multiplication
	 */
	public Complex multiplication(double r) {
		return new Complex(r * real, r * imaginary);
	}
	
	/**
	 * Divides one complex number by this complex number
	 * @param comp2 - the complex number to divide this one by
	 * @return - the result of the division
	 */
	public Complex division(Complex comp2) {
		double newReal = ( real * comp2.getReal() + imaginary * comp2.getImaginary() ) /
				( (Math.pow(comp2.getReal(), 2)) + Math.pow(comp2.getImaginary(), 2)  );
		double newImag = ( imaginary * comp2.getReal() - real * comp2.getImaginary() ) /
				( (Math.pow(comp2.getReal(), 2)) + Math.pow(comp2.getImaginary(), 2)  );
		return new Complex(newReal, newImag);
	}
	
	/**
	 * Overload method of division to divide by a real number
	 * @see division
	 */
	public Complex division(double r) {
		return new Complex(real / r, imaginary / r);
	}
	
	// TODO want to implement a rounding method that rounds the doubles to the nearest specified
	// decimal place, with a value of 0 meaning to round to the nearest integer.
	
	
	/* Other Methods */
	
	/**
	 * Writes out the complex number in its notation.
	 * @return the complex number written out as a string in its standard notation
	 */
	public String toString() {
		if(real == 0.0) {
			return(imaginary + "i");
		}
		if(imaginary == 0.0) {
			return(real + "");
		}
		return(real + " + " + imaginary + "i");
	}
	
	/**
	 * Writes out the complex number in its polar form
	 * @return the complex number written out as a string in its polar form
	 */
	public String toStringPolarForm() {
		return( "(" + magnitude + " , " + angle + ")");
	}
	
	/**
	 * Compares the complex number object to another object
	 * @return if the object is equal to the complex number or the object
	 */
	public boolean equals(Object that) {
		if(this == that) {
			return true;
		}
		if(that == null) {
			return false;
		}
		if(this.getClass() != that.getClass()) {
			return false;
		}
		Complex comp2 = (Complex) that;
		return real == comp2.getReal() && imaginary == comp2.getImaginary();
	}
	
	/**
	 * Compares two complex numbers by comparing their real and imaginary coefficients
	 * @param comp2 - the complex number to compare to.
	 * @exception NullPointerException cannot compare a complex number to a null value
	 * @return
	 * 0 - the two complex numbers are equal to each other <br>
	 * 1 - this complex number is greater than comp2 <br>
	 * -1 - comp2 is greater than this complex number
	 */
	public int compareTo(Complex comp2) {
		if(comp2 == null) {
			throw new NullPointerException("Cannot compare to a null value!");
		}
		if(real == comp2.getReal()) {
			if(imaginary > comp2.getImaginary()) {
				return 1;
			} else if(imaginary < comp2.getImaginary()) {
				return -1;
			}
			return 0;
		} else if(real > comp2.getReal()) {
			return 1;
		}
		return -1;
	}

}
