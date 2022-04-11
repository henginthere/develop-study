package com.ssafy.comp_02.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ssafy.comp_02.fragment.databinding.FragmentABinding
import com.ssafy.comp_02.fragment.databinding.FragmentBBinding

//fragment 초기화 파라미터 이름으로 필요시 적설히 이름 변경 후 사용
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private const val TAG = "AFragment_싸피"
class BFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentBBinding

    //fragment가 activity에 붙을 때 호출되는 콜백함수
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach: ")
    }

    //fragment가 activity에 붙은 뒤 호출되는 콜백 함수수
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    //layout을 inflate하는 단계로 뷰 바인딩 진행, UI에 대한 작업은 직행하지 않음
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")

        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    //View 생성이 완료되었으며 UI 초기화 작업 진행
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")

        binding.tvParam1.text = param1
        binding.tvParam2.text = param2

        binding.btnAdd.setOnClickListener {
            childFragmentManager
                .beginTransaction()
                .add(R.id.view_stub, CFragment(), "newFragmentC")
                .commit()
        }

        binding.btnRemove.setOnClickListener {
            val current = childFragmentManager.findFragmentByTag("newFragmentC")
            if(current!=null){
                childFragmentManager
                    .beginTransaction()
                    .remove(current)
                    .commit()
            }
        }
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
    // fragment가 생성돼서 해당 fragment가 액티비티에 추가되기 전에 인자를 첨부하기 위해
    // companion object 사용
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}