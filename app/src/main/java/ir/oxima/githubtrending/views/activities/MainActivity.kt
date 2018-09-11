package ir.oxima.githubtrending.views.activities

import android.content.Context
import android.os.Bundle
import android.view.View
import ir.oxima.githubtrendin.contracts.MainContract
import ir.oxima.githubtrending.NavigationManager
import ir.oxima.githubtrending.R
import ir.oxima.githubtrending.other.components.SimpleToolbar
import ir.oxima.githubtrending.other.components.bottomnavigationbar.BottomBarItem
import ir.oxima.githubtrending.other.components.bottomnavigationbar.BottomNavigationBar
import ir.oxima.githubtrending.other.utilities.FileLog
import ir.oxima.githubtrending.other.utilities.LocaleController
import ir.oxima.githubtrending.views.fragments.HomeFragment

class MainActivity : BaseActivity(), MainContract.View,SimpleToolbar.OnClickIconListener {



    private var simple_toolbar : SimpleToolbar? = null
    private var bottom_navigation : BottomNavigationBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        openFragment()
        setupToolbar()
        setupBottomNavigation()
    }

    override fun getAppContext(): Context {
       return this
    }

    override fun openFragment() {
        NavigationManager.getInstance().open(HomeFragment.instance())
    }

    override fun initViews() {
        bottom_navigation = findViewById(R.id.bottom_navigation)
        simple_toolbar = findViewById(R.id.simple_toolbar)

    }

    override fun setupToolbar() {
        simple_toolbar!!.setIconBack(null)
        simple_toolbar!!.setTitle(LocaleController.getText(this,R.string.app_name))
        simple_toolbar!!.setOnClickIconListener(this)
    }

    override fun setupBottomNavigation() {
        val bottomNavigationHome = BottomBarItem(R.drawable.ic_tab_home, R.string.home)
        val bottomNavigationList = BottomBarItem(R.drawable.ic_tab_category, R.string.category)
        val bottomNavigationSearchView = BottomBarItem(R.drawable.ic_tab_search, R.string.search)

        bottom_navigation!!.addTab(bottomNavigationHome)
        bottom_navigation!!.addTab(bottomNavigationList)
        bottom_navigation!!.addTab(bottomNavigationSearchView)

    }

    override fun onClickIcon(view: View?) {
        when (view!!.getId()) {
            R.id.icon1 -> FileLog.i("on click me !")
        }
    }

    override fun onBackstackChanged() {
        super.onBackstackChanged()
    }
}
