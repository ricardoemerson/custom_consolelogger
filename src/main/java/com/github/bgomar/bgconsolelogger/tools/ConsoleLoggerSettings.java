package com.github.bgomar.bgconsolelogger.tools;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "ConsoleLoggerSettings", storages = {@Storage("consolelogger.xml")})
public class ConsoleLoggerSettings implements PersistentStateComponent<ConsoleLoggerSettings> {

    public static final String DEFAULT_PATTERN_1 =  "log('$$: ${$$}');";
    public static final String DEFAULT_PATTERN_2 =  "log('Exception: ${$$}', error: err, stackTrace: s);";
    public static final String DEFAULT_PATTERN_3 =  "=>";

    public static final String DEFAULT_PATTERN_4 =  "Colors.";
    public static final String DEFAULT_PATTERN_5 =  "Icon(Icons.)";
    public static final String DEFAULT_PATTERN_6 =  "FaIcon(FontAwesomeIcons.)";

    public static final String DEFAULT_PATTERN_7 =  "controller.";
    public static final String DEFAULT_PATTERN_8 =  "System.out.println(\"$$ = \" + $$);";
    public static final String DEFAULT_PATTERN_9 =  "System.out.println($$);";

    private static final String[] patterns = {
            DEFAULT_PATTERN_1,
            DEFAULT_PATTERN_2,
            DEFAULT_PATTERN_3,
            DEFAULT_PATTERN_4,
            DEFAULT_PATTERN_5,
            DEFAULT_PATTERN_6,
            DEFAULT_PATTERN_7,
            DEFAULT_PATTERN_8,
            DEFAULT_PATTERN_9
    };

    public String version = "0.0.23";

    public static ConsoleLoggerSettings getInstance() {
        return ApplicationManager.getApplication().getService(ConsoleLoggerSettings.class);
    }

    @Nullable
    @Override
    public ConsoleLoggerSettings getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull ConsoleLoggerSettings state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public static String getPattern(int index) {
        if (index >= 0 && index < patterns.length) {
            return patterns[index];
        } else {
            return patterns[index-1];
        }
    }
}
