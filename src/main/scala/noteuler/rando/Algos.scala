package noteuler.rando

import scala.math.pow

/**
 * Created by alexandra on 29/09/15.
 */
object Algos extends App {

  // approximating sqrt
  def approxSqrt(min: Double, max: Double, n: Int): Double = {
    val guess = ((max - min) / 2) + min
    val diff = n - pow(guess, 2)
    if (math.abs(diff) < 0.00000000001) guess
    else if (diff < 0) approxSqrt(min, guess, n)
    else approxSqrt(guess, max, n)
  }

  println(approxSqrt(1.4, 1.5, 2))
  println(approxSqrt(2, 5, 9))

}
