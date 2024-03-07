package com.github.bgomar.consolelogger

import com.intellij.find.FindModel
import com.intellij.find.FindUtil
import com.intellij.find.replaceInProject.ReplaceInProjectManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.github.bgomar.bgdevtoys.tools.ConsoleLoggerSettings


class ConsoleLoggerRemove : AnAction("Remove ConsoleLogger's Logs") {
  override fun actionPerformed(e: AnActionEvent) {
    // display the dialog
    val dlg = ConsoleLoggerRemoveDlg()
    if (!dlg.showAndGet()) return

    val project = e.getData(CommonDataKeys.PROJECT)!!
    val editor = e.getRequiredData(CommonDataKeys.EDITOR)

    val removeLog1: String = ".*" + ConsoleLoggerSettings.getPattern(1).run {
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
    val findLog1 = FindModel().apply {
      stringToFind = removeLog1
      stringToReplace = ""
      isPromptOnReplace = false
      isRegularExpressions = true
      isGlobal = true
      isPromptOnReplace = false
    }

    val removeLog2: String = ".*" + ConsoleLoggerSettings.getPattern(2).run {
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
    val findLog2 = FindModel().apply {
      stringToFind = removeLog2
      stringToReplace = ""
      isPromptOnReplace = false
      isRegularExpressions = true
      isGlobal = true
      isPromptOnReplace = false
    }

    val removeLog3: String = ".*" + ConsoleLoggerSettings.getPattern(3).run {
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
    val findLog3 = FindModel().apply {
      stringToFind = removeLog3
      stringToReplace = ""
      isPromptOnReplace = false
      isRegularExpressions = true
      isGlobal = true
      isPromptOnReplace = false
    }

    val removeLog4: String = ".*" + ConsoleLoggerSettings.getPattern(4).run {
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
    val findLog4 = FindModel().apply {
      stringToFind = removeLog4
      stringToReplace = ""
      isPromptOnReplace = false
      isRegularExpressions = true
      isGlobal = true
      isPromptOnReplace = false
    }

    val removeLog5: String = ".*" + ConsoleLoggerSettings.getPattern(5).run {
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
    val findLog5 = FindModel().apply {
      stringToFind = removeLog5
      stringToReplace = ""
      isPromptOnReplace = false
      isRegularExpressions = true
      isGlobal = true
      isPromptOnReplace = false
    }

    val removeLog6: String = ".*" + ConsoleLoggerSettings.getPattern(6).run {
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
    val findLog6 = FindModel().apply {
      stringToFind = removeLog6
      stringToReplace = ""
      isPromptOnReplace = false
      isRegularExpressions = true
      isGlobal = true
      isPromptOnReplace = false
    }

    val removeError: String = ".*" + ConsoleLoggerSettings.getPattern(7).run {
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

    val removeGroup: String = ".*" + ConsoleLoggerSettings.getPattern(8).run {
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
    val findGroup = FindModel().apply {
      stringToFind = removeGroup
      stringToReplace = ""
      isPromptOnReplace = false
      isRegularExpressions = true
      isGlobal = true
      isPromptOnReplace = false
    }

    val removeTable: String = ".*" + ConsoleLoggerSettings.getPattern(9).run {
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
                FindUtil.replace(project, editor, 0, findLog1) &&
                FindUtil.replace(project, editor, 0, findLog2) &&
                FindUtil.replace(project, editor, 0, findLog3) &&
                FindUtil.replace(project, editor, 0, findLog4) &&
                FindUtil.replace(project, editor, 0, findLog5) &&
                FindUtil.replace(project, editor, 0, findLog6) &&
                FindUtil.replace(project, editor, 0, findError) &&
                FindUtil.replace(project, editor, 0, findTable) &&
                FindUtil.replace(project, editor, 0, findGroup)
      Scope.PROJECT -> {
                ReplaceInProjectManager(project).replaceInPath(findLog1);
                ReplaceInProjectManager(project).replaceInPath(findLog2);
                ReplaceInProjectManager(project).replaceInPath(findLog3);
                ReplaceInProjectManager(project).replaceInPath(findLog4);
                ReplaceInProjectManager(project).replaceInPath(findLog5);
                ReplaceInProjectManager(project).replaceInPath(findLog6);
                ReplaceInProjectManager(project).replaceInPath(findError);
                ReplaceInProjectManager(project).replaceInPath(findTable);
                ReplaceInProjectManager(project).replaceInPath(findGroup);
      }
    }
  }
}
