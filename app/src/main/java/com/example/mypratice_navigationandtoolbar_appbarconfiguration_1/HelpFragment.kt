package com.example.mypratice_navigationandtoolbar_appbarconfiguration_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mypratice_navigationandtoolbar_appbarconfiguration_1.databinding.FragmentHelpBinding


class HelpFragment : Fragment() {
    private lateinit var binding: FragmentHelpBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentHelpBinding.inflate(inflater, container, false)
        return binding.root
    }

}