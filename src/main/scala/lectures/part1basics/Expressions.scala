package lectures.part1basics

object Expressions extends App {
  // If expression
  val aCondition = true

  val aConditionedValue = if(aCondition) 5 else 3

  println(aConditionedValue)

  var aVariable = 1
  val aWeirdValue = (aVariable = 3) // Unit === void

  println(aWeirdValue)

  val aCodeBlock = {
    val y = 2
    var z = y + 1

    if (z > 2) "Hello" else "GoodBye"
  }
}
