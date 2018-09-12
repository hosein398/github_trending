package ir.oxima.githubtrending.Presenters


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.bumptech.glide.Glide
import ir.oxima.githubtrendin.contracts.HomeContract
import ir.oxima.githubtrending.R
import ir.oxima.githubtrending.models.Root
import ir.oxima.githubtrending.models.Trend
import ir.oxima.githubtrending.other.constant.C
import ir.oxima.githubtrending.other.utilities.ValidationTools
import ir.oxima.githubtrending.views.adapters.TrendAdapter
import kotlin.collections.ArrayList

class HomePresenter : HomeContract.Presenter {


    private var mView: HomeContract.View
    private var page : Int = 1
    private var items = ArrayList<Trend>()

    constructor(view: HomeContract.View){
        this.mView = view
    }

    override fun fetchTrends() {
        if (page == 1){
            mView.showLoading()
        }else{
            mView.showLoadingMore()
        }

        AndroidNetworking.get(String.format(C.API_BASE_URL,"q=language:kotlin&sort=stars&order=desc&page=$page"))
                .setTag("")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsObject(Root::class.java, object : ParsedRequestListener<Root> {
                    override fun onResponse(response: Root) {
                        if (response == null){
                            if (page != 1){
                                return
                            }
                            mView.showAlertDialog("",true)
                            return
                        }

                        if (!ValidationTools.isEmptyOrNull(response.getErrors())){
                            if (page != 1){
                                return
                            }
                            mView.showAlertDialog(response.getMessage(),true)
                            return
                        }

                        if (ValidationTools.isEmptyOrNull(response.getItems())){
                            if (page != 1){
                                return
                            }
                            mView.showEmpty()
                        }

                        if (page == 1){
                            items = response.getItems()!!
                            mView.showTrends()
                        }else{
                            items.addAll(response.getItems()!!)
                            mView.notifyDataSetChange()
                        }
                        mView.showContent()
                        page++
                    }

                    override fun onError(anError: ANError) {
                        if (page != 1){
                            return
                        }
                        mView.showAlertDialog(anError.errorDetail,true)
                        mView.showEmpty()
                    }
                })
    }

    override fun getTrendsCount(): Int {
        return if (ValidationTools.isEmptyOrNull(getTrendes())) 0 else getTrendes().size
    }

    override fun getTrendes(): ArrayList<Trend> {
        return items
    }

    override fun createViewHolder(parent: ViewGroup, viewType: Int): TrendAdapter.Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_trend, null)
        val lp = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        view.setLayoutParams(lp)
        return TrendAdapter.Holder(view)
    }

    override fun bindViewHolder(holder: TrendAdapter.Holder, position: Int) {
        if (ValidationTools.isEmptyOrNull(getTrendes())){
            return
        }

        var trend = getTrendes().get(position)
        holder.txt_full_name.text = trend.getFullName()
        holder.txt_description.text = trend.getDescription()
        holder.txt_watchers_count.text = "" + trend.getWatchersCount()

        Glide.with(mView.getAppContext())
                .load(trend.getOwner()!!.getAvatarUrl())
                .into(holder.img_avatar)

        holder.root.setOnClickListener{
            mView.onClickTrend(trend)
        }
    }

}