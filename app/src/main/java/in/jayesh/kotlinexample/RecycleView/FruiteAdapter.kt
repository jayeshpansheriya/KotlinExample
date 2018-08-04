package `in`.jayesh.kotlinexample.RecycleView

import `in`.jayesh.kotlinexample.R
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class FruiteAdapter(val mainActivity: MainActivity,val images: Array<Int>,val fruite: Array<String>): RecyclerView.Adapter<FruiteAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(mainActivity).inflate(R.layout.custom_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return fruite.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.textView?.text=fruite[position]
        holder?.image?.setImageResource(images[position])
    }

    class ViewHolder(itemview : View): RecyclerView.ViewHolder(itemview){
        val textView = itemView.findViewById<TextView>(R.id.text) as TextView
        val image=itemview.findViewById<ImageView>(R.id.image_view) as ImageView
    }
}

