package com.example.exammovil

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController

@Composable
fun AerolineaDetailScreen(
    navController: NavController,
    aerolineaId: Long,
    viewModel: AerolineasViewModel
) {
    val aerolineaState = viewModel.getAerolineaById(aerolineaId).collectAsState(initial = null)

    val aerolinea = aerolineaState.value

    if (aerolinea != null) {

        Column {
            Text(text = "Nombre: ${aerolinea.nombre}")
            Text(text = "Código: ${aerolinea.codigo}")
            Text(text = "Pais: ${aerolinea.pais}")
            Text(text = "Flota: ${aerolinea.flota}")
        }
    } else {

        Text(text = "Aerolínea no encontrada")
    }
}