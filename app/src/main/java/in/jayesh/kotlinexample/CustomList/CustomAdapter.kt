package `in`.jayesh.kotlinexample.CustomList

import `in`.jayesh.kotlinexample.R
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(private val customListViewActivity: CustomListViewActivity,val images: Array<Int>,val fruite: Array<String>): BaseAdapter() {
  //  val images: Array<Int> = images   // in constructor apply val then this one is not mandatory
  //  val fruite: Array<String> = fruite

   /* init {
        this.images=images as Array<Int>

       // also as consructor
    }*/


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
     val vi: View =View.inflate(customListViewActivity, R.layout.custom_layout,null)
        val image=vi.findViewById<ImageView>(R.id.image_view)
        val text=vi.findViewById<TextView>(R.id.text)

        image.setImageResource(images[position])
        text.setText(fruite[position])

      //  text.text=fruite[position]  also apply
      return  vi
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItem(position: Int): Any {
       return position//TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {
     return position.toLong() // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        return images.size//TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}