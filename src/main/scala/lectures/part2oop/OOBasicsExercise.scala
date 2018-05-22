package lectures.part2oop

object OOBasicsExercise extends App {
  val author: Writer = new Writer("Charles", "Dickens", 1912)
  val novel: Novel = new Novel("Great Expectations", 1949, author)

  println(author.fullName)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))

  val c: Counter = new Counter()
  c.inc.print
  c.print
  c.inc(10).print
}

class Writer(firstName: String, surName: String, val yearOfBirth: Int) {
  def fullName: String = s"$firstName $surName"
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge: Int = yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer): Boolean = this.author == author

  def copy(newYearOfRelease: Int): Novel =
    new Novel(this.name, newYearOfRelease, this.author)
}

class Counter(val value: Int = 0) {
  def currentCount: Counter = this

  def inc: Counter = new Counter(this.value + 1)
  //def inc(by: Int): Counter = new Counter(this.value + by)
  // Another option to write increment by recursively if
  // logging needs to be done in inc/dec functions
  def inc(by: Int): Counter =
    if (by <= 0) this
    else inc.inc(by - 1)

  def dec: Counter = new Counter(this.value - 1)
  //def dec(by: Int): Counter = new Counter(this.value - by)
  def dec(by: Int): Counter =
    if (by <= 0) this
    else dec.dec(by - 1)

  def print = println(value)
}