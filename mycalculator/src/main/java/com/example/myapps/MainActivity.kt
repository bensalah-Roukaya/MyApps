package com.example.myapps

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var output: TextView
    var history: String = "Last operations \n"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        output = findViewById(R.id.outputView)
    }

    fun onNumberClick(view: View) {
        if (view is Button) {
            val input = (view as Button).text.toString()
            val newOutput = output.text.toString().plus(input)
            output.setText(newOutput)
        }
    }

    fun onOperatorClick(view: View) {
        if (view is Button) {
            val operator = (view as Button).text.toString()
            val newOutput = output.text.toString().plus(operator)
            output.setText(newOutput)
        }
    }

    fun onClearClick(view: View) {
        if (view is Button) {
            output.setText("")
        }
    }

    fun onDeleteInputClick(view: View) {
        if (view is Button) {
            if (!output.text.toString().isEmpty()) {
                //Retourner la sous chaine de output en enlevant le dernier caracter
                val newOutput = output.text.toString().substring(0, output.text.toString().length - 1)
                output.setText(newOutput)
            }
        }
    }

    fun onResultClick(view: View) {
        if (view is Button) {
            val operators: List<String> = Arrays.asList("+", "-", "*", "/")
            val outputSplited: List<String> = output.text.toString()
                    .replace("+", "$+$")
                    .replace("*", "$*$")
                    .replace("-", "$-$")
                    .replace("/", "$/$")
                    .split("$")

            var resultat: Float = 0f
            outputSplited.forEachIndexed { index, element ->

                if (operators.contains(element)) {
                    var previousValue = outputSplited.get(index - 1).replace(",", ".").toFloat()
                    val nextValue = outputSplited.get(index + 1).replace(",", ".").toFloat()

                    if (resultat != 0f) {
                        previousValue = resultat
                    }

                    when (element) {
                        "+" -> resultat = previousValue + nextValue
                        "-" -> resultat = previousValue - nextValue
                        "*" -> resultat = previousValue * nextValue
                        "/" -> resultat = previousValue / nextValue
                        else -> resultat = 0f
                    }

                }
            }
            history += output.text.toString() + "=" + resultat.toString() + "\n"

            output.setText(resultat.toString())

        }
    }

    fun notImlemented(view: View) {
        Toast.makeText(applicationContext, "not yet implemented", Toast.LENGTH_SHORT).show()
    }

    fun showHistory(view: View) {
        Toast.makeText(applicationContext, history, Toast.LENGTH_SHORT).show()

    }
}
