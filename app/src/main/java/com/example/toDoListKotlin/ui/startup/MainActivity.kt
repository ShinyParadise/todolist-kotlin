package com.example.toDoListKotlin.ui.startup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.toDoListKotlin.R
import com.example.toDoListKotlin.ui.listScreen.ListsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listsFragment = ListsFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, listsFragment)
            .commit()
    }
}
