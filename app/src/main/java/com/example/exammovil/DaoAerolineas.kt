package com.example.exammovil

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoAerolineas {
    @Query("SELECT * FROM aerolineas")
    fun getAllAerolineas(): Flow<List<Aerolineas>>

    @Query("SELECT * FROM aerolineas WHERE id = :aerolineaId")
    fun getAerolineaById(aerolineaId: Long): Flow<Aerolineas?>

    @Insert
    suspend fun insertAerolinea(aerolinea: Aerolineas)
}

