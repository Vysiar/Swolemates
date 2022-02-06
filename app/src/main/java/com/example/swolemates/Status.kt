package com.example.swolemates

enum class StatusNumber(val num: Int) {
    NONE(0), LIKED(1), HIDDEN(2)
}

data class Status(var user: User, var currStatus: StatusNumber)

