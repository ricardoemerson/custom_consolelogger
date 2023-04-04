package com.github.bgomar.consolelogger.settings

import com.intellij.openapi.options.ConfigurableUi
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.components.JBTextField
import com.intellij.ui.dsl.builder.*
import com.intellij.ui.dsl.gridLayout.HorizontalAlign
import javax.swing.JComponent


class ConsoleLoggerConfigurableUI(setting: ConsoleLoggerSettings) : ConfigurableUi<ConsoleLoggerSettings> {
  private val ui: DialogPanel = panel {
    var logField: Cell<JBTextField>
    row("(CTRL + ALT + 1) log: ") {
      logField = textField()
        .bindText(setting::logPattern)
        .horizontalAlign(HorizontalAlign.FILL)
        .gap(RightGap.SMALL)
        .resizableColumn().apply {
          component.toolTipText = "Use \$\$ for selected variable, {FP} filepath, {FN} filename, {LN} line number, %c for ,color=#fff"
        }

      button("Default", actionListener = {
        logField.component.text = LOG_CONSOLELOGGER_PATTERN
      }).apply {
        component.toolTipText = "Reset to default pattern"
      }
    }.layout(RowLayout.PARENT_GRID)

    var debugField: Cell<JBTextField>
    row("(CTRL + ALT + 2) debug: ") {
      debugField = textField()
        .bindText(setting::debugPattern)
        .horizontalAlign(HorizontalAlign.FILL)
        .gap(RightGap.SMALL)
        .resizableColumn().apply {
          component.toolTipText = "Use \$\$ for selected variable, {FP} filepath, {FN} filename, {LN} line number"
        }

      button("Default", actionListener = {
        debugField.component.text = DEBUG_CONSOLELOGGER_PATTERN
      }).apply {
        component.toolTipText = "Reset to default pattern"
      }
    }.layout(RowLayout.PARENT_GRID)

    var warnField: Cell<JBTextField>
    row("(CTRL + ALT + 3) warn: ") {
      warnField = textField()
        .bindText(setting::warnPattern)
        .horizontalAlign(HorizontalAlign.FILL)
        .gap(RightGap.SMALL)
        .resizableColumn().apply {
          component.toolTipText = "Use \$\$ for selected variable, {FP} filepath, {FN} filename, {LN} line number"
        }

      button("Default", actionListener = {
        warnField.component.text = WARN_CONSOLELOGGER_PATTERN
      }).apply {
        component.toolTipText = "Reset to default pattern"
      }
    }.layout(RowLayout.PARENT_GRID)

    var errorField: Cell<JBTextField>
    row("(CTRL + ALT + 4) error: ") {
      errorField = textField()
        .bindText(setting::errorPattern)
        .horizontalAlign(HorizontalAlign.FILL)
        .gap(RightGap.SMALL)
        .resizableColumn().apply {
          component.toolTipText = "Use \$\$ for selected variable, {FP} filepath, {FN} filename, {LN} line number"
        }

      button("Default", actionListener = {
        errorField.component.text = ERROR_CONSOLELOGGER_PATTERN
      }).apply {
        component.toolTipText = "Reset to default pattern"
      }
    }.layout(RowLayout.PARENT_GRID)

    var groupField: Cell<JBTextField>
    row("(CTRL + ALT + 5) group: ") {
      groupField = textField()
        .bindText(setting::groupPattern)
        .horizontalAlign(HorizontalAlign.FILL)
        .gap(RightGap.SMALL)
        .resizableColumn().apply {
          component.toolTipText = "Use \$\$ for selected variable, {FP} filepath, {FN} filename, {LN} line number"
        }

      button("Default", actionListener = {
        groupField.component.text = GROUP_CONSOLELOGGER_PATTERN
      }).apply {
        component.toolTipText = "Reset to default pattern"
      }
    }.layout(RowLayout.PARENT_GRID)

    var tableField: Cell<JBTextField>
    row("(CTRL + ALT + 6) table: ") {
      tableField = textField()
        .bindText(setting::tablePattern)
        .horizontalAlign(HorizontalAlign.FILL)
        .gap(RightGap.SMALL)
        .resizableColumn().apply {
          component.toolTipText = "Only \$\$ for selected table works."
        }

      button("Default", actionListener = {
        tableField.component.text = TABLE_CONSOLELOGGER_PATTERN
      }).apply {
        component.toolTipText = "Reset to default pattern"
      }
    }.layout(RowLayout.PARENT_GRID)
  }

  override fun reset(settings: ConsoleLoggerSettings) {
    ui.reset()
  }

  override fun isModified(settings: ConsoleLoggerSettings): Boolean {
    return ui.isModified()
  }

  override fun apply(settings: ConsoleLoggerSettings) {
    ui.apply()
  }

  override fun getComponent(): JComponent {
    return ui
  }
}
