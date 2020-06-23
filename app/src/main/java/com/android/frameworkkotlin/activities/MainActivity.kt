package com.android.frameworkkotlin.activities

import android.os.Bundle
import com.android.frameworkkotlin.R
import com.android.frameworkkotlin.base.BaseActivity
import com.android.frameworkkotlin.fragments.HomeFragment
import com.android.frameworkkotlin.fragments.InformationFragment
import com.android.frameworkkotlin.fragments.MineFragment
import com.android.frameworkkotlin.fragments.VideoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 首页MainActivity
 */
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListner()
    }

    fun initListner() {
        bnvBottomMenu.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            onTabItemSelected(item.itemId)
            true
        })

    }

    private fun onTabItemSelected(id: Int) {
        when (id) {
            R.id.menu_main_bottom_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.flContent, HomeFragment.instance).commit()
            R.id.menu_main_bottom_information -> supportFragmentManager.beginTransaction()
                .replace(R.id.flContent, InformationFragment.instance).commit()
            R.id.menu_main_botton_video -> supportFragmentManager.beginTransaction()
                .replace(R.id.flContent, VideoFragment.instance).commit()
            R.id.menu_main_botton_mine -> supportFragmentManager.beginTransaction()
                .replace(R.id.flContent, MineFragment.instance).commit()
            else -> {
            }
        }
    }


}


