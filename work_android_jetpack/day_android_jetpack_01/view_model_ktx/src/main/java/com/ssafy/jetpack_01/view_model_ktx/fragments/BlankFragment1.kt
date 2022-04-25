package com.ssafy.jetpack_01.view_model_ktx.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ssafy.jetpack_01.view_model_ktx.databinding.FragmentBlank1Binding

class BlankFragment1 : Fragment() {

    var listener: CommunicationCallback? = null
    private lateinit var binding: FragmentBlank1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlank1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        printCount()

        binding.buttonPlus.setOnClickListener {
            listener?.increaseCount()
            printCount()
        }
        binding.buttonMinus.setOnClickListener {
            listener?.decreaseCount()
            printCount()
        }
    }

    fun printCount() {
        binding.textResult.text = listener?.getCount().toString()
    }
}