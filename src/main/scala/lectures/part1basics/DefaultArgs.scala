package lectures.part1basics

object DefaultArgs extends App {

  def factorial(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else factorial(n - 1, n * acc)
  }
}
