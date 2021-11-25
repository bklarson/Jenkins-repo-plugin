package hudson.plugins.repo.RepoSCM

def l = namespace(lib.JenkinsTagLib)

['REPO_MANIFEST_URL', 'REPO_MANIFEST_BRANCH', 'REPO_MANIFEST_FILE', 'REPO_MANIFEST_XML'].each {name ->
    l.buildEnvVar(name: name) {
        raw(_("${name}.blurb"))
    }
}
