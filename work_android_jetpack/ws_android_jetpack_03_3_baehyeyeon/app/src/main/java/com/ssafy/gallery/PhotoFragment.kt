package com.ssafy.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ssafy.gallery.database.GalleryDao
import com.ssafy.gallery.databinding.FragmentPhotoBinding
import com.ssafy.gallery.util.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val ARG_PHOTO_ID = "photo_id"
class PhotoFragment : Fragment() {

    private lateinit var photo : Photo
    private lateinit var binding : FragmentPhotoBinding
    private val galleryRepository = GalleryRepository.get()
    private var photoId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //넘어온 ID값 받기
        photoId = arguments?.getSerializable(ARG_PHOTO_ID) as Int
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
        CoroutineScope(Dispatchers.Main).launch {
            photo = galleryRepository.getPhoto(photoId)
            updateUI(photo)
        }

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