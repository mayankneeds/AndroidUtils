package com.mayank.androidutils

import android.os.Bundle
import androidx.navigation.NavDirections

interface Navigation {
    fun openFragmentAndClearTill(directions: NavDirections, bundle: Bundle?=null, popUpTillFragmentId: Int)
    fun openFragmentAndRemoveCurrent(directions: NavDirections, bundle: Bundle?=null)
    fun openFragmentAndClearAll(directions: NavDirections, bundle: Bundle?=null)
    fun openFragment(directions: NavDirections, bundle: Bundle?=null)

    fun goBack(bundle: Bundle? = null)
    fun detectBundleOnBackPressed(onDetect: (bundle: Bundle?) -> Unit)
}