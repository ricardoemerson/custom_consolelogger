package com.github.bgomar.bgconsolelogger.toolwindow.setup;

import com.github.bgomar.bgconsolelogger.tools.ConsoleLoggerSettings;
import com.intellij.openapi.options.ConfigurableUi;
import com.intellij.openapi.ui.DialogPanel;
import org.jetbrains.annotations.NotNull;


import javax.swing.*;

public class PropertiesConsoleLoggerToolSetup  extends AbstractToolSetup implements ConfigurableUi<ConsoleLoggerSettings> {
    private static JTextField propertiesConsoleLoggerTextField1 = new JTextField();
    private static JTextField propertiesConsoleLoggerTextField2 = new JTextField();
    private static JTextField propertiesConsoleLoggerTextField3 = new JTextField();
    private static JTextField propertiesConsoleLoggerTextField4 = new JTextField();
    private static JTextField propertiesConsoleLoggerTextField5 = new JTextField();
    private static JTextField propertiesConsoleLoggerTextField6 = new JTextField();
    private static JTextField propertiesConsoleLoggerTextField7 = new JTextField();
    private static JTextField propertiesConsoleLoggerTextField8 = new JTextField();
    private static JTextField propertiesConsoleLoggerTextField9 = new JTextField();
    private static JButton propertiesConsoleLoggerbutton1 = new JButton();
    public static DialogPanel ui;

    public PropertiesConsoleLoggerToolSetup(
            JTextField propertiesConsoleLoggerTextField1,
            JTextField propertiesConsoleLoggerTextField2,
            JTextField propertiesConsoleLoggerTextField3,
            JTextField propertiesConsoleLoggerTextField4,
            JTextField propertiesConsoleLoggerTextField5,
            JTextField propertiesConsoleLoggerTextField6,
            JTextField propertiesConsoleLoggerTextField7,
            JTextField propertiesConsoleLoggerTextField8,
            JTextField propertiesConsoleLoggerTextField9,
            JButton propertiesConsoleLoggerbutton1
    ) {
        super();
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField1 = propertiesConsoleLoggerTextField1;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField2 = propertiesConsoleLoggerTextField2;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField3 = propertiesConsoleLoggerTextField3;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField4 = propertiesConsoleLoggerTextField4;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField5 = propertiesConsoleLoggerTextField5;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField6 = propertiesConsoleLoggerTextField6;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField7 = propertiesConsoleLoggerTextField7;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField8 = propertiesConsoleLoggerTextField8;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField9 = propertiesConsoleLoggerTextField9;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerbutton1 = propertiesConsoleLoggerbutton1;
    }

    public PropertiesConsoleLoggerToolSetup() {
        setup();
    }


    public void setup() {
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField9.setText(ConsoleLoggerSettings.getPattern(0));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField1.setText(ConsoleLoggerSettings.getPattern(1));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField2.setText(ConsoleLoggerSettings.getPattern(2));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField3.setText(ConsoleLoggerSettings.getPattern(3));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField4.setText(ConsoleLoggerSettings.getPattern(4));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField5.setText(ConsoleLoggerSettings.getPattern(5));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField6.setText(ConsoleLoggerSettings.getPattern(6));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField7.setText(ConsoleLoggerSettings.getPattern(7));
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerTextField8.setText(ConsoleLoggerSettings.getPattern(8));
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