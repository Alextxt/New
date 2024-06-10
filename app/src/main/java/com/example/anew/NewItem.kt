package com.example.anew

import android.os.Parcel
import android.os.Parcelable

data class NewItem(val image: Int, val title: String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewItem> {
        override fun createFromParcel(parcel: Parcel): NewItem {
            return NewItem(parcel)
        }

        override fun newArray(size: Int): Array<NewItem?> {
            return arrayOfNulls(size)
        }
    }
}
