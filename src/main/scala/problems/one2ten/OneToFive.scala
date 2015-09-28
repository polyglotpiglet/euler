package problems.one2ten

import util.DivisorUtils._
import util.SequenceUtils
import util.PrimeUtils._
import util.NumUtils._

import scala.collection.immutable.IndexedSeq

/**
 * Created by alexandra on 28/09/15.
 */
object OneToFive extends App {

  // sum numbers 1 to 1k that a multiples of 3 or 5
  val one = (1 until 1000).filter(x => x % 3 == 0 || x % 5 == 0).sum
  println(one)

  // sum of even fibs up to 4million
  val two = SequenceUtils.fibonacciTo(4000000).filter(x => x < 4000000 && x % 2 == 0).sum
  println(two)

  // largest prime factor
  val three = getDivisors(600851475143L).filter(isPrime).max
  println(three)

  // largest palindrome that is multiple of two 3-digit numbers
  val four = (for (i <- 1 to 999; j <- 1 to 999 if (i * j).isPalindrome) yield i * j).max
  println(four)

  // smallest number divisible by 1 to 20
  val five = (1 to 20).map(x => (x, primeFactors(x))).foldRight((1L, Array[Int]())) { (a,b) =>
    val diff = a._2.diff(b._2)
    if (diff.isEmpty) b
    else (diff.product * b._1, b._2 ++ diff)
  }._1

  println(five)
}
