package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI(){
        if(editTextWeight.text.isEmpty()){
            editTextWeight.setError((getString(R.string.error_input)))
            return
        }
        if(editTextHeight.text.isBlank()){
            editTextHeight.setError((getString(R.string.error_input)))
            return
        }
        val weight : Float = editTextWeight.text.toString().toFloat()
        val height : Float = editTextHeight.text.toString().toFloat()
        val bmiCount = weight/(height*2)

        textViewBMI.text = String.format("%s %.2f",getString(R.string.bmi),bmiCount)
        if(bmiCount<18.5){
            imageViewBody.setImageResource(R.drawable.under)
            textViewStatus.text = String.format("%s %s",getString(R.string.status),getString(R.string.underweight))
        }else if(bmiCount>18.5&&bmiCount<25){
            imageViewBody.setImageResource(R.drawable.normal)
            textViewStatus.text = String.format("%s %s",getString(R.string.status),getString(R.string.normal))
        }else if(bmiCount>=25){
            imageViewBody.setImageResource(R.drawable.over)
            textViewStatus.text = String.format("%s %s",getString(R.string.status),getString(R.string.overweight))
        }
    }

    fun resetOutput(view:View){
        //TODO clear all input and output
        imageViewBody.setImageResource(R.drawable.empty)
        editTextHeight.text.clear()
        editTextWeight.text.clear()
        textViewBMI.text = String.format("%s",getString(R.string.bmi))
        textViewStatus.text = String.format("%s",getString(R.string.status))
    }
}


