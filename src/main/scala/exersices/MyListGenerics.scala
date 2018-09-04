package exersices

object MyListGenerics extends App {
  println("Testing Scala Linked List!")

  val listOfIntegers: MyListGenerics[Int] = new ConsGenerics(1, new ConsGenerics(2, EmptyGenerics))
  val listOfString: MyListGenerics[String] = new ConsGenerics("Hello", new ConsGenerics("Scala", EmptyGenerics))

  println(listOfIntegers.toString)
  println(listOfString.toString)

//  val l: LinkedListGenerics = new LinkedListGenerics()
//  println(l.isEmpty)
//  l.add(0).add(1).add(2)
//  println("List: " + l)
//  println("Head: " + l.head)
//  println(l.isEmpty)

  println("------------")

/*  val l1 = new ConsGenerics[Int](1, new ConsGenerics[Int](2, EmptyGenerics))

  println(l1.add(3).head)

  println(l1.head)
  println(l1.tail.head)
  println(l1)*/
}

abstract class MyListGenerics[+A] {
  /*
    List of integers, singly linked

    head = first element of the list
    tail = remainder of the list
    isEmpty = returns a boolean
    add(int) => returns new list with added element
    toString => returns string representation of the list

   */

  def head: A
  def tail: MyListGenerics[A]

  def isEmpty: Boolean
  def add[B >: A](n: B): MyListGenerics[B]

  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

// Class implementation:

object EmptyGenerics extends MyListGenerics[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyListGenerics[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](n: B): MyListGenerics[B] = new ConsGenerics(n, EmptyGenerics)

  override def printElements: String = ""
}

class ConsGenerics[+A](h: A, t: MyListGenerics[A]) extends MyListGenerics[A] {
  def head: A = h
  def tail: MyListGenerics[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](n: B): MyListGenerics[B] = new ConsGenerics(n, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}


// My implementation:
/*
class LinkedListGenerics extends MyListGenerics {
  var data: Int = _
  var firstLink: LinkedListGenerics = _
  var lastLink: LinkedListGenerics = _
  var nextLink: LinkedListGenerics = _

  def head: Int = firstLink.data

  def tail: LinkedListGenerics = firstLink.nextLink

  def add(n: Int): LinkedListGenerics = {
    val temp: LinkedListGenerics = new LinkedListGenerics()
    temp.data = n

    this.attach(temp)
    this
  }

  def isEmpty: Boolean = this.firstLink == null


  override def printElements: String = {
    def helper(l: LinkedListGenerics, acc: String = ""): String = {
      if (l == null) acc
      else helper(l.nextLink, acc + l.data + " ")
    }

    helper(firstLink)
  }

  private def attach(l: LinkedListGenerics): Unit = {
    if (firstLink != null) {
      lastLink.nextLink = l
    } else {
      firstLink = l
    }
    lastLink = l
  }
}
*/