package com.ssafy.comp_02.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ssafy.comp_02.fragment.databinding.FragmentCBinding


class CFragment : Fragment() {

    //뷰 바인딩 하는 코드만 작성
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }

}