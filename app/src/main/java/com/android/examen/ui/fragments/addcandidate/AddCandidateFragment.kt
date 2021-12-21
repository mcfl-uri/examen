package com.android.examen.ui.fragments.addcandidate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.android.examen.R
import com.android.examen.database.CandidatsDB
import com.android.examen.databinding.FragmentAddCandidateBinding
import com.android.examen.shared.viewmodel.SharedViewModel
import com.android.examen.shared.viewmodel.SharedViewModelFactory

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

        val application = requireNotNull(this.activity).application
        val dataSource = CandidatsDB.getInstance(application).candidatDao
        val viewModelFactory = SharedViewModelFactory(dataSource, application)

        val sharedViewModel =
            ViewModelProvider(this, viewModelFactory).get(SharedViewModel::class.java)

        binding.setLifecycleOwner(this)

        binding.addButton.setOnClickListener { View ->

            if (binding.radioDesti.checkedRadioButtonId != -1) {
                val destiId: Int = binding.radioDesti.checkedRadioButtonId
                val desti = view?.findViewById<View>(destiId) as RadioButton

                if (binding.radioSexe.checkedRadioButtonId != -1) {
                    val sexeId: Int = binding.radioSexe.checkedRadioButtonId
                    val sexe = view?.findViewById<View>(sexeId) as RadioButton

                    if (binding.editTextPersonName.text.toString() != "" &&
                        binding.editTextEmailAddress.text.toString() != "" &&
                        binding.editTextEdat.text.toString().toInt() > 0 &&
                        binding.editTextEdat.text.toString().isNotBlank()
                    ) {
                        sharedViewModel.insert(
                            binding.editTextPersonName.text.toString(),
                            binding.editTextEmailAddress.text.toString(),
                            binding.editTextEdat.text.toString().toInt(),
                            sexe.text.toString(),
                            desti.text.toString()
                        )
                    } else {
                        Toast.makeText(
                            this.activity,
                            "Cal omplir totes les dades",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }
                } else {
                    Toast.makeText(
                        this.activity,
                        "Selecciona un sexe, si us plau",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }

            } else {
                Toast.makeText(this.activity, "Selecciona un destí, si us plau", Toast.LENGTH_LONG)
                    .show()
            }
        }

        binding.nextButton.setOnClickListener { View ->
            view?.findNavController()
                ?.navigate(R.id.action_addCandidateFragment_to_seeCandidatesFragment)
        }

        return binding.root
    }

}