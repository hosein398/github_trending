package ir.oxima.githubtrending.views.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.oxima.githubtrendin.contracts.HomeContract
import ir.oxima.githubtrending.Presenters.HomePresenter
import ir.oxima.githubtrending.R
import ir.oxima.githubtrending.other.components.StatefulLayout
import ir.oxima.githubtrending.other.components.infinitescrollprovider.InfiniteScrollProvider
import ir.oxima.githubtrending.other.components.infinitescrollprovider.OnLoadMoreListener
import ir.oxima.githubtrending.views.adapters.TrendAdapter

class HomeFragment : BaseFragment(), HomeContract.View {


    private var mRootView: View? = null
    private var state_view : StatefulLayout? = null
    private var rcl_trends : RecyclerView? = null
    private var presenter : HomePresenter? = null
    private var trendAdapter: TrendAdapter? = null

    override fun onPause() {
        super.onPause()
    }

    companion object {
        @Synchronized
        fun instance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment_home, null)
        }
        initViews()
        presenter = HomePresenter(this)
        presenter!!.fetchTrends()
        return mRootView
    }

    override fun initViews() {
        state_view = mRootView!!.findViewById(R.id.state_view)
        rcl_trends = mRootView!!.findViewById(R.id.rcl_trends)


    }

    override fun getAppContext(): Context? {
        return context
    }

    override fun showLoading() {
        state_view!!.showProgressCenter()
    }

    override fun showEmpty() {
        state_view!!.showEmpty()
    }

    override fun showLoadingMore() {
       state_view!!.showProgressBottom(true)
    }

    override fun showContent() {
        state_view!!.showContent()
    }

    override fun showAlertDialog(msg: String?, cancelable: Boolean) {
        getBaseActivity().needShowAlertDialog(msg,cancelable)
    }

    override fun notifyDataSetChange() {
        trendAdapter!!.notifyDataSetChanged()
    }

    override fun notifyItemInserted(layoutPosition: Int) {
        trendAdapter!!.notifyItemInserted(layoutPosition)
    }

    override fun notifyItemRemoved(layoutPosition: Int) {
        trendAdapter!!.notifyItemRemoved(layoutPosition)
    }

    override fun notifyItemRangeChanged(positionStart: Int, itemCount: Int) {
        trendAdapter!!.notifyItemRangeChanged(positionStart,itemCount)
    }


    override fun showTrends() {
        rcl_trends!!.layoutManager = LinearLayoutManager(getAppContext())
        trendAdapter = TrendAdapter(presenter!!)
        rcl_trends!!.adapter = trendAdapter

        val infiniteScrollProvider = InfiniteScrollProvider()
        infiniteScrollProvider.attach(rcl_trends, object : OnLoadMoreListener {
            override fun onLoadMore() {
                presenter!!.fetchTrends()
            }
        })
    }


    override fun onConnectivityChange(isConnectedOrConnecting: Boolean) {
        super.onConnectivityChange(isConnectedOrConnecting)
        if (isConnectedOrConnecting){
            if (trendAdapter != null){
                showContent()
                retainInstance
            }
            presenter!!.fetchTrends()
        }else{
            state_view!!.showOffline()
        }
    }
}