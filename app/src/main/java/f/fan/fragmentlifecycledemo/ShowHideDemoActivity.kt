package f.fan.fragmentlifecycledemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_demo.*

/**
 * Created by fan.feng on 2019/4/24.
 */
class ShowHideDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        val fragment1 = ShowHideFragment.newInstance("首页")
        val fragment2 = ShowHideFragment.newInstance("咨询")
        val fragment3 = ShowHideFragment.newInstance("反馈")
        val fragment4 = ShowHideFragment.newInstance("帮助")

        tvOne.setOnClickListener {
            Log.e(ShowHideFragment.TAG, "   ")
            Log.e(ShowHideFragment.TAG, "-----点击了首页-----")
            showFragment(fragment1)
        }

        tvTwo.setOnClickListener {
            Log.e(ShowHideFragment.TAG, "   ")
            Log.e(ShowHideFragment.TAG, "-----点击了咨询-----")
            showFragment(fragment2)
        }

        tvThree.setOnClickListener {
            Log.e(ShowHideFragment.TAG, "   ")
            Log.e(ShowHideFragment.TAG, "-----点击了反馈-----")
            showFragment(fragment3)
        }

        tvFor.setOnClickListener {
            Log.e(ShowHideFragment.TAG, "   ")
            Log.e(ShowHideFragment.TAG, "-----点击了帮助-----")
            showFragment(fragment4)
        }

        supportFragmentManager.beginTransaction()
                .add(R.id.flContent, fragment1)
                .add(R.id.flContent, fragment2)
                .add(R.id.flContent, fragment3)
                .add(R.id.flContent, fragment4)
                .show(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4)
                .commit()

        showFragment = fragment1
    }

    var showFragment: Fragment? = null

    private fun showFragment(fg: Fragment){

        supportFragmentManager.beginTransaction()
                .hide(showFragment!!)
                .show(fg)
                .commit()
        showFragment = fg
    }

}