package playground

object WhileLoops extends App {
  var a = 100
  var result = ""

  while(a > 0) {
    result = result + a
    if (a > 1) result = result + ","
    a = a - 1
  }

  println(result)
}

object FunctionalLoops extends App {
  val result = (1 to 100).reverse.mkString(",")
  println(result)

  var result1 = (100 to 1 by -1).mkString(",")
  println(result1)
}

object DoWhileLoop extends App {
  var a = 0
  var result = ""

  do {
    result = result + a
    if (a > 1) result = result + ","
    a = a - 1
  } while(a > 0)

  println(result)
}

object ForLoops extends App {
  var result = ""
  for (a <- 1 to 100) {
    result = result + a
    if (a > 1) result = result + ","
  }

  println(result)
}

object ForLoops2 extends App {
  val xs = List(1,2,3,4)
  var result = List[Int]()

  for(a <- xs) {
    result = result :+ (a + 1)
  }

  println(result)
}

object FunctionalForLoops extends App {
  val xs = List(1,2,3,4)
  val result = for(a <- xs) yield a + 1

  println(result)
}