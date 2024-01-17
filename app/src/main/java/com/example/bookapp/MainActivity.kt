package com.example.bookapp

import BookAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        // Use a GridLayoutManager with 2 columns
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        bookAdapter = BookAdapter(this)
        recyclerView.adapter = bookAdapter

        fetchData()
    }
    private fun fetchData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.api.getBooks()
                withContext(Dispatchers.Main) {
                    if (response.isNotEmpty()) {
                        bookAdapter.setData(response)
                    } else {
                        Toast.makeText(this@MainActivity, "no book", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                // Handle network errors or API call failures
                e.printStackTrace()
            }
        }
    }

}