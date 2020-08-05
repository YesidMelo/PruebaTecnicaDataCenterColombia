package com.mitiempo.manejadormenu.presentacion

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.mitiempo.manejadormenu.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        poneEscuchadores()
    }

    @SuppressLint("WrongConstant", "SetTextI18n")
    private fun poneEscuchadores() {
        boton_menu.setOnClickListener {
            contenedor_principal.openDrawer(Gravity.START)
        }

        menu_aplicacion
            .conDrawerLayout(contenedor_principal)
            .conEscuchadorOpcionSeleccionada {
                opcionSeleccionada ->
                contador_numero_veces.setText(" el numero es : ${opcionSeleccionada.traerNumeroToques()} ");
                titulo_seleccion.setText(getString(opcionSeleccionada.traerTituloOpcion()))
                fecha_seleccion.setText(Date().toString())
            }
    }
}
