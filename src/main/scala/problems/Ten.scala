package problems

import util.PrimeUtils
import PrimeUtils._

/**
 * Created by alexandra on 27/09/15.
 */
object Ten extends App {

  println ((1L to 2000000L).filter(isPrime).sum)

}
