package com.baharudin.loundryyuk.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.baharudin.loundryyuk.R
import com.baharudin.loundryyuk.databinding.FragmentSettingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : Fragment(R.layout.fragment_setting) {

    private var _binding : FragmentSettingBinding ?= null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentSettingBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }
}