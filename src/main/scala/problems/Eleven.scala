package problems

import scala.io.Source

/**
 * Created by alexandra on 28/09/15.
 */
object Eleven extends App {

  val size = 4
  val cat: Array[Array[Long]] = Source.fromURL(getClass.getResource("/Eleven.txt")).getLines().map(_.split(" ").map(_.toLong)).toArray

  /*  0 1 2

  0   1 2 3
  1   4 5 6
  2   7 8 9

   */

 // val cat = Array(Array(1L,2L,3L), Array(4L,5L,6L), Array(7L,8L,9L))

 val across = for (i <- cat.indices; j <- cat.indices; if j <= cat.length - size)
   yield cat(i).slice(j, j + size).product

 val down = for (i <- cat.indices; j <- cat.indices; if i <= cat.length - size)
   yield (i until i + size).map{ k => cat(k)(j)}.product

 val diag1 = for (i <- cat.indices; j <- cat.indices; if j <= cat.length - size && i <= cat.length-size)
   yield (0 until size).map(k => cat(i+k)(j+k)).product

  val diag2 = for (i <- cat.indices; j <- cat.indices; if i - size + 1 >= 0 && j + size <= cat.length)
    yield (0 until size).map(k => cat(i - k)(j+k)).product


  println(across union down union diag1 union diag2 max)


}
