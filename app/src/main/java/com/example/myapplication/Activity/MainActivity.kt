package com.example.myapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.myapplication.Etudiant
import com.example.myapplication.R
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    var videoTime: Int =0;
    var video:String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val context = baseContext
        val intent = Intent(this,ExactementActivity::class.java)
        intent.putExtra("Test",12)
        startActivity(intent)
        val button = findViewById(R.id.buttonTest) as Button
        button.setText("blabla")
    }

    override fun onStart() {
        super.onStart()
        video = "Initialisation de la video"
        Log.d("start","J'initie mes variable")
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume1","Je lance la video la ou elle on est grace a une variable ou pas")
        Log.d("onResume2","Si c'est la premiere fois je commence a 0");
    }

    override fun onPause() {
        super.onPause()
        Log.d("onResume2","Je mets sur pause la video");
        Log.d("onResume2","Je sauvergarder la ou en est la videal");
        videoTime=1

    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop","J'arrete et je libere les ressources");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy",R.string.oskur.toString());
    }
}
