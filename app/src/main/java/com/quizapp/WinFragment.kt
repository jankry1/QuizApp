package com.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.quizapp.databinding.FragmentWinBinding

class WinFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentWinBinding>(
            inflater, R.layout.fragment_win, container, false)

        binding.oneMoreTimeButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(
                R.id.action_winFragment_to_quizFragment
            )
        }
        // creating title for ActionBar
        (activity as AppCompatActivity).supportActionBar?.title = "Harry Potter Quiz"
        return binding.root
    }

}