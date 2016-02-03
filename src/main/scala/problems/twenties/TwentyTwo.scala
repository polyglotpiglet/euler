package problems.twenties

import scala.io.Source

/**
 * Created by alexandra on 03/02/16.
 */
object TwentyTwo extends App {

  val names = Source.fromURL(getClass.getResource("/TwentyTwo.txt"))
                .getLines().toSeq.head
                .split(",")
                .map(n => n.substring(1, n.length-1))
                .sorted
                .map(nameValue)

  def nameValue(name: String): Int = name.map(_.toInt).sum - name.length * '@'.toInt

  val values = names.zip(BigInt(1) to BigInt(names.length))
  val result = values.map(x => x._1 * x._2).sum

  println(result)

}
