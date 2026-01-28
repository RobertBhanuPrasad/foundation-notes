
10️⃣ How Data Travels (Full Journey)

Let’s see FULL FLOW 👇

When You Insert Data (Seed)
Browser
   ↓
/seed route
   ↓
Next.js server
   ↓
postgres library
   ↓
Internet cable 🌍
   ↓
Supabase Database
   ↓
Table created
   ↓
Rows inserted


When You Read Data (/query)
Browser
   ↓
/query
   ↓
Next.js server
   ↓
SQL SELECT
   ↓
Supabase DB
   ↓
Result returned
   ↓
JSON shown in browser


**Fetching Data** :

**Choosing how to fetch data**
    API layer
    APIs are an intermediary layer between your application code and database. There are a few cases where you might use an API:

    If you're using third-party services that provide an API.
    If you're fetching data from the client, you want to have an API layer that runs on the server to avoid exposing your database secrets to the client.
    In Next.js, you can create API endpoints using Route Handlers.


**Database queries**
    When you're creating a full-stack application, you'll also need to write logic to interact with your database. For relational databases like Postgres, you can do this with SQL or with an ORM.

    There are a few cases where you have to write database queries:

    When creating your API endpoints, you need to write logic to interact with your database.
    If you are using React Server Components (fetching data on the server), you can skip the API layer, and query your database directly without risking exposing your database secrets to the client.


**Using Server Components to fetch data**
    By default, Next.js applications use React Server Components. Fetching data with Server Components is a relatively new approach and there are a few benefits of using them:

    Server Components support JavaScript Promises, providing a solution for asynchronous tasks like data fetching natively. You can use async/await syntax without needing useEffect, useState or other data fetching libraries.
    Server Components run on the server, so you can keep expensive data fetches and logic on the server, only sending the result to the client.
    Since Server Components run on the server, you can query the database directly without an additional API layer. This saves you from writing and maintaining additional code.


**Using SQL**
    For your dashboard application, you'll write database queries using the postgres.js library and SQL. There are a few reasons why we'll be using SQL:

    SQL is the industry standard for querying relational databases (e.g. ORMs generate SQL under the hood).
    Having a basic understanding of SQL can help you understand the fundamentals of relational databases, allowing you to apply your knowledge to other tools.
    SQL is versatile, allowing you to fetch and manipulate specific data.
    The postgres.js library provides protection against SQL injections.
    Don't worry if you haven't used SQL before - we have provided the queries for you.


However... there are two things you need to be aware of:

    1) The data requests are unintentionally blocking each other, creating a request waterfall.
    2) By default, Next.js prerenders routes to improve performance, this is called Static Rendering. So if your data changes, it won't be reflected in your dashboard.
    Let's discuss number 1 in this chapter, then look into detail at number 2 in the next chapter.

**What are request waterfalls?**
    A "waterfall" refers to a sequence of network requests that depend on the completion of previous requests. In the case of data fetching, each request can only begin once the previous request has returned data.

    Diagram showing time with sequential data fetching and parallel data fetching
    For example, we need to wait for fetchRevenue() to execute before fetchLatestInvoices() can start running, and so on.

    /app/dashboard/page.tsx
    const revenue = await fetchRevenue();
    const latestInvoices = await fetchLatestInvoices(); // wait for fetchRevenue() to finish
    const {
    numberOfInvoices,
    numberOfCustomers,
    totalPaidInvoices,
    totalPendingInvoices,
    } = await fetchCardData(); // wait for fetchLatestInvoices() to finish
    This pattern is not necessarily bad. There may be cases where you want waterfalls because you want a condition to be satisfied before you make the next request. For example, you might want to fetch a user's ID and profile information first. Once you have the ID, you might then proceed to fetch their list of friends. In this case, each request is contingent on the data returned from the previous request.

    However, this behavior can also be unintentional and impact performance.


**Parallel data fetching**
    A common way to avoid waterfalls is to initiate all data requests at the same time - in parallel.

    In JavaScript, you can use the Promise.all() or Promise.allSettled() functions to initiate all promises at the same time. For example, in data.ts, we're using Promise.all() in the fetchCardData() function:

    /app/lib/data.ts
    export async function fetchCardData() {
    try {
        const invoiceCountPromise = sql`SELECT COUNT(*) FROM invoices`;
        const customerCountPromise = sql`SELECT COUNT(*) FROM customers`;
        const invoiceStatusPromise = sql`SELECT
            SUM(CASE WHEN status = 'paid' THEN amount ELSE 0 END) AS "paid",
            SUM(CASE WHEN status = 'pending' THEN amount ELSE 0 END) AS "pending"
            FROM invoices`;
    
        const data = await Promise.all([
        invoiceCountPromise,
        customerCountPromise,
        invoiceStatusPromise,
        ]);
        // ...
    }
    }
    By using this pattern, you can:

    Start executing all data fetches at the same time, which is faster than waiting for each request to complete in a waterfall.
    Use a native JavaScript pattern that can be applied to any library or framework.
    However, there is one disadvantage of relying only on this JavaScript pattern: what happens if one data request is slower than all the others? Let's find out more in the next chapter.

**In this chapter...**

    Here are the topics we'll cover

    What static rendering is and how it can improve your application's performance.

    What dynamic rendering is and when to use it.

    Different approaches to make your dashboard dynamic.

    Simulate a slow data fetch to see what happens.


**What is Static Rendering?**
    With static rendering, data fetching and rendering happens on the server at build time (when you deploy) or when revalidating data.

    Whenever a user visits your application, the cached result is served. There are a couple of benefits of static rendering:

    Faster Websites - Prerendered content can be cached and globally distributed when deployed to platforms like Vercel. This ensures that users around the world can access your website's content more quickly and reliably.
    Reduced Server Load - Because the content is cached, your server does not have to dynamically generate content for each user request. This can reduce compute costs.
    SEO - Prerendered content is easier for search engine crawlers to index, as the content is already available when the page loads. This can lead to improved search engine rankings.
    Static rendering is useful for UI with no data or data that is shared across users, such as a static blog post or a product page. It might not be a good fit for a dashboard that has personalized data which is regularly updated.

    The opposite of static rendering is dynamic rendering.


**What is Dynamic Rendering?**
    With dynamic rendering, content is rendered on the server for each user at request time (when the user visits the page). There are a couple of benefits of dynamic rendering:

    Real-Time Data - Dynamic rendering allows your application to display real-time or frequently updated data. This is ideal for applications where data changes often.
    User-Specific Content - It's easier to serve personalized content, such as dashboards or user profiles, and update the data based on user interaction.
    Request Time Information - Dynamic rendering allows you to access information that can only be known at request time, such as cookies or the URL search parameters.


**Streaming** :

    What is streaming?
    Streaming is a data transfer technique that allows you to break down a route into smaller "chunks" and progressively stream them from the server to the client as they become ready.

    Diagram showing time with sequential data fetching and parallel data fetching
    By streaming, you can prevent slow data requests from blocking your whole page. This allows the user to see and interact with parts of the page without waiting for all the data to load before any UI can be shown to the user.

    Diagram showing time with sequential data fetching and parallel data fetching
    Streaming works well with React's component model, as each component can be considered a chunk.

    There are two ways you implement streaming in Next.js:

    At the page level, with the loading.tsx file (which creates <Suspense> for you).
    At the component level, with <Suspense> for more granular control.

**Streaming a whole page with loading.tsx**
    In the /app/dashboard folder, create a new file called loading.tsx:

    /app/dashboard/loading.tsx
    export default function Loading() {
    return <div>Loading...</div>;
    }


    A few things are happening here:

    1) loading.tsx is a special Next.js file built on top of React Suspense. It allows you to create fallback UI to show as a replacement while page content loads.
    2) Since <SideNav> is static, it's shown immediately. The user can interact with <SideNav> while the dynamic content is loading.
    3) The user doesn't have to wait for the page to finish loading before navigating away (this is called interruptable navigation).
    4) Congratulations! You've just implemented streaming. But we can do more to improve the user experience. Let's show a loading skeleton instead of the Loading… text.

**Adding loading skeletons**
    A loading skeleton is a simplified version of the UI. Many websites use them as a placeholder (or fallback) to indicate to users that the content is loading. Any UI you add in loading.tsx will be embedded as part of the static file, and sent first. Then, the rest of the dynamic content will be streamed from the server to the client.

    Inside your loading.tsx file, import a new component called <DashboardSkeleton>:

    /app/dashboard/loading.tsx
    import DashboardSkeleton from '@/app/ui/skeletons';
    
    export default function Loading() {
    return <DashboardSkeleton />;
    }

    

