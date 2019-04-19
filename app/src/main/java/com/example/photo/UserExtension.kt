package com.example.photo

fun User.mapToRealm() : UserRealm {
    val userRealm = UserRealm()
    userRealm.id = this.id
    userRealm.login = this.login
    return userRealm
}

fun UserRealm.mapToData() = User (this.id, this.login)
