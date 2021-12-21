package com.android.examen.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Candidat(
    @PrimaryKey(autoGenerate = true)
    val idCandidat: Int,
    @ColumnInfo(name = "nom_candidat")
    var nomCandidat: String,
    @ColumnInfo(name = "mail_candidat")
    var mailCandidat: String,
    @ColumnInfo(name = "edat_candidat")
    var edatCandidat: Int,
    @ColumnInfo(name = "sexeCandidat")
    var sexeCandidat: String,
    @ColumnInfo(name = "desti_candidat")
    var destiCandidat: String
)
