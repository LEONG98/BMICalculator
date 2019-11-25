package com.example.bmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener(){
            calculateBMI()
        }

        btnReset.setOnClickListener(){
            reset()
        }
    }

    private fun calculateBMI(){
        try {
        val weight:Double = txtWeight.text.toString().toDouble()
        val height:Double = txtHeight.text.toString().toDouble()

            val value:Double = weight / (height * height)
            val BMI:String

            if(value <= 18.5){
                txtBMI.text = "(Underweight)"
                imgBMI.setImageResource(R.drawable.under)
            }else if(value <= 24.9){
                txtBMI.text = "(Normal)"
                imgBMI.setImageResource(R.drawable.normal)
            }else{
                txtBMI.text = "(Overweight)"
               imgBMI.setImageResource(R.drawable.over)
            }

            txtValue.text = "BMI = %.2f".format(value)
        }
        catch (e:Exception){
            val toast:Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }

    private fun reset(){
        txtHeight.setText("")
        txtWeight.text = null
        txtValue.text = null
        txtBMI.text = null
        imgBMI.setImageResource(R.drawable.empty)
        Toast.makeText(applicationContext, "Reset Completed", Toast.LENGTH_SHORT).show()
    }
}
