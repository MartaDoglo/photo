package com.example.photo

import io.realm.RealmList

fun Photo.mapToRealm():PhotoRealm {
    val photoRealm = PhotoRealm()
    photoRealm.id = this.id
    photoRealm.url = this.url
    return photoRealm
}

fun PhotoRealm.mapToData () = UserPhoto (this.id, this.url)

fun MutableList<UserPhoto>.mapToRealmList (){
    val l : RealmList<UserRealm>
    l.forEach {
        l.add(it.mapToRealm())
    }
}