package com.example.anew

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var stubContainer: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.main_recyclerView)
        stubContainer = findViewById(R.id.main_container)
        recyclerView.layoutManager = LinearLayoutManager(this)



        val data = ArrayList<NewItem>()

        for (i in 1..20){
            data.add(NewItem(R.drawable.plant5, "dkcb" + i))
        }

        if (data.isEmpty()){
            recyclerView.visibility = INVISIBLE
            stubContainer.visibility = VISIBLE
        } else {
            recyclerView.visibility = VISIBLE
            stubContainer.visibility = INVISIBLE
        }

        val adapter = CustomAdapter(data)

        recyclerView.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("title", it)
            startActivity(intent)
        }



    }
}