package ir.oxima.githubtrendin.contracts

import android.content.Context

interface MainContract {

    interface View{
        fun initViews()
        fun getAppContext(): Context
        fun openFragment()
        fun setupToolbar()
        fun setupBottomNavigation()
    }

}