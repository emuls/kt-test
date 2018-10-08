fun main(args: Array<String>) {
    println(foo("rex"))
    println(foo("bob", 50))
    println(foo("rex", 50 , true))
    println(foo(number = 28, name = "rex"))
}


fun foo(name: String, number: Int = 42, toUpperCase:Boolean = false): String = (if (toUpperCase) name.toUpperCase() else name) + number