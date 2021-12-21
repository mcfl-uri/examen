package com.android.examen.ui.fragments.addcandidate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.android.examen.R
import com.android.examen.databinding.FragmentAddCandidateBinding

class AddCandidateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAddCandidateBinding>(
            inflater,
            R.layout.fragment_add_candidate,
            container,
            false
        )


        binding.nextButton.setOnClickListener { View ->
            view?.findNavController()?.navigate(R.id.action_addCandidateFragment_to_seeCandidatesFragment)
        }

        return binding.root
    }

}