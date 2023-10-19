# ![Build](./src/main/resources/META-INF/pluginIcon.svg) Console Logger IntelliJ Plugin

<!-- Plugin description -->
An Intellij Plugin to create Javascript logs from selection.
(CTRL + ALT + 1) `console.log( -----> $$: ", $$);`
(CTRL + ALT + 2) `console.debug( -----> $$: ", $$);`
(CTRL + ALT + 3) `console.log("%c ---> $$: ","color:#F0F;", $$);`
(CTRL + ALT + 4) `console.log("%c ---> $$: ","color:#0F0;", $$);`
(CTRL + ALT + 5) `console.warn("%c ---> $$: ","color:#F00;", $$);`
(CTRL + ALT + 6) `console.warn("%c ---> $$: ","color:#00F;", $$);`

If you want to console.log  `this.variable`  from below, 

```ts
  this.variable = someThing + otherThing
```
With `this.variable` selected, (ctrl + alt + 1) gives you this result:

```ts
  this.variable = someThing + otherThing
  console.log(" ---> this.variable: ", this.variable);
```


In the Settings -> Tools -> ConsoleLogger you can modify `ctrl+alt+(1-6)`

  (CTRL + ALT + 0) removes all unedited console loggers from file or project

#### [<img src="https://github.com/bg-omar/consolelogger/blob/master/.github/pics/preview2.png?raw=true" width="90%"/>]()
#### [<img src="https://github.com/bg-omar/consolelogger/blob/master/.github/pics/preview3.png?raw=true" width="90%"/>]()

#### [<img src="https://github.com/bg-omar/consolelogger/blob/master/.github/pics/preview6.png?raw=true" width="45%"/>]()
#### [<img src="https://github.com/bg-omar/consolelogger/blob/master/.github/pics/preview8.png?raw=true" width="90%"/>]()

<!-- Plugin description end -->






## Installation

  Download the [latest release](https://github.com/bg-omar/consolelogger/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>