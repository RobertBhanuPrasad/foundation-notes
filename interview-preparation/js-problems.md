# JavaScript Interview Coding Problems

> **Reference:** [sudheerj/javascript-interview-questions](https://github.com/sudheerj/javascript-interview-questions?tab=readme-ov-file)

---

## Part 1 - Core Problems

---

### 1. Reverse a String (Very Common)

**Problem:** Reverse a string.

| Input | Output |
|-------|--------|
| `"hello"` | `"olleh"` |

**Approach:**
1. Start from last character
2. Append each character to new string
3. Continue until index 0

```javascript
function reverseString(str){
  let result = "";
  for(let i = str.length - 1; i >= 0; i--){
    result = result + str[i];
  }
  return result;
}

console.log(reverseString("hello"));
```

> **Time Complexity:** O(n)

---

### 2. Check Palindrome

**Problem:** Check if string is palindrome.

| Input | Output |
|-------|--------|
| `"madam"` | `true` |

**Approach:**
1. Compare first and last characters
2. Move inward
3. If mismatch return false

```javascript
function isPalindrome(str){
  let left = 0;
  let right = str.length - 1;

  while(left < right){
    if(str[left] !== str[right]){
      return false;
    }
    left++;
    right--;
  }

  return true;
}
```

---

### 3. Find Largest Number in Array

**Problem:** Find the largest number in an array.

| Input | Output |
|-------|--------|
| `[4,7,2,9,5]` | `9` |

**Approach:**
1. Assume first number is largest
2. Compare with others
3. Update max if bigger

```javascript
function findMax(arr){
  let max = arr[0];

  for(let i = 1; i < arr.length; i++){
    if(arr[i] > max){
      max = arr[i];
    }
  }

  return max;
}
```

---

### 4. Remove Duplicates from Array

**Problem:** Remove duplicate elements from an array.

| Input | Output |
|-------|--------|
| `[1,2,2,3,4,4]` | `[1,2,3,4]` |

**Approach:**
1. Create new array
2. Check if element already exists
3. If not, add it

```javascript
function removeDuplicates(arr){
  let result = [];

  for(let i = 0; i < arr.length; i++){
    let exists = false;

    for(let j = 0; j < result.length; j++){
      if(arr[i] === result[j]){
        exists = true;
        break;
      }
    }

    if(!exists){
      result[result.length] = arr[i];
    }
  }

  return result;
}
```

---

### 5. Count Character Frequency

**Problem:** Count how many times each character appears.

| Input | Output |
|-------|--------|
| `"apple"` | `a:1, p:2, l:1, e:1` |

**Approach:**
1. Create empty object
2. Loop through string
3. Increase count

```javascript
function charFrequency(str){
  let map = {};

  for(let i = 0; i < str.length; i++){
    let char = str[i];

    if(map[char] === undefined){
      map[char] = 1;
    } else {
      map[char] = map[char] + 1;
    }
  }

  return map;
}
```

---

### 6. Find Missing Number

**Problem:** Find the missing number in a sequence from 1 to n.

| Input | Output |
|-------|--------|
| `[1,2,3,5]` | `4` |

**Approach:**
1. Find expected sum using formula: `n(n+1)/2`
2. Subtract actual sum

```javascript
function missingNumber(arr, n){
  let expected = (n * (n + 1)) / 2;
  let sum = 0;

  for(let i = 0; i < arr.length; i++){
    sum = sum + arr[i];
  }

  return expected - sum;
}
```

---

### 7. Two Sum Problem

**Problem:** Find two numbers that add up to a target.

| Input | Output |
|-------|--------|
| `[2,7,11,15], target=9` | `[0,1]` |

**Approach:**
1. Store numbers in object
2. Check complement

```javascript
function twoSum(arr, target){
  let map = {};

  for(let i = 0; i < arr.length; i++){
    let complement = target - arr[i];

    if(map[complement] !== undefined){
      return [map[complement], i];
    }

    map[arr[i]] = i;
  }
}
```

---

### 8. Reverse Array

**Problem:** Reverse an array in-place.

| Input | Output |
|-------|--------|
| `[1,2,3]` | `[3,2,1]` |

```javascript
function reverseArray(arr){
  let left = 0;
  let right = arr.length - 1;

  while(left < right){
    let temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;

    left++;
    right--;
  }

  return arr;
}
```

---

### 9. Factorial

**Problem:** Find the factorial of a number.

| Input | Output |
|-------|--------|
| `5` | `120` |

```javascript
function factorial(n){
  let result = 1;

  for(let i = 1; i <= n; i++){
    result = result * i;
  }

  return result;
}
```

---

### 10. Check Anagram

**Problem:** Check if two strings are anagrams of each other.

| Input | Output |
|-------|--------|
| `"listen", "silent"` | `true` |

```javascript
function isAnagram(a, b){
  if(a.length !== b.length){
    return false;
  }

  let count = {};

  for(let i = 0; i < a.length; i++){
    let char = a[i];
    if(count[char]){
      count[char]++;
    } else {
      count[char] = 1;
    }
  }

  for(let i = 0; i < b.length; i++){
    let char = b[i];
    if(!count[char]){
      return false;
    }
    count[char]--;
  }

  return true;
}
```

---

### 11. Find Second Largest Number

**Problem:** Find the second largest number in an array.

```javascript
function secondLargest(arr){
  let first = -Infinity;
  let second = -Infinity;

  for(let i = 0; i < arr.length; i++){
    if(arr[i] > first){
      second = first;
      first = arr[i];
    } else if(arr[i] > second && arr[i] !== first){
      second = arr[i];
    }
  }

  return second;
}
```

---

### 12. FizzBuzz

**Problem:** Print numbers 1-100 with rules:
- Divisible by 3 → `"Fizz"`
- Divisible by 5 → `"Buzz"`
- Divisible by both 3 & 5 → `"FizzBuzz"`

```javascript
for(let i = 1; i <= 100; i++){
  if(i % 3 === 0 && i % 5 === 0){
    console.log("FizzBuzz");
  } else if(i % 3 === 0){
    console.log("Fizz");
  } else if(i % 5 === 0){
    console.log("Buzz");
  } else {
    console.log(i);
  }
}
```

---

### 13. Linear Search

**Problem:** Search for a target in an array, return its index.

```javascript
function search(arr, target){
  for(let i = 0; i < arr.length; i++){
    if(arr[i] === target){
      return i;
    }
  }
  return -1;
}
```

---

## Part 2 - Practice Problems

---

### 1. Find the Sum of Array Elements

**Problem:** Return the sum of all numbers in an array.

| Input | Output |
|-------|--------|
| `[1,2,3,4]` | `10` |

```javascript
function arraySum(arr){
  let sum = 0;

  for(let i = 0; i < arr.length; i++){
    sum = sum + arr[i];
  }

  return sum;
}

console.log(arraySum([1,2,3,4]));
```

---

### 2. Count Even Numbers in Array

| Input | Output |
|-------|--------|
| `[1,2,3,4,6]` | `3` |

```javascript
function countEven(arr){
  let count = 0;

  for(let i = 0; i < arr.length; i++){
    if(arr[i] % 2 === 0){
      count++;
    }
  }

  return count;
}
```

---

### 3. Find Smallest Number

| Input | Output |
|-------|--------|
| `[7,3,9,2,5]` | `2` |

```javascript
function findMin(arr){
  let min = arr[0];

  for(let i = 1; i < arr.length; i++){
    if(arr[i] < min){
      min = arr[i];
    }
  }

  return min;
}
```

---

### 4. Reverse Words in Sentence

| Input | Output |
|-------|--------|
| `"hello world"` | `"world hello"` |

```javascript
function reverseWords(str){
  let words = str.split(" ");
  let result = "";

  for(let i = words.length - 1; i >= 0; i--){
    result += words[i];
    if(i !== 0){
      result += " ";
    }
  }

  return result;
}
```

---

### 5. Count Vowels in String

| Input | Output |
|-------|--------|
| `"hello"` | `2` |

```javascript
function countVowels(str){
  let vowels = "aeiou";
  let count = 0;

  for(let i = 0; i < str.length; i++){
    for(let j = 0; j < vowels.length; j++){
      if(str[i] === vowels[j]){
        count++;
      }
    }
  }

  return count;
}
```

---

### 6. Check if Array is Sorted

| Input | Output |
|-------|--------|
| `[1,2,3,4]` | `true` |

```javascript
function isSorted(arr){
  for(let i = 0; i < arr.length - 1; i++){
    if(arr[i] > arr[i + 1]){
      return false;
    }
  }

  return true;
}
```

---

### 7. Find Index of Element

| Input | Output |
|-------|--------|
| `[4,7,1,9], target=1` | `2` |

```javascript
function findIndex(arr, target){
  for(let i = 0; i < arr.length; i++){
    if(arr[i] === target){
      return i;
    }
  }

  return -1;
}
```

---

### 8. Count Words in Sentence

| Input | Output |
|-------|--------|
| `"I love coding"` | `3` |

```javascript
function countWords(str){
  let count = 1;

  for(let i = 0; i < str.length; i++){
    if(str[i] === " "){
      count++;
    }
  }

  return count;
}
```

---

### 9. Find Duplicate Elements

| Input | Output |
|-------|--------|
| `[1,2,3,2,4]` | `[2]` |

```javascript
function findDuplicates(arr){
  let duplicates = [];

  for(let i = 0; i < arr.length; i++){
    for(let j = i + 1; j < arr.length; j++){
      if(arr[i] === arr[j]){
        duplicates.push(arr[i]);
      }
    }
  }

  return duplicates;
}
```

---

### 10. Flatten Simple Nested Array

| Input | Output |
|-------|--------|
| `[1,[2,3],4]` | `[1,2,3,4]` |

```javascript
function flatten(arr){
  let result = [];

  for(let i = 0; i < arr.length; i++){
    if(Array.isArray(arr[i])){
      for(let j = 0; j < arr[i].length; j++){
        result.push(arr[i][j]);
      }
    } else {
      result.push(arr[i]);
    }
  }

  return result;
}
```

---

### 11. Capitalize First Letter

| Input | Output |
|-------|--------|
| `"hello"` | `"Hello"` |

```javascript
function capitalize(str){
  let first = str[0].toUpperCase();
  let rest = "";

  for(let i = 1; i < str.length; i++){
    rest += str[i];
  }

  return first + rest;
}
```

---

### 12. Find Longest Word

| Input | Output |
|-------|--------|
| `"I love programming"` | `"programming"` |

```javascript
function longestWord(str){
  let words = str.split(" ");
  let longest = "";

  for(let i = 0; i < words.length; i++){
    if(words[i].length > longest.length){
      longest = words[i];
    }
  }

  return longest;
}
```

---

### 13. Generate Fibonacci Series

| Input | Output |
|-------|--------|
| `5` | `0 1 1 2 3` |

```javascript
function fibonacci(n){
  let a = 0;
  let b = 1;

  console.log(a);
  console.log(b);

  for(let i = 2; i < n; i++){
    let next = a + b;
    console.log(next);
    a = b;
    b = next;
  }
}
```

---

### 14. Swap Two Numbers

| Input | Output |
|-------|--------|
| `a=5, b=10` | `a=10, b=5` |

```javascript
function swap(a, b){
  let temp = a;
  a = b;
  b = temp;

  console.log(a, b);
}
```

---

### 15. Find Sum of Digits

| Input | Output |
|-------|--------|
| `123` | `6` |

```javascript
function sumDigits(num){
  let sum = 0;

  while(num > 0){
    sum = sum + (num % 10);
    num = Math.floor(num / 10);
  }

  return sum;
}
```

---

## Most Likely Coding Topics in Tests

For frontend developer tests, companies mostly give problems from:

- Arrays
- Strings
- Loops
- Objects
- Frequency counting
- Duplicates
- Reversing
- Sorting logic


Robert 👍

In technical interviews, they often give small problems and expect you to choose the correct method (map, filter, reduce, Object.keys, split, etc.).
They also ask why you used that method instead of another one.

Below is a structured practice set with:

- Interview Question
- Correct Method
- Code
- Why that method
- Why not other methods
- Differences

---

## 1️⃣ ARRAY METHODS

---

### Q1 — Transform Array Values

**Question:** Multiply every number by 2.

| Input | Output |
|-------|--------|
| `[1,2,3]` | `[2,4,6]` |

**Correct Method:** `map()`

**Code:**

```javascript
const nums = [1,2,3];

const result = nums.map(num => num * 2);

console.log(result);
```

**Output:** `[2,4,6]`

**Why `map()`:** Because map transforms each element and returns a new array.

**Why NOT `forEach()`:** forEach() does not return a new array.

**Difference:**

| `map` | `forEach` |
|-------|-----------|
| returns new array | returns undefined |
| used for transformation | used for iteration |

---

### Q2 — Filter Array Elements

**Question:** Return only even numbers.

| Input | Output |
|-------|--------|
| `[1,2,3,4]` | `[2,4]` |

**Method:** `filter()`

**Code:**

```javascript
const nums = [1,2,3,4];

const result = nums.filter(num => num % 2 === 0);

console.log(result);
```

**Why `filter()`:** Because it selects elements that match condition.

**Why NOT `map()`:** map() modifies elements but does not remove them.

**Difference:**

| `filter` | `map` |
|----------|-------|
| removes elements | transforms elements |

---

### Q3 — Find First Matching Element

**Question:** Find first number greater than 10.

| Input | Output |
|-------|--------|
| `[5,8,12,20]` | `12` |

**Method:** `find()`

**Code:**

```javascript
const arr = [5,8,12,20];

const result = arr.find(num => num > 10);

console.log(result);
```

**Why `find()`:** Returns first matching element.

**Why NOT `filter()`:** filter() returns all matching elements.

**Difference:**

| `find` | `filter` |
|--------|----------|
| first match | all matches |

---

### Q4 — Calculate Sum of Array

**Question:**

| Input | Output |
|-------|--------|
| `[1,2,3,4]` | `10` |

**Method:** `reduce()`

**Code:**

```javascript
const nums = [1,2,3,4];

const sum = nums.reduce((acc,val)=>acc+val,0);

console.log(sum);
```

**Why `reduce()`:** Because it reduces array into single value.

**Why NOT `map()`:** map() returns an array.

---

## 2️⃣ OBJECT METHODS

---

### Q5 — Get Object Keys

**Question:** Get all keys.

**Input:**

```javascript
{
 name:"John",
 age:25
}
```

**Method:** `Object.keys()`

**Code:**

```javascript
const user = {
 name:"John",
 age:25
};

console.log(Object.keys(user));
```

**Output:** `["name","age"]`

**Why:** Objects are not iterable directly.

---

### Q6 — Get Object Values

**Method:** `Object.values()`

**Code:**

```javascript
console.log(Object.values(user));
```

**Output:** `["John",25]`

---

### Q7 — Get Key-Value Pairs

**Method:** `Object.entries()`

**Code:**

```javascript
console.log(Object.entries(user));
```

**Output:** `[["name","John"],["age",25]]`

**Difference:**

| Method | Output |
|--------|--------|
| `keys` | `["name","age"]` |
| `values` | `["John",25]` |
| `entries` | `[["name","John"],["age",25]]` |

---

### Q8 — Check if Object Key Exists

**Question:** Check if "name" exists.

**Code:**

```javascript
"name" in user
```

OR

```javascript
user.hasOwnProperty("name")
```

---

### Q9 — Check if Object Value Exists

**Code:**

```javascript
Object.values(user).includes("John")
```

---

## 3️⃣ STRING METHODS

---

### Q10 — Convert String to Array

**Question:**

| Input | Output |
|-------|--------|
| `"hello world"` | `["hello","world"]` |

**Method:** `split()`

**Code:**

```javascript
const str = "hello world";

const result = str.split(" ");

console.log(result);
```

---

### Q11 — Convert Array to String

**Method:** `join()`

**Code:**

```javascript
const arr = ["hello","world"];

console.log(arr.join(" "));
```

**Output:** `hello world`

---

### Q12 — Extract Part of String

**Method:** `slice()`

**Code:**

```javascript
const str = "javascript";

console.log(str.slice(0,4));
```

**Output:** `java`

**Difference:**

| `slice` | `substring` |
|---------|-------------|
| supports negative index | no negative index |

---

### Q13 — Check Substring Exists

**Method:** `includes()`

**Code:**

```javascript
"javascript".includes("script")
```

**Output:** `true`

---

### Q14 — Replace Part of String

**Method:** `replace()`

**Code:**

```javascript
"hello world".replace("world","JS")
```

**Output:** `hello JS`

---

### Q15 — Remove Spaces

**Method:** `trim()`

**Code:**

```javascript
" hello ".trim()
```

**Output:** `hello`

---

## ⭐ Very Common Interview Questions

They often ask things like:

- Use `map` to transform array
- Use `filter` to remove elements
- Use `reduce` to calculate values
- Use `Object.keys` to iterate object
- Use `split`/`join` for string problems

---

## 🚀 Final Quick Revision

**Arrays:**
- `map` → transform values
- `filter` → remove elements
- `reduce` → combine values
- `find` → first match

**Objects:**
- `Object.keys` → keys
- `Object.values` → values
- `Object.entries` → pairs

**Strings:**
- `split` → string → array
- `join` → array → string
- `slice` → substring
- `replace` → change text


Perfect Robert 👍

Now we will cover Topic 4: Technical Concepts (JS, React, Node, DB) exactly like a technical interview discussion round for 2 years experience.

I will structure it like this so you can explain confidently to the interviewer:

1. JavaScript Core Concepts
2. React Concepts
3. Node.js Concepts
4. Database Concepts
5. Fullstack Understanding (how everything connects)

For each topic I’ll explain:

- What
- Why
- How
- Example
- Differences
- Interview explanation

---

## 1️⃣ JAVASCRIPT TECHNICAL CONCEPTS

> These are most asked in interviews.

---

### 1. `var` vs `let` vs `const`

**What:** Ways to declare variables.

**Example:**

```javascript
var a = 10
let b = 20
const c = 30
```

**Why:** They behave differently with scope and hoisting.

**Differences:**

| Feature | `var` | `let` | `const` |
|---------|-------|-------|---------|
| Scope | Function | Block | Block |
| Redeclare | Yes | No | No |
| Reassign | Yes | Yes | No |
| Hoisting | Yes | Yes | Yes |
| TDZ | No | Yes | Yes |

**Example:**

```javascript
if(true){

 var a = 10
 let b = 20

}

console.log(a) // works
console.log(b) // error
```

> **Interview Explanation:**
> `var` is function scoped while `let` and `const` are block scoped. `const` cannot be reassigned.

---

### 2. Closures

**What:** Function remembers variables from outer scope.

**Example:**

```javascript
function outer(){

 let count = 0

 return function(){
  count++
  console.log(count)
 }

}

const fn = outer()

fn()
fn()
```

**Output:**

```
1
2
```

**Why Used:**

- data privacy
- callbacks
- React hooks

---

### 3. Hoisting

**What:** JavaScript moves declarations to top.

**Example:**

```javascript
console.log(a)

var a = 5
```

**Output:** `undefined`

**Equivalent to:**

```javascript
var a

console.log(a)

a = 5
```

---

### 4. Event Loop

JavaScript is single-threaded.

To handle async tasks it uses:

- Call Stack
- Callback Queue
- Event Loop

**Example:**

```javascript
console.log("A")

setTimeout(()=>{
 console.log("B")
},0)

console.log("C")
```

**Output:**

```
A
C
B
```

---

### 5. Promises

**What:** Promise represents future value of async operation.

**States:**

- `pending`
- `fulfilled`
- `rejected`

**Example:**

```javascript
const promise = new Promise((resolve,reject)=>{

 setTimeout(()=>{
  resolve("Success")
 },1000)

})

promise.then(console.log)
```

---

### 6. Async / Await

Simplifies promises.

**Example:**

```javascript
async function getData(){

 const res = await fetch("api")

 const data = await res.json()

 console.log(data)

}
```

---

## 2️⃣ REACT TECHNICAL CONCEPTS

---

### 1. What is React

React is a JavaScript library for building UI.

**Key idea:** Component based architecture

**Example:**

```jsx
function App(){

 return <h1>Hello</h1>

}
```

---

### 2. Components

**Two types:**

- Functional components
- Class components

Now mostly functional components.

**Example:**

```jsx
function Welcome(){

 return <h1>Hello</h1>

}
```

---

### 3. Props

Props pass data from parent to child.

**Parent:**

```jsx
<Child name="Robert"/>
```

**Child:**

```jsx
function Child(props){

 return <h1>{props.name}</h1>

}
```

---

### 4. State

State stores dynamic data.

**Example:**

```javascript
const [count,setCount] = useState(0)
```

**Difference:**

| Props | State |
|-------|-------|
| read-only | mutable |
| passed from parent | managed inside component |

---

### 5. useEffect

Used for side effects.

**Use cases:**

- API calls
- subscriptions
- DOM updates

**Example:**

```javascript
useEffect(()=>{

 console.log("component mounted")

},[])
```

---

### 6. React Rendering

React uses Virtual DOM.

**Steps:**

1. State change
2. Virtual DOM update
3. Diffing algorithm
4. DOM update

---

### 7. Keys in React

Used in list rendering.

**Example:**

```jsx
items.map(item=>(
 <li key={item.id}>{item.name}</li>
))
```

---

## 3️⃣ NODE.JS CONCEPTS

---

### 1. What is Node.js

Node.js allows JavaScript to run on server.

**Built on:** Chrome V8 engine

---

### 2. Why Node.js

- non-blocking
- event driven
- fast I/O

---

### 3. Creating Server

**Example:**

```javascript
const http = require("http")

const server = http.createServer((req,res)=>{

 res.end("Hello")

})

server.listen(3000)
```

---

### 4. Express.js

Framework for Node.

**Example:**

```javascript
const express = require("express")

const app = express()

app.get("/",(req,res)=>{

 res.send("Hello")

})

app.listen(3000)
```

---

### 5. Middleware

Functions executed before request completes.

**Example:**

- authentication
- logging
- validation

---

## 4️⃣ DATABASE CONCEPTS

---

### 1. SQL vs NoSQL

| SQL | NoSQL |
|-----|-------|
| structured | flexible |
| tables | documents |
| MySQL | MongoDB |

**Example SQL Query:**

```sql
SELECT * FROM users
```

**Insert:**

```sql
INSERT INTO users(name)
VALUES(‘John’)
```

**MongoDB Example — Document:**

```json
{
 "name":"John",
 "age":25
}
```

---

### 2. Indexing

Indexes improve query performance.

**Example:**

```sql
CREATE INDEX idx_name ON users(name)
```

---

### 3. Joins

Used to combine tables.

**Example:**

- `INNER JOIN`
- `LEFT JOIN`
- `RIGHT JOIN`

---

## 5️⃣ HOW FULLSTACK APPLICATION WORKS

**Typical flow:**

```
React UI
↓
API call
↓
Node server
↓
Database query
↓
Return JSON
↓
React renders UI
```

**Example:**

- React → fetch API
- Node → process request
- DB → store data

---

## ⭐ Most Common Technical Interview Questions

They may ask:

- Explain closures
- Explain event loop
- Difference `var` `let` `const`
- What is `useEffect`
- Difference props and state
- What is middleware
- How Node handles async operations
- Difference SQL and NoSQL

---

## ⭐ Example Interview Answer

**Question:** What is closure?

> **Answer:**
> A closure is when a function remembers variables from its outer lexical scope even after the outer function has executed.

---

## ⭐ Advice for 2-Year Experience Interview

Interviewers expect you to know:

- JavaScript internals
- React hooks
- API handling
- Node basics
- Database queries

---

## DSA Problems — Brute Force & Optimized

> Below are the JavaScript solutions for each problem with:
>
> 1️⃣ Brute Force Approach
> 2️⃣ Optimized / Better DSA Approach
> 3️⃣ Example explanation

---

### 1️⃣ Number of Palindromes in a String

| Input | Output |
|-------|--------|
| `"abbaeae"` | `11` |

Because substrings like: `a, b, b, a, bb, abba, e, a, e, aeae...`

**🔹 Brute Force Approach — O(n³)**

**Idea:** Generate all substrings, check if each substring is palindrome.

```javascript
function countPalindromesBrute(str) {
  let count = 0;

  for (let i = 0; i < str.length; i++) {
    for (let j = i; j < str.length; j++) {
      let substring = str.slice(i, j + 1);

      if (isPalindrome(substring)) {
        count++;
      }
    }
  }

  return count;
}

function isPalindrome(s) {
  return s === s.split("").reverse().join("");
}

console.log(countPalindromesBrute("abbaeae"));
```

**Complexity:** Time: `O(n³)` | Space: `O(1)`

**🔹 Optimized Approach (Expand Around Center) — O(n²)**

**Idea:** Every palindrome expands from a center.

Centers can be:

- odd length → `aba`
- even length → `abba`

```javascript
function countPalindromesOptimized(str) {
  let count = 0;

  function expand(left, right) {
    while (left >= 0 && right < str.length && str[left] === str[right]) {
      count++;
      left--;
      right++;
    }
  }

  for (let i = 0; i < str.length; i++) {
    expand(i, i);     // odd length
    expand(i, i + 1); // even length
  }

  return count;
}

console.log(countPalindromesOptimized("abbaeae"));
```

**Complexity:** Time: `O(n²)` | Space: `O(1)`

---

### 2️⃣ Print Even Numbers in an Array

| Input | Output |
|-------|--------|
| `[1,2,3,4,5,6]` | `[2,4,6]` |

**🔹 Brute Force:**

```javascript
function printEvenNumbers(arr) {
  let result = [];

  for (let i = 0; i < arr.length; i++) {
    if (arr[i] % 2 === 0) {
      result.push(arr[i]);
    }
  }

  return result;
}

console.log(printEvenNumbers([1,2,3,4,5,6]));
```

**Complexity:** Time: `O(n)` | Space: `O(n)`

**🔹 Optimized (Using Filter):**

Cleaner functional approach.

```javascript
function printEvenNumbersOptimized(arr) {
  return arr.filter(num => num % 2 === 0);
}

console.log(printEvenNumbersOptimized([1,2,3,4,5,6]));
```

---

### 3️⃣ Reverse Each Word of a Sentence

| Input | Output |
|-------|--------|
| `"I love JavaScript"` | `"I evol tpircSavaJ"` |

**🔹 Brute Force:**

**Steps:** Split sentence → Reverse each word → Join

```javascript
function reverseEachWord(sentence) {
  let words = sentence.split(" ");
  let result = [];

  for (let word of words) {
    let reversed = word.split("").reverse().join("");
    result.push(reversed);
  }

  return result.join(" ");
}

console.log(reverseEachWord("I love JavaScript"));
```

**🔹 Optimized Approach:**

```javascript
function reverseEachWordOptimized(sentence) {
  return sentence
    .split(" ")
    .map(word => [...word].reverse().join(""))
    .join(" ");
}

console.log(reverseEachWordOptimized("I love JavaScript"));
```

**Complexity:** Time: `O(n)` | Space: `O(n)`

---

### 4️⃣ Reverse of a Number

| Input | Output |
|-------|--------|
| `12345` | `54321` |

**🔹 Brute Force (String Method):**

```javascript
function reverseNumber(num) {
  return Number(num.toString().split("").reverse().join(""));
}

console.log(reverseNumber(12345));
```

**🔹 Optimized (Pure DSA / Math Approach):**

Best interview solution.

**Logic:**

```
1234

step1:
rev = 0
digit = 4
rev = 4

step2:
digit = 3
rev = 43
```

```javascript
function reverseNumberOptimized(num) {
  let rev = 0;

  while (num > 0) {
    let digit = num % 10;
    rev = rev * 10 + digit;
    num = Math.floor(num / 10);
  }

  return rev;
}

console.log(reverseNumberOptimized(12345));
```

**Complexity:** Time: `O(log n)` | Space: `O(1)`

---

## ⭐ Interview Tip

If interviewer asks these, always say:

- **First approach** → Brute force
- **Second approach** → Optimized
- Then explain time complexity



**Debounce in js**:

function decounce(fn, delay){
  let timer;

  return function (..args) {
    clearTimeout(timer)

    timer = setTimeout(() => {
      fn.apply(this, args)
    }, delay)
  }
}