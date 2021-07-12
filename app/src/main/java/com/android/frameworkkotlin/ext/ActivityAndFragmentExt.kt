package com.android.frameworkkotlin.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


fun <T : ViewModel> obtainViewModel(acitivty: AppCompatActivity, viewModelClass: Class<T>) =
    ViewModelProvider(acitivty).get(viewModelClass)


fun <T : ViewModel> obtainViewModel(fragment: Fragment, viewModelClass: Class<T>) =
    ViewModelProvider(fragment).get(viewModelClass)
