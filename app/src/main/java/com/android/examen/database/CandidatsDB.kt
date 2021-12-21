package com.android.examen.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.examen.database.daos.CandidatDao
import com.android.examen.database.entities.Candidat

@Database(
    entities = [Candidat::class],
    version = 2,
    exportSchema = false
)

abstract class CandidatsDB : RoomDatabase() {

    abstract val candidatDao: CandidatDao

    companion object {

        @Volatile
        private var INSTANCE: CandidatsDB? = null

        fun getInstance(context: Context): CandidatsDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CandidatsDB::class.java,
                        "candidats_database"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}