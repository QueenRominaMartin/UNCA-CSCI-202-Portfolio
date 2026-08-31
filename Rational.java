package csci202project;

public class Rational {

	private int numerator, denominator;
	private int gcd;

	/* Constructors */
	
	/**
	 * @param num - the numerator
	 * @param den - the denominator
	 * @exception IllegalArgumentException Throws if the den param is 0, as it would result in an 
	 * unreal number
	 */
	public Rational(int num, int den) {
		if(den == 0) {
			throw new IllegalArgumentException("Denominator cannot be 0");
		}
		if(den < 0) {
			num = num * -1;
			den = den * -1;
		}
		if(num == 0) {
			den = 1;
		}
		gcd = gcd(num, den);
		// Using the GCD to simplify the rational number
		numerator = num / gcd;
		denominator = den / gcd;
		
	}
	
	public Rational(int num) {
		this(num, 1);
	}
	
	/* METHODS */
	
	/* Getters */
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public int getGCD() {
		return gcd;
	}
	
	/* Setters */
	public void setNumerator(int num) {
		numerator = num;
	}
	public void setDenominator(int den) {
		if(den == 0) {
			throw new IllegalArgumentException("Denominator cannot be 0.");
		} else {
			denominator = den;
		}
	}
	
	/* Arithmetic Methods */
	
	/**
	 * Calculates the Greatest Common Denominator (GCD) of the two numbers provided
	 * (Usually the numerator and denominator of the rational number)
	 * @param num1
	 * @param num2
	 * @return - the Greatest Common Denominator
	 */
	public static int gcd(int num1, int num2) {
		num1 = Math.abs(num1);
		num2 = Math.abs(num2);
		if(num1 == 0) {
			return num2;
		}
		if(num2 == 0) {
			return num1;
		}
		while(num1 != num2) {
			if(num1 > num2) {
				num1 = num1 - num2;
			} else {
				num2 = num2 - num1;
			}
		}
		return num1;
	}
	
	/**
	 * Adds two rational number objects together
	 * @param rat2 - the second rational number to add by
	 * @return - The rational number that is a result of the addition
	 */
	public Rational add(Rational rat2) {
		int newNum = ( getNumerator() * rat2.getDenominator() ) 
				+ ( rat2.getNumerator() * getDenominator() ) ;
		int newDen = ( getDenominator() * rat2.getDenominator() );
		return new Rational(newNum, newDen);
	}
	
	/**
	 * An override function of add for adding an integer instead of a Rational number
	 * @see add
	 */
	public Rational add(int integer) {
		return add(new Rational(integer));
	}
	
	/**
	 * Subtracts a rational number object from another one
	 * @param rat2 - the rational number to subtract by
	 * @return - The rational number that is a result of the subtraction
	 */
	public Rational subtract(Rational rat2) {
		int newNum =  ( getNumerator() * rat2.getDenominator() ) 
				- ( rat2.getNumerator() * getDenominator() ) ;
		int newDen = ( getDenominator() * rat2.getDenominator() );
		return new Rational(newNum, newDen);
	}
	
	/**
	 * An override function of subtract for subtracting an integer from the rational number instead of
	 * another rational number
	 * @see subtract
	 */
	public Rational subtract(int integer) {
		return subtract(new Rational(integer));
	}
	
	/**
	 * Multiplies two rational numbers objects together
	 * @param rat2 - the second rational number to multiply this one by
	 * @return the rational number that results from multiplying the two together
	 */
	public Rational multiply(Rational rat2) {
		return new Rational(this.getNumerator() * rat2.getNumerator(), 
				this.getDenominator() * rat2.getDenominator());
	}
	/**
	 * Multiplies the rational number by the integer passed through the method
	 * @param integer - the number to multiply the rational number by
	 * @return - the product of the multiplication
	 */
	public Rational multiply(int integer) {
		return new Rational(this.getNumerator() * integer, this.getDenominator());
	}
	
	/**
	 * Divides two instances of the Rational number class by each other.
	 * @exception Arithmetic Throws an exception if the operation will result in an unreal 
	 * number
	 * @param rat2 - the other instance of the Rational class to divide
	 * @return - the Rational number resulting of the division
	 */
	public Rational divide(Rational rat2) {
		int newNum = this.getNumerator() * rat2.getDenominator();
		int newDen = this.getDenominator() * rat2.getNumerator();
		if(newNum == 0) {
			throw new ArithmeticException("Cannot divide " + this.toString() + " by " + rat2.toString());
		}
		return new Rational(newNum, newDen);
	}
	
	/**
	 * @param integer - the integer to divide the Rational number by
	 * @return - the rational number that results from the division.
	 */
	public Rational divide(int integer) {
		return new Rational(this.getNumerator(), 
				this.getDenominator() * integer);
	}
	
	
	/**
	 * @exception Arthmetic - Throws an exception if the numerator of the rational number is 0
	 * which would result in an unreal number being produced by the operation.
	 * @return the reciprocal of the Rational number
	 * for example if the number is 4/3, the method returns 3/4
	 */
	public Rational reciprocal() {
		if(numerator ==  0) {
			throw new ArithmeticException("A reciprocal for " + toString() + " does not exist");
		}
		return new Rational(denominator, numerator);
	}
	
	/* Other Methods */
	
	/**
	 * Method to write out the rational number
	 * @return the String to return
	 */
	public String toString() {
		if(denominator == 1 ) {
			return " " + getNumerator() + " ";
		}
		return " " + getNumerator() + " / " + getDenominator() + " ";
	}
	
	/**
	 * @return the rational number as a floating point decimal
	 */
	public double toDouble() {
		return (double) getNumerator() / (double) getDenominator();
	} 
	
	/**
	 * Compares two rational numbers to each other
	 * @param that - the Object to compare to
	 * @return true if the value of the two Rational numbers are equal and
	 * false if they are not.
	 */
	public boolean equals(Object that) {
		if(this == that) {
			return true;
		}
		if(that == null) {
			return false;
		}
		if(getClass() != that.getClass()) {
			return false;
		}
		Rational rat2 = (Rational) that;
		return numerator == rat2.getNumerator() && denominator == rat2.getDenominator();
	}
	
	/**
	 * Compares the value of two rational objects together
	 * @exception NullPointerException if it tries to compare to a null object
	 * @param rat2 - the second rational object to compare the first to
	 * @return 0 - the two rational numbers are equal
	 * 1 - this rational number is greater than rat2
	 * -1 = rat2 is greater than this rational number
	 */
	public int compareTo(Rational rat2) {
		if(rat2 == null) {
			throw new NullPointerException("Cannot compare to a null value!");
		}
		if(numerator == rat2.getNumerator() && denominator == rat2.getDenominator()) {
			return 0;
		}
		if(numerator * rat2.getDenominator() > denominator * rat2.getNumerator()) {
			return 1;
		}
		return -1;
	}
	
	
	
}
