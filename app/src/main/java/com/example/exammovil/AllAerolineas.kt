package com.example.exammovil

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun AllAerolineas(
    navController: NavController,
    aerolineas: List<Aerolineas>,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Listado de todas las aerolíneas:")

        LazyColumn {
            items(aerolineas) { aerolinea ->
                Button(
                    onClick = {
                        navController.navigate("detalle/${aerolinea.id}")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "${aerolinea.nombre}")
                }
            }
        }
    }
}
