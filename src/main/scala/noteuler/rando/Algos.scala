package noteuler.rando

import scala.math.{pow, abs}

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

  // I googled it and this is the babylon method
  // maybe if i am feeling productive later i will write a blog post on it
  def babylon(guess: Double, n: Int): Double = {
    if (abs(n - pow(guess, 2)) < 0.00000000001) guess
    else babylon((guess + (n/guess)) * 1/2, n)
  }

  println(approxSqrt(1.4, 1.5, 2))
  println(approxSqrt(2, 5, 9))

  println(babylon(1, 2))
  println(babylon(1, 9))

}
