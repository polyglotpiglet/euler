package util

/**
 * Created by alexandra on 28/09/15.
 */
object NumUtils extends App {

  class Palindrome(n: Int) {
    def isPalindrome: Boolean = n.toString.zip(n.toString.reverse).map(c => c._1 == c._2).foldLeft(true){ _ && _ }
  }

  implicit def isPalindrome(n: Int): Palindrome = new Palindrome(n)

}
