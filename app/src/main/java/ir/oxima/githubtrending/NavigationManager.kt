package ir.oxima.githubtrending

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class NavigationManager {

    interface NavigationListener {
        fun onBackstackChanged()
    }

    private constructor(){

    }

    companion object {
        private val mInstance: NavigationManager = NavigationManager()

        @Synchronized
        fun getInstance(): NavigationManager {
            return mInstance
        }
    }


    private var mFragmentManager: FragmentManager? = null
    private var mNavigationListener: NavigationListener? = null

    fun init(fragmentManager: FragmentManager) {
        mFragmentManager = fragmentManager
        mFragmentManager!!.addOnBackStackChangedListener {
            if (mNavigationListener != null) {
                mNavigationListener!!.onBackstackChanged()
            }
        }
    }

    fun open(fragment: Fragment) {

        if (mFragmentManager != null) {
            mFragmentManager!!.beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .setCustomAnimations(R.anim.slide_in_right,
                            R.anim.no_animation,
                            R.anim.no_animation,
                            R.anim.slide_out_right)
                    .addToBackStack(fragment.toString())
                    .commit()
        }
    }

    fun openAsRoot(fragment: Fragment) {
        popEveryFragment()
        open(fragment)
    }

    private fun popEveryFragment() {
        val backStackCount = mFragmentManager!!.backStackEntryCount
        for (i in 0 until backStackCount) {
            val backStackId = mFragmentManager!!.getBackStackEntryAt(i).id
            mFragmentManager!!.popBackStack(backStackId, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        }
    }

    fun navigateBack(baseActivity: Activity) {

        if (mFragmentManager!!.backStackEntryCount == 1) {
            baseActivity.finish()
        } else {
            mFragmentManager!!.popBackStackImmediate()
        }
    }

    fun getNavigationListener(): NavigationListener? {
        return mNavigationListener
    }

    fun setNavigationListener(navigationListener: NavigationListener) {
        mNavigationListener = navigationListener
    }
}