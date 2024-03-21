package edu.t3h.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.t3h.note.databinding.ItemTutorialBinding
import edu.t3h.note.databinding.ItemTutorialV2Binding

class TutorialAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        if (position % 2 == 0) return 0
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val binding: ItemTutorialBinding =
                ItemTutorialBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return TutorialViewHolder(binding)
        }

        val bindingV2: ItemTutorialV2Binding =
            ItemTutorialV2Binding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TutorialViewHolderV2(bindingV2)
    }

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TutorialViewHolder) {
            if (position == 0) {
                holder.binding.img.setImageResource(R.drawable.tuto_01)
            } else {
                holder.binding.img.setImageResource(R.drawable.tuto_03)
            }
        }
        if (holder is TutorialViewHolderV2) {
            holder.binding.img.setImageResource(R.drawable.tuto_02)
        }
    }
}

class TutorialViewHolderV2(
    val binding: ItemTutorialV2Binding
) : RecyclerView.ViewHolder(binding.root)

class TutorialViewHolder(
    val binding: ItemTutorialBinding
) : RecyclerView.ViewHolder(binding.root)