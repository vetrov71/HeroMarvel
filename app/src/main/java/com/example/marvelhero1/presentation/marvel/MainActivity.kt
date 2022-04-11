package com.example.marvelhero1.presentation.marvel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelhero1.R
import com.example.marvelhero1.presentation.marvel.list.MarvelListFragment
import com.example.marvelhero1.presentation.utils.root


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        root(MarvelListFragment.newInstance())
    }
}
