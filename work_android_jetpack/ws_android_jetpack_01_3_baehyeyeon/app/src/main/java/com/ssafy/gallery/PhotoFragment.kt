package com.ssafy.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.ssafy.gallery.databinding.FragmentPhotoBinding
import com.ssafy.gallery.util.Utils

class PhotoFragment : Fragment() {

    private lateinit var binding : FragmentPhotoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 이미지 클릭 시 Gallery Fragment로 이동
        binding.ivPhoto.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fcv_main, GalleryFragment())
                .commit()
        }

        // Gallery Fragment에서 넘어온 Photo를 읽고, 화면에 출력
        setFragmentResultListener("ItemClick"){_, bundle ->
            val photo = bundle.getSerializable("Photo") as Photo
            
            binding.tvDate.text = Utils.formatter().format(photo.date)
            binding.tvLocation.text = photo.location
            val packageName = "com.ssafy.gallery"
            val resId = view.resources.getIdentifier(photo.src, "drawable", packageName)
            binding.ivPhoto.setImageResource(resId)
        }
    }

}