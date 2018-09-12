package ir.oxima.githubtrending.models.models

class License {

    private var key: String? = null
    private var name: String? = null
    private var spdx_id: String? = null
    private var url: String? = null
    private var node_id: String? = null

    fun getKey(): String? {
        return this.key
    }

    fun setKey(key: String) {
        this.key = key
    }

    fun getName(): String? {
        return this.name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getSpdxId(): String? {
        return this.spdx_id
    }

    fun setSpdxId(spdx_id: String) {
        this.spdx_id = spdx_id
    }

    fun getUrl(): String? {
        return this.url
    }

    fun setUrl(url: String) {
        this.url = url
    }

    fun getNodeId(): String? {
        return this.node_id
    }

    fun setNodeId(node_id: String) {
        this.node_id = node_id
    }

}