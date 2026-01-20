**Loopp within a loop** - video - 8

1) for(i=0;i<5;i++){
    for(j=0;j<5;i++){
        console.log("i ="+i + "j ="+j)
    }
}

i = 0 j = 0
i = 0 j = 1
i = 0 j = 2
i = 0 j = 3
i = 0 j = 4
i = 1 j = 0    
i = 2 j = 1
i = 2 j = 2
i = 2 j = 3
i = 2 j = 4
i = 3 j = 0
i = 3 j = 1
i = 3 j = 2
i = 3 j = 3
i = 3 j = 4
i = 4 j = 0
i = 4 j = 1
i = 4 j = 2
i = 4 j = 3
i = 4 j = 4 

2) for(i=0;i<3;i++){
    for(j=0;j<i;j++){
        console.log("i =" + i + "j="+j)
    }
}

i = 1 j = 0
i = 2 j = 0
i = 2 j = 1 

3) for(i=0;i<5;i++){
    for(j=0;j<=i;j++){
        consol.log("i= "+ i + "j= " + j)
    }
}

i = 0 j = 0
i = 1 j = 0
i = 1 j = 1
i = 2 j = 0
i = 2 j = 1
i = 2 j = 2
i = 3 j = 0
i = 3 j = 1
i = 3 j = 2
i = 3 j = 3
i = 4 j = 0
i = 4 j = 1
i = 4 j = 2
i = 4 j = 3
i = 4 j = 4 

4) for(i=0;i<3;i++){
    for(j=i;j>0;j--){
        console.log("i= "+ i "j= "+ j)
    }
}

i = 1 j = 1
i = 2 j = 2
i = 2 j = 1

5) for(i=0;i<3;i++){
    for(j=i;j<=0;j--){
        console.log("i= "+ i + "j= "+ j)
    }
}

i = 0 j = 0
i = 0 j = infinity

6) for(i=5;i>0;i--){
    for(j=0;j<i;j++){
        console.log("i= " + i + "j= " + j)
    }
}

i = 5 j = 0
i = 5 j = 1
i = 5 j = 2
i = 5 j = 3
i = 5 j = 4
i = 4 j = 0
i = 4 j = 1
i = 4 j = 2
i = 4 j = 3
i = 3 j = 0
i = 3 j = 1
i = 3 j = 2
i = 2 j = 0
i = 2 j = 1
i = 1 j = 0

7) for(i=0;i<5;i++){
    let row = " "
    for(j=0;j<5;j++){
        row += "* "
    }
    console.log(row)
}


5 5 5 5 5


* * * * *
* * * * *
* * * * *
* * * * *
* * * * *

8) for(i=0;i<=0;i++){
    let row = " "
    for(j=0;j<5;j++){
        row += "* "
        console.log(row)
    }
}


9) for(i=0;i<n;i++){
    for(j=0;j<=i;j++){
        row += (j+1)
    }
}

    1) i = 0, j = 0 , row = 0+1(j+1) = 1
    2) i = 1, j = 0 , row = 0+1(j+1) = 1
              j = 1 , row = 1+1(j+1) = 2
1 
1 2
1 2 3
1 2 3 4

10) let n=4
for(i=0;i<n;i++){
    let row = ""
    for(j=0;j<=i;j++){
        row += (i+1)
    }
    console.log(row)
}