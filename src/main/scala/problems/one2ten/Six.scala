package problems.one2ten

/**
 * Created by alexandra on 27/09/15.
 */
object Six extends App {
  val max = 100
  println((math.pow((1 to max).sum.toLong, 2) - (1 to max).map{ i => math.pow(i.toLong,  2)}.sum).toInt)
}
