package com.github.bgomar.bgdevtoys.tools;

import com.github.bgomar.bgdevtoys.toolwindow.setup.PropertiesConsoleLoggerToolSetup;
import com.intellij.openapi.ui.DialogPanel;
import com.intellij.ui.components.JBTextField;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class ConsoleLoggerTools extends PropertiesConsoleLoggerToolSetup {
    public ConsoleLoggerTools(JTextArea propertiesConsoleLoggerTextArea1, JTextArea propertiesConsoleLoggerTextArea2, JTextArea propertiesConsoleLoggerTextArea3, JTextArea propertiesConsoleLoggerTextArea4, JTextArea propertiesConsoleLoggerTextArea5, JTextArea propertiesConsoleLoggerTextArea6, JTextArea propertiesConsoleLoggerTextArea7, JTextArea propertiesConsoleLoggerTextArea8, JTextArea propertiesConsoleLoggerTextArea9) {
        super( propertiesConsoleLoggerTextArea1, propertiesConsoleLoggerTextArea2, propertiesConsoleLoggerTextArea3, propertiesConsoleLoggerTextArea4, propertiesConsoleLoggerTextArea5, propertiesConsoleLoggerTextArea6, propertiesConsoleLoggerTextArea7, propertiesConsoleLoggerTextArea8, propertiesConsoleLoggerTextArea9);
    }

    public static class ConsoleLoggerConfig extends PropertiesConsoleLoggerToolSetup {
        public ConsoleLoggerConfig(@NotNull ConsoleLoggerSettings setting) {
            super();

            ui = new DialogPanel();
            ui.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;

            JBTextField[] textFields = new JBTextField[9];

            for (int i = 1; i < 9; i++) {

                ui.add(new JTextField("(CTRL + ALT + " + i + ") "), gbc);
                gbc.gridx++;

                textFields[i] = new JBTextField();
                textFields[i].setText(ConsoleLoggerSettings.getPattern(i));
                textFields[i].setToolTipText("Tooltip for pattern " + i);
                ui.add(textFields[i], gbc);
                gbc.gridx++;

                JButton defaultButton = new JButton("Default");
                int finalIndex = i; // Need to make the index final for lambda expression
                defaultButton.addActionListener(e -> textFields[finalIndex - 1].setText(ConsoleLoggerSettings.getPattern(finalIndex)));
                defaultButton.setToolTipText("Reset to default pattern");
                ui.add(defaultButton, gbc);
                gbc.gridx = 0; // Reset grid column for the next row
                gbc.gridy++;
            }
        }


    }
}