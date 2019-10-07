package com.fr.MBDS.schaibi.tp1calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var premierChiffre="0"
    var deuxiemeChiffre=""
    
    var operateur=""
    var result =""
    var list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textView = findViewById<TextView>(R.id.textViewAffichage)
        textView.setText(premierChiffre)
    }

    fun displayHistorique()
    {
        var textView = findViewById<TextView>(R.id.textView)
        var history : String =""
        if(list?.size!=0)
        for (s in list)
        {
            history+=s.toString()+"\n"
        }

        textView.setText(history)
    }

    fun display()
    {
        var textView = findViewById<TextView>(R.id.textViewAffichage)
        textView.setText(premierChiffre+operateur+deuxiemeChiffre)
    }

    fun reinit()
    {
        premierChiffre="0"
        deuxiemeChiffre=""
        operateur=""
        display()
    }

    fun operation(operateurSigne : String):Float
    {
        var operationResult:Float =0f
        when(operateurSigne)
        {
            "+"-> operationResult=(premierChiffre.toFloat())+(deuxiemeChiffre.toFloat())
            "-"-> operationResult=(premierChiffre.toFloat())-(deuxiemeChiffre.toFloat())
            "/"-> operationResult=(premierChiffre.toFloat())/(deuxiemeChiffre.toFloat())
            "x"-> operationResult=(premierChiffre.toFloat())*(deuxiemeChiffre.toFloat())

        }
        return operationResult

    }

    fun onClickNombre(view: View) {
        val button = view as Button
        var textView = findViewById<TextView>(R.id.textViewAffichage)
        if(operateur=="")
        {
            if(premierChiffre=="0")
            {
                premierChiffre=button.text.toString()
            }
            else {
                premierChiffre += button.text.toString()
            }

        }
        else
        {
            deuxiemeChiffre += button.text.toString()
            textView.setText(textView.getText().toString()+deuxiemeChiffre)

        }
        display()
    }

    fun onClickOperateur(view : View) {
        val button = view as Button
        var textView = findViewById<TextView>(R.id.textViewAffichage)
        var operation: Float
        when (button.text.toString()) {
            "=" -> {
                var textView = findViewById<TextView>(R.id.textViewAffichage)
                list.add(premierChiffre + " " + operateur + " " + deuxiemeChiffre)
                if (operateur != "" || deuxiemeChiffre != "") {
                    operation = operation(operateur)
                    reinit()
                    displayHistorique()
                    premierChiffre=operation.toString()
                }
            }
            else -> {
                operateur = button.text.toString()

            }
        }
        display()
    }

        fun onClickErase(view : View)
        {
            reinit()
        }

    fun onClickSupp(view : View)
    {
        if(operateur!="" && deuxiemeChiffre=="")
        {
            operateur=""
            display()
        }
        else if(operateur!="" &&  deuxiemeChiffre!="")
        {
            deuxiemeChiffre=deuxiemeChiffre.substring(0,deuxiemeChiffre.length-1)
        }
        else
        {
            premierChiffre=premierChiffre.substring(0,premierChiffre.length-1)
        }

        display()
    }


}
