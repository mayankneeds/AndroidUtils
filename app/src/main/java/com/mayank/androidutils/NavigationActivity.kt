package com.mayank.androidutils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import kotlin.properties.Delegates

open class NavigationActivity : AppCompatActivity(), Navigation {

    private val mKeyBundle = "key_bundle"

    private var navHostId by Delegates.notNull<Int>()
    private val navHostFragment by lazy { supportFragmentManager.findFragmentById(navHostId) as NavHostFragment }
    private val navController get() = navHostFragment.navController
    private val currentFragment get() = navHostFragment.childFragmentManager.fragments.first()
    private val backPressedListener get() = if (currentFragment is OnBackPressedListener) (currentFragment as OnBackPressedListener) else null

    fun setNavHosId(navHostId: Int) {
        this.navHostId = navHostId
    }

    override fun onBackPressed() {
        backPressedListener?.run { onBackPressed() }
            ?: if (!navController.popBackStack()) super.onBackPressed()
    }

    override fun detectBundleOnBackPressed(onDetect: (bundle: Bundle?) -> Unit) {
        val savedStateHandle = navController.currentBackStackEntry?.savedStateHandle
        savedStateHandle?.getLiveData<Bundle>(mKeyBundle)
            ?.observe(currentFragment.viewLifecycleOwner) {
                onDetect(it)
                savedStateHandle.clearSavedStateProvider(mKeyBundle)
            }
    }

    override fun openFragmentAndClearTill(
        directions: NavDirections,
        bundle: Bundle?,
        popUpTillFragmentId: Int
    ) {
        navController.navigate(
            directions.actionId,
            bundle,
            if (popUpTillFragmentId != 0) navOptions {
                popUpTo(popUpTillFragmentId) {
                    inclusive = true
                }
            } else null)
    }

    override fun openFragmentAndRemoveCurrent(directions: NavDirections, bundle: Bundle?) {
        openFragmentAndClearTill(directions, bundle, navController.currentDestination?.id ?: 0)
    }

    override fun openFragmentAndClearAll(directions: NavDirections, bundle: Bundle?) {
        openFragmentAndClearTill(directions, bundle, navController.graph.startDestinationId)
    }

    override fun openFragment(directions: NavDirections, bundle: Bundle?) {
        openFragmentAndClearTill(directions, bundle, 0)
    }

    override fun goBack(bundle: Bundle?) {
        bundle?.let {
            navController.previousBackStackEntry?.savedStateHandle?.set(
                mKeyBundle,
                bundle
            )
        }
        if (!navController.popBackStack()) super.onBackPressed()
    }

}