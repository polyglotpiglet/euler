package problems.twenties

import scala.annotation.tailrec

/**
 * Created by alexandra on 02/02/16.
 */
object TwentyFour extends App {
//  val a = "0123456789".permutations.toArray
//  println(a(999999)) // = 2783915460

    val a = Array(0,1,2,3,4,5,6,7,8,9)
    println(rawr(a, 999999).mkString)
    println(rawr(a, 1000000).mkString)
//  println(rawr( Array(0,1,2),0, Seq.empty[Int], 3, 0).mkString)


  /*

    how many start with 0? = 362880
    how many start with 1? = 362880
    how many start with 0 or 1 = 725760
    how many start with 0,1,2 = 1088640 so first digit must be two

    wanna find the 274240th that starts with two
    how many start with 20? = 40320
    how many start with 20 or 21 = 80640
    how many start with 20, 21, 22 = 120960
    how many start with 20, 21, 22, 23, 24, 25, 26 = 241920
    how many start with 20, 21, 22, 23, 24, 25, 26, 27 = 241920

   */


  @tailrec
  def rawr(numbers: Array[Int], targetIndex: Int, currentNumberOp: Option[Int] = None,  result: Seq[Int] = Seq.empty[Int], runningTotal: Int = 0): Seq[Int] = {
    val currentNumber = currentNumberOp.getOrElse(numbers.min)
    val factorial = (1 until numbers.length).product
    if ((runningTotal + factorial) > targetIndex) {
      val newResult = result :+ currentNumber
      val notVisited = numbers.filter(!newResult.contains(_))
      rawr(notVisited, targetIndex, Some(notVisited.min), newResult, runningTotal)
    }
    else if ((runningTotal + factorial) == targetIndex) {
      val rest = numbers.filter{ n => !result.contains(n) && n != currentNumber }
      val perms = rest.mkString.permutations.toArray
      result ++ Seq(currentNumber) ++ Seq(perms(factorial - 1).toInt)
    }
    else {
      val next = numbers.filter(_ > currentNumber).min
      rawr(numbers, targetIndex, Some(next), result, runningTotal + factorial)
    }
  }

}
