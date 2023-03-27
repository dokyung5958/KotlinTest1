package com.example.kotlintest1

//1.Lamda
// 람다식은 우리가 마치 value처럼 다룰 수 있는 익명함수
// 1) 메소드의 파라미터로 넘겨줄 수 있다. fun maxBy(a : Int)
// 2) return 값으로 사용할 수가 있다.

//람다의 기본정의
//val lamdaName : Type = {argumentList -> codeBody}

//int -> int input으로 int타입을 넣고 int타입으로 output을 return받겠다
//number를 int라고 정의해주지않아도 타입추론으로 int라고 정의함
//val square : (Int) -> (Int) = {number -> number * number}
//int라고 어디선가는 한번은 선언을 해주어야 한다
val square = {number : Int -> number * number}
//타입추론을 할 수 있는 만큼의 정보는 제공해야 한다.
val nameAge = {name : String, age : Int
    -> "My name is ${name} I'm ${age}"}


fun main(){
    println(square(12))
    println(nameAge("dike", 10))
    val a = "A said "
    val b = "B said "

    println(a.pizzaIsGreate())
    println(b.pizzaIsGreate())

    println(extendString("AAA", 20))

    println(calculateGrade(100))

    println("=============================================================")


    //Double의 number라는 파라미터를 받아서 그 number가 4.3213인지 아닌지 boolean을 리턴한다.
    val lamda = {number : Double ->
        println("getNumber : ${number}")
        number == 4.3213
    }

    println(invokeLamda(lamda))
    //람다리터럴 : 바로 값을 넣어버리는것 - lamda호출X => 리턴값을 그냥 박아버림
    println(invokeLamda({true}))
    
    //it - 넣는 파라미터가 하나일 때 - 5.234-lamda를 넣어서 호출할때 넣은 파라미터값(유일한 파라미터)
    println(invokeLamda({it > 3.22}))
    //invokeLamda({}) -> 소괄호 생략 => 같은 식
    //function의 마지막 파라미터가 람다식인 경우에 가능
    invokeLamda { it > 3.22 }



}


//확장함수
//익명함수 string함수를 확장한다
//this : 이 함수를 실행하게 하는 String -> a.pizzaIsGreate -> a가 this
val pizzaIsGreate : String.() -> String = {
    this + "Pizza is the best!"
}

//this : 실제 함수를 콜하는 오브젝트
//it : 하나 들어가는 파라미터의 경우 it으로 생략이 가능함
fun extendString(name : String, age : Int) : String {
    val introduceMySelf : String.(Int) -> String = {
        "I am ${this} and ${it} year old"
    }
    return name.introduceMySelf(age)
}


//람다의 return
//int를 파라미터로 받을땐 소괄호???????
//Stirng을 반환해야하기 때문에 반드시 반환할 문자열이 필요하다 -> 반드시 else가 필요함
val calculateGrade : (Int) -> String = {
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

//람다를 표현하는 방법
//invokeLamda는 boolean을 리턴하는데, 파라미터로 넘긴 lamda를 사용할건데,
//그 lamda에 5.234을 넣어서 리턴하는 불리언값을 리턴값으로 한다.
fun invokeLamda(lamda : (Double) -> Boolean) : Boolean {
    return lamda(5.234)
}

//익명내부함수
//onclicklistner
//1. Kotlin interface가 아닌 자바인터페이스여야한다
//2. 그 인터페이스는 딱 하나의 메소드만 가져야한다.