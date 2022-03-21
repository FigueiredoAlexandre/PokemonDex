package com.example.pokemondex.presentation.view.adapter

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemondex.R
import com.example.pokemondex.data.PokemonCategoryModel
import com.example.pokemondex.databinding.LayoutEletricCategoryCardBinding

class PokemonCategoryAdapter(
    val cardClickCallBack: (String) -> Unit
): RecyclerView.Adapter<PokemonCategoryAdapter.PokemonCategoryViewHolder>(){


    val arrayListOfCategories: ArrayList<PokemonCategoryModel> = arrayListOf()


    inner class PokemonCategoryViewHolder(val binding: LayoutEletricCategoryCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PokemonCategoryModel) {
            binding.apply {
                categoryIcon.setImageResource(item.resourceSymbol)
                categoryLabel.text = item.name
                expandArrow.setOnClickListener {
                    if (expandableInfo.visibility == View.GONE) {

                        TransitionManager.beginDelayedTransition(mainCardView, AutoTransition())
                        expandableInfo.visibility = View.VISIBLE
                        expandArrow.setImageResource(R.drawable.ic_baseline_expand_less_24)
                        attackPro.text = item.attackQualities.attackPros
                        attackCon.text = item.attackQualities.attackCons
                        defensePro.text = item.defenseQualities.defensePros
                        defenseCon.text = item.defenseQualities.defenseCons
                    } else {

                        TransitionManager.beginDelayedTransition(mainCardView, AutoTransition())
                        expandArrow.setImageResource(R.drawable.ic_baseline_expand_more_24)
                        expandableInfo.visibility = View.GONE
                    }
                }
                categoryContainer.setOnClickListener {
                    cardClickCallBack(item.name)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonCategoryViewHolder {
        return PokemonCategoryViewHolder(
            LayoutEletricCategoryCardBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonCategoryViewHolder, position: Int) {
        holder.bind(arrayListOfCategories[position])
    }

    override fun getItemCount(): Int {
        return arrayListOfCategories.size
    }

    fun updateAdapter(list: ArrayList<PokemonCategoryModel>) {
        arrayListOfCategories.clear()
        arrayListOfCategories.addAll(list)
        notifyDataSetChanged()
    }
}