package problems.twenties


/**
 * Created by alexandra on 31/01/16.
 */
object TwentyOne extends App {

  val max = 10000
  val a = Array.fill[Seq[Int]](max)(Seq.empty[Int])

  (1 to max/2).foreach { i =>
    (i until max by i).foreach { j =>
      if (j != i) a(j) = i +: a(j)
    }
  }

  val d = a.map(_.sum)

  val sum = (2 until max).map { i =>
    if (d(i) < a.length // make sure not too big
      && d(i) != i // not amicable with itself (eg 6)
      && d(d(i)) == i)  // amicable condition
      i
    else 0
  }.sum

  println(sum)


}
