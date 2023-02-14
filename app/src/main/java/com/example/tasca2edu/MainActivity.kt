package com.example.tasca2edu

import android.content.ContentValues.TAG
import android.graphics.Color
import android.graphics.Color.RED
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.hardware.camera2.params.RggbChannelVector.RED
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
        val rnd = Random()
        var result:Int = 0
        var pixel:Int = 14
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))

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
            val colorT: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            textCero.setTextColor(colorT)
        })
        btnColorFons.setOnClickListener(View.OnClickListener {


            var bg:ConstraintLayout = findViewById(R.id.background)
            bg.setBackgroundColor(color)

        })
        Toast.makeText(this, "Notificación corta", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "Notificación larga", Toast.LENGTH_LONG).show()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        var textCero = findViewById<View>(R.id.textView) as TextView;



        outState.putString("num", textCero.text.toString())
        outState.putInt("color", textCero.currentTextColor)
        outState.putFloat("size", textCero.textSize)
        outState.putInt("visible", textCero.visibility)

        var bg:ConstraintLayout = findViewById(R.id.background)

        outState.putInt("bgColor", bg.solidColor)

        super.onSaveInstanceState(outState)
    }




    override fun onRestoreInstanceState(savedInstanceState: Bundle) {val rnd = Random()
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))

        super.onRestoreInstanceState(savedInstanceState)
        var textCero = findViewById<View>(R.id.textView) as TextView;
        var bg:ConstraintLayout = findViewById(R.id.background)

        textCero.setText(savedInstanceState.getString("num"))
        textCero.setTextColor(savedInstanceState.getInt("color"))
        textCero.setTextSize(TypedValue.COMPLEX_UNIT_PX, savedInstanceState.getFloat("size"))
        textCero.visibility = savedInstanceState.getInt("visible")
        bg.setBackgroundColor(color)

    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
        Toast.makeText(this, "on pause", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
        Toast.makeText(this, "on start", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
        Toast.makeText(this, "on destroy", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
        Toast.makeText(this, "on Resume", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
        Toast.makeText(this, "on Stop", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
        Toast.makeText(this, "on restart", Toast.LENGTH_SHORT).show()
    }
}