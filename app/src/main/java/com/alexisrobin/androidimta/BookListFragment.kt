package com.alexisrobin.androidimta

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.book_list_fragment.*
import java.util.ArrayList
import RecyclerItemClickListener
import android.os.Parcelable
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by alexis on 16/11/2017.
 */
class BookListFragment(var listener: OnBookClickedListener? = null) : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.listener = context as OnBookClickedListener
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.book_list_fragment, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val henriPotierService = retrofit.create(HenriPotierService::class.java)
        henriPotierService.books().enqueue(object : Callback<List<Book>> {

            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                val books: List<Book> = response.body()!!
                bookListView.layoutManager = GridLayoutManager(context, 1)
                bookListView.adapter = BookAdapter(LayoutInflater.from(context), books)
                bookListView.addOnItemTouchListener(
                        RecyclerItemClickListener(context, object : RecyclerItemClickListener.OnItemClickListener {
                            override fun onItemClick(view: View, position: Int) {
                                listener!!.onClick(books.get(position))
                            }
                        })
                )
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Log.v("TAG", "error")
            }

        })
    }

    interface OnBookClickedListener {
        fun onClick(book: Book?)
    }
}
