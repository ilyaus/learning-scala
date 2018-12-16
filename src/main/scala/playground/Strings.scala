package playground

import java.time._

object Strings extends App {
  val lyrics = """I see trees of green,
                  |Red roses too,
                  |I see them bloom,
                  |For me and you,
                  |And I think to myself,
                  |What a wonderful world""".stripMargin('|')

  println(lyrics)

  val message = "We are meeting on June 13th of this year, and having lunch at 12:30PM or 3:20AM"
  val regex = """(\s|[0-9])?[0-9]:[0-5][0-9]\s*(AM|PM)""".r

  println(regex.findAllIn(message).toList)
}


object StringFormat extends App {
  // Java style
  val str = String.format("This is a %s", "Test")

  // Scala style
  val str1 = "This is a %s".format("Test")

  println(str)
  println(str1)

  println("Because you are %3$s, %2$s, %1$s times a lady".format("Three", "Twice", "Once"))
  println("We will be eating lunch on %1$tB the %1$te in the year %1$tY.".format(LocalDate.now))
  printf("We will be eating lunch on %1$tB the %1$te in the year %1$tY.\n", LocalDate.now)

  val lyrics = """I see trees of %s,
                 |%s roses too,
                 |I see them bloom,
                 |For me and you,
                 |And I think to myself,
                 |What a wonderful world""".stripMargin('|').format("green", "Red")

  println(lyrics)
}

object StringInterpolation extends App {
  val a = 99
  println(s"${a} balloons floating in the summer sky")
  println(s"$a balloons floating in the summer sky")

  println(s"${a + 3} balloons floating in the summer sky")

  // -- F interpolator
  val ticketCost:Double = 50
  val bandName = "Psychedelic Furs"

  println(f"The $bandName ticket are probably $$$ticketCost%1.2f")

  val percentIncrease = 20
  val musicGenre = "New Wave"

  println(f"The $percentIncrease%% increase.%nAnd this is a new line")
  println(f"""The $percentIncrease%% increase.
              |And this is a new line""".stripMargin)
}