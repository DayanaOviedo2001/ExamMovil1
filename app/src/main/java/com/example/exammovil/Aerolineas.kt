package com.example.exammovil

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aerolineas")
data class Aerolineas(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nombre: String,
    val codigo: String,
    val pais: String,
    val flota: Int
)
