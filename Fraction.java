/*
  To enable assertions, modify the java command line with: 
    > javac Fraction.java
    > java -enableassertions Fraction
*/

public class Fraction
{
   private int numerator, denominator;

    /**
    * The Fraction object Constructor.  
    *
    * @param  n an integer numerator
    * @param  d an integer denominator 
    * @throws IllegalArgumentException in case of denominator == 0
    * @return a new Fraction object
    */
   public Fraction (int n, int d){
      if (d == 0) throw new IllegalArgumentException("Unacceptable denominator value: " + d);

      if (d < 0){
         n = n * -1;
         d = d * -1;
      }

      this.numerator = n;
      this.denominator = d;
      reduce();//store all fractions in lowest terms
   }//end constructor

    /**
    * The numerator Accessor method.  
    *
    * @return the numerator of this Fraction object
    */
   public int getNumerator(){ return this.numerator; }

    /**
    * The denominator Accessor method.  
    *
    * @return the denominator of this Fraction object
    */
   public int getDenominator(){ return this.denominator; }

    /**
    * Returns a new Fraction object that is the reciprocal of
    * this Fraction object  
    *
    * @return a Fraction object, the reciprocal of this Fraction object
    */
   public Fraction reciprocal(){ return new Fraction (denominator, numerator); }

    /**
    * Returns a new Fraction object that is the sum 
    * of the parameter and this Fraction 
    *
    * @param f, a Fraction to be added to this Fraction
    * @return a Fraction object, the sum of the two Fraction objects
    */
   public Fraction add(Fraction f){
      int commonDenominator = this.denominator * f.getDenominator();
      int numerator1 = this.numerator * f.getDenominator();
      int numerator2 = f.getNumerator() * this.denominator;
      int sum = numerator1 + numerator2;

      return new Fraction (sum, commonDenominator);
   }//end add

    /**
    * Returns a new Fraction object that is the difference 
    * of the parameter and this Fraction 
    *
    * @param f, a Fraction to be subtracted from this Fraction
    * @return a Fraction object, the difference of the two Fraction objects
    */
   public Fraction subtract (Fraction f){
      int commonDenominator = this.denominator * f.getDenominator();
      int numerator1 = this.numerator * f.getDenominator();
      int numerator2 = f.getNumerator() * this.denominator;
      int difference = numerator1 - numerator2;

      return new Fraction (difference, commonDenominator);
   }//end subrtract

   /**
    * Returns a new Fraction object that is the product 
    * of the parameter and this Fraction 
    *
    * @param f, a Fraction to be multiplied with this Fraction
    * @return a Fraction object, the product of the two Fraction objects
    */
   public Fraction multiply (Fraction f){
      int numer = this.numerator * f.getNumerator();
      int denom = this.denominator * f.getDenominator();

      return new Fraction (numer, denom);
   }//end multiply

   /**
    * Returns a new Fraction object that is the quotient 
    * of the parameter and this Fraction 
    *
    * @param f, a Fraction to divide this Fraction
    * @return a Fraction object, the quotient of the two Fraction objects
    */
   public Fraction divide (Fraction f){ return multiply(f.reciprocal()); }

   /**
    * Compares the two fractions. Returns a 0 if the two Fraction objects
    * are equal, returns a negative number if this Fraction object is less 
    * than the argument and returns a positive number if this Fraction is greater
    * than the argument
    *
    * @param f, a Fraction to compare with this Fraction
    * @return an integer to indicate the ordering of the two Fraction objects
    */
   public int compareTo (Fraction f){
      int crossLeft = this.numerator*f.getDenominator();
      int crossRight = this.denominator*f.getNumerator();

      return crossLeft - crossRight;
   }//end compareTo

   /**
    * Converts the Fraction into a String object
    *
    * @return the String version of the Fraction
    */
   public String toString (){
      String result="";

      if (this.numerator == 0) result = "0";
      else if (this.denominator == 1) result = this.numerator + "";
      else result = this.numerator + "/" + this.denominator;
    
      return result;
   }//end toString

   /**
    * Eliminates common factors from the numerator and denominator
    *
    */
   private void reduce (){
      if (this.numerator != 0){
         int common = gcd (Math.abs(this.numerator), this.denominator);

         this.numerator = this.numerator / common;
         this.denominator = this.denominator / common;
      }
   }//end reduce


   /**
    * Computes and returns the greatest common divisor of the two
    * positive parameters. Uses Euclid's algorithm.
    *
    * @param num1, an integer
    * @param num2, an integer
    * @return an integer, the gcd of the two arguments
    */
   private int gcd (int num1, int num2)
   {
      while (num1 != num2)
         if (num1 > num2)
            num1 = num1 - num2;
         else
            num2 = num2 - num1;

      return num1;
   }//end gcd

   public static void main(String args[]){
        Fraction f1_2 = new Fraction(1,2); 
        Fraction f4_8 = new Fraction(4,8);
        Fraction f2_3 = new Fraction(2,3);
        Fraction f0_3 = new Fraction(0,3);

        assert f1_2.toString().equals("1/2"): " toString is not valid"; 
        assert f4_8.toString().equals("1/2"): " reduce() is not valid"; 
        assert f1_2.compareTo(f4_8)==0: " Equals comparison is not valid";
        assert f1_2.compareTo(f2_3)!=0: " Equals comparison is not valid";
        assert f1_2.compareTo(f2_3)<0: " Less than comparison is not valid"; 
        assert f1_2.multiply(f2_3).toString().equals("1/3"): "multiplication is not valid"; 
        assert f1_2.multiply(f0_3).toString().equals("0"): "multiplication or toString is not valid"; 
        assert f1_2.divide(f2_3).toString().equals("3/4"): "division is not valid"; 

        System.out.println("All tests pass!!!");
   }//end main
}//end Fraction class

