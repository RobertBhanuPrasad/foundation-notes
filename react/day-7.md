
**Improving Accessibility**:
    In this chapter...

        Here are the topics we'll cover
        How to use eslint-plugin-jsx-a11y with Next.js to implement accessibility best practices.
        How to implement server-side form validation.
        How to use the React useActionState hook to handle form errors, and display them to the user.

**What is accessibility?**:

Accessibility refers to designing and implementing web applications that everyone can use, including those with disabilities. It's a vast topic that covers many areas, such as keyboard navigation, semantic HTML, images, colors, videos, etc.

While we won't go in-depth into accessibility in this course, we'll discuss the accessibility features available in Next.js and some common practices to make your applications more accessible.

If you'd like to learn more about accessibility, we recommend the Learn Accessibility course by web.dev.

Using the ESLint accessibility plugin in Next.js
Next.js's ESLint configuration includes the eslint-plugin-jsx-a11y plugin, which helps catch accessibility issues early. For example, this plugin warns if you have images without alt text, use the aria-* and role attributes incorrectly, and more.

Begin by installing ESLint:

Terminal
pnpm add -D eslint eslint-config-next
Next, create an eslint.config.mjs file in the root of your project with the following content:

eslint.config.mjs
import { defineConfig, globalIgnores } from 'eslint/config';
import nextVitals from 'eslint-config-next/core-web-vitals';
const eslintConfig = defineConfig([
  ...nextVitals,
  globalIgnores(['.next/**', 'out/**', 'build/**', 'next-env.d.ts']),
]);
export default eslintConfig;
This configuration uses eslint-config-next/core-web-vitals, which includes the eslint-plugin-jsx-a11y plugin for catching accessibility issues.

Now add a lint script to your package.json file:

/package.json
"scripts": {
    "build": "next build",
    "dev": "next dev",
    "start": "next start",
    "lint": "eslint ."
},
Then run pnpm lint in your terminal:

Terminal
pnpm lint
If there are no linting errors, ESLint will complete without any output. However, what would happen if you had an image without alt text? Let's find out!

Go to /app/ui/invoices/table.tsx and remove the alt prop from the image. You can use your editor's search feature to quickly find the <Image>:

/app/ui/invoices/table.tsx
<Image
  src={invoice.image_url}
  className="rounded-full"
  width={28}
  height={28}
  alt={`${invoice.name}'s profile picture`} // Delete this line
/>
Now run pnpm lint again, and you should see the following warning:

Terminal
./app/ui/invoices/table.tsx
45:25  Warning: Image elements must have an alt prop,
either with meaningful text, or an empty string for decorative images. jsx-a11y/alt-text
While adding and configuring a linter is not a required step, it can be helpful to catch accessibility issues in your development process.

Improving form accessibility
There are three things we're already doing to improve accessibility in our forms:

Semantic HTML: Using semantic elements (<input>, <option>, etc) instead of <div>. This allows assistive technologies (AT) to focus on the input elements and provide appropriate contextual information to the user, making the form easier to navigate and understand.
Labelling: Including <label> and the htmlFor attribute ensures that each form field has a descriptive text label. This improves AT support by providing context and also enhances usability by allowing users to click on the label to focus on the corresponding input field.
Focus Outline: The fields are properly styled to show an outline when they are in focus. This is critical for accessibility as it visually indicates the active element on the page, helping both keyboard and screen reader users to understand where they are on the form. You can verify this by pressing tab.
These practices lay a good foundation for making your forms more accessible to many users. However, they don't address form validation and errors.

Form validation
Go to http://localhost:3000/dashboard/invoices/create, and submit an empty form. What happens?

You get an error! This is because you're sending empty form values to your Server Action. You can prevent this by validating your form on the client or the server.

Client-Side validation
There are a couple of ways you can validate forms on the client. The simplest would be to rely on the form validation provided by the browser by adding the required attribute to the <input> and <select> elements in your forms. For example:

/app/ui/invoices/create-form.tsx


**Server-Side validation** :
    By validating forms on the server, you can:

    Ensure your data is in the expected format before sending it to your database.
    Reduce the risk of malicious users bypassing client-side validation.
    Have one source of truth for what is considered valid data.
    In your create-form.tsx component, import the useActionState hook from react. Since useActionState is a hook, you will need to turn your form into a Client Component using "use client" directive: