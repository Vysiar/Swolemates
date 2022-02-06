package com.example.swolemates

import android.app.Activity


data class Preference(var minExperience: Int, var maxExperience: Int, var individual: Boolean,
                      var group: Boolean, var minAge: Int, var maxAge: Int,
                      var activity: ACTIVITY) {

    var genderSet = mutableSetOf<Gender>()

}
