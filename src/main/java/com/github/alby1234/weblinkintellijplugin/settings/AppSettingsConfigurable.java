package com.github.alby1234.weblinkintellijplugin.settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class AppSettingsConfigurable implements Configurable {

    private AppSettingsComponent settingsComponent;

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
        settingsComponent = new AppSettingsComponent();
        return settingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        AppSettingsState settings = AppSettingsState.getInstance();
        return !settingsComponent.getUsername().equals(settings.username)
                || !settingsComponent.getRepoName().equals(settings.repoName);
    }

    @Override
    public void apply() {
        AppSettingsState settings = AppSettingsState.getInstance();
        settings.username = settingsComponent.getUsername();
        settings.repoName = settingsComponent.getRepoName();
    }

    @Override
    public void reset() {
        AppSettingsState settings = AppSettingsState.getInstance();
        settingsComponent.setUsername(settings.username);
        settingsComponent.setRepoName(settings.repoName);
    }

    @Override
    public void disposeUIResources() {
        settingsComponent = null;
    }

}
