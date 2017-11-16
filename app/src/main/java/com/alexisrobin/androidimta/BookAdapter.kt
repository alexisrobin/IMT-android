package com.alexisrobin.androidimta

/**
 * Created by alexis on 16/11/2017.
 */
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View

/**
 * Created by alexis on 10/11/2017.
 */

class BookAdapter(val inflater: LayoutInflater, val books: List<Book>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val itemView = holder?.itemView
        return when(itemView) {
            is BookItemView -> itemView.bindView(books.get(position))
            else -> {}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder =
            MyViewHolder(inflater.inflate(R.layout.custom_view_item_book, parent, false));

    override fun getItemCount(): Int = books.size

    class MyViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView)

}