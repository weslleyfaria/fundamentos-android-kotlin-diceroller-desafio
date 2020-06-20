package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countButton: Button = findViewById(R.id.countup_button)
        countButton.setOnClickListener { countUp() }
    }

    private fun rollDice() {
        Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        //Se o texto padrão for "Hello World!" apresenta 1 no result_text
        if (resultText.text == "Hello World!") {
            Toast.makeText(this, "+1", Toast.LENGTH_SHORT).show()
            resultText.text = "1"
        } else {
            //Para comparar o dado aleatório precisa resgatar o valor e converter para string e depois para inteiro
            var resultInt = resultText.text.toString().toInt()
            //Condição para adicionar +1 se o valor for menor que 6
            if (resultInt < 6) {
                Toast.makeText(this, "+1", Toast.LENGTH_SHORT).show()
                resultInt++
                resultText.text = resultInt.toString()
            }
        }
    }
}
