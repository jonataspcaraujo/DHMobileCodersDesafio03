package com.example.desafio03.model

import android.os.Parcelable
import android.provider.ContactsContract
import kotlinx.parcelize.Parcelize

@Parcelize
data class HqItem(
        val attributionHTML: String?,
        val attributionText: String?,
        val code: Int?,
        val copyright: String?,
        val data: Data?,
        val etag: String?,
        val status: String?
) : Parcelable
