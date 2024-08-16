package com.ahmed.app3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmed.app3.databinding.FragmentDBinding


class FragmentD : Fragment() {
    private lateinit var binding: FragmentDBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {

    }
}