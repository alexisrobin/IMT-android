package com.alexisrobin.androidimta

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by alexis on 16/11/2017.
 */
data class Book(val isbn: String? = null,
                val title: String? = null,
                val price: Int? = null,
                val cover: String? = null,
                val synopsis: List<String>? = null) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.createStringArrayList()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(isbn)
        parcel.writeString(title)
        parcel.writeValue(price)
        parcel.writeString(cover)
        parcel.writeStringList(synopsis)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }


}