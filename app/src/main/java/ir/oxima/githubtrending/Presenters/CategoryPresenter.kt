package ir.oxima.githubtrending.Presenters


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.bumptech.glide.Glide
import ir.oxima.githubtrendin.contracts.CategoryContract
import ir.oxima.githubtrendin.contracts.HomeContract
import ir.oxima.githubtrending.R
import ir.oxima.githubtrending.models.Category
import ir.oxima.githubtrending.models.Root
import ir.oxima.githubtrending.models.Trend
import ir.oxima.githubtrending.other.constant.C
import ir.oxima.githubtrending.other.utilities.ValidationTools
import ir.oxima.githubtrending.views.adapters.CategoryAdapter
import ir.oxima.githubtrending.views.adapters.TrendAdapter
import kotlin.collections.ArrayList

class CategoryPresenter : CategoryContract.Presenter {

    private var mView: CategoryContract.View
    private var items = ArrayList<Category>()


    constructor(view: CategoryContract.View){
        this.mView = view
    }

    override fun fetchCategories() {

        items.add(Category("Java",true))
        items.add(Category("Kotlin"))
        items.add(Category("C#"))
        items.add(Category("Swift"))
        items.add(Category("C"))
        items.add(Category("C++"))
        items.add(Category("CSS"))
        items.add(Category("HTML"))
        items.add(Category("PHP"))
        items.add(Category("Python"))
        items.add(Category("Perl"))
        items.add(Category("CMake"))
        items.add(Category("D"))
        items.add(Category("Go"))
        items.add(Category("Groovy"))
        items.add(Category("JavaScript"))
        items.add(Category("TypeScript"))
        items.add(Category("Matlab"))
        items.add(Category("PLSQL"))
        items.add(Category("TeX"))

        mView!!.showCategories()

    }

    override fun getCategoriesCount(): Int {
        return if (ValidationTools.isEmptyOrNull(getCategories())) 0 else getCategories().size
    }

    override fun getCategories(): ArrayList<Category> {
        return items
    }

    override fun createViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_category, null)
        val lp = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        view.setLayoutParams(lp)
        return CategoryAdapter.Holder(view)
    }

    override fun bindViewHolder(holder: CategoryAdapter.Holder, position: Int) {
        if (ValidationTools.isEmptyOrNull(getCategories())){
            return
        }

        var category = getCategories().get(position)
        holder.chk_category.setOnCheckedChangeListener(null)
        holder.chk_category.isChecked = category.isChecked()
        holder.chk_category.text = category.getTitle()
        holder.chk_category.setOnCheckedChangeListener{ buttonView, isChecked ->
            if (!isChecked){
                holder.chk_category.isChecked = true
                return@setOnCheckedChangeListener
            }
            for (cat in getCategories()){
                cat.setChecked(false)
            }
            category.setChecked(isChecked)
            mView!!.notifyDataSetChange()
        }
    }

}