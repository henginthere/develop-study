package com.ssafy.gallery

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.gallery.database.GalleryDao
import com.ssafy.gallery.databinding.FragmentGalleryBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "GalleryFragment_싸피"

class GalleryFragment : Fragment() {

    // Fragment교체 기능을 호스팅 Activity에 위임하기 위해 구현
    // Callbacks에서는 Fragment가 필요로 하는 일을 수행하게 하는 함수를 정의
    interface Callbacks {
        fun onPhotoSelected(photoId: Int)
    }

    private var callbacks: Callbacks? = null
    private lateinit var binding: FragmentGalleryBinding
    private var galleryRepository =  GalleryRepository.get()
    private var photos : List<Photo> = emptyList()
    private var galleryAdapter : GalleryAdapter? = GalleryAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //호스팅 액티비티에 연결될 때 호출
    override fun onAttach(context: Context) {
        super.onAttach(context)
        // onAttach의 인자로 전달된 Context 객체의 참조를 callbacks의 속성에 저장한다.
        callbacks = context as Callbacks?
        // 인자로 전달된 Context 객체의 참조를 callbacks의 속성에 지정할 때
        // GalleryFragment.Callbacks 타입으로 변환하기 때문에
        // GalleryFragment를 호스팅하는 액티비티는 반드시 Callbacks 인터페이스를 구현해야한다.
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.Main).launch {
            photos = galleryRepository.getPhotos()
            galleryAdapter = GalleryAdapter(photos)

            galleryAdapter!!.setItemClickListener(object: GalleryAdapter.ItemClickListener{
                override fun onClick(view: View, dto: Photo, position: Int) {
                    callbacks?.onPhotoSelected(dto.num)
                }
            })

            binding.recyclerView.apply {
                layoutManager = GridLayoutManager(context,3)
                adapter = galleryAdapter
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        // 이 함수가 호출될 때 호스팅 액티비티를 사용할 수 없거나 호스팅 액티비티가 계속 존재한다는 보장이 없기 때문에 null 입력
        callbacks = null
    }

    companion object {
        fun newInstance(): GalleryFragment {
            return GalleryFragment()
        }
    }
}