package com.example.pharmandroid.Manage

import com.example.pharmandroid.Models.User.User

object UserList {
    var UserList: MutableList<User> = mutableListOf()

    fun add(user: User) {
        UserList.add(user)
    }

    fun removeAll() {
        UserList = mutableListOf()
    }
}