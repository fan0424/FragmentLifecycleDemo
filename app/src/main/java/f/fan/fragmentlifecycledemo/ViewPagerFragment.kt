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
class ViewPagerFragment : Fragment() {

    companion object {

        val TAG = "ViewPagerFragment"

        fun newInstance(tag: String): ViewPagerFragment{

            var fragment = ViewPagerFragment()

            fragment.mTag = tag
            return fragment
        }
    }

    private var mTag = ""
    private var isFirstResume = true
    private var isFirstVisible = true
    private var isUserVisible = false
    private var isPrepared: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e(ViewPagerFragment.TAG, "$mTag ===  onViewCreated")

        tvTest.text = "这是$mTag"
    }

    override fun onResume() {
        super.onResume()

        if (isFirstResume) {
            isFirstResume = false
            return
        }

        if (userVisibleHint) {
            isUserVisible = true
            onUserVisible()
        }

    }

    override fun onPause() {
        super.onPause()

        if (isFirstResume) {
            isFirstResume = false
            return
        }
        if (userVisibleHint) {
            if(isUserVisible){
                isUserVisible = false
                onUserInvisible()
            }
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initPrepare()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false
                initPrepare()
            } else {
                isUserVisible = true
                onUserVisible()
            }
        } else {
            if(isUserVisible){
                isUserVisible = false
                onUserInvisible()
            }
        }
    }

    private fun initPrepare() {
        if (isPrepared) {
            isUserVisible = true
            onUserVisible()
        } else {
            isPrepared = true
        }
    }

    open fun onUserVisible() {
        Log.e(ViewPagerFragment.TAG, "$mTag ===  onUserVisible")
    }

    open fun onUserInvisible() {
        Log.e(ViewPagerFragment.TAG, "$mTag ===  onUserInvisible")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        isFirstResume = true
        isFirstVisible = true

        isUserVisible = false
        isPrepared = false
    }

}