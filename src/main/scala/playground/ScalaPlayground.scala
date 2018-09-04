package playground

object ScalaPlayground extends App {
  println("Hello Scala!")

  // Quick sort:
  val l = List(6,1,3,5,2,3,2,4)
  println(l)
  println(quicksort(l))

  def quicksort[T](x: List[T]): List[T] = {
    x match {
      case xh::xt =>
        val (first, pivot, second) = partition(x)
        quicksort(first):::(pivot::quicksort(second))
      case Nil => x
    }
  }

  def partition[T](x: List[T]):(List[T], T, List[T]) = {
    val pivot = x.head

    var first: List[T] = List()
    var second: List[T] = List()

    val sort = (i: T) => {
      if (i.asInstanceOf[Comparable[T]].compareTo(pivot) <=0) first = i::first
      // if (i < pivot) first = i::first
      else second = i::second
    }

    x.tail.foreach(sort)

    (first, pivot, second)
  }
}
