package com.capstone.hewankita.ui.bottom.ui.tips

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class TipsViewModel : ViewModel() {

    fun signOut(){
        Firebase.auth.signOut()
    }
}