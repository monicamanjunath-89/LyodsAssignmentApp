package com.assignment.lloydsassignmentapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

/**
 * Abstract Fragment which binds [ViewModel] [VM] and [ViewBinding] [VB]
 */
abstract class BaseFragment<VM : ViewModel, VB : ViewBinding> : Fragment() {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    protected abstract val viewmodel: VM
    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding()
        return binding.root
    }

    abstract fun getViewBinding(): VB
}
