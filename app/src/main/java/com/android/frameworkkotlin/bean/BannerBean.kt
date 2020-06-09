package com.android.frameworkkotlin.bean

/**
 * 当前类的注释:
 * 作者：WangLiJian on 2020/4/20.
 * 邮箱：wanglijian1214@gmail.com
 */
class BannerBean{
    /**
     * data : [{"image":"http://gank.io/images/cfb4028bfead41e8b6e34057364969d1","title":"干货集中营新版更新","url":"https://gank.io/migrate_progress"},{"image":"http://gank.io/images/aebca647b3054757afd0e54d83e0628e","title":"- 春水初生，春林初盛，春风十里，不如你。","url":"https://gank.io/post/5e51497b6e7524f833c3f7a8"},{"image":"https://pic.downk.cc/item/5e7b64fd504f4bcb040fae8f.jpg","title":"盘点国内那些免费好用的图床","url":"https://gank.io/post/5e7b5a8b6d2e518fdeab27aa"}]
     * status : 100
     */
    var status = 0
    var data: List<DataBean>? = null

    class DataBean {
        /**
         * image : http://gank.io/images/cfb4028bfead41e8b6e34057364969d1
         * title : 干货集中营新版更新
         * url : https://gank.io/migrate_progress
         */
        var image: String? = null
        var title: String? = null
        var url: String? = null
        override fun toString(): String {
            return "DataBean(image=$image, title=$title, url=$url)"
        }

    }

    override fun toString(): String {
        return "BannerBean(status=$status, data=$data)"
    }

}