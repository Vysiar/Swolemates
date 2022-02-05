package com.example.swolemates

data class Preference(var minExperience: Int, var maxExperience: Int, var individual: Boolean,
var group: Boolean, var minAge: Int, var maxAge: Int) {

    var activity = Activities

    var genderSet = mutableSetOf<Gender>()


}
