package problems.eleven2twenty

import scala.io.Source

/**
 * Created by alexandra on 27/09/15.
 */
object Thirteen extends App {

  val desieredNumberOfInts = 10

  val bigNumbers: Array[BigInt] = Source.fromURL(getClass.getResource("/Thirteen.txt")).getLines().toArray.map(BigInt(_))
  val sum: BigInt = bigNumbers.sum
  println(sum)
  val zeros = sum.toString().length - desieredNumberOfInts
  val powerOfTen = (1 to zeros).map(_ => BigInt(10)).fold(BigInt(1)){(x,y) => x * y}
  println((sum - (sum % powerOfTen)) / powerOfTen)

}
