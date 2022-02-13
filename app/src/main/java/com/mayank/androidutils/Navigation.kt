package com.mayank.androidutils

import android.os.Bundle
import androidx.navigation.NavDirections

interface Navigation {
    fun openFragmentAndClearTill(directions: NavDirections, popUpTillFragmentId:Int = 0)
    fun openFragmentAndRemoveCurrent(directions: NavDirections)
    fun openFragmentAndClearAll(directions: NavDirections)
    fun openFragment(directions: NavDirections)

    fun goBack(bundle: Bundle? = null)
    fun detectBundleOnBackPressed(onDetect: (bundle: Bundle?) -> Unit)
}