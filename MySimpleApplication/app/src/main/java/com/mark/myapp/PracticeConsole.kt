package com.mark.myapp

class PracticeConsole {

    fun practiceOnConsoleMethod() {

        // Console test
        println("--- THE BEGINNING OF MY MESSAGES\nON LOGCAT CONSOLE ---")


        println()
        // the difference between val and var

        var a : String = "valamilyen érték"

        a = "valamilyen más szöveg"
        println(a)

        val b : String = "egy amolyan szöveg ez"
        println(b)


        println()
        // using 'lateinit var'

        lateinit var c : String

        c = "ez egy érték"

        c = "van az érték"

        println(c)

        var d = "Ez egy szöveg."

        println(d)


        println()
        // 'Nullable' variables

        var f : String? = null      // in this case, a 'null' can be used

        println(f)

        println(f?.length) // a question mark is needed if we want to try using a Method


        // double exclamation mark

        //println(f!!.length) // this throws an error (in this case, the value cannot be 'null'


        // using the 'let' function if the value is 'null' or the value is not 'null'

        f?.let {    // .let function usage

                it -> println(it.length)

        }

        f = "Valamilyen érték ez."

        f?.let {

                it -> println(it.length)

        }

        // (the .let function usage is similar to this (in Java))
        if ( f != null ) {
            println(f?.length)
        }


        println()
        println("--- elvis operator test ---")
        // using the Elvis Operator

        // if the value of the elvis operator is not 'null'

        // println( f?.let{it.length} )
        //val anElvisOperator = f?.let{it.length}

        val anElvisOperator = f?.let{it.length} ?: 0

        println( anElvisOperator )

        // if the value of the elvis operator is 'null'

        var h : String? = null

        val anotherElvisOperator: Int = h?.let{it.length} ?: 0

        // val anotherElvisOperator: Int? = h?.let{it.length}

        println( anotherElvisOperator )


        // practising class and object creation
        println()
        println("--- class creation test ---")

        val p = Person_1(name = "Jake")

        val p_2 = Person_2(name = "Jake")

        val p_3 = Person_3(name = "Jake")

        val p_4 = Person_4(name = "Jake")

        println(p)

        println(p_2)

        println(p_3)

        println(p_4)


        println()

        val p_5 = Person_5(name = "Jake").apply {       // .apply function usage

            // 'this' -- > it refers to a 'Person' object

            println(this.name)

            age = 30

        }

        println(p_5)


        // data classes and copying objects
        println()
        println("--- copying objects test ---")

        val personObject = Person_6(name = "A", age = 12)

        println(personObject)

        val personObjectCopy = personObject.copy()

        println(personObjectCopy)

        val personObjectCopy_2 = personObject.copy(age = 43)

        println(personObjectCopy_2)

        println()

        personObjectCopy.name = "B"

        println(personObjectCopy)           // it is a 'copy by value'

        println(personObjectCopy_2)         // it is a 'copy by value'


        // using extension functions
        println()
        println("--- extension function test ---")

        println(personObject.nameLength())

        println(personObject.name.getFirst())


        // practising with a mutable list
        println()
        println("--- mutable list test ---")

        val mutableList = mutableListOf(4,2,3,1)

        println(mutableList)

        mutableList.swap(0,3)

        println(mutableList)

        // Our extension function 'swap' cannot be used in this case because we can only manipulate a list of integers
        // mutableListOf("Alma", "Barack", "Citrom").swap(0,2)

        println()


        //mutableList.add(index = 0, element = 765)
        mutableList.add(0, 765)

        println(mutableList)          // (! the variable itself is 'immutable')


        var immutableList = listOf(9,8,7,6, "Alma", "Barack", "Citrom")

        // immutableList.add(0, 123) // this is an 'immutable' list, a function cannot be used on it

        println(immutableList)

        immutableList = listOf(11,22,33,44)     // (! the variable itself is 'mutable')

        println(immutableList)


        println("--- THE ENDING OF MY MESSAGES\nON LOGCAT CONSOLE ---")

    }

}


// practising class and object creation

// class Person ( )
class Person_1 constructor(
    val name: String

)

class Person_2 (
    val name: String

){
    //override fun toString(): String {
    //    return super.toString()
    //}
    override fun toString(): String {
        return "$name"
    }

}

data class Person_3 constructor(
    val name: String

)

data class Person_4 constructor(
    val name: String

){

    var age : Int = 0

    override fun toString(): String {
        return "$name, $age"
    }

}

data class Person_5 constructor(
    val name: String

){

    var age : Int = 0

    override fun toString(): String {
        return "$name, $age"
    }

}


// data classes and copying objects

data class Person_6 constructor(
    var name: String,               // (! a comma is needed here)

    var age : Int

)/*{
    fun nameLength(): Int {             // an extension function example #
        return name.length
}*/


// using extension functions

fun Person_6.nameLength(): Int {        // an extension function example #

    // 'this' -- > it refers to a 'Person' object

    return name.length

}

fun String.getFirst(): Char = this.first()
/*
// you can also write it this way (it does the same thing):

        fun String.getFirst(): Char {
            return this.first()
        }

 */


// practising with a mutable list

fun MutableList<Int>.swap(fromVariable: Int, toVariable: Int) {

    // applying a swapping algorithm

    val tmpVariable = this[fromVariable]    // 'this' -- > 'MutableList<Int>' Class (so it is a List object)

    // this[fromVariable] -- > it can be also written in this way: MutableList<Int>[fromVariable]
    // (it means that inside the List, we want to get the corresponding values from the indexes)

    this[fromVariable] = this[toVariable]

    this[toVariable] = tmpVariable

}