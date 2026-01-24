**How js works?**  - video - 1

1) Js code will execute inside the execution context.

        Execution context:

    
    Memory(variable env.)   |   Code(Thread of execution)
    ________________________________
    key : value                 single line 
    a: 10                       code(whole code will execute here.)
    f: {....}


*** Js** is a synchronous single threaded language(js can only excute one command at a time in a order line by line)

**How js is executed** :

1) when u run the js code the global execution contecxt is created.

excution context(excution and code) in two phases:

var n = 2
function suqare (num) {
    var ans = num * num;
    return ans;
}
var = sqaure2 = sqaure(n);
var sqaure4 = sqaure(4);

1) Memory creation phase : 

**MEMORY**
______________

n : undefined;
square : {..}
sqaure2 : undefined
sqaure4 : undefined

2) Code excution phase :

**code**
___________________________________
once again the js will go through the total again.

Memory 

n : 2

function invokation(now it will execute the function (sqaure(n)))

Again inside the **code** function invokation.

**Phase - 1** :

Memory              |      Code

num : undefined 
ans : undefined

**Phase - 2** :

Memory       |   Code

num : 2          num*num
ans : 4         return 
square2 : 4  (after replacing the value here after invoking the function the execution context is deleted completely)      

for the next function (sqaure(4)) -  the execution context inside the code.

Memory              |   Code

num : undefined
ans: undefined

num : 4 (after fn excution)
ans : 16 (after fn excution)

sqaure4 : 16; (Again now above full execution context will be deleted)

**Now** after executing the total the whole total gobal execution context is deleted.

***The** js will have its own call stack it will handle all this execution context.

**when** any js is executing the total execution context is pushed into the global execution context.

whenever is function invoked or new execution context is created it went to global execution context. (E1, E2 etc) - when the execution context is deleted it is moved out from the global execution and after deleted all the execution context the call stack will get empty 

