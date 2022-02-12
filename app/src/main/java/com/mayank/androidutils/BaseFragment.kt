package com.mayank.androidutils

import android.content.Context
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

open class BaseFragment : Fragment() {

    var navigation: Navigation? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Navigation) navigation = context
    }

}