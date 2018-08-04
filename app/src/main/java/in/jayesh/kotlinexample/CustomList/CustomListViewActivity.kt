package `in`.jayesh.kotlinexample.CustomList

import `in`.jayesh.kotlinexample.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class CustomListViewActivity : AppCompatActivity() {
    var custadapter:CustomAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view)

        val listView=findViewById<ListView>(R.id.list);
        val images= arrayOf(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background)
        val fruite= arrayOf("Mango","Banana","Apple")

        custadapter=CustomAdapter(this,images,fruite)
        listView.adapter=custadapter

        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,""+fruite[position],Toast.LENGTH_LONG).show()
        }
    }



}
