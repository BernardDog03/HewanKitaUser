package com.capstone.hewankita.ui.bottom.ui.home

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeViewModel : ViewModel() {

    fun signOut(){
        Firebase.auth.signOut()
    }
}