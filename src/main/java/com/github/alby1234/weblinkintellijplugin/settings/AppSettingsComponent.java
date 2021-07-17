package com.github.alby1234.weblinkintellijplugin.settings;

import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AppSettingsComponent {

    private final JPanel mainPanel;
    private final JBTextField urlText = new JBTextField();

    public AppSettingsComponent() {
        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JLabel("Enter repository base url: "), urlText, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    @NotNull
    public String getBaseUrlText() {
        return urlText.getText();
    }

    public void setBaseUrlText(@NotNull String newText) {
        urlText.setText(newText);
    }

    public JComponent getPreferredFocusedComponent() {
        return urlText;
    }
}
