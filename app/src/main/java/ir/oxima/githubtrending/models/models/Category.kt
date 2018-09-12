package ir.oxima.githubtrending.models.models

class Category {

    private var title: String? = null
    private var isChecked: Boolean = false

    constructor(){

    }

    constructor(title: String?){
        this.title = title
        this.isChecked = false
    }

    constructor(title: String?,isChecked: Boolean){
        this.title = title
        this.isChecked = isChecked
    }

    fun getTitle(): String? {
        return this.title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun isChecked(): Boolean {
        return this.isChecked
    }

    fun setChecked(isChecked: Boolean) {
        this.isChecked = isChecked
    }

}