package hellotest
import scala.collection.mutable

class ConcreteOutputObserver extends OutputObserver:
  override type Result = mutable.Map[String, Int]
  
  override def output(cloud: Result): Unit =
  {
    // DO: call convert function and print result to the standard output for the user
    println(convert(cloud))
  }

  override def convert(cloud: Result): String =
  {
    // DO: convert the given map object into a string representation and return it
    val keys = cloud.toSeq.sortBy(_._2).reverse.toMap.keysIterator
    if (!keys.hasNext) return ""
    var key = keys.next()
    var output = key + ": " + cloud(key)
    while (keys.hasNext)
      key = keys.next()
      output += " " + key + ": " + cloud(key)
    return output
  }
end ConcreteOutputObserver

