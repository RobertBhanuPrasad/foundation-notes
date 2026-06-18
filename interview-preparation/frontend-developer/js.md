JAVASCRIPT EXECUTION CONTEXT
What is Execution Context?

Whenever JS runs code, it creates an environment called an Execution Context.

Think:

JavaScript Engine
      ↓
Creates Memory
Creates Execution Context
Runs Code

Example:

var name = "Robert";

function greet() {
  console.log("Hello");
}

greet();
Behind the scenes
Memory Phase
name → undefined
greet → function definition
Execution Phase
name = Robert

greet() called
MCQ
console.log(a);

var a = 10;

Output?

A. 10

B. undefined ✅

C. Error

D. null

2. HOISTING
What?

JavaScript moves declarations to the top before execution.

Example
console.log(a);

var a = 10;

JS sees:

var a;

console.log(a);

a = 10;

Output:

undefined
let
console.log(age);

let age = 25;

Output:

ReferenceError

Why?

Because of TDZ.

3. TEMPORAL DEAD ZONE (TDZ)
What?

Area between declaration and initialization.

console.log(name);

let name = "Robert";

Here:

TDZ Starts
↓
console.log(name)
↓
let name
TDZ Ends

Result:

ReferenceError
Interview Question

Why is let safer than var?

Answer:

let prevents accidental access before initialization.
4. VAR VS LET VS CONST
Feature	var	let	const
Scope	Function	Block	Block
Redeclare	Yes	No	No
Reassign	Yes	Yes	No
Hoisted	Yes	Yes	Yes
TDZ	No	Yes	Yes

Example:

if(true){
   var a = 10;
}

console.log(a);

Output:

10

Example:

if(true){
   let b = 10;
}

console.log(b);

Output:

ReferenceError
MCQ
const user = {
   name:"Robert"
}

user.name = "John";

Output?

A Error

B Success ✅

Why?

Object reference cannot change.

Properties can.

5. SCOPE
Global Scope
let a = 10;

Accessible everywhere.

Function Scope
function test(){
   let a = 10;
}

Only inside function.

Block Scope
{
   let age = 25;
}

Only inside block.

6. CLOSURE (VERY IMPORTANT)

90% chance interview asks this.

Definition

Closure = Function + Lexical Environment

Inner function remembers outer variables even after outer function finishes.

Example

function outer(){

  let count = 0;

  return function(){

      count++;

      return count;
  }
}

const increment = outer();

console.log(increment());
console.log(increment());
console.log(increment());

Output:

1
2
3

Why?

Because count remains in memory.

Real World Example

Debounce

Authentication

Private Variables

Memoization

React Hooks

Event Handlers

Interview Answer

What is Closure?

A closure is created when a function remembers variables from its lexical scope even after the outer function has completed execution.
7. THIS KEYWORD

Most asked question.

Global
console.log(this);

Browser:

window
Object
const user = {
  name:"Robert",

  show(){
      console.log(this.name);
  }
}

Output:

Robert

this = current object.

Arrow Function
const user = {
  name:"Robert",

  show: () => {
      console.log(this.name);
  }
}

Output:

undefined

Why?

Arrow functions do not have their own this.

8. CALLBACKS

Function passed into another function.

function greet(callback){
   callback();
}

greet(() => {
   console.log("Hello");
});

Output:

Hello
Why?

Asynchronous programming.

9. PROMISES

Before Promises:

callback hell

Example:

login(()=>{
  getUser(()=>{
      getOrders(()=>{
      })
  })
})

Mess.

Promise solves this.

States
Pending
Resolved
Rejected

Example

const promise = new Promise((resolve,reject)=>{

   let success = true;

   if(success){
      resolve("Success");
   }else{
      reject("Failed");
   }

});

Consume

promise
 .then(data=>console.log(data))
 .catch(err=>console.log(err));
10. ASYNC AWAIT

Cleaner syntax over promises.

Promise

fetchUsers()
.then(data=>{
 console.log(data);
});

Async Await

const data = await fetchUsers();

Cleaner.

Example

async function getUsers(){

   try{

      const response =
      await fetch("/api/users");

      const data =
      await response.json();

      console.log(data);

   }catch(error){
      console.log(error);
   }

}
MCQ
async function test(){
  return "Hello";
}

console.log(test());

Output?

Promise { "Hello" }

Not Hello.

11. EVENT LOOP

MOST IMPORTANT.

Example

console.log(1);

setTimeout(()=>{
   console.log(2);
},0);

console.log(3);

Output:

1
3
2

Why?

setTimeout goes to Web APIs.

Flow

Call Stack

↓

Web APIs

↓

Callback Queue

↓

Event Loop

↓

Call Stack
Advanced Event Loop
console.log(1);

Promise.resolve()
.then(()=>console.log(2));

setTimeout(()=>console.log(3));

console.log(4);

Output?

1
4
2
3

Why?

Promise goes to Microtask Queue.

Microtask Queue gets priority.

12. MAP

Transforms array.

const nums=[1,2,3];

const result =
nums.map(num=>num*2);

console.log(result);

Output

[2,4,6]
13. FILTER

Filters data.

const nums=[1,2,3,4];

const result=
nums.filter(num=>num>2);

Output

[3,4]
14. REDUCE

Most important array method.

Example

const nums=[1,2,3,4];

const sum=
nums.reduce(
(acc,curr)=>acc+curr,
0
);

console.log(sum);

Output

10
Interview Question

Group Users By Role

const users = [
 {name:"A",role:"Admin"},
 {name:"B",role:"User"},
 {name:"C",role:"Admin"}
];

Solution

const result =
users.reduce((acc,user)=>{

  if(!acc[user.role]){
      acc[user.role]=[];
  }

  acc[user.role].push(user);

  return acc;

},{});

Output

{
 Admin:[...],
 User:[...]
}
15. DEBOUNCE

Asked frequently.

Problem

Search API called on every keystroke.

R
Ro
Rob
Robe
Robert

5 API calls.

Bad.

Debounce

Wait for user to stop typing.

function debounce(fn,delay){

 let timer;

 return function(...args){

   clearTimeout(timer);

   timer=setTimeout(()=>{
      fn(...args);
   },delay);

 }

}
Throttle vs Debounce
Debounce
Wait and execute

Search bar

Throttle
Execute every x seconds

Scroll events

Common Coding Questions
Reverse String
function reverse(str){
 return str.split("")
           .reverse()
           .join("");
}
Palindrome
function palindrome(str){

 return str ===
 str.split("")
    .reverse()
    .join("");

}
Remove Duplicates
const unique =
[...new Set(arr)];
Flatten Array
arr.flat(Infinity);
Top 20 Questions To Practice
var vs let vs const
Hoisting
TDZ
Scope
Closure
this keyword
Callback
Promise
Promise.all
Promise.race
Async Await
Event Loop
Call Stack
Map
Filter
Reduce
Debounce
Throttle
Deep Copy vs Shallow Copy
Array/Object Destructuring

Master these 20 topics and you'll be able to answer about 80-90% of the JavaScript questions likely to appear in a Frontend Product Developer assessment.


1. VAR vs LET vs CONST
Easy Level
What is var?
var name = "Robert";

Can be:

✅ Redeclared

var a = 10;
var a = 20;

✅ Reassigned

var a = 10;
a = 20;
What is let?
let age = 25;

❌ Cannot redeclare

let age = 25;
let age = 30;

Error

✅ Can reassign

let age = 25;
age = 30;
What is const?
const PI = 3.14;

❌ Cannot redeclare

❌ Cannot reassign

const PI = 3.14;
PI = 10;

Error

Medium Level
Output?
if(true){
  var a = 10;
}

console.log(a);

Output:

10

Why?

var is function scoped.

Output?
if(true){
  let b = 20;
}

console.log(b);

Output:

ReferenceError

Because let is block scoped.

Hard Level
Output?
const user = {
  name: "Robert"
};

user.name = "John";

console.log(user.name);

Output

John

Why?

Object properties can change.

Reference cannot.

Output?
const user = {
  name:"Robert"
};

user = {};

Output

TypeError
Interview Answer

Why should we prefer let and const over var?

Answer:

Because let and const provide block scope, avoid accidental redeclaration, and reduce bugs caused by hoisting.
2. HOISTING
Easy Level
What is Hoisting?

Before code execution JavaScript moves declarations to memory.

Example

console.log(a);

var a = 10;

Internally

var a;

console.log(a);

a = 10;

Output

undefined
Medium Level
Output
sayHello();

function sayHello(){
 console.log("Hello");
}

Output

Hello

Why?

Function declarations are fully hoisted.

Output
sayHello();

var sayHello = function(){
 console.log("Hello");
}

Output

TypeError

Why?

Only variable is hoisted.

Function assignment is not.

Hard Level
Output
console.log(a);

let a = 10;

Output

ReferenceError

Not undefined.

Because of TDZ.

3. TDZ (Temporal Dead Zone)
Easy Level

TDZ means:

Variable exists in memory but cannot be accessed.

Example

console.log(name);

let name = "Robert";

Error

Medium Level

Memory:

name -> uninitialized

Execution:

console.log(name);

Error.

Hard Level
Output
let age = 20;

{
   console.log(age);

   let age = 30;
}

Output

ReferenceError

Why?

Inner age creates its own TDZ.

4. SCOPE
Easy Level
Global Scope
let name = "Robert";

Accessible everywhere.

Function Scope
function test(){
  let age = 25;
}

Only inside function.

Block Scope
{
  let city = "Hyderabad";
}

Only inside block.

Medium Level
Output
let a = 10;

function test(){
 console.log(a);
}

test();

Output

10

Because JS searches upward.

Hard Level
Lexical Scope
let a = 10;

function outer(){

  let b = 20;

  function inner(){
      console.log(a,b);
  }

  inner();
}

outer();

Output

10 20

Interviewers love asking:

How does JS find variables?

Answer:

JavaScript follows lexical scoping. It searches in the current scope, then parent scope, then global scope.
5. CLOSURE

Most important topic.

Easy Level

Definition:

A closure allows a function to remember variables from its outer scope even after the outer function has finished execution.

Example

function outer(){

 let name = "Robert";

 function inner(){
   console.log(name);
 }

 return inner;
}

const fn = outer();

fn();

Output

Robert

Question:

Outer function already finished.

How is name still available?

Answer:

Closure.

Medium Level

Counter Example

function counter(){

 let count = 0;

 return function(){

    count++;

    return count;

 }

}

const c = counter();

console.log(c());
console.log(c());
console.log(c());

Output

1
2
3

Memory Visualization

counter()

count = 0

↓ return function

count remains alive
Hard Level

Private Variable

function bank(){

 let balance = 1000;

 return {

   deposit(amount){
      balance += amount;
   },

   getBalance(){
      return balance;
   }

 }

}

Usage

const acc = bank();

acc.deposit(500);

console.log(acc.getBalance());

Output

1500

Why important?

Used in:

React Hooks
Debounce
Throttle
Authentication
Memoization
Tricky Interview Question

Output?

for(var i=0;i<3;i++){

 setTimeout(()=>{
   console.log(i);
 },1000);

}

Output

3
3
3

Why?

All callbacks share same variable.

Solution

for(let i=0;i<3;i++){

 setTimeout(()=>{
   console.log(i);
 },1000);

}

Output

0
1
2

Because let creates a new binding each iteration.

Coding Question

Create a counter using closure.

function createCounter(){

 let count = 0;

 return {
   increment(){
      return ++count;
   },

   decrement(){
      return --count;
   }
 }

}

These first 5 topics (var/let/const, hoisting, TDZ, scope, closure) alone account for roughly 30-40% of JavaScript interview questions in frontend assessments.

Next, you should study:

this keyword
Callbacks
Promises
Promise.all
Promise.race
Async/Await
Event Loop
Call Stack

THIS KEYWORD
What is this?

this refers to the object that is currently executing the function.

Simple meaning:

"this" = Who called me?
Example 1: Object Method
const user = {
  name: "Robert",

  showName() {
    console.log(this.name);
  }
};

user.showName();

Output:

Robert

Why?

user.showName()
↑
user called the function

Therefore:

this === user

So:

this.name

becomes

user.name

which is:

Robert
Real Life Example

Imagine:

Robert says:
"My name is Robert"

John says:
"My name is John"

"My" changes depending on who is speaking.

Similarly:

this.name

changes depending on who called the function.

Example 2
const user1 = {
  name: "Robert",

  show() {
    console.log(this.name);
  }
};

const user2 = {
  name: "John",

  show: user1.show
};

user2.show();

Output:

John

Why?

Because:

user2.show()

was called by user2.

Therefore:

this === user2
Interview Question

What decides the value of this?

Answer:

The object that calls the function determines the value of this.
Example 3: Global Scope

Browser:

console.log(this);

Output:

window

Because:

Global Object in browser = window

Therefore:

this === window
Example 4: Normal Function
function show() {
  console.log(this);
}

show();

Browser Output:

window

Why?

No object called it.

Default binding applies.

Example 5: Strict Mode
"use strict";

function show() {
  console.log(this);
}

show();

Output:

undefined

Why?

Strict mode removes automatic window binding.

Most Asked Interview Question

Output?

const user = {
  name: "Robert",

  show() {
    console.log(this.name);
  }
};

const fn = user.show;

fn();

Output:

undefined

Why?

Because:

fn()

is not called by user.

It is called directly.

Therefore:

this !== user
How to Fix?
bind()
const fn = user.show.bind(user);

fn();

Output:

Robert

bind permanently sets this.

call()
function greet() {
  console.log(this.name);
}

const user = {
  name: "Robert"
};

greet.call(user);

Output:

Robert

call immediately executes.

apply()
function greet(city) {
  console.log(this.name, city);
}

const user = {
  name: "Robert"
};

greet.apply(user, ["Hyderabad"]);

Output:

Robert Hyderabad
Difference
call
fn.call(user, arg1, arg2)

Arguments individually.

apply
fn.apply(user, [arg1, arg2])

Arguments as array.

bind
const newFn = fn.bind(user);

Returns new function.

Does not execute immediately.

Arrow Function and this

Most important.

Normal Function
const user = {
  name: "Robert",

  show() {
    console.log(this.name);
  }
};

user.show();

Output:

Robert
Arrow Function
const user = {
  name: "Robert",

  show: () => {
    console.log(this.name);
  }
};

user.show();

Output:

undefined
Why?

Arrow functions DO NOT have their own this.

They borrow it from parent scope.

Normal Function

function test() {}

Has its own:

this
arguments
super

Arrow Function

const test = () => {}

Does NOT have:

this
arguments
super
Tricky Question

Output?

const obj = {
  name: "Robert",

  regular: function () {
    console.log(this.name);
  },

  arrow: () => {
    console.log(this.name);
  }
};

obj.regular();
obj.arrow();

Output:

Robert
undefined
Real React Example

Bad

class App {

  handleClick() {
    console.log(this);
  }

}

Need

this.handleClick =
this.handleClick.bind(this);

OR

handleClick = () => {
   console.log(this);
}

Arrow automatically captures parent this.

Memory Trick

Always ask:

Who called the function?

Examples:

user.show()

this = user

obj.test()

this = obj

show()

this = window (or undefined in strict mode)

arrowFunction()

this = parent scope

Top Interview Questions
Q1

What is this?

Answer:

this refers to the object that is currently executing the function.
Q2

Why does arrow function behave differently?

Answer:

Arrow functions do not create their own this. They inherit this from their surrounding scope.
Q3

Difference between call, apply and bind?

Answer:

Method	Executes Immediately	Arguments
call	Yes	Separate
apply	Yes	Array
bind	No	Returns Function
Q4

Output?

const obj = {
  name:"Robert",

  show(){
      return function(){
          console.log(this.name);
      }
  }
};

obj.show()();

Output:

undefined

Because inner function is called directly.

Think of it like this:

Callbacks
   ↓
Promises
   ↓
Async/Await

If Callbacks are clear, Promises and Async/Await become easy.

1. WHAT IS A CALLBACK?

A callback is simply:

A function passed as an argument to another function, to be executed later.

Simple Example
function greet(name) {
  console.log("Hello " + name);
}

function processUser(callback) {
  callback("Robert");
}

processUser(greet);

Output:

Hello Robert
What Happened?
Step 1
processUser(greet);

We're passing the function.

NOT:

processUser(greet());

because that executes immediately.

Step 2

Inside:

function processUser(callback) {
  callback("Robert");
}

callback becomes:

greet

So:

callback("Robert");

becomes:

greet("Robert");

Output:

Hello Robert
Why Do We Need Callbacks?

Imagine:

Download File
Read Database
Call API
Wait for User Click

These take time.

JavaScript cannot stop the entire application and wait.

Instead:

Start Task
↓
Continue Other Work
↓
Task Completes
↓
Run Callback
Real Life Example

Imagine ordering food.

Wrong approach:

Order Food
Sit 30 minutes doing nothing
Food arrives

Efficient approach:

Order Food
Continue watching movie
Restaurant calls you
Collect food

That phone call is the callback.

2. CALLBACKS WITH BUTTONS

Example:

button.addEventListener("click", function() {
  console.log("Button clicked");
});

Question:

Who executes this function?

Not you.

Browser executes it later.

Flow:

Register callback
↓
Wait
↓
User clicks
↓
Browser executes callback
3. CALLBACKS WITH setTimeout

Example:

setTimeout(() => {
  console.log("Hello");
}, 2000);

Output after 2 seconds:

Hello

Question:

What is callback here?

() => {
  console.log("Hello");
}

Question:

Who executes it?

Browser.

Flow:

Register callback
↓
Wait 2 sec
↓
Browser executes callback
4. CALLBACKS WITH ARRAYS

Example:

const nums = [1, 2, 3];

nums.forEach(function(num) {
  console.log(num);
});

Output:

1
2
3

Callback:

function(num){
 console.log(num);
}

forEach executes callback for every item.

Internally:

callback(1);
callback(2);
callback(3);
5. CUSTOM CALLBACK EXAMPLE

Suppose we want reusable logic.

function calculate(a, b, operation) {
  return operation(a, b);
}

Addition

function add(x, y) {
  return x + y;
}

Multiply

function multiply(x, y) {
  return x * y;
}

Usage

console.log(calculate(10, 5, add));

Output:

15

Usage

console.log(calculate(10, 5, multiply));

Output:

50

Why useful?

Same function.

Different behavior.

6. SYNCHRONOUS CALLBACK

Runs immediately.

Example:

function greet(callback) {
  callback();
}

greet(() => {
  console.log("Hello");
});

Output:

Hello

Execution:

greet()
↓
callback()
↓
Hello
7. ASYNCHRONOUS CALLBACK

Runs later.

Example:

setTimeout(() => {
  console.log("Hello");
}, 2000);

Output after 2 seconds.

Execution:

Register callback
↓
Continue execution
↓
2 sec later
↓
Execute callback
8. CALLBACK HELL

This is why Promises were created.

Imagine:

Login User
loginUser(function(user) {

});
Fetch Profile
loginUser(function(user) {

   getProfile(user.id,function(profile){

   });

});
Fetch Orders
loginUser(function(user) {

   getProfile(user.id,function(profile){

      getOrders(profile.id,function(orders){

      });

   });

});
Send Email
loginUser(function(user) {

   getProfile(user.id,function(profile){

      getOrders(profile.id,function(orders){

         sendEmail(function(){

         });

      });

   });

});

Looks like:

\
 \
  \
   \
    \

This is called:

Callback Hell

or

Pyramid of Doom

Problems:

Hard to Read
login(()=>{
 getProfile(()=>{
   getOrders(()=>{
      sendMail(()=>{
      });
   });
 });
});
Hard to Debug

Finding errors becomes difficult.

Hard to Maintain

Adding new steps becomes messy.

Why Promises Were Created

Instead of:

login(()=>{
 getProfile(()=>{
   getOrders(()=>{
   });
 });
});

We write:

login()
 .then(getProfile)
 .then(getOrders)
 .then(sendMail);

Much cleaner.

Interview Question

What problem do Promises solve?

Answer:

Promises solve callback hell and provide better error handling for asynchronous operations.
9. CALLBACK INTERVIEW QUESTIONS
Question 1

Output?

function hello(callback) {
  callback();
}

hello(() => {
  console.log("Hi");
});

Output:

Hi
Question 2

Output?

console.log("Start");

setTimeout(() => {
  console.log("Middle");
}, 0);

console.log("End");

Output:

Start
End
Middle

Why?

Because callback executes later.

(Event Loop topic)

Question 3

Output?

function test(cb) {
  cb("Robert");
}

test(name => {
  console.log(name);
});

Output:

Robert
Real React Examples
Button Click
<button onClick={() => {
   console.log("clicked");
}}>
Click
</button>

Callback:

() => {
 console.log("clicked");
}
API Success
fetch("/users")
.then(response => {
   return response.json();
});

Callback:

response => {
   return response.json();
}
Array Mapping
users.map(user => {
   return user.name;
});

Callback:

user => user.name
Interview Answer (Memorize)
What is a callback?

A callback is a function passed as an argument to another function that is executed later, either synchronously or asynchronously.

Why are callbacks used?

Callbacks allow JavaScript to handle asynchronous operations such as API calls, timers, user events, and file operations without blocking the main thread.

What is callback hell?

Callback hell occurs when multiple asynchronous callbacks are nested inside one another, making code difficult to read, debug, and maintain.



For a Frontend Product Developer (3–6 years) role, these topics are not separate. They are connected like this:

Call Stack
   ↓
Callbacks
   ↓
Web APIs
   ↓
Event Loop
   ↓
Promises
   ↓
Promise.all / Promise.race
   ↓
Async/Await

If you understand this flow, you can answer almost any JavaScript asynchronous question.

1. CALL STACK (Foundation)
What is Call Stack?

The Call Stack is where JavaScript keeps track of function execution.

Think of it as a stack of plates.

Top
-----
test()
-----
main()
-----
Bottom

The last function added executes first.

Example
function one() {
  console.log("One");
}

function two() {
  one();
  console.log("Two");
}

two();
Execution

Initially

Stack Empty

Call:

two();

Stack

two()

Inside two()

one();

Stack

one()
two()

one finishes

two()

two finishes

Empty

Output

One
Two
Interview Question
Output?
function a() {
  b();
}

function b() {
  c();
}

function c() {
  console.log("Hello");
}

a();

Stack

c()
b()
a()

Output

Hello
2. CALLBACKS
What?

A function passed as an argument to another function.

function greet(callback) {
  callback();
}

greet(() => {
  console.log("Hello");
});

Output

Hello
Why?

Because some tasks take time.

Examples:

API Calls
Database Calls
User Clicks
File Reads
Timers

Instead of blocking JavaScript:

Start Task
↓
Continue Other Work
↓
Task Completes
↓
Run Callback
Callback Hell
login(() => {
  getProfile(() => {
    getOrders(() => {
      sendMail(() => {

      });
    });
  });
});

Problem:

Hard to read
Hard to debug
Hard to maintain

This is why Promises were invented.

3. EVENT LOOP

Most Important Topic.

JavaScript is Single Threaded

Only one thing executes at a time.

One Call Stack.

One Chef
One Kitchen

Question:

How does JavaScript handle:

setTimeout()
fetch()
click events

if it is single threaded?

Answer:

Because of the Event Loop.

Example
console.log("Start");

setTimeout(() => {
  console.log("Timer");
}, 0);

console.log("End");

Output

Start
End
Timer

Why?

Step 1
console.log("Start");

Call Stack

console.log

Output

Start
Step 2
setTimeout(...)

Timer callback goes to:

Web APIs

NOT Call Stack.

Step 3
console.log("End");

Output

End
Step 4

Call Stack becomes empty.

Event Loop checks.

Callback Queue

contains:

Timer Callback

Moves callback to stack.

Output

Timer
Event Loop Diagram
Call Stack
     ↑
     |
Event Loop
     |
     ↓
Callback Queue

Web APIs
4. PROMISES
What?

Promise is an object representing the future result of an asynchronous operation.

Think:

Restaurant Promise

Order Food
↓
Waiting
↓
Food Delivered
OR
Food Cancelled
States
Pending
Fulfilled
Rejected
Create Promise
const promise = new Promise((resolve, reject) => {

  let success = true;

  if(success){
     resolve("Success");
  } else {
     reject("Failed");
  }

});
Consume Promise
promise
 .then(data => {
   console.log(data);
 })
 .catch(err => {
   console.log(err);
 });

Output

Success
Why Promises?

Instead of:

login(() => {
  getProfile(() => {
    getOrders(() => {

    });
  });
});

Use:

login()
 .then(getProfile)
 .then(getOrders)
 .then(sendMail);

Cleaner.

Promise Chaining
fetchUser()
.then(user => {
  return fetchOrders(user.id);
})
.then(orders => {
  console.log(orders);
});
5. PROMISE.ALL

Very Common Interview Question.

Purpose

Run multiple promises together.

Example

Promise.all([
  fetchUsers(),
  fetchProducts(),
  fetchOrders()
])
.then(data => {
  console.log(data);
});

Imagine

Users API
Products API
Orders API

All run simultaneously.

Faster.

Success Condition

ALL must succeed.

✔
✔
✔

Success.

Failure Condition
✔
❌
✔

Entire Promise.all fails.

Interview Question

When should you use Promise.all?

Answer:

When multiple independent asynchronous operations can run in parallel and all results are required.
Promise.all Example
Promise.all([
  Promise.resolve(1),
  Promise.resolve(2),
  Promise.resolve(3)
])
.then(console.log);

Output

[1,2,3]
6. PROMISE.RACE

Purpose:

Return first settled promise.

Example

Promise.race([
  fetchServer1(),
  fetchServer2(),
  fetchServer3()
]);

Whichever finishes first wins.

Example

Promise.race([
  new Promise(resolve =>
    setTimeout(() => resolve("A"),3000)
  ),

  new Promise(resolve =>
    setTimeout(() => resolve("B"),1000)
  )
])
.then(console.log);

Output

B

Because B finishes first.

Difference
Promise.all

Wait for everyone.

A
B
C

Need all.

Promise.race

Take first winner.

A
B
C

Winner = fastest
7. ASYNC / AWAIT

Most used in React and Next.js.

Problem

Promise code:

fetchUsers()
.then(data => {
  console.log(data);
})
.catch(err => {
  console.log(err);
});

Works.

But gets messy.

Async Await
const data = await fetchUsers();

Looks synchronous.

Much cleaner.

async

Makes function return a Promise.

async function test() {
  return "Hello";
}

Output

Promise { "Hello" }

Interview Question

Output?
async function test() {
  return 100;
}

console.log(test());

Output

Promise {100}
await

Pauses function execution until Promise resolves.

const response =
await fetch("/users");

Example

async function getUsers() {

  try {

    const response =
    await fetch("/users");

    const data =
    await response.json();

    console.log(data);

  }
  catch(error) {

    console.log(error);

  }

}
Why Async Await?

Readable.

Compare:

.then()
.then()
.then()

vs

await
await
await

Much cleaner.

8. MICROTASK QUEUE vs CALLBACK QUEUE

Advanced Interview Topic.

Example

console.log(1);

setTimeout(() => {
  console.log(2);
},0);

Promise.resolve()
.then(() => {
  console.log(3);
});

console.log(4);

Output

1
4
3
2

Why?

Promise callbacks go to:

Microtask Queue

setTimeout goes to:

Callback Queue

Priority:

Microtask Queue
       ↑
Higher Priority

Callback Queue
       ↓
Lower Priority
Most Important Interview Question
Explain this output
console.log("Start");

setTimeout(() => {
  console.log("Timer");
},0);

Promise.resolve()
.then(() => {
  console.log("Promise");
});

console.log("End");

Output

Start
End
Promise
Timer
Explanation
Start executes
Timer goes to Web API
Promise goes to Microtask Queue
End executes
Call Stack empty
Event Loop checks Microtask Queue first
Promise executes
Timer executes

Final Output:

Start
End
Promise
Timer
Interview Summary Answers

What is Call Stack?

A data structure that manages function execution in JavaScript.

What is a Callback?

A function passed to another function to be executed later.

What is the Event Loop?

A mechanism that moves tasks from queues to the Call Stack when it becomes empty.

What is a Promise?

An object representing the eventual success or failure of an asynchronous operation.

What is Promise.all?

Runs multiple promises in parallel and resolves when all succeed.

What is Promise.race?

Returns the result of the first settled promise.

What is async?

Makes a function return a Promise.

What is await?

Pauses execution inside an async function until a Promise resolves.