package com.example.photo

data class User (
    var id : Int = 0,
    var login : String = "user",
    //var picture : String = "url",
    var images : MutableList<UserPhoto>? = null) {

}