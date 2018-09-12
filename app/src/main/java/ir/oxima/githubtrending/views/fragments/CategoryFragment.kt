package ir.oxima.githubtrending.views.fragments

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.oxima.githubtrendin.contracts.CategoryContract
import ir.oxima.githubtrending.Presenters.CategoryPresenter
import ir.oxima.githubtrending.R
import ir.oxima.githubtrending.other.components.StatefulLayout
import ir.oxima.githubtrending.views.adapters.CategoryAdapter


class CategoryFragment : BaseFragment(),CategoryContract.View{


    private var mRootView: View? = null
    private var state_view : StatefulLayout? = null
    private var rcl_categories : RecyclerView? = null
    private var presenter : CategoryPresenter? = null
    private var categoryAdapter: CategoryAdapter? = null

    override fun onPause() {
        super.onPause()
    }

    companion object {
        @Synchronized
        fun instance(): CategoryFragment {
            return CategoryFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment_category, null)
        }
        initViews()
        presenter = CategoryPresenter(this)
        presenter!!.fetchCategories()
        return mRootView
    }

    override fun showCategories() {
        rcl_categories!!.layoutManager = GridLayoutManager(getAppContext(),2) as RecyclerView.LayoutManager
        categoryAdapter = CategoryAdapter(presenter!!)
        rcl_categories!!.adapter = categoryAdapter
    }

    override fun initViews() {
        state_view = mRootView!!.findViewById(R.id.state_view)
        rcl_categories = mRootView!!.findViewById(R.id.rcl_categories)
    }

    override fun getAppContext(): Context? {
        return context
    }

    override fun notifyDataSetChange() {
        categoryAdapter!!.notifyDataSetChanged()
    }

    override fun notifyItemInserted(layoutPosition: Int) {
        categoryAdapter!!.notifyItemInserted(layoutPosition)
    }

    override fun notifyItemRemoved(layoutPosition: Int) {
        categoryAdapter!!.notifyItemRemoved(layoutPosition)
    }

    override fun notifyItemRangeChanged(positionStart: Int, itemCount: Int) {
        categoryAdapter!!.notifyItemRangeChanged(positionStart,itemCount)
    }

    override fun onConnectivityChange(isConnectedOrConnecting: Boolean) {
        super.onConnectivityChange(isConnectedOrConnecting)
        if (isConnectedOrConnecting){
            state_view!!.showContent()
        }else{
            state_view!!.showOffline()
        }
    }
}