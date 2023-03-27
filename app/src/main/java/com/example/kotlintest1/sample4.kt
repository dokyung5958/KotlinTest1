package com.example.kotlintest1

//object와 class와 다른점 : CarFactory라는 객체는 앱이 실행되는 동안 딱 한번만 만들어진다 -> Singletoe Pattern
//불필요한 메모리 사용X
object CarFactory{
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower: Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower : Int)

fun main(){
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(20)

    println("CarFactory size : ${CarFactory.cars.size}" )
    println(CarFactory.cars)
    println("car = ${car}")
    println("car2 = ${car2}")

}

