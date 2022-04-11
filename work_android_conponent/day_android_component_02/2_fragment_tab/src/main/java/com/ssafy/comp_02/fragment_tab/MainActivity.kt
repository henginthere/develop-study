package com.ssafy.comp_02.fragment_tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.ssafy.comp_02.fragment_tab.databinding.ActivityMainBinding
import com.ssafy.comp_02.fragment_tab.databinding.FragmentTabItem1Binding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        replaceFragment(TabItem1Fragment())

        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            tabLayoutMain.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val selectedFragment = when (tab!!.position){
                        0 -> TabItem1Fragment()
                        1 -> TabItem2Fragment()
                        2 -> TabItem3Fragment()
                        3 -> TabItem4Fragment()
                        4 -> TabItem5Fragment()
                        else -> null
                    }
                    replaceFragment(selectedFragment!!)
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

            })
        }
    }

    private fun replaceFragment(f: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout_main,f)
            .commit()
    }
}

