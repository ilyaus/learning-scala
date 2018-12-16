package playground

object BasicMethods extends App {
  def add(x:Int, y:Int)= x + y
  def numberStatus(n:Int) = {
    if (n < 10) "Less than 10"
    else if (n > 10) "Greater than 10"
    else "It is 10"
  }

  println(add(6, 7))
  println(numberStatus(1))
}

object ScalaTypes extends App {
  def add(x:Int, y:Int) = x + y
  def subtract(x: Double, y:Double) = x - y

  println(add(1,3))
  println(add(subtract(2,1).round.toInt,2))
}

object DifferentReturnTypes extends App {
  def add(x:Int, y:Int) =
    if (x > 10) (x + y).toString
    else x + y

  println(add(15,3))
}

object UnitMethods extends App {
  def add(x:Int, y:Int) =
    x + y

  def badAdd(x:Int, y:Int): Unit = {
    x + y
  }

  println(badAdd(1,2))
}

object BendingMethodNames extends App {
  def `summation of`(x:Int, y:Int) = x + y
  def areWeLikingScala_? = true

  val status = if(areWeLikingScala_?) "Nice" else "Sorry!"
}

object OperatorOverloading extends App {
  def +(x:Int, y:Int) = x + y

  println(1+3)
}

object MethodOverloading extends App {
  def addNum(x:Int) = x + 1
  def addNum(x:Double) = x + 2
  def addNum(x:String) = x + 3

  println(addNum(1))
  println(addNum(2.3))
  println(addNum("Hello "))
}

object ScalaInstances extends App {
  println(3.isInstanceOf[Int])
  println("3".isInstanceOf[String])
  println("3".isInstanceOf[CharSequence])

  val g:Any = "This is some sting"
  println(g)

  val h:String = g.asInstanceOf[String]
  println(h)

  def decide(x:Any) = if (x.isInstanceOf[Int]) x.asInstanceOf[Int] + 1 else -1

  println(decide(1))
  println(decide("Hi"))
}

object ParameterizedTypesOnMethods extends App {
  def decide(b:Boolean, x:Any, y:Any)= if (b) x else y

  println(decide(true, "A", "B"))
  println(decide(false, 3, 10))
  println(decide(true, 'c', 'd'))

  def getNextChar(c:Char) = (c + 1).toChar

  println(getNextChar('a'))
  val result = decide(true, 'a', 'b')
  if (result.isInstanceOf[Char])
    println(getNextChar(result.asInstanceOf[Char]))

  // ----
  def decide1[T](b:Boolean, x:T, y:T) = if (b) x else y

  println(getNextChar(decide1(true, 'a', 'b')))
}