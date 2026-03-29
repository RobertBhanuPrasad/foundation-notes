**Load Balancing**:

1) In a server a single application is running and max. limit is 1000 users.
2) if 2000 users has came at that time application will stuck.
3) then i will take another server with the max. limit of 1000 requests.
4) At this i will connect the two servers to the load balancing in between the two servers.
5) At this time when request comes it will go to the load balancer.
6) This load balancer will shift the requests based on the server performance.(health info. - how much CPU the server is using. )
7) It will send the requests to the healthy server.
8) If both servers are healthy the load balancer will split the requests equally.(if 50 are came it will send 25 to one and other 25 to two)
9) Because of this the application performance will good no stuck.

**How**
10) we will create the instanaces for each one in aws and we will connect those two for load balancer.
11) now the load balancer will provide the DNS name and we will use this to access the application .
12) when we hit thi load balancer it will have the two ip addresses in the load balancer it will only balance the requests by sending the request to the servers.

13) if we take the 5 web servers and connect to one load balancer(it will give the DNS name - myloadbalancer-some number-some name) -  so the user will not remember all this dns name so i will purchase the domain from the go-daddy or hostinger(like as facebook.com) and i will link that domain to this dns and now when the user types the facebook,com our website will come.

14) when we have two servers and each server will accept only 1000 requests per server and suddenly if we got the 5000 requests our server will get down and our application will get stuck or performance will decrease.
  
  in cloud it will be depend on money 

  **Problem**:
  when initially our application are using only 2k users for me just 100 servers or enough.
  But if i keep any offer i will think that my application will get 10k users and i will ask i need 250 servers. But unfortunately we only got the just 3k to 4k users and for this for just 150 servers are enough or unfortunately if our application 15k users so what are the servers we have those are not sufficient we need more servers. We have to pay for all the servers we have we use or not use.

  **Solution** 
  To solve this problem we can come across the Auto scalling group.

  1) It will help that i will keep min. 100 servers should be there.
  2) And how much percentage to use like as 60%(it is usefull that if the cpu utilization is above 60% i will say add one more server or if it less i will say you have to delete the server).
  3) So in this when business increase my servers will increase or decrease when buisiness was not there so in here my cost will also managed because i am paying for what i used/present.