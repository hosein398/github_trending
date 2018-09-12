package ir.oxima.githubtrending.models.models

class Error {

    private var message: String? = null
    private var resource: String? = null
    private var field: String? = null
    private var code: String? = null

    fun getMessage(): String? {
        return this.message
    }

    fun setMessage(message: String) {
        this.message = message
    }



    fun getResource(): String? {
        return this.resource
    }

    fun setResource(resource: String) {
        this.resource = resource
    }



    fun getField(): String? {
        return this.field
    }

    fun setField(field: String) {
        this.field = field
    }



    fun getCode(): String? {
        return this.code
    }

    fun setCode(code: String) {
        this.code = code
    }
}