package com.example.exammovil



import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AerolineasViewModel(private val daoAerolineas: DaoAerolineas) : ViewModel() {


    fun getAllAerolineas(): Flow<List<Aerolineas>> {
        return daoAerolineas.getAllAerolineas()
    }

    fun insertAerolinea(aerolinea: Aerolineas) {
        viewModelScope.launch {
            try {
                daoAerolineas.insertAerolinea(aerolinea)
            } catch (e: Exception) {
                Log.e("AerolineasViewModel", "Error al insertar la aerolínea: ${e.message}")
            }
        }
    }

    fun getAerolineaById(aerolineaId: Long): Flow<Aerolineas?> {
        return daoAerolineas.getAerolineaById(aerolineaId)
    }
}


