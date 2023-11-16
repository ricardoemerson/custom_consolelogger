package com.github.bgomar.consolelogger

import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.notification.NotificationType
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import com.github.bgomar.consolelogger.settings.ConsoleLoggerSettings

fun properties() {  }


class UpdateNotify : StartupActivity {
  private val plugin = PluginManagerCore.getPlugin(PluginId.getId("com.github.bgomar.consolelogger"))!!

  override fun runActivity(project: Project) {
    val settings = ConsoleLoggerSettings.instance
    if (settings.version.toString() == "Unknown") {
      settings.version = com.github.bgomar.consolelogger.settings.properties("pluginVersion")
    } else if (plugin.version.toString() != settings.version.toString()) {
      settings.version = com.github.bgomar.consolelogger.settings.properties("pluginVersion")
      showUpdate(project)
    }
  }

  private val updateContent: String by lazy {
    //language=HTML
    """
     🤏 🐛 Small Bugfix:  <br/>
    FIX: Handle cases where the editor might be missing. <br>

    🦄 You can always <b>change defaults<b> in settings (ctrl + alt + S)<br>
    <b>Settings || Tools || ConsoleLogger</b>
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