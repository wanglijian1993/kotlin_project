package com.android.frameworkkotlin.home.bean

/**
 * 当前类的注释:首页相关实体类
 * 作者：WangLiJian on 2021/7/11.
 * 邮箱：wanglijian1214@gmail.com
 */

data class ArticleResponse<T>(
    val errorCode:Int,
    val errorMsg:String,
    val data:T
)

data class ArticleData(
    val curPage: Int,
    val datas: List<ArticleList>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)

data class ArticleList(
    val apkLink: String,
    val audit: Int,
    val author: String,
    val canEdit: Boolean,
    val chapterId: Int,
    val chapterName: String,
    val collect: Boolean,
    val courseId: Int,
    val desc: String,
    val descMd: String,
    val envelopePic: String,
    val fresh: Boolean,
    val host: String,
    val id: Int,
    val link: String,
    val niceDate: String,
    val niceShareDate: String,
    val origin: String,
    val prefix: String,
    val projectLink: String,
    val publishTime: Long,
    val realSuperChapterId: Int,
    val selfVisible: Int,
    val shareDate: Long,
    val shareUser: String,
    val superChapterId: Int,
    val superChapterName: String,
    val title: String,
    val type: Int,
    val userId: Int,
    val visible: Int,
    val zan: Int
)

