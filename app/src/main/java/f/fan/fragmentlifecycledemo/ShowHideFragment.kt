package f.fan.fragmentlifecycledemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_test.*

/**
 * Created by fan.feng on 2019/4/24.
 */
class ShowHideFragment : Fragment() {

    companion object {

        val TAG = "ShowHideFragment"

        fun newInstance(tag: String): ShowHideFragment{

            var fragment = ShowHideFragment()

            fragment.mTag = tag
            return fragment
        }
    }

    private var mTag = ""
    //与show hide用到
    private var isRuningHiddenChanged = false
    private var isUserVisible = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e(TAG, "$mTag ===  onViewCreated")

        tvTest.text = "这是$mTag"
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "$mTag ===  onResume")
        if(!isRuningHiddenChanged){
            isRuningHiddenChanged = true
            isUserVisible = true
            onUserVisible()
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)

        //如果是隐藏
        if(hidden){
            if (isUserVisible){
                onUserInvisible()
            }
        } else {
            //如果是显示
            //并且是第一次显示
            onUserVisible()
            isUserVisible = true
        }

        isRuningHiddenChanged = true
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "$mTag ===  onPause")
    }


    fun onUserVisible(){
        Log.e(TAG, "$mTag ===  onUserVisible")
    }

    fun onUserInvisible(){
        Log.e(TAG, "$mTag ===  onUserInvisible")
    }

}