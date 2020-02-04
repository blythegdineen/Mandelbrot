/**
 * @author      Justin Gohde <justin.gohde@trinityschoolnyc.org>
 * @version     1.0                 
 * @since       2013-11-17          
 */
public class ComplexNumber {

	private double a; 
	private double b;
	
	/**
	 * Creates a new ComplexNumber with both real and imaginary components
	 * @param a the real component of the complex number
	 * @param b the imaginary component of the complex number
	 */
	public ComplexNumber(double a, double b){
		this.a = a;
		this.b = b;		
	}
	
	/**
	 * The "copy constructor"
	 * Creates a new ComplexNumber from an existing ComplexNumber
	 * @param c a ComplexNumber
	 */
	public ComplexNumber(ComplexNumber c){
		a = c.getReal();
		b = c.getImaginary();
	}

	public ComplexNumber(){
		a = 1;
		b = 1;
	}
	
	/**
	 * An "accessor" method
	 * Returns the real component of this ComplexNumber
	 * @return a the private real component of this ComplexNumber 
	 */
	public double getReal(){
		return a;
	}
	
	/**
	 * An "accessor" method
	 * Returns the imaginary component of this ComplexNumber
	 * @return b the private imaginary component of this ComplexNumber 
	 */
	public double getImaginary(){
		return b;
	}

	/**
	 * Returns the conjugate of the complex number
	 * (a+bi) returns (a-bi)
	 * @return complexnumber the private conjugate
	 */

	private ComplexNumber conjugate(){
		return new ComplexNumber(this.a, 0-this.b);
	}


	/**
	 * Adds together real and imaginary components of two complex numbers
	 * @param adding
	 * @return c the added complex number
	 */

	public ComplexNumber add(ComplexNumber adding){
		return new ComplexNumber(this.a+adding.getReal(), this.b+adding.getImaginary());
	}

	/**
	 * Adds together real and imaginary components of two complex numbers
	 * @param c1
	 * @param c2
	 * @return c3 the added complex number
	 */

	public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2){
		return new ComplexNumber(c1.getReal()+c2.getReal(), c1.getImaginary()+c2.getImaginary());
	}

	/**
	 * Subtracts the real and imaginary components of two complex numbers
	 * @param subbing
	 * @return c the subtracted complex number
	 */
	
	public ComplexNumber subtract(ComplexNumber subbing){
		return new ComplexNumber(this.a+subbing.getReal(), this.b+subbing.getImaginary());
	}

	/**
	 * Subtracts real and imaginary components of two complex numbers
	 * @param c1
	 * @param c2
	 * @return c3 the subtracted complex number
	 */

	public static ComplexNumber subtract(ComplexNumber c1, ComplexNumber c2){
		return new ComplexNumber(c1.getReal()-c2.getReal(), c1.getImaginary()-c2.getImaginary());
	}

	

   	/**
	 * Multiplies two complex numbers
	 * @param c
	 * @return result the two complex numbers multiplied
	 */

   public ComplexNumber multiply(ComplexNumber c){
   	double m = this.a*c.getReal();
   	double n = this.a*c.getImaginary();
   	double o = this.b*c.getReal();
   	double p = this.b*c.getImaginary()*-1;

   	double real = m+p;
   	double imagine = n+o;
   	ComplexNumber result = new ComplexNumber(real, imagine);
   	return result;
   }

    /**
	 * Multiplies two complex numbers
	 * @param c1
	 * @param c2
	 * @return result the two complex numbers multiplied
	 */

   public static ComplexNumber multiply(ComplexNumber c1, ComplexNumber c2){
   	double m = c1.getReal()*c2.getReal();
   	double n = c1.getReal()*c2.getImaginary();
   	double o = c1.getImaginary()*c2.getReal();
   	double p = c1.getImaginary()*c2.getImaginary()*-1;

   	double real = m+p;
   	double imagine = n+o;
   	ComplexNumber result = new ComplexNumber(real, imagine);
   	return result;
   }

   	/**
	 * Divides two complex numbers
	 * @param c
	 * @throws ArithmeticException()
	 * @return result the two complex numbers divided
	 */

   public ComplexNumber divide(ComplexNumber c){
   	ComplexNumber numerator = this.multiply(c.conjugate());
   	ComplexNumber denominator = c.multiply(c.conjugate());

   	if (denominator.getReal() == 0){
   		throw new ArithmeticException();
   	}
   	double real = numerator.getReal()/denominator.getReal();
   	double imagine = numerator.getImaginary()/denominator.getReal();
   	ComplexNumber result = new ComplexNumber(real, imagine);
   	return result;
   }

    /**
	 * Divides two complex numbers
	 * @param c1
	 * @param c2
	 * @throws ArithmeticException()
	 * @return result the two complex numbers divided
	 */

   public static ComplexNumber divide(ComplexNumber c1, ComplexNumber c2){
   	ComplexNumber numerator = c1.multiply(c2.conjugate());
   	ComplexNumber denominator = c2.multiply(c2.conjugate());

   	if (denominator.getReal() == 0){
   		throw new ArithmeticException();
   	}
   	double real = numerator.getReal()/denominator.getReal();
   	double imagine = numerator.getImaginary()/denominator.getReal();
   	ComplexNumber result = new ComplexNumber(real, imagine);
   	return result;
   }

     /**
	 * multiplies a number to a certain power
	 * @param exponent
	 * @throws IllegalArgumentException
	 * @return result the number multipled exponent number times
	 */

   public ComplexNumber power(int exponent){
   		ComplexNumber result = new ComplexNumber(this);
   		if (exponent == 0){
   			return new ComplexNumber(1,0);
   		} else if (exponent < 0){
   			throw new IllegalArgumentException();
   		} else {
	   		for (int i = 1; i < exponent; i++){
	   			result = result.multiply(this);
	   		}   			
   		}
   		return result;
   }

     /**
	 * multiplies a number to a certain power
	 * @param exponent
	 * @param c
	 * @throws IllegalArgumentException
	 * @return result the number multipled exponent number times
	 */

   public ComplexNumber power(int exponent, ComplexNumber c){
   		ComplexNumber result = new ComplexNumber(c);
   		if (exponent == 0){
   			return new ComplexNumber(1,0);
   		} else if (exponent < 0){
   			throw new IllegalArgumentException();
   		}
   		for (int i = 1; i < exponent; i++){
   			result = result.multiply(c);
   		}
   		return result;
   }

     /**
	 * returns the magnitude of the vector of the complex number in the complex number plane
	 * @return result the length of the complex number from the origin
	 */

   public double magnitude(){
		return (Math.sqrt(this.a*this.a + this.b*this.b));
	}

	 /**
	 * returns the difference between the magnitude of two complex numbers
	 * @param c the second complex number to be compared to the first
	 * @return result the difference in magnitudes
	 */

	public int compareTo(ComplexNumber c){
 		return ((int) (this.magnitude() - c.magnitude()));
 	}


   /**
    * Converts the Fraction into a String object
    *
    * @return the String version of the Fraction
    */
   public String toString (){
      String real;
      String imagine;
      String result;

      if (this.a == 0.0 && this.b == 0.0){
      	result = "0.0";
      } else{
	      if (this.a == 0.0){
	      	real = "";
	      } else {
	      	real = this.a + "";
	      }

	      if (this.b == 1.0){
	      	imagine = "i";
	      } else if (this.b == 0.0){
	      	imagine = "";
	      } else {
	      	imagine = this.b + "i";
	      }
	    result=real + " " + imagine;
      }   
      return result;
   }

public static void leftGraph(ComplexNumber cons, double x1, double x2, double y1, double y2){
	double x = scale(cons.getReal(), x1, x2, 0, 400);
	double y = scale(cons.getImaginary(), y1, y2, 0, 300);
	StdDraw.point(x, y);
}

public static void rightGraph(ComplexNumber cons, double x1, double x2, double y1, double y2){
	double x = scale(cons.getReal(), x1, x2, 400, 800);
	double y = scale(cons.getImaginary(), y1, y2, 0, 300);
	StdDraw.point(x, y);
}

public static double scale(final double valueIn, final double baseMin, final double baseMax, final double limitMin, final double limitMax) {
        return ((limitMax - limitMin) * (valueIn - baseMin) / (baseMax - baseMin)) + limitMin;
    }


	/**
	 * A tester method
	 * @param args
	 */
	public static void main(String[] args) {
		ComplexNumber c1 = new ComplexNumber(3, -2);
		ComplexNumber c2 = new ComplexNumber(-1, -1);
		ComplexNumber zero = new ComplexNumber(0,0);
		ComplexNumber one = new ComplexNumber(1,0);
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());

		System.out.println("\nmagnitude: ");
		System.out.println(c1.magnitude());
		System.out.println(c2.magnitude());

		// System.out.println("\ncompare to: ");
		// System.out.println(c1.compareTo(c2));

		// System.out.println("\nadd: ");
		// System.out.println(c1.add(c2).toString());
		// System.out.println(c1.add(zero).toString());
		// System.out.println(c1.add(one).toString());
		// System.out.println(add(c1,c2).toString());

		// System.out.println("\nsubtract: ");
		// System.out.println(c1.subtract(c2).toString());
		// System.out.println(c1.subtract(zero).toString());
		// System.out.println(c1.subtract(one).toString());
		// System.out.println(subtract(c1,c2).toString());

		// System.out.println("\nmultiply: ");
		// System.out.println(c1.multiply(c2).toString());
		// System.out.println(c1.multiply(zero).toString());
		// System.out.println(c1.multiply(one).toString());
		// System.out.println(multiply(c1,c2).toString());

		// System.out.println("\ndivide: ");
		// System.out.println(c1.divide(c2).toString());
		// System.out.println(c1.divide(zero).toString());
		// System.out.println(c1.divide(one).toString());
		// System.out.println(divide(c1,c2).toString());

		// System.out.println("\nexponent: ");
		// System.out.println(c1.power(5).toString());
		// System.out.println(c1.power(0).toString());
		// System.out.println(c1.power(1).toString());
		//System.out.println(power(c1,5).toString());
	}
}

