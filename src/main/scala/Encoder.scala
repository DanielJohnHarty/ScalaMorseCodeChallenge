
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

  def morseEncode(s: String): String = {
    val encodedString: String = s.map(encodingMap).mkString(" ")
    return encodedString
  }

  def morseDecode(s: String): String ={
  val msgLetters = s.split("[ ]")
    val decodedString: String = msgLetters.map(decodingMap).mkString("")
    return  decodedString
  }

  def main(args: Array[String]) {
    val msgToEncode: String = args(0).toString
    val encodedMsg = morseEncode(msgToEncode)
    val decodedMsg = morseDecode(encodedMsg)
    printf("\nMessage Encoding:\n    %s\n    ↓\n    %s\n    ↓\n    %s\n",msgToEncode, encodedMsg, decodedMsg)
  }
}
