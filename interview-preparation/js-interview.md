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

- What the concept is
- Why interviewers ask it
- How to answer
- Example code
- How to explain it verbally in interview

---

### 1. Scope in JavaScript

**What is Scope:** Scope determines where variables are accessible.

**Types:**

- Global scope
- Function scope
- Block scope

**Why Interviewers Ask:** They want to see if you understand how variables behave in programs.

**Example:**

```javascript
let a = 10;

function test(){
 let b = 20;
 console.log(a);
}

test();
```

**Output:** `10`

**Why:** `a` is global so it is accessible inside function.

> **How to Explain in Interview:**
> Scope defines where variables are accessible. JavaScript has global, function, and block scope. Variables declared with `let` and `const` are block-scoped, while `var` is function-scoped.

---

### 2. Hoisting

**What is Hoisting:** JavaScript moves variable and function declarations to the top of the scope.

**Example:**

```javascript
console.log(x);

var x = 5;
```

**Output:** `undefined`

**Why:** Because JS interprets it like this:

```javascript
var x;

console.log(x);

x = 5;
```

**`let` and `const` behavior:**

```javascript
console.log(x);

let x = 5;
```

**Output:** `ReferenceError`

Because of **Temporal Dead Zone (TDZ)**.

> **Interview Explanation:**
> Hoisting is JavaScript’s behavior of moving declarations to the top. `var` is hoisted with `undefined`, while `let` and `const` exist in the Temporal Dead Zone until initialization.

---

### 3. Closures

**What is Closure:** A closure is when a function remembers variables from its outer scope even after the outer function finishes execution.

**Example:**

```javascript
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
```

**Output:**

```
1
2
```

**Why Interviewers Ask:** Closures are used in:

- React hooks
- callbacks
- data privacy

> **How to Explain:**
> A closure occurs when a function retains access to variables from its lexical scope even after the outer function has returned.

---

### 4. Event Loop

> This is very commonly asked.

**What is Event Loop:** JavaScript is single-threaded, so it uses an event loop to handle asynchronous operations.

**Example:**

```javascript
console.log("A");

setTimeout(()=>console.log("B"),0);

Promise.resolve().then(()=>console.log("C"));

console.log("D");
```

**Output:**

```
A
D
C
B
```

**Why — Execution order:**

```
Call Stack
↓
Microtask Queue (Promises)
↓
Macrotask Queue (setTimeout)
```

> **Interview Explanation:**
> JavaScript executes synchronous code first. Then microtasks like Promises run, followed by macrotasks like setTimeout.

---

### 5. `this` Keyword

**What is `this`:** `this` refers to the object that calls the function.

**Example:**

```javascript
const obj = {
 name: "Robert",

 greet:function(){
  console.log(this.name);
 }
}

obj.greet();
```

**Output:** `Robert`

**Arrow Function Behavior:**

```javascript
const obj = {
 name:"Robert",

 greet:()=>{
  console.log(this.name);
 }
}
```

**Output:** `undefined`

Because arrow functions do not bind their own `this`.

---

### 6. Promises

**What is Promise:** Promise represents an asynchronous operation.

**States:**

- `pending`
- `fulfilled`
- `rejected`

**Example:**

```javascript
const promise = new Promise((resolve,reject)=>{

 setTimeout(()=>{
  resolve("success");
 },1000);

});

promise.then(console.log);
```

**Why Interviewers Ask:** Promises are used in:

- API calls
- async programming
- React data fetching

---

### 7. Async / Await

**What:** Simplified syntax for promises.

**Example:**

```javascript
async function getData(){

 const res = await fetch("api");

 const data = await res.json();

 console.log(data);

}
```

> **Interview Explanation:**
> async/await allows writing asynchronous code that looks synchronous while still using promises under the hood.

---

### 8. Deep vs Shallow Copy

**Shallow Copy:** Copies reference of nested objects.

**Example:**

```javascript
let a = {x:1};

let b = {...a};

b.x = 10;
```

**Deep Copy:** Copies entire object structure.

**Example:**

```javascript
JSON.parse(JSON.stringify(obj))
```

---

### 9. Debouncing

**What:** Limits how often a function executes.

**Used in:**

- search inputs
- API calls
- scroll events

**Example:**

```javascript
function debounce(fn,delay){

 let timer;

 return function(){

  clearTimeout(timer);

  timer = setTimeout(fn,delay);

 }

}
```

---

### 10. Throttling

**What:** Ensures a function runs at most once in a specified time interval.

**Used in:**

- scroll events
- resize events

---

### 11. Prototypes

JavaScript uses prototype-based inheritance.

**Example:**

```javascript
function Person(name){

 this.name = name;

}

Person.prototype.greet = function(){

 console.log("Hello");

}
```

---

### 12. Memory Management

JavaScript uses **Garbage Collection**.

---

### Questions They Might Ask

Example interview questions:

- What is closure?
- What is hoisting?
- Difference between `var` `let` `const`?
- Explain event loop
- What is promise?
- Difference between async await and promises?
- Difference between `map` `filter` `reduce`?
- What is `this` keyword?

---

### Final Advice for 2-Year Experience

Interviewers expect you to know:

- JavaScript fundamentals
- Async behavior
- Closures
- Event loop
- Objects and arrays

> If you understand these concepts deeply, you will perform well in the technical interview.

---

## Practice Code — Array, Object, String Methods

```javascript
const nums = [1, 2, 3, 4]

console.log(nums.map((num) => num*2), nums)
console.log(nums.filter((num) => num%2==0), nums)
console.log(nums.find((num) => num > 0), nums)
console.log(nums.reduce((acc, val) => acc+val))

const object = {name: "robert", age: "20"}

console.log(Object.keys(object), object, "name" in object, object.hasOwnProperty("name"))
console.log(Object.values(object), object, Object.values(object).includes("robert"))
console.log(Object.entries(object))

const str = "hello world"
const strArray = [‘hello’, ‘world’]
const spaceStr = ‘ bhanu ‘

console.log(spaceStr.trim())
console.log(str.split(" "))
console.log(strArray.join(""))
console.log(str.slice(0, 3))
console.log(str.includes(‘hello’))
console.log(str.replace(‘world’, ‘js’))
```

## Top 25 JavaScript Coding Questions

---

### 1. Reverse a String

**🔹 Brute Force:**

```javascript
function reverseString(str){
  let result = ""

  for(let i = str.length - 1; i >= 0; i--){
    result += str[i]
  }

  return result
}
```

**🔹 Built-in:**

```javascript
function reverseString(str){
  return str.split("").reverse().join("")
}
```

---

### 2. Check Palindrome

**🔹 Brute Force:**

```javascript
function isPalindrome(str){
  let reversed = ""

  for(let i = str.length - 1; i >= 0; i--){
    reversed += str[i]
  }

  return str === reversed
}
```

**🔹 Built-in:**

```javascript
function isPalindrome(str){
  return str === str.split("").reverse().join("")
}
```

---

### 3. Reverse a Number

**🔹 Brute Force:**

```javascript
function reverseNumber(num){
  let result = 0

  while(num > 0){
    let digit = num % 10
    result = result * 10 + digit
    num = Math.floor(num / 10)
  }

  return result
}
```

**🔹 Built-in:**

```javascript
function reverseNumber(num){
  return Number(num.toString().split("").reverse().join(""))
}
```

---

### 4. Find Largest Number in Array

**🔹 Brute Force:**

```javascript
function max(arr){
  let largest = arr[0]

  for(let i = 1; i < arr.length; i++){
    if(arr[i] > largest){
      largest = arr[i]
    }
  }

  return largest
}
```

**🔹 Built-in:**

```javascript
function max(arr){
  return Math.max(...arr)
}
```

---

### 5. Find Smallest Number

**🔹 Brute Force:**

```javascript
function min(arr){
  let smallest = arr[0]

  for(let i = 1; i < arr.length; i++){
    if(arr[i] < smallest){
      smallest = arr[i]
    }
  }

  return smallest
}
```

**🔹 Built-in:**

```javascript
function min(arr){
  return Math.min(...arr)
}
```

---

### 6. Remove Duplicates

**🔹 Brute Force:**

```javascript
function removeDuplicates(arr){
  let result = []

  for(let i = 0; i < arr.length; i++){
    if(!result.includes(arr[i])){
      result.push(arr[i])
    }
  }

  return result
}
```

**🔹 Built-in:**

```javascript
function removeDuplicates(arr){
  return [...new Set(arr)]
}
```

---

### 7. Count Characters

**🔹 Brute Force:**

```javascript
function countChars(str){
  let obj = {}

  for(let char of str){
    if(obj[char]){
      obj[char]++
    }else{
      obj[char] = 1
    }
  }

  return obj
}
```

**🔹 Built-in:**

```javascript
function countChars(str){
  return str.split("").reduce((acc, char)=>{
    acc[char] = (acc[char] || 0) + 1
    return acc
  },{})
}
```

---

### 8. Find Even Numbers

**🔹 Brute Force:**

```javascript
function even(arr){
  let result = []

  for(let i = 0; i < arr.length; i++){
    if(arr[i] % 2 === 0){
      result.push(arr[i])
    }
  }

  return result
}
```

**🔹 Built-in:**

```javascript
function even(arr){
  return arr.filter(x => x % 2 === 0)
}
```

---

### 9. Sum of Array

**🔹 Brute Force:**

```javascript
function sum(arr){
  let total = 0

  for(let i = 0; i < arr.length; i++){
    total += arr[i]
  }

  return total
}
```

**🔹 Built-in:**

```javascript
function sum(arr){
  return arr.reduce((a,b)=>a+b,0)
}
```

---

### 🔟 Factorial

**🔹 Brute Force:**

```javascript
function factorial(n){
  let result = 1

  for(let i = 1; i <= n; i++){
    result *= i
  }

  return result
}
```

**🔹 Built-in (Recursion):**

```javascript
function factorial(n){
  if(n === 0) return 1
  return n * factorial(n-1)
}
```

---

### 1️⃣1️⃣ Fibonacci

**🔹 Brute Force:**

```javascript
function fib(n){
  let a = 0, b = 1

  for(let i = 2; i <= n; i++){
    let temp = a + b
    a = b
    b = temp
  }

  return b
}
```

**🔹 Built-in (Recursion):**

```javascript
function fib(n){
  if(n <= 1) return n
  return fib(n-1) + fib(n-2)
}
```

---

### 1️⃣2️⃣ Check Anagram

**🔹 Brute Force:**

```javascript
function isAnagram(a,b){
  if(a.length !== b.length) return false

  let obj = {}

  for(let char of a){
    obj[char] = (obj[char] || 0) + 1
  }

  for(let char of b){
    if(!obj[char]) return false
    obj[char]--
  }

  return true
}
```

**🔹 Built-in:**

```javascript
function isAnagram(a,b){
  return a.split("").sort().join("") === b.split("").sort().join("")
}
```

---

### 1️⃣3️⃣ Flatten Array

**🔹 Brute Force:**

```javascript
function flatten(arr){
  let result = []

  for(let item of arr){
    if(Array.isArray(item)){
      result = result.concat(flatten(item))
    }else{
      result.push(item)
    }
  }

  return result
}
```

**🔹 Built-in:**

```javascript
function flatten(arr){
  return arr.flat(Infinity)
}
```

---

### 1️⃣4️⃣ Find Duplicate Elements

**🔹 Brute Force:**

```javascript
function duplicates(arr){
  let result = []

  for(let i = 0; i < arr.length; i++){
    for(let j = i+1; j < arr.length; j++){
      if(arr[i] === arr[j] && !result.includes(arr[i])){
        result.push(arr[i])
      }
    }
  }

  return result
}
```

**🔹 Built-in:**

```javascript
function duplicates(arr){
  return arr.filter((item, index)=>arr.indexOf(item) !== index)
}
```

---

### 1️⃣5️⃣ Capitalize First Letter

**🔹 Brute Force:**

```javascript
function capitalize(str){
  let words = str.split(" ")

  for(let i = 0; i < words.length; i++){
    words[i] = words[i][0].toUpperCase() + words[i].slice(1)
  }

  return words.join(" ")
}
```

**🔹 Built-in:**

```javascript
function capitalize(str){
  return str.split(" ")
    .map(w => w.charAt(0).toUpperCase() + w.slice(1))
    .join(" ")
}
```

> 👉 I’ve covered 15 core ones here (most asked 🔥)

---

## 🚀 React Coding Questions (Top 15)

---

### 1. Input and Show in UI

```jsx
function App(){
  const [name,setName] = useState("")

  return (
    <>
      <input onChange={(e)=>setName(e.target.value)} />
      <h1>{name}</h1>
    </>
  )
}
```

---

### 2. Counter

```jsx
const [count,setCount] = useState(0)

<button onClick={()=>setCount(count+1)}>+</button>
<button onClick={()=>setCount(count-1)}>-</button>
<button onClick={()=>setCount(0)}>Reset</button>
```

---

### 3. Filter Even Numbers

```javascript
const arr = [1,2,3,4]

const even = arr.filter(x => x % 2 === 0)
```

---

### 4. Todo List

```jsx
const [list,setList] = useState([])
const [input,setInput] = useState("")

function add(){
  setList([...list,input])
}
```

---

### 5. Conditional Rendering

```jsx
{isLoggedIn ? <Home/> : <Login/>}
```

---

### 6. Fetch API

```javascript
useEffect(()=>{
 fetch("api")
   .then(res=>res.json())
   .then(data=>console.log(data))
},[])
```

---

### 7. Debounce Input (important)

```javascript
useEffect(()=>{
 const timer = setTimeout(()=>{
   console.log(input)
 },500)

 return ()=>clearTimeout(timer)
},[input])
```

---

### 8. Toggle

```jsx
const [show,setShow] = useState(true)

<button onClick={()=>setShow(!show)}>
 Toggle
</button>
```

---

### 9. Form Handling

```jsx
<input value={name} onChange={(e)=>setName(e.target.value)} />
```

---

### 🔟 Props Passing

```jsx
<Child name="Robert" />
```

---

## 3️⃣ Node.js Questions (Top 10)

---

### 1. Simple API

```javascript
app.get("/user",(req,res)=>{
 res.send("Hello")
})
```

---

### 2. Middleware

```javascript
app.use((req,res,next)=>{
 console.log("middleware")
 next()
})
```

---

### 3. POST API

```javascript
app.post("/user",(req,res)=>{
 res.json(req.body)
})
```

---

### 4. PUT vs PATCH

- **PUT** → full update
- **PATCH** → partial update

---

### 5. DB Connection Pooling (concept)

Reuse connections instead of creating new ones.

---

### 6. HTTPS

Secure communication using SSL.

---

### 7. Async API

```javascript
app.get("/data", async (req,res)=>{
 let data = await fetchData()
 res.json(data)
})
```

---

### 8. Error Handling

```javascript
app.use((err,req,res,next)=>{
 res.status(500).send(err.message)
})
```

---

### 9. Authentication Middleware

```javascript
function auth(req,res,next){
 if(req.headers.token){
   next()
 }else{
   res.send("Unauthorized")
 }
}
```

---

### 🔟 Routing

```javascript
const router = express.Router()
```


> Good question — this is a very common interview topic. Let’s break it down clearly so you can explain it confidently.

---

## 🔥 `map()` vs `for` loop (Arrays in JavaScript)

---

### ✅ 1. Basic Difference

| Feature | `map()` | `for` loop |
|---------|---------|------------|
| Type | Array method | General loop |
| Returns | New array | Nothing (unless you return manually) |
| Mutation | Does NOT modify original array | Can modify original array |
| Use case | Transform data | Any kind of iteration |

---

### 🧠 2. Example

**👉 Using `map()`:**

```javascript
const nums = [1, 2, 3, 4];

const doubled = nums.map(num => num * 2);

console.log(doubled); // [2, 4, 6, 8]
```

- ✔ Automatically creates a new array
- ✔ Cleaner and shorter

**👉 Using `for` loop:**

```javascript
const nums = [1, 2, 3, 4];
const doubled = [];

for (let i = 0; i < nums.length; i++) {
  doubled.push(nums[i] * 2);
}

console.log(doubled); // [2, 4, 6, 8]
```

- ✔ You must manually:
  - Create array
  - Push values

---

### ⚡ 3. Key Differences (Important for Interview)

**🔹 1. Return Value**

- `map()` → always returns a new array
- `for` loop → returns nothing unless you handle it

**🔹 2. Code Readability**

- `map()` → clean & functional
- `for` loop → more verbose

> **👉 Interview line:**
> "map is preferred when transforming arrays because it’s declarative and readable."

**🔹 3. Use Case**

Use `map()` when:
- You want to transform data
- Example: `users.map(user => user.name)`

Use `for` loop when:
- You need `break` / `continue`
- complex logic
- performance control

**🔹 4. Break / Continue**

- ❌ `map()` → cannot use break or continue
- ✅ `for` loop → supports both

```javascript
for (let i = 0; i < 5; i++) {
  if (i === 3) break;
}
```

**🔹 5. Performance**

- `for` loop → slightly faster (low-level control)
- `map()` → slightly slower but cleaner

> 👉 In real apps → difference is negligible

**🔹 6. Mutation**

```javascript
const arr = [1,2,3];

arr.map(num => num * 2);
console.log(arr); // [1,2,3] ✅ unchanged
```

```javascript
for (let i = 0; i < arr.length; i++) {
  arr[i] = arr[i] * 2;
}
console.log(arr); // [2,4,6] ❗ modified
```

---

### 🎯 4. When to Use What (Best Answer)

**👉 Use `map()`:**

- When transforming arrays
- When writing clean React code (very important)

**👉 Use `for` loop:**

- When you need control (break, continue)
- When performance matters
- When logic is complex

---

### 🧾 Final Interview Answer (Say this 👇)

> "map() is an array method used to transform each element and return a new array without mutating the original one. It is more readable and commonly used in functional programming and React.
>
> A for loop is a general-purpose looping construct that provides more control, allows break and continue, and can be used for complex logic, but requires more code."

---

## 🔥 How to Iterate Through an Object in JavaScript

> Great question — this is very important for interviews and real projects 👍
>
> Unlike arrays, objects are not directly iterable, so we use special methods.

---

### ✅ 1. Using `for...in` (Most Basic)

```javascript
const user = {
  name: "Bhanu",
  age: 25,
  city: "Bangalore"
};

for (let key in user) {
  console.log(key, user[key]);
}
```

**👉 Output:**

```
name Bhanu
age 25
city Bangalore
```

- ✔ Gives you keys
- ✔ Access value using `obj[key]`

---

### ✅ 2. Using `Object.keys()` (Very Common)

```javascript
const user = {
  name: "Bhanu",
  age: 25,
  city: "Bangalore"
};

Object.keys(user).map(key => {
  console.log(key, user[key]);
});
```

- ✔ Returns array of keys → `["name", "age", "city"]`
- ✔ Can use `map`, `forEach`, etc.

---

### ✅ 3. Using `Object.values()`

```javascript
Object.values(user).forEach(value => {
  console.log(value);
});
```

**👉 Output:**

```
Bhanu
25
Bangalore
```

- ✔ Only values
- ✔ No keys

---

### ✅ 4. Using `Object.entries()` (🔥 Best for Interviews)

```javascript
Object.entries(user).forEach(([key, value]) => {
  console.log(key, value);
});
```

**👉 Output:**

```
name Bhanu
age 25
city Bangalore
```

✔ Returns:

```javascript
[
  ["name", "Bhanu"],
  ["age", 25],
  ["city", "Bangalore"]
]
```

✔ Clean + modern approach

---

### ⚡ 5. Using `for...of` (with entries)

```javascript
for (let [key, value] of Object.entries(user)) {
  console.log(key, value);
}
```

✔ Best combination (clean + powerful)

---

### 🧠 Quick Comparison

| Method | Gives | Best For |
|--------|-------|----------|
| `for...in` | keys | Simple iteration |
| `Object.keys()` | keys | When using array methods |
| `Object.values()` | values | Only values needed |
| `Object.entries()` | key + value | 🔥 Best modern approach |

---

### 🎯 When to Use What

**👉 Use `Object.entries()`:**

- Cleanest and most used in modern JS
- Great for React & real projects

**👉 Use `for...in`:**

- When you just need quick iteration

---

### 🧾 Interview Answer (Say this 👇)

> "Objects are not directly iterable like arrays, so we use methods like `for...in`, `Object.keys()`, `Object.values()`, and `Object.entries()`.
> The most modern and preferred approach is `Object.entries()` because it gives both key and value and works well with `for...of` and array methods."