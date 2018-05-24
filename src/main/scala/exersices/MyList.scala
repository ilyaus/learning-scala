package exersices

object MyList extends App {
  println("Testing Scala Linked List!")

  val l: LinkedList = new LinkedList()
  println(l.isEmpty)
  l.add(0).add(1).add(2)
  println("List: " + l)
  println("Head: " + l.head)
  println(l.isEmpty)

  println("------------")

  val l1 = new Cons(1, new Cons(2, Empty))

  println(l1.add(3).head)

  println(l1.head)
  println(l1.tail.head)
  println(l1)
}

abstract class MyList {
  /*
    List of integers, singly linked

    head = first element of the list
    tail = remainder of the list
    isEmpty = returns a boolean
    add(int) => returns new list with added element
    toString => returns string representation of the list

   */

  def head: Int
  def tail: MyList

  def isEmpty: Boolean
  def add(n: Int): MyList

  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

// Class implementation:
object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(n: Int): MyList = new Cons(n, Empty)

  override def printElements: String = ""

}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(n: Int): MyList = new Cons(n, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

// My implementation:
class LinkedList extends MyList {
  var data: Int = _
  var firstLink: LinkedList = _
  var lastLink: LinkedList = _
  var nextLink: LinkedList = _

  def head: Int = firstLink.data

  def tail: LinkedList = firstLink.nextLink

  def add(n: Int): LinkedList = {
    val temp: LinkedList = new LinkedList()
    temp.data = n

    this.attach(temp)
    this
  }

  def isEmpty: Boolean = this.firstLink == null


  override def printElements: String = {
    def helper(l: LinkedList, acc: String = ""): String = {
      if (l == null) acc
      else helper(l.nextLink, acc + l.data + " ")
    }

    helper(firstLink)
  }

  private def attach(l: LinkedList): Unit = {
    if (firstLink != null) {
      lastLink.nextLink = l
    } else {
      firstLink = l
    }
    lastLink = l
  }
}