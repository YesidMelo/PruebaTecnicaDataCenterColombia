package com.mitiempo.calculadora.Presentacion

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mitiempo.calculadora.R
import kotlinx.android.synthetic.main.activity_main.*

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adicionarEscuchadores()
    }


    private fun adicionarEscuchadores(){
        boton_suma.setOnClickListener {

            if(!sePuedeRealizarOperacion()){
                mostrarToast(R.string.no_se_puede_realizar_esta_operacion_verifica_la_informacion_de_los_campos)
                return@setOnClickListener
            }

            resultado.setText(" ${numero_1.text.toString().toDouble() + numero_2.text.toString().toDouble() } ")
        }

        boton_resta.setOnClickListener {
            if(!sePuedeRealizarOperacion()){
                mostrarToast(R.string.no_se_puede_realizar_esta_operacion_verifica_la_informacion_de_los_campos)
                return@setOnClickListener
            }
            resultado.setText(" ${numero_1.text.toString().toDouble() - numero_2.text.toString().toDouble() } ")
        }

        boton_multiplicacion.setOnClickListener {
            if(!sePuedeRealizarOperacion()){
                mostrarToast(R.string.no_se_puede_realizar_esta_operacion_verifica_la_informacion_de_los_campos)
                return@setOnClickListener
            }


            resultado.setText(" ${numero_1.text.toString().toDouble() * numero_2.text.toString().toDouble() } ")
        }

        boton_divicion.setOnClickListener {
            if(!sePuedeRealizarOperacion()){
                mostrarToast(R.string.no_se_puede_realizar_esta_operacion_verifica_la_informacion_de_los_campos)
                return@setOnClickListener
            }



            if(esCeroElDivisor()){
                mostrarToast(R.string.no_se_puede_realizar_una_divicion_por_cero_intentelo_con_otro_numero)
                return@setOnClickListener
            }
            resultado.setText(" ${numero_1.text.toString().toDouble() / numero_2.text.toString().toDouble() } ")
        }
    }

    private fun sePuedeRealizarOperacion() : Boolean{
        return numero_1.text.isNotEmpty() && numero_2.text.isNotEmpty()
    }

    private fun mostrarToast(mensajeAMostrar : Int){
        Toast.makeText(this,getString(mensajeAMostrar),Toast.LENGTH_LONG).show()
    }

    private fun esCeroElDivisor(): Boolean{
        return numero_2.text.toString().toInt() == 0
    }
}
