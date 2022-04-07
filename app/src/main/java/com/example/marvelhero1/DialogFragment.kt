package com.example.marvelhero1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.marvelhero1.databinding.DialogFragmentBinding

class CustomDialogFragment: DialogFragment() {
    private lateinit var binding: DialogFragmentBinding
    private var createdby: String = ""
    private var firstApp: String = ""
    private var publisher: String = ""
    private var biography: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogFragmentBinding.inflate(layoutInflater)
        createdby = arguments?.getString("Arg1","createdby").toString()
        firstApp = arguments?.getString("Arg2","firstappearance").toString()
        publisher = arguments?.getString("Arg3","publisher").toString()
        biography = arguments?.getString("Arg4","biography").toString()
        binding.butBack.setOnClickListener { dismiss() }

        binding.createText.text = createdby
        binding.textFiApp.text = firstApp
        binding.textPubl.text = publisher
        binding.textBio.text = biography
        return binding.root
    }

}