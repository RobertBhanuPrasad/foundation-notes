
**Problem:** Reverse string

let arr = ['h', 'e', "l", "l", "o"] ---->  ["o", "l", "l", "e", "h"]

i = 0 replace with - n-1
i = 1 relace with n-2
i = 2 replace with n-3

i = i replace with n-1-i

function reverseString(arr){
    for(i=0;i<n/2;i++){
        let temp = arr[i]
        arr[i]=arr[arr.length-1-i]
        arr[arr.length-1-i]=arr[i]
    }
    return arr.
}


**Problem:** : Reverse word

let word = 'sky is blue in color'   ---> color in blue is sky

let word1 = word.trim().split(\/s+\) --> ['sky', 'is', 'blue', 'in', 'color']