package problems.eleven2twenty

import util.DivisorUtils._

// What is the value of the first triangle number to have over five hundred divisors?
object Twelve extends App {

  val numberOfDivisors = 500

  println(compute(1, 0))

  def compute(i: Int, triangle: Int): Int = {
    val incTriangle = triangle + i
    if (getDivisors(incTriangle).size > numberOfDivisors) incTriangle
    else compute(i + 1, incTriangle)
  }

}
