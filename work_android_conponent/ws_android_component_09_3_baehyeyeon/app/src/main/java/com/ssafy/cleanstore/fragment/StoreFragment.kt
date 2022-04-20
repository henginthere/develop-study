package com.ssafy.cleanstore.fragment

import android.Manifest
import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.ssafy.cleanstore.databinding.FragmentStoreBinding
import com.ssafy.cleanstore.stuff.StuffActivity

private const val TAG="StoreFragment_싸피"
class StoreFragment : Fragment() {

    private lateinit var binding: FragmentStoreBinding

    private lateinit var ctx: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.storeInfo1.setOnClickListener {
            val intent = Intent(ctx, StuffActivity::class.java)
            startActivity(intent)
        }

        binding.btnAddContact.setOnClickListener {
            val permissionlistener = object : PermissionListener {

                override fun onPermissionGranted() {
                    var storeName = binding.tvName.text.toString()
                    var storeTel = binding.tvTel.text.toString()
                    addContacts(storeName, storeTel)
                }

                override fun onPermissionDenied(deniedPermissions: List<String>) {
                    Toast.makeText(ctx,
                        "연락처 접근 권한을 허가해주세요",
                        Toast.LENGTH_SHORT)
                        .show()
                }
            }

            TedPermission.create()
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("권한을 허용해주세요. [설정] > [앱 및 알림] > [고급] > [앱 권한]")
                .setPermissions(Manifest.permission.WRITE_CONTACTS)
                .check()

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach: ")
    }

    private fun addContacts(storeName: String, storeTel: String) {
        val p = ContentValues()
        p.put(ContactsContract.RawContacts.ACCOUNT_TYPE, "com.google")
        p.put(ContactsContract.RawContacts.ACCOUNT_NAME, "ssafy")
        val rowContact = ctx.contentResolver.insert(ContactsContract.RawContacts.CONTENT_URI, p)
        val rawContactId = ContentUris.parseId(rowContact!!)

        // 연락처의 이름 지정
        val value = ContentValues()
        value.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId)
        value.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
        value.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, storeName)
        ctx.contentResolver.insert(ContactsContract.Data.CONTENT_URI, value)

        // 연락처의 전화번호 지정
        val ppv = ContentValues()
        ppv.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId)
        ppv.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
        ppv.put(ContactsContract.CommonDataKinds.Phone.NUMBER, storeTel)
        ppv.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
        ctx.contentResolver.insert(ContactsContract.Data.CONTENT_URI, ppv)

        Toast.makeText(ctx,"$storeName 연락처가 저장되었습니다.", Toast.LENGTH_SHORT).show()
    }

}