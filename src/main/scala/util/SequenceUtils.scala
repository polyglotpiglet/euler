package util

import scala.annotation.tailrec

/**
 * Created by alexandra on 27/09/15.
 */
object SequenceUtils extends App {

  def fibonacciTo(max: Int): Array[Int] = {

    def helper(one: Int, two: Int, seq: Array[Int]): Array[Int] = {
      if (two >= max) seq
      else helper(two, one + two, seq :+ two)
    }

    helper(0, 1, Array(0))
  }

  def nthFibonacci(n: Int): Int = {

    @tailrec
    def helper(first: Int, second: Int, index: Int): Int = {
      if (index == n) second
      else helper(second, second + first, index + 1)
    }

    helper(0, 1, 1)
  }


  def nthTriangle(n: Int): Int = (1 to n).sum
}
