package com.example.marvelhero1.presentation.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.marvelhero1.R

fun AppCompatActivity.root(fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .add(R.id.container, fragment)
        .commit()
}