package br.com.fishtudo.devhub.repository.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var name: String = "",
    var login: String = "",
    var bio: String = "",
    var avatar_url: String = ""
) : Parcelable