package com.android.examen.shared.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.android.examen.database.daos.CandidatDao
import com.android.examen.database.entities.Candidat
import kotlinx.coroutines.launch

class SharedViewModel(
    private val dataSource: CandidatDao, application: Application
) : AndroidViewModel(application) {
    fun insert(nom: String, email: String, edat: Int, sexe: String, desti: String) {
        val candidat = Candidat(0, nom, email, edat, sexe, desti)
        viewModelScope.launch {
            dataSource.insert(candidat)
        }
    }

    fun getAll(): List<Candidat> {
        return dataSource.getAll()
    }
}