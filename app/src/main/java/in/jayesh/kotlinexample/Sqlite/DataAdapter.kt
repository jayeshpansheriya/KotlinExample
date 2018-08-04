package `in`.jayesh.kotlinexample.Sqlite

import `in`.jayesh.kotlinexample.R
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.widget.Toast


class DataAdapter(val viewAllDataActivity: ViewAllDataActivity,val arrayList: ArrayList<HashMap<String, String>>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
lateinit var helper : DatabaseHelper
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vi=LayoutInflater.from(viewAllDataActivity).inflate(R.layout.cust_layout,parent,false)
        return ViewHolder(vi)
    }

    override fun getItemCount(): Int {
        return arrayList.size
        Log.d("size",arrayList.size.toString())
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text=arrayList.get(position).get(FNAME)+"  "+arrayList.get(position).get(LNAME)
        holder.gender.text=arrayList.get(position).get(GENDER)
        holder.standard.text=arrayList.get(position).get(STANDARD)
        holder.time.text=arrayList.get(position).get(CURRENT_TIME)
        helper= DatabaseHelper(viewAllDataActivity)
        Log.d("hiiii", arrayList.toString())

        holder.update.setOnClickListener {
            val intent = Intent(viewAllDataActivity, UpdateActivity::class.java)
            intent.putExtra(ID, arrayList.get(position).get(ID))
            intent.putExtra(FNAME,arrayList.get(position).get(FNAME))
            intent.putExtra(LNAME, arrayList.get(position).get(LNAME))
            intent.putExtra(GENDER,arrayList.get(position).get(GENDER))
            intent.putExtra(STANDARD, arrayList.get(position).get(STANDARD))
            intent.putExtra(CURRENT_TIME, arrayList.get(position).get(CURRENT_TIME))
            viewAllDataActivity.startActivity(intent)
        }

        holder.delete.setOnClickListener {
           val result : Boolean = helper.deleteUser(Integer.parseInt(arrayList.get(position).get(ID)))

            when{
                result->{
                    Toast.makeText(viewAllDataActivity,"Data deleted Successfully..", Toast.LENGTH_LONG).show()
                    val intent = Intent(viewAllDataActivity, ViewAllDataActivity::class.java)
                    viewAllDataActivity.startActivity(intent)
                }
                else-> Toast.makeText(viewAllDataActivity,"Failed to delete data", Toast.LENGTH_LONG).show()
            }

        }
    }

    class ViewHolder(item : View) : RecyclerView.ViewHolder(item) {
        val name=item.findViewById<TextView>(R.id.txt_name)
        val gender=item.findViewById<TextView>(R.id.txt_gender)
        val standard=item.findViewById<TextView>(R.id.txt_standard)
        val time=item.findViewById<TextView>(R.id.txt_time)
        val update=item.findViewById<Button>(R.id.btn_update)
        val delete=item.findViewById<Button>(R.id.btn_delete)
    }

    companion object {
        private val ID = "Id"
        private val FNAME = "FName"
        private val LNAME= "LName"
        private val GENDER = "Gender"
        private val STANDARD="Standard"
        private val CURRENT_TIME="Record"

    }
}