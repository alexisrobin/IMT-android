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

/**
 * Created by alexis on 16/11/2017.
 */
class BookListFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.book_list_fragment, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val books: ArrayList<Book> = arguments.getParcelableArrayList("books")!!
        bookListView.setLayoutManager(GridLayoutManager(context, 1))
        bookListView.setAdapter(BookAdapter(LayoutInflater.from(context), books))
    }

    interface OnBookClickedListener {
        fun onClick(book: Book?)
    }
}
