package exersices

object MyListGenerics extends App {
  println("Testing Scala Linked List!")

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

abstract class MyListGenerics[A] {
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
  def add(n: A): MyListGenerics[A]

  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

// Class implementation:
/*
object EmptyGenerics extends MyListGenerics {
  def head[A]: A = throw new NoSuchElementException
  def tail[A]: MyListGenerics[A] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[A](n: A): MyListGenerics[A] = new ConsGenerics[A](n, EmptyGenerics)

  override def printElements: String = ""
}

class ConsGenerics[A](h: A, t: MyListGenerics[A]) extends MyListGenerics {
  def head[A]: A = h
  def tail[A]: MyListGenerics[A] = t
  def isEmpty: Boolean = false
  def add[A](n: A): MyListGenerics[A] = new ConsGenerics(n, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}
*/

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