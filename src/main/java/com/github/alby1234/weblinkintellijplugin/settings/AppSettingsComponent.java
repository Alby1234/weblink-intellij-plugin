package com.github.alby1234.weblinkintellijplugin.settings;

import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AppSettingsComponent {

    private final JPanel mainPanel;
    private final JBTextField username = new JBTextField();
    private final JBTextField repoName = new JBTextField();

    public AppSettingsComponent() {
        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JLabel("Enter repository username (github only): "), username, 1, false)
                .addLabeledComponent(new JLabel("Enter repository name (github only): "), repoName, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    @NotNull
    public String getUsername() {
        return username.getText();
    }

    public void setUsername(@NotNull String newText) {
        username.setText(newText);
    }

    public JComponent getPreferredFocusedComponent() {
        return username;
    }

    public String getRepoName() { return repoName.getText(); }

    public void setRepoName(@NotNull String newText) { repoName.setText(newText); }
}
