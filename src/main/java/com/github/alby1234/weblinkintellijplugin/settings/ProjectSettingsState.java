package com.github.alby1234.weblinkintellijplugin.settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "com.github.alby1234.weblinkplugin.settings.ProjectSettingsState",
        storages = {@Storage("WeblinkPluginSettings.xml")}
)
public class ProjectSettingsState implements PersistentStateComponent<ProjectSettingsState> {

    public String username = "";
    public String repoName = "";

    public static ProjectSettingsState getInstance(Project project) {
        return ServiceManager.getService(project, ProjectSettingsState.class);
    }

    @Nullable
    @Override
    public ProjectSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull ProjectSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}
