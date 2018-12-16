package playground

import scala.annotation.tailrec

object BasicRecursion extends App {
  def factorial(x:BigInt): BigInt = {
    if (x <= 1) 1
    else x * factorial(x - 1)
  }

  println(factorial(6))
}

object TailRecursion extends App {

  def factorial(y:BigInt):BigInt = {
    @tailrec
    def fact(x: BigInt, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else fact(x - 1, accumulator * x)
    }

    fact(y, 1)
  }

  println(factorial(6))
}