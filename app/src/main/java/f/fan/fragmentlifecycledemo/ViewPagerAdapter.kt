package f.fan.fragmentlifecycledemo

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by fan.feng on 2019/4/24.
 */
class ViewPagerAdapter : FragmentStatePagerAdapter {

    var datas: ArrayList<Fragment>? = null

    constructor(fm: FragmentManager, datas: ArrayList<Fragment>): super(fm){
        this.datas = datas
    }

    override fun getItem(position: Int) = datas!![position]

    override fun getCount() = datas?.size ?:0

}