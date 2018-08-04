package `in`.jayesh.kotlinexample.RecycleView

import `in`.jayesh.kotlinexample.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView=findViewById<RecyclerView>(R.id.recycle_view) as RecyclerView

        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val arrayList= ArrayList<String>()
        //val animals: ArrayList<String> = ArrayList()    another types
        val images= arrayOf(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background)
        val fruite= arrayOf("Mango","Banana","Apple")

        recyclerView.adapter=FruiteAdapter(this,images,fruite)
    }
}
