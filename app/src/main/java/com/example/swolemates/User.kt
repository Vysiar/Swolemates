package com.example.swolemates

import java.io.Serializable

// General initialization of the data class, will need to create more constructors if needed
data class User(var userId: Int, var name: String, var age: Int, var location: String,
                var gender: Gender, var liked: Boolean, var matched: Boolean) : Serializable{

    // Sets
    var likeSet = mutableSetOf<Int>()
    var hiddenSet = mutableSetOf<Int>()

    // Lists
    var matches = arrayListOf<Int>()
    var interests = arrayListOf<Interest>(Interest(ACTIVITY.TENNIS,-1))

    // Extra Descriptors
    var bio = ""
    var aboutMe = ""
    // Handle photos later
    // var photos = "???"



}