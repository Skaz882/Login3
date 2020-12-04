package com.example.login

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.*


class ChooseClass : Activity() {

    private var firstName: String? = ""
    private var lastname: String? = ""
    private var phone: String? = ""
    private var birthDate: String? = ""
    private var isDegreeCert: String? = ""
    private var degreeCertification: String? = ""

    private var ctv1: CheckedTextView? = null
    private var ctv2: CheckedTextView? = null
    private var ctv3: CheckedTextView? = null
    private var ctv4: CheckedTextView? = null

    private var rb1: RadioButton? = null
    private var rb2: RadioButton? = null
    private var rb3: RadioButton? = null
    private var rb4: RadioButton? = null
    private var rb5: RadioButton? = null
    private var rb6: RadioButton? = null
    private var rb7: RadioButton? = null
    private var rb8: RadioButton? = null

    private var rg1: RadioGroup? = null
    private var rg2: RadioGroup? = null
    private var rg3: RadioGroup? = null
    private var rg4: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_class)

        ctv1 = findViewById<CheckedTextView>(R.id.ctv1)
        ctv2 = findViewById<CheckedTextView>(R.id.ctv2)
        ctv3 = findViewById<CheckedTextView>(R.id.ctv3)
        ctv4 = findViewById<CheckedTextView>(R.id.ctv4)

        rb1 = findViewById<RadioButton>(R.id.rb1)
        rb2 = findViewById<RadioButton>(R.id.rb2)
        rb3 = findViewById<RadioButton>(R.id.rb3)
        rb4 = findViewById<RadioButton>(R.id.rb4)
        rb5 = findViewById<RadioButton>(R.id.rb5)
        rb6 = findViewById<RadioButton>(R.id.rb6)
        rb7 = findViewById<RadioButton>(R.id.rb7)
        rb8 = findViewById<RadioButton>(R.id.rb8)

        val btnNext = findViewById<Button>(R.id.btnNext)

        val extras = intent.extras
        if (extras != null) {
            firstName = extras.getString("FirstName")
            lastname = extras.getString("LastName")
            phone = extras.getString("Phone")
            birthDate = extras.getString("BirthDate")
            isDegreeCert = extras.getString("isDegreeCert")
            degreeCertification = extras.getString("degreeCert")
        }

        btnNext.setOnClickListener {
            var radioButton: RadioButton

            var ctv1Text = ""
            var ctv2Text = ""
            var ctv3Text = ""
            var ctv4Text = ""

            var radio1Text = ""
            var radio2Text = ""
            var radio3Text = ""
            var radio4Text = ""

            rg1 = findViewById<RadioGroup>(R.id.radioGroup)
            rg2 = findViewById<RadioGroup>(R.id.radioGroup2)
            rg3 = findViewById<RadioGroup>(R.id.radioGroup3)
            rg4 = findViewById<RadioGroup>(R.id.radioGroup4)
            var selectedTime1 = 0
            var selectedTime2 = 0
            var selectedTime3 = 0
            var selectedTime4 = 0


            if (ctv1!!.isChecked) {
                ctv1Text = ctv1!!.text.toString()
                selectedTime1 = rg1!!.checkedRadioButtonId
                radioButton = findViewById<RadioButton>(selectedTime1)
                radio1Text = radioButton.text.toString()

            }

            if (ctv2!!.isChecked) {
                ctv2Text = ctv2!!.text.toString()
                selectedTime2 = rg2!!.checkedRadioButtonId
                radioButton = findViewById<RadioButton>(selectedTime2)
                radio2Text = radioButton.text.toString()

            }
            if (ctv3!!.isChecked) {
                ctv3Text = ctv3!!.text.toString()
                selectedTime3 = rg3!!.checkedRadioButtonId
                radioButton = findViewById<RadioButton>(selectedTime3)
                radio3Text = radioButton.text.toString()

            }
            if (ctv4!!.isChecked) {
                ctv4Text = ctv4!!.text.toString()
                selectedTime4 = rg4!!.checkedRadioButtonId
                radioButton = findViewById<RadioButton>(selectedTime4)
                radio4Text = radioButton.text.toString()

            }

            if (radioCheck(selectedTime1, selectedTime2, selectedTime3, selectedTime4)) {
                val nextScreen2 = Intent(this@ChooseClass, Summary::class.java).apply {
                    putExtra("FirstName", firstName)
                    putExtra("LastName", lastname)
                    putExtra("Phone", phone)
                    putExtra("BirthDate", birthDate)
                    putExtra("isDegreeCert", isDegreeCert)
                    putExtra("Class1", ctv1Text)
                    putExtra("Selected1", radio1Text)
                    putExtra("Class2", ctv2Text)
                    putExtra("Selected2", radio2Text)
                    putExtra("Class3", ctv3Text)
                    putExtra("Selected3", radio3Text)
                    putExtra("Class4", ctv4Text)
                    putExtra("Selected4", radio4Text)
                    putExtra("degreeCert", degreeCertification)
                }


                //Start the activity
                startActivity(nextScreen2)
            } else {
                Toast.makeText(applicationContext, "Timeslot conflict.", Toast.LENGTH_SHORT).show()
            }
        }

        rb1!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }

        rb2!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }

        rb3!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb4!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb5!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb6!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb7!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb8!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }


        ctv1!!.setOnClickListener {
            if (ctv1!!.isChecked)
                enableDisable(ctv1, rb1, rb2, Color.WHITE, false)
            else
                enableDisable(ctv1, rb1, rb2, Color.GRAY, true)
        }

        ctv2!!.setOnClickListener {
            if (ctv2!!.isChecked)
                enableDisable(ctv2, rb3, rb4, Color.WHITE, false)
            else
                enableDisable(ctv2, rb3, rb4, Color.GRAY, true)
        }

        ctv3!!.setOnClickListener {
            if (ctv3!!.isChecked)
                enableDisable(ctv3, rb5, rb6, Color.WHITE, false)
            else
                enableDisable(ctv3, rb5, rb6, Color.GRAY, true)
        }
        ctv4!!.setOnClickListener {
            if (ctv4!!.isChecked)
                enableDisable(ctv4, rb7, rb8, Color.WHITE, false)
            else
                enableDisable(ctv4, rb7, rb8, Color.GRAY, true)
        }
    }


    fun enableDisable(ctv: CheckedTextView?, rb1: RadioButton?, rb2: RadioButton?, bgColor: Int?, state: Boolean?) {
        ctv!!.isChecked = state!!
        ctv.setBackgroundColor(bgColor!!)
        rb1!!.isEnabled = state
        rb2!!.isEnabled = state

        rb1.isChecked = state

        if (!state) {
            rb1.isChecked = state
            rb2.isChecked = state
        }

    }

    fun radioCheck(selectedTime1: Int, selectedTime2: Int, selectedTime3: Int, selectedTime4: Int): Boolean {

        if (selectedTime1 == R.id.rb2 && selectedTime4 == R.id.rb7) {
            rb2!!.error = "Timeslot conflict."
            rb7!!.error = "Timeslot conflict."
            return false
        }

        if (selectedTime1 == R.id.rb1 && selectedTime2 == R.id.rb3) {
            rb1!!.error = "Timeslot conflict."
            rb3!!.error = "Timeslot conflict."
            return false
        }
        if (selectedTime3 == R.id.rb5 && selectedTime4 == R.id.rb8) {
            rb5!!.error = "Timeslot conflict."
            rb8!!.error = "Timeslot conflict."
            return false
        }




        return true
    }

}