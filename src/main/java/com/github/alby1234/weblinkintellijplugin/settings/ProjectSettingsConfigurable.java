package com.github.alby1234.weblinkintellijplugin.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ProjectSettingsConfigurable implements Configurable {

    private ProjectSettingsComponent settingsComponent;
    private Project project;

    public ProjectSettingsConfigurable(Project project) {
        this.project = project;
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Weblink plugin settings";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return settingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        settingsComponent = new ProjectSettingsComponent();
        return settingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        ProjectSettingsState settings = ProjectSettingsState.getInstance(project);
        return !settingsComponent.getUsername().equals(settings.username)
                || !settingsComponent.getRepoName().equals(settings.repoName);
    }

    @Override
    public void apply() {
        ProjectSettingsState settings = ProjectSettingsState.getInstance(project);
        settings.username = settingsComponent.getUsername();
        settings.repoName = settingsComponent.getRepoName();
    }

    @Override
    public void reset() {
        ProjectSettingsState settings = ProjectSettingsState.getInstance(project);
        settingsComponent.setUsername(settings.username);
        settingsComponent.setRepoName(settings.repoName);
    }

    @Override
    public void disposeUIResources() {
        settingsComponent = null;
    }

}
