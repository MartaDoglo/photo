package com.example.photo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class PhotoRealm : RealmObject() {

    @PrimaryKey
    var id : Int =0
    var url : String? = null

}