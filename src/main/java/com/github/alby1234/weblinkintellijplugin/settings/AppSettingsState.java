package com.github.alby1234.weblinkintellijplugin.settings;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import jdk.internal.jline.internal.Nullable;
import org.jetbrains.annotations.NotNull;

@State(
        name = "com.github.alby1234.weblinkplugin.settings.AppSettingsState",
        storages = {@Storage("WeblinkPluginSettings.xml")}
)
public class AppSettingsState implements PersistentStateComponent<AppSettingsState> {

    // default to github, for now
    public String webRepositoryBaseUrl = "https://github.com";

    public static AppSettingsState getInstance() {
        return ApplicationManager.getApplication().getService(AppSettingsState.class);
    }

    @Nullable
    @Override
    public AppSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull AppSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}
