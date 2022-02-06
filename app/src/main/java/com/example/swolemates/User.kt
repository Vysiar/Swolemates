package com.example.swolemates

import java.io.Serializable

// General initialization of the data class, will need to create more constructors if needed
data class User(var userId: Int, var name: String, var age: Int, var location: String,
                var gender: Gender) : Serializable{

    // Sets
    var likeSet = mutableSetOf<Int>()
    var hiddenSet = mutableSetOf<Int>()

    // Lists
    var matches = arrayListOf<Int>()

    // Extra Descriptors
    var bio = ""
    var aboutMe = ""
    // Handle photos later
    // var photos = "???"



}