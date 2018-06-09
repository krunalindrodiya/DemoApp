package com.powerise.demoapp.splash.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Krunal on 08-06-2018.
 */
data class AlbumModel(
        val description: String = "",
        val genre: String = "",
        val title: String = "",
        val thumb: String = "") : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
        parcel.writeString(genre)
        parcel.writeString(title)
        parcel.writeString(thumb)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AlbumModel> {
        override fun createFromParcel(parcel: Parcel): AlbumModel {
            return AlbumModel(parcel)
        }

        override fun newArray(size: Int): Array<AlbumModel?> {
            return arrayOfNulls(size)
        }
    }
}