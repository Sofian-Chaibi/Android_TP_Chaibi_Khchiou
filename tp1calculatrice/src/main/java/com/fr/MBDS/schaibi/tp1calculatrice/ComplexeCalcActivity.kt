package com.fr.MBDS.schaibi.tp1calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.java.dev.eval.*;
import kotlinx.android.synthetic.main.activity_main.*
import net.java.dev.eval.Expression.eval
import java.lang.Exception

class ComplexeCalcActivity : AppCompatActivity() {

    var operat: String = "0"
    var operateur = ""
    var result = ""
    var list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complexe)
        var textView = findViewById<TextView>(R.id.textViewAffichage)
        textView.setText(operat)
    }


    /**
     * Allow to display all history
     */
    fun displayHistorique() {
        var textView = findViewById<TextView>(R.id.textView)
        var history: String = ""
        if (list?.size != 0)
            for (s in list) {
                history += s.toString() + "\n"
            }

        textView.setText(history)
    }

    /**
     * allow to display the text to the screen
     */
    fun display() {
        var textView = findViewById<TextView>(R.id.textViewAffichage)
        textView.setText(operat)
    }

    /**
     * reinitialisation of all the previous data excepte history
     */
    fun reinit() {
        operat = "0"
        operateur = ""
        display()
    }

    /**
     * do the math, display error if calcu by 0 par exemple
     */
    fun operation(operat: String): Float {
        var operationResult: Float = 0f
        try {
            operationResult = eval(operat).toFloat()
        }catch (exception:Exception )
        {
            Toast.makeText(baseContext,"L'operation est invalide",Toast.LENGTH_LONG).show()
        }
        return operationResult

    }

    /**
     * event of Number !
     */
    fun onClickNombre(view: View) {
        val button = view as Button
        var textView = findViewById<TextView>(R.id.textViewAffichage)
        if (operateur == "") {
            if (operat == "0") {
                operat = button.text.toString()
            } else {
                operat += button.text.toString()
            }

        } else {
            operat += button.text.toString()
            operateur = "";
            textView.setText(operat)

        }
        display()
    }

    /**
     * if "=" do the math else adding signe
     */
    fun onClickOperateur(view: View) {
        val button = view as Button
        var textView = findViewById<TextView>(R.id.textViewAffichage)
        var operation: Float
        when (button.text.toString()) {
            "=" -> {
                if(operateur=="") {
                    var textView = findViewById<TextView>(R.id.textViewAffichage)
                    list.add(operat)
                    operation = operation(operat)
                    reinit()
                    displayHistorique()
                    operat = operation.toString()
                }
            }
            else -> {
                if(operateur!="") {
                    onClickSupp(view)
                }
                operateur = button.text.toString()
                operat += operateur

            }
        }
        display()
    }

    /**
     * erase all
     */
    fun onClickErase(view: View) {
        reinit()
    }

    /**
     * sup the last input
     */
    fun onClickSupp(view: View) {
        if (operateur != "") {
            operateur = ""
        }
        operat = operat.substring(0, operat.length - 1)
        display()
    }


}
