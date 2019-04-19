package com.example.photo

class PhotoDBProvider {

    var photos : MutableList<UserPhoto> = mutableListOf(
        UserPhoto(url = "url0"),
        UserPhoto(1,"url1"),
        UserPhoto(id = 0, url = "url2")
    )

    fun getPhotosByUserId (userId:Int) : MutableList<UserPhoto>{
        return photos
    }
}