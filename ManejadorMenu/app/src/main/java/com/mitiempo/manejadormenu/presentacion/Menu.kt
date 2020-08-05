package com.mitiempo.manejadormenu.presentacion

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.mitiempo.manejadormenu.R
import kotlinx.android.synthetic.main.view_menu.view.*

class Menu @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_menu,this,true)
        ponerEscuchadores()
    }

    private fun ponerEscuchadores(){
        opcion1.setOnClickListener {  notificaAlInvocador(opcionesMenu.OPCION_1.aumentarNumeroToque()) }
        opcion2.setOnClickListener {  notificaAlInvocador(opcionesMenu.OPCION_2.aumentarNumeroToque()) }
        opcion_3.setOnClickListener { notificaAlInvocador(opcionesMenu.OPCION_3.aumentarNumeroToque()) }
        opcion_4.setOnClickListener { notificaAlInvocador(opcionesMenu.OPCION_4.aumentarNumeroToque()) }
    }

    @SuppressLint("WrongConstant")
    private fun notificaAlInvocador(opcionesMenu: opcionesMenu){
        post {
            escuchadorOpcionSeleccionada?.invoke(opcionesMenu)
            drawerLayout?.closeDrawer(Gravity.START)
        }
    }

    private var escuchadorOpcionSeleccionada : ((opcionesMenu)->Unit) ?= null
    fun conEscuchadorOpcionSeleccionada(escuchadorOpcionSeleccionada : ((opcionesMenu)->Unit)) : Menu {
        this.escuchadorOpcionSeleccionada = escuchadorOpcionSeleccionada
        return this
    }

    private var drawerLayout : DrawerLayout ?= null
    fun conDrawerLayout(drawerLayout : DrawerLayout) : Menu {
        this.drawerLayout = drawerLayout
        return this
    }

    enum class opcionesMenu (private val titulo_opcion : Int){
        OPCION_1(R.string.opcion_1),
        OPCION_2(R.string.opcion_2),
        OPCION_3(R.string.opcion_3),
        OPCION_4(R.string.opcion_4),
        ;

        fun traerTituloOpcion() : Int{
            return titulo_opcion
        }

        private var numero_toques = 0
        fun aumentarNumeroToque() : opcionesMenu {
            numero_toques++
            return this
        }

        fun traerNumeroToques() : Int{
            return numero_toques
        }
    }


}