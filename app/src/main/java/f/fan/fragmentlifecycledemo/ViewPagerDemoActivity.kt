package f.fan.fragmentlifecycledemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_demo.*

/**
 * Created by fan.feng on 2019/4/24.
 */
class ViewPagerDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        val fragment1 = ViewPagerFragment.newInstance("首页")
        val fragment2 = ViewPagerFragment.newInstance("咨询")
        val fragment3 = ViewPagerFragment.newInstance("反馈")
        val fragment4 = ViewPagerFragment.newInstance("帮助")

        var fragments = ArrayList<Fragment>()

        fragments.add(fragment1)
        fragments.add(fragment2)
        fragments.add(fragment3)
        fragments.add(fragment4)

        tvOne.setOnClickListener {
            Log.e(ViewPagerFragment.TAG, "   ")
            Log.e(ViewPagerFragment.TAG, "-----点击了首页-----")
            vpContent?.currentItem = 0
        }

        tvTwo.setOnClickListener {
            Log.e(ViewPagerFragment.TAG, "   ")
            Log.e(ViewPagerFragment.TAG, "-----点击了咨询-----")
            vpContent?.currentItem = 1
        }

        tvThree.setOnClickListener {
            Log.e(ViewPagerFragment.TAG, "   ")
            Log.e(ViewPagerFragment.TAG, "-----点击了反馈-----")
            vpContent?.currentItem = 2
        }

        tvFor.setOnClickListener {
            Log.e(ViewPagerFragment.TAG, "   ")
            Log.e(ViewPagerFragment.TAG, "-----点击了帮助-----")
            vpContent?.currentItem = 3
        }

        vpContent.adapter = ViewPagerAdapter(supportFragmentManager, fragments)
    }

}