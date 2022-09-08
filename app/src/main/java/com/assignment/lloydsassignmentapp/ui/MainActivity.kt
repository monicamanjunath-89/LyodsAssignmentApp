package com.assignment.lloydsassignmentapp.ui

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.lifecycle.ViewModelProvider
import com.assignment.lloydsassignmentapp.R
import com.assignment.lloydsassignmentapp.base.BaseActivity
import com.assignment.lloydsassignmentapp.databinding.ActivityMainBinding
import com.assignment.lloydsassignmentapp.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override val viewmodel: MainActivityViewModel
        get() = ViewModelProvider(this)[MainActivityViewModel::class.java]

    override fun getBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}