package com.example.anew

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CustomAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var stubContainer: LinearLayout
    private lateinit var fragmentContainer: FrameLayout
 
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.main_recyclerView)
        stubContainer = findViewById(R.id.empty_container)
        fragmentContainer = findViewById(R.id.fragment_container)


//        recyclerView.layoutManager = LinearLayoutManager(this)



        val data = ArrayList<NewItem>()

        for (i in 1..20){
            data.add(NewItem(R.drawable.plant5, "dkcb" + i))
        }

        recyclerView.isVisible = data.isNotEmpty()
        stubContainer.isVisible = data.isEmpty()

        val adapter = CustomAdapter(data, this)

        recyclerView.adapter = adapter

    }

    override fun onItemClick(position: Int) {
        recyclerView.visibility = View.GONE
        val fragment = BlankFragment()
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }
        fragmentContainer.visibility = VISIBLE
    }
}