**Best practice: Debouncing**
    Congratulations! You've implemented search with Next.js! But there's something you can do to optimize it.

    Inside your handleSearch function, add the following console.log:

    /app/ui/search.tsx
    function handleSearch(term: string) {
    console.log(`Searching... ${term}`);
    
    const params = new URLSearchParams(searchParams);
    if (term) {
        params.set('query', term);
    } else {
        params.delete('query');
    }
    replace(`${pathname}?${params.toString()}`);
    }
    Then type "Delba" into your search bar and check the console in dev tools. What is happening?

    Dev Tools Console
    Searching... D
    Searching... De
    Searching... Del
    Searching... Delb
    Searching... Delba
    You're updating the URL on every keystroke, and therefore querying your database on every keystroke! This isn't a problem as our application is small, but imagine if your application had thousands of users, each sending a new request to your database on each keystroke.

    Debouncing is a programming practice that limits the rate at which a function can fire. In our case, you only want to query the database when the user has stopped typing.

    How Debouncing Works:

    Trigger Event: When an event that should be debounced (like a keystroke in the search box) occurs, a timer starts.
    Wait: If a new event occurs before the timer expires, the timer is reset.
    Execution: If the timer reaches the end of its countdown, the debounced function is executed.
    You can implement debouncing in a few ways, including manually creating your own debounce function. To keep things simple, we'll use a library called use-debounce.

    Install use-debounce:

    Terminal
    pnpm i use-debounce
    In your <Search> Component, import a function called useDebouncedCallback:

    /app/ui/search.tsx
    // ...
    import { useDebouncedCallback } from 'use-debounce';
    
    // Inside the Search Component...
    const handleSearch = useDebouncedCallback((term) => {
    console.log(`Searching... ${term}`);
    
    const params = new URLSearchParams(searchParams);
    if (term) {
        params.set('query', term);
    } else {
        params.delete('query');
    }
    replace(`${pathname}?${params.toString()}`);
    }, 300);
    This function will wrap the contents of handleSearch, and only run the code after a specific time once the user has stopped typing (300ms).

**Server Actions** - https://nextjs.org/learn/dashboard-app/mutating-data#updating-an-invoice