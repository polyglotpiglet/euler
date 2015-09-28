package util

import scala.language.postfixOps
import scala.math._
import PrimeUtils._

/**
 * Created by alexandra on 27/09/15.
 */
object DivisorUtils extends App {

  def getDivisors(n: Int): Set[Int] = {
    if (isPrime(n)) return Set(1,n)

    val sqrt = (pow(n, 0.5) + 1).toInt
    (1 to sqrt).flatMap { i =>
      if (n % i == 0) Set(i, n/i)
      else Set[Int]()
    }.sorted.toSet
  }

  def getDivisors(n: Long): Set[Long] = {
    if (isPrime(n)) return Set(1,n)

    val sqrt = (pow(n, 0.5) + 1).toInt
    (1 to sqrt).flatMap { i =>
      if (n % i == 0) Set(i, n/i)
      else Set[Long]()
    }.sorted.toSet
  }


 def primeFactors(n: Int): List[Int] = {

   def helper(num: Int, prime: Int, arr: List[Int]): List[Int] = {
     if (num == 1) arr
     else if (isPrime(num)) arr :+ num
     else {
       if (num % prime == 0) helper(num / prime, prime, arr :+ prime)
       else helper(n, nextPrime(prime), arr)
     }
   }

   helper(n, 2, List[Int]())
 }


}
