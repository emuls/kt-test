fun fizzBuzz(f: Int): String =
        when {
            f % 15 == 0 -> "FizzBuzz "
            f % 5 == 0 -> "Buzz "
            f % 3 == 0 -> "Fizz "
            else -> "$f "
        }

fun main(args: Array<String>) {
    for(i in 1 .. 100) {
        print(fizzBuzz(i))
    }
    println("\n----")
    for(i in 1 until 100) {
        print(fizzBuzz(i))
    }
    println("\n----")
    for(i in 100 downTo 1 step 5) {
        print(fizzBuzz(i))
    }

    val hexReps = HashMap<Int, String>()
    for(c in 0..255) hexReps[c] = Integer.toHexString(c)
    for((char, hex) in hexReps ) println("$char = $hex")

}