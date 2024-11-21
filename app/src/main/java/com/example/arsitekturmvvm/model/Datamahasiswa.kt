package com.example.arsitekturmvvm.model

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.core.app.GrammaticalInflectionManagerCompat.GrammaticalGender

data class Datamahasiswa(
    val nama:String = "",
    val NIM : String = "",
    val email: String= "",
    val gender: String = "",
    val alamat:String= "",
)
