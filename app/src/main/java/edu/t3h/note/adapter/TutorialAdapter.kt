package edu.t3h.note.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.t3h.note.R
import edu.t3h.note.databinding.ItemTutorialBinding

class TutorialAdapter : RecyclerView.Adapter<TutorialViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorialViewHolder {
// Use for TutorialViewHolderV2
//        val view =
//            LayoutInflater.from(parent.context).inflate(R.layout.item_tutorial, parent, false)

        val binding: ItemTutorialBinding =
            ItemTutorialBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TutorialViewHolder(binding)
    }

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: TutorialViewHolder, position: Int) {
        when (position) {
            0 -> {
                holder.binding.img.setImageResource(R.drawable.splash1)
            }
            1 -> {
                holder.binding.img.setImageResource(R.drawable.splash2)
            }
            else -> {
                holder.binding.img.setImageResource(R.drawable.splash3)
            }
        }
    }

}

//class TutorialViewHolderV2(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//}

class TutorialViewHolder(val binding: ItemTutorialBinding) : RecyclerView.ViewHolder(binding.root)