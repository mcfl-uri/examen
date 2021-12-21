package com.android.examen.ui.fragments.seecandidates

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.examen.R
import com.android.examen.database.CandidatsDB
import com.android.examen.database.entities.Candidat
import com.android.examen.databinding.FragmentAddCandidateBinding
import com.android.examen.databinding.FragmentSeeCandidatesBinding
import com.android.examen.shared.viewmodel.SharedViewModel
import com.android.examen.shared.viewmodel.SharedViewModelFactory

class SeeCandidatesFragment : Fragment() {

    var candidats = listOf<Candidat>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSeeCandidatesBinding>(
            inflater,
            R.layout.fragment_see_candidates,
            container,
            false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = CandidatsDB.getInstance(application).candidatDao
        val viewModelFactory = SharedViewModelFactory(dataSource, application)

        val sharedViewModel =
            ViewModelProvider(this, viewModelFactory).get(SharedViewModel::class.java)

        binding.setLifecycleOwner(this)

        candidats = sharedViewModel.getAll()

        binding.candidatRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val adapter = SeeCandidatesAdapter(candidats)
        binding.candidatRecycler.adapter = adapter

        binding.tornaButton.setOnClickListener { View ->
            view?.findNavController()?.navigate(R.id.action_seeCandidatesFragment_to_addCandidateFragment)
        }

        return binding.root
    }

}