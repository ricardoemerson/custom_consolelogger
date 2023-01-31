package com.github.bgomar.consolelogger

import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.dsl.builder.toMutableProperty
import java.awt.Dimension
import javax.swing.JComponent

enum class Scope { CURRENT_FILE, PROJECT }

class ConsoleLoggerRemoveDlg : DialogWrapper(false) {
  var scope: Scope

  init {
    title = "Remove ConsoleLogger's Logs"
    scope = Scope.CURRENT_FILE
    init()
  }

  override fun createCenterPanel(): JComponent {
    val pan = panel {
      buttonsGroup("Choose Scope:") {
        row {
          radioButton("Current file", Scope.CURRENT_FILE)
        }
        row {
          radioButton("Project", Scope.PROJECT)
        }
      }.bind(::scope.toMutableProperty(), Scope::class.java)
    }

    pan.minimumSize = Dimension(300, 100)
    return pan
  }
}
