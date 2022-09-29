package com.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity


class InformationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // creating title for ActionBar
        (activity as AppCompatActivity).supportActionBar?.title = "Harry Potter Quiz"

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_information, container, false)
    }

}