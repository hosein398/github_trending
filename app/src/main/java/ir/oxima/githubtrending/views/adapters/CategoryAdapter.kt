package ir.oxima.githubtrending.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import ir.oxima.githubtrending.Presenters.CategoryPresenter
import ir.oxima.githubtrending.Presenters.HomePresenter
import ir.oxima.githubtrending.R


class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.Holder> {

    private val mPresenter: CategoryPresenter

    constructor(presnter: CategoryPresenter){
        this.mPresenter = presnter
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): Holder {
        return mPresenter.createViewHolder(viewGroup, i)
    }

    override fun onBindViewHolder(feedListRowHolder: Holder, position: Int) {
        mPresenter.bindViewHolder(feedListRowHolder, position)
    }

    override fun getItemCount(): Int {
        return mPresenter.getCategoriesCount()
    }


    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        var chk_category: CheckBox

        init {
            this.chk_category = view.findViewById(R.id.chk_category)
        }
    }

}