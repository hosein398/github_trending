package ir.oxima.githubtrending.views.activities

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
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

class MainActivity : BaseActivity(),
        MainContract.View,
        SimpleToolbar.OnClickIconListener,
        BottomNavigationBar.OnSelectListener,
        BottomNavigationBar.OnReselectListener{



    private var simple_toolbar : SimpleToolbar? = null
    private var bottom_navigation : BottomNavigationBar? = null
    private var homeFragment : HomeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        openFragment(homeFragment!!)
        setupToolbar()
        setupBottomNavigation()
    }

    override fun getAppContext(): Context {
       return this
    }

    override fun openFragment(fragment: Fragment) {
        NavigationManager.getInstance().open(fragment)
    }

    override fun initViews() {
        bottom_navigation = findViewById(R.id.bottom_navigation)
        simple_toolbar = findViewById(R.id.simple_toolbar)

        homeFragment = HomeFragment.instance()
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

        bottom_navigation!!.setOnSelectListener(this)
        bottom_navigation!!.setOnReselectListener(this)

    }

    override fun onSelect(position: Int) {
        when (position) {
            0 -> openFragment(homeFragment!!)
            1 -> FileLog.i("on click me !")
            2 -> simple_toolbar!!.openSearchView()
        }
    }

    override fun onReselect(position: Int) {
        when (position) {
            0 -> openFragment(homeFragment!!)
            1 -> FileLog.i("on click me !")
            2 -> simple_toolbar!!.openSearchView()
        }
    }

    override fun onClickIcon(view: View?) {
        when (view!!.getId()) {
        }
    }

    override fun onBackstackChanged() {
        super.onBackstackChanged()
    }
}
