package com.fr.MBDS.schaibi.myappcours

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fr.MBDS.schaibi.myappcours.Fragment.ArticlesFragment

class RecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)

        var planetes = resources.getStringArray(R.array.planetes)
//recupérer l'instance du spinner dans la vue
        var spinner = findViewById(R.id.spinner) as Spinner
//instancier l'adapteur
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, planetes)
//associer l'adapter au spinner
        spinner.adapter = adapter
//Listener quand l'utilisateur selectionne un élément
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(baseContext, "Vous n'avez rien selectionné", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onItemSelected(
                adapter: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    baseContext,
                    "Vous avez selectionné ${planetes[position]}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
