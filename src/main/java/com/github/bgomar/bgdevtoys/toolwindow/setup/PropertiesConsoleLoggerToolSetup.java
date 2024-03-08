package com.github.bgomar.bgdevtoys.toolwindow.setup;

import com.github.bgomar.bgdevtoys.tools.ConsoleLoggerSettings;
import com.intellij.openapi.options.ConfigurableUi;
import com.intellij.openapi.ui.DialogPanel;
import org.jetbrains.annotations.NotNull;


import javax.swing.JComponent;
import javax.swing.JTextArea;

public class PropertiesConsoleLoggerToolSetup  extends AbstractToolSetup implements ConfigurableUi<ConsoleLoggerSettings> {
    private static JTextArea propertiesConsoleLoggerTextArea1 = new JTextArea();
    private static JTextArea propertiesConsoleLoggerTextArea2 = new JTextArea();
    private static JTextArea propertiesConsoleLoggerTextArea3 = new JTextArea();
    private static JTextArea propertiesConsoleLoggerTextArea4 = new JTextArea();
    private static JTextArea propertiesConsoleLoggerTextArea5 = new JTextArea();
    private static JTextArea propertiesConsoleLoggerTextArea6 = new JTextArea();
    private static JTextArea propertiesConsoleLoggerTextArea7 = new JTextArea();
    private static JTextArea propertiesConsoleLoggerTextArea8 = new JTextArea();
    private static JTextArea propertiesConsoleLoggerTextArea9 = new JTextArea();
    public static DialogPanel ui;

    public PropertiesConsoleLoggerToolSetup(
            JTextArea propertiesConsoleLoggerTextArea1,
            JTextArea propertiesConsoleLoggerTextArea2,
            JTextArea propertiesConsoleLoggerTextArea3,
            JTextArea propertiesConsoleLoggerTextArea4,
            JTextArea propertiesConsoleLoggerTextArea5,
            JTextArea propertiesConsoleLoggerTextArea6,
            JTextArea propertiesConsoleLoggerTextArea7,
            JTextArea propertiesConsoleLoggerTextArea8,
            JTextArea propertiesConsoleLoggerTextArea9) {
        super();
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea1 = propertiesConsoleLoggerTextArea1;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea2 = propertiesConsoleLoggerTextArea2;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea3 = propertiesConsoleLoggerTextArea3;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea4 = propertiesConsoleLoggerTextArea4;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea5 = propertiesConsoleLoggerTextArea5;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea6 = propertiesConsoleLoggerTextArea6;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea7 = propertiesConsoleLoggerTextArea7;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea8 = propertiesConsoleLoggerTextArea8;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea9 = propertiesConsoleLoggerTextArea9;

    }

    public PropertiesConsoleLoggerToolSetup() {

    }
    public void setup() {
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea9.setText(ConsoleLoggerSettings.getPattern(0));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea1.setText(ConsoleLoggerSettings.getPattern(1));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea2.setText(ConsoleLoggerSettings.getPattern(2));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea3.setText(ConsoleLoggerSettings.getPattern(3));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea4.setText(ConsoleLoggerSettings.getPattern(4));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea5.setText(ConsoleLoggerSettings.getPattern(5));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea6.setText(ConsoleLoggerSettings.getPattern(6));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea7.setText(ConsoleLoggerSettings.getPattern(7));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextArea8.setText(ConsoleLoggerSettings.getPattern(8));
    }

    @Override
    public void reset(@NotNull ConsoleLoggerSettings settings) {
        ui.reset();
    }

    @Override
    public boolean isModified(@NotNull ConsoleLoggerSettings settings) {
        return ui.isModified();
    }

    @Override
    public void apply(@NotNull ConsoleLoggerSettings settings) {
        ui.apply();
    }

    @Override
    public @NotNull JComponent getComponent() {
        return ui;
    }


}
