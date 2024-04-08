package com.github.bgomar.consolelogger.settings

import org.jetbrains.annotations.Nullable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

internal const val DEFAULT_PATTERN_1 = "log('$$: \${$$}');"
internal const val DEFAULT_PATTERN_2 = "log('Exception: \${$$}', error: err, stackTrace: s);"
internal const val DEFAULT_PATTERN_3 = "=>"

internal const val DEFAULT_PATTERN_4 = "Colors."
internal const val DEFAULT_PATTERN_5 = "Icon(Icons.)"
internal const val DEFAULT_PATTERN_6 = "FaIcon(FontAwesomeIcons.)"

internal const val DEFAULT_PATTERN_7 = "controller."
internal const val DEFAULT_PATTERN_8 = "System.out.println(\"$$ = \" + $$);"
internal const val DEFAULT_PATTERN_9 = "System.out.println($$);"


@State(name = "ConsoleLoggerSettings", storages = [(Storage("consolelogger.xml"))])
class ConsoleLoggerSettings : PersistentStateComponent<ConsoleLoggerSettings> {


  var pattern1: String = DEFAULT_PATTERN_1
  var pattern2: String = DEFAULT_PATTERN_2
  var pattern3: String = DEFAULT_PATTERN_3
  var pattern4: String = DEFAULT_PATTERN_4
  var pattern5: String = DEFAULT_PATTERN_5
  var pattern6: String = DEFAULT_PATTERN_6
  var pattern7: String = DEFAULT_PATTERN_7
  var pattern8: String = DEFAULT_PATTERN_8
  var pattern9: String = DEFAULT_PATTERN_9

  var version = "0.0.23"
  companion object {
    val instance: ConsoleLoggerSettings
      get() = ApplicationManager.getApplication().getService(ConsoleLoggerSettings::class.java)
  }

  @Nullable
  override fun getState(): ConsoleLoggerSettings = this

  override fun loadState(state: ConsoleLoggerSettings) {
    XmlSerializerUtil.copyBean(state, this)
  }


}
