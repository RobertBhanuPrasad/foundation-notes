# Next.js & JavaScript Interview Questions

---

## 🔥 `map()` vs `for` loop (Arrays in JavaScript)

> Good question — this is a very common interview topic. Let's break it down clearly so you can explain it confidently.

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
> "map is preferred when transforming arrays because it's declarative and readable."

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

---

## 🔥 Convert Object to String in JavaScript

> Great — another very common interview + real-world question 👍
>
> There are multiple ways, but the most important one is 👇

---

### ✅ 1. Using `JSON.stringify()` (🔥 Most Important)

```javascript
const user = {
  name: "Bhanu",
  age: 25
};

const str = JSON.stringify(user);

console.log(str);
```

**👉 Output:**

```
'{"name":"Bhanu","age":25}'
```

- ✔ Converts object → JSON string
- ✔ Used in:
  - APIs
  - LocalStorage
  - Sending data to backend

---

### ✅ 2. Pretty Format (Readable String)

```javascript
const str = JSON.stringify(user, null, 2);

console.log(str);
```

**👉 Output:**

```json
{
  "name": "Bhanu",
  "age": 25
}
```

- ✔ `2` → spacing (indentation)
- ✔ Useful for debugging

---

### ✅ 3. Manual Conversion (Not Recommended)

```javascript
const str = user.name + " " + user.age;

console.log(str); // Bhanu 25
```

- ❌ Not scalable
- ❌ Loses structure

---

### ⚠️ Important Edge Cases

**❗ Functions are removed:**

```javascript
const obj = {
  name: "Bhanu",
  greet: function() {}
};

console.log(JSON.stringify(obj));
```

**👉 Output:** `{"name":"Bhanu"}`

**❗ Undefined is removed:**

```javascript
const obj = {
  name: "Bhanu",
  age: undefined
};

console.log(JSON.stringify(obj));
```

**👉 Output:** `{"name":"Bhanu"}`

**❗ Circular Objects ❌ ERROR:**

```javascript
const obj = {};
obj.self = obj;

JSON.stringify(obj); // ❌ Error
```

---

### 🔁 Reverse (String → Object)

```javascript
const str = '{"name":"Bhanu","age":25}';

const obj = JSON.parse(str);

console.log(obj);
```

✔ Very important pair:

- `JSON.stringify()` → object → string
- `JSON.parse()` → string → object

---

### 🎯 When to Use

**👉 Use `JSON.stringify()` when:**

- Storing in localStorage
- Sending API request
- Logging data

---

### 🧾 Interview Answer (Say this 👇)

> "We convert an object to a string using `JSON.stringify()`. It converts a JavaScript object into a JSON string, which is useful for data transfer and storage. To convert it back, we use `JSON.parse()`."

---

## 🔥 Convert Object → Array in JavaScript

> Nice — this is a very important JS concept (used a lot in React & APIs) 👍
>
> There are 3 main ways, depending on what you need.

---

### ✅ 1. `Object.keys()` → Array of Keys

```javascript
const user = {
  name: "Bhanu",
  age: 25,
  city: "Bangalore"
};

const keys = Object.keys(user);

console.log(keys);
```

**👉 Output:** `["name", "age", "city"]`

✔ Use when you need only keys

---

### ✅ 2. `Object.values()` → Array of Values

```javascript
const values = Object.values(user);

console.log(values);
```

**👉 Output:** `["Bhanu", 25, "Bangalore"]`

✔ Use when you need only values

---

### ✅ 3. `Object.entries()` → Array of Key-Value Pairs (🔥 Most Important)

```javascript
const entries = Object.entries(user);

console.log(entries);
```

**👉 Output:**

```javascript
[
  ["name", "Bhanu"],
  ["age", 25],
  ["city", "Bangalore"]
]
```

- ✔ Best & most flexible
- ✔ Used in React lists, loops, transformations

---

### ⚡ Bonus: Convert to Custom Array Format

**👉 Example: Object → Array of Objects:**

```javascript
const result = Object.entries(user).map(([key, value]) => {
  return { key, value };
});

console.log(result);
```

**👉 Output:**

```javascript
[
  { key: "name", value: "Bhanu" },
  { key: "age", value: 25 },
  { key: "city", value: "Bangalore" }
]
```

---

### ⚡ Real React Example (🔥 Important)

```jsx
Object.entries(user).map(([key, value]) => (
  <p key={key}>
    {key}: {value}
  </p>
));
```

---

### 🧠 Quick Summary

| Method | Output | Use Case |
|--------|--------|----------|
| `Object.keys()` | `["name","age"]` | Only keys |
| `Object.values()` | `["Bhanu",25]` | Only values |
| `Object.entries()` | `[["name","Bhanu"]]` | 🔥 Best (key + value) |

---

### 🎯 Best Practice

> **👉 In interviews say:**
> "We use `Object.entries()` to convert an object into an array because it provides both key and value and is more flexible for transformations."

---

## 🧸 Dependency Injection (ELI5)

> Alright — let's make this super simple (like you're 5 years old) and then connect it to real coding 👇

**Imagine this 👇**

You have a toy car 🚗

👉 The car needs a battery 🔋 to run

**❌ Without Dependency Injection:**

- You glue the battery inside the car permanently
- If battery dies ❌ → you can't change it
- Car is stuck 😢
- 👉 Car is dependent on that fixed battery

**✅ With Dependency Injection:**

- Now imagine:
- You can remove and insert battery easily
- If battery dies → just replace 🔄
- 👉 Someone gives (injects) the battery into the car

**💡 Simple Meaning:**

> Dependency Injection means:
> Don't create things inside — get them from outside

---

### 🧠 Now in JavaScript (Real Example)

**❌ Without Dependency Injection:**

```javascript
class Car {
  constructor() {
    this.engine = new Engine(); // ❌ tightly coupled
  }
}

class Engine {
  start() {
    console.log("Engine started");
  }
}
```

👉 Problem:
- Car always uses same Engine
- Hard to test / change

**✅ With Dependency Injection:**

```javascript
class Car {
  constructor(engine) {
    this.engine = engine; // ✅ injected from outside
  }

  startCar() {
    this.engine.start();
  }
}

class Engine {
  start() {
    console.log("Engine started");
  }
}

const engine = new Engine();
const car = new Car(engine);

car.startCar();
```

👉 Now:
- You can change engine easily
- More flexible

---

### 🔥 Real Benefit (Important)

You can swap dependencies 👇

```javascript
class ElectricEngine {
  start() {
    console.log("Electric engine started ⚡");
  }
}

const car = new Car(new ElectricEngine());
car.startCar();
```

👉 Same Car, different behavior 😎

---

### ⚡ Real-Life Example (API)

**❌ Without DI:**

```javascript
function getUser() {
  const api = new ApiService(); // tightly coupled
  return api.fetchUser();
}
```

**✅ With DI:**

```javascript
function getUser(apiService) {
  return apiService.fetchUser();
}
```

👉 You can pass:
- real API
- mock API (for testing)

---

### 🎯 Why Dependency Injection?

- ✔ Easy to test
- ✔ Easy to change code
- ✔ Loose coupling (very important term)
- ✔ Reusable components

---

### 🧾 Interview Answer (Simple & Strong)

> "Dependency Injection is a design pattern where dependencies are provided from outside instead of being created inside a class or function. It helps in reducing coupling, improving testability, and making code more flexible."

**🧸 One Line (ELI5):**

> "Instead of building your own toy battery, someone gives it to you so you can change it anytime."

---

## 🧠 Normal Function vs Arrow Function

> Great — this is a must-know JavaScript interview question 👍

---

### 🧸 ELI5 (Super Simple)

- **👉 Normal Function** — Like a regular worker, has its own identity (`this`)
- **👉 Arrow Function** — Like a helper, uses parent's identity (`this`)

---

### ✅ 1. Syntax Difference

**🔹 Normal Function:**

```javascript
function add(a, b) {
  return a + b;
}
```

**🔹 Arrow Function:**

```javascript
const add = (a, b) => a + b;
```

- ✔ Shorter
- ✔ Cleaner

---

### 🔥 2. `this` Keyword (MOST IMPORTANT 🔥)

**❌ Normal Function (`this` changes):**

```javascript
const obj = {
  name: "Bhanu",
  greet: function () {
    console.log(this.name);
  }
};

obj.greet(); // Bhanu ✅
```

👉 `this` = current object

**✅ Arrow Function (`this` is inherited):**

```javascript
const obj = {
  name: "Bhanu",
  greet: () => {
    console.log(this.name);
  }
};

obj.greet(); // undefined ❌
```

- 👉 Arrow function does NOT have its own `this`
- 👉 It takes from parent (global)

---

### 🔥 3. `arguments` Keyword

**❌ Normal Function:**

```javascript
function test() {
  console.log(arguments);
}
```

✔ Works

**❌ Arrow Function:**

```javascript
const test = () => {
  console.log(arguments); // ❌ Error
};
```

❌ No `arguments`

---

### 🔥 4. Can be used as Constructor?

**✅ Normal Function:**

```javascript
function Person(name) {
  this.name = name;
}

const p = new Person("Bhanu");
```

✔ Works

**❌ Arrow Function:**

```javascript
const Person = (name) => {
  this.name = name;
};

new Person("Bhanu"); // ❌ Error
```

❌ Cannot use `new`

---

### 🔥 5. Implicit Return

**Arrow Function Shortcut:**

```javascript
const sum = (a, b) => a + b;
```

✔ No need for `return`

**Normal Function:**

```javascript
function sum(a, b) {
  return a + b;
}
```

---

### 🔥 6. Best Use Cases

**✅ Use Arrow Function:**

- Short functions
- Array methods (`map`, `filter`)
- When you want same `this`

```javascript
arr.map(x => x * 2);
```

**✅ Use Normal Function:**

- Object methods
- Constructors
- When you need dynamic `this`

---

### 🧠 Quick Comparison

| Feature | Normal Function | Arrow Function |
|---------|----------------|----------------|
| Syntax | Longer | Short |
| `this` | Dynamic | Lexical (fixed) |
| `arguments` | Available | Not available |
| Constructor | Yes | No |
| Best for | Objects, classes | Short callbacks |

---

### 🎯 Interview Answer (Say This 👇)

> "The main difference between normal functions and arrow functions is how they handle `this`. Normal functions have their own `this` based on how they are called, while arrow functions inherit `this` from their surrounding scope. Arrow functions are shorter and commonly used in callbacks, whereas normal functions are used when dynamic context or constructors are needed."

---

## 🚀 Next.js Interview Questions

---

### 🚀 1. What is Next.js?

**👉 Simple Explanation:**

> Next.js is a React framework that provides built-in features like routing, server-side rendering, API routes, and performance optimizations.

**🧠 ELI5:**

- React = building blocks 🧱
- Next.js = ready-made house with everything included 🏠

**❓ Why Next.js?**

👉 React alone:
- No routing ❌
- No SEO ❌
- No SSR ❌

👉 Next.js gives:
- File-based routing ✅
- SSR / SSG ✅
- SEO friendly ✅
- Backend APIs ✅

> **🎯 Interview Answer:**
> "Next.js is used to build production-ready React applications with built-in features like SSR, routing, and API handling, improving performance and SEO."

---

### 🔥 2. SSG vs SSR vs CSR

**🟢 CSR (Client-Side Rendering):**

```javascript
useEffect(() => {
  fetch('/api/data').then(...)
}, []);
```

- 👉 Data loads in browser
- 👉 Initial page is empty
- ✔ Fast navigation
- ❌ Bad SEO

**🔵 SSR (Server-Side Rendering):**

```javascript
export async function getServerSideProps() {
  const data = await fetchData();
  return { props: { data } };
}
```

- 👉 Page generated on every request
- ✔ SEO friendly
- ✔ Fresh data
- ❌ Slower than SSG

**🟣 SSG (Static Site Generation):**

```javascript
export async function getStaticProps() {
  const data = await fetchData();
  return { props: { data } };
}
```

- 👉 Page generated at build time
- ✔ Very fast
- ✔ Best performance
- ❌ Not real-time

**🧠 Quick Comparison:**

| Type | When Generated | SEO | Speed |
|------|---------------|-----|-------|
| CSR | Browser | ❌ | Medium |
| SSR | Every request | ✅ | Medium |
| SSG | Build time | ✅ | 🔥 Fast |

> **🎯 Interview Line:**
> "CSR renders on the client, SSR renders on each request, and SSG pre-renders pages at build time for better performance."

---

### 🔥 3. What are Server Components?

👉 Introduced in Next.js (App Router)

**🧠 Simple Meaning:** Server Components run on the server, not in the browser.

**Example:**

```javascript
// Server Component
export default async function Page() {
  const data = await fetch("https://api.com/data");
  return <div>{data.name}</div>;
}
```

**✅ Benefits:**

- No bundle size (not sent to browser)
- Faster performance
- Direct DB/API calls

**❗ Important — Cannot use:**

- `useState`
- `useEffect`

> **🎯 Interview Answer:**
> "Server Components are rendered on the server and reduce client-side JavaScript, improving performance and enabling direct data fetching."

---

### 🔥 4. Benefits of Next.js

**✅ Key Benefits:**

- 🚀 SEO friendly (SSR/SSG)
- ⚡ Faster performance
- 📁 File-based routing
- 🔌 API routes (backend inside frontend)
- 🧠 Server + Client components
- 📦 Image optimization

---

### 🔥 5. Routing in Next.js

**🧠 File-Based Routing:**

👉 Just create files → routes automatically created

**Example (App Router):**

```
app/
 ├── page.js        → /
 ├── about/page.js  → /about
 ├── blog/[id]/page.js → /blog/1
```

**Dynamic Routing:**

```javascript
// app/blog/[id]/page.js
export default function Blog({ params }) {
  return <h1>{params.id}</h1>;
}
```

**Navigation:**

```jsx
import Link from 'next/link';

<Link href="/about">Go to About</Link>
```

> **🎯 Interview Answer:**
> "Next.js uses file-based routing where the folder structure defines routes. It also supports dynamic routing using brackets like `[id]`."

---

### 🔥 6. Authentication in Next.js

**🧠 Common Ways:**

**✅ 1. JWT Authentication:**

- Login → get token
- Store token (cookie/localStorage)
- Send with requests

**✅ 2. NextAuth.js (🔥 Most Popular):**

```javascript
import NextAuth from "next-auth";
```

✔ Supports:
- Google login
- GitHub login
- Credentials

**✅ 3. Middleware Protection:**

```javascript
// middleware.js
import { NextResponse } from 'next/server';

export function middleware(req) {
  const token = req.cookies.get("token");

  if (!token) {
    return NextResponse.redirect("/login");
  }
}
```

**✅ 4. Server-side Auth (Best):**

```javascript
export async function getServerSideProps(context) {
  const token = context.req.cookies.token;

  if (!token) {
    return {
      redirect: { destination: '/login' }
    };
  }

  return { props: {} };
}
```

> **🎯 Interview Answer:**
> "Authentication in Next.js can be implemented using JWT, NextAuth.js, or middleware. For secure apps, server-side authentication using cookies is preferred."

---

### 🧠 FINAL QUICK SUMMARY (Revision)

- **Next.js** = React framework with SSR, routing
- **CSR / SSR / SSG** = rendering strategies
- **Server Components** = run on server
- **Routing** = file-based
- **Auth** = JWT / NextAuth / Middleware

---

## 🔥 Next.js Real Interview Questions + Answers

> Perfect — this is exactly what you need to crack Next.js interviews 🔥
> I'll give you 3 parts:
>
> 1️⃣ Real Interview Questions + Answers
> 2️⃣ App Router vs Pages Router (VERY IMPORTANT)
> 3️⃣ Project-based answers (tailored for YOU)

---

### ❓ Q1: What is Next.js?

> "Next.js is a React framework that enables server-side rendering, static site generation, file-based routing, and API routes, helping build SEO-friendly and high-performance applications."

---

### ❓ Q2: Difference between SSR, SSG, CSR?

> "CSR renders data in the browser, SSR renders on every request from the server, and SSG pre-renders pages at build time for better performance and SEO."

---

### ❓ Q3: What is `getServerSideProps`?

> "It is a function used in Next.js to fetch data on every request. It runs on the server and is used when data needs to be real-time."

---

### ❓ Q4: What is `getStaticProps`?

> "It fetches data at build time and generates static pages, which improves performance."

---

### ❓ Q5: What is dynamic routing?

```javascript
pages/blog/[id].js
```

> "Dynamic routing allows creating routes based on parameters using brackets like `[id]`."

---

### ❓ Q6: What are API routes?

```javascript
// pages/api/user.js
export default function handler(req, res) {
  res.json({ name: "Bhanu" });
}
```

> "API routes allow building backend endpoints inside Next.js."

---

### ❓ Q7: What is Image Optimization?

> "Next.js provides an Image component that automatically optimizes images for performance and responsiveness."

---

### ❓ Q8: What is Middleware?

> "Middleware runs before a request is completed and is used for authentication, redirects, and logging."

---

### ❓ Q9: What are Server Components?

> "Server Components run on the server and reduce client-side JavaScript, improving performance."

---

### ❓ Q10: How does Next.js improve SEO?

> "By supporting SSR and SSG, Next.js sends fully rendered HTML to the browser, which improves search engine indexing."

---

## 🔥 App Router vs Pages Router (VERY IMPORTANT)

---

### 🧠 Overview

| Feature | Pages Router | App Router |
|---------|-------------|------------|
| Folder | `/pages` | `/app` |
| Data Fetching | `getServerSideProps` | async components |
| Layouts | Manual | Built-in layouts |
| Server Components | ❌ | ✅ |
| Routing | File-based | File-based (advanced) |

**✅ Pages Router (Old Way):**

```javascript
// pages/index.js
export default function Home() {
  return <h1>Home</h1>;
}
```

👉 Uses:
- `getServerSideProps`
- `getStaticProps`

**✅ App Router (New Way 🔥):**

```javascript
// app/page.js
export default function Home() {
  return <h1>Home</h1>;
}
```

👉 Uses:
- Server Components
- Layouts
- Streaming

---

### 🔥 Layout Feature (App Router)

```javascript
// app/layout.js
export default function RootLayout({ children }) {
  return (
    <html>
      <body>{children}</body>
    </html>
  );
}
```

✔ Shared UI across pages

> **🎯 Interview Answer:**
> "Pages Router uses traditional data fetching methods like `getServerSideProps`, whereas App Router introduces server components, layouts, and modern data fetching using async components, making it more scalable and efficient."

---

## 🔥 Project-Based Answers (VERY IMPORTANT FOR YOU)

> You said:
> 👉 You're working on enterprise platform (Pathfinder)
> 👉 Using Next.js + PostgreSQL + APIs
>
> So here's how you should answer 👇

---

### ❓ Q: How are you using Next.js in your project?

> "In my current project, I use Next.js to build scalable frontend applications with server-side rendering for better SEO and performance. We use API routes for backend communication and integrate with PostgreSQL."

---

### ❓ Q: Which rendering strategy do you use?

> "We primarily use SSR for dynamic data like dashboards and SSG for static pages like landing pages to optimize performance."

---

### ❓ Q: How do you handle routing?

> "We use file-based routing in Next.js, and for dynamic routes like user profiles or dashboards, we use dynamic segments like `[id]`."

---

### ❓ Q: How do you handle authentication?

> "We use JWT-based authentication stored in cookies and protect routes using middleware and server-side checks."

---

### ❓ Q: How do you optimize performance?

> "We use image optimization, code splitting, server components, and caching strategies to improve performance."

---

### ❓ Q: How do you fetch data?

> "In App Router, we use async server components for fetching data directly from APIs, reducing client-side load."

---

### ❓ Q: Challenges you faced?

> "One challenge was handling client vs server components correctly. We resolved it by separating logic and ensuring stateful logic runs only in client components."

---

## 🔥 BONUS: Strong Closing Answer

If interviewer asks:

> 👉 "Why Next.js over React?"

> "Next.js provides built-in features like SSR, routing, and API handling, which reduces setup time and improves performance and SEO compared to plain React."

---

## 🧠 FINAL TIP (IMPORTANT)

In interviews:

- Always say **performance + SEO + scalability**
- Mention **SSR + Server Components**
- Connect answers to your project
