package com.github.bgomar.bgdevtoys.toolwindow.setup;

import com.github.bgomar.bgdevtoys.tools.ConsoleLoggerSettings;
import com.github.bgomar.bgdevtoys.tools.PropertiesConsoleLoggerTools;
import com.intellij.openapi.options.ConfigurableUi;
import com.intellij.openapi.ui.DialogPanel;
import com.intellij.ui.components.JBTextField;
import org.jetbrains.annotations.NotNull;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PropertiesConsoleLoggerToolSetup  extends AbstractToolSetup implements ConfigurableUi<ConsoleLoggerSettings> {
    private static JTextArea propertiesConsoleLoggerPropertiesTextArea = new JTextArea();
    private static JTextArea propertiesConsoleLoggerConsoleLoggerTextArea = new JTextArea();
    private static DialogPanel ui;
    public PropertiesConsoleLoggerToolSetup(JTextArea propertiesConsoleLoggerPropertiesTextArea,
                                            JTextArea propertiesConsoleLoggerConsoleLoggerTextArea) {
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerPropertiesTextArea = propertiesConsoleLoggerPropertiesTextArea;
        PropertiesConsoleLoggerToolSetup.propertiesConsoleLoggerConsoleLoggerTextArea = propertiesConsoleLoggerConsoleLoggerTextArea;
    }


    public void setup() {
        propertiesConsoleLoggerPropertiesTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateTextAreas();
            }
        });
    }

    private void updateTextAreas() {
        propertiesConsoleLoggerConsoleLoggerTextArea.setText(PropertiesConsoleLoggerTools.propertiesToConsoleLogger(
                propertiesConsoleLoggerPropertiesTextArea.getText()
        ));
        propertiesConsoleLoggerConsoleLoggerTextArea.setCaretPosition(0);
        updateWithBestNumberOfRows(propertiesConsoleLoggerPropertiesTextArea, propertiesConsoleLoggerConsoleLoggerTextArea);
    }

    @Override
    public void reset(ConsoleLoggerSettings settings) {
        ui.reset();
    }

    @Override
    public boolean isModified(ConsoleLoggerSettings settings) {
        return ui.isModified();
    }

    @Override
    public void apply(ConsoleLoggerSettings settings) {
        ui.apply();
    }

    @Override
    public JComponent getComponent() {
        return ui;
    }

    public static class ConsoleLoggerConfig extends PropertiesConsoleLoggerToolSetup {
        public ConsoleLoggerConfig(@NotNull ConsoleLoggerSettings setting) {
            super(propertiesConsoleLoggerPropertiesTextArea,
                    propertiesConsoleLoggerConsoleLoggerTextArea);
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
                textFields[i].setText(setting.getPattern(i));
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
