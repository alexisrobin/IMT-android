package com.alexisrobin.androidimta


import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by alexis on 16/11/2017.
 */
interface HenriPotierService {

    @GET("books")
    fun books(): Call<List<Book>>

}
