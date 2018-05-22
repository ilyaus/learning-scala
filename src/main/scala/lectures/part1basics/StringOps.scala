package lectures.part1basics

object StringOps extends App {
  var str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11)) // First index is inclusive, second is exclusive
  println(str.split(" ").toList)
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  // Prepend and append
  println('a' +: aNumberString :+ 'z')

  // S-interpolation
  val name = "David"
  val age = 46
  val greeting = s"Hello my name is $name, and my age is $age"
  val anotherGreeting = s"Hello, I'll be turning ${age + 1} year old"

  println(greeting)
  println(anotherGreeting)

  // F-interpolation
  // Can use printf formatting style
  var speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"

  println(myth)

  // raw-interpolation
  // Does not escape any characters in test, but does escape characters in variables
  println(raw"This is an \n new line")
  val escaped = "This is another \n new line"
  println(raw"$escaped")
}
