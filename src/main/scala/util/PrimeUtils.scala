package util

import scala.math._

/**
 * Created by alexandra on 26/09/15.
 */
object PrimeUtils extends App {

  def nthPrime(n: Int): Int = {
    def nthPrimeHelper(prime: Int, index: Int): Int = {
      if (n < 0) throw new RuntimeException(s"CATS $prime, $index")
      if (index == n) prime
      else nthPrimeHelper(nextPrime(prime), index + 1)
    }
    nthPrimeHelper(2, 1)
  }

  def nextPrime(n: Int): Int = {
    if (isPrime(n + 1)) n + 1 else nextPrime(n+1)
  }

  def isPrime(n: Int): Boolean = {
    isPrime(n.toLong)
  }

  def isPrime(n: Long): Boolean = {

    if (n == 2) return true
    if (n == 0 || n == 1 || n % 2 == 0) return false

    for (i <- 3 to (pow(n, 0.5).toInt + 1) by 2) {
      if (n % i == 0) return false
    }

    true
  }

}
