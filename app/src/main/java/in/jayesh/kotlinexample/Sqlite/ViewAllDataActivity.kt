package `in`.jayesh.kotlinexample.Sqlite

import `in`.jayesh.kotlinexample.R
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import java.time.LocalDate
import android.view.ContextMenu
import android.view.View


class ViewAllDataActivity : AppCompatActivity() {
    lateinit var databaseHelper: DatabaseHelper
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DataAdapter

    var hashMapArrayList: ArrayList<HashMap<String, String>> = ArrayList()
    var list: List<User>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all_data)
        recyclerView=findViewById(R.id.recycle_view)
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        databaseHelper= DatabaseHelper(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.itemId){
            R.id.insert->{
                val intent=Intent(this,InsertActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        ReadData()
        registerForContextMenu(recyclerView)
        super.onResume()
    }

    private fun ReadData() {
        val list=databaseHelper.user

        hashMapArrayList.clear()
        if (list != null && list.size>0)
        {

            for (user:User in list) {
                val hashMap = HashMap<String,String>()
                hashMap.put(ID, user.id.toString())
                hashMap.put(FNAME, user.fname)
                hashMap.put(LNAME, user.lname)
                hashMap.put(GENDER, user.gender)
                hashMap.put(STANDARD,user.standard)
                hashMap.put(CURRENT_TIME,user.record)
                hashMapArrayList.add(hashMap)
            }
            adapter = DataAdapter(this,hashMapArrayList)
            recyclerView.adapter=adapter
            Log.d("array", hashMapArrayList.toString())
            Toast.makeText(this,"Data Received..",Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(this,"Data not found",Toast.LENGTH_LONG).show()

        }
    }

  /*  override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v!!.id == R.id.recycle_view) {
            menu!!.setHeaderTitle("Set Action")
            menu.add(0, 1, 0, "Update Contact")
            menu.add(0, 2, 0, "Delete Contact")
        }
    }*/

    companion object {
        private val ID = "Id"
        private val FNAME = "FName"
        private val LNAME= "LName"
        private val GENDER = "Gender"
        private val STANDARD="Standard"
        private val CURRENT_TIME="Record"

    }

}
