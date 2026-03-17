# Techpearl Interview Preparation

> Great 👍 You already cleared the Aptitude round — good sign. Now the technical round will mainly check JavaScript thinking, React basics, and Node fundamentals through discussion + small coding problems.

I'll explain everything your friend mentioned in a structured interview-ready way:

For each topic I'll cover:

- What it is
- Why we use it
- How it works
- Example
- Interview tips / differences

---

## 1️⃣ JavaScript Core Topics

---

### 1. `let` vs `var` vs `const`

**What:** They are keywords used to declare variables in JavaScript.

**Why:** To store data in memory and control scope & mutability.

**How they differ:**

| Feature | `var` | `let` | `const` |
|---------|-------|-------|---------|
| Scope | Function | Block | Block |
| Reassign | Yes | Yes | No |
| Redeclare | Yes | No | No |
| Hoisting | Yes | Yes | Yes |

**Example:**

```javascript
var a = 10
let b = 20
const c = 30
```

**Reassignment:**

```javascript
let x = 10
x = 20   // allowed

const y = 10
y = 20   // error
```

**Scope Example:**

```javascript
if(true){
   var a = 10
   let b = 20
}

console.log(a) // 10
console.log(b) // error
```

Because `let` is block scoped.

> **Interview Answer (short):**
> `var` is function scoped and can be redeclared.
> `let` and `const` are block scoped.
> `const` cannot be reassigned.

---

### 2️⃣ Scope

**What:** Scope defines where a variable can be accessed.

**Types:**

1. Global Scope
2. Function Scope
3. Block Scope

**Example:**

```javascript
let a = 10  // global

function test(){
   let b = 20
   console.log(a) // accessible
}

console.log(b) // error
```

---

### 3️⃣ Hoisting

**What:** JavaScript moves variable and function declarations to the top of their scope during compilation.

**Example:**

```javascript
console.log(a)

var a = 10
```

JS interprets as:

```javascript
var a
console.log(a)
a = 10
```

**Output:** `undefined`

**`let` and `const` hoisting:**

```javascript
console.log(a)
let a = 10
```

**Error:** `Cannot access before initialization`

This period is called **Temporal Dead Zone (TDZ)**.

---

### 4️⃣ `==` vs `===`

**What:** Comparison operators.

| Operator | Meaning |
|----------|---------|
| `==` | loose equality |
| `===` | strict equality |

**Example:**

```javascript
5 == "5"    // true
5 === "5"   // false
```

**Why?** `==` converts types before comparing.

> **Interview Tip:** Always prefer `===` to avoid type coercion bugs.

---

### 5️⃣ Nullish Coalescing Operator (`??`)

**What:** Returns right side value if left side is `null` or `undefined`.

**Example:**

```javascript
let name = null

let result = name ?? "Guest"

console.log(result)
```

**Output:** `Guest`

**Difference with OR (`||`):**

```javascript
let count = 0

count || 10   // 10
count ?? 10   // 0
```

Because `||` treats `0` as false.

---

### 6️⃣ Spread Operator

**What:** Used to expand arrays or objects.

**Example (Array):**

```javascript
let arr1 = [1,2]
let arr2 = [...arr1,3,4]

console.log(arr2)
```

**Output:** `[1,2,3,4]`

**Example (Object):**

```javascript
let obj1 = {name:"Robert"}
let obj2 = {...obj1, age:25}
```

---

### 7️⃣ Rest Operator

**What:** Collects multiple elements into single array.

**Example:**

```javascript
function sum(...numbers){
   return numbers.reduce((a,b)=>a+b)
}

sum(1,2,3,4)
```

**Difference:**

| Spread | Rest |
|--------|------|
| Expands | Collects |

---

### 8️⃣ Destructuring

**What:** Extract values from arrays or objects easily.

**Array destructuring:**

```javascript
let arr = [10,20,30]

let [a,b,c] = arr

console.log(a)
```

**Output:** `10`

**Object destructuring:**

```javascript
let user = {name:"Robert", age:25}

let {name, age} = user
```

---

### 9️⃣ Normal Function vs Arrow Function

| Feature | Normal | Arrow |
|---------|--------|-------|
| `this` | dynamic | lexical |
| `arguments` | available | not |
| constructor | yes | no |

**Example — Normal:**

```javascript
function add(a,b){
 return a+b
}
```

**Example — Arrow:**

```javascript
const add = (a,b) => a+b
```

---

### 🔟 Promise

**What:** Promise represents future completion of async operation.

**States:**

1. Pending
2. Resolved
3. Rejected

**Example:**

```javascript
let promise = new Promise((resolve,reject)=>{

setTimeout(()=>{
 resolve("Success")
},2000)

})

promise.then(res=>console.log(res))
```

**Why Promises?** To avoid callback hell.

---

### 1️⃣1️⃣ Async Await

**What:** Cleaner way to handle promises.

**Example:**

```javascript
async function getData(){

let data = await fetch("api")

console.log(data)

}
```

**Difference:**

| Promise | Async/Await |
|---------|-------------|
| `.then()` | `await` |
| chaining | synchronous style |

---

### 1️⃣2️⃣ Closure

**What:** A closure is function remembering variables from outer scope.

**Example:**

```javascript
function outer(){

let count = 0

return function(){
 count++
 console.log(count)
}

}

let counter = outer()

counter()
counter()
```

**Output:**

```
1
2
```

---

### 1️⃣3️⃣ Lexical Scope

**What:** Scope is determined by where functions are written.

**Example:**

```javascript
function outer(){
 let a = 10

 function inner(){
  console.log(a)
 }

 inner()
}

outer()
```

Inner can access outer variables.

---

### 1️⃣4️⃣ Event Loop

JavaScript is single threaded but handles async using:

1. Call Stack
2. Web APIs
3. Callback Queue
4. Event Loop

**Example:**

```javascript
console.log("start")

setTimeout(()=>{
console.log("timer")
},0)

console.log("end")
```

**Output:**

```
start
end
timer
```

Because event loop waits until stack empty.

---

### 1️⃣5️⃣ Object Equality

```javascript
let a = {name:"robert"}
let b = {name:"robert"}

console.log(a == b)
```

**Output:** `false`

Because objects compare memory reference.

---

### 1️⃣6️⃣ JSON

**What:** JSON = JavaScript Object Notation

Used for data exchange between client & server.

**Example:**

```json
{
"name":"Robert",
"age":25
}
```

**JS conversion:**

```javascript
JSON.stringify(obj)
JSON.parse(json)
```

---

### 1️⃣7️⃣ Callback Hell

**What:** Nested callbacks making code unreadable.

**Example:**

```javascript
login(()=>{
 getUser(()=>{
   getOrders(()=>{
     getPayment()
   })
 })
})
```

**Solution:**

- ✅ Promises
- ✅ Async/Await

---

### 1️⃣8️⃣ Array Methods (Very Important)

**`map()`** — Transforms array

```javascript
let arr = [1,2,3]

let result = arr.map(x=>x*2)
```

**Output:** `[2,4,6]`

**`filter()`** — Filters elements

```javascript
arr.filter(x=>x>2)
```

**`reduce()`** — Aggregates values

```javascript
arr.reduce((sum,val)=>sum+val)
```

**`find()`** — Returns first match

**`some()`** — Checks if any element satisfies condition

**`every()`** — Checks if all elements satisfy condition

---

## 2️⃣ Object Methods

**Check key exists:**

```javascript
"name" in obj
```

or

```javascript
obj.hasOwnProperty("name")
```

**Check value exists:**

```javascript
Object.values(obj).includes("robert")
```

**Loop objects:**

```javascript
Object.keys(obj)
Object.values(obj)
Object.entries(obj)
```

---

## 3️⃣ String Methods

**Important ones:**

| Method | Example |
|--------|---------|
| `includes` | `str.includes("abc")` |
| `split` | `str.split(" ")` |
| `replace` | `str.replace()` |
| `toUpperCase` | `str.toUpperCase()` |
| `substring` | `str.substring()` |

**Example:**

```javascript
let str = "hello world"

str.includes("hello")
```

---

## 4️⃣ React Topics

---

### What is React

React is a JavaScript library for building UI.

Developed by Facebook.

### Why React

**Problems before React:**

- ❌ DOM manipulation
- ❌ slow UI updates
- ❌ complex state

**React solves using:**

- ✅ Virtual DOM
- ✅ Component architecture
- ✅ Efficient updates

---

### SPA (Single Page Application)

App loads single HTML page.

Content updates without reloading page.

**Example:** Gmail, Facebook

---

### JSX

JSX = JavaScript XML

```jsx
const element = <h1>Hello</h1>
```

Converted to `React.createElement()`

---

### Props

Props = data passed from parent to child

**Example:**

```jsx
function Child(props){
 return <h1>{props.name}</h1>
}
```

---

### State

State = component internal data

**Example:**

```javascript
const [count,setCount] = useState(0)
```

**State vs Props:**

| Props | State |
|-------|-------|
| read-only | mutable |
| parent sends | component manages |

---

### Conditional Rendering

```jsx
{isLoggedIn ? <Home/> : <Login/>}
```

---

### Controlled Components

React controls input.

```jsx
<input value={name} onChange={(e)=>setName(e.target.value)} />
```

**Uncontrolled:**

```jsx
<input ref={inputRef}/>
```

---

### Hooks

Hooks allow state & lifecycle in functional components.

**Examples:**

- `useState`
- `useEffect`
- `useRef`
- `useMemo`
- `useCallback`

---

### useEffect

Handles side effects.

**Example:**

```javascript
useEffect(()=>{
 fetchData()
},[])
```

---

### Custom Hook

Reusable hook.

```javascript
function useCounter(){

const [count,setCount] = useState(0)

return {count,setCount}

}
```

---

### Lazy Loading

Load components only when needed.

```javascript
const Page = React.lazy(()=>import("./Page"))
```

---

### Suspense

Fallback while loading.

```jsx
<Suspense fallback={<Loading/>}>
 <Page/>
</Suspense>
```

---

### React Performance

**Use:** React Developer Tools → Profiler

**Check:**

- render time
- component re-renders

---

### Vanilla JS vs React

| Vanilla | React |
|---------|-------|
| manual DOM | virtual DOM |
| complex | component based |

---

## 5️⃣ Node.js

---

### What is Node

Node.js is JavaScript runtime for backend.

Runs JS outside browser.

---

### HTTPS

Secure version of HTTP.

**Uses:** SSL / TLS encryption

**Flow:** Client → handshake → encrypted communication

---

### Connection Pooling

Database maintains pool of connections.

**Why?** Opening DB connection every request is slow.

**Example:**

- 10 connections kept ready
- API uses them

---

### PUT vs PATCH

| PUT | PATCH |
|-----|-------|
| full update | partial update |

**Example:**

- **PUT** — update whole user
- **PATCH** — update only email

---

### Middleware

Middleware runs before request reaches controller.

**Example:**

```javascript
app.use((req,res,next)=>{
 console.log("middleware")
 next()
})
```

**Use cases:**

- auth
- logging
- validation

---

## 6️⃣ React Coding Questions (Very Likely)

---

### Input Access

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

### Increment / Decrement

```jsx
const [count,setCount] = useState(0)

<button onClick={()=>setCount(count+1)}>+</button>
<button onClick={()=>setCount(count-1)}>-</button>
<button onClick={()=>setCount(0)}>Reset</button>
```

---

## 🔥 Important DSA they may ask

Very common ones:

1. Reverse string
2. Remove duplicates
3. Palindrome
4. Largest number in array
5. Count characters
6. Fibonacci

**Example — Reverse string:**

```javascript
function reverse(str){
 return str.split("").reverse().join("")
}
```

---

## ⭐ My Suggestion For You

Based on Techpearl interview style, they will likely ask:

**JS coding:**
- filter numbers divisible by 3
- reverse string
- remove duplicates

**React coding:**
- counter app
- input print UI
- todo list

**Concept questions:**
- event loop
- closure
- promises
- useEffect
- state vs props


> Perfect — this is exactly what interviewers expect 🔥
> I’ll give you real interview-style answers (the way you should speak) + deep understanding + examples.

---

## 🧠 JAVASCRIPT QUESTIONS

---

### 1️⃣ Difference between `let`, `var`, `const`

**✅ Interview Answer (Say like this):**

> In JavaScript, `var`, `let`, and `const` are used to declare variables.
> `var` is function-scoped and can be redeclared.
> `let` and `const` are block-scoped.
> `const` cannot be reassigned after initialization.

**🔍 What:** Ways to declare variables.

**❓ Why:** To control:

- Scope
- Reassignment
- Memory safety

**⚙️ How — Example:**

```javascript
var a = 10
let b = 20
const c = 30
```

**Scope Example:**

```javascript
if(true){
  var x = 10
  let y = 20
}

console.log(x) // ✅ 10
console.log(y) // ❌ error
```

**🚨 Key Differences:**

| Feature | `var` | `let` | `const` |
|---------|-------|-------|---------|
| Scope | function | block | block |
| Redeclare | ✅ | ❌ | ❌ |
| Reassign | ✅ | ✅ | ❌ |

---

### 2️⃣ What is Closure

**✅ Interview Answer:**

> A closure is a function that remembers variables from its outer scope even after the outer function has finished execution.

**🔍 What:** Function + its lexical environment.

**❓ Why:** Used for:

- Data privacy
- Maintaining state

**⚙️ How:**

```javascript
function outer(){
  let count = 0

  return function inner(){
    count++
    return count
  }
}

const counter = outer()

console.log(counter()) // 1
console.log(counter()) // 2
```

> **🔥 Key Insight:** Even after `outer()` is finished, `inner()` still remembers `count`.

---

### 3️⃣ Explain Event Loop

**✅ Interview Answer:**

> JavaScript is single-threaded but handles async operations using the event loop, call stack, callback queue, and Web APIs.

**🔍 What:** Mechanism that handles async tasks.

**❓ Why:** JS cannot block execution → needs async handling.

**⚙️ How (Step-by-step):**

```javascript
console.log("start")

setTimeout(()=>{
  console.log("timer")
},0)

console.log("end")
```

**Execution Flow:**

1. `start` → call stack
2. `setTimeout` → Web API
3. `end` → call stack
4. Timer → callback queue
5. Event loop → moves to stack

**Output:**

```
start
end
timer
```

---

### 4️⃣ Promise vs Async/Await

**✅ Interview Answer:**

> Promises handle async operations using `.then()`, while async/await is a cleaner syntax built on top of promises that makes code look synchronous.

**🔍 What:** Both handle async operations.

**❓ Why:** Avoid callback hell.

**⚙️ How — Promise:**

```javascript
fetchData()
  .then(res => console.log(res))
```

**Async/Await:**

```javascript
async function getData(){
  let res = await fetchData()
  console.log(res)
}
```

**🔥 Difference:**

| Promise | Async/Await |
|---------|-------------|
| chaining | synchronous style |
| harder to read | easier |

---

### 5️⃣ `map` vs `filter` vs `reduce`

**✅ Interview Answer:**

> `map` transforms data, `filter` selects data, and `reduce` aggregates data into a single value.

**⚙️ Examples:**

**`map`:**

```javascript
[1,2,3].map(x => x * 2)
// [2,4,6]
```

**`filter`:**

```javascript
[1,2,3,4].filter(x => x % 2 === 0)
// [2,4]
```

**`reduce`:**

```javascript
[1,2,3].reduce((a,b)=>a+b,0)
// 6
```

---

## 🔥 CODING QUESTIONS

---

### 1️⃣ Reverse String

**Brute:**

```javascript
function reverse(str){
  let res = ""
  for(let i=str.length-1;i>=0;i--){
    res += str[i]
  }
  return res
}
```

**Built-in:**

```javascript
str.split("").reverse().join("")
```

---

### 2️⃣ Remove Duplicates

**Brute:**

```javascript
function removeDup(arr){
  let res = []
  for(let i=0;i<arr.length;i++){
    if(!res.includes(arr[i])){
      res.push(arr[i])
    }
  }
  return res
}
```

**Built-in:**

```javascript
[...new Set(arr)]
```

---

### 3️⃣ Count Characters

**Brute:**

```javascript
function count(str){
  let obj = {}

  for(let char of str){
    obj[char] = (obj[char] || 0) + 1
  }

  return obj
}
```

**Built-in:**

```javascript
str.split("").reduce((acc,c)=>{
  acc[c] = (acc[c] || 0) + 1
  return acc
},{})
```

---

### 4️⃣ Palindrome

```javascript
str === str.split("").reverse().join("")
```

---

### 5️⃣ Even Numbers

```javascript
arr.filter(x => x % 2 === 0)
```

---

## ⚛️ REACT QUESTIONS

---

### 1️⃣ What is `useEffect`?

**✅ Interview Answer:**

> `useEffect` is a React hook used to perform side effects like API calls, subscriptions, or DOM updates.

**⚙️ Example:**

```javascript
useEffect(()=>{
  console.log("Component mounted")
},[])
```

**Why?**

- API calls
- timers
- subscriptions

---

### 2️⃣ State vs Props

**✅ Answer:**

> Props are read-only data passed from parent to child, while state is internal data managed within a component.

| Props | State |
|-------|-------|
| read-only | mutable |
| external | internal |

---

### 3️⃣ Controlled vs Uncontrolled

**Controlled:**

```jsx
<input value={name} onChange={(e)=>setName(e.target.value)} />
```

**Uncontrolled:**

```jsx
<input ref={inputRef} />
```

**Answer:**

> Controlled components are handled by React state, while uncontrolled use DOM directly.

---

### 4️⃣ Virtual DOM

**✅ Answer:**

> Virtual DOM is a lightweight copy of the real DOM used by React to optimize updates.

**How:**

1. React creates virtual DOM
2. Compare with previous (diffing)
3. Update only changed parts

---

### 5️⃣ Why React?

**✅ Answer:**

> React is used because it provides component-based architecture, virtual DOM for performance, and better state management.

---

## 🟢 NODE QUESTIONS

---

### 1️⃣ What is Middleware?

**✅ Answer:**

> Middleware is a function that runs between request and response cycle in Node.js.

**Example:**

```javascript
app.use((req,res,next)=>{
  console.log("middleware")
  next()
})
```

---

### 2️⃣ PUT vs PATCH

**✅ Answer:**

> PUT updates entire resource, PATCH updates partial resource.

**Example:**

- **PUT** → `{name:"Robert", age:25}`
- **PATCH** → `{age:26}`

---

### 3️⃣ How API Works?

**✅ Answer:**

> Client sends request → server processes → sends response.

**Flow:**

1. Client request
2. Route
3. Controller
4. DB
5. Response

---

### 4️⃣ What is HTTPS?

**✅ Answer:**

> HTTPS is a secure version of HTTP that encrypts data using SSL/TLS.

**Why:**

- secure data
- prevent hacking