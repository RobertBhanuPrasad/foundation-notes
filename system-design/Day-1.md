

**Browser Databases storage** (Front-end)

1) localstorge - public storage(key, value pairs)(key and value should be string) -  dark or light mode
2) session storage - short info. for some time only (sensitive) - bank apps while using.
3) cookies - when any info. you want to send from client to server (headers auth. token, jwt etc)
4) index db - if you want to large data to store in browser (slack, web.whasapp, outlook) 

when the user logout you have to clear all your data from web browser.

**Cache** - clear side data.

1) HTTP - When do i should invalidate or get the data based on conditions/
2) Memory Cache - If you want to load a image continously then it will store in memory cache.
3) Disk Cache - it is browser storage
4) Service worker cache - it will access to the api responses, files (if it is offline or their a storage get the request or data from the cache) - It will work as like Interceptor. (lies b/w the application and network layer).

If you are using Redis the browser cannot know, what was there.

