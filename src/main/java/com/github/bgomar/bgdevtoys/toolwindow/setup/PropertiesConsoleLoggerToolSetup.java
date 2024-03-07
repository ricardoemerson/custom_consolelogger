package com.github.bgomar.bgdevtoys.toolwindow.setup;

import com.github.bgomar.bgdevtoys.tools.PropertiesConsoleLoggerTools;


import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PropertiesConsoleLoggerToolSetup extends AbstractToolSetup {


    private final JTextArea propertiesConsoleLoggerPropertiesTextArea;
    private final JTextArea propertiesConsoleLoggerConsoleLoggerTextArea;

    public PropertiesConsoleLoggerToolSetup(JTextArea propertiesConsoleLoggerPropertiesTextArea,
                                            JTextArea propertiesConsoleLoggerConsoleLoggerTextArea) {
        this.propertiesConsoleLoggerPropertiesTextArea = propertiesConsoleLoggerPropertiesTextArea;
        this.propertiesConsoleLoggerConsoleLoggerTextArea = propertiesConsoleLoggerConsoleLoggerTextArea;
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
}