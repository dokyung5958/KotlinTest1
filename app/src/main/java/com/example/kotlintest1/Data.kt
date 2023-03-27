package com.example.kotlintest1

import java.util.Date

data class Ticket(val companyName : String, val name : String, var date : String,var seatNumber : Int)
    //toString(), hashCode(), equals(), copy() - data class로 생성했기 때문에 자동 생성됨

class TicketNormal(val companyName : String, val name : String, var date : String,var seatNumber : Int)


fun main(){
    val ticketA = Ticket("KoreanAir", "lee", "2023-03-09", 14)
    val ticketB = TicketNormal("KoreanAir", "lee", "2023-03-09", 14)

    println(ticketA)    //toString때문에 출력문이 다름
    println(ticketB)    //주소값
}