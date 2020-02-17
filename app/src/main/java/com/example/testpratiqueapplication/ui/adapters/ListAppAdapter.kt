package com.example.testpratiqueapplication.ui.adapters

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.testpratiqueapplication.R
import com.example.testpratiqueapplication.ui.AppModel
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListAppAdapter(private val listApp: List<AppModel>) :
    RecyclerView.Adapter<ListAppAdapter.ListAppHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAppHolder =
        ListAppHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_list,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = listApp.size

    override fun onBindViewHolder(holder: ListAppHolder, position: Int) {
        holder.bindView(listApp[position])
    }

    class ListAppHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(listApp: AppModel) {
            view._nameApp.text = listApp.nom
            view._genreApp.text = listApp.genre
            view._releaseDateApp.text = listApp.anneeSortie.toString()
            val draweeView = view._imageApp as SimpleDraweeView
            draweeView.setImageURI(listApp.imageUrl)

        }
    }
}