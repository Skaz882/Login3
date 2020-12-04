package com.example.login

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainClassList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_class_list)

        val swDegreeCert = findViewById(R.id.idswDegreeCert) as Switch
        val spnDegree = findViewById(R.id.idspnDegree) as Spinner
        val spnCertificate = findViewById(R.id.idspnCertificate) as Spinner
        val txtCertificate = findViewById(R.id.idlblCertificate) as TextView
        val txtDegree = findViewById(R.id.idlblDegree) as TextView
        val btnNext = findViewById(R.id.idbtnNext) as Button

        val firstName = findViewById(R.id.idtxtFirstName) as EditText
        val lastName = findViewById(R.id.idtxtLastName) as EditText
        val phone = findViewById(R.id.idtxtPhone) as EditText

        val spMonth = findViewById(R.id.idspnMonth) as Spinner
        val txtDay = findViewById(R.id.idtxtDay) as TextView
        val txtYear = findViewById(R.id.idtxtYear) as TextView

        firstName.requestFocus()

        swDegreeCert.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                spnDegree.visibility = VISIBLE
                txtDegree.visibility = VISIBLE
                spnCertificate.visibility = GONE
                txtCertificate.visibility = GONE
            } else {
                spnDegree.visibility = GONE
                txtDegree.visibility = GONE
                spnCertificate.visibility = VISIBLE
                txtCertificate.visibility = VISIBLE
            }
        }

        btnNext.setOnClickListener {
            if (checkData()) {
                val doBirth: String
                doBirth = spMonth.selectedItem.toString() + "/" + txtDay.text.toString() + "/" + txtYear.text.toString()

                val nextScreen = Intent(this@MainClassList, ChooseClass::class.java)
                nextScreen.putExtra("FirstName", firstName.text.toString())
                nextScreen.putExtra("LastName", lastName.text.toString())
                nextScreen.putExtra("Phone", phone.text.toString())
                nextScreen.putExtra("BirthDate", doBirth)

                if (spnDegree.visibility == VISIBLE) {
                    nextScreen.putExtra("isDegreeCert", "Degree")
                    nextScreen.putExtra("degreeCert", spnDegree.selectedItem.toString())

                } else {
                    nextScreen.putExtra("isDegreeCert", "Certificate")
                    nextScreen.putExtra("degreeCert", spnCertificate.selectedItem.toString())
                }

                startActivity(nextScreen)
            }
        }
    }
    private fun checkData(): Boolean {
        val firstName = findViewById(R.id.idtxtFirstName) as EditText
        val lastName = findViewById(R.id.idtxtLastName) as EditText
        val phone = findViewById(R.id.idtxtPhone) as EditText
        val txtDay = findViewById(R.id.idtxtDay) as TextView
        val txtYear = findViewById(R.id.idtxtYear) as TextView


        if (firstName.text.toString().isEmpty()) {

            firstName.error = "Invalid First Name"
            firstName.requestFocus()
            return false
        }

        if (lastName.text.toString().isEmpty()) {
            lastName.error = "Invalid Last Name"
            lastName.requestFocus()
            return false
        }

        if (phone.text.toString().isEmpty()) {
            phone.error = "Invalid Phone Number"
            phone.requestFocus()
            return false
        }

        if (txtDay.text.toString().isEmpty()) {
            txtDay.error = "Invalid Date Selection"
            txtDay.requestFocus()
            return false
        }
        if (txtYear.text.toString().isEmpty()) {
            txtYear.error = "Invalid Date Selection"
            txtYear.requestFocus()
            return false
        }

        return true
    }
}