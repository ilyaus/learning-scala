package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 30)
  println(person.age)
  println(person.x)
  person.greet("Daniel")
}

class Person(name: String, val age: Int) { // Constructor
  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
  // multiple constructors can be replaced with default parameters

  val x = 2

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
}