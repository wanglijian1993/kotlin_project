package com.android.frameworkkotlin.ext

import java.lang.reflect.ParameterizedType


/**
 * 当前绑定的泛型
 */
@Suppress("UNCHECKED_CAST")
fun <VM> getVmClazz(obj: Any): VM {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}