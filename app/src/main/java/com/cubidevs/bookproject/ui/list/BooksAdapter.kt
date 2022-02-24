package com.cubidevs.bookproject.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cubidevs.bookproject.R
import com.cubidevs.bookproject.model.Book
import java.util.ArrayList

class BooksAdapter (
    private val bookslist: ArrayList <Book>

): RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        valview = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_book, parent, false)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }

    class BookViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    }

}