package com.mayank.androidutils

import android.os.Bundle

class SampleActivity : NavigationActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        setNavHosId(R.id.nav_host_fragment)
    }

}