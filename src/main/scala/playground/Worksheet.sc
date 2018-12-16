import scala.annotation.tailrec

println("Hello World")

var x: Int = 1
x = 2



def factorial(x: Int): Int = {
  if (x <= 1) 1
  else x * factorial(x - 1)
}

def factorial1(x: Int, acc: Int = 1): Int = {
  if (x <= 1) acc
  else factorial1(x - 1, x * acc)
}

def factorial2(x: Int): Int = {
  def loop(x: Int, acc: Int): Int = {
    if (x <= 1) acc
    else loop(x - 1, acc * x)
  }

  loop(x, 1)
}

factorial(10)
factorial(10)
factorial1(10)
factorial2(10)

val name = "Ilya"
val x1 = 2
val y = x1 + " " + name + " there"

val a:Byte = 1
val maxShort:Short = 32767

1 + 4
1.+(4)

-5.abs
Math.abs(-5)








