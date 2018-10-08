package list

import java.lang.RuntimeException


fun main(args: Array<String>) {
    val strings: KTList<String> = KTList();
    strings.apply {
        add("A")
        add("B")
        add("C")
        add("D")
    }

    val ints: KTList<Int> = KTList();
    ints.apply {
        add(1)
        add(2)
        add(3)
        add(4)
        add(5)
    }
    println(strings);
    println(ints);
    ints.remove(3)
    strings.remove(0)
    println(strings)
    println(ints)
    ints.remove(3)
    println(ints)
    while(ints.length>0) {
        ints.remove(0)
    }
    println(ints)
}

class KTList<T> {
    var head: Node<T>? = null
    var length: Int = 0

    fun isEmpty() = head == null

    fun add(value: T) {
        length++;
        if (head == null) {
            head = Node(value)
        } else head?.let {
            var current: Node<T> = it
            while (current.next != null) current = current.next!!
            current.next = Node(value)
        }
    }

    fun remove(i: Int) {
        var counter = 0;
        if (head != null) {
            var current: Node<T> = head!!
            var previous: Node<T>? = null
            while (current.next != null && counter < i) {
                counter++
                previous = current
                current = current.next!!
            }

            when {
                (counter == 0) -> head = head!!.next;
                (previous != null) -> previous.next = current.next
                else -> head = head!!.next;
            }
        } else {
            throw RuntimeException("Invalid index")
        }
        length--;
    }

    fun each(eachFun: (A: Node<T>) -> Unit ) {
        if(head != null) {
            var current = head as Node<T>
            eachFun(current)
            while(current.next!=null) {
                current = current.next as Node<T>;
                eachFun(current)
            }
        }
    }

    override fun toString() = "{${commaNodes()}}"

    private fun commaNodes(): String {
        var result = "";
        when {
            (head == null) -> result = "";
            (head != null) -> {
                result = "";
                each {
                    result = result + it.value + ",";
                }
                if(result.endsWith(",")) {
                    result = result.substring(0, result.length-1);
                }
            }
        }
        return result;
    }

}