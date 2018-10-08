import java.lang.IllegalArgumentException

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(expr: Expr) : Int {
    if(expr is Num) {
        return expr.value
    } else if(expr is Sum) {
        return eval(expr.left) + eval(expr.right)
    }
    throw IllegalArgumentException("Unknown Expression")
}

fun eval2(expr: Expr) : Int {
    when(expr) {
        is Num -> return expr.value
        is Sum -> return eval2(expr.left) + eval2(expr.right)
    }
    throw IllegalArgumentException("Unknown Expression")
}

fun eval3(expr: Expr) : Int =
        when(expr) {
            is Num -> expr.value
            is Sum -> eval3(expr.left) + eval3(expr.right)
            else -> throw IllegalArgumentException("Unknown Expression")
        }
fun eval4(e: Expr): Int =
        when (e) {
            is Num -> {
                println("num: ${e.value}")
                e.value
            }
            is Sum -> {
                val left = eval4(e.left)
                val right = eval4(e.right)
                val result = left + right
                println("sum: $left + $right = $result")
                result
            }
            else -> throw IllegalArgumentException("Unknown expression")
        }
fun main(args: Array<String>) {
    println(eval4(Sum(Sum(Num(3),Num(4)),Num(3))))
}