package com.android.examen.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.android.examen.database.entities.Candidat

@Dao
interface CandidatDao {
    @Insert
    fun insert(candidat: Candidat)

    @Query("SELECT * FROM Candidat")
    fun getAll(): List<Candidat>
}