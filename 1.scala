class Rational(val numerator: Int, val denominator: Int) {
  
  require(denominator != 0, "Denominator cannot be zero")
  private val gcd = greatestCommonDivisor(numerator, denominator)
  val num = numerator / gcd
  val denom = denominator / gcd
  
 
  def neg: Rational = new Rational(-num, denom)
  

  private def greatestCommonDivisor(a: Int, b: Int): Int = {
    if (b == 0) a else greatestCommonDivisor(b, a % b)
  }
  
  override def toString: String = s"$num/$denom"
}

object RationalTest extends App {
  val x = new Rational(3, 4)
  println(x)          
  println(x.neg)      
}