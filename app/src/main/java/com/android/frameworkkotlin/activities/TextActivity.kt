package com.android.frameworkkotlin.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import com.android.frameworkkotlin.R
import com.android.frameworkkotlin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_text.*
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class TextActivity : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
        button.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)

    }


    fun main() {
        //GlobalScope协程的生命周期只受整个应用程序的生命周期限制
//        GlobalScope.launch {//在后台启动一个新的协程并继续
//            delay(1000)//非阻塞等待一秒钟(默认时间单位是毫秒)
//            println("World!") //在延迟后打印输出
//        }
//        println("hello,")//协程已等待时主线程还在继续
//        Thread.sleep(2000L) //阻塞主线程2秒来保证JVM存活


        println("main:" + Thread.currentThread())
        println("开始") // 主线程中的代码会立即执行

        GlobalScope.launch { // 在后台启动一个新的协程并继续
            println("-GlobalScope.launch:" + Thread.currentThread())
            delay(1000L)
            println("World!")
        }
        println("Hello,") // 主线程中的代码会立即执行
        runBlocking {     // 但是这个表达式阻塞了主线程
            println("runBlocking--thread:" + Thread.currentThread())
            delay(2000L)  // ……我们延迟 2 秒来保证 JVM 的存活
            Thread.sleep(2000L)
        }
        GlobalScope.launch { // 在后台启动一个新的协程并继续
            println("-GlobalScope.launch:" + Thread.currentThread())
            delay(1000L)
            println("结束!")
        }
    }

    fun main1() = runBlocking<Unit> {
        GlobalScope.launch {
            delay(1000L)
            println("World!")
        }
        println("hello,")
        delay(2000L)
    }

     fun join()= runBlocking {

        val job = GlobalScope.launch {
            delay(1000L)
            println("World~")
        }

        println("hello,")
        job.join()
        println("-----结束")
    }


    fun joinWait()= runBlocking{
        val job = launch {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(1300L) // 延迟一段时间
        println("main: I'm tired of waiting!")
//        job.cancel() // 取消该作业
//        job.join() // 等待作业执行结束
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }
    fun joinWait1()= runBlocking{
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (isActive) { // 可以被取消的计算循环
                // 每秒打印消息两次
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L) // 等待一段时间
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // 取消该作业并等待它结束
        println("main: Now I can quit.")
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button -> main()
            R.id.button1 -> main1()
            R.id.button2 -> join()
            R.id.button3 -> joinWait1()
        }
    }

}