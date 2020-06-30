package com.android.frameworkkotlin.activities

import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Lifecycle
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
    private var mHomeFragment: HomeFragment? = null
    private var mInformationFragment: InformationFragment? = null
    private var mVideoFragment: VideoFragment? = null
    private var mMineFragment: MineFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onTabItemSelected(R.id.menu_main_bottom_home)
        initListner()
    }

    fun initListner() {
        bnvBottomMenu.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            onTabItemSelected(item.itemId)
            true
        })

    }

    private fun onTabItemSelected(id: Int) {
        var transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (id) {
            R.id.menu_main_bottom_home -> mHomeFragment?.let {
                transaction.show(it)
                transaction.setMaxLifecycle(it,Lifecycle.State.STARTED)
            } ?: HomeFragment.instance.let {
                mHomeFragment = it
                transaction.add(R.id.flContent, it, "home")
                transaction.setMaxLifecycle(it,Lifecycle.State.STARTED)
            }

            R.id.menu_main_bottom_information ->
                mInformationFragment?.let {
                    transaction.show(it)
                    transaction.setMaxLifecycle(it,Lifecycle.State.STARTED)
               } ?: InformationFragment.instance.let {
                    mInformationFragment = it
                    transaction.add(R.id.flContent, it, "information")
                    transaction.setMaxLifecycle(it,Lifecycle.State.STARTED)
                }
            R.id.menu_main_botton_video ->
                mVideoFragment?.let {
                    transaction.show(it)
                    transaction.setMaxLifecycle(it,Lifecycle.State.STARTED)
              } ?: VideoFragment.instance.let {
                    mVideoFragment = it
                    transaction.add(R.id.flContent, it, "video")
                    transaction.setMaxLifecycle(it,Lifecycle.State.STARTED)
                }
            R.id.menu_main_botton_mine ->
                mMineFragment?.let {
                    transaction.show(it)
                    transaction.setMaxLifecycle(it,Lifecycle.State.STARTED)
                } ?: MineFragment.instance.let {
                    mMineFragment = it
                    transaction.add(R.id.flContent, it, "mine")
                    transaction.setMaxLifecycle(it,Lifecycle.State.STARTED)

                }
            else -> {
            }
        }
        transaction.commit()
    }

    /**
     * 隐藏所有的Fragment
     * @param transaction transaction
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mInformationFragment?.let { transaction.hide(it) }
        mVideoFragment?.let { transaction.hide(it) }
        mMineFragment?.let { transaction.hide(it) }
    }

}


