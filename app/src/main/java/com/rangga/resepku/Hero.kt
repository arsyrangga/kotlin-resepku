package com.rangga.resepku

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val description: String,
    val photo: String,
    val bahan: String,
    val masak: String
): Parcelable
