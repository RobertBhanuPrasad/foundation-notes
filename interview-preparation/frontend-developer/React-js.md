REACT.JS - COMPLETE INTERVIEW PREPARATION

Before Hooks, understand:

What is React?
Problem Before React

Imagine a normal HTML page.

<div id="counter">0</div>

<button onclick="increment()">
 Increment
</button>
function increment() {
  document.getElementById("counter").innerText++;
}

For small applications:

✅ Works

For large applications:

❌ Difficult to manage

❌ Lots of DOM manipulation

❌ Hard to maintain

Why React?

React introduced:

UI = f(State)

Meaning:

Change State
     ↓
React Updates UI

Developer doesn't manually update DOM.

React does it.

Virtual DOM

Most asked question.

What is DOM?

When browser loads:

<div>
  <h1>Hello</h1>
</div>

Browser creates:

Document
 |
 div
 |
 h1

Called DOM Tree.

Problem

Changing DOM is expensive.

document.getElementById()
appendChild()
removeChild()

Browser has to:

Recalculate Layout
Repaint
Re-render

Slow.

React Solution

Virtual DOM.

React creates:

Real DOM

AND

Virtual DOM

in memory.

When state changes:

Old Virtual DOM
       ↓
Compare
       ↓
New Virtual DOM
       ↓
Update only changed nodes

Called:

Diffing Algorithm
Interview Question

What is Virtual DOM?

Answer:

Virtual DOM is a lightweight JavaScript representation of the real DOM that React uses to efficiently update only the changed parts of the UI.

Components

React applications are made of components.

Example

function Header() {
  return <h1>Welcome</h1>;
}

Usage

function App() {
  return <Header />;
}

Think:

Website
 |
 Header
 |
 Sidebar
 |
 Dashboard
 |
 Footer

Reusable building blocks.

Functional Components vs Class Components

Class

class App extends React.Component {
 render() {
   return <h1>Hello</h1>;
 }
}

Functional

function App() {
 return <h1>Hello</h1>;
}

Today:

Use Functional Components

Almost everywhere.

JSX

What is JSX?

const element =
<h1>Hello</h1>;

Looks like HTML.

Actually:

React.createElement()

behind the scenes.

Interview Question

Can browser understand JSX?

Answer:

❌ No

Babel converts JSX to JavaScript.

Props

Most basic React concept.

Props = Parent → Child Data

Parent

<User
 name="Robert"
/>

Child

function User(props){
 return <h1>{props.name}</h1>;
}

Output

Robert
Why Props?

Reusable components.

Example

<User name="Robert" />
<User name="John" />
<User name="David" />

Same component.

Different data.

State

Most important topic.

Question:

Difference between Props and State?

Props	State
Read Only	Mutable
Parent Controls	Component Controls
External Data	Internal Data

Example

const [count,setCount] =
useState(0);

count

Current State

setCount

Updates State

Example

function Counter(){

 const [count,setCount] =
 useState(0);

 return (
  <button
   onClick={() =>
     setCount(count+1)
   }
  >
   {count}
  </button>
 );

}
Why State Update Causes Re-render?

Interview favorite.

Example

setCount(10);

React sees:

State Changed
      ↓
Component Re-render
      ↓
UI Updated
React Render Cycle
State Change
      ↓
Render Phase
      ↓
Virtual DOM
      ↓
Diffing
      ↓
Commit Phase
      ↓
Update Real DOM

Very important.

useState Deep Dive

Question:

Why shouldn't we do:

count++;

?

Because React doesn't know state changed.

Correct:

setCount(count+1);
Tricky Interview Question

Output?

const [count,setCount] =
useState(0);

setCount(count+1);
setCount(count+1);

Expected?

2

Actual?

1

Why?

React batches updates.

Correct

setCount(prev => prev + 1);
setCount(prev => prev + 1);

Output

2
useEffect

Most asked React Hook.

What is useEffect?

Used for:

API Calls
Subscriptions
Timers
Side Effects

Example

useEffect(() => {
 console.log("Mounted");
}, []);

Runs once.

Why?

Empty dependency array.

Component Lifecycle

Old React:

componentDidMount
componentDidUpdate
componentWillUnmount

React Hooks:

useEffect()

does all.

Mount
useEffect(() => {
 console.log("Mounted");
}, []);

Runs once.

Update
useEffect(() => {
 console.log("Updated");
}, [count]);

Runs whenever count changes.

Unmount
useEffect(() => {

 return () => {
   console.log("Cleanup");
 }

}, []);

Runs when component is removed.

Real Example

API Call

useEffect(() => {

 fetchUsers();

}, []);
useRef

Since you've previously worked with router redirects, this one is important.

What is useRef?

Stores value without re-rendering.

Example

const countRef =
useRef(0);

Update

countRef.current++;

No re-render.

useState vs useRef
useState	useRef
Re-renders	No Re-render
UI Data	Mutable Storage
Triggers UI Update	Doesn't

Example

const inputRef =
useRef();

Access DOM

inputRef.current.focus();
useMemo

Performance Optimization.

Problem

const value =
heavyCalculation();

Runs every render.

Solution

const value =
useMemo(() => {

 return heavyCalculation();

}, [data]);

Meaning

Only recalculate when data changes
useCallback

Most people confuse with useMemo.

useMemo

Memoizes Value

useCallback

Memoizes Function

Example

const handleClick =
useCallback(() => {

 console.log("Clicked");

}, []);
React.memo

Problem

Parent renders.

Child unnecessarily renders.

Solution

export default React.memo(User);

Meaning

Re-render only when props change
Custom Hooks

Interview favorite.

Example

function useCounter(){

 const [count,setCount] =
 useState(0);

 const increment =
 () => setCount(c => c+1);

 return {
   count,
   increment
 };

}

Usage

const {
 count,
 increment
}
=
useCounter();
Controlled Components

Example

const [name,setName] =
useState("");
<input
 value={name}
 onChange={(e)=>
   setName(e.target.value)
 }
/>

React controls input.

Uncontrolled Components
const ref =
useRef();
<input ref={ref}/>

DOM controls input.

Top React Interview Questions
Difference between Props and State?
Why Virtual DOM?
What causes re-render?
useState vs useRef?
useMemo vs useCallback?
What is React.memo?
Controlled vs Uncontrolled Components?
What is reconciliation?
What is diffing algorithm?
Why keys are important?
Keys (Very Important)

Wrong

users.map(user =>
 <User />
)

Correct

users.map(user =>
 <User key={user.id}/>
)

Why?

React identifies changed items efficiently.

PPLSYNC Expected React Questions

If I were taking your interview, I'd ask:

Explain React rendering lifecycle.
Why Virtual DOM?
useState vs useRef.
useMemo vs useCallback.
What causes re-render?
Explain a production issue you fixed.
How do you optimize a large table with 10,000 rows?
How do you prevent unnecessary re-renders?
Explain controlled forms.
Explain React component architecture in your current project.


1. Explain React Rendering Lifecycle
What is Rendering?

Rendering means:

React executes component
↓
Creates Virtual DOM
↓
Updates UI

Example:

function Counter() {
  const [count, setCount] = useState(0);

  return <h1>{count}</h1>;
}

Initially:

Counter()
↓
Virtual DOM
↓
Real DOM
What Happens When State Changes?
setCount(1);

React:

State Changed
↓
Component Re-renders
↓
New Virtual DOM Created
↓
Compare with Old Virtual DOM
↓
Update Only Changed Nodes
React Lifecycle
Mounting

Component appears first time.

useEffect(() => {
 console.log("Mounted");
}, []);

Runs once.

Updating

State or Props change.

setCount(10);

React re-renders.

Unmounting

Component removed.

useEffect(() => {

 return () => {
   console.log("Cleanup");
 }

}, []);
Interview Answer

React rendering lifecycle consists of Mounting, Updating, and Unmounting. When state or props change, React creates a new Virtual DOM, compares it with the previous one using the reconciliation process, and updates only the changed parts of the real DOM.

2. Why Virtual DOM?
Problem

Suppose page has:

1000 rows

User changes:

1 row

Without Virtual DOM:

Browser checks entire DOM

Expensive.

React Solution

React keeps:

Real DOM

AND

Virtual DOM

in memory.

Example

Before:

<h1>0</h1>

After:

<h1>1</h1>

React compares:

Old VDOM
New VDOM

Only updates:

<h1>

Not whole page.

Why Important?

Benefits:

Faster UI updates
Less DOM manipulation
Better performance
Interview Answer

Virtual DOM is a lightweight copy of the real DOM. React uses it to compare previous and current UI states and update only the changed elements, improving performance.

3. useState vs useRef

Most asked React question.

useState

Used when UI should update.

const [count, setCount] = useState(0);

Update:

setCount(1);

Result:

Re-render
UI Update
useRef

Used when UI should NOT update.

const countRef = useRef(0);

Update:

countRef.current++;

Result:

No Re-render
Example
useState
const [count,setCount] =
useState(0);
setCount(count+1);

Screen updates.

useRef
const countRef =
useRef(0);
countRef.current++;

Screen does not update.

Real Example

Input focus:

const inputRef = useRef();
inputRef.current.focus();
Interview Answer

useState stores data that affects the UI and triggers re-renders when updated. useRef stores mutable values or DOM references and does not trigger re-renders.

4. useMemo vs useCallback

Most confusing React question.

useMemo

Memoizes VALUE.

Example

const total =
useMemo(() => {

 return expensiveCalculation();

}, [data]);

Meaning:

Don't recalculate
unless data changes
useCallback

Memoizes FUNCTION.

Example

const handleClick =
useCallback(() => {

 console.log("Clicked");

}, []);

Meaning:

Don't recreate function
unless dependency changes
Easy Memory Trick
useMemo
Stores Result
useCallback
Stores Function
Interview Answer

useMemo caches computed values to avoid expensive recalculations, while useCallback caches function references to prevent unnecessary function recreation and child re-renders.

5. What Causes Re-render?

Very important.

React re-renders when:

State changes
setCount(10);
Props change
<User name="Robert" />

to

<User name="John" />
Parent re-renders

Parent renders.

Child also renders.

Context value changes
ThemeContext

changes.

Does useRef cause re-render?
ref.current++;

No.

Interview Answer

React re-renders when state changes, props change, parent components re-render, or context values change. Updating a ref does not cause a re-render.

6. Explain a Production Issue You Fixed

This question checks experience.

Use STAR format.

Example Answer

In one project, users reported that attendance data was loading very slowly. After investigation, I found that the component was making the same API request multiple times because of an incorrect useEffect dependency.

I fixed the dependency array, introduced memoization where necessary, and reduced unnecessary API calls.

As a result, page load time improved significantly and backend API traffic was reduced.

This sounds like real product experience.

7. How Do You Optimize a Large Table with 10,000 Rows?

Very likely SaaS question.

Bad Approach
10,000 rows rendered

Browser becomes slow.

Solutions
Pagination
Show 50 rows

instead of 10,000.

Virtualization

Libraries:

react-window
react-virtualized

Render only visible rows.

Memoization
React.memo
useMemo
Debounced Search
Avoid API call on every keystroke
Interview Answer

For large datasets, I use pagination or virtualization libraries such as react-window. I also optimize rendering using React.memo, useMemo, and debounced search to reduce unnecessary rendering and API calls.

8. How Do You Prevent Unnecessary Re-renders?
React.memo
export default React.memo(User);
useMemo
const data =
useMemo(() => process(users),
[users]);
useCallback
const handleClick =
useCallback(() => {}, []);
Split Components

Bad:

Dashboard

contains everything.

Better:

Dashboard
 ├ Header
 ├ Sidebar
 ├ Table
 ├ Footer

Only affected component re-renders.

Interview Answer

I prevent unnecessary re-renders using React.memo, useMemo, useCallback, component splitting, stable props, and avoiding unnecessary state updates.

9. Explain Controlled Forms

Most asked form question.

Controlled Component

React controls form state.

const [name,setName] =
useState("");
<input
 value={name}
 onChange={(e)=>
  setName(e.target.value)
 }
/>

Flow:

Input
↓
React State
↓
UI

Benefits:

Validation
Error Handling
Dynamic Forms
Uncontrolled Component

DOM controls value.

const inputRef =
useRef();
<input ref={inputRef} />

Read later:

inputRef.current.value
Interview Answer

In controlled components, React manages form values through state. In uncontrolled components, the DOM manages values and we access them using refs.

10. Explain React Component Architecture in Your Current Project

This is almost guaranteed.

Answer like this:

In my current project, we follow a component-based architecture. We separate reusable UI components such as buttons, modals, tables, and form elements into a common components layer.

Feature-specific components are organized by modules. API communication is handled through service layers, and state is managed using React hooks and Context API/Redux where required.

We follow separation of concerns by keeping UI, business logic, and API logic independent. This improves maintainability, scalability, and code reuse across the application.

1. useState vs useRef ⭐⭐⭐⭐⭐
What is useState?

State is data that React tracks.

const [count, setCount] = useState(0);

When state changes:

setCount(1);

React:

State Changed
↓
Component Re-renders
↓
UI Updates
Example
function Counter() {
  const [count, setCount] = useState(0);

  return (
    <button
      onClick={() => setCount(count + 1)}
    >
      {count}
    </button>
  );
}

Click:

0
↓
1
↓
2
↓
3

Because React re-renders.

What is useRef?

Ref stores mutable value.

const countRef = useRef(0);

Update:

countRef.current++;

React:

Value Changed
↓
NO Re-render
Example
function Demo() {
  const countRef = useRef(0);

  const increment = () => {
    countRef.current++;
    console.log(countRef.current);
  };

  return (
    <button onClick={increment}>
      Increment
    </button>
  );
}

UI never updates.

Console updates.

Real Production Example
Prevent Multiple API Calls
const hasFetched = useRef(false);

useEffect(() => {

  if(hasFetched.current)
     return;

  hasFetched.current = true;

  fetchData();

}, []);
Interview Question
Why useRef instead of useState?

Because:

Need value
BUT
Don't need re-render

Examples:

✅ Timer IDs

✅ Previous Values

✅ DOM References

✅ API Flags

Interview Answer

useState is used for data that affects the UI and triggers re-renders. useRef stores mutable values or DOM references without causing re-renders.

Tricky Question

Output?

const ref = useRef(0);

ref.current++;

console.log(ref.current);

Output:

1

Will component re-render?

NO
2. useMemo vs useCallback ⭐⭐⭐⭐⭐

Most candidates fail this.

Why useMemo?

Imagine:

const result =
expensiveCalculation();

Every render:

Recalculate
Recalculate
Recalculate

Bad.

Solution
const result =
useMemo(() => {

 return expensiveCalculation();

}, [data]);

Meaning

Run only when data changes
Example
const total =
useMemo(() => {

 return products.reduce(
   (sum,p) => sum + p.price,
   0
 );

}, [products]);

Without useMemo:

Every render calculates.

Why useCallback?

Functions recreated every render.

Example:

const handleClick = () => {
 console.log("Clicked");
};

Every render:

New Function
New Function
New Function
Solution
const handleClick =
useCallback(() => {

 console.log("Clicked");

}, []);

React reuses same function.

Biggest Difference
useMemo

Stores:

Value
useCallback

Stores:

Function
Memory Trick
Memo = Value

Callback = Function
Real Example
const filteredUsers =
useMemo(() => {

 return users.filter(
  user => user.active
 );

}, [users]);
const onDelete =
useCallback((id) => {

 deleteUser(id);

}, []);
Interview Answer

useMemo memoizes computed values, while useCallback memoizes function references. Both are used for performance optimization.

Tricky Question

Is this useful?

const num =
useMemo(() => 5, []);

Answer:

No

Because calculation isn't expensive.

3. Virtual DOM & Reconciliation ⭐⭐⭐⭐⭐

Most favorite React question.

What is DOM?

Browser creates:

<div>
  <h1>Hello</h1>
</div>

DOM Tree:

div
 |
 h1
Problem

Updating DOM is expensive.

Example:

document.getElementById()
appendChild()
removeChild()

Browser must:

Layout
Paint
Render

Again.

React Solution

Virtual DOM.

React keeps:

Real DOM

AND

Virtual DOM
Example

Before:

<h1>0</h1>

After:

<h1>1</h1>

React creates:

Old Virtual DOM

and

New Virtual DOM

Compares them.

Only updates:

<h1>

Not whole page.

Reconciliation

Process of comparing:

Old Virtual DOM
New Virtual DOM

Called:

Reconciliation
Diffing Algorithm

React asks:

What changed?

Only updates changed nodes.

Why Keys Important?

Bad

users.map(user =>
 <User />
)

React confused.

Good

users.map(user =>
 <User key={user.id}/>
)

React identifies item quickly.

Interview Answer

Reconciliation is React's process of comparing the old and new Virtual DOM trees using the diffing algorithm. React then updates only the changed parts of the real DOM, improving performance.

4. What Causes Re-renders? ⭐⭐⭐⭐⭐

Very important.

State Changes
setCount(10);

Causes re-render.

Props Change

Parent:

<User name="Robert" />

Later:

<User name="John" />

Child re-renders.

Parent Re-renders
<Dashboard>
  <User />
</Dashboard>

Dashboard re-renders.

User re-renders too.

Context Change
ThemeContext

changes.

Consumers re-render.

What DOESN'T Cause Re-render?
useRef
ref.current++;

No re-render.

Local Variable
let count = 0;

count++;

No re-render.

Interview Answer

React re-renders when:

✅ State changes

✅ Props change

✅ Parent re-renders

✅ Context changes

It does not re-render when refs or normal variables change.

5. Large Table Optimization (10,000 Rows) ⭐⭐⭐⭐⭐

Very likely SaaS question.

Imagine HRMS.

Employee Table
10,000 Employees

Bad:

employees.map(...)

Render all rows.

Problems

Slow UI
Memory Usage
Lag
Solution 1 - Pagination

Show:

50 Rows

instead of

10,000 Rows
Solution 2 - Virtualization

Most important answer.

Libraries:

react-window
react-virtualized

Render:

Only Visible Rows

Example:

Rows 1-20 visible

Only 20 rows rendered

Not 10,000.

Solution 3 - React.memo
export default React.memo(Row);

Avoid row re-renders.

Solution 4 - useMemo
const filteredData =
useMemo(() => {

 return processRows();

}, [rows]);

Avoid recalculation.

Solution 5 - Debounce Search

Without debounce:

R
Ro
Rob
Robe
Robert

5 API Calls.

With debounce:

Robert

1 API Call.

Interview Answer (Best Answer)

For large tables, I use server-side pagination or virtualization using libraries such as react-window. I avoid rendering all rows at once, memoize expensive calculations using useMemo, prevent unnecessary row re-renders using React.memo, and debounce search/filter operations to reduce API calls and improve performance.

One-Line Answers for Monday
useState vs useRef

useState triggers re-renders; useRef stores mutable values without re-rendering.

useMemo vs useCallback

useMemo caches values; useCallback caches functions.

Virtual DOM

A lightweight copy of the real DOM used by React for efficient updates.

Reconciliation

React's process of comparing old and new Virtual DOM trees.

What causes re-render?

State changes, props changes, parent re-renders, and context updates.

10k Rows Optimization

Virtualization, pagination, React.memo, useMemo, and debounced filtering.