package com.example.marvelhero1

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
        create = arguments?.getString("create").toString()
        fiApp = arguments?.getString("firstAppearance").toString()
        publ = arguments?.getString("publisher").toString()
        bio = arguments?.getString("biography").toString()
        binding.butBack.setOnClickListener { dismiss() }

        binding.createText.text = create
        binding.textFiApp.text = fiApp
        binding.textPubl.text = publ
        binding.textBio.text = bio
        return binding.root
    }

}