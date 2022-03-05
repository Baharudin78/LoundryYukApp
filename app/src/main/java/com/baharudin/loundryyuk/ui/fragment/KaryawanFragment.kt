package com.baharudin.loundryyuk.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.baharudin.loundryyuk.R
import com.baharudin.loundryyuk.databinding.FragmentKaryawanBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KaryawanFragment : Fragment(R.layout.fragment_karyawan) {

    private var _binding : FragmentKaryawanBinding ? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentKaryawanBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }
}