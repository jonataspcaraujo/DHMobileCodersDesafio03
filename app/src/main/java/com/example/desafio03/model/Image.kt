package com.example.desafio03.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
        val extension: String,
        var path: String?
): Parcelable