package com.example.testpratiqueapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testpratiqueapplication.ui.AppModel
import com.example.testpratiqueapplication.ui.adapters.ListAppAdapter
import com.example.testpratiqueapplication.ui.listOfApps
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Fresco.initialize(this)

        _filterGenreButton.setOnClickListener {
            val sortedListGenre = listOfApps.sortedWith(compareBy { it.genre })
            Log.d("Debug1", sortedListGenre.toString())
        }

        _filterDateButton.setOnClickListener {
            val sortedListDate = listOfApps.sortedWith(compareBy { it.anneeSortie })
            Log.e("Debug2", sortedListDate.toString())
        }

        _listAppRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ListAppAdapter(listOfApps)
        }

        listOfApps.forEach { app ->
            Log.d("Debug", app.toString())
        }
    }


}
