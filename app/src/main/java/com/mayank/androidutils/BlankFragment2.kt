package com.mayank.androidutils

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


class BlankFragment2 : BaseFragment(), OnBackPressedListener {

    private val args: BlankFragment2Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view as FrameLayout).setBackgroundColor(Color.parseColor(args.color))

        view.findViewById<Button>(R.id.btn).setOnClickListener {
            navigation?.openFragment(BlankFragment2Directions.actionBlankFragment2ToBlankFragment(),R.id.blankFragment)
        }

    }

    override fun onBackPressed() {
        navigation?.goBack(
            bundleOf(
                BlankFragment.KEY_BTN_TEXT to "Came from fragment 2"
            )
        )
    }

}