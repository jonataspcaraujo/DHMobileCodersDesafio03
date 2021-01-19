package com.example.desafio03.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Characters(
        val available: Int,
        val collectionURI: String,
        val items: List<Item>,
        val returned: Int
) : Parcelable
