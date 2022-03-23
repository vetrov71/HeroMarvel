package com.example.marvelhero1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelhero1.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity(), MyAdapter.ItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val adapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            recView.layoutManager = LinearLayoutManager(
                this@MainActivity
            )

            recView.adapter = adapter
            adapter.setOnItemClickListener(this@MainActivity)
        }
        val apiInterface = ApiInterface.create().getMovies()
        apiInterface.enqueue(object :
            retrofit2.Callback<ArrayList<Marvel>> {
            override fun onResponse(
                call: Call<ArrayList<Marvel>>?,
                response: Response<ArrayList<Marvel>>?
            ) {
                val recyclerAdapter = adapter
                if (response?.body() != null)
                    recyclerAdapter.setMovieListItems(response.body()!! )
                response?.let {
                    for (item: Marvel in response.body()!!) {
                        recyclerAdapter.setMovieListItems(response.body()!!)
                    }
                }
            }

            override fun onFailure(
                call: Call<ArrayList<Marvel>>,
                t: Throwable
            ) {
            }
        })
    }

    override fun onItemClick(marvel: Marvel) {
        val bundle = Bundle()
        bundle.putInt("Arg",1)
        bundle.putString("Arg1",marvel.createdby)
        bundle.putString("Arg2",marvel.publisher)
        bundle.putString("Arg3",marvel.firstappearance)
        bundle.putString("Arg4",marvel.bio)

//        Toast.makeText(
//            this@MainActivity, "ты нажал на элемент marvel",
//            Toast.LENGTH_SHORT
//        ).show()
        val dialog = CustomDialogFragment()
        dialog.arguments = bundle
        dialog.show(supportFragmentManager,"marvel")
    }
    override fun passData(position: Int, createdby: String, publisher: String,
                          firstappearance: String, biography: String) {
        val bundle = Bundle()
        bundle.putInt("Arg",position)
        bundle.putString("Arg1",createdby)
        bundle.putString("Arg2",publisher)
        bundle.putString("Arg3",firstappearance)
        bundle.putString("Arg4",biography)

//        val transaction = this.supportFragmentManager.beginTransaction()
//        val dialFrag = CustomDialogFragment()
//        dialFrag.arguments = bundle
//        transaction.show(dialFrag)
//            .commit()
    }

}
