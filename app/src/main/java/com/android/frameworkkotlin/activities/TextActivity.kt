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
        button4.setOnClickListener(this)
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

    fun  lengthOfLongestSubstring(s:String):Int{
        // 哈希集合，记录每个字符是否出现过
        val occ:Set<Char> = setOf()
        val n = s.length
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        var rk:Int = -1
        var ans:Int = 0
        for (i in 1.. s.length) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.minus(s[i - 1]);
            }
            while (rk + 1 < n &&!occ.contains(s.get(rk + 1))) {
                // 不断地移动右指针
                occ.plus(s[rk + 1]);
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        println("value:")
        occ.forEach{
            println("char:$it")
        }
        println("length:"+ans)

        return ans
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button -> main()
            R.id.button1 -> main1()
            R.id.button2 -> join()
            R.id.button3 -> joinWait1()
            R.id.button4 ->lengthOfLongestSubstring(button4.text.toString())
        }
    }

}