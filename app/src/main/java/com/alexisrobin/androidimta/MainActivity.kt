package com.alexisrobin.androidimta


import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val henriPotierService = retrofit.create(HenriPotierService::class.java)

        henriPotierService.books().enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {

                val bookListFragment = BookListFragment()
                val arguments = Bundle()
                arguments.putParcelableArrayList("books", response.body() as ArrayList<out Parcelable>?)
                bookListFragment.arguments = arguments
                supportFragmentManager.beginTransaction()
                        .replace(R.id.containerFrameLayout, bookListFragment, BookListFragment::class.java.simpleName)
                        .commit()
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {

            }
        })

    }
}
