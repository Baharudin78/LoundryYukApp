package com.baharudin.loundryyuk.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.baharudin.loundryyuk.R
import com.baharudin.loundryyuk.databinding.FragmentTransaksiBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TransaksiFragment : Fragment(R.layout.fragment_transaksi) {

    private var _binding : FragmentTransaksiBinding ? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentTransaksiBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }
}