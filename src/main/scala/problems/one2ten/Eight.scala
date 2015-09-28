package problems.one2ten

import scala.io.Source

/**
 * Created by alexandra on 27/09/15.
 */
object Eight extends App {

  val length = 13
  val numbers = Source.fromURL(getClass.getResource("/Eight.txt")).getLines().toArray.flatten.map(_.toLong - '0')
  println(numbers.sliding(length).map(_.product).max)

}
