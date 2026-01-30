**What are Server Actions?**
    React Server Actions allow you to run asynchronous code directly on the server. They eliminate the need to create API endpoints to mutate your data. Instead, you write asynchronous functions that execute on the server and can be invoked from your Client or Server Components.

    Security is a top priority for web applications, as they can be vulnerable to various threats. This is where Server Actions come in. They include features like encrypted closures, strict input checks, error message hashing, host restrictions, and more — all working together to significantly enhance your application security.

**For example:**

    // Server Component

    export default function Page() {
    // Action
    async function create(formData: FormData) {
        'use server';
    
        // Logic to mutate data...
    }
    
    // Invoke the action using the "action" attribute
    return <form action={create}>...</form>;
    }

    An advantage of invoking a Server Action within a Server Component is progressive enhancement - forms work even if JavaScript has not yet loaded on the client. For example, without slower internet connections.

**Creating an invoice**
    Here are the steps you'll take to create a new invoice:

        Create a form to capture the user's input.
        Create a Server Action and invoke it from the form.
        Inside your Server Action, extract the data from the formData object.
        Validate and prepare the data to be inserted into your database.
        Insert the data and handle any errors.
        Revalidate the cache and redirect the user back to invoices page.

