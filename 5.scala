object LetterCount {
  
  def countLetterOccurrences(words: List[String]): Int = {
   
    val lengths = words.map(word => word.length)
    
    
    val totalOccurrences = lengths.reduce((acc, length) => acc + length)
    
    totalOccurrences
  }

  def main(args: Array[String]): Unit = {
    
    val words = List("apple", "banana", "cherry", "date")
    val total = countLetterOccurrences(words)
    println(s"Total count of letter occurrences: $total")
  }
}