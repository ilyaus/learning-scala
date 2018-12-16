package playground

import scala.beans.BeanProperty

class Employee(@BeanProperty val firstName:String,
               @BeanProperty val lastName:String,
               val title:String) {

  def this(firstName:String, lastName:String) {
    this(firstName, lastName, "Title")
  }

  require(firstName.nonEmpty, "First name cannot be empty")
  require(lastName.nonEmpty, "Last name cannot be empty")
  require(title.nonEmpty, "Title cannot be empty")

  if(title.contains("Senior") || title.contains("Junior"))
    throw new IllegalArgumentException("Title cannot be Senior or Junior")

  def fullName:String = s"$firstName $lastName"

  def changeLastName(ln:String) = new Employee(firstName, ln, lastName)

  def copy(firstName:String = this.firstName, lastName:String = this.lastName, title:String = this.title):Employee = {
    new Employee(firstName, lastName, title)
  }
}


class Department(val name:String)

class Manager(firstName: String, lastName: String, title: String, val department: Department) extends
  Employee(firstName, lastName, title) {
  override def fullName: String = s"${super.fullName} ${department.name} Manager"

  override def copy(firstName: String, lastName: String, title: String): Employee = super.copy(firstName, lastName, "Toy")
}


object EmployeeScript extends App {
  val ada = new Employee("Ada", "Something")

  println(ada)
  println(ada.firstName)
  println(ada.title)

  println("Full name: " + ada.fullName)

  val newAda = ada.changeLastName("Something else")
  println("New Ada's name: " +  newAda.fullName)

  try {
    val c = new Employee("C", "Plus", "Junior")
  } catch {
    case ex:IllegalArgumentException => println(ex.getMessage)
  } finally {
    println("Continuing with our program")
  }

  // ----
  val mathematics = new Department("mathematics")
  val alan = new Manager("Alan", "Turing", "Mathematician, Logician", mathematics)

  println("Alan's department: " + alan.department.name)

  val alanEmployee:Employee = alan

  println(alan.firstName)
  println(alanEmployee.firstName)

  println(alanEmployee.fullName)
}