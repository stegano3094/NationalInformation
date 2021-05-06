package com.stegano.nationalinformation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

data class NationData(val resId: Int, val name: String, val capital: String)

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val img_flag: ImageView = view.findViewById(R.id.img_flag) as ImageView
    val txt_name: TextView = view.findViewById(R.id.txt_name) as TextView
    val txt_capital: TextView = view.findViewById(R.id.txt_capital) as TextView
}

class NationAdapter(val context: Context, val items: List<NationData>) : RecyclerView.Adapter<ViewHolder>() {
    private var onItemClick: View.OnClickListener? = null

    fun setOnItemClickListener(l: View.OnClickListener) {
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mainView: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_nation_list_item, parent, false)
        mainView.setOnClickListener(onItemClick)
        return ViewHolder(mainView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img_flag.setImageResource(items[position].resId)
        holder.txt_capital.text = items[position].capital
        holder.txt_name.text = items[position].name
        holder.txt_name.tag = position
    }

    override fun getItemCount(): Int {
        return items.size
    }
}