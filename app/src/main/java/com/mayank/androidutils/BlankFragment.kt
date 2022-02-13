package com.mayank.androidutils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


class BlankFragment : NavigationFragment() {

    companion object {
        val KEY_BTN_TEXT = "btn_text"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigation?.detectBundleOnBackPressed {
            it?.getString(KEY_BTN_TEXT)?.let {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                (view.findViewById(R.id.button) as Button).text = it
            }
        }

        (view.findViewById(R.id.button) as Button).setOnClickListener { _ ->
            navigation?.openFragment(
                BlankFragmentDirections.actionBlankFragmentToBlankFragment2("#FFCCFF")
            )
        }

    }

}