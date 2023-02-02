package com.github.bgomar.consolelogger.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import org.jetbrains.annotations.Nullable

internal const val DEFAULT_CONSOLELOGGER_PATTERN = """console.log("=>({FN}:{LN}) $$", $$);"""

@State(name = "ConsoleLoggerSettings", storages = [(Storage("log_it.xml"))])
class ConsoleLoggerSettings : PersistentStateComponent<ConsoleLoggerSettings> {

  var pattern: String = DEFAULT_CONSOLELOGGER_PATTERN
  var version = "Unknown"

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
