package ir.oxima.githubtrending.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ir.oxima.githubtrending.Presenters.HomePresenter
import ir.oxima.githubtrending.R


class TrendAdapter : RecyclerView.Adapter<TrendAdapter.Holder> {

    private val mPresenter: HomePresenter

    constructor(presnter: HomePresenter){
        this.mPresenter = presnter
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): Holder {
        return mPresenter.createViewHolder(viewGroup, i)
    }

    override fun onBindViewHolder(feedListRowHolder: Holder, position: Int) {
        mPresenter.bindViewHolder(feedListRowHolder, position)
    }

    override fun getItemCount(): Int {
        return mPresenter.getTrendsCount()
    }


    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        var txt_full_name: TextView
        var txt_description: TextView
        var txt_watchers_count: TextView
        var img_avatar: ImageView

        init {
            this.txt_full_name = view.findViewById(R.id.txt_full_name)
            this.txt_description = view.findViewById(R.id.txt_description)
            this.txt_watchers_count = view.findViewById(R.id.txt_watchers_count)
            this.img_avatar = view.findViewById(R.id.img_avatar)
        }
    }

}