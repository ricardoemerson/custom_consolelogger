package com.github.bgomar.bgdevtoys.tools;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

@State(name = "ConsoleLoggerSettings", storages = {@Storage("consolelogger.xml")})
public class ConsoleLoggerSettings implements PersistentStateComponent<ConsoleLoggerSettings> {

    public static final String DEFAULT_PATTERN_1 = "console.log(\"%c ---> $$: \",\"color:#F0F;\", $$);";
    public static final String DEFAULT_PATTERN_2 = "console.log(\"%c ---> $$: \",\"color:#0F0;\", $$);";
    public static final String DEFAULT_PATTERN_3 = "console.warn(\"%c ---> $$: \",\"color:#F00;\", $$);";
    public static final String DEFAULT_PATTERN_4 = "Serial.println($$);";
    public static final String DEFAULT_PATTERN_5 = "cout << \"      ---> $$: \" << $$ << endl;";
    public static final String DEFAULT_PATTERN_6 = "print(\"{:>30}\".format(\" ---> $$: \" + $$));";
    public static final String DEFAULT_PATTERN_7 = "console.error(\"%c ({FP}:{LN}) $$: \", \"color:#FF0;\", $$);";
    public static final String DEFAULT_PATTERN_8 = "${'\n'}console.groupCollapsed(\"group $$\");" +
            "${'\n'}console.groupEnd(\"end of group $$\");";
    public static final String DEFAULT_PATTERN_9 = "console.table($$);";

    private static String[] patterns = {
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

    public String version = "Unknown";

    public static ConsoleLoggerSettings getInstance() {
        return ApplicationManager.getApplication().getService(ConsoleLoggerSettings.class);
    }

    @Nullable
    @Override
    public ConsoleLoggerSettings getState() {
        return this;
    }

    @Override
    public void loadState(ConsoleLoggerSettings state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public static String getPattern(int index) {
        return patterns[index];
    }
}
