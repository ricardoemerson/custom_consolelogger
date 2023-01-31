const DummyDataOne = [
    {
        "name": "THE ALL MIGHT CONSOLE",
        "description": "Fast Smart Powerfull",
        "powerlevel": 9001
    },
    {
        "name": "THE ALL MIGHT CONSOLE",
        "description": "Fast Smart Powerfull",
        "powerlevel": 9002
    },
    {
        "name": "THE ALL MIGHT CONSOLE",
        "description": "Fast Smart Powerfull",
        "powerlevel": 9003,
        "odd one out": "hello i am alone"
    },
    {
        "name": "THE ALL MIGHT CONSOLE",
        "description": "Fast Smart Powerfull",
        "powerlevel": 9004
    },
    {
        "name": "THE ALL MIGHT CONSOLE",
        "description": "Fast Smart Powerfull",
        "powerlevel": 9005
    }
];

function stepOne() {
    console.log("%cThe power of the console", "font-family:serif; font-size: 80px");
    console.log("%cThis first tech talk will be about the front end debug life saver called console!", "font-family:serif; font-size: 30px");
    console.log('--------------------------------------------------------------')
}

function stepTwo() {
    console.log("%cYou might be thinking what can the console do for me?", "font-family:serif; font-size: 30px");
    console.log("%cThe console can do a lot more then just output strings!", "font-family:serif; font-size: 30px");
    console.log("%cLike shown above with different sizes of text", "font-family:serif; font-size: 30px");
    console.log("%cOr like here with a different font and color", "color: green;font-family:comic sans MS; font-size: 30px");
    console.log("%cAll of this can be done by adding a %c at the start of the first string and a second string of css after a comma", "font-family:serif; font-size: 30px");
    console.log('--------------------------------------------------------------')
}

function stepThree() {
    console.log("%cOne of the many cool tools that the console has to offer is a mode to display a lot of data with a clear overview like here using console.table():", "font-family:serif; font-size: 30px");
    console.table(DummyDataOne);
    console.log("%cAnother fun tool that could be used to display multiple levels of data is group. Group allows us to show data with indentations:", "font-family:serif; font-size: 30px");
    console.log("This is the outer level");
    console.groupCollapsed()
    console.log("Level 2");
    console.group();
    console.log("Level 3");
    console.warn("More of level 3");
    console.groupEnd();
    console.log("Back to level 2");
    console.groupEnd();
    console.log("Back to the outer level");
    console.log("%cThe tool shown above is named group. To use this tool we can use the following commands: console.group(), console.groupEnd() and console.groupCollapsed()", "font-family:serif; font-size: 30px");

    console.log('--------------------------------------------------------------')
}

function stepFour() {
    console.log("%cIf we get into the more complex features we can start looking into tools to measure and trace functions:", "font-family:serif; font-size: 30px");

    }

function stepFourDir() {
    console.log("%cFor example we can output an entire overview of all funtionalities and content of a javascript objecte with console.dir():", "font-family:serif; font-size: 30px");
    console.dir(document.body)
    console.log("%cOr a printout of a XML or HTMl object through console.dirxml():", "font-family:serif; font-size: 30px");
    console.dirxml(document.body);
}

function stepFourTime(){
    console.log("%cUsing the console.time() and console.timeEnd() we can for example show how long it takes to make an api call or the run time of a function:", "font-family:serif; font-size: 30px");
    console.time('timer')
    fetch('https://jsonplaceholder.typicode.com/todos')
        .then(response => response.json())
        .then(json => {
            console.log(json);
            console.timeEnd('timer');
        })
}

function stepFourTrace() {
    console.log("%cA more indepth tool is the console.trace wich will allow us the trace the full path to the point of execution:", "font-family:serif; font-size: 30px");
    delayOne()
}

function delayOne() {
    delayTwo();
}

function delayTwo() {
    delayThree();
}

function delayThree() {
    console.trace()
    console.log('-------------------------------------------------------------- ');
}

function stepFive() {
    console.log("%cLast but not least a small example of the different console levels:", "font-family:serif; font-size: 30px");
    console.debug('debug level');
    console.warn('warn level');
    console.error('error level');
    console.info('info level');
    console.log('-------------------------------------------------------------- ');
}

