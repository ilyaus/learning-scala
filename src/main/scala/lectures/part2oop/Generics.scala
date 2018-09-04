package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Animal
    Can accept parameter B, which is supper type of A
    (Can accept Animal because Animal is super type of Cat)
    If Animal element is added, list to become List[Animal] (not List[Cat])
    */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods:
  object MyList {
    //def empty[A]: MyList[A] = ???
  }

  //val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // If Cat extends Animal, does list of Cats extend list of Animals
  // 1. Yes.  List[Cat] extends List[Animal] = Covariance
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // Can add Dog to list of Cats:
  // animalList.add(new Dog)  it is possible, but it pollutes the list of cats

  // 2. No. List[Cat] and List[Animal] are different lists = Invariance
  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal] // Can only be Animal

  // 3. No.
  // List of Cats can be assigned List of Animals, but not other way around
  // even through cat is sub-class of animals
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // bounded types:
  // Class cage of type Animal.
  // Restriction: Class cage only accepts parameters A which are sub-types of Animal
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  // this is illegal because Car is not sub-type of Animal
  //val newCage = new Cage(new Car)

  // bounded types solve a variance problem we want to write
  // covariant collections

  // --------------

  abstract class printMe[A] {
    def p[A](i: A): Unit
  }

  class printObject[A]() extends printMe[A] {
    def p[A](i: A): Unit = println(i)
  }

  object printObject extends printMe {
    def p[A](i: A): Unit = println("Hello from object (" + i + ")")
  }

  val p = new printObject[Int]
  p.p(1)

  val s = new printObject[String]
  s.p("Hello there")

  printObject.p(0)
  printObject.p("Hello")

  // ---------------

  def getMiddle[T](a: Array[T]) = a(a.length / 2)

  println(getMiddle(Array("one", "two", "three")))

  val f = getMiddle[String] _

  println(f(Array("a", "b")))

  // Takes two parameters of different types
  class PairOne[T, S](val first: T, val second: S)

  // Takes two parameters of the same type

  // To make sure that type T has compareTo members,
  // we need to add upper bound
  class PairTwo[T <: Comparable[T]](val first: T, val second: T) {
    def smaller: T = if (first.compareTo(second) < 0) first
    else second
  }

  val p1 = new PairOne[Any, Any](1, "Hello")
  val p2 = new PairOne(2, "Hello again")

  //val p3 = new PairTwo[Any](1, 1)
  //val p4 = new PairTwo("Hello", "World")

  println(p1.first + " " + p1.second)
  println(p2.first + " " + p2.second)

  class Person
  class Student extends Person

  //def makeFriends(p: Pair[Person])
}
