package com.example.exammovil

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Aerolineas::class], version = 1, exportSchema = false)
abstract class AerolineasDatabase : RoomDatabase() {
    abstract fun daoAerolineas(): DaoAerolineas

    companion object {
        @Volatile
        private var INSTANCE: AerolineasDatabase? = null

        fun getDatabase(context: Context): AerolineasDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AerolineasDatabase::class.java,
                    "aerolineas_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

