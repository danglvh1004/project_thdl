package com.rikkeisoft.myapplication.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rikkeisoft.myapplication.R
import com.rikkeisoft.myapplication.databinding.ItemRuleBinding
import com.rikkeisoft.myapplication.model.RuleModel

class RuleListAdapter(
    private val onClickItem: (Int) -> Unit,
    private val onRemoveRule: (Int) -> Unit
) :
    ListAdapter<RuleModel, RuleListAdapter.RuleViewHolder>(RuleDiffUtil()) {
    class RuleViewHolder(
        private val binding: ItemRuleBinding,
        private val onClickItem: (Int) -> Unit,
        private val onRemoveRule: (Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.apply {
                root.setOnClickListener {
                    onClickItem.invoke(adapterPosition)
                }

                ivRemove.setOnClickListener {
                    onRemoveRule.invoke(adapterPosition)
                }
            }
        }

        fun bind(item: RuleModel) {
            binding.apply {
                tvElement.text = item.element
                tvStart.text = item.startRule
                tvEnd.text = item.endRule
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RuleViewHolder =
        RuleViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_rule,
                parent,
                false
            ), onClickItem, onRemoveRule
        )

    override fun onBindViewHolder(holder: RuleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: MutableList<RuleModel>?) {
        val result = arrayListOf<RuleModel>()
        list?.forEach { result.add(it.copy()) }
        super.submitList(result)
    }
}

class RuleDiffUtil : DiffUtil.ItemCallback<RuleModel>() {
    override fun areItemsTheSame(oldItem: RuleModel, newItem: RuleModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: RuleModel, newItem: RuleModel): Boolean =
        oldItem == newItem
}