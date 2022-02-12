package com.mayank.androidutils

import android.os.Bundle
import androidx.navigation.NavDirections

interface Navigation {
    fun openFragment(directions: NavDirections)
    fun goBack(bundle: Bundle? = null)
    fun detectBundleOnBackPressed(onDetect: (bundle: Bundle?) -> Unit)
}