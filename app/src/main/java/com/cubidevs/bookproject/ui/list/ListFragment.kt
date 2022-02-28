package com.cubidevs.bookproject.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cubidevs.bookproject.databinding.FragmentListBinding
import com.cubidevs.bookproject.local.Book

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var booksAdapter: BooksAdapter
    private  var booksList: ArrayList<Book> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
   }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listViewModel.loadBooksDone.observe(viewLifecycleOwner) { result ->
            onLoadBooksDoneSubscribe(result)
        }

        listViewModel.loadBooks()

        booksAdapter = BooksAdapter(booksList)

        listBinding.booksRecyclerView.apply {

            layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            adapter = booksAdapter
            setHasFixedSize(false)
        }

        listBinding.newButtton.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToNewBookFragment())

        }
    }

    private fun onLoadBooksDoneSubscribe(booksListLoaded: ArrayList<Book>) {
        booksList = booksListLoaded
        booksAdapter.appendItems(booksList)
        //Log.d("Hello","data")

    }

}