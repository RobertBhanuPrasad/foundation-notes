# 🚀 TypeScript Master Preparation (Interview Ready)

## 📌 Table of Contents
1. [🧩 Step 1 — What is TypeScript?](#-step-1--what-is-typescript)
2. [🧩 Step 2 — Basic Types](#-step-2--basic-types)
3. [🧩 Step 3 — Functions](#-step-3--functions)
4. [🧩 Step 4 — Interfaces vs Types](#-step-4--interfaces-vs-types)
5. [🧩 Step 5 — Union & Intersection](#-step-5--union--intersection)
6. [🧩 Step 6 — Generics](#-step-6--generics)
7. [🧩 Step 7 — Type Narrowing](#-step-7--type-narrowing)
8. [🧩 Step 8 — Utility Types](#-step-8--utility-types)
9. [🧩 Step 9 — Advanced Types](#-step-9--advanced-types)
10. [🧩 Step 10 — Decorators](#-step-10--decorators)
11. [🧩 Step 11 — TypeScript in Your Project](#-step-11--typescript-in-your-project)
12. [🧩 Step 12 — Common Interview Questions](#-step-12--common-interview-questions)
13. [🧩 Step 13 — Tricky Questions](#-step-13--tricky-questions)
14. [🚀 Advanced TypeScript](#-advanced-typescript)
    - [1. Type Inference](#1-type-inference)
    - [2. Type Assertion](#2-type-assertion)
    - [3. Type Guards](#3-type-guards)
    - [4. Optional Chaining & Nullish Coalescing](#4-optional-chaining--nullish-coalescing)
    - [5. Readonly & Immutability](#5-readonly--immutability)
    - [6. Record Type](#6-record-type)
    - [7. Mapped Types](#7-mapped-types)
    - [8. Conditional Types](#8-conditional-types)
    - [9. Never Type](#9-never-type)
    - [10. Void vs Never](#10-void-vs-never)
    - [11. Modules](#11-modules)
    - [12. TS Config](#12-ts-config)
    - [13. TypeScript in Backend](#13-typescript-in-backend)
15. [🚨 Tricky Interview Questions](#-tricky-interview-questions)
16. [🚀 Final Level Answer](#-final-level-answer)

---

## 🧩 Step 1 — What is TypeScript?

### ✅ Interview Answer
> TypeScript is a superset of JavaScript that adds static typing, allowing developers to catch errors at compile time and build more maintainable and scalable applications.

### 🔥 Why TypeScript?
*   **Type safety**: Catch bugs early.
*   **Better IDE support**: Auto-completion and navigation.
*   **Scalable for large apps**: Easier to maintain complex codebases.

### 💥 Strong Answer
> In large-scale applications like the one I worked on, TypeScript helped enforce type safety across modules, reducing runtime errors and improving maintainability.

---

## 🧩 Step 2 — Basic Types

### 🔥 Primitive Types
```typescript
let name: string = "Robert";
let age: number = 25;
let isActive: boolean = true;
```

### 🔥 Arrays
```typescript
let nums: number[] = [1, 2, 3];
```

### 🔥 Tuple
```typescript
let user: [string, number] = ["Robert", 25];
```

### 🔥 Enum
```typescript
enum Role {
  Admin,
  User,
}
```

### 🔥 Any vs Unknown (IMPORTANT 🔥)

#### ❌ any
*   No type checking.
```typescript
let data: any = "hello";
data = 10;
```

#### ✅ unknown
*   Safer version.
```typescript
let data: unknown;

if (typeof data === "string") {
  console.log(data.toUpperCase());
}
```

### ✅ Interview Answer
> `any` disables type checking, while `unknown` enforces type safety by requiring type checks before usage.

---

## 🧩 Step 3 — Functions

```typescript
function add(a: number, b: number): number {
  return a + b;
}
```

### 🔥 Optional + Default
```typescript
function greet(name: string = "User") {}
```

---

## 🧩 Step 4 — Interfaces vs Types (VERY IMPORTANT 🔥)

### 🔥 Interface
```typescript
interface User {
  name: string;
  age: number;
}
```

### 🔥 Type
```typescript
type User = {
  name: string;
  age: number;
};
```

### 🎯 Difference (INTERVIEW GOLD)

| Feature | Interface | Type |
| :--- | :---: | :---: |
| Extend | ✅ | ✅ |
| Merge | ✅ | ❌ |
| Union | ❌ | ✅ |

### ✅ Perfect Answer
> Interfaces are mainly used for object structures and support declaration merging, while types are more flexible and support unions and complex compositions.

---

## 🧩 Step 5 — Union & Intersection

### 🔥 Union
```typescript
let id: string | number;
```

### 🔥 Intersection
```typescript
type A = { name: string };
type B = { age: number };

type C = A & B;
```

---

## 🧩 Step 6 — Generics (VERY IMPORTANT 🔥)

### 💡 Concept
Reusable type-safe code.

```typescript
function identity<T>(value: T): T {
  return value;
}
```

### ✅ Answer
> Generics allow creating reusable components that work with multiple types while maintaining type safety.

### 💥 Real Example (USE THIS)
> In APIs, I used generics to define reusable response types like `ApiResponse<T>` to standardize responses across modules.

---

## 🧩 Step 7 — Type Narrowing

```typescript
function print(value: string | number) {
  if (typeof value === "string") {
    console.log(value.toUpperCase());
  }
}
```

---

## 🧩 Step 8 — Utility Types (IMPORTANT)

### 🔥 Common Ones
*   `Partial<User>`
*   `Required<User>`
*   `Pick<User, "name">`
*   `Omit<User, "age">`

### ✅ Answer
> Utility types help transform existing types, improving reusability and reducing duplication.

---

## 🧩 Step 9 — Advanced Types (HIGH IMPACT)

### 🔥 keyof
```typescript
type Keys = keyof User;
```

### 🔥 typeof
```typescript
type T = typeof someObject;
```

---

## 🧩 Step 10 — Decorators (VERY IMPORTANT FOR NESTJS 🔥)

```typescript
@Controller()
class UserController {}
```

### 💡 Concept
Add metadata to classes/methods.

### ✅ Answer
> Decorators are functions that add metadata and behavior to classes, methods, or properties, widely used in frameworks like NestJS.

---

## 🧩 Step 11 — TypeScript in Your Project (🔥 GOLD)

### 🎯 Strong Answer
> I used TypeScript extensively in my project to define DTOs, enforce API contracts, and ensure type safety across frontend and backend. It helped reduce runtime errors and improved code maintainability in our multi-module system.

---

## 🧩 Step 12 — Common Interview Questions

### 🔥 Q1: Difference between TypeScript and JavaScript?
> TypeScript adds static typing and compile-time checks, while JavaScript is dynamically typed.

### 🔥 Q2: What are Generics?
> (Already covered — give example)

### 🔥 Q3: Interface vs Type?
> (VERY IMPORTANT - See Difference Table)

### 🔥 Q4: What is unknown vs any?
### 🔥 Q5: What are decorators?
### 🔥 Q6: What is type inference?
> TypeScript automatically infers types based on values.

### 🔥 Q7: What is strict mode?
> Enables strict type checking.

---

## 🧩 Step 13 — Tricky Questions

### ❓ Why not use any everywhere?
> It removes type safety and defeats the purpose of TypeScript.

### ❓ Can interfaces extend types?
👉 **YES**

### ❓ Can types extend interfaces?
👉 **YES** (via intersection)

---

## 🚀 Final Interview Strategy

### 🎯 When answering:
Always combine:
1.  **Concept**
2.  **Why**
3.  **Example**
4.  **Your usage**

### 💥 Example Answer
> I used TypeScript generics to create reusable API response types, which helped standardize responses and reduce duplication across multiple modules.

---

## 🚀 Advanced TypeScript (Interview-Critical Topics)

### 1. Type Inference (VERY IMPORTANT)
#### 💡 Concept
TypeScript automatically detects types.

```typescript
let name = "Robert"; // inferred as string
```

#### ✅ Interview Answer
> Type inference allows TypeScript to automatically determine the type of a variable based on its value, reducing the need for explicit annotations.

#### ⚠️ Follow-up
👉 **“When should you NOT rely on inference?”**

#### ✅ Answer
> In complex systems or APIs, explicit types should be used for clarity and maintainability.

---

### 2. Type Assertion
#### 💡 Concept
Tell TypeScript “trust me, I know the type”.

```typescript
let value: unknown = "hello";
let str = value as string;
```

#### ⚠️ Important
*   No runtime check
*   Only compile-time

#### ✅ Answer
> Type assertion is used to override TypeScript’s inferred type when we are certain about the value’s type.

---

### 3. Type Guards (VERY IMPORTANT 🔥)
#### 💡 Concept
Narrow down types safely.

#### 🔥 Types
1.  **typeof**
    ```typescript
    if (typeof value === "string") {}
    ```
2.  **instanceof**
    ```typescript
    if (err instanceof Error) {}
    ```
3.  **Custom Guard**
    ```typescript
    function isString(val: unknown): val is string {
      return typeof val === "string";
    }
    ```

#### ✅ Answer
> Type guards help narrow down union types safely at runtime, ensuring type-safe operations.

---

### 4. Optional Chaining & Nullish Coalescing
#### 🔥 Optional Chaining
```typescript
user?.address?.city
```

#### 🔥 Nullish Coalescing
```typescript
let name = input ?? "Default";
```

#### ✅ Answer
> Optional chaining prevents runtime errors when accessing nested properties, while nullish coalescing provides default values for null or undefined.

---

### 5. Readonly & Immutability
```typescript
readonly name: string;
```

#### ✅ Answer
> Readonly ensures that properties cannot be modified after initialization, improving data integrity.

---

### 6. Record Type
```typescript
type Users = Record<string, number>;
```

#### ✅ Answer
> Record is used to define object types with dynamic keys and consistent value types.

---

### 7. Mapped Types (ADVANCED 🔥)
```typescript
type Optional<T> = {
  [K in keyof T]?: T[K];
};
```

#### ✅ Answer
> Mapped types allow transforming existing types dynamically, making code reusable and scalable.

---

### 8. Conditional Types (ADVANCED 🔥)
```typescript
type IsString<T> = T extends string ? true : false;
```

#### ✅ Answer
> Conditional types enable dynamic type logic based on conditions, making TypeScript highly flexible.

---

### 9. Never Type (Tricky 🔥)
```typescript
function throwError(): never {
  throw new Error();
}
```

#### 💡 Meaning
*   Never returns
*   Infinite loop or error

#### ✅ Answer
> The `never` type represents values that never occur, such as functions that throw errors or never complete.

---

### 10. Void vs Never (IMPORTANT 🔥)

| Feature | void | never |
| :--- | :--- | :--- |
| Returns | nothing | never returns |
| Example | `console.log` | `throw error` |

---

### 11. Modules (IMPORTANT FOR NODE)
#### 🔥 ES Modules
```typescript
import { x } from "./file";
```

#### 🔥 CommonJS
```typescript
const x = require("./file");
```

#### ✅ Answer
> TypeScript supports both ES modules and CommonJS, depending on the project configuration.

---

### 12. TS Config (VERY IMPORTANT 🔥)
#### 🔥 Key Options
```json
{
  "strict": true,
  "target": "ES6",
  "module": "commonjs"
}
```

#### ✅ Answer
> `tsconfig.json` controls how TypeScript compiles code, including strictness, module system, and target JavaScript version.

---

### 13. TypeScript in Backend (REAL USE 🔥)
#### 🎯 Where YOU used it
1.  **DTOs**
    ```typescript
    class CreateUserDto {
      name: string;
    }
    ```
2.  **API Response Types**
    ```typescript
    type ApiResponse<T> = {
      data: T;
      success: boolean;
    };
    ```
3.  **Validation (Zod / class-validator)**

#### 💥 Strong Answer
> I used TypeScript to define DTOs, enforce API contracts, and ensure type safety across modules. It helped reduce runtime errors and improved maintainability in our multi-tenant system.

---

## 🚨 Tricky Interview Questions (VERY IMPORTANT)

### ❓ 1. What is the difference between interface and abstract class?
#### ✅ Answer
> Interfaces define structure, while abstract classes can include implementation and behavior.

### ❓ 2. What is declaration merging?
#### ✅ Answer
> Interfaces with the same name automatically merge their properties.

### ❓ 3. Can TypeScript catch runtime errors?
#### ✅ Answer
> No, TypeScript only performs compile-time checks.

### ❓ 4. What is structural typing?
#### ✅ Answer
> TypeScript checks compatibility based on structure, not exact type names.

### ❓ 5. Why TypeScript over JavaScript?
#### ✅ Answer
> It improves maintainability, scalability, and reduces runtime bugs through static typing.

---

## 🚀 Final Level Answer (USE THIS IN INTERVIEW)

### 👉 If they ask:
“How comfortable are you with TypeScript?”

### 💥 Perfect Answer
> I’m very comfortable with TypeScript and use it extensively in backend development. I’ve worked with advanced concepts like generics, utility types, and type guards to build scalable APIs. I’ve also used TypeScript for DTO validation and enforcing API contracts, which significantly improved code quality and reduced runtime errors in our system.