package com.ssafy.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.ssafy.gallery.databinding.FragmentPhotoBinding
import com.ssafy.gallery.util.Utils

private const val ARG_PHOTO_ID = "photo_id"
class PhotoFragment : Fragment() {

    private lateinit var photo : Photo
    private lateinit var binding : FragmentPhotoBinding
    private var galleryDao = GalleryDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        galleryDao.dbOpenHelper(requireContext())
        galleryDao.open()

        //넘어온 ID값 받기
        val photoId: Int = arguments?.getSerializable(ARG_PHOTO_ID) as Int

        //해당 ID로 DB 검색
        photo = galleryDao.selectPhotos(photoId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUI(photo)
    }

    private fun updateUI(photo: Photo){
        binding.tvLocation.text = photo.location
        binding.tvDate.apply {
            val sdf = Utils.formatter().format(photo.date).toString()
            text = sdf
        }
        binding.ivPhoto.apply{
            val resId = view?.resources?.getIdentifier(photo.src, "drawble", context.packageName)
            if(resId!=null){
                setImageResource(resId)
            }
        }
    }

    companion object {
        // Argument에 Bundle을 넘겨 ID 값을 저장하는 Instance 함수 구현
        fun newInstance(photoId: Int): PhotoFragment {
            val args = Bundle().apply {
                putSerializable(ARG_PHOTO_ID, photoId)
            }
            return PhotoFragment().apply {
                arguments = args
            }
        }
    }

}