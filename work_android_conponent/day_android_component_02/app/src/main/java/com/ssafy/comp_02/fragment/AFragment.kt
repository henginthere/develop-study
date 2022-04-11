package com.ssafy.comp_02.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ssafy.comp_02.R
import com.ssafy.comp_02.databinding.FragmentABinding
import com.ssafy.comp_02.databinding.FragmentBBinding

// Fragment 초기화 파라미터 이름으로 필요시 적절히 이름 변경 후 사용
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
private const val TAG = "AFragment_싸피"
class AFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentABinding

    // Fragment가 Activity에 붙을 때 호출되는 콜백 함수
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach:")
    }

    // Fragment가 Activity에 붙은 후 호출되는 콜백 함수
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate:")

        // arguments 내장 객체를 통해 파라미터 활용
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    // layout을 inflate하는 단계로 뷰 바인딩 진행, UI에 대한 작업은 진행하지 않음
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        
        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    // View 생성이 완료 되었으며 UI 초기화 작업 진행
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")

        binding.tvStatusA.text = param1
        binding.tvMessageA.text = param2
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    // 프레그먼트가 생성되서 해당 프레그먼트가 액티비티에 추가되기 전에 인자를 첨부하기 위해 companion object 사용
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AFragment.
         */
        @JvmStatic  // Companion에 등록된 변수를 자바의 static처럼 선언하기 위한 annotation
        fun newInstance(param1: String, param2: String) =
            AFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
                Log.d(TAG, "newInstance: AFragment 객체 생성")
            }
    }
}