package ir.oxima.githubtrending.models.models

class Owner {

    private var login: String? = null
    private var id: Int = 0
    private var node_id: String? = null
    private var avatar_url: String? = null
    private var gravatar_id: String? = null
    private var url: String? = null
    private var html_url: String? = null
    private var followers_url: String? = null
    private var following_url: String? = null
    private var gists_url: String? = null
    private var starred_url: String? = null
    private var subscriptions_url: String? = null
    private var organizations_url: String? = null
    private var repos_url: String? = null
    private var events_url: String? = null
    private var received_events_url: String? = null
    private var type: String? = null
    private var site_admin: Boolean = false


    fun getLogin(): String? {
        return this.login
    }

    fun setLogin(login: String) {
        this.login = login
    }

    fun getId(): Int {
        return this.id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getNodeId(): String? {
        return this.node_id
    }

    fun setNodeId(node_id: String) {
        this.node_id = node_id
    }



    fun getAvatarUrl(): String? {
        return this.avatar_url
    }

    fun setAvatarUrl(avatar_url: String) {
        this.avatar_url = avatar_url
    }



    fun getGravatarId(): String? {
        return this.gravatar_id
    }

    fun setGravatarId(gravatar_id: String) {
        this.gravatar_id = gravatar_id
    }



    fun getUrl(): String? {
        return this.url
    }

    fun setUrl(url: String) {
        this.url = url
    }



    fun getHtmlUrl(): String? {
        return this.html_url
    }

    fun setHtmlUrl(html_url: String) {
        this.html_url = html_url
    }



    fun getFollowersUrl(): String? {
        return this.followers_url
    }

    fun setFollowersUrl(followers_url: String) {
        this.followers_url = followers_url
    }


    fun getFollowingUrl(): String? {
        return this.following_url
    }

    fun setFollowingUrl(following_url: String) {
        this.following_url = following_url
    }

    fun getGistsUrl(): String? {
        return this.gists_url
    }

    fun setGistsUrl(gists_url: String) {
        this.gists_url = gists_url
    }



    fun getStarredUrl(): String? {
        return this.starred_url
    }

    fun setStarredUrl(starred_url: String) {
        this.starred_url = starred_url
    }

    fun getSubscriptionsUrl(): String? {
        return this.subscriptions_url
    }

    fun setSubscriptionsUrl(subscriptions_url: String) {
        this.subscriptions_url = subscriptions_url
    }

    fun getOrganizationsUrl(): String? {
        return this.organizations_url
    }

    fun setOrganizationsUrl(organizations_url: String) {
        this.organizations_url = organizations_url
    }

    fun getReposUrl(): String? {
        return this.repos_url
    }

    fun setReposUrl(repos_url: String) {
        this.repos_url = repos_url
    }

    fun getEventsUrl(): String? {
        return this.events_url
    }

    fun setEventsUrl(events_url: String) {
        this.events_url = events_url
    }

    fun getReceivedEventsUrl(): String? {
        return this.received_events_url
    }

    fun setReceivedEventsUrl(received_events_url: String) {
        this.received_events_url = received_events_url
    }

    fun getType(): String? {
        return this.type
    }

    fun setType(type: String) {
        this.type = type
    }

    fun getSiteAdmin(): Boolean {
        return this.site_admin
    }

    fun setSiteAdmin(site_admin: Boolean) {
        this.site_admin = site_admin
    }
}