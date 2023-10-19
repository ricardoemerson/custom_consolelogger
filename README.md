# ![Build](./src/main/resources/META-INF/pluginIcon.svg) Console Logger IntelliJ Plugin

<!-- Plugin description -->
`CTRL + ALT + (1-6)` to create console.logs from selection.  
(1) = `console.log( -----> $$: ", $$);`  
(2) = `console.debug( -----> $$: ", $$);`  
(3) = `console.log("%c ---> $$: ","color:#F0F;", $$);`  
(4) = `console.log("%c ---> $$: ","color:#0F0;", $$);`  
(5) = `console.warn("%c ---> $$: ","color:#F00;", $$);`  
(6) = `console.warn("%c ---> $$: ","color:#00F;", $$);`  

(CTRL + ALT + 0) removes all unedited console loggers from file or project  

```ts
  this.variable = someThing + otherThing  
```
With `this.variable` selected, (ctrl + alt + 1) gives you this result:

```ts
  this.variable = someThing + otherThing
  console.log(" ---> this.variable: ", this.variable);
```

In the `Settings` -> `Tools` -> `ConsoleLogger` you can modify the 6 loggers

#### [<img src="https://github.com/bg-omar/consolelogger/blob/master/.github/pics/preview2.png?raw=true" width="90%"/>]()  
#### [<img src="https://github.com/bg-omar/consolelogger/blob/master/.github/pics/preview3.png?raw=true" width="90%"/>]()  

#### [<img src="https://github.com/bg-omar/consolelogger/blob/master/.github/pics/preview6.png?raw=true" width="45%"/>]()  
#### [<img src="https://github.com/bg-omar/consolelogger/blob/master/.github/pics/preview8.png?raw=true" width="90%"/>]()  

<!-- Plugin description end -->