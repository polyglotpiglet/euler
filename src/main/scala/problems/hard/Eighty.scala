package problems.hard

/**
 * Created by alexandra on 01/10/15.
 */
object Eighty extends App {
  /*
  1  1   1   1
  1  1   100 1
  2  100 99  1
  1  1   1   1



  1   1   1   100
  1   1   100   1
  1   1   2     1



  1  100   100   100
    2          1
         1

    1 2 3
    4 5 2
    9 1 9
                    (2)
            (3)

        (2)
                    (2)
            (5)
                    (1)
    (1)

            (5)

        (4)

            (9)
   */


  case class Node(value: Int, left: Int, right: Int)
  val testSample = Array(Array(1,1,1,1), Array(1,1,100,1), Array(2,100,99,1), Array(1,1,1,1))
  val littleCat = Array(Array(1,2,3), Array(4,5,2), Array(9,1,9))

  def buildTreeFromMatrix(mat: Array[Array[Int]]) = {
    val s = mat.length

    def cat(node) = {

    }

    val node = Node(mat(s)(s), 0 ,0  )

    for {
      i <- mat.length
      j <- mat.length
    } yield 0
  }
}
