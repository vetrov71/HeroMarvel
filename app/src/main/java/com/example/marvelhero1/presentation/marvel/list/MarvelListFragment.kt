package com.example.marvelhero1.presentation.marvel.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelhero1.data.network.RetrofitClient
import com.example.marvelhero1.databinding.FragmentMarvelListBinding
import com.example.marvelhero1.domain.entity.Marvel
import com.example.marvelhero1.presentation.marvel.CustomDialogFragment
import retrofit2.Call
import retrofit2.Response

class MarvelListFragment : Fragment(), MyAdapter.ItemClickListener {

    private lateinit var binding: FragmentMarvelListBinding
    private val adapter = MyAdapter()


    companion object {

        fun newInstance() = MarvelListFragment()
    }

    private lateinit var viewModel: MarvelListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMarvelListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MarvelListViewModel::class.java)
        init()
    }

    private fun init() {
        with(binding){
            recView.layoutManager = LinearLayoutManager(requireContext())
            recView.adapter = adapter
            adapter.setOnItemClickListener(this@MarvelListFragment)

            viewModel.marvelListLiveData.observe(viewLifecycleOwner){
                adapter.setMovieListItems(it)
            }
            viewModel.errorLiveData.observe(viewLifecycleOwner){ msg ->
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onItemClick(marvel: Marvel) {

        val bundle = Bundle()

        bundle.putInt("Arg", 1)
        bundle.putString("Arg1", marvel.createdby)
        bundle.putString("Arg2", marvel.publisher)
        bundle.putString("Arg3", marvel.firstappearance)
        bundle.putString("Arg4", marvel.bio)

        val dialog = CustomDialogFragment()
        dialog.arguments = bundle
        dialog.show(parentFragmentManager, "marvel")
    }
}