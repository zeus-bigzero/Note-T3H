package edu.t3h.note.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.t3h.note.R
import edu.t3h.note.databinding.ItemImageBinding

class TutorialViewPagerAdapter() : RecyclerView.Adapter<TutorialViewPagerAdapter.TutorialViewPagerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorialViewPagerHolder {
        val binding : ItemImageBinding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TutorialViewPagerHolder(binding)
    }

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: TutorialViewPagerHolder, position: Int) {
        holder.bind(position)
    }

    inner class TutorialViewPagerHolder(private val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            when (position) {
                0 -> {
                    binding.img.setImageResource(R.drawable.tuto_01)

                }
                1 -> {
                    binding.img.setImageResource(R.drawable.tuto_02)
                }
                else -> {
                    binding.img.setImageResource(R.drawable.tuto_03)
                }
            }
        }
    }

}

