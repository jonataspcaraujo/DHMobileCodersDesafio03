package com.example.desafio03.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Events(
        val available: Int,
        val collectionURI: String,
        val returned: Int
): Parcelable
