package ir.oxima.githubtrending.models.models

import com.google.gson.annotations.SerializedName

class Trend {

    private var id: Int = 0

    fun getId(): Int {
        return this.id
    }

    fun setId(id: Int) {
        this.id = id
    }

    private var node_id: String? = null

    fun getNodeId(): String? {
        return this.node_id
    }

    fun setNodeId(node_id: String) {
        this.node_id = node_id
    }

    private var name: String? = null

    fun getName(): String? {
        return this.name
    }

    fun setName(name: String) {
        this.name = name
    }

    private var full_name: String? = null

    fun getFullName(): String? {
        return this.full_name
    }

    fun setFullName(full_name: String) {
        this.full_name = full_name
    }

    private var owner: Owner? = null

    fun getOwner(): Owner? {
        return this.owner
    }

    fun setOwner(owner: Owner) {
        this.owner = owner
    }

    @SerializedName("private")
    private var isPrivate: Boolean = false

    fun isPrivate(): Boolean {
        return this.isPrivate
    }

    fun setPrivate(isPrivate: Boolean) {
        this.isPrivate = isPrivate
    }

    private var html_url: String? = null

    fun getHtmlUrl(): String? {
        return this.html_url
    }

    fun setHtmlUrl(html_url: String) {
        this.html_url = html_url
    }

    private var description: String? = null

    fun getDescription(): String? {
        return this.description
    }

    fun setDescription(description: String) {
        this.description = description
    }

    private var fork: Boolean = false

    fun getFork(): Boolean {
        return this.fork
    }

    fun setFork(fork: Boolean) {
        this.fork = fork
    }

    private var url: String? = null

    fun getUrl(): String? {
        return this.url
    }

    fun setUrl(url: String) {
        this.url = url
    }

    private var forks_url: String? = null

    fun getForksUrl(): String? {
        return this.forks_url
    }

    fun setForksUrl(forks_url: String) {
        this.forks_url = forks_url
    }

    private var keys_url: String? = null

    fun getKeysUrl(): String? {
        return this.keys_url
    }

    fun setKeysUrl(keys_url: String) {
        this.keys_url = keys_url
    }

    private var collaborators_url: String? = null

    fun getCollaboratorsUrl(): String? {
        return this.collaborators_url
    }

    fun setCollaboratorsUrl(collaborators_url: String) {
        this.collaborators_url = collaborators_url
    }

    private var teams_url: String? = null

    fun getTeamsUrl(): String? {
        return this.teams_url
    }

    fun setTeamsUrl(teams_url: String) {
        this.teams_url = teams_url
    }

    private var hooks_url: String? = null

    fun getHooksUrl(): String? {
        return this.hooks_url
    }

    fun setHooksUrl(hooks_url: String) {
        this.hooks_url = hooks_url
    }

    private var issue_events_url: String? = null

    fun getIssueEventsUrl(): String? {
        return this.issue_events_url
    }

    fun setIssueEventsUrl(issue_events_url: String) {
        this.issue_events_url = issue_events_url
    }

    private var events_url: String? = null

    fun getEventsUrl(): String? {
        return this.events_url
    }

    fun setEventsUrl(events_url: String) {
        this.events_url = events_url
    }

    private var assignees_url: String? = null

    fun getAssigneesUrl(): String? {
        return this.assignees_url
    }

    fun setAssigneesUrl(assignees_url: String) {
        this.assignees_url = assignees_url
    }

    private var branches_url: String? = null

    fun getBranchesUrl(): String? {
        return this.branches_url
    }

    fun setBranchesUrl(branches_url: String) {
        this.branches_url = branches_url
    }

    private var tags_url: String? = null

    fun getTagsUrl(): String? {
        return this.tags_url
    }

    fun setTagsUrl(tags_url: String) {
        this.tags_url = tags_url
    }

    private var blobs_url: String? = null

    fun getBlobsUrl(): String? {
        return this.blobs_url
    }

    fun setBlobsUrl(blobs_url: String) {
        this.blobs_url = blobs_url
    }

    private var git_tags_url: String? = null

    fun getGitTagsUrl(): String? {
        return this.git_tags_url
    }

    fun setGitTagsUrl(git_tags_url: String) {
        this.git_tags_url = git_tags_url
    }

    private var git_refs_url: String? = null

    fun getGitRefsUrl(): String? {
        return this.git_refs_url
    }

    fun setGitRefsUrl(git_refs_url: String) {
        this.git_refs_url = git_refs_url
    }

    private var trees_url: String? = null

    fun getTreesUrl(): String? {
        return this.trees_url
    }

    fun setTreesUrl(trees_url: String) {
        this.trees_url = trees_url
    }

    private var statuses_url: String? = null

    fun getStatusesUrl(): String? {
        return this.statuses_url
    }

    fun setStatusesUrl(statuses_url: String) {
        this.statuses_url = statuses_url
    }

    private var languages_url: String? = null

    fun getLanguagesUrl(): String? {
        return this.languages_url
    }

    fun setLanguagesUrl(languages_url: String) {
        this.languages_url = languages_url
    }

    private var stargazers_url: String? = null

    fun getStargazersUrl(): String? {
        return this.stargazers_url
    }

    fun setStargazersUrl(stargazers_url: String) {
        this.stargazers_url = stargazers_url
    }

    private var contributors_url: String? = null

    fun getContributorsUrl(): String? {
        return this.contributors_url
    }

    fun setContributorsUrl(contributors_url: String) {
        this.contributors_url = contributors_url
    }

    private var subscribers_url: String? = null

    fun getSubscribersUrl(): String? {
        return this.subscribers_url
    }

    fun setSubscribersUrl(subscribers_url: String) {
        this.subscribers_url = subscribers_url
    }

    private var subscription_url: String? = null

    fun getSubscriptionUrl(): String? {
        return this.subscription_url
    }

    fun setSubscriptionUrl(subscription_url: String) {
        this.subscription_url = subscription_url
    }

    private var commits_url: String? = null

    fun getCommitsUrl(): String? {
        return this.commits_url
    }

    fun setCommitsUrl(commits_url: String) {
        this.commits_url = commits_url
    }

    private var git_commits_url: String? = null

    fun getGitCommitsUrl(): String? {
        return this.git_commits_url
    }

    fun setGitCommitsUrl(git_commits_url: String) {
        this.git_commits_url = git_commits_url
    }

    private var comments_url: String? = null

    fun getCommentsUrl(): String? {
        return this.comments_url
    }

    fun setCommentsUrl(comments_url: String) {
        this.comments_url = comments_url
    }

    private var issue_comment_url: String? = null

    fun getIssueCommentUrl(): String? {
        return this.issue_comment_url
    }

    fun setIssueCommentUrl(issue_comment_url: String) {
        this.issue_comment_url = issue_comment_url
    }

    private var contents_url: String? = null

    fun getContentsUrl(): String? {
        return this.contents_url
    }

    fun setContentsUrl(contents_url: String) {
        this.contents_url = contents_url
    }

    private var compare_url: String? = null

    fun getCompareUrl(): String? {
        return this.compare_url
    }

    fun setCompareUrl(compare_url: String) {
        this.compare_url = compare_url
    }

    private var merges_url: String? = null

    fun getMergesUrl(): String? {
        return this.merges_url
    }

    fun setMergesUrl(merges_url: String) {
        this.merges_url = merges_url
    }

    private var archive_url: String? = null

    fun getArchiveUrl(): String? {
        return this.archive_url
    }

    fun setArchiveUrl(archive_url: String) {
        this.archive_url = archive_url
    }

    private var downloads_url: String? = null

    fun getDownloadsUrl(): String? {
        return this.downloads_url
    }

    fun setDownloadsUrl(downloads_url: String) {
        this.downloads_url = downloads_url
    }

    private var issues_url: String? = null

    fun getIssuesUrl(): String? {
        return this.issues_url
    }

    fun setIssuesUrl(issues_url: String) {
        this.issues_url = issues_url
    }

    private var pulls_url: String? = null

    fun getPullsUrl(): String? {
        return this.pulls_url
    }

    fun setPullsUrl(pulls_url: String) {
        this.pulls_url = pulls_url
    }

    private var milestones_url: String? = null

    fun getMilestonesUrl(): String? {
        return this.milestones_url
    }

    fun setMilestonesUrl(milestones_url: String) {
        this.milestones_url = milestones_url
    }

    private var notifications_url: String? = null

    fun getNotificationsUrl(): String? {
        return this.notifications_url
    }

    fun setNotificationsUrl(notifications_url: String) {
        this.notifications_url = notifications_url
    }

    private var labels_url: String? = null

    fun getLabelsUrl(): String? {
        return this.labels_url
    }

    fun setLabelsUrl(labels_url: String) {
        this.labels_url = labels_url
    }

    private var releases_url: String? = null

    fun getReleasesUrl(): String? {
        return this.releases_url
    }

    fun setReleasesUrl(releases_url: String) {
        this.releases_url = releases_url
    }

    private var deployments_url: String? = null

    fun getDeploymentsUrl(): String? {
        return this.deployments_url
    }

    fun setDeploymentsUrl(deployments_url: String) {
        this.deployments_url = deployments_url
    }

    private var created_at: String? = null

    fun getCreatedAt(): String? {
        return this.created_at
    }

    fun setCreatedAt(created_at: String) {
        this.created_at = created_at
    }

    private var updated_at: String? = null

    fun getUpdatedAt(): String? {
        return this.updated_at
    }

    fun setUpdatedAt(updated_at: String) {
        this.updated_at = updated_at
    }

    private var pushed_at: String? = null

    fun getPushedAt(): String? {
        return this.pushed_at
    }

    fun setPushedAt(pushed_at: String) {
        this.pushed_at = pushed_at
    }

    private var git_url: String? = null

    fun getGitUrl(): String? {
        return this.git_url
    }

    fun setGitUrl(git_url: String) {
        this.git_url = git_url
    }

    private var ssh_url: String? = null

    fun getSshUrl(): String? {
        return this.ssh_url
    }

    fun setSshUrl(ssh_url: String) {
        this.ssh_url = ssh_url
    }

    private var clone_url: String? = null

    fun getCloneUrl(): String? {
        return this.clone_url
    }

    fun setCloneUrl(clone_url: String) {
        this.clone_url = clone_url
    }

    private var svn_url: String? = null

    fun getSvnUrl(): String? {
        return this.svn_url
    }

    fun setSvnUrl(svn_url: String) {
        this.svn_url = svn_url
    }

    private var homepage: String? = null

    fun getHomepage(): String? {
        return this.homepage
    }

    fun setHomepage(homepage: String) {
        this.homepage = homepage
    }

    private var size: Int = 0

    fun getSize(): Int {
        return this.size
    }

    fun setSize(size: Int) {
        this.size = size
    }

    private var stargazers_count: Int = 0

    fun getStargazersCount(): Int {
        return this.stargazers_count
    }

    fun setStargazersCount(stargazers_count: Int) {
        this.stargazers_count = stargazers_count
    }

    private var watchers_count: Int = 0

    fun getWatchersCount(): Int {
        return this.watchers_count
    }

    fun setWatchersCount(watchers_count: Int) {
        this.watchers_count = watchers_count
    }

    private var language: String? = null

    fun getLanguage(): String? {
        return this.language
    }

    fun setLanguage(language: String) {
        this.language = language
    }

    private var has_issues: Boolean = false

    fun getHasIssues(): Boolean {
        return this.has_issues
    }

    fun setHasIssues(has_issues: Boolean) {
        this.has_issues = has_issues
    }

    private var has_projects: Boolean = false

    fun getHasProjects(): Boolean {
        return this.has_projects
    }

    fun setHasProjects(has_projects: Boolean) {
        this.has_projects = has_projects
    }

    private var has_downloads: Boolean = false

    fun getHasDownloads(): Boolean {
        return this.has_downloads
    }

    fun setHasDownloads(has_downloads: Boolean) {
        this.has_downloads = has_downloads
    }

    private var has_wiki: Boolean = false

    fun getHasWiki(): Boolean {
        return this.has_wiki
    }

    fun setHasWiki(has_wiki: Boolean) {
        this.has_wiki = has_wiki
    }

    private var has_pages: Boolean = false

    fun getHasPages(): Boolean {
        return this.has_pages
    }

    fun setHasPages(has_pages: Boolean) {
        this.has_pages = has_pages
    }

    private var forks_count: Int = 0

    fun getForksCount(): Int {
        return this.forks_count
    }

    fun setForksCount(forks_count: Int) {
        this.forks_count = forks_count
    }

    private var mirror_url: String? = null

    fun getMirrorUrl(): String? {
        return this.mirror_url
    }

    fun setMirrorUrl(mirror_url: String) {
        this.mirror_url = mirror_url
    }

    private var archived: Boolean = false

    fun getArchived(): Boolean {
        return this.archived
    }

    fun setArchived(archived: Boolean) {
        this.archived = archived
    }

    private var open_issues_count: Int = 0

    fun getOpenIssuesCount(): Int {
        return this.open_issues_count
    }

    fun setOpenIssuesCount(open_issues_count: Int) {
        this.open_issues_count = open_issues_count
    }

    private var license: License? = null

    fun getLicense(): License? {
        return this.license
    }

    fun setLicense(license: License) {
        this.license = license
    }

    private var forks: Int = 0

    fun getForks(): Int {
        return this.forks
    }

    fun setForks(forks: Int) {
        this.forks = forks
    }

    private var open_issues: Int = 0

    fun getOpenIssues(): Int {
        return this.open_issues
    }

    fun setOpenIssues(open_issues: Int) {
        this.open_issues = open_issues
    }

    private var watchers: Int = 0

    fun getWatchers(): Int {
        return this.watchers
    }

    fun setWatchers(watchers: Int) {
        this.watchers = watchers
    }

    private var default_branch: String? = null

    fun getDefaultBranch(): String? {
        return this.default_branch
    }

    fun setDefaultBranch(default_branch: String) {
        this.default_branch = default_branch
    }

    private var score: Double = 0.toDouble()

    fun getScore(): Double {
        return this.score
    }

    fun setScore(score: Double) {
        this.score = score
    }
}