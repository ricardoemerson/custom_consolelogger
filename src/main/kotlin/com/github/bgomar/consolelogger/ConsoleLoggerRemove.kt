package com.github.bgomar.consolelogger

import com.intellij.find.FindModel
import com.intellij.find.FindUtil
import com.intellij.find.replaceInProject.ReplaceInProjectManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.github.bgomar.consolelogger.settings.ConsoleLoggerSettings


class ConsoleLoggerRemove : AnAction("Remove ConsoleLogger's Logs") {
  override fun actionPerformed(e: AnActionEvent) {
    // display the dialog
    val dlg = ConsoleLoggerRemoveDlg()
    if (!dlg.showAndGet()) return

    val project = e.getData(CommonDataKeys.PROJECT)!!
    val editor = e.getRequiredData(CommonDataKeys.EDITOR)

    val removeLog: String = ".*" + ConsoleLoggerSettings.instance.defaultPattern.run {
      replace("\\", "\\\\")
        .replace("(", "\\(")
        .replace(")", "\\)")
        .replace("[", "\\[")
        .replace("]", "\\]")
        .replace("^", "\\^")
        .replace("+", "\\+")
        .replace("?", "\\?")
        .replace("|", "\\|")
        .replace(".", "\\.")
        .replace("*", "\\*")
        .replace("$$", ".*")
        .replace("{FN}", ".*")
        .replace("{FP}", ".*")
        .replace("{LN}", "\\d*")
        .replace("{", "\\{")
        .replace("}", "\\}")
        .replace("$", "\\$")
    } + "\n"

    val findLog = FindModel().apply {
      stringToFind = removeLog
      stringToReplace = ""
      isPromptOnReplace = false
      isRegularExpressions = true
      isGlobal = true
      isPromptOnReplace = false
    }

    val removeInfo: String = ".*" + ConsoleLoggerSettings.instance.infoPattern.run {
      replace("\\", "\\\\")
        .replace("(", "\\(")
        .replace(")", "\\)")
        .replace("[", "\\[")
        .replace("]", "\\]")
        .replace("^", "\\^")
        .replace("+", "\\+")
        .replace("?", "\\?")
        .replace("|", "\\|")
        .replace(".", "\\.")
        .replace("*", "\\*")
        .replace("$$", ".*")
        .replace("{FN}", ".*")
        .replace("{FP}", ".*")
        .replace("{LN}", "\\d*")
        .replace("{", "\\{")
        .replace("}", "\\}")
        .replace("$", "\\$")
    } + "\n"

    val findInfo = FindModel().apply {
      stringToFind = removeInfo
      stringToReplace = ""
      isPromptOnReplace = false
      isRegularExpressions = true
      isGlobal = true
      isPromptOnReplace = false
    }

    val removeDebug: String = ".*" + ConsoleLoggerSettings.instance.debugPattern.run {
      replace("\\", "\\\\")
        .replace("(", "\\(")
        .replace(")", "\\)")
        .replace("[", "\\[")
        .replace("]", "\\]")
        .replace("^", "\\^")
        .replace("+", "\\+")
        .replace("?", "\\?")
        .replace("|", "\\|")
        .replace(".", "\\.")
        .replace("*", "\\*")
        .replace("$$", ".*")
        .replace("{FN}", ".*")
        .replace("{FP}", ".*")
        .replace("{LN}", "\\d*")
        .replace("{", "\\{")
        .replace("}", "\\}")
        .replace("$", "\\$")
    } + "\n"

    val findDebug = FindModel().apply {
      stringToFind = removeDebug
      stringToReplace = ""
      isPromptOnReplace = false
      isRegularExpressions = true
      isGlobal = true
      isPromptOnReplace = false
    }

    val removeWarn: String = ".*" + ConsoleLoggerSettings.instance.warnPattern.run {
      replace("\\", "\\\\")
        .replace("(", "\\(")
        .replace(")", "\\)")
        .replace("[", "\\[")
        .replace("]", "\\]")
        .replace("^", "\\^")
        .replace("+", "\\+")
        .replace("?", "\\?")
        .replace("|", "\\|")
        .replace(".", "\\.")
        .replace("*", "\\*")
        .replace("$$", ".*")
        .replace("{FN}", ".*")
        .replace("{FP}", ".*")
        .replace("{LN}", "\\d*")
        .replace("{", "\\{")
        .replace("}", "\\}")
        .replace("$", "\\$")
    } + "\n"

    val findWarn = FindModel().apply {
      stringToFind = removeWarn
      stringToReplace = ""
      isPromptOnReplace = false
      isRegularExpressions = true
      isGlobal = true
      isPromptOnReplace = false
    }

    val removeError: String = ".*" + ConsoleLoggerSettings.instance.errorPattern.run {
      replace("\\", "\\\\")
        .replace("(", "\\(")
        .replace(")", "\\)")
        .replace("[", "\\[")
        .replace("]", "\\]")
        .replace("^", "\\^")
        .replace("+", "\\+")
        .replace("?", "\\?")
        .replace("|", "\\|")
        .replace(".", "\\.")
        .replace("*", "\\*")
        .replace("$$", ".*")
        .replace("{FN}", ".*")
        .replace("{FP}", ".*")
        .replace("{LN}", "\\d*")
        .replace("{", "\\{")
        .replace("}", "\\}")
        .replace("$", "\\$")
    } + "\n"
    val findError = FindModel().apply {
      stringToFind = removeError
      stringToReplace = ""
      isPromptOnReplace = false
      isRegularExpressions = true
      isGlobal = true
      isPromptOnReplace = false
    }
    val removeTable: String = ".*" + ConsoleLoggerSettings.instance.tablePattern.run {
      replace("\\", "\\\\")
        .replace("(", "\\(")
        .replace(")", "\\)")
        .replace("[", "\\[")
        .replace("]", "\\]")
        .replace("^", "\\^")
        .replace("+", "\\+")
        .replace("?", "\\?")
        .replace("|", "\\|")
        .replace(".", "\\.")
        .replace("*", "\\*")
        .replace("$$", ".*")
        .replace("{FN}", ".*")
        .replace("{FP}", ".*")
        .replace("{LN}", "\\d*")
        .replace("{", "\\{")
        .replace("}", "\\}")
        .replace("$", "\\$")
    } + "\n"
    val findTable = FindModel().apply {
      stringToFind = removeTable
      stringToReplace = ""
      isPromptOnReplace = false
      isRegularExpressions = true
      isGlobal = true
      isPromptOnReplace = false
    }



    when (dlg.scope) {
      Scope.CURRENT_FILE ->
                FindUtil.replace(project, editor, 0, findLog) &&
                FindUtil.replace(project, editor, 0, findInfo) &&
                FindUtil.replace(project, editor, 0, findDebug) &&
                FindUtil.replace(project, editor, 0, findWarn) &&
                FindUtil.replace(project, editor, 0, findError) &&
                FindUtil.replace(project, editor, 0, findTable)
      Scope.PROJECT -> {
                ReplaceInProjectManager(project).replaceInPath(findLog);
                ReplaceInProjectManager(project).replaceInPath(findInfo);
                ReplaceInProjectManager(project).replaceInPath(findDebug);
                ReplaceInProjectManager(project).replaceInPath(findWarn);
                ReplaceInProjectManager(project).replaceInPath(findError);
                ReplaceInProjectManager(project).replaceInPath(findTable);
      }
    }
  }
}
