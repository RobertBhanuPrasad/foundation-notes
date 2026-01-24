**Time and Space complexity** : Video - 13

Time complexity :  It is used to measure the efficiency of algorithm in terms of speed, as the input size grows. (time complexity != time taken to execute the code).

Speed efficiency -  when the user iput increase.


        Linear Search                      |              Binary Search
_____________________________________________________________________________________________

[2, 1, 3, ,5 ,4 7] - search(5)                  It will work in sorted array 

it will search                                   [1, 3, 4, ,7 , 9, 10, 15]  - search(10)
line by line each and everything.                   But in binary search we will divide two 
                                                           seperate things take midle check < or > based on this it will work.


Linear search : n elements (n times) if n= 100 my loop runs - 100 times

Binary search  : n elements (log2(down)n(side)) (n/2pow(x)=1) - if n=100 my loop runs - 7 times (100 50 25 12 6 3 1) - x = log2(base)n(pow)

The above are the complexity of the algorithms.(The binary is taking more speed efficiency)


Linear search                           |     Binary search
_____________________________________________

n = 100, x= 10(no. of times loop runs)         n = 10 , x= 3      
n=100, x=100                                   n=100 , x=7
n= 1000, x=1000                                n=1000, x=10

The above one is time complexity.

** Binary search >>>>>> linear search

**Big O notation** :(we are using this to know the worst case of algorithm) -  just for representation.

Linear search:

[5, 6, 1, 0m 7] - search (5) - Best case because only one loop.

worst case - search (100) - x= n times

Binary seach :

[5, 8, 10, 15, 20] - search (10) -  best case simple only one loop because the binary search will become middle element

worst case - search(100) - x= log(n) - 3 iterations.


**Linear search** -> O(n) - n times

**Binary search** --> O(log n)

Efficiency -> O(log n ) >> O(n)

1) O(n) ---> Linear search
        for(i=0;i<n;i++>)
                (n operations)

                x=n

2) O(log n) --> Binary search
                --> n, n/2, n/4 -----1

                x=(log n)

3) O(n pow(2)) ---> for(i=0;i<n;i++>){
        for(j=0;j<n;j++){
                n times
        }
}

n*n times  = n pow(2) -> two loops

4) O(nlogn) --> Merge sort

        for(i=0;i<n;i++){
                n times = O(n)
        
                n/2*1/2----1 = log n
        }


5) O(n pow(3)) --> Three loops.
6) O(2(pow(n))) -->
                [2, 2] --> 4 times
                [3, 3] ---> 9 times.

7) O(n!)
8) Constant time complexity --> O(1)

        m = 10  x=1
        n=100   x=1

        array of n elements - find an element of array[n]

**Famous** time complexity --> O(n), n(log n), O(n log n) , O(n pow(2)) , O(n pow(3))


**Order of time complexity** -->  O(1)  > O(log n) > O(n) > O(n log n) > O(n pow(2)) > O(2 pow(n)) > O(n!) 


**Space complexity** : (Homw much extra spcae you are using)

1) Find 5th element in array - arr{
        return arr[4]
}

time complexity - O(1)
space complexity - O(1)

2) findMaxArray(arr){
        let max = a[0]
        for(i=0;i<n;i++){
                if(a[i]>max) max = a[i]
        }
        return max
}

space complexity  - max(extra space 1 variable) - O(1) - constant 
time = O(n)

3) doubleArray(arr){
        let newArray = []
        for(i=0;i<n;i++){
                newArray = arr[i]*2
        }
}

time = O(n)
space = O(n)

[i, j, max,----] -  they are countable = O(1) =  space complexity

newArray[   ] with n = O(n) -  space complexity

[    ] - n*n matrix  = O(n pow(2)) = space complexity

Problem :

[1, 3, 2, 8, 10] - You have to create an array of double of n times

[1, 3, 3, 8, 10
2, 6, 3, 16, 20] -  like this 5 rows


**2 Independent for loops**:

func(){
        for(loop){     - n
                                = n+n
        }
        for(loop){     - n 

        }
}

O(2n) -  time complexity

**Nested for loop** :

for(loop){             - n
        for(loop){     - n     = n*n --> O(n pow(2)) -  time complexity

        }
}


**Comparision** between O(n pow(2))  and O(3n)

    O(n pow(2))            |          O(3n)
______________________________________________________
    n=10, x= 100                  n=10  , x = 20
    n=100, x= 10, 000             n= 100 , x= 300

**Example** Time complexity:

for(loop){
        for(loop){

        }
}
for(loop){

}

O(n pow(2) + n)  ==> O(n pow(2)) - we can ignore the smaller values because when our n is 1 millioon

O(n pow(3)+ n+ n pow(2))  - O(n pow(3))

O(n pow(2)+ 2n)  => O(n pow(2))

O(n pow(2)+ n log+ 2n +n)  => O(n pow(2))

**we will take the greater time complexity and ignore the smaller ones when over n value increases. (Similar for the **space complexity**)