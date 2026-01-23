**Plaindrome** : Video - 11

function palindromeCheck(num){
    const a = num;
    let reverse = " "
    while(num>0){
        reverse += (num%10)
        num = Math.floor(num/10)
    }
    return reverse == a;
}


    OR

function palindromeChceck(num){
    const a = num;
    let rev = 0;
    while(num>0){
        rev = (rev*10) + (num%10)
        num = Math.floor(num/10)
    }
    return rev == a;
}

last digit = n%10
remove last digit = n/10

**Reverse Integer** : video - 12

function reverseInteger(x) {
    const xCopy = x;
    let rev = 0;
    x=Math.abs(x)
    while(x>0){
        rev = (10*rev) + (x%10)
        x = Math.floor(x/10)
    }
    if(rev > 2**31) return 0;
    return xCopy < 0 ? -rev : rev;
}

console.log(Math.abs(-121)) ==> 121;
console.log(Math.floor(20.5)) ==> 20;