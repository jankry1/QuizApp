package com.quizapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.quizapp.databinding.FragmentWelcomeScreenBinding

class WelcomeScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentWelcomeScreenBinding =
            DataBindingUtil.inflate(
                inflater, R.layout.fragment_welcome_screen, container, false)

        // creating navigation from WelcomeScreen to QuizFragment by clicking the button "Let's play"

        binding.letsPlay.setOnClickListener{ view: View ->
            Navigation.findNavController(view).navigate(R.id.action_welcomeScreenFragment3_to_quizFragment)

        }

        // creating title for ActionBar
        (activity as AppCompatActivity).supportActionBar?.title = "Harry Potter Quiz"

        setHasOptionsMenu(true)

        return binding.root


    }

    // implementing menu to the app
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)


    }

    //navigation for menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item, requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }
}