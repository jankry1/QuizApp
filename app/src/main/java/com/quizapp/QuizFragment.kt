package com.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.quizapp.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {
//questions
    private val quizItems: MutableList<QuizItem> = mutableListOf(
        QuizItem("What is Hermione Granger blood status?",
            //everytime the first answer here is correct, that's why I did the shuffle in fun getRandomQuizItem()
            listOf("Muggle-born", "Half-blood", "Pure-blood")),

        QuizItem("When is Ron Weasley's birthday?",
            listOf("1 March, 1980", "25 September, 1981", "23 November, 2004")),

        QuizItem("Where did Harry Potter get the Philosopher's Stone by looking in the mirror?",
            listOf("From the pocket", "From a boot", "Out of the bag")),

        QuizItem("What did Harry Potter name his youngest daughter?",
            listOf("Lily Luna Potter", "Luna Hermione Potter", "Lily Cho Potter")),

        QuizItem("Which Horcrux does Harry find in Bellatrix Lestrange's vault?",
            listOf("Helga Hufflepuff's cup", "Ravenclaw's Diadem", "A vase")),

        QuizItem("Who gave Hermione the Time-Turner?",
            listOf("Professor McGonagall", "Albus Dumbledore", "Her mother")),

        QuizItem("What did Hermione say when she entered the compartment in which Harry and Ron were sitting in the philosopher's stone?",
            listOf("Has anyone seen a toad? A boy named Neville lost one", "Oh my goodness! Are you Harry Potter?", "Hi, I'm Hermione Granger")),

        QuizItem("What smell did the huntsman smell in the forest near the tent in which Harry, Ron and Hermione lived during the search for Horcruxes?",
            listOf("Hermione's perfume", "Rain", "Fried chicken ")),

        QuizItem("What did Hermione do after the war for Hogwarts ended?",
            listOf("Completed 7 years at Hogwarts", "Married Ron", "Got a job at the Ministry of Magic")),

        QuizItem("Who did Harry and Hermione turn into when they went to Godric's Hollow?",
            listOf("For an old couple", "To Colin Creevy's parents", "In children")),
    )

    lateinit var currentQuizItem: QuizItem
    lateinit var answers: MutableList<String>
    private var quizItemIndex = 0
    private val numberOfQuestions = 10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
            inflater, R.layout.fragment_quiz, container, false)

        getRandomQuizItem()

        // bind this class with quizFragment
        binding.quizFragment = this

        binding.nextButton.setOnClickListener{ view: View ->

            val selectedCheckboxId = binding.quizRadioGroup.checkedRadioButtonId

            if (selectedCheckboxId != 1 ) {

                var answerIndex = 0
                when (selectedCheckboxId){
                    R.id.firstRadioButton -> answerIndex = 0
                    R.id.secondRadioButton -> answerIndex = 1
                    R.id.thirdRadioButton -> answerIndex = 2
                }

                // checking if the selected answer is correct -->

                if (answers[answerIndex] == currentQuizItem.answerList[0]) {

                    quizItemIndex++

                    if( quizItemIndex < numberOfQuestions ) {
                        setQuizItem()

                        // to show all changes
                        binding.invalidateAll()

                    } else {
                        // go to winFragment
                        view.findNavController().navigate(
                            R.id.action_quizFragment_to_winFragment
                        )
                    }
                } else {
                    //go to LoseFragment

                    view.findNavController().navigate(
                        R.id.action_quizFragment_to_loseFragment
                    )
                }
            }
        }

        // creating title for ActionBar
        (activity as AppCompatActivity).supportActionBar?.title = "Harry Potter Quiz"

        return binding.root
    }

    //to get every time random question
    private fun getRandomQuizItem(){

        quizItems.shuffle()
        quizItemIndex = 0
        setQuizItem()
    }

    private fun setQuizItem(){
        currentQuizItem = quizItems[quizItemIndex]
        answers = currentQuizItem.answerList.toMutableList()
        answers.shuffle()
    }
}