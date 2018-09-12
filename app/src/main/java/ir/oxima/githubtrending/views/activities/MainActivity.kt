package ir.oxima.githubtrending.views.activities

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.Gravity
import android.view.View
import ir.oxima.githubtrendin.contracts.MainContract
import ir.oxima.githubtrending.NavigationManager
import ir.oxima.githubtrending.R
import ir.oxima.githubtrending.models.interfaces.IReloadTrends
import ir.oxima.githubtrending.models.models.Category
import ir.oxima.githubtrending.other.components.SimpleToolbar
import ir.oxima.githubtrending.other.components.bottomnavigationbar.BottomBarItem
import ir.oxima.githubtrending.other.components.bottomnavigationbar.BottomNavigationBar
import ir.oxima.githubtrending.other.utilities.FileLog
import ir.oxima.githubtrending.other.utilities.LocaleController
import ir.oxima.githubtrending.other.utilities.Prefs
import ir.oxima.githubtrending.views.fragments.CategoryFragment
import ir.oxima.githubtrending.views.fragments.HomeFragment

class MainActivity : BaseActivity(),
        MainContract.View,
        SimpleToolbar.OnClickIconListener,
        SimpleToolbar.SearchViewListener,
        BottomNavigationBar.OnSelectListener,
        BottomNavigationBar.OnReselectListener,
        IReloadTrends{



    private var simple_toolbar : SimpleToolbar? = null
    private var bottom_navigation : BottomNavigationBar? = null
    private var homeFragment : HomeFragment? = null
    private var categoryFragment : CategoryFragment? = null

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
        categoryFragment = CategoryFragment.instance()
        categoryFragment!!.setListener(this)
    }

    override fun setupToolbar() {
        simple_toolbar!!.setIconBack(null)
        simple_toolbar!!.setTitle(LocaleController.getText(this,R.string.app_name))
        simple_toolbar!!.setGravityTitle(Gravity.CENTER)
        simple_toolbar!!.setOnClickIconListener(this)
        simple_toolbar!!.setSearchViewListener(this)
        var category = Prefs.getObject("category",Category::class.java)
        simple_toolbar!!.setSubTitle("For ${if (category == null) "Java" else category!!.getTitle()}")

    }

    override fun setupBottomNavigation() {
        val bottomNavigationHome = BottomBarItem(R.drawable.ic_tab_home, R.string.home)
        val bottomNavigationList = BottomBarItem(R.drawable.ic_tab_category, R.string.category)
        //val bottomNavigationSearchView = BottomBarItem(R.drawable.ic_tab_search, R.string.search)

        bottom_navigation!!.addTab(bottomNavigationHome)
        bottom_navigation!!.addTab(bottomNavigationList)
        //bottom_navigation!!.addTab(bottomNavigationSearchView)

        bottom_navigation!!.setOnSelectListener(this)
        bottom_navigation!!.setOnReselectListener(this)

    }

    override fun onSelect(position: Int) {
        when (position) {
            0 -> {
                simple_toolbar!!.closeSearchView()
                openFragment(homeFragment!!)
            }

            1 -> {
                simple_toolbar!!.closeSearchView()
                openFragment(categoryFragment!!)
            }
            2 -> {
                simple_toolbar!!.openSearchView()
                openFragment(homeFragment!!)
            }
        }
    }

    override fun onReselect(position: Int) {
        when (position) {
            0 -> {
                simple_toolbar!!.closeSearchView()
                openFragment(homeFragment!!)
            }
            1 -> {
                simple_toolbar!!.closeSearchView()
                openFragment(categoryFragment!!)
            }
            2 -> {
                simple_toolbar!!.openSearchView()
                openFragment(homeFragment!!)
            }
        }
    }

    override fun onClickIcon(view: View?) {
        when (view!!.getId()) {
        }
    }

    override fun onSearchViewShown() {
    }

    override fun onSearchViewClosed() {
    }

    override fun onSearchViewBackPressed() {
        bottom_navigation!!.selectTab(0, true)
    }

    override fun onBackPressed() {
        if (simple_toolbar!!.isOpenSearchView){
            simple_toolbar!!.closeSearchView()
            bottom_navigation!!.selectTab(0, true)
            return
        }
        val f = supportFragmentManager.findFragmentById(R.id.main_container)
        if (f is HomeFragment) {
            finish()
        }else{
            bottom_navigation!!.selectTab(0, true)
        }
        super.onBackPressed()
    }

    override fun onChangeCategory(category: Category?) {
        simple_toolbar!!.setSubTitle("For ${if (category == null) "Java" else category!!.getTitle()}")
        bottom_navigation!!.selectTab(0, true)
        homeFragment = HomeFragment.instance()
        openFragment(homeFragment!!)
    }
}
