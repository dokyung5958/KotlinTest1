package com.example.kotlintest1

fun main(){

    //3. String Template
    val name = "dike"
    val lastName = "Lee"
    println("my name is $name Hi") //자동매치 - 띄어쓰기로 다음 스트링과 구분
    println("my name is ${name + lastName} Hi") //이렇게하면 띄어쓰기 안하고 변수를 구분해줌

    //forAndWhile();

    nullcheck();

}

//1. 함수
//변수명을 타입보다 먼저 리턴값은 기능 전에 정의한다
//리턴형 void = Unit -> 생략가능
fun helloWorld() : Unit{
    println("hello World!")
}

//리턴이 있는 경우는 리턴타입 생략 불가능
fun add(a : Int, b : Int) : Int {
    return a + b
}


//2. val vs var
// val = value : 바뀌지 않는 값
fun hi(){
    val a : Int = 10    //변하지 않는 값 -> 상수?
    var b : Int = 9     //변할 수 있는 값

    b = 7 //가능
    //a = 7 -> 불가능

    println(b)

    val c = 100 //코틀린이 타입추론을 해주기 때문에 타입지정해주지 않아도 된다
    var d = 100 //val var 둘다 타입생략 가능 하지만 var인지 val인지는 반드시 지정해줘야 한다.

    var name = "dike"

    var e : String  //타입만 선언 가능
}


//4. 조건식
fun maxBy(a : Int, b : Int) : Int {
    if(a > b){
        return a
    }else{
        return b
    }
}
// 같은 결과 -> 자바의 삼항연산은 코틀린에 없음
//뽀짝뽀짝해서 값을 만들면  expression
fun maxBy2(a : Int, b : Int) = if( a > b) a else b


//참고 : java는 void는 statement (-> 명령지시)로 취급한다
// -> Unit을 생략할 수 있지만, 어쨋든 Unit이라는 리턴값이 있기는 하다 -> 모든 함수는 kotlin에서 Expression으로 사용이 된다!
//fun checkNum(score : Int) : Unit{
fun checkNum(score : Int){
    //값을 만들지않았다 -> Statement
    when(score){    //java switch
        0 -> println("This is 0")
        1 -> println("This is 1")
        2,3 -> println("this is 2 or 3")
        else -> println("I don't know")

    }

    //값을 만들어서 b를 리턴했다 -> Expression
    //정의할 때 이런 표현식으로 사용할 경우는 반드시 else를 포함해야함
    // 결과값이 b에 저장되어야 하니까!
    var b = when(score){
        1 -> 1
        2 -> 2
        else -> 3
    }
    println("b : ${b}")

    //정의하는 용도가 아니기 때문에 else가 없어도 가능하다
    when(score){
        in 90..100 -> println("You are genius")
        in 10..80 -> println("not bad")
        //else -> println("okay")
        else -> println("okay")
    }

}

//Expression vs Statement
//뚱땅뚱땅 무언가의 값을 만들어내고 리턴했다 ->  Expression
//값을 만들어내지않고 그냥 지시했다 -> Statement

//5.Array and List
//Array : 배열 = 사이즈가 정해져있다. 메모리가 할당되어있다.
//List : 1.List : 읽기전용 - get만 있음
//2.MutableList : 읽기쓰기 가능 - add, remove, set이 있음

fun array(){
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)

    //대박 짱신기하당
    val array2 : Array<Any> = arrayOf(1,"d", 3.4f)
    val list2 = listOf(1,"d",11L)

    array[0] = 3
    //불가능!
    //list[0] = 1
    var result = list.get(0)    //읽기는 가능 - set은 없음!

    //var arrayList = arrayListOf<Int>() 도 가능!
    //인덱스의 값은 변할 수 있다 -> 주소값이 바뀌지는 않는다!
    val arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(100)

    //var로 선언했을 때는 가능한데 val로 선언하면 불가능 -> 새로운개체로 바꾸는 것은 불가하기 때문에
    //arrayList = arrayListOf()

}

//6. for / while
fun forAndWhile(){
    val students = arrayListOf("joyce", "james", "jenny", "kuri", "dike")


    for (name in students){
        println("${name}")
    }

    //인덱스와 이름을 함께 사용
    for((index, name) in students.withIndex()){
        //인덱스는 0부터
        println("${index+1}번째 학생 : ${name}")
    }


    var sum : Int = 0
    //for(i in 1..10 step 2){
    //for(i in 10 downTo 1){ 10 9 8 7...
    //for(i in 1 until 100){ 1..100 과의 차이 :100을 포함하지 않는다. 1 < 100
    //1..100 : 1 <= 100

    for(i in 1..10){

        sum += i
    }

    println(sum)

    var index = 0
    while(index < 10){
        println("current index : ${index}")
        index++
    }

}


//7. Nullable / NoNull

fun nullcheck(){
    //NPE : Null pointer Exception
    //컴파일시점에서는 잡을 수 없고 런타임에서 발생 -> 런을 해봐야만 알 수 있음 -> 불편함
    //코틀린 : 컴파일시점에서 잡을 수 있도록 => ?

    //NoNull
    var name : String = "dike"

    //에러!
    //var nullName : String = null



    //Nullable -> null값이 가능한 변수이다 - ?
    var nullName : String? = null

    // null일 수가 없음.-> 바로 사용가능 NoNull케이스
    var nameInUpperCase = name.uppercase()

    //null인지 아닌지 알 수 없어서 사용가능한지 알 수 없다
    //var nullNameInUpperCase = nullName.uppercase()
    //?를 붙임 -> 만약에 nullName이 null이 아니면 uppercase를 하고
    //null이면 null을 리턴한다 -> 컴파일시점에서 에러를 알 수 있도록
    var nullNameInUpperCase = nullName?.uppercase()

    // ?: 엘비스연산자 null일 때 default값을 설정
    //val lastName : String? = null
    //val lastName = "Lee"

    var lastName : String? = null
    //lastName = "Lee"

    //null이 아니면 lastname을 출력하고 null이면 "No lastname"을 출력한다
    val fullName = name + " " + (lastName?:"No lastname")

    println(fullName)

}

fun ignoreNulls(str : String?){
    //!!연산자
    //nullable로 타입이 선언이 되어있긴 하지만 컴파일러한테 null이 아닌 것을 보장하는 연산자
    
    //str이 null일수도 있기 때문에 에러
    //val mNotNull : String = str

    //절대 str에 null이 들어올가능성이 0이다
    val mNotNull : String = str!!
    val upper = mNotNull.uppercase() //null이 아닌게 보장되어있기 때문에 uppercase사용 가능

    //!! 사용을 지양해야한다 -> 정말 확실하지 않는 이상 null pointer exception이 발생하기 때문에

    //null일수있다.
    val email : String? = "uksk37@gmail.com"
    //null이 아니면! 해라
    //let : 자신의 리시버객체를 람다식 내부로 옮겨서 실행하는 구문
    // - email을 람다식 내부로 옮겨줌
    //email이 null이 아닐때면 실행하기 때문에 print구문은 매우 안전하다
    email?.let {
        println("email is ${email}")
    }

}





