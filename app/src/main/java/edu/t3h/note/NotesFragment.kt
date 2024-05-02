package edu.t3h.note

import android.content.Context
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


class NotesFragment : Fragment() {
    private var _binding: FragmentNotesBinding? = null
    private val binding: FragmentNotesBinding by lazy { requireNotNull(_binding) }
    private val list = arrayListOf<NoteModel>()
    private val adapter: NoteAdapter by lazy {
        NoteAdapter(list,
            object : OnNoteClickListener {
                override fun onClickNote(note: NoteModel) {
                    TODO("Not yet implemented")
                }

                override fun onLongClickNote(note: NoteModel) {
                    TODO("Not yet implemented")
                }
            })
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
        Log.d("NGHIA",notesData.toString())
        if (!notesData.isNullOrEmpty()) {
            notesData.forEach {
                list.add(Gson().fromJson(it,NoteModel::class.java))
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
            val mutableSet = mutableSetOf<String>()
            list.forEach {
                mutableSet.add(it.toString())
            }
            val sharedPref = activity?.getSharedPreferences("appData", Context.MODE_PRIVATE)
            sharedPref!!.edit()!!.putStringSet("notesData", mutableSet)!!.apply()
            Manager.des = ""
            Manager.title = ""
            adapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

