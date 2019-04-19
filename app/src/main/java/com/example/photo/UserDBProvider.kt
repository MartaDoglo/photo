package com.example.photo

import android.content.Context

class UserDBProvider {

    lateinit var userList: MutableList<User>
    val photoDBProvider : PhotoDBProvider

    init {
        photoDBProvider = PhotoDBProvider()
    }
    fun initConnection (context : Context){
        userList = mutableListOf(
            User (1, "John1", photoDBProvider.getPhotosByUserId(1)),
            User (2, "John2", photoDBProvider.getPhotosByUserId(2)),
            User (3, "John3", photoDBProvider.getPhotosByUserId(3))
        )
    }

    fun GetAllUsers() = userList
}