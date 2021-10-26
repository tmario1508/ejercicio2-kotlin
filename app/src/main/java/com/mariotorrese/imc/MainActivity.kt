package com.mariotorrese.imc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mariotorrese.imc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var resources: ActivityMainBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //setContentView(R.layout.activity_main)
        resources = ActivityMainBinding.inflate(layoutInflater)
        setContentView(resources.root)
        val indice1 = getString(R.string.indice1)
        val indice2 = getString(R.string.indice2)
        val indice3 = getString(R.string.indice3)
        val indice4 = getString(R.string.indice4)

        resources.btnCalcular.setOnClickListener {
            val peso = resources.txtPeso.text.toString().toInt()
            val estatura = resources.txtEstatura.text.toString().toDouble()
            val imc = peso / (estatura * estatura)
            resources.txtIMC.text = imc.toString()
            if(imc <= 18.5){
                resources.txtIndice.text = "$indice1"
                resources.imagen.setImageResource(R.drawable.desnutricion)
            }
            if(imc > 18.5 && imc <= 24.9){
                resources.txtIndice.text = "$indice2"
                resources.imagen.setImageResource(R.drawable.bajopeso)
            }
            if(imc > 24.9 && imc <= 29.9){
                resources.txtIndice.text = "$indice3"
                resources.imagen.setImageResource(R.drawable.peso)
            }
            if(imc > 29.9){
                resources.txtIndice.text = "$indice4"
                resources.imagen.setImageResource(R.drawable.fat)
            }

        }
    }
}