package `in`.jayesh.kotlinexample.Sqlite

import `in`.jayesh.kotlinexample.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class InsertActivity : AppCompatActivity() {
    lateinit var save : Button
    lateinit var edtFname : EditText
    lateinit var edtLname : EditText    // its not require define null   like val edtFname : EditText?=null
    lateinit var rg : RadioGroup
    lateinit var rb : RadioButton
    lateinit var spinner: Spinner

    lateinit var  databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        save=findViewById(R.id.btn_save)
        edtFname=findViewById(R.id.edt_fname)
        edtLname=findViewById(R.id.edt_lname)
        rg=findViewById(R.id.rg)
        spinner=findViewById(R.id.spinner_std)
        databaseHelper=DatabaseHelper(this)

        save.setOnClickListener {
            insertFunction()
        }

    }


    private fun insertFunction() {

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        val fname=edtFname.text.toString()
        val lname=edtLname.text.toString()
        val id=rg.checkedRadioButtonId
        rb=findViewById(id)
        val gender=rb.text.toString()
        val std=spinner.selectedItem.toString()

        val user=User()
        user.fname=fname
        user.lname=lname
        user.gender=gender
        user.standard=std
        user.record=currentDate

        val result : Boolean = databaseHelper.onStoreData(user)

        when{
            result->{
                Toast.makeText(this,"Data inserted Successfully..",Toast.LENGTH_LONG).show()
                finish()
            }
            else->Toast.makeText(this,"Failed to insert data",Toast.LENGTH_LONG).show()
        }
    }
}
