package br.com.fishtudo.devhub.network.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser(
    var name: String = "",
    var login: String = "",
    var bio: String = "",
    @SerializedName(value = "avatar_url")
    var avatar: String = ""
) : Parcelable