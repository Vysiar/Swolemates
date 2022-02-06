package com.example.swolemates

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class SwoleViewModel(application: Application): AndroidViewModel(application){
    var user: User = User(1, "",0,"",Gender.OTHER)

}