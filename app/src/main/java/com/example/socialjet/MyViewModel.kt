package com.example.socialjet

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    val auth : FirebaseAuth,
    val storage : FirebaseStorage,
    val db : FirebaseFirestore
) : ViewModel() {

}