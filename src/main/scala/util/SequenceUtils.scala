package util

import scala.annotation.tailrec

/**
 * Created by alexandra on 27/09/15.
 */
object SequenceUtils extends App {

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
