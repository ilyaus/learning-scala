package lectures.part2oop

object MethodNotations extends App {
  class Person(val name: String, age:Int = 0, favoriteMovie: String) {
    def likes(movies: String): Boolean = movies == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(rockStart: String): Person = new Person(s"$name ($rockStart)", age, this.favoriteMovie)

    def unary_! : String = s"What the hack!"
    def unary_+ : Person = new Person(name, age + 1, favoriteMovie)

    def isAlive = true

    def apply(): String = s"Hi, my name is $name, and I like $favoriteMovie"
    def apply(n: Int): String = s"$name watched her favorite movie $favoriteMovie $n times"

    def learns(s: String): String = s"$name learns $s"
    def learnsScala: String = learns("Scala")
  }

  val mary = new Person("Mary", age=0, "Inception")
  println(mary.likes("Inception"))

  // +++ infix notation = operator notation
  // Only work with methods with single parameter
  println(mary likes "Inception")

  // "operators" in Scala
  val tom = new Person("Tom", age=0,"Fight Club")
  println(mary + tom)

  // All Operators are methods:
  println(1 + 2)
  println(1.+(2))


  // +++ prefix notation
  val x = -1
  val y = 1.unary_-

  println(!mary)


  // +++ postfix notation
  // Only available to methods without parameters
  println(mary isAlive)
  println(mary learnsScala)


  // apply
  println(mary.apply())
  println(mary())
  println(mary(3))
}
