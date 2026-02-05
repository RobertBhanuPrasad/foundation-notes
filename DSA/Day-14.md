**Recursion**:  Function calls itself to solve smaller versions of the same problem.

Two parts of recursion :
1) Base Case - stop condition(when to stop calling itself).
2) Recursive Case - Part where function calls itself.

**Real life examples** :

1) Queue of people. (start(p1, p2, p3, p4 .... (pn)end)) - from start to end every person will ask how many people present after you.
2) Comment Threads (eg: Reddit) - comment replies.
3) Organisational Hierarchies.(Like in company (CEO--> CMO --> CTO))


**What is fn call inside it is**: function calling itself is known as recursion.

function fn() {
    console.log("Robert");
    fn();
}

fn();

output :

robert
robert
robert
.....Infinite loop.

**Recursion & Call back**(kind of block and you keep something on top of it) :

function fn(num){
    console.log(num);
    num = num-1
    fn(num)
}

a = 5
fn(a)

console:

5
4
3
...Infinity

In recusrion you have to know about the base case(when to stop the function) - Always write the base caes in top of the program.

function fn(num){
    if(num==0) return;
    console.log(num)
    num=num-1
    fn(num)
}
a = 5
fn(a)

console:

5
4
3
2
1

Call stack : it store the fn(n) like as carriage bag boxes from down


if you want to see the call stack : write the below function in inspect console.

function fn(num) {
    if(num==2) return;
    debugger;
    console.log(num)
    num = num - 1
    fn(num);
}
a=5
fn(a)

after running you can check in call stack "fn" will gets adding.

If you removed the base case in the above problem it will lead to **stack over flow**


**Common Mistakes**:

1) Missong base case -  stack over flow
2) Not simplifying the input -  never reaches base case.
3) Too deep recusrion - large inputs
4) Keeping in mind the time complexity - **O(n)**

When to use the **Recursion**:

1) Problem can be broken into sum problems.
2) Treese and graphs.
3) Backn tracking , DP, Divide and Conquer