package com.rikkeisoft.myapplication.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.rikkeisoft.myapplication.R
import com.rikkeisoft.myapplication.databinding.FragmentEditItemRuleDialogBinding
import com.rikkeisoft.myapplication.define.EditItemRuleType
import com.rikkeisoft.myapplication.model.RuleModel

class EditItemRuleDialogFragment : DialogFragment() {

    private var _binding: FragmentEditItemRuleDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NORMAL, R.style.EditItemRuleTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.apply {
            btnSave.setOnClickListener {

            }
        }

        return inflater.inflate(R.layout.fragment_edit_item_rule_dialog, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(type: EditItemRuleType, itemRule: RuleModel? = null) =
            EditItemRuleDialogFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}

interface EditItemRuleDialogListener{

}