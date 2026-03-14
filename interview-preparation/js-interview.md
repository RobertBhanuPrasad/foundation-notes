# JavaScript Interview Guide - Arrays, Objects & Strings

> Robert, this is a very important request because arrays, objects, and strings are the core of JavaScript interviews, especially for 1–2 years frontend roles.

I will explain **WHAT**, **WHY**, **HOW**, methods, iterations, interview questions, and coding examples for:

1. Arrays
2. Objects
3. Strings

---

## 1. Arrays in JavaScript

### What is an Array?

An array is a data structure that stores multiple values in a single variable.

**Example:**

```javascript
const arr = [10, 20, 30];
```

Here:

| Index | 0  | 1  | 2  |
|-------|----|----|----|
| Value | 10 | 20 | 30 |

### Why Arrays Are Used

Arrays help when you want to:

- Store lists of items
- Loop through data
- Transform data
- Filter data

**Example:**

```javascript
const users = ["John", "Robert", "Alex"];
```

---

### Array Iteration (Looping)

#### 1. `for` loop

**Why:** Most basic way to iterate arrays.

**Example:**

```javascript
const arr = [1,2,3];

for(let i=0;i<arr.length;i++){
 console.log(arr[i]);
}
```

**Output:**

```
1
2
3
```

#### 2. `for...of` loop

**Why:** Simpler way to access values.

```javascript
const arr = [10,20,30];

for(let value of arr){
 console.log(value);
}
```

#### 3. `forEach`

**What:** Runs a function for each element.

```javascript
const arr = [1,2,3];

arr.forEach(function(num){
 console.log(num);
});
```

---

### Important Array Methods

#### `map()`

**What:** Transforms array elements.

**Why:** Creates a new array after modifying values.

**Example:**

```javascript
const arr = [1,2,3];

const result = arr.map(num => num * 2);

console.log(result);
```

**Output:**

```
[2,4,6]
```

#### `filter()`

**What:** Filters elements based on condition.

**Example:**

```javascript
const arr = [1,2,3,4];

const result = arr.filter(num => num % 2 === 0);

console.log(result);
```

**Output:**

```
[2,4]
```

#### `reduce()`

**What:** Reduces array to a single value.

**Example:**

```javascript
const arr = [1,2,3,4];

const sum = arr.reduce((acc,value)=>{
 return acc + value;
},0);

console.log(sum);
```

**Output:**

```
10
```

#### `find()`

Returns first matching element.

```javascript
const arr = [5,10,15];

const result = arr.find(x => x > 8);

console.log(result);
```

**Output:**

```
10
```

#### `some()`

Checks if any element matches condition.

```javascript
const arr = [1,2,3];

const result = arr.some(num => num > 2);

console.log(result);
```

**Output:**

```
true
```

#### `every()`

Checks if all elements match condition.

```javascript
const arr = [2,4,6];

const result = arr.every(num => num % 2 === 0);

console.log(result);
```

**Output:**

```
true
```

---

### Array Coding Question

**Remove duplicates:**

```javascript
function removeDuplicates(arr){

 let result = [];

 for(let i=0;i<arr.length;i++){

  if(!result.includes(arr[i])){
   result.push(arr[i]);
  }

 }

 return result;
}
```

---

### Interview Question (Array)

**Difference between `map` and `forEach`:**

| `map` | `forEach` |
|-------|-----------|
| returns new array | returns undefined |
| used for transformation | used for iteration |

---

## 2. Objects in JavaScript

### What is an Object?

Objects store key-value pairs.

**Example:**

```javascript
const user = {
 name: "Robert",
 age: 25
};
```

Here:

- `key` -> name
- `value` -> Robert

### Why Objects Are Used

Objects are used to represent real-world entities.

**Example:**

```javascript
const product = {
 id:1,
 name:"Laptop",
 price:50000
};
```

---

### Object Iteration

#### `for...in` loop

```javascript
const user = {
 name:"John",
 age:25
};

for(let key in user){
 console.log(key, user[key]);
}
```

**Output:**

```
name John
age 25
```

#### `Object.keys()`

Returns array of keys.

```javascript
const user = {name:"John",age:25};

console.log(Object.keys(user));
```

**Output:**

```
["name","age"]
```

#### `Object.values()`

Returns values.

```javascript
console.log(Object.values(user));
```

**Output:**

```
["John",25]
```

#### `Object.entries()`

Returns key-value pairs.

```javascript
console.log(Object.entries(user));
```

**Output:**

```
[["name","John"],["age",25]]
```

---

### Check if Key Exists

```javascript
const user = {name:"John"};

console.log("name" in user);
```

**Output:**

```
true
```

### Check if Value Exists

```javascript
const user = {name:"John",age:25};

console.log(Object.values(user).includes(25));
```

**Output:**

```
true
```

---

### Object Coding Question

**Convert object values to array:**

```javascript
function getValues(obj){

 let result = [];

 for(let key in obj){
  result.push(obj[key]);
 }

 return result;
}
```

---

### Interview Question

**Difference between `Object.keys()` and `Object.entries()`:**

| Method | Output |
|--------|--------|
| `keys` | `["name","age"]` |
| `entries` | `[["name","John"],["age",25]]` |

---

## 3. Strings in JavaScript

### What is a String?

A string is a sequence of characters.

**Example:**

```javascript
const str = "hello";
```

---

### String Iteration

#### `for` loop

```javascript
const str = "hello";

for(let i=0;i<str.length;i++){
 console.log(str[i]);
}
```

#### `for...of` loop

```javascript
for(let char of "hello"){
 console.log(char);
}
```

---

### Important String Methods

#### `toUpperCase()`

```javascript
const str = "hello";

console.log(str.toUpperCase());
```

**Output:**

```
HELLO
```

#### `toLowerCase()`

```javascript
console.log("HELLO".toLowerCase());
```

**Output:**

```
hello
```

#### `includes()`

```javascript
console.log("hello".includes("ell"));
```

**Output:**

```
true
```

#### `startsWith()`

```javascript
console.log("hello".startsWith("he"));
```

**Output:**

```
true
```

#### `endsWith()`

```javascript
console.log("hello".endsWith("lo"));
```

**Output:**

```
true
```

#### `split()`

Converts string to array.

```javascript
const str = "a,b,c";

console.log(str.split(","));
```

**Output:**

```
["a","b","c"]
```

#### `join()`

Converts array to string.

```javascript
const arr = ["a","b","c"];

console.log(arr.join("-"));
```

**Output:**

```
a-b-c
```

---

### String Coding Questions

**Reverse string:**

```javascript
function reverse(str){

 let result = "";

 for(let i=str.length-1;i>=0;i--){
  result += str[i];
 }

 return result;
}
```

**Count Characters:**

```javascript
function countChars(str){

 let map = {};

 for(let char of str){

  if(map[char]){
   map[char]++;
  }
  else{
   map[char] = 1;
  }

 }

 return map;
}
```

---

### Common Interview Questions

**Array Questions:**
- remove duplicates
- find largest number
- array flatten
- array sum

**Object Questions:**
- check key exists
- iterate object
- convert object to array

**String Questions:**
- reverse string
- palindrome
- count characters
- check anagram

---

### Important Tip

In interviews, they want to see:

- iteration logic
- understanding of methods
- problem solving ability
- clean code

---

---

# Part 2 - Deep Dive: When, Why & How to Use Each Method

> Robert, this is a very important topic for technical interviews. Interviewers often test **when** to use a method, **why** to use it, and **why not** another method.

A structured guide for Arrays, Objects, and Strings with:

- What the method does
- When to use it
- Why to use it instead of others
- Example
- Interview explanation

---

## 1. ARRAY METHODS (When, Why, How)

### 1. `map()`

**What:** Creates a new array by transforming each element.

**When to use:** Use when you want to modify every element and return a new array.

**Why not `forEach()`:** forEach() does not return a new array.

**Example:**

```javascript
const nums = [1,2,3];

const result = nums.map(num => num * 2);

console.log(result);
```

**Output:**

```
[2,4,6]
```

**Interview Explanation:**

> I use map() when I need to transform array elements and produce a new array without mutating the original one.

---

### 2. `forEach()`

**What:** Iterates over array but does not return anything.

**When to use:** Use when performing side effects.

**Example:**

```javascript
const nums = [1,2,3];

nums.forEach(num => console.log(num));
```

**Why not `map()`:** Because map() is meant for transformations, not just iteration.

---

### 3. `filter()`

**What:** Returns elements that satisfy a condition.

**When to use:** When you want to remove unwanted elements.

**Example:**

```javascript
const nums = [1,2,3,4];

const result = nums.filter(n => n % 2 === 0);

console.log(result);
```

**Output:**

```
[2,4]
```

**Why not `map()`:** map() modifies elements, filter() selects elements.

---

### 4. `reduce()`

**What:** Reduces array to one single value.

**When to use:** Use when calculating:

- sum
- product
- grouping
- aggregation

**Example:**

```javascript
const nums = [1,2,3,4];

const sum = nums.reduce((acc,val) => acc + val,0);

console.log(sum);
```

**Output:**

```
10
```

**Why not `map()`:** map() returns an array. reduce() returns a single value.

---

### 5. `find()`

**What:** Returns the first matching element.

**Example:**

```javascript
const users = [{id:1},{id:2},{id:3}];

const user = users.find(u => u.id === 2);

console.log(user);
```

**Output:**

```
{id:2}
```

**Why not `filter()`:** filter() returns all matches, find() returns first match only.

---

### 6. `some()`

**What:** Checks if any element satisfies condition.

**Example:**

```javascript
const nums = [1,2,3];

const result = nums.some(n => n > 2);

console.log(result);
```

**Output:**

```
true
```

---

### 7. `every()`

**What:** Checks if all elements satisfy condition.

**Example:**

```javascript
const nums = [2,4,6];

const result = nums.every(n => n % 2 === 0);

console.log(result);
```

**Output:**

```
true
```

---

### 8. `includes()`

**What:** Checks if array contains a value.

**Example:**

```javascript
const nums = [1,2,3];

console.log(nums.includes(2));
```

**Output:**

```
true
```

---

### Important Differences (Arrays)

| Method | Purpose | Returns |
|--------|---------|---------|
| `map` | transform elements | new array |
| `filter` | remove unwanted elements | new array |
| `reduce` | combine values | single value |
| `forEach` | iterate | undefined |
| `find` | first match | element |
| `some` | any match | boolean |
| `every` | all match | boolean |

---

## 2. OBJECT METHODS

Objects store key-value pairs.

**Example:**

```javascript
const user = {
 name: "Robert",
 age: 25
};
```

### 1. `Object.keys()`

**What:** Returns all keys.

**Example:**

```javascript
Object.keys(user);
```

**Output:**

```
["name","age"]
```

**When to use:** When you want to iterate keys.

---

### 2. `Object.values()`

Returns values.

```javascript
Object.values(user);
```

**Output:**

```
["Robert",25]
```

---

### 3. `Object.entries()`

Returns key-value pairs.

**Example:**

```javascript
Object.entries(user);
```

**Output:**

```
[["name","Robert"],["age",25]]
```

---

### Iterating Object

```javascript
for(let key in user){
 console.log(key,user[key]);
}
```

### Check Key Exists

**Method 1:**

```javascript
"name" in user
```

**Method 2:**

```javascript
user.hasOwnProperty("name")
```

### Check Value Exists

```javascript
Object.values(user).includes(25)
```

---

### Difference Between Key Methods

| Method | Returns |
|--------|---------|
| `Object.keys()` | keys |
| `Object.values()` | values |
| `Object.entries()` | key-value pairs |

---

## 3. STRING METHODS

Strings are sequence of characters.

**Example:**

```javascript
const str = "hello";
```

### 1. `split()`

**What:** Converts string → array.

**Example:**

```javascript
"hello world".split(" ");
```

**Output:**

```
["hello","world"]
```

---

### 2. `includes()`

Checks substring.

```javascript
"hello".includes("ell")
```

**Output:**

```
true
```

---

### 3. `slice()`

Extracts part of string.

```javascript
"hello".slice(1,4)
```

**Output:**

```
ell
```

---

### 4. `substring()`

Similar to slice.

```javascript
"hello".substring(1,4)
```

**Output:**

```
ell
```

**Difference:**
- `substring` does not accept negative index
- `slice` accepts negative index

---

### 5. `replace()`

```javascript
"hello world".replace("world","JS")
```

**Output:**

```
hello JS
```

---

### 6. `toUpperCase()`

```javascript
"hello".toUpperCase()
```

**Output:**

```
HELLO
```

---

### 7. `trim()`

Removes spaces.

```javascript
" hello ".trim()
```

**Output:**

```
hello
```

---

### String Iteration

```javascript
for(let char of "hello"){
 console.log(char);
}
```

---

## Common Interview Questions

### Array
- remove duplicates
- find max number
- flatten array
- sum array

### Object
- check key exists
- convert object to array
- count values
- iterate object

### String
- reverse string
- check palindrome
- count characters
- check anagram

---

## Final Interview Tip

> When interviewer asks **"Why did you use this method?"**

Explain like this:

> *"I used map because I needed to transform each element and return a new array without mutating the original."*

This shows strong understanding.

---

---

# Part 3 - 10-Minute JavaScript Interview Cheat Sheet

> Robert, here is a 10-minute JavaScript Interview Cheat Sheet for Arrays, Objects, and Strings.
> This is designed so you can quickly revise before the technical interview.

I organized it into:

- Arrays
- Objects
- Strings
- Iteration
- Common interview patterns

---

## 1. ARRAYS – Quick Cheat Sheet

### Create Array

```javascript
const arr = [1,2,3];
```

### Array Iteration

#### `for` loop

```javascript
for(let i=0;i<arr.length;i++){
 console.log(arr[i]);
}
```

Use when you need index control.

#### `for...of`

```javascript
for(let value of arr){
 console.log(value);
}
```

Use when you only need values.

#### `forEach`

```javascript
arr.forEach((value,index)=>{
 console.log(value,index);
});
```

Use for simple iteration.

---

### Array Methods (Most Important)

| Method | Use Case | Returns |
|--------|----------|---------|
| `map` | transform values | new array |
| `filter` | remove unwanted values | new array |
| `reduce` | combine values | single value |
| `find` | first match | element |
| `some` | any match | boolean |
| `every` | all match | boolean |
| `includes` | check value | boolean |

#### `map()`

Transform elements.

```javascript
const nums = [1,2,3];

const result = nums.map(n => n*2);

console.log(result);
```

**Output:**

```
[2,4,6]
```

#### `filter()`

Select elements.

```javascript
const nums = [1,2,3,4];

const result = nums.filter(n => n%2===0);
```

**Output:**

```
[2,4]
```

#### `reduce()`

Aggregate values.

```javascript
const nums = [1,2,3];

const sum = nums.reduce((acc,val)=>acc+val,0);
```

**Output:**

```
6
```

#### `find()`

```javascript
const nums = [5,10,15];

nums.find(n => n > 8);
```

**Output:**

```
10
```

---

### Array Interview Pattern

**Remove duplicates:**

```javascript
function removeDuplicates(arr){

 let result=[];

 for(let i=0;i<arr.length;i++){

  if(!result.includes(arr[i])){
   result.push(arr[i]);
  }

 }

 return result;
}
```

---

## 2. OBJECTS – Quick Cheat Sheet

### Create Object

```javascript
const user = {
 name:"Robert",
 age:25
};
```

### Access Object Values

```javascript
user.name
user["age"]
```

### Object Iteration

#### `for...in`

```javascript
for(let key in user){
 console.log(key,user[key]);
}
```

### Object Methods

| Method | Purpose |
|--------|---------|
| `Object.keys()` | get keys |
| `Object.values()` | get values |
| `Object.entries()` | get key-value pairs |

#### `Object.keys()`

```javascript
Object.keys(user)
```

**Output:**

```
["name","age"]
```

#### `Object.values()`

```javascript
Object.values(user)
```

**Output:**

```
["Robert",25]
```

#### `Object.entries()`

```javascript
Object.entries(user)
```

**Output:**

```
[["name","Robert"],["age",25]]
```

### Check if Key Exists

```javascript
"name" in user
```

or

```javascript
user.hasOwnProperty("name")
```

### Check if Value Exists

```javascript
Object.values(user).includes(25)
```

---

### Object Interview Pattern

**Count object values:**

```javascript
const obj = {a:1,b:2,c:3};

let sum = 0;

for(let key in obj){
 sum += obj[key];
}
```

---

## 3. STRINGS – Quick Cheat Sheet

### Create String

```javascript
const str = "hello";
```

### String Iteration

#### `for` loop

```javascript
for(let i=0;i<str.length;i++){
 console.log(str[i]);
}
```

#### `for...of`

```javascript
for(let char of str){
 console.log(char);
}
```

---

### Important String Methods

| Method | Purpose |
|--------|---------|
| `split` | string → array |
| `join` | array → string |
| `slice` | extract substring |
| `substring` | extract substring |
| `includes` | check substring |
| `replace` | replace text |
| `toUpperCase` | uppercase |
| `toLowerCase` | lowercase |
| `trim` | remove spaces |

#### `split()`

```javascript
"hello world".split(" ")
```

**Output:**

```
["hello","world"]
```

#### `join()`

```javascript
["hello","world"].join(" ")
```

**Output:**

```
hello world
```

#### `slice()`

```javascript
"hello".slice(1,4)
```

**Output:**

```
ell
```

#### `includes()`

```javascript
"hello".includes("ell")
```

**Output:**

```
true
```

#### `replace()`

```javascript
"hello world".replace("world","JS")
```

**Output:**

```
hello JS
```

---

### String Interview Pattern

**Reverse String:**

```javascript
function reverse(str){

 let result="";

 for(let i=str.length-1;i>=0;i--){
  result += str[i];
 }

 return result;
}
```

---

## MOST COMMON INTERVIEW PROBLEMS

**Arrays:**
- remove duplicates
- find largest number
- flatten array
- sum array

**Objects:**
- check key exists
- iterate object
- convert object to array
- count values

**Strings:**
- reverse string
- palindrome
- count characters
- anagram

---

## VERY IMPORTANT INTERVIEW DIFFERENCES

### `map` vs `forEach`

| `map` | `forEach` |
|-------|-----------|
| returns new array | returns undefined |
| used for transformation | used for iteration |

### `slice` vs `splice`

| `slice` | `splice` |
|---------|----------|
| does not modify original | modifies original |
| returns new array | removes elements |

### `substring` vs `slice`

| `substring` | `slice` |
|-------------|---------|
| no negative index | supports negative index |

---

## 10-Second Revision Before Interview

> Remember these core tools:

- `map` → transform array
- `filter` → remove elements
- `reduce` → aggregate values
- `Object.keys` → get keys
- `Object.values` → get values
- `split` → string to array
- `join` → array to string
- `slice` → extract string

Robert, since you told them you have ~2 years of experience, interviewers will expect more than arrays, objects, and strings. They will test whether you understand how JavaScript works internally and whether you have used it in real projects.

Below is a complete roadmap of JavaScript topics interviewers ask for 1–2 years experience, including:

What the concept is

Why interviewers ask it

How to answer

Example code

How to explain it verbally in interview

1. Scope in JavaScript
What is Scope

Scope determines where variables are accessible.

Types:

Global scope
Function scope
Block scope
Why Interviewers Ask

They want to see if you understand how variables behave in programs.

Example
let a = 10;

function test(){
 let b = 20;
 console.log(a);
}

test();

Output

10
Why

a is global so it is accessible inside function.

How to Explain in Interview

Scope defines where variables are accessible. JavaScript has global, function, and block scope. Variables declared with let and const are block-scoped, while var is function-scoped.

2. Hoisting
What is Hoisting

JavaScript moves variable and function declarations to the top of the scope.

Example
console.log(x);

var x = 5;

Output

undefined
Why

Because JS interprets it like this:

var x;

console.log(x);

x = 5;
let and const behavior
console.log(x);

let x = 5;

Output

ReferenceError

Because of Temporal Dead Zone (TDZ).

Interview Explanation

Hoisting is JavaScript’s behavior of moving declarations to the top. var is hoisted with undefined, while let and const exist in the Temporal Dead Zone until initialization.

3. Closures
What is Closure

A closure is when a function remembers variables from its outer scope even after the outer function finishes execution.

Example
function outer(){

 let count = 0;

 return function(){
  count++;
  console.log(count);
 }

}

const fn = outer();

fn();
fn();

Output

1
2
Why Interviewers Ask

Closures are used in:

React hooks
callbacks
data privacy
How to Explain

A closure occurs when a function retains access to variables from its lexical scope even after the outer function has returned.

4. Event Loop

This is very commonly asked.

What is Event Loop

JavaScript is single-threaded, so it uses an event loop to handle asynchronous operations.

Example
console.log("A");

setTimeout(()=>console.log("B"),0);

Promise.resolve().then(()=>console.log("C"));

console.log("D");

Output

A
D
C
B
Why

Execution order

Call Stack
↓
Microtask Queue (Promises)
↓
Macrotask Queue (setTimeout)
Interview Explanation

JavaScript executes synchronous code first. Then microtasks like Promises run, followed by macrotasks like setTimeout.

5. this Keyword
What is this

this refers to the object that calls the function.

Example
const obj = {
 name: "Robert",

 greet:function(){
  console.log(this.name);
 }
}

obj.greet();

Output

Robert
Arrow Function Behavior
const obj = {
 name:"Robert",

 greet:()=>{
  console.log(this.name);
 }
}

Output

undefined

Because arrow functions do not bind their own this.

6. Promises
What is Promise

Promise represents an asynchronous operation.

States:

pending
fulfilled
rejected
Example
const promise = new Promise((resolve,reject)=>{

 setTimeout(()=>{
  resolve("success");
 },1000);

});

promise.then(console.log);
Why Interviewers Ask

Promises are used in:

API calls
async programming
React data fetching
7. Async / Await
What

Simplified syntax for promises.

Example
async function getData(){

 const res = await fetch("api");

 const data = await res.json();

 console.log(data);

}
Interview Explanation

async/await allows writing asynchronous code that looks synchronous while still using promises under the hood.

8. Deep vs Shallow Copy
Shallow Copy

Copies reference of nested objects.

Example

let a = {x:1};

let b = {...a};

b.x = 10;
Deep Copy

Copies entire object structure.

Example

JSON.parse(JSON.stringify(obj))
9. Debouncing
What

Limits how often a function executes.

Used in:

search inputs
API calls
scroll events

Example

function debounce(fn,delay){

 let timer;

 return function(){

  clearTimeout(timer);

  timer = setTimeout(fn,delay);

 }

}
10. Throttling
What

Ensures a function runs at most once in a specified time interval.

Used in:

scroll events
resize events
11. Prototypes

JavaScript uses prototype-based inheritance.

Example

function Person(name){

 this.name = name;

}

Person.prototype.greet = function(){

 console.log("Hello");

}
12. Memory Management

JavaScript uses Garbage Collection.

Questions They Might Ask

Example interview questions:

What is closure?
What is hoisting?
Difference between var let const?
Explain event loop
What is promise?
Difference between async await and promises?
Difference between map filter reduce?
What is this keyword?
Final Advice for 2-Year Experience

Interviewers expect you to know:

JavaScript fundamentals
Async behavior
Closures
Event loop
Objects and arrays

If you understand these concepts deeply, you will perform well in the technical interview.