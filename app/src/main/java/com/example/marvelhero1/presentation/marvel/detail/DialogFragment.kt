package com.example.marvelhero1.presentation.marvel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.marvelhero1.databinding.DialogFragmentBinding

class CustomDialogFragment: DialogFragment() {
    private lateinit var binding: DialogFragmentBinding
    private var create: String = ""
    private var fiApp: String = ""
    private var publ: String = ""
    private var bio: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogFragmentBinding.inflate(layoutInflater)
        create = arguments?.getString("Arg1","createdby").toString()
        fiApp = arguments?.getString("Arg2","firstappearance").toString()
        publ = arguments?.getString("Arg3","publisher").toString()
        bio = arguments?.getString("Arg4","biography").toString()
        binding.butBack.setOnClickListener { dismiss() }

        binding.createText.text = create
        binding.textFiApp.text = fiApp
        binding.textPubl.text = publ
        binding.textBio.text = bio
        return binding.root
    }

}