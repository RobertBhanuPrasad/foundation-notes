**What are Server Actions?** - https://chatgpt.com/share/6984962b-a208-8013-9d5a-3586cbd2a268
    React Server Actions allow you to run asynchronous code directly on the server. They eliminate the need to create API endpoints to mutate your data. Instead, you write asynchronous functions that execute on the server and can be invoked from your Client or Server Components.

    Security is a top priority for web applications, as they can be vulnerable to various threats. This is where Server Actions come in. They include features like encrypted closures, strict input checks, error message hashing, host restrictions, and more — all working together to significantly enhance your application security.

**Next.js with Server Actions**
    Server Actions are also deeply integrated with Next.js caching. When a form is submitted through a Server Action, not only can you use the action to mutate data, but you can also revalidate the associated cache using APIs like revalidatePath and revalidateTag.


**Handling all errors with error.tsx**
    The error.tsx file can be used to define a UI boundary for a route segment. It serves as a catch-all for unexpected errors and allows you to display a fallback UI to your users.

    Inside your /dashboard/invoices folder, create a new file called error.tsx and paste the following code:


**Handling 404 errors with the notFound function**
    Another way you can handle errors gracefully is by using the notFound function. While error.tsx is useful for catching uncaught exceptions, notFound can be used when you try to fetch a resource that doesn't exist.

    For example, visit http://localhost:3000/dashboard/invoices/2e94d1ed-d220-449f-9f11-f0bbceed9645/edit.

    This is a fake UUID that doesn't exist in your database.

    You'll immediately see error.tsx kicks in because this is a child route of /invoices where error.tsx is defined.

    However, if you want to be more specific, you can show a 404 error to tell the user the resource they're trying to access hasn't been found.

    You can confirm that the resource hasn't been found by going into your fetchInvoiceById function in data.ts, and adding a console log for the returned invoice:

Now that you know the invoice doesn't exist in your database, let's use notFound to handle it. Navigate to /dashboard/invoices/[id]/edit/page.tsx, and import { notFound } from 'next/navigation'.

That's something to keep in mind, notFound will take precedence over error.tsx, so you can reach out for it when you want to handle more specific errors!

**In this chapter...**

    Here are the topics we'll cover

    How to use eslint-plugin-jsx-a11y with Next.js to implement accessibility best practices.

    How to implement server-side form validation.

    How to use the React useActionState hook to handle form errors, and display them to the user.

**What is accessibility?**
    Accessibility refers to designing and implementing web applications that everyone can use, including those with disabilities. It's a vast topic that covers many areas, such as keyboard navigation, semantic HTML, images, colors, videos, etc.

    While we won't go in-depth into accessibility in this course, we'll discuss the accessibility features available in Next.js and some common practices to make your applications more accessible.

    If you'd like to learn more about accessibility, we recommend the Learn Accessibility course by web.dev.

**Using the ESLint accessibility plugin in Next.js**
    Next.js's ESLint configuration includes the eslint-plugin-jsx-a11y plugin, which helps catch accessibility issues early. For example, this plugin warns if you have images without alt text, use the aria-* and role attributes incorrectly, and more.

    Begin by installing ESLint:

    