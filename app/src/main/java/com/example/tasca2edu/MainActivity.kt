package com.example.tasca2edu

import android.graphics.Color
import android.graphics.Color.RED
import android.hardware.camera2.params.RggbChannelVector.RED
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textCero = findViewById<View>(R.id.textView) as TextView;

        var btnSumar = findViewById<View>(R.id.btnSumar) as Button;
        var btnRestar = findViewById<View>(R.id.btnRestar) as Button;
        var btnAumentar = findViewById<View>(R.id.btnAumentar) as Button;
        var btnDisminuir = findViewById<View>(R.id.btnDisminuir) as Button;
        var btnAmagar = findViewById<View>(R.id.btnAmagar) as Button;
        var btnMostrar = findViewById<View>(R.id.btnMostrar) as Button;
        var btnColorText = findViewById<View>(R.id.btnColorText) as Button;
        var btnColorFons = findViewById<View>(R.id.btnColorFons) as Button;

        var result:Int = 0
        var pixel:Int = 14

        btnSumar.setOnClickListener(View.OnClickListener {

            result++
            textCero.setText(result.toString())


        })

        btnRestar.setOnClickListener(View.OnClickListener{
            result--
            textCero.setText(result.toString())
        })

        //boton de aumentar
        btnAumentar.setOnClickListener(View.OnClickListener {
            pixel++
            textCero.setTextSize(pixel.toFloat())
        })

        btnDisminuir.setOnClickListener(View.OnClickListener {
            pixel--
            textCero.setTextSize(pixel.toFloat())
        })

        btnAmagar.setOnClickListener(View.OnClickListener {
            textCero.isVisible=false
        })
        btnMostrar.setOnClickListener(View.OnClickListener {
            textCero.isVisible=true
        })

        btnColorText.setOnClickListener(View.OnClickListener {
            val rnd = Random()
            val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            textCero.setTextColor(color)
        })
        btnColorFons.setOnClickListener(View.OnClickListener {
            val rnd = Random()
            val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            var bg:ConstraintLayout = findViewById(R.id.background)
            bg.setBackgroundColor(color)
        })
    }

}