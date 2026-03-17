# Node.js & Database Interview Preparation

> Perfect Robert 👍 — this is very important clarity.
> You are using:
>
> - **NestJS** (backend framework)
> - **PostgreSQL** (database)
>
> So I will prepare you exactly how to answer in interview, even if you didn't write raw Node.js.
>
> We'll do this step by step, in a way you can speak confidently.

---

## 🔥 PART 1 — NODE.JS (WITH NESTJS CONTEXT)

> Even if you use NestJS, interviewers will still ask:
>
> - What is Node.js?
> - How backend works?
> - How APIs are created?

---

### 1️⃣ What is Node.js (IMPORTANT)

**What:** Node.js is a runtime environment that allows JavaScript to run on the server.

**Why:**

- Handle backend logic
- Create APIs
- Connect with database

**How it works:**

```
Frontend (React)
↓
API call
↓
Node.js server
↓
Database
↓
Response
```

> **Your Interview Answer (VERY IMPORTANT):**
> In our project, we use NestJS, which is built on top of Node.js. Node.js provides the runtime, and NestJS helps structure the backend using a modular architecture.

---

### 2️⃣ What is NestJS

**What:** NestJS is a backend framework built on Node.js (Express/Fastify).

**Why companies use it:**

- Structured code (like Angular)
- Scalable architecture
- Dependency Injection
- Clean separation (Controller, Service)

**Example Structure:**

- `Controller` → handles request
- `Service` → business logic
- `Repository` → database

**Example Code:**

```typescript
@Controller('users')
export class UserController {

 constructor(private userService: UserService) {}

 @Get()
 getUsers(){
  return this.userService.getAll();
 }

}
```

> **Interview Answer:**
> NestJS follows a modular architecture with controllers handling requests and services containing business logic, making it scalable and maintainable.

---

### 3️⃣ What is Controller, Service (VERY COMMON)

**Controller — What:** Handles incoming HTTP requests.

**Example:**

```typescript
@Get()
getUsers(){
 return this.userService.getUsers();
}
```

**Service — What:** Contains business logic.

```typescript
getUsers(){
 return this.userRepository.find();
}
```

**Difference:**

| Controller | Service |
|------------|---------|
| handles request | handles logic |
| API layer | business layer |

---

### 4️⃣ What is Dependency Injection

**What:** NestJS automatically provides dependencies.

**Example:**

```typescript
constructor(private userService: UserService){}
```

**Why:**

- loose coupling
- easy testing
- clean code

---

### 5️⃣ Middleware in NestJS

**What:** Runs before request reaches controller.

**Example:**

- logging
- authentication
- validation

---

## 🔥 PART 2 — DATABASE (POSTGRESQL)

> Now this is VERY IMPORTANT for your interview.

---

### 1️⃣ What is PostgreSQL

**What:** PostgreSQL is a relational database (SQL-based).

**Why used:**

- structured data
- strong consistency
- complex queries
- transactions

> **Interview Answer:**
> PostgreSQL is a relational database where data is stored in tables with predefined schema, and it supports complex queries and transactions.

---

### 2️⃣ Table Structure

**Example — `users` table:**

| id | name | email |
|----|------|-------|

---

### 3️⃣ Primary Key

**What:** Unique identifier.

**Example:**

```sql
id SERIAL PRIMARY KEY
```

**Why:**

- uniquely identify each row
- fast lookup

---

### 4️⃣ Foreign Key

**What:** Connects two tables.

**Example:** `orders.user_id` → `users.id`

**Why:** maintain relationships

---

### 5️⃣ CRUD Operations

**CREATE:**

```sql
INSERT INTO users(name)
VALUES('John');
```

**READ:**

```sql
SELECT * FROM users;
```

**UPDATE:**

```sql
UPDATE users
SET name='Alex'
WHERE id=1;
```

**DELETE:**

```sql
DELETE FROM users
WHERE id=1;
```

---

### 6️⃣ JOIN (VERY IMPORTANT)

**What:** Combine data from multiple tables.

**Example:**

```sql
SELECT users.name, orders.amount
FROM users
INNER JOIN orders
ON users.id = orders.user_id;
```

**Types:**

| JOIN | Meaning |
|------|---------|
| `INNER` | common data |
| `LEFT` | all left table |
| `RIGHT` | all right table |

---

### 7️⃣ Index (VERY COMMON QUESTION)

**What:** Improves query performance.

**Why:**

- Without index → scan full table
- With index → direct lookup

**Example:**

```sql
CREATE INDEX idx_name
ON users(name);
```

---

### 8️⃣ Transactions

**What:** Group of operations executed together.

**Example:**

```sql
BEGIN;

UPDATE accounts SET balance = balance - 100 WHERE id=1;
UPDATE accounts SET balance = balance + 100 WHERE id=2;

COMMIT;
```

**Why:** data consistency

---

### 9️⃣ ACID Properties

- **Atomicity** → all or nothing
- **Consistency** → valid state
- **Isolation** → independent transactions
- **Durability** → permanent

---

### 🔟 Normalization

**What:** Organizing data to reduce duplication.

**Bad:** users + orders in one table

**Good:** users table + orders table (separate)

---

## ⭐ MOST IMPORTANT INTERVIEW QUESTIONS FOR YOU

Based on your profile, they will ask:

**Node/NestJS:**

- What is NestJS?
- How does controller work?
- What is service?
- What is dependency injection?
- How do you handle APIs?

**Database:**

- What is PostgreSQL?
- Difference SQL vs NoSQL?
- What is primary key?
- What is join?
- What is index?
- What is normalization?

---

## ⭐ VERY IMPORTANT (REAL ANSWER YOU SHOULD GIVE)

If interviewer asks:

> 👉 "Do you know Node.js?"

**You should say:**

> Yes, I have worked with NestJS which is built on top of Node.js. I understand how Node.js works, including event-driven architecture, API handling, and middleware.

---

## 🚀 FINAL STEP (VERY IMPORTANT)

Next, I will prepare you for:

- 🔥 REAL INTERVIEW Q&A (exact answers you should say)
- 🔥 Project explanation (based on your work)
- 🔥 Follow-up questions they will ask


> Since you use NestJS, the interviewer will test if you understand the "Magic" happening behind the scenes. They want to ensure you aren't just copy-pasting decorators, but actually understand Node.js fundamentals and Database architecture.
>
> Here are the exact questions and the professional way to answer them.

---

## 1. Node.js Follow-up Questions (The Foundation)

---

### Q1: Since you use NestJS, can you tell me what the "Underlying Platform" is?

> **The Answer you say:**
> "By default, NestJS is built on top of Express, which is the most popular Node.js web framework. However, NestJS is platform-agnostic, meaning it can also use Fastify if we need higher performance for handling a massive number of requests per second."

---

### Q2: How does Node.js handle multiple requests if it is "Single Threaded"?

> **The Answer you say:**
> "Node.js uses an Event Loop. When a request comes in (like a DB call in NestJS), Node doesn't wait for the DB to finish. It sends that task to the system kernel or a thread pool and moves to the next request. Once the DB data is ready, a callback is pushed to the Task Queue, and the Event Loop picks it up. This is why our NestJS APIs are non-blocking."

---

### Q3: What is the purpose of `main.ts` in your NestJS project?

> **The Answer you say:**
> "The `main.ts` is the entry point of the application. It uses the `NestFactory` class to create a Nest application instance. This is where we define the port, enable CORS, and set up Global Pipes for validation (like `ValidationPipe`)."

---

## 2. PostgreSQL Follow-up Questions (The Data)

---

### Q1: How do you handle relationships between tables in PostgreSQL using NestJS?

> **The Answer you say:**
> "We use an ORM like TypeORM or Prisma. I define relationships using decorators:
>
> - `@OneToMany` for things like a User having many Posts.
> - `@ManyToOne` for the reverse.
> - `@ManyToMany` for things like Students and Courses.
>
> PostgreSQL enforces these via Foreign Keys, ensuring data integrity."

---

### Q2: What is an Index in PostgreSQL, and when would you use it?

> **The Answer you say:**
> "An index is a structure that speeds up data retrieval. I would apply an index to columns that appear frequently in WHERE clauses or JOIN conditions—for example, an email column in a users table. However, I avoid indexing every column because it slows down INSERT and UPDATE operations."

---

### Q3: How do you prevent SQL Injection in your NestJS application?

> **The Answer you say:**
> "By using an ORM like TypeORM, we automatically use Parameterized Queries. The ORM escapes input values so they aren't executed as SQL commands. If I ever have to write a 'Raw Query,' I make sure to use placeholders (`?` or `$1`) instead of template literals."

---

## 3. Advanced Technical Scenarios

---

### Q1: What are "Middlewares" in Node, and how are they different from "Interceptors" in NestJS?

> **The Answer you say:**
> "Middleware is standard Node/Express code that runs before the route handler. Interceptors are a NestJS-specific feature that has access to the 'Execution Context.' I use Interceptors when I want to transform the data being returned (the response) or log the time a request takes."

---

### Q2: Explain "Dependency Injection" (DI) to a 5-year-old.

> **The Answer you say:**
> "Instead of a component creating its own tools (like a Database Service), the 'NestJS Container' provides those tools to the component when it starts. This makes our code easier to test because we can easily swap the real database service for a 'Mock' service during testing."

---

### Key Interviewer "Trap" to avoid:

**If they ask:** "Is NestJS faster than Node.js?"

> **The Correct Response:**
> "NestJS is a framework for Node.js, so it cannot be faster than Node itself. However, it makes development faster and the codebase more maintainable by enforcing a strict architectural pattern (Modules, Controllers, and Services)."

---

## 🔥 SECTION 1 — INTRODUCTION (FIRST QUESTION)

---

### ❓ Tell me about yourself

**✅ Answer (Say like this):**

> I am a frontend-focused full stack developer with around 2 years of experience. Currently, I am working at Techved where I am contributing to the Pathfinder platform, which is a global enterprise application.
>
> I primarily work with React on the frontend and NestJS on the backend, along with PostgreSQL as the database.
>
> My work involves building scalable UI components, integrating APIs, and also understanding backend flows like controllers, services, and database interactions.
>
> I have also worked on optimizing queries and improving performance in some modules.

---

## 🔥 SECTION 2 — NESTJS / NODE QUESTIONS

---

### ❓ What is NestJS?

**✅ Answer:**

> NestJS is a backend framework built on top of Node.js, usually using Express or Fastify under the hood.
> It provides a structured and scalable architecture using concepts like controllers, services, and dependency injection, which makes large applications easier to maintain.

---

### ❓ How does your backend work in your project?

**✅ Answer:**

> In our project, we use NestJS where the request flow is:
>
> Client sends a request → Controller handles it → calls Service → Service interacts with the database → response is returned to the client.
>
> This separation helps maintain clean and scalable code.

---

### ❓ What is Controller in NestJS?

**✅ Answer:**

> A controller is responsible for handling incoming HTTP requests and returning responses. It defines routes and delegates the logic to services.

---

### ❓ What is Service?

**✅ Answer:**

> A service contains the business logic of the application. It processes data, applies logic, and interacts with the database or external APIs.

---

### ❓ Difference between Controller and Service?

**✅ Answer:**

> Controller handles the request and response, whereas service contains the business logic. Controllers should be thin, and most logic should be inside services.

---

### ❓ What is Dependency Injection?

**✅ Answer:**

> Dependency Injection is a design pattern where dependencies are provided automatically instead of being created manually. In NestJS, it helps in creating loosely coupled and testable code.

---

### ❓ Follow-up Questions

They may ask:

- Why is dependency injection useful?
- Have you used it in your project?

**✅ Answer:**

> Yes, we use dependency injection in NestJS to inject services into controllers. It helps in better code organization and makes testing easier.

---

## 🔥 SECTION 3 — DATABASE (POSTGRESQL)

---

### ❓ What is PostgreSQL?

**✅ Answer:**

> PostgreSQL is a relational database management system where data is stored in tables with predefined schemas. It supports complex queries, indexing, and transactions.

---

### ❓ What is Primary Key?

**✅ Answer:**

> A primary key is a column that uniquely identifies each row in a table. It ensures there are no duplicate records.

---

### ❓ What is Foreign Key?

**✅ Answer:**

> A foreign key is used to establish a relationship between two tables by referencing the primary key of another table.

---

### ❓ What is JOIN?

**✅ Answer:**

> JOIN is used to combine data from multiple tables based on a related column.

**Follow-up — 👉 Types of JOIN?**

**✅ Answer:**

> The main types are INNER JOIN, LEFT JOIN, and RIGHT JOIN. INNER JOIN returns matching records, LEFT JOIN returns all records from the left table, and RIGHT JOIN returns all records from the right table.

---

### ❓ What is Index?

**✅ Answer:**

> An index is used to improve query performance by allowing faster data retrieval instead of scanning the entire table.

---

### ❓ Why is index important?

**✅ Answer:**

> It reduces query time significantly, especially for large datasets, by enabling direct lookup instead of full table scans.

---

### ❓ What is Normalization?

**✅ Answer:**

> Normalization is the process of organizing data into multiple related tables to reduce redundancy and improve data consistency.

---

### ❓ What is Transaction?

**✅ Answer:**

> A transaction is a group of operations that are executed together. If any operation fails, the entire transaction is rolled back to maintain consistency.

---

## 🔥 SECTION 4 — VERY IMPORTANT FOLLOW-UP QUESTIONS

> These are what interviewers will actually test deeply

---

### ❓ How do you handle API errors?

**✅ Answer:**

> We handle errors using try-catch blocks in services and also use global exception filters in NestJS to standardize error responses.

---

### ❓ How do you optimize performance?

**✅ Answer:**

> On the frontend, I optimize by reducing unnecessary re-renders and using memoization where needed.
> On the backend, we optimize queries using indexing and proper query design.

---

### ❓ Have you written SQL queries?

**✅ Answer (Important — be honest but confident):**

> Yes, I have basic experience writing queries like SELECT, INSERT, and JOIN, and I have worked with optimizing queries using indexes.

---

### ❓ Difference between SQL and NoSQL?

**✅ Answer:**

> SQL databases are structured with fixed schemas and use tables, while NoSQL databases are flexible and store data in formats like JSON documents.

---

### ❓ Why PostgreSQL over MongoDB?

**✅ Answer:**

> PostgreSQL is better for structured data and complex relationships, while MongoDB is more suitable for flexible and unstructured data.

---

## 🔥 SECTION 5 — TRICKY QUESTIONS (VERY COMMON)

---

### ❓ What happens when you hit an API?

**✅ Answer:**

> When we hit an API, the request goes to the backend server, the controller processes it, calls the service, which interacts with the database, and then returns a response to the frontend.

---

### ❓ How frontend and backend connect?

**✅ Answer:**

> The frontend communicates with the backend using HTTP requests like GET, POST, etc., and the backend returns JSON responses which are rendered in the UI.