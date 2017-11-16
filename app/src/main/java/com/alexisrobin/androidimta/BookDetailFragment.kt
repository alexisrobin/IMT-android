package com.alexisrobin.androidimta

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.book_detail_fragment.*
import kotlinx.android.synthetic.main.custom_view_item_book.view.*

/**
 * Created by alexis on 16/11/2017.
 */
class BookDetailFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.book_detail_fragment, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val book: Book = arguments.getParcelable("book")!!
        titleTextView.text = book.title
        Glide.with(context)
                .load(book.cover)
                .into(coverImageView);
    }
}