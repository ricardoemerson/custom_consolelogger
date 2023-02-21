package com.github.bgomar.consolelogger

import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.notification.NotificationType
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import com.github.bgomar.consolelogger.settings.ConsoleLoggerSettings

class UpdateNotify : StartupActivity {
  private val plugin = PluginManagerCore.getPlugin(PluginId.getId("com.github.bgomar.consolelogger"))!!

  override fun runActivity(project: Project) {
    val settings = ConsoleLoggerSettings.instance
    if (settings.version == "Unknown") {
      settings.version = plugin.version
    } else if (plugin.version != settings.version) {
      settings.version = plugin.version
      showUpdate(project)
    }
  }

  private val updateContent: String by lazy {
    //language=HTML
    """
    <br/>
    In this version you'll find the ability<br><br>
    👉 to use  <b>console.</b> with  <b>log, debug, warn, error, info, table</b> press CTRL + ALT + (1 to 6)  <br>
    See ConsoleLogger Settings<br><br>
    👉 to remove ConsoleLogger's logs from the <b>current file</b> or the <b>project</b>  press CTRL + ALT + 0<br>
    See ConsoleLogger in <b>Code | ConsoleLogger</b>
    """
  }

  private fun showUpdate(project: Project) {
    val notification = createNotification(
      "ConsoleLogger plugin updated to version ${plugin.version}",
      updateContent,
      NotificationType.INFORMATION
    )
    showFullNotification(project, notification)
  }
}
