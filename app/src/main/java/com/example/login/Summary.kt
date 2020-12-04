package com.example.login

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class Summary : Activity() {

    private var firstName: String? = ""
    private var lastName: String? = ""
    private var phone: String? = ""
    private var birthDate: String? = ""
    private var isDegreeCert: String? = ""
    private var degreeCert: String? = ""
    private var class1: String? = ""
    private var selected1: String? = ""
    private var class2: String? = ""
    private var selected2: String? = ""
    private var class3: String? = ""
    private var selected3: String? = ""
    private var class4: String? = ""
    private var selected4: String? = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val extras = intent.extras
        if (extras != null) {
            firstName = extras.getString("FirstName")
            lastName = extras.getString("LastName")
            phone = extras.getString("Phone")
            birthDate = extras.getString("BirthDate")
            isDegreeCert = extras.getString("isDegreeCert")
            degreeCert = extras.getString("degreeCert")
            class1 = extras.getString("Class1")
            selected1 = extras.getString("Selected1")
            class2 = extras.getString("Class2")
            selected2 = extras.getString("Selected2")
            class3 = extras.getString("Class3")
            selected3 = extras.getString("Selected3")
            class4 = extras.getString("Class4")
            selected4 = extras.getString("Selected4")

        }

        val txtStudent = findViewById(R.id.txtStudent) as TextView
        val txtPhone = findViewById(R.id.txtPhone) as TextView
        val txtBirthDate = findViewById(R.id.txtBirthDate) as TextView
        val txtDegreePlan = findViewById(R.id.txtDegree) as TextView
        val txtMajor = findViewById(R.id.txtMajor) as TextView
        val txtClassSchedule = findViewById(R.id.txtClassSchedule) as TextView

        txtStudent.text = "$firstName $lastName"
        txtPhone.text = phone
        txtBirthDate.text = birthDate
        txtDegreePlan.text = isDegreeCert
        txtMajor.text = degreeCert

        val ClassSchedule = StringBuilder(250)
        if (class1 != "") {
            ClassSchedule.append(class1 + "\n" + selected1 + "\n\n")
        }
        if (class2 != "") {
            ClassSchedule.append(class2 + "\n" + selected2 + "\n\n")
        }
        if (class3 != "") {
            ClassSchedule.append(class3 + "\n" + selected3 + "\n\n")
        }
        if (class4 != "") {
            ClassSchedule.append(class4 + "\n" + selected4 + "\n\n")
        }


        txtClassSchedule.text = ClassSchedule


    }
}