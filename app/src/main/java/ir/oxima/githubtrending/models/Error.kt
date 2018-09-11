package ir.oxima.githubtrending.models

class Error {

    private var message: String? = null

    fun getMessage(): String? {
        return this.message
    }

    fun setMessage(message: String) {
        this.message = message
    }

    private var resource: String? = null

    fun getResource(): String? {
        return this.resource
    }

    fun setResource(resource: String) {
        this.resource = resource
    }

    private var field: String? = null

    fun getField(): String? {
        return this.field
    }

    fun setField(field: String) {
        this.field = field
    }

    private var code: String? = null

    fun getCode(): String? {
        return this.code
    }

    fun setCode(code: String) {
        this.code = code
    }
}