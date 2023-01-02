package com.capstone.hewankita.ui.vaccination

import androidx.lifecycle.ViewModel
import com.capstone.hewankita.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class VaccinationViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth

    fun addVaccinationService(outlet: String, bookingDate: String, bookingTime: String, outletEmail: String, outletId: String){
        auth = FirebaseAuth.getInstance()

        val firebaseUser: FirebaseUser? = auth.currentUser
        val userEmail : String? = firebaseUser?.email

        val database = Firebase.database
        val databaseReference = database.getReference(Constants.TABLE_DATA_SERVICE).child(Constants.CHILD_SERVICE_VACCINATION_SERVICE)
        val key : String = databaseReference.push().key.toString()

        val hashMap = mapOf<String, Any>(
            Constants.CONST_SERVICE_OUTLET to outlet,
            Constants.CONST_SERVICE_DATE to bookingDate,
            Constants.CONST_SERVICE_TIME to bookingTime,
            Constants.CONST_USER_EMAIL to userEmail.toString(),
            Constants.CONST_SERVICE_OUTLET_ID to outletId,
            Constants.CONST_SERVICE_OUTLET_EMAIL to outletEmail
        )

        databaseReference.child(key).setValue(hashMap)
    }
}