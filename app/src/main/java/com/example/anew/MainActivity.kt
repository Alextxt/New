package com.example.anew

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.anew.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateToFragment(MainFragment(), false)
    }

    // метод для управления фрагментами, навигацией между фрагментами
    fun navigateToFragment(fragment: Fragment, isAddToBackStack: Boolean = true) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container, fragment)

    // добавлене фрагмента в BackStack, если true, то при нажатии назад мы возратимся на предыдущий фрагмент
    // если false, то не возратимся на предыдущий фрагмент, потому что, фрагмент не добавится  в BackStack
            if (isAddToBackStack)
                addToBackStack(fragment.javaClass.simpleName)
        }
    }
}