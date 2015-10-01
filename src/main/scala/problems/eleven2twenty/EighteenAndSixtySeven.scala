package problems.eleven2twenty

import scala.math._

import scala.io.Source

/**
 * Created by alexandra on 30/09/15.
 */
object EighteenAndSixtySeven extends App {

  /*
         5
        4 6
       9 1 1
      1 2 1 1

      Find the max sum from top to bottom of triange (in this triangle the answer = 5 + 4 + 9 + 2 = 16)

      Algorithm:

      Combine the bottom two rows

      (9,1,1) combined with (1,2,1,1) where you add a1(i) to max{a2(i), a2(i+1)} = 11,3,2

      [This next bit isnt really necessary or useful but i liked it]
      After the comine step we analyse the result to decide which routes cannot win.
      A route cannot win if it has a neighbour that is bigger that it and so we set it to zero
      (11,3,2) => 11,3,0
   */

  val miniTriangle = Array(Array(1), Array(4,6), Array(9,1,1), Array(1,2,1,1))

  val triangle = Source.fromURL(getClass.getResource("/Eighteen.txt")).getLines().map(_.split(" ").map(_.toInt))
  val massiveTriangle = Source.fromURL(getClass.getResource("/SixtySeven.txt")).getLines().map(_.split(" ").map(_.toInt))

  def cat(a1: Array[Int], a2: Array[Int]): Array[Int] = {
    assert(a1.length == a2.length -1)
    a1.zipWithIndex.map { case (x, i) => x + max(a2(i), a2(i+1)) }
  }


  val res = massiveTriangle.reduceRight(cat)
  println(res(0))



  // i thought this was interesting when i was impl it
  def zeroOutUselessRoutes(a1: Array[Int], a2: Array[Int]): Array[Int] = {
    assert(a1.length == a2.length -1)
    val chooseMaxes = a1.zipWithIndex.map { case (x, i) => x + max(a2(i), a2(i+1)) }
    val l = chooseMaxes.length
    if (l == 1) return chooseMaxes

    val zipped = chooseMaxes.zipWithIndex.map(_.swap)
    zipped.map { case (i, x) =>
      if (i == 0) { if (zipped(i+1)._2 > x) 0 else x }
      else if (i == l - 1) { if (zipped(i -1)._2 > x) 0 else x }
      else if (zipped(i-1)._2 > x && zipped(i+1)._2 > x) 0
      else x
    }
  }


}
