package com.rikkeisoft.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rikkeisoft.myapplication.databinding.FragmentHomeBinding
import com.rikkeisoft.myapplication.define.EditItemRuleType
import com.rikkeisoft.myapplication.model.RuleModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val mViewModel: HomeViewModel by viewModels()

    private var mAdapter: RuleListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        mAdapter = RuleListAdapter(onClickItem = {
            mViewModel.onClickItemRule(it)
        }, onRemoveRule = {
            mViewModel.onClickRemoveRule(it)
        })
        binding.rcvRuleList.adapter = mAdapter

        binding.apply {
            btnRun.setOnClickListener {

            }

            btnAdd.setOnClickListener {
                mViewModel.onClickAddRule()
            }
        }

        mViewModel.ruleList.observe(viewLifecycleOwner) {
            mAdapter?.submitList(it)
        }

        mViewModel.mActionState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeActionState.EditItemRule -> {

                }

                is HomeActionState.AddItemRule -> {

                }
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        binding.rcvRuleList.adapter = null
        mAdapter = null
        super.onDestroyView()
        _binding = null
    }
}