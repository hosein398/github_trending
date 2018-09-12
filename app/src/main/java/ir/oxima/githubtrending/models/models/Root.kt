package ir.oxima.githubtrending.models.models

import com.google.gson.GsonBuilder


class Root {

    private var total_count: Int = 0
    private var items: ArrayList<Trend>? = null
    private var incomplete_results: Boolean = false

    private var errors: ArrayList<Error>? = null
    private var message: String? = null
    private var documentation_url: String? = null

    fun getTotalCount(): Int {
        return this.total_count
    }

    fun setTotalCount(total_count: Int) {
        this.total_count = total_count
    }

    fun getIncompleteResults(): Boolean {
        return this.incomplete_results
    }

    fun setIncompleteResults(incomplete_results: Boolean) {
        this.incomplete_results = incomplete_results
    }

    fun getItems(): ArrayList<Trend>? {
        return this.items
    }

    fun setItems(items: ArrayList<Trend>) {
        this.items = items
    }

    fun getMessage(): String? {
        return this.message
    }

    fun setMessage(message: String) {
        this.message = message
    }

    fun getDocumentationUrl(): String? {
        return this.documentation_url
    }

    fun setDocumentationUrl(documentation_url: String) {
        this.documentation_url = documentation_url
    }

    fun getErrors(): ArrayList<Error>? {
        return this.errors
    }

    fun setErrors(errors: ArrayList<Error>) {
        this.errors = errors
    }

    override fun toString(): String {
        return GsonBuilder().create().toJson(this)
    }
}