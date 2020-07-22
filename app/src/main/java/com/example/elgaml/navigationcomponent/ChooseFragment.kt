package com.example.elgaml.navigationcomponent

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose.*
import kotlinx.android.synthetic.main.fragment_specify_amount.*

/**
 * A simple [Fragment] subclass.
 */
class ChooseFragment : Fragment(),View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController= Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next_btn).setOnClickListener (this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener (this)

    }

    override fun onClick(p0: View?) {
        when (p0!!.id){
            R.id.next_btn-> {
                if (!TextUtils.isEmpty(input_recipient.text.toString())){
                val bundle= bundleOf("recipent" to input_recipient.text.toString())
                navController.navigate(R.id.action_chooseFragment_to_specifyAmountFragment,bundle)

                }
            }

            R.id.cancel_btn-> requireActivity().onBackPressed()
        }
    }
}
