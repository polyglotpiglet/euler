import scala.math._

/**
 * Created by alexandra on 26/09/15.
 */
object Utility {

  def isPrime(n: Int): Boolean = {

    if (n == 0 || n == 1 || n % 2 == 0) return false
    if (n == 2) return true

    for (i <- 3 to (pow(n, 0.5).toInt + 1) by 2) {
      if (n % i == 0) return false
    }

    true
  }

}
