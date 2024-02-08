
<h1 align="center">
    <a href="">
      <img src="./src/main/resources/META-INF/pluginIcon.svg" width="84" height="84" alt="logo"/>
    </a><br/>
    BG-DevToys
</h1>

An Intellij IDEA plugin.
Find useful tools in a Tool Window in the top right corner of your IDE:

**Work in progress**: 😎.
## Download

Download plugin from the JetBrains marketplace or via your IDE: <kbd>File</kbd>, <kbd>Settings...</kbd>, <kbd>Plugins</kbd>, <kbd>Marketplace</kbd> then select `BG-DevToys`.

## ToDo
* improve the GUI
    * settings: remember last opened tool
* add more tools, like Base64 from file, GZip encoder/decoder, JWT encoder/decoder, text tools, graphics tools...

Nota: I think we don't need to reproduce tools that exist in IntelliJ already, like the regex tester, diff viewer, conflict resolver, and markdown previewer.


# ![Build](./src/main/resources/META-INF/pluginIcon.svg) Console Logger JetBrains Plugin

<!-- Plugin description -->
#### `CTRL + ALT + (1-9)` for console.logs  
May need personal adjustments in settings.    
This project is heavily based on LogIt by Laurent Soulet

Defaults for CTRL + ALT + (1-9)  
(1) = `console.log("%c ---> $$: ","color:#F0F;", $$);`          
(2) = `console.debug("%c ---> $$: ","color:#0F0;", $$);`          
(3) = `console.warn("%c ---> $$: ","color:#F00;", $$);`          
(4) = `Serial.print(" ---> $$: ", $$);`           
(5) = `cout << "      ---> $$: " << $$ << endl;`           
(6) = `print("{:>30}".format(" ---> $$: " + $$))`         
(7) = `console.error("%c ({FP}:{LN}) $$: ", "color:#FF0;", $$);`      
(8) = `console.groupCollapsed("group $$");'\n' console.groupEnd("end of group $$");`      
(9) = `console.table($$);`      
(0) = `remove all loggers (unedited)`      

## Example of ConsoleLogger  
#### [<img src="https://github.com/bg-omar/consolelogger/blob/master/.github/pics/preview1.png?raw=true" width="500px"/>]()  
#### `Ctrl + Alt + 1`  on the `someReturn(theVariable);`  
#### [<img src="https://github.com/bg-omar/consolelogger/blob/master/.github/pics/preview2.png?raw=true" width="500px%"/>]()  
#### Which will show in console
#### [<img src="https://github.com/bg-omar/consolelogger/blob/master/.github/pics/preview3.png?raw=true" width="500px%"/>]()  
## Remove all loggers  
#### `(CTRL + ALT + 0)`  
#### [<img src="https://github.com/bg-omar/consolelogger/blob/master/.github/pics/preview6.png?raw=true" width="300px%"/>]()  
### `Settings` -> `Tools` -> `ConsoleLogger`  
#### [<img src="https://github.com/bg-omar/consolelogger/blob/master/.github/pics/SettingPreview.png?raw=true" width="500px%"/>]()  
<!-- Plugin description end -->
