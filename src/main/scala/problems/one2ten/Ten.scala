package problems.one2ten

import util.PrimeUtils
import util.PrimeUtils._

/**
 * Created by alexandra on 27/09/15.
 */
object Ten extends App {

  println ((1L to 2000000L).filter(isPrime).sum)

}
