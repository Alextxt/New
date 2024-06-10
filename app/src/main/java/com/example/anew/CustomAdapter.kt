package com.example.anew


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent

class CustomAdapter(private val mList: List<NewItem>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    var onItemClick: ((NewItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(mList[position].image)
        holder.title.text = mList[position].title
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(mList[position])

        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.item_im)
        val title: TextView = itemView.findViewById(R.id.item_title)

    }


}