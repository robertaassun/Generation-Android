package com.app.calculagorjeta

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.calculagorjeta.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{ calculateTip() }
    }

    fun calculateTip() {
        var stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()

         val selectedId = binding.tipOptions.checkedRadioButtonId
            val tipPercentage = when (selectedId) {
            R.id.opc20 -> 0.20
            R.id.opc18-> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        var roundUp = binding.roundUpSwitch.isChecked

        if(roundUp){
            tip = ceil(tip)
        }

        NumberFormat.getCurrencyInstance()
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.app_name, formattedTip)
    }
}