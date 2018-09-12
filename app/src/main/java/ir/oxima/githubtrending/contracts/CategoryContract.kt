package ir.oxima.githubtrendin.contracts

import android.content.Context
import android.view.ViewGroup
import ir.oxima.githubtrending.models.Category
import ir.oxima.githubtrending.models.Trend
import ir.oxima.githubtrending.views.adapters.CategoryAdapter
import ir.oxima.githubtrending.views.adapters.TrendAdapter

interface CategoryContract {

    interface View{
        fun initViews()
        fun getAppContext(): Context?
        fun notifyDataSetChange()
        fun notifyItemInserted(layoutPosition: Int)
        fun notifyItemRemoved(layoutPosition: Int)
        fun notifyItemRangeChanged(positionStart: Int, itemCount: Int)
        fun showCategories()
    }

    interface Presenter{
        fun fetchCategories()
        fun getCategories() : ArrayList<Category>
        fun getCategoriesCount(): Int
        fun createViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.Holder
        fun bindViewHolder(holder: CategoryAdapter.Holder, position: Int)
    }
}