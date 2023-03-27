
//파일이름이랑 클래스 이름이 동일하지 않아도 된다
//여러클래스를 한 파일에 넣을 수 있다.

//파일명과 동일하게 만드는 것을 권장하기는 한다.
class ClassPractice {

}

//class Human constructor(name : String){
//constructor에서 받는 name이랑 같은 이름이니까 그냥
//생성자에서 한번에 받아
//val name = name
//class Human constructor(val name : String){
//constructor생략가능
//class Human (val name : String){

//default값도 지정할 수 있음 ->val anonymous = Human()
//val anonymous = Human()라는 name을 넘기지 않는 생성자도 만들어진다. -> 이렇게하면 name에 default값이 들어가겠지

//다른 클래스에서 상속받을 수 있도록 open처리
open class Human (val name : String = "Anonymous"){

    //java라고 하면 -> koltin에서는 constructor 사용
    /*   class Human{
           private String name;
           private int age;

           public Human(){

           }

           public Human(Strng name){
               this.name = name;
           }

           public Human(String name, int age){
               this.name = name;
               this.age = age;
           }
       }*/

    //부생성자 -> 주생성자의 위임을 받아야한다 -> this
    //주생성자가 없는 경우 this로 위임받을 필요 없고
    //이 부생성자를 주생성자로 쓰도록 추천됨
    //name이 자동으로 상속됨
    constructor(name : String, age : Int) : this(name){
        println("my name is ${name}, ${age} years old")
    }

    //init은 주생성자의 일부 -> constructor(부생성자)보다 먼저 실행된다
    //처음 객체를 생성할때 하고 싶은 초기화 -> 생성됨과 동시에 코드블럭이 실행
    init{
        println("New Human has been born~")
    }

    fun eatingCake(){
        println("This is so yummy")

    }

    open fun singASong(){
        println("lalala")
    }

}


//class Korean extends Human {} - 상속
//kotlin은 final class -> 같은 파일에 있어도 접근을 못함 -> Human에 open이 필요함
class Korean : Human() {

    //overriding -> 부모클래스에 있는 메서드를 재정의
    //그냥 override하면 'singASong' in 'Human' is final and cannot be overridden 에러
    //open이 필요함!
    override fun singASong(){
        super.singASong()   //부모클래스 singasong도 쓸 수 있음
        println("라라라")
        //name은 부모클래스의 name에서 default값을 정해줌 -> anonymous가 출력됨
        println("my name is ${name}")
    }

}
fun main(){
    //Human human = new Human()
    //객체를 생성할때 name일 지정해주고 싶은경우 -> 생성자를 이용해!

    //val human = Human("dike")
    //human.eatingCake()
    //val anonymous = Human()

    //println("Anonymous name is ${anonymous.name}")

    //println("============================================")

    //val mom = Human("boki", 60)

    val korean = Korean()
    korean.singASong()

}