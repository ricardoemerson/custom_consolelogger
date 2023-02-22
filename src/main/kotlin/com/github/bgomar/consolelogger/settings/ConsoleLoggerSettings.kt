package com.github.bgomar.consolelogger.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import org.jetbrains.annotations.Nullable

internal const val DEFAULT_CONSOLELOGGER_PATTERN = """console.log("%c (ln{LN}) $$: ", "color:#09A59A;", $$);"""
internal const val DEBUG_CONSOLELOGGER_PATTERN = """console.debug("%c (ln{LN}) $$: ", "color:#09A59A;", $$);"""
internal const val WARN_CONSOLELOGGER_PATTERN = """console.warn("%c (ln{LN}) $$: ", "color:#09A59A;", $$);"""
internal const val ERROR_CONSOLELOGGER_PATTERN = """console.error("%c ({FP}:{LN}) $$: ", "color:#09A59A;", $$);"""
internal const val GROUP_CONSOLELOGGER_PATTERN = """${'\n'}console.groupCollapsed("%c (ln{LN}) group $$", "color:#09A59A;");${'\n'}console.groupEnd("end of group $$");"""
internal const val TABLE_CONSOLELOGGER_PATTERN = """console.table($$);"""


@State(name = "ConsoleLoggerSettings", storages = [(Storage("consolelogger.xml"))])
class ConsoleLoggerSettings : PersistentStateComponent<ConsoleLoggerSettings> {

  var defaultPattern: String = DEFAULT_CONSOLELOGGER_PATTERN
  var groupPattern: String = GROUP_CONSOLELOGGER_PATTERN
  var debugPattern: String = DEBUG_CONSOLELOGGER_PATTERN
  var warnPattern: String = WARN_CONSOLELOGGER_PATTERN
  var errorPattern: String = ERROR_CONSOLELOGGER_PATTERN
  var tablePattern: String = TABLE_CONSOLELOGGER_PATTERN

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
