package ir.oxima.githubtrendin.contracts

import android.content.Context
import android.support.v4.app.Fragment

interface MainContract {

    interface View{
        fun initViews()
        fun getAppContext(): Context
        fun openFragment(fragment: Fragment)
        fun setupToolbar()
        fun setupBottomNavigation()
    }

}