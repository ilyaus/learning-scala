package lectures.part2oop

object Inheritance extends App {

  class Animal {
    protected val creatureType = "Wild"
    def eat: Unit = println("nom...nom...nom")
  }

  class Cat extends Animal {
    def crunch: Unit = {
      eat
      println("Crunch ... Crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overwriting
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType: String = "Domestic"
    override def eat: Unit = {
      super.eat
      println("crunch ... crunch")
    }
  }

  val dog = new Dog("domestic")
  dog.eat
  println(dog.creatureType)

  // type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("K9")

  unknownAnimal.eat  // eat will be called from Dog class

}
