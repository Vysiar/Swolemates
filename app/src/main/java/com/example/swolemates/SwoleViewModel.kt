package com.example.swolemates

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class SwoleViewModel(application: Application): AndroidViewModel(application){
    var user: User = User(1, "",0,"",Gender.OTHER)
    var otherUsers:MutableList<User> = mutableListOf(
        User(111111, "Donald Pump", 24, "Blacksburg", Gender.MALE),
        User(222222, "Ben Bulkenson",21, "Blacksburg", Gender.MALE),
        User(333333, "Debby Deadlifts",20, "Blacksburg", Gender.FEMALE),
        User(444444, "Felicity Flash",23, "Blacksburg", Gender.FEMALE),
        User(555555, "Lady Macbuff",20, "Blacksburg", Gender.FEMALE)
    )


//    private fun initArray(myDataset: MutableList<User>){
//        myDataset.clear()
//
//        myDataset.add(User(111111, "Donald Pump", 24, "Blacksburg", Gender.MALE))
//        myDataset.add(User(222222, "Ben Bulkenson",21, "Blacksburg", Gender.MALE))
//        myDataset.add(User(333333, "Debby Deadlifts",20, "Blacksburg", Gender.FEMALE))
//        myDataset.add(User(444444, "Felicity Flash",23, "Blacksburg", Gender.FEMALE))
//        myDataset.add(User(555555, "Lady Macbuff",20, "Blacksburg", Gender.FEMALE))
//    }

}