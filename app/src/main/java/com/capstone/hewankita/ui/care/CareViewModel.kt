package com.capstone.hewankita.ui.care

import androidx.lifecycle.ViewModel
import com.capstone.hewankita.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class CareViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth

    fun addCareService(outlet: String, checkIn: String, checkOut: String, timeOA: String, outletEmail: String, outletId: String){

        auth = FirebaseAuth.getInstance()
        val firebaseUser : FirebaseUser? = auth.currentUser
        val userEmail: String? = firebaseUser!!.email

        val database = Firebase.database
        val databaseReference = database.getReference(Constants.TABLE_DATA_SERVICE).child(Constants.CHILD_SERVICE_CARE_SERVICE)
        val key: String = databaseReference.push().key.toString()

        val hashMap = mapOf<String, Any>(
            Constants.CONST_SERVICE_OUTLET to outlet,
            Constants.CONST_SERVICE_CHECK_IN to checkIn,
            Constants.CONST_SERVICE_CHECK_OUT to checkOut,
            Constants.CONST_SERVICE_TIME_OA to timeOA,
            Constants.CONST_USER_EMAIL to userEmail.toString(),
            Constants.CONST_SERVICE_OUTLET_ID to outletId,
            Constants.CONST_SERVICE_OUTLET_EMAIL to outletEmail
        )

        databaseReference.child(key).setValue(hashMap)
    }
}