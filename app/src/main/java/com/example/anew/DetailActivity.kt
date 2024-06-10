package com.example.anew

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getParcelableExtra<NewItem>("title")
        if (title != null){
            val textView: TextView = findViewById(R.id.detail_text1)
            val imageView: ImageView = findViewById(R.id.detail_imageView)

            textView.text = title.title
            imageView.setImageResource(title.image)
        }

    }
}