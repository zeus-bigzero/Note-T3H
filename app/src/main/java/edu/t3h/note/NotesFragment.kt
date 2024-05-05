package edu.t3h.note

import android.content.Context
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import edu.t3h.note.adapter.NoteAdapter
import edu.t3h.note.controller.Manager
import edu.t3h.note.databinding.FragmentNotesBinding
import edu.t3h.note.listener.OnNoteClickListener
import edu.t3h.note.model.NoteModel
import java.util.Date
import java.util.Locale


class NotesFragment : Fragment(), OnNoteClickListener {
    private var _binding: FragmentNotesBinding? = null
    private val binding: FragmentNotesBinding by lazy { requireNotNull(_binding) }
    private val list = arrayListOf<NoteModel>()
    private val adapter: NoteAdapter by lazy {
        NoteAdapter(list, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formatter = SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH)
        val date = Date()
        val current = formatter.format(date)
        binding.date.text = current

        val sharedPref = activity?.getSharedPreferences("appData", Context.MODE_PRIVATE)
        val notesData  = sharedPref?.getStringSet("notesData", null)
        if (!notesData.isNullOrEmpty()) {
            notesData.forEach {
                val content = it.replace("\n","@n_Line")
                val obj : NoteModel = Gson().fromJson(content,NoteModel::class.java)
                if (obj.des.contains("@n_Line",false)) {
                    obj.des = obj.des.replace("@n_Line","\n")
                }
                list.add(obj)
            }
        }

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return if (adapter?.getItemViewType(position) == 0) {
                            1
                        } else {
                            2
                        }
                    }
                }
            }
            adapter = this@NotesFragment.adapter
        }
    }

    override fun onResume() {
        super.onResume()
        if (Manager.des.isNotEmpty() && Manager.title.isNotEmpty()) {
            list.add(
                0,
                NoteModel(
                    System.currentTimeMillis(),
                    Manager.title,
                    Manager.des,
                    "8E8E92",
                    false,
                    false,
                    false
                )
            )
            saveFile()
            Manager.des = ""
            Manager.title = ""
            adapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickNote(note: NoteModel) {
        Manager.note = note
        parentFragmentManager.beginTransaction()
            .replace(R.id.container,CreateNoteFragment())
            .commit()
    }

    override fun onLongClickNote(note: NoteModel) {
        AlertDialog.Builder(requireContext()).apply {
            setTitle("Thông báo")
            setMessage("Bạn có có muốn xóa Note đang chọn không??")
            setPositiveButton("Có") { _, _ ->
                for (i in 0..<list.size) {
                    if (list[i].id == note.id) {
                        list.removeAt(i)
                        saveFile()
                        adapter.notifyDataSetChanged()
                        break
                    }
                }
            }
            setNegativeButton("Không") { _, _ ->
                //DO NOTHING
            }
            show()
        }

    }

    private fun saveFile() {
        val mutableSet = mutableSetOf<String>()
        list.forEach {
            mutableSet.add(it.toString())
        }
        val sharedPref = activity?.getSharedPreferences("appData", Context.MODE_PRIVATE)
        sharedPref!!.edit()!!.putStringSet("notesData", mutableSet)!!.apply()
    }
}

