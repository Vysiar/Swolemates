package com.example.swolemates

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class SwoleViewModel(application: Application): AndroidViewModel(application) {
    var user: User = User(1, "", 0, "", Gender.OTHER, true, true)
    var otherUsers: MutableList<User> = mutableListOf(
        User(111111, "Donald Pump", 24, "Blacksburg", Gender.MALE, true, false),
        User(333333, "Debby Deadlifts", 24, "Blacksburg", Gender.FEMALE, true, false),
        User(444444, "Felicity Flash", 23, "Blacksburg", Gender.FEMALE,true, false),
        User(555555, "Lady Macbuff", 20, "Blacksburg", Gender.FEMALE, false, false),
        User(666666, "Marcus Max", 21, "Blacksburg", Gender.MALE, true, false),
        User(777777, "Nicole Nutrition", 21, "Blacksburg", Gender.FEMALE, false, false),
        User(888888, "Alisa Arm Circles", 22, "Blacksburg", Gender.FEMALE, true, false),
        User(999999, "Fast Franco", 20, "Blacksburg", Gender.MALE, true, false)

    )
}
