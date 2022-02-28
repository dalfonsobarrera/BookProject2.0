package com.cubidevs.bookproject.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao

interface BookDao {

    @Insert
    suspend fun saveBook ( book: Book)

    @Query("SELECT * FROM table_books WHERE name LIKE :nameBook")
    suspend fun searchBook (nameBook:String): Book

    @Delete
    suspend fun deleteBook(book: Book)

    @Query ("SELECT * FROM table_books")
    suspend fun loadBooks(): MutableList<Book>


}