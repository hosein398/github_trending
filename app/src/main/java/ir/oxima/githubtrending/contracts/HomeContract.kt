package ir.oxima.githubtrendin.contracts

import android.content.Context
import android.view.ViewGroup
import ir.oxima.githubtrending.models.Trend
import ir.oxima.githubtrending.views.adapters.TrendAdapter

interface HomeContract {

    interface View{
        fun initViews()
        fun getAppContext(): Context?
        fun showLoading()
        fun showLoadingMore()
        fun showEmpty()
        fun showContent()
        fun showAlertDialog(msg : String?,cancelable : Boolean)
        fun notifyDataSetChange()
        fun notifyItemInserted(layoutPosition: Int)
        fun notifyItemRemoved(layoutPosition: Int)
        fun notifyItemRangeChanged(positionStart: Int, itemCount: Int)
        fun showTrends()
    }

    interface Presenter{
        fun fetchTrends()
        fun getTrendes() : ArrayList<Trend>
        fun getTrendsCount(): Int
        fun createViewHolder(parent: ViewGroup, viewType: Int): TrendAdapter.Holder
        fun bindViewHolder(holder: TrendAdapter.Holder, position: Int)
    }
}