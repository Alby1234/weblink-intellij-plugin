package com.github.alby1234.weblinkintellijplugin.services

import com.github.alby1234.weblinkintellijplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
