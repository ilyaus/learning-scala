package lectures.part1basics

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - first I need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }

  println(factorial(6))

  def anotherFactorial(n: Int): Int = {
    def factorialHelper(x: Int, accumulator: Int): Int =
      if (x <= 1 ) accumulator
      else factorialHelper(x - 1, x * accumulator)

    factorialHelper(n, 1)
  }



  def aRepeatedFunction(aString: String, n: Int): String = {
    def helper(acc: String, x: Int): String = {
      if (x == n) acc
      else helper(aString + acc, x + 1)
    }

    helper(aString, 1)
  }

  println(aRepeatedFunction("Hello", 3))


  def fibonacci(n: Int): Int = {
    def helper(acc1: Int, acc2: Int, seq: Int): Int = {
      println("acc1: " + acc1 + "; acc2: " + acc2)

      if (seq >= n) acc2
      else helper(acc2, acc1 + acc2, seq + 1)
    }

    if (n <= 2) 1
    else helper(1, 2, 3)
  }

  println(fibonacci(4))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }
}
