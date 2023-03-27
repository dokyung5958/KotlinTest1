package com.example.kotlintest1

//Companion Object -> java static
//정적인 메소드, 정적인 변수

//private constructor : 다른 곳에서는 객체를 생성할 수 없음
class Book private constructor(val id : Int, val name : String){

    companion object BookFactory : IdProvieder{

        val myBook = "new book"

        override fun getId(): Int {
            return  1
        }

        fun create() = Book(getId(), myBook)
    }
}



interface IdProvieder{
    fun getId() : Int
}

fun main(){
    //companion object가 없이는 그냥 생성불가
    //val book = Book()
    //객체생성
    //Companion 생략가능
    //val book = Book.Companion.create()
    val book = Book.create()
    val bookId = Book.BookFactory.getId()
    println("book : ${book.id}, ${book.name}")
}