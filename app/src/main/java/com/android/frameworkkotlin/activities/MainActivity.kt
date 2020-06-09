package com.android.frameworkkotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.view.View
import androidx.collection.ArraySet
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
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
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

/**
 * 首页MainActivity
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       Debug.startMethodTracing();
        setContentView(R.layout.activity_main)
        var adapter = ContentAdapter(supportFragmentManager,initFragments())
        vp_content.setAdapter(adapter)
        vp_content.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL)
        tabDatas.forEach{
            tl_bottom_control.addTab(tl_bottom_control.newTab().setText(it))
        }
        vp_content.registerOnPageChangeCallback(onPageChangeCallBack)
        tl_bottom_control.addOnTabSelectedListener(onTabSelectCallBack)
        Debug.startMethodTracing()
    }


    fun initFragments(): List<Fragment> {
        val homefragment = HomeFragment.instance
        val informationFragment = InformationFragment.instance
         val videoFragment=VideoFragment.instance
        val mineFragment=MineFragment.instance
        val fragments = listOf(homefragment,informationFragment,videoFragment,mineFragment)
        return fragments;
    }

    val onPageChangeCallBack=object :ViewPager2.OnPageChangeCallback(){

        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels)
        }

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            tl_bottom_control.getTabAt(position)?.select()
        }
    }
    val onTabSelectCallBack=object : TabLayout.OnTabSelectedListener{
        override fun onTabReselected(p0: TabLayout.Tab?) {
         println("onTabReselected-----"+p0?.position);
        }

        override fun onTabUnselected(p0: TabLayout.Tab?) {
            println("onTabUnselected-----"+p0?.position);

        }

        override fun onTabSelected(p0: TabLayout.Tab?) {
            println("onTabSelected-----"+p0?.position);
            p0?.position?.let { vp_content.setCurrentItem(it) }

        }
    }

}


