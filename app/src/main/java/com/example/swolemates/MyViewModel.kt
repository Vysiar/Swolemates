package com.example.swolemates

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var forums = MutableLiveData<ArrayList<Int>>()
    var forumItems: java.util.ArrayList<Int>? = null

    init{
        forums.value = forumItems
        forumItems = java.util.ArrayList<Int>()


    }
}