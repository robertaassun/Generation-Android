package com.app.interactivebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.io.BufferedReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
             rollThis()
    }
}
    private fun rollThis() {
        var dado = dados(6)
        var dadoJogado = dado.roll()
        var textView:ImageView = findViewById(R.id.imageView)
        when(dadoJogado){
            1 -> textView.setImageResource(R.drawable.dice_1)
            2 -> textView.setImageResource(R.drawable.dice_2)
            3 -> textView.setImageResource(R.drawable.dice_3)
            4 -> textView.setImageResource(R.drawable.dice_4)
            5 -> textView.setImageResource(R.drawable.dice_5)
            6 -> textView.setImageResource(R.drawable.dice_6)
        }
    }
}
class dados(private val numbSides: Int) {

    fun roll(): Int {
        return (1..numbSides).random()
    }

}