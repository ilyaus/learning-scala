package lectures.part1basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = {
    "Hello, World!" + " " + a + " " + b
  }

  println(aFunction("Hello", 2))

  def aParameterlessFunction(): Int = 43

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Hello", 3))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def greetingForKids(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + Int

  def factorial(n: Int): Int = {
    if (n == 1) 1
    else n * factorial(n - 1)
  }

  def fibonacci(n: Int): Int = {
    if (n == 1 || n == 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  // ------------
  println(greetingForKids("Max", 84))
  println("Factorial of 5 is " + factorial(5))
  println("Fibonacci of 8 is " + fibonacci(8))
  println("Is prime: 2003 " + isPrime(2003))
  println(isPrime(44 * 45))
}
