package exersices

abstract class MyList {
  /*
    List of integers, singly linked

    head = first element of the list
    tail = remainder of the list
    isEmpty = returns a boolean
    add(int) => returns new list with added element
    toString => returns string representation of the list

   */

  def head: ListElement
  def tail: MyList
  def isEmpty: Boolean
  def add(n: Int): MyList
  def toString: String
}

class List extends MyList {
  class ListElement(val n: Int, val list: List)

  val listElement: ListElement()

  def head: ListElement
}