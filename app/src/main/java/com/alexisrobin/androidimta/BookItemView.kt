package com.alexisrobin.androidimta

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.custom_view_item_book.view.*

/**
 * Created by alexis on 10/11/2017.
 */
class BookItemView: LinearLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun bindView(book: Book) {
        nameTextView.text = book.title
        priceTextView.text = book.price.toString()
    }

}