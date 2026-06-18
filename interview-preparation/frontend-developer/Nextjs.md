Excellent. Now let's move to Priority 3: Next.js, which is probably the most important section for this PPLSYNC role because the JD specifically mentions:

Next.js
SSR
SEO
API Integration
Authentication
Deployment
Production Support
Performance Optimization

For a 2-hour assessment, expect 30-40% of questions from Next.js.

1. WHAT IS NEXT.JS?
What?

Next.js is a React Framework.

React alone gives:

UI Components
Hooks
State Management

Next.js adds:

Routing
SSR
SSG
API Routes
Middleware
SEO
Image Optimization
Authentication
Deployment Support
Why Next.js?

Problem with React:

React = CSR (Client Side Rendering)

Browser receives:

<div id="root"></div>

Then:

Download JS
Execute JS
Render UI

Problems:

❌ Slow First Load

❌ Poor SEO

❌ Bad Performance

Next.js solves this.

Interview Answer

Next.js is a React framework that provides routing, server-side rendering, static generation, API routes, SEO optimization, middleware, and production-ready features.

2. CSR (CLIENT SIDE RENDERING)
What?

Browser renders page.

Example React App

function Users() {

 const [users,setUsers] =
 useState([]);

 useEffect(() => {

   fetchUsers();

 },[]);

}

Flow

Browser
↓
Download JS
↓
Run JS
↓
Call API
↓
Render Page

Problem

User waits.

SEO Problem

Google initially sees:

<div id="root"></div>

Not content.

Interview Answer

In CSR, rendering happens in the browser after JavaScript loads. It provides rich interactivity but can affect SEO and initial load performance.

3. SSR (SERVER SIDE RENDERING)

⭐⭐⭐⭐⭐ Very Important

What?

Server renders page before sending.

Example

Request
↓
Server Builds HTML
↓
HTML Sent To Browser
↓
Browser Displays Immediately

Example

export async function getServerSideProps(){

 const users =
 await fetchUsers();

 return {
   props:{
     users
   }
 };

}

Browser receives:

<h1>Users</h1>
<ul>
 ...
</ul>

Already rendered.

Benefits

✅ SEO

✅ Fast First Paint

✅ Fresh Data

Drawback

Every request hits server.

Interview Answer

SSR generates HTML on the server for every request. It improves SEO and ensures fresh data but increases server load.

4. SSG (STATIC SITE GENERATION)

⭐⭐⭐⭐⭐

What?

Page generated during build time.

Example

export async function getStaticProps(){

 const products =
 await getProducts();

 return {
   props:{
     products
   }
 };

}

Generated:

npm run build

Once.

Stored as:

Static HTML

Request:

User
↓
CDN
↓
Serve HTML

Very fast.

Benefits

✅ Extremely Fast

✅ SEO

✅ CDN Cached

Best For

Blogs
Landing Pages
Documentation

Drawback

Data can become stale.

Interview Answer

SSG generates pages at build time and serves static HTML. It offers excellent performance and SEO but is best suited for content that doesn't change frequently.

5. ISR (INCREMENTAL STATIC REGENERATION)

⭐⭐⭐⭐⭐

Most interviewers ask.

Problem

SSG data becomes old.

Solution

ISR.

Example

export async function getStaticProps(){

 return {

   props:{},

   revalidate:60

 };

}

Meaning

Regenerate page
every 60 seconds

Flow

User Request
↓
Cached Page
↓
Background Regeneration
↓
Updated Page

Benefits

SSG Speed
+
Fresh Data
Interview Answer

ISR allows static pages to be regenerated after a specified interval, combining the performance benefits of SSG with fresher content.

SSR vs SSG vs ISR
Feature	SSR	SSG	ISR
Generated	Request Time	Build Time	Build + Regeneration
SEO	Yes	Yes	Yes
Speed	Medium	Fast	Fast
Fresh Data	Yes	No	Yes
6. APP ROUTER vs PAGES ROUTER

Very Common.

Old
pages/

Example

pages/index.js
pages/about.js
New
app/

Example

app/page.js
app/about/page.js

Advantages

Layouts
Server Components
Streaming
Better Data Fetching

Interview Answer

App Router is the newer routing system introduced in Next.js 13 that supports layouts, server components, streaming, and improved data fetching compared to the older Pages Router.

7. SERVER COMPONENTS

⭐⭐⭐⭐⭐

Next.js 13 favorite topic.

What?

Components rendered on server.

Example

async function Users(){

 const users =
 await fetchUsers();

 return (
   <div>
     ...
   </div>
 );
}

Benefits

Less JavaScript
Faster Page Load
Better SEO
Client Component
"use client";

function Counter(){

 const [count,setCount] =
 useState(0);

}

Need client component when using:

useState
useEffect
Browser APIs
Events
Interview Answer

Server Components render on the server and reduce client-side JavaScript. Client Components are required when using hooks, browser APIs, or user interactions.

8. DYNAMIC ROUTES

Example

/products/1
/products/2
/products/3

Create

app/products/[id]/page.js

Access

export default function Product({
 params
}){

 console.log(params.id);

}
9. MIDDLEWARE

⭐⭐⭐⭐⭐

Used for authentication.

Example

import { NextResponse }
from "next/server";

export function middleware(req){

 const token =
 req.cookies.get("token");

 if(!token){

   return NextResponse.redirect(
      new URL("/login",req.url)
   );

 }

}

Use Cases

Authentication
Authorization
Redirects
Role Validation
10. AUTHENTICATION

Interview Favorite.

Flow

Login
↓
Backend Validates
↓
JWT Generated
↓
Frontend Stores Token
↓
Protected Routes

Store JWT

HTTP Only Cookies

Preferred.

Not:

localStorage

for sensitive apps.

Interview Answer

I prefer storing JWTs in HTTP-only cookies because they are protected from JavaScript access and reduce XSS risks.

11. IMAGE OPTIMIZATION

Bad

<img src="/image.png"/>

Good

import Image from "next/image";

Benefits

Lazy Loading
Responsive Images
Compression
Performance
12. DEPLOYMENT

Very likely because JD mentions deployment.

Common Flow

Code
↓
GitHub
↓
Pull Request
↓
Code Review
↓
Merge
↓
CI/CD
↓
Build
↓
Deploy

Vercel

Most common.

Git Push
↓
Auto Deploy
Production Question
What if deployment fails?

Answer:

Check Build Logs
Check Environment Variables
Check API Endpoints
Rollback Previous Release
Top Next.js Questions Expected Monday
What is Next.js?
SSR vs CSR?
SSR vs SSG vs ISR?
App Router vs Pages Router?
Server Components vs Client Components?
What is Middleware?
How do you implement authentication?
What are Dynamic Routes?
Why use next/image?
Explain your deployment process.
One-Line Interview Answers
SSR

HTML generated on server for every request.

SSG

HTML generated at build time.

ISR

Static pages regenerated periodically after deployment.

App Router

Next.js 13 routing system with layouts and server components.

Server Component

Component rendered on server to reduce client JavaScript.

Middleware

Runs before requests to handle authentication, redirects, and authorization.

Dynamic Route

Route created using parameterized folders such as [id].

next/image

Optimizes images automatically through lazy loading, resizing, and compression.

Very few can confidently explain:

SSR vs CSR vs SSG vs ISR
Server Components
Authentication
Middleware
Production Issues
Deployment

Let's go deep.

1. SSR vs CSR vs SSG vs ISR ⭐⭐⭐⭐⭐

This is probably the #1 Next.js question.

CSR (Client Side Rendering)
What?

Browser renders page.

Example:

"use client";

export default function Users() {

 const [users,setUsers] =
 useState([]);

 useEffect(() => {

   fetch("/api/users")
    .then(res => res.json())
    .then(setUsers);

 },[]);

}
Flow
Browser Requests Page
↓
Empty HTML Returned
↓
Download JS
↓
Execute JS
↓
Call API
↓
Render UI
Problem

User waits.

SEO Problem

Google initially receives:

<div id="root"></div>

No content.

Use Cases
Dashboard
Admin Panels
Internal Tools
Attendance Systems
HRMS
SSR (Server Side Rendering)
What?

Server builds page before sending.

Example

export async function getServerSideProps() {

 const users =
 await getUsers();

 return {
   props: { users }
 };

}
Flow
Request
↓
Server Calls API
↓
Builds HTML
↓
Returns HTML
↓
Browser Displays
Benefits
SEO Friendly
Fresh Data
Fast First Paint
Drawback

Every request:

API Call
Database Call
HTML Generation

Server load increases.

Example
Stock Market
Weather
Live Pricing

Need fresh data.

SSG (Static Site Generation)
What?

Page generated during build.

Example

export async function getStaticProps() {

 const blogs =
 await getBlogs();

 return {
   props:{blogs}
 };

}

During:

npm run build

Page generated once.

Flow
Build Time
↓
Generate HTML
↓
Store on CDN
↓
Serve Instantly
Benefits
Very Fast
Very Cheap
Great SEO
Drawback

Data becomes stale.

Example
Blogs
Documentation
Marketing Pages
Company Website
ISR (Incremental Static Regeneration)

Most important.

Problem

SSG gets outdated.

Solution
export async function getStaticProps(){

 return {

   props:{},

   revalidate:60

 };

}

Meaning

Regenerate every 60 sec
Flow
Serve Cached HTML
↓
60 Sec Passed
↓
Background Regeneration
↓
New HTML Replaces Old
Example
E-commerce Products
News Pages
Job Listings
Interview Table
Feature	CSR	SSR	SSG	ISR
Render Location	Browser	Server	Build Time	Build + Regenerate
SEO	Poor	Excellent	Excellent	Excellent
Speed	Medium	Medium	Fastest	Fast
Fresh Data	Yes	Yes	No	Yes
Interview Answer
Which would you choose for an HRMS dashboard?

Answer:

CSR

Why?

SEO not important.

User logged in.

Which would you choose for a company website?

Answer:

SSG
Which would you choose for a live attendance report?

Answer:

SSR
2. use client & Server Components ⭐⭐⭐⭐⭐

Most Next.js 13 interviews ask this.

Server Component

Default in App Router.

Example

export default async function Users(){

 const users =
 await getUsers();

 return <div>{users.length}</div>;

}
Why?

Runs on server.

Benefits:

Less JS Sent
Better SEO
Faster
Client Component

Need:

"use client";

Example

"use client";

import { useState } from "react";

function Counter(){

 const [count,setCount] =
 useState(0);

}
Why?

Hooks require browser.

Rule

If using:

useState
useEffect
Event Handlers
window
localStorage

Need:

"use client";
Interview Question

Can useState be used inside Server Component?

Answer:

No
3. App Router ⭐⭐⭐⭐⭐

Old

pages/

New

app/

Example

app
 ├ page.js
 ├ about
 │   └ page.js

Route:

/

comes from:

app/page.js

Route:

/about

comes from:

app/about/page.js

Benefits

Layouts
Server Components
Streaming
Better Data Fetching
Layouts

Example

Dashboard
 ├ Sidebar
 ├ Header
 ├ Content

Instead of repeating:

<Sidebar />
<Header />

Use:

layout.js
Interview Answer

App Router is Next.js's modern routing system that supports nested layouts, server components, streaming, and improved data fetching.

4. Authentication with JWT ⭐⭐⭐⭐⭐

Most likely.

Login Flow
User Login
↓
Backend Verifies
↓
JWT Generated
↓
Frontend Receives Token
↓
Store Token
↓
Protected Requests

Example JWT

eyJhbGci...
Sending Token
Authorization:
Bearer TOKEN
Next.js Preferred

Store in:

HTTP Only Cookie

Not:

localStorage

Why?

More Secure
Protected from XSS
Example

Login

POST /login

Response

{
 "token":"JWT"
}

Store Cookie

cookies().set(...)

Protected Request

Authorization:
Bearer TOKEN
Interview Question

Where do you store JWT?

Answer:

HTTP Only Cookies
Why not localStorage?

Because:

JavaScript Can Read It

XSS risk.

5. Middleware ⭐⭐⭐⭐⭐

Most asked practical question.

What?

Code runs before request reaches page.

Example

User Opens Dashboard
↓
Middleware Executes
↓
Check Token
↓
Allow or Redirect

Example

import {
 NextResponse
}
from "next/server";

export function middleware(req){

 const token =
 req.cookies.get("token");

 if(!token){

   return NextResponse.redirect(
      new URL("/login", req.url)
   );

 }

}
Uses
Authentication
Authorization
Role Validation
Redirects

Example

Employee
↓
Access Admin Page
↓
Middleware Blocks
Interview Answer

Middleware runs before requests are completed and is commonly used for authentication, authorization, redirects, and request validation.

6. API Integration & Error Handling ⭐⭐⭐⭐⭐

Very likely coding question.

Bad

const data =
await fetch("/users");

Good

try {

 const response =
 await fetch("/users");

 if(!response.ok){

   throw new Error(
      "Failed"
   );

 }

 const data =
 await response.json();

}
catch(error){

 console.error(error);

}
Common Status Codes
200 Success
201 Created
400 Bad Request
401 Unauthorized
403 Forbidden
404 Not Found
500 Server Error
Production Answer

If API fails:

Show Error Message
Retry
Log Error
Fallback UI
7. Deployment & Production Issues ⭐⭐⭐⭐⭐

This is where experienced developers stand out.

Typical Flow
Code
↓
Git Branch
↓
Pull Request
↓
Code Review
↓
Merge
↓
CI/CD
↓
Build
↓
Deploy
Vercel Deployment
Push to GitHub
↓
Vercel Detects Push
↓
Build
↓
Deploy
Common Production Issues
Environment Variables Missing
Works Local
Fails Production

Reason:

API_URL missing
API CORS Issue
Frontend Calls API
↓
Blocked
Build Failure
Type Error
Lint Error
Hydration Error

Most asked Next.js issue.

Example:

<Date />

Server:

10:00 AM

Client:

10:01 AM

Mismatch.

Hydration Error.

Fix:

useEffect()

for client-only values.

Production Issue Answer (Strong Answer)

One production issue I handled was a hydration mismatch caused by client-side date rendering. The server and client were generating different timestamps, causing React hydration warnings. I moved the dynamic rendering logic into a client-side useEffect and resolved the issue without impacting SEO.

Top 10 Questions Likely on Monday
SSR vs CSR vs SSG vs ISR
Why use Next.js over React?
Server Components vs Client Components
What does "use client" do?
App Router vs Pages Router
JWT Authentication Flow
Middleware Usage
API Error Handling
Hydration Errors
Deployment Process & Production Issues

1. SSR vs CSR vs SSG vs ISR ⭐⭐⭐⭐⭐
Interview Question
Explain SSR vs CSR vs SSG vs ISR.
CSR (Client Side Rendering)
What?

Browser renders page.

useEffect(() => {
 fetchUsers();
}, []);

Flow:

Browser
↓
Download JS
↓
Run JS
↓
Fetch API
↓
Render UI
Example
HRMS Dashboard
Attendance Dashboard
Admin Panel
Why?

Because SEO doesn't matter.

Users already logged in.

SSR (Server Side Rendering)
What?

Server renders HTML for every request.

Flow:

Request
↓
Server Fetches Data
↓
Builds HTML
↓
Returns HTML
Example
Live Stock Market
Live Reports
Real-time Pricing
Why?

Fresh data on every request.

SSG (Static Site Generation)
What?

Page generated during build.

npm run build

Once.

Example
Blogs
Landing Pages
Documentation
Why?

Extremely fast.

ISR (Incremental Static Regeneration)
What?

Static page regenerated periodically.

export const revalidate = 60;
Example
Job Listings
News Articles
Product Pages
Why?

Need fast pages but data changes occasionally.

Best Interview Answer

CSR renders in the browser and is suitable for dashboards. SSR renders on the server for every request and is useful for frequently changing data. SSG generates pages during build time and provides the best performance for static content. ISR combines SSG with periodic regeneration to keep data fresh.

2. Why Next.js Over React? ⭐⭐⭐⭐⭐

Most common question.

React Gives
Components
Hooks
State Management
Next.js Adds
Routing
SSR
SSG
ISR
API Routes
Middleware
Image Optimization
SEO
Server Components
Example

React:

Need React Router
Need SEO Library
Need Custom SSR Setup

Next.js:

Built In
Interview Answer

React is a UI library, while Next.js is a full framework built on React. Next.js provides routing, SSR, SSG, middleware, image optimization, API routes, and SEO support out of the box, making it more suitable for production applications.

3. Server Components vs Client Components ⭐⭐⭐⭐⭐
Server Component

Default in App Router.

export default async function Users() {

 const users =
 await getUsers();

 return <div>{users.length}</div>;

}

Runs on server.

Benefits
Less JavaScript
Faster Load
Better SEO
Client Component
"use client";

Required when using:

useState
useEffect
window
localStorage
click handlers

Example

"use client";

const [count,setCount] =
useState(0);
Interview Answer

Server Components execute on the server and reduce the JavaScript sent to the client. Client Components run in the browser and are required for hooks, event handling, and browser APIs.

4. What Does "use client" Do? ⭐⭐⭐⭐⭐

Question:

const [count,setCount] =
useState(0);

Will this work?

Inside:

app/page.js

No.

Need:

"use client";

Why?

Because App Router components are Server Components by default.

Interview Answer

"use client" marks a component as a Client Component and allows the use of hooks, browser APIs, localStorage, and event handlers.

5. App Router vs Pages Router ⭐⭐⭐⭐⭐

Old

pages/

Example

pages/index.js
pages/about.js

New

app/

Example

app/page.js
app/about/page.js

Benefits

Nested Layouts
Server Components
Streaming
Better Data Fetching
Interview Answer

Pages Router was the traditional routing system. App Router is the newer architecture introduced in Next.js 13 that supports nested layouts, server components, streaming, and improved data fetching.

6. JWT Authentication Flow ⭐⭐⭐⭐⭐
Complete Flow
User Login
↓
Backend Validates Credentials
↓
JWT Created
↓
JWT Stored
↓
Protected API Calls

Example

POST /login

Response:

{
  "token":"JWT"
}

Frontend:

Store Token

Preferred:

HTTP Only Cookie

Why?

Safer than:

localStorage
Interview Answer

After successful login, the backend generates a JWT. The frontend stores it in an HTTP-only cookie and sends it with subsequent requests. Protected routes validate the token before granting access.

7. Middleware Usage ⭐⭐⭐⭐⭐
What?

Runs before request reaches page.

Example

/dashboard

Request:

Check Token
↓
Valid?
↓
Allow

Else:

Redirect Login

Example

export function middleware(req) {

 const token =
 req.cookies.get("token");

 if(!token) {

   return NextResponse.redirect(
      new URL("/login", req.url)
   );

 }

}
Interview Answer

Middleware executes before a request is completed and is commonly used for authentication, authorization, redirects, and role-based access control.

8. API Error Handling ⭐⭐⭐⭐⭐

Very practical question.

Bad

const data =
await fetch("/users");

Good

try {

 const response =
 await fetch("/users");

 if(!response.ok) {

   throw new Error(
      "Failed"
   );

 }

 const data =
 await response.json();

}
catch(error){

 console.error(error);

}
Production

Handle:

401 Unauthorized
403 Forbidden
404 Not Found
500 Server Error
Interview Answer

I always validate response.ok, handle API errors using try/catch, show user-friendly messages, and log failures for debugging.

9. Hydration Errors ⭐⭐⭐⭐⭐

Most asked Next.js production question.

What?

Server HTML differs from Client HTML.

Example

Server:

<p>
 {new Date().toLocaleTimeString()}
</p>

Server renders:

10:00:00

Client renders:

10:00:01

Mismatch.

Hydration Warning.

Fix

Move client-specific code.

"use client";

useEffect(() => {

 setTime(
   new Date()
 );

}, []);
Interview Answer

Hydration errors occur when server-rendered HTML differs from client-rendered HTML. Common causes include dates, random values, localStorage, and browser-only APIs.

10. Deployment Process & Production Issues ⭐⭐⭐⭐⭐
Deployment Flow
Feature Branch
↓
Pull Request
↓
Code Review
↓
Merge
↓
CI/CD
↓
Build
↓
Deploy
Common Production Issues
Environment Variables Missing
NEXT_PUBLIC_API_URL

Not configured.

Build Failure
Type Errors
Lint Errors
API Failure
Wrong URL
Network Issue
Hydration Errors

Very common.

CORS Issue

Frontend:

app.company.com

Backend:

api.company.com

Blocked.

Interview Answer

In production I first check deployment logs, environment variables, API responses, browser console errors, and network requests. For failed releases, I verify CI/CD pipelines and rollback if required.

The 5 Questions Most Likely To Actually Appear

If HR specifically said:

JavaScript
React.js
Next.js
AI

I would bet on these:

SSR vs CSR vs SSG vs ISR ⭐⭐⭐⭐⭐
useState vs useRef ⭐⭐⭐⭐⭐
useMemo vs useCallback ⭐⭐⭐⭐⭐
JWT Authentication Flow ⭐⭐⭐⭐⭐
Hydration Error in Next.js ⭐⭐⭐⭐⭐

And one coding question such as:

Promise.all
Debounce
Array Reduce
Flatten Array
Event Loop Output