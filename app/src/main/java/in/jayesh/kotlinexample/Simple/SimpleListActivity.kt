package `in`.jayesh.kotlinexample.Simple

import `in`.jayesh.kotlinexample.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast

class SimpleListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simplelist)

        val serchview = findViewById<SearchView>(R.id.searchView) as SearchView

        val listview = findViewById<ListView>(R.id.list_view) as ListView

        val fruits = arrayOf("Apple","Kiwi","Mango","Blueberry")

        val adapter:ArrayAdapter<String> = ArrayAdapter(this@SimpleListActivity,android.R.layout.simple_list_item_1,fruits)

        listview.adapter=adapter

        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this@SimpleListActivity,"$id"+fruits[position],Toast.LENGTH_LONG).show()
        }

        serchview.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                adapter.filter.filter(newText)
                return false
            }

        })

    }
}
