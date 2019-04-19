package com.example.photo

import io.realm.RealmObject

open class UserRealm : RealmObject() {

    var id : Int = 0
    var login : String = "user"
    //var picture : String = "url",
    var images : MutableList<UserPhoto>? = null
}