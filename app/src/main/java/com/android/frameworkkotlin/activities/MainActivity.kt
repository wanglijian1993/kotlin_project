package com.android.frameworkkotlin.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.android.frameworkkotlin.R
import com.android.frameworkkotlin.adapter.ContentAdapter
import com.android.frameworkkotlin.base.BaseActivity
import com.android.frameworkkotlin.fragments.HomeFragment
import com.android.frameworkkotlin.fragments.InformationFragment
import com.android.frameworkkotlin.fragments.MineFragment
import com.android.frameworkkotlin.fragments.VideoFragment
import com.android.frameworkkotlin.utils.tabDatas
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 首页MainActivity
 */
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
        val adapter = ContentAdapter(this,initFragments())
        vp_content.adapter = adapter
        vp_content.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        tabDatas.forEach{
            tl_bottom_control.addTab(tl_bottom_control.newTab().setText(it))
        }
        vp_content.registerOnPageChangeCallback(onPageChangeCallBack)
        tl_bottom_control.addOnTabSelectedListener(onTabSelectCallBack)
    }


    fun initFragments(): List<Fragment> {
        val homefragment = HomeFragment.instance
        val informationFragment = InformationFragment.instance
         val videoFragment=VideoFragment.instance
        val mineFragment=MineFragment.instance
        val fragments = listOf(homefragment,informationFragment,videoFragment,mineFragment)
        return fragments
    }

    val onPageChangeCallBack=object :ViewPager2.OnPageChangeCallback(){

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            tl_bottom_control.getTabAt(position)?.select()
        }
    }
    val onTabSelectCallBack=object : TabLayout.OnTabSelectedListener{
        override fun onTabReselected(p0: TabLayout.Tab?) {
         println("onTabReselected-----"+p0?.position)
        }

        override fun onTabUnselected(p0: TabLayout.Tab?) {
            println("onTabUnselected-----"+p0?.position)

        }

        override fun onTabSelected(p0: TabLayout.Tab?) {
            println("onTabSelected-----"+p0?.position)
            p0?.position?.let { vp_content.currentItem = it
            }

        }
    }

}


