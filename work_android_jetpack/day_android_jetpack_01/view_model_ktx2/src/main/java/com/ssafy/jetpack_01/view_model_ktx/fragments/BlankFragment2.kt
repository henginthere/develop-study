package com.ssafy.jetpack_01.view_model_ktx.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.ssafy.jetpack_01.view_model_ktx.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {

    private lateinit var binding: FragmentBlank2Binding
    private val activityWithFragmentViewModel: ActivityWithFragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlank2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        printCount()

        binding.buttonPlus.setOnClickListener {
            activityWithFragmentViewModel.increaseCount()
            printCount()
        }
        binding.buttonMinus.setOnClickListener {
            activityWithFragmentViewModel.decreaseCount()
            printCount()
        }
    }

    fun printCount() {
        binding.textResult.text = activityWithFragmentViewModel.count.toString()
    }
}