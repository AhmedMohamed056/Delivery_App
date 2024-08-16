package com.ahmed.app3

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.ahmed.app3.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private var visiblefragment:Fragment?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        window.statusBarColor=ContextCompat.getColor(this,R.color.white)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentB()).commit()
        setupviewpager()
        changebtntxtdependentonpager()
        tabiconstate()
        binding.btnnext.setOnClickListener {
            binding.pager.currentItem+=1
            //change button text
            //changebtntxt()
        }

    }

    private fun tabiconstate() {
        binding.tablay.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.icon=null
                binding.tablay.setSelectedTabIndicator(R.drawable.tabselectback)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.icon=ContextCompat.getDrawable(this@MainActivity,R.drawable.circle_svgrepo_com)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                tab?.icon=null
            }
        })
    }


    private fun changebtntxtdependentonpager() {
        binding.pager.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                //to move tab with move viewpager
//                binding.tablay.selectTab(binding.tablay.getTabAt(position))
                //to change button text
                if (position==2){
                    binding.btnnext.text="Proceed"
                }else{
                    binding.btnnext.text="Next"
                }
            }
        })
    }


//    private fun changebtntxt() {
//        // get fragment on activity
//        visiblefragment = supportFragmentManager.fragments.find {
//            it.isVisible
//        }
//        visiblefragment?.let {
//            when(it){
//                is FragmentC->{binding.btnnext.text="proceed"}
//            }
//        }
//    }

    private fun setupviewpager() {
        val adapter=viewPagerAdapter(this)
        binding.pager.adapter=adapter
//        binding.tablay.addTab(binding.tablay.newTab().setIcon(R.drawable.circle_svgrepo_com))
//        binding.tablay.addTab(binding.tablay.newTab().setIcon(R.drawable.circle_svgrepo_com))
//        binding.tablay.addTab(binding.tablay.newTab().setIcon(R.drawable.circle_svgrepo_com))
        TabLayoutMediator(binding.tablay,binding.pager){tab,postion->
            if (postion>=0){
                tab.setIcon(R.drawable.circle_svgrepo_com)
            }
        }.attach()

    }

    fun hidesplashscreen() {
        //I give him id of layout that i set fragment on it
        supportFragmentManager.findFragmentById(R.id.fragment_container)?.let {
            supportFragmentManager.beginTransaction().remove(it).commit()
        }
    }


}