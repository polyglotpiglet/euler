package problems.one2ten

import scala.math._

/**
 * Created by alexandra on 27/09/15.
 */
/*
Finding unique pythagorean triple where a + b + c = 1000

Pretty dumb solution but it's quick so i dont really mind
 */
object Nine extends App {

  val n = 1000
  val range = 1 until n

  val triplets = for (i <- range; j <- range if n - i - j > 0) yield (i, j, n-i-j)
  val result = triplets.find { case (i, j, k) => pow(i, 2) + pow(j, 2) == pow(k, 2) } get

  println(result)
  println(result._1 * result._2 * result._3)

}
