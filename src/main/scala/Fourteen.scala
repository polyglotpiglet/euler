import scala.collection.immutable._

/**
 * Created by alexandra on 25/09/15.
 */

/*
Problem 14

You can define a sequence with n_0 is a positive integer and given n_i, n_i+1 =

    n/2      if n is is even
    3n + 1   if n is odd


    eg starting at 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 1

    Some conjecture that I can't remember the name of states that no matter what n_0, the sequence will always
    converge to 1.

    Find the number under 1 million that produces the longest chain.


    My solution: For 1 million to 1 compute the length of the chain. Cache all intermediate results.
    Eg for 13 we would cache (13 -> 9), (40 -> 8), (20 -> 7) etc then when we hit that number we can
    just look up the length in the cache.

 */

object Fourteen extends App {

  val max = 1000000

  val cat: IndexedSeq[(Int, Int)] = for (i <- max to 1 by -1) yield (i, computeChainLength(i))
  println(cat.maxBy(_._2))


  def computeChainLength(seed: Long): Int = {

    // yes im using a var to cache the results, don't eat me
    var cache = HashMap[Long, Int]()

    // helper function to compute the chain for a given number
    def computeChain(n: Long, chain: Array[Long]): (Array[Long], Int) = {
      if (cache.contains(n)) (chain, cache(n))
      if (n == 1) (chain :+ n, 0)
      else {
        if (n % 2 == 0) computeChain(n/2, chain :+ n)
        else computeChain((3*n) + 1, chain :+ n)
      }
    }

    val chain = computeChain(seed, Array[Long]())

    // super fun caching logic
    chain._1.reverse.zipWithIndex.foreach { case (x, i) =>
      cache += (x -> (i + chain._2 + 1)) // adding one because otherwise is indexed from 0
    }

    cache(seed)
  }

}
