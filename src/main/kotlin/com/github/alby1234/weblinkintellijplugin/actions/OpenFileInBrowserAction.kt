package com.github.alby1234.weblinkintellijplugin.actions

import com.github.alby1234.weblinkintellijplugin.settings.AppSettingsState
import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys

class OpenInBrowserAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val localProjectPath: String = e.project?.basePath ?: "";
        val localFilePath: String = e.getData(CommonDataKeys.VIRTUAL_FILE)?.path ?: "";
        val relativePath: String = localFilePath.replace(localProjectPath, "");

        val baseUrl: String = AppSettingsState.getInstance().webRepositoryBaseUrl;
        val path: String = baseUrl + relativePath;

        BrowserUtil.browse(path);
    }

}