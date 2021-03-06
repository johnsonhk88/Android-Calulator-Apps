package com.studio.daydream.calculatorexcise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    // Button Number press Event
    fun butNumberEvent(view: View)
    {
        if(isNewOp)
        {
            // clear display value
            edShowNum.setText("")
        }
        isNewOp= false
        val butSelect = view as Button
        var butClickValue : String=  edShowNum.text.toString()   // get display value (number)
        // check button Select
        when(butSelect.id)
        {
            but0.id -> {
                butClickValue += "0"
            }
            but1.id ->{
                butClickValue += "1"
            }
            but2.id ->{
                butClickValue += "2"
            }
            but3.id ->{
                butClickValue += "3"
            }
            but4.id ->{
                butClickValue += "4"
            }
            but5.id ->{
                butClickValue += "5"
            }
            but6.id ->{
                butClickValue += "6"
            }
            but7.id ->{
                butClickValue += "7"
            }
            but8.id ->{
                butClickValue += "8"
            }
            but9.id ->{
                butClickValue += "9"
            }
            butDot.id ->{
                //TODO:  prevent adding more tha 1 dot
                butClickValue += "."
            }
            butPlusMinus.id ->{
                butClickValue = "-" + butClickValue
            }
        }
        edShowNum.setText(butClickValue) // Show number display
    }
    // storge current operation
 var opCode: String = "*"
 var oldValue : String = ""
 var isNewOp : Boolean= true
    // Handle Math operation button Press event
    fun butOpEvent(view:View)
    {
        val butSelect = view as Button
        // check button Select id
        when(butSelect.id) {
            butMul.id -> {
                opCode= "*"  // set mulitple operation
            }
            butDiv.id -> {
                opCode = "/"  // set divide operation
            }
            butSub.id -> {
                opCode = "-"  // set  operation
            }
            butSum.id -> {
                opCode = "+"
            }
        }
        oldValue = edShowNum.text.toString()
        isNewOp =true // clear show value
    }

    //  Equal function button Press Event for calulate the result
    fun butEuqEvent(view: View){
        val newValue: String = edShowNum.text.toString()
        var finalNum: Double? = null
        //
        when(opCode)
        {
            "*"->{
               finalNum= oldValue.toDouble() * newValue.toDouble()
            }
            "/"->{
                finalNum= oldValue.toDouble() / newValue.toDouble()
            }
            "+"->{
                finalNum= oldValue.toDouble() + newValue.toDouble()
            }
            "-"->{
                finalNum= oldValue.toDouble() - newValue.toDouble()
            }

        }
        edShowNum.setText(finalNum.toString())  // Show the final math result
        isNewOp= true
    }

    // Handle Button Precentage Press Event
    fun butPrecentEvent(view:View){
        val number = edShowNum.text.toString().toDouble()/100

        edShowNum.setText(number.toString())
        isNewOp= true // request new operation

    }

    // Handle Clear Button Press Event
    fun butClearEvent(view: View) {
        edShowNum.setText("0")
        isNewOp= true
    }
}
