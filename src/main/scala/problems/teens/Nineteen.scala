package problems.teens

/**
 * Created by alexandra on 07/10/15.
 */
object Nineteen extends App {
  val dates = List(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
  val leapDates = List(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

  val datesMipped = dates.scanLeft(0)((x, y) => (x + y) % 7).take(12)
  val leapDatesMipped = dates.scanLeft(0)((x, y) => (x + y) % 7).take(12)

//  (1900 to 1903).scanLeft(0)((x,y) => )
//
//  for (y <- 1900 to 2000) {
//
//
//  }


  def isLeapYear(year: Int) = {
    if (year % 400 == 0) true // century leap
    else if (year % 100 == 0 ) false // century non leap
    else if (year % 4 == 0) true // normal leap
    else false // normal non leap
  }


}
