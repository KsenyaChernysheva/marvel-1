package com.example.xenya.marvel.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.xenya.marvel.R
import com.example.xenya.marvel.entities.Result
import com.example.xenya.marvel.utils.STANDARD_SMALL
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_character.view.*

class MarvelListAdapter(
        val list: List<Result?>,
        val onClick: (Int, View) -> Unit
) : RecyclerView.Adapter<MarvelListAdapter.MarvelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelViewHolder =
            MarvelViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
        holder.bind(list[position], onClick)
    }

    class MarvelViewHolder(
            override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(character: Result?, onClick: (Int, View) -> Unit) = with(containerView) {
            tv_name_character.text = character?.name
            Glide.with(this)
                    .load(getImagePath(character))
                    .placeholder(R.mipmap.ic_launcher)
                    .into(iv_character)

            character?.let { result ->
                setOnClickListener {
                    onClick(result.id, iv_character)
                }
            }
        }

        private fun getImagePath(character: Result?) =
                character?.thumbnail?.path + STANDARD_SMALL + character?.thumbnail?.extension
    }
}
