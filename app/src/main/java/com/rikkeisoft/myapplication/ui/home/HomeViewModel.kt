package com.rikkeisoft.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rikkeisoft.myapplication.base.SingleLiveEvent
import com.rikkeisoft.myapplication.model.RuleModel

class HomeViewModel : ViewModel() {

    val mActionState = SingleLiveEvent<HomeActionState>()

    private var mRuleList = arrayListOf<RuleModel>()
    private val _ruleList = MutableLiveData<ArrayList<RuleModel>>()
    val ruleList : LiveData<ArrayList<RuleModel>> get() = _ruleList

    init { _ruleList.value = mRuleList }

    fun onClickItemRule(position: Int) {
        mActionState.value = HomeActionState.EditItemRule(mRuleList[position])
    }

    fun onClickAddRule() {
        mActionState.value = HomeActionState.AddItemRule
    }

    fun onClickRemoveRule(position: Int) {
        mRuleList.removeAt(position)
        _ruleList.value = mRuleList
    }

    fun handleAddRuleSuccess(rule: RuleModel) {
        mRuleList.add(rule)
        _ruleList.value = mRuleList
    }
}

sealed class HomeActionState {
    class EditItemRule(val item: RuleModel) : HomeActionState()
    data object AddItemRule : HomeActionState()
}