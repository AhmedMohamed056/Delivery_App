package com.ahmed.app3

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmed.app3.databinding.FragmentBBinding

class FragmentB : Fragment() {
    private lateinit var binding:FragmentBBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentBBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val handler= Handler(Looper.getMainLooper())
        handler.postDelayed({
            val activity=activity as MainActivity
            activity.hidesplashscreen()
        },3000)
    }


    companion object {

    }
}