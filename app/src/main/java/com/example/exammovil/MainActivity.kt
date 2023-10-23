package com.example.exammovil

import MyScreenAerolineas
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: AerolineasViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = AerolineasDatabase.getDatabase(applicationContext)
        val daoAerolineas = database.daoAerolineas()
        viewModel = AerolineasViewModel(daoAerolineas)

        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "aerolineas"
            ) {
                composable("aerolineas") {
                    MyScreenAerolineas(viewModel, navController)
                }
                composable(
                    "detalle/{aerolineaId}",
                    arguments = listOf(navArgument("aerolineaId") { type = NavType.LongType })
                ) { backStackEntry ->
                    val aerolineaId = backStackEntry.arguments?.getLong("aerolineaId")
                    val aerolinea = aerolineaId?.let { viewModel.getAerolineaById(it).collectAsState(initial = null).value }
                    if (aerolineaId != null) {
                        AerolineaDetailScreen(navController, aerolineaId, viewModel)
                    }
                }
                composable("allAerolineas") {
                    AllAerolineas(navController, viewModel.getAllAerolineas().collectAsState(initial = emptyList()).value)
                }
            }
        }
    }
}