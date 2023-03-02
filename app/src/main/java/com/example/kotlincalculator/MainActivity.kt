package com.example.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var NewOp = true
    var oldNumber = ""
    var op = "+"
    var result = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberAction(view: View) {
       if (NewOp)
           editText.setText("")
        NewOp = false
        var buclick :String = editText.text.toString()
        val buselect: Button =  view as Button
        when (buselect.id)
        {
          bu1.id -> {buclick += "1"}
          bu2.id -> {buclick += "2"}
          bu3.id -> {buclick += "3"}
          bu4.id -> {buclick += "4"}
          bu5.id -> {buclick += "5"}
          bu6.id -> {buclick += "6"}
          bu7.id -> {buclick += "7"}
          bu8.id -> {buclick += "8"}
          bu9.id -> {buclick += "9"}
          bu0.id -> {buclick += "0"}
          buDot.id -> {buclick += "."}
        }
        editText.setText(buclick)

    }
    fun operationAction(view: View) {
      NewOp = true
        oldNumber = editText.text.toString()
        var  buselect: Button = view as Button

        when(buselect.id)
        {
            Divide.id -> {op = "/"}
            Multiply.id -> {op = "*"}
            Minus.id -> {op = "-"}
            Sum.id -> {op = "+"}
        }
        editText.setText(op)


    }
    fun equalsAction(view: View) {
        var newnumber : String = editText.text.toString()

        when (op){
            "+" -> {result = oldNumber.toDouble() + newnumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newnumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newnumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newnumber.toDouble()}
        }

        editText.setText(result.toString())
    }
    fun allClearAction(view: View) {
       editText.setText("0")
        NewOp = true
    }
    fun backSpaceAction(view: View) {
        var length = editText.length()
        if (length > 0) {
            editText.text = editText.text.substring(0, length - 1)
        }
    }

    fun Result(view: View) {



    }
}