package edu.t3h.note

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import edu.t3h.note.controller.Manager
import edu.t3h.note.databinding.FragmentCreateNoteBinding


class CreateNoteFragment : Fragment() {
    private var _binding : FragmentCreateNoteBinding? = null
    private val binding : FragmentCreateNoteBinding by lazy { requireNotNull(_binding) }
    private val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        listOf(
            Manifest.permission.READ_MEDIA_IMAGES,
            Manifest.permission.READ_MEDIA_VIDEO,
            Manifest.permission.READ_MEDIA_AUDIO
        )
    } else {
        listOf(Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    private val requestMultiPermissionResult =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            if (isGranted(permissions)) {
                openGallery()
            } else {
                Toast.makeText(requireContext(), "Bạn từ chối cấp quyền!", Toast.LENGTH_SHORT).show()
            }
        }

    private val requestGalleryResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it != null && it.resultCode == RESULT_OK){
            val params = binding.pageBody.layoutParams as LinearLayout.LayoutParams
            params.weight = 5f
            Log.d("NGHIA","${it.data?.data}")
            binding.img.setImageURI(it.data?.data)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (Manager.note != null) {
            binding.apply {
                pageTitle.text = SpannableStringBuilder(Manager.note!!.title)
                pageBody.text = SpannableStringBuilder(Manager.note!!.des)
                Manager.note = null
            }
        }

        binding.apply {
            btnBack.setOnClickListener{
                if (!binding.pageTitle.text.isNullOrEmpty() || !binding.pageBody.text.isNullOrEmpty()) {
                    AlertDialog.Builder(requireContext()).apply {
                        setTitle("Thông báo")
                        setMessage("Bạn có nội dung chưa lưu.Bạn có muốn lưu không?")
                        setPositiveButton("Có") { _, _ ->
                            saveContent()
                        }
                        setNegativeButton("Không") { _, _ ->
                            parentFragmentManager.beginTransaction()
                                .replace(R.id.container,HomeScreenFragment())
                                .commit()
                        }
                        show()
                    }
                } else {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container,HomeScreenFragment())
                        .commit()
                }
            }
            btnSave.setOnClickListener{
                saveContent()
            }
            btnAddImg.setOnClickListener {
                if (isGranted(permissions)) {
                    openGallery()
                } else {
                    requestMultiPermissionResult.launch(permissions.toTypedArray())
                }
            }
        }
    }

    private fun saveContent() {
        if (binding.pageTitle.text.isNullOrEmpty() || binding.pageBody.text.isNullOrEmpty()){
            Toast.makeText(requireContext(),"Vui lòng nhập đầy đủ Tiêu Đề và Nội Dung",Toast.LENGTH_SHORT).show()
        } else {
            Manager.des = binding.pageBody.text.toString()
            Manager.title = binding.pageTitle.text.toString()
            binding.pageBody.text = null
            binding.pageTitle.text = null
            parentFragmentManager.beginTransaction()
                .replace(R.id.container,HomeScreenFragment())
                .commit()
        }
    }

    private fun openGallery() {
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT
        requestGalleryResult.launch(i)
    }

    private fun isGranted(permissions: List<String>): Boolean {
        for (permission in permissions) {
            if (isDenied(permission)) return false
        }
        return true
    }

    private fun isGranted(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(), permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun isDenied(permission: String): Boolean {
        return !isGranted(permission)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}