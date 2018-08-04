package `in`.jayesh.kotlinexample.Sqlite

import `in`.jayesh.kotlinexample.R
import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import junit.runner.Version.id
import java.text.SimpleDateFormat
import java.util.*



class UpdateActivity : AppCompatActivity() {
    lateinit var update : Button
    lateinit var edtFname : EditText
    lateinit var edtLname : EditText    // its not require define null   like val edtFname : EditText?=null
    lateinit var rg : RadioGroup
    lateinit var rb : RadioButton
    lateinit var rb_male : RadioButton
    lateinit var rb_female : RadioButton
    lateinit var spinner: Spinner

    lateinit var  databaseHelper: DatabaseHelper

    var id: String = ""
    var fname: String = ""
    var lname: String = ""
    var gender: String = ""
    var standard: String = ""


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        update=findViewById(R.id.btn_update)
        edtFname=findViewById(R.id.edt_fname)
        edtLname=findViewById(R.id.edt_lname)
        rg=findViewById(R.id.rg)
        spinner=findViewById(R.id.spinner_std)
        rb_male=findViewById(R.id.rb_male)
        rb_female=findViewById(R.id.rb_female)

        databaseHelper=DatabaseHelper(this)

        edtFname.setText(intent.getStringExtra(FNAME).toString())
        id=intent.getStringExtra(ID)
        edtLname.setText(intent.getStringExtra(LNAME))

        gender=intent.getStringExtra(GENDER)
        if (gender.equals("Male"))
        {
            rb_male.isChecked=true
        }else
        {
            rb_female.isChecked=true
        }
        standard=intent.getStringExtra(STANDARD)

        val testArray = resources.getStringArray(R.array.standard)

        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,testArray)
        spinner.adapter=adapter
        if(standard!=null) {
            val spinnerPosition = adapter.getPosition(standard)
            spinner.setSelection(spinnerPosition)
        }
        update.setOnClickListener {
            UpdateData()
        }
    }

    private fun UpdateData() {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        fname=edtFname.text.toString()
        lname=edtLname.text.toString()
        val rb_id=rg.checkedRadioButtonId
        rb=findViewById(rb_id)
        gender=rb.text.toString()
        standard=spinner.selectedItem.toString()

        val user=User()
        user.id=Integer.parseInt(id)
        user.fname=fname
        user.lname=lname
        user.gender=gender
        user.standard=standard
        user.record=currentDate

        val result : Boolean = databaseHelper.updateUser(user)

        when{
            result->{
                Toast.makeText(this,"Data Updated Successfully..",Toast.LENGTH_LONG).show()
                finish()
            }
            else->Toast.makeText(this,"Failed to update data",Toast.LENGTH_LONG).show()
        }

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
