**warm-up -> Programming 101**: - video - 4
1) This is very basic any one can do.
2) The js is very easy and love the js.
3) It is very popular language.
4) Thier will not be heavy installation.
5) Go to playgorund in namaste dsa. (both browser and console was there).
6) what is programming? - Right some code and it will gives some ouput.

console.log("hello world") - why wrapping inside (" ") - it is string in js.

**Data types**:

1) string - "2"
2) number - 2
3) boolean - true/false

Mathematical operations and variables let, const:
1) + , *, -
2) const had its own values and he will use mostly let variable.
3) string concatination :
let a = 1
let b = 2
console.log(a+b) = 3
cosole.log(a + " "+ b) = 1 2.
4) The js will only run in js engine(taking values and managing garbage) and it is running inside the browser and it will execute line by line.

**Arrays** - [] - it can store multiple values.

How does js store the array - [5, 10, 2, 0, 1]

index value
0       5
1       10
2       2
3       0
4       1

const a = [2, 3, 4];
console.log(a[3]+a[0]) = NAN; (undefined + 2)
console.log(a[3]) = undefined

**Objects** : - {} - contains key , value pairs.

How these are stored in js


let obj = {
    a:1,
    b:"string",
    c:[2,3,4]
    d:true
}

key value
a   1
b   string
c   [2,3,4]
d   true

obj.a = 1
obj.b = string


**Function, if - else, loops(for, while)** - video - 4

1) Functions:

function(keyword) printHelloWorld() (name of the function) {
    console.log()
}

2) Problems:
odd or even, vote(above 18), sum

**Loops 01** - Video - 5

1) If we need to do the same things for that we use the loops.

2) problems:
    1) Print hello world 5 times

        for(i=0;i<5;i++){
            console.log("top", i)
            console.log("hello world", i)
            console.log("down", i)
        }

        output :

            top 0
            hello world 0
            down 0
            top 1
            hello world 1
            down 1
            top 2
            hello world 2
            down 2
            top 3
            hello world 3
            down 3
            top 4
            hello world 4
            down 4
            top 5
            hello world 5
            down 5

         How **for-loop** works :
            for(initialize a variable(let i = 0);condition(i<5);increment change(i++(i=i+1)))
                        console
            i=0          hello world
            i=1          hello world
            i=2          hello world
            i=3          hello world
            i=4          hello world
            i=5             Fails

2) While loop : 

    let i =0;
    while(i<5){
        console.log("hello world");
        i++;
    }

**IMP**
**In javascript "Infinity" is bigger than any number.
In javascript "-Infinity" is smaller than any number.**