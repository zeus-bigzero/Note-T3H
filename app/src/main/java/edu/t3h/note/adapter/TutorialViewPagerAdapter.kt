package edu.t3h.note.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.t3h.note.databinding.ItemImageBinding

class TutorialViewPagerAdapter(val context : Context) : RecyclerView.Adapter<TutorialViewPagerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorialViewPagerHolder {
        val binding : ItemImageBinding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TutorialViewPagerHolder(binding)
    }

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: TutorialViewPagerHolder, position: Int) {

        fun getDrawableFromAsset(fileName: String?): Drawable? {
            val assetManager = context.assets
            val inputStream = assetManager.open(fileName!!)
            return Drawable.createFromStream(inputStream, null)
        }
        when (position) {
            0 -> {
                holder.binding.img.setImageDrawable(getDrawableFromAsset("tuto_01.png"))

            }
            1 -> {
                holder.binding.img.setImageDrawable(getDrawableFromAsset("tuto_02.png"))
            }
            else -> {
                holder.binding.img.setImageDrawable(getDrawableFromAsset("tuto_03.png"))
            }
        }
    }

}

class TutorialViewPagerHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {

}