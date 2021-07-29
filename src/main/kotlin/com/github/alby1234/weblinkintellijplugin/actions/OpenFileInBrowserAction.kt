package com.github.alby1234.weblinkintellijplugin.actions

import com.github.alby1234.weblinkintellijplugin.clients.HttpGithubClient
import com.github.alby1234.weblinkintellijplugin.settings.ProjectSettingsState
import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys

class OpenFileInBrowserAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val localProjectPath = e.project?.basePath ?: ""
        val localFilePath = e.getData(CommonDataKeys.VIRTUAL_FILE)?.path ?: ""
        val relativePath = localFilePath.replace(localProjectPath, "")
        val fileName = e.getData(CommonDataKeys.VIRTUAL_FILE)?.name ?: ""
        val filePath = relativePath.replace(fileName, "")

        val settings = ProjectSettingsState.getInstance(e.project)

        val username = settings.username
        val repoName = username + "/" + settings.repoName

        val githubClient = HttpGithubClient()

        BrowserUtil.browse(githubClient.getGithubUrlOfFile(username, fileName, filePath, repoName))
    }
}
