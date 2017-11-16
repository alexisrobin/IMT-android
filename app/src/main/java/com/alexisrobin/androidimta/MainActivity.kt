package com.alexisrobin.androidimta


import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

/**
 * Created by alexis on 16/11/2017.
 */
class MainActivity : AppCompatActivity(), BookListFragment.OnBookClickedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when(resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                setContentView(R.layout.activity_main)
                supportFragmentManager.beginTransaction()
                        .replace(R.id.containerFrameLayout, BookListFragment(), BookListFragment::class.java.simpleName)
                        .commit()
            }
            else -> {
                setContentView(R.layout.activity_main_landscape)
                supportFragmentManager.beginTransaction()
                        .replace(R.id.book_list_fragment, BookListFragment(), BookListFragment::class.java.simpleName)
                        .commit()
                val bookDetailFragment = BookDetailFragment()
                val arguments = Bundle()
                arguments.putBoolean("selected", false)
                bookDetailFragment.arguments = arguments
                supportFragmentManager.beginTransaction()
                        .replace(R.id.book_detail_fragment, bookDetailFragment, BookDetailFragment::class.java.simpleName)
                        .commit()
            }
        }
    }

    override fun onClick(book: Book?) {
        val bookDetailFragment = BookDetailFragment()
        val arguments = Bundle()
        arguments.putParcelable("book", book)
        arguments.putBoolean("selected", true)
        bookDetailFragment.arguments = arguments

        when(resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                supportFragmentManager.beginTransaction()
                        .addToBackStack(BookListFragment::class.java.simpleName)
                        .replace(R.id.containerFrameLayout, bookDetailFragment, BookDetailFragment::class.java.simpleName)
                        .commit()
            }
            else -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.book_detail_fragment, bookDetailFragment, BookDetailFragment::class.java.simpleName)
                        .commit()
            }
        }

    }
}
