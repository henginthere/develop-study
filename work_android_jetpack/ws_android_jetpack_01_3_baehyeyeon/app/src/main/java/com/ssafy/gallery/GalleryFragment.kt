package com.ssafy.gallery

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.GridLayoutManager
import com.ssafy.gallery.databinding.FragmentGalleryBinding

private const val TAG = "GalleryFragment_싸피"

class GalleryFragment : Fragment() {

    private lateinit var ctx: Context
    private lateinit var binding: FragmentGalleryBinding

    private lateinit var photoViewModel: PhotoViewModel
    private lateinit var galleryDao: GalleryDao
    private lateinit var galleryAdapter: GalleryAdapter
    private lateinit var photo: Photo

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
        // SQLite 초기화
        initDB()
        photoViewModel = PhotoViewModel()
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

        // 갤러리 화면 갱신
        updateGallery()
    }

    private fun initDB(){
        Log.d(TAG, "initDB: ")

        galleryDao = GalleryDao()
        galleryDao.dbOpenHelper(ctx)
        galleryDao.open()
    }

    private fun updateGallery(){
        Log.d(TAG, "updateGallery: ")

        photoViewModel.photoList = galleryDao.selectAllPhotos()

        galleryAdapter = GalleryAdapter(ctx, photoViewModel.photoList)

        binding.rcvMain.apply {
            adapter = galleryAdapter
            layoutManager = GridLayoutManager(ctx, 3)
        }

        // 썸네일 클릭 시 Photo Fragment로 이동
        val itemClickListener = object : GalleryAdapter.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                Log.d(TAG, "onItemClick: $position")
                photo = photoViewModel.photoList[position]

                setFragmentResult("ItemClick", bundleOf("Photo" to photo))
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fcv_main, PhotoFragment())
                    .commit()
            }
        }

        galleryAdapter.onItemClickListener = itemClickListener
    }
}