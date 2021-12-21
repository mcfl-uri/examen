package com.android.examen.ui.fragments.seecandidates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.examen.R
import com.android.examen.database.entities.Candidat

class SeeCandidatesAdapter (val candidats: List<Candidat>) : RecyclerView.Adapter<SeeCandidatesAdapter.CandidatesHolder>() {

    override fun getItemCount() = candidats.size

    class CandidatesHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(candidat: Candidat) {
            view.findViewById<TextView>(R.id.candidatNom).text = candidat.nomCandidat
            view.findViewById<TextView>(R.id.candidatEdat).text = candidat.edatCandidat.toString()
            view.findViewById<TextView>(R.id.candidatDesti).text = candidat.destiCandidat
        }

        companion object {
            fun from(parent: ViewGroup): CandidatesHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.candidate_cell_layout, parent, false)

                return CandidatesHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CandidatesHolder {
        return CandidatesHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CandidatesHolder, position: Int) {
        holder.bind(candidats[position])
    }
}