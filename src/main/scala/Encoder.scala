
object Encoder{

  // Taken from https://github.com/jordiolivares/Morsecoder/blob/master/morsedecoder.scala
  val encodingMap = Map(
    // Letters
    'A' -> ".-", 'B' -> "-...", 'C' -> "-.-.", 'D' -> "-..", 'E' -> ".",
    'F' -> "..-.", 'G' -> "--.", 'H' -> "....", 'I' -> "..", 'J' -> ".---",
    'K' -> "-.-", 'L' -> ".-..", 'M' -> "--", 'N' -> "-.", 'O' -> "---",
    'P' -> ".--.", 'Q' -> "--.-", 'R' -> ".-.", 'S' -> "...", 'T' -> "-",
    'U' -> "..-", 'V' -> "...-", 'W' -> ".--", 'X' -> "-..-", 'Y' -> "-.--",
    'Z' -> "--..",
    // Numbers
    '1' -> ".----", '2' -> "..---", '3' -> "...--", '4' -> "....-",
    '5' -> ".....", '6' -> "-....", '7' -> "--...", '8' -> "---..",
    '9' -> "----.", '0' -> "-----",
    // Punctuation and blank spaces
    '@' -> ".--.-.", '.' -> ".-.-.-", ',' -> "--..--", '?' -> "..--..",
    '\'' -> ".----.", '!' -> "-.-.--", '/' -> "-..-.", '(' -> "-.--.",
    ')' -> "-.--.-", '&' -> ".-...", ':' -> "---...", ';' -> "-...-",
    '+' -> ".-.-.", '-' -> "-....-", '_' -> "..--.-", '"' -> ".-..-."
  )

  val decodingMap = encodingMap.map(_.swap)

  def encode(msgToEncode: String): String = {
    val encodedString: String = msgToEncode.map(encodingMap).mkString(" ")
    println(encodedString)
    return encodedString
  }

  def decode(msgToDecode: String): String = {
    val msgLetters = msgToDecode.split("[ ]")
    val decodedString: String = msgLetters.map(decodingMap).mkString("")
    println(decodedString)
    return  decodedString
  }

  def main(args: Array[String]) {
    val msgToEncode: String = args(0).toString

    println("Message to encode: " + msgToEncode)
    val encodedMsg = encode(msgToEncode)
    val decodedMsg = decode(encodedMsg)
  }
}
