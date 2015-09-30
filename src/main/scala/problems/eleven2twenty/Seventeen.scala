package problems.eleven2twenty

/**
 * Created by alexandra on 30/09/15.
 */

// count the letters in the numbers
object Seventeen extends App {

  val under20 = Array("one", "two", "three", "four", "five",
    "six", "seven", "eight", "nine", "ten",
    "eleven", "twelve", "thirteen", "fourteen", "fifteen",
    "sixteen", "seventeen", "eighteen", "nineteen", "twenty")

  val tens = Array("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

  def getString(n: Int): String = {
    if (n < 20) under20(n-1)
    else if (n == 1000) "one thousand"
    else if (n < 100 && n % 10 == 0) tens(n/10 - 2)
    else if (n < 100) tens(n/10 - 2) + " " + under20 (n - (n/10) * 10 -1)
    else if (n % 100 == 0) under20(n/100 - 1 ) + " hundred"
    else under20(n/100 - 1 ) + " hundred and " + getString(n - (n/100) * 100)
  }

  println((1 to 5).map(x => getString(x).count(_ != ' ')).sum)
  println((1 to 1000).map(x => getString(x).count(_ != ' ')).sum)
//  (1 to 1000).map{x => println(x) ; getString(x)}.foreach(println)
}
