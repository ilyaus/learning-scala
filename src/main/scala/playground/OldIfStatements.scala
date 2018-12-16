package playground

object OldIfStatements extends App {
  println("Running old if statements")

  val a = 10
  var result = ""

  if (a < 10)
    result = "Less than 10"
  else if (a > 10)
    result = "Grater than 10"
  else
    result = "It is 10!"

  println(result)
}

object NewIfStatements extends App {
  println("Running new version")

  val a = 10
  val result =
    if(a < 10) "Less than 10"
    else if (a > 10) "Greater than 10"
    else "It is 10"

  println(result)
}