package com.android.frameworkkotlin.ext

import java.lang.reflect.ParameterizedType


/**
 * 当前绑定的泛型
 */
@Suppress("UNCHECKED_CAST")
fun <VB> getVbClazz(obj: Any,index:Int): Class<VB> {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[index] as Class<VB>
}