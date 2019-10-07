package com.fr.MBDS.schaibi.myappcours

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.fr.MBDS.schaibi.myappcours.Fragment.ArticlesFragment

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_articles)

        var planetes = resources.getStringArray(R.array.planetes)
        var spinner = findViewById(R.id.spinner) as Spinner
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, planetes)
        spinner.adapter = adapter
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
                val fragment = ArticlesFragment(planetes[position])
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container, fragment)
                    addToBackStack(null)
                }.commit()
            }
        }
    }
}
