# JavaScript Interview Coding Problems

> **Reference:** [sudheerj/javascript-interview-questions](https://github.com/sudheerj/javascript-interview-questions?tab=readme-ov-file)

---

## Part 1 - Core Problems

---

### 1. Reverse a String (Very Common)

**Problem:** Reverse a string.

| Input | Output |
|-------|--------|
| `"hello"` | `"olleh"` |

**Approach:**
1. Start from last character
2. Append each character to new string
3. Continue until index 0

```javascript
function reverseString(str){
  let result = "";
  for(let i = str.length - 1; i >= 0; i--){
    result = result + str[i];
  }
  return result;
}

console.log(reverseString("hello"));
```

> **Time Complexity:** O(n)

---

### 2. Check Palindrome

**Problem:** Check if string is palindrome.

| Input | Output |
|-------|--------|
| `"madam"` | `true` |

**Approach:**
1. Compare first and last characters
2. Move inward
3. If mismatch return false

```javascript
function isPalindrome(str){
  let left = 0;
  let right = str.length - 1;

  while(left < right){
    if(str[left] !== str[right]){
      return false;
    }
    left++;
    right--;
  }

  return true;
}
```

---

### 3. Find Largest Number in Array

**Problem:** Find the largest number in an array.

| Input | Output |
|-------|--------|
| `[4,7,2,9,5]` | `9` |

**Approach:**
1. Assume first number is largest
2. Compare with others
3. Update max if bigger

```javascript
function findMax(arr){
  let max = arr[0];

  for(let i = 1; i < arr.length; i++){
    if(arr[i] > max){
      max = arr[i];
    }
  }

  return max;
}
```

---

### 4. Remove Duplicates from Array

**Problem:** Remove duplicate elements from an array.

| Input | Output |
|-------|--------|
| `[1,2,2,3,4,4]` | `[1,2,3,4]` |

**Approach:**
1. Create new array
2. Check if element already exists
3. If not, add it

```javascript
function removeDuplicates(arr){
  let result = [];

  for(let i = 0; i < arr.length; i++){
    let exists = false;

    for(let j = 0; j < result.length; j++){
      if(arr[i] === result[j]){
        exists = true;
        break;
      }
    }

    if(!exists){
      result[result.length] = arr[i];
    }
  }

  return result;
}
```

---

### 5. Count Character Frequency

**Problem:** Count how many times each character appears.

| Input | Output |
|-------|--------|
| `"apple"` | `a:1, p:2, l:1, e:1` |

**Approach:**
1. Create empty object
2. Loop through string
3. Increase count

```javascript
function charFrequency(str){
  let map = {};

  for(let i = 0; i < str.length; i++){
    let char = str[i];

    if(map[char] === undefined){
      map[char] = 1;
    } else {
      map[char] = map[char] + 1;
    }
  }

  return map;
}
```

---

### 6. Find Missing Number

**Problem:** Find the missing number in a sequence from 1 to n.

| Input | Output |
|-------|--------|
| `[1,2,3,5]` | `4` |

**Approach:**
1. Find expected sum using formula: `n(n+1)/2`
2. Subtract actual sum

```javascript
function missingNumber(arr, n){
  let expected = (n * (n + 1)) / 2;
  let sum = 0;

  for(let i = 0; i < arr.length; i++){
    sum = sum + arr[i];
  }

  return expected - sum;
}
```

---

### 7. Two Sum Problem

**Problem:** Find two numbers that add up to a target.

| Input | Output |
|-------|--------|
| `[2,7,11,15], target=9` | `[0,1]` |

**Approach:**
1. Store numbers in object
2. Check complement

```javascript
function twoSum(arr, target){
  let map = {};

  for(let i = 0; i < arr.length; i++){
    let complement = target - arr[i];

    if(map[complement] !== undefined){
      return [map[complement], i];
    }

    map[arr[i]] = i;
  }
}
```

---

### 8. Reverse Array

**Problem:** Reverse an array in-place.

| Input | Output |
|-------|--------|
| `[1,2,3]` | `[3,2,1]` |

```javascript
function reverseArray(arr){
  let left = 0;
  let right = arr.length - 1;

  while(left < right){
    let temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;

    left++;
    right--;
  }

  return arr;
}
```

---

### 9. Factorial

**Problem:** Find the factorial of a number.

| Input | Output |
|-------|--------|
| `5` | `120` |

```javascript
function factorial(n){
  let result = 1;

  for(let i = 1; i <= n; i++){
    result = result * i;
  }

  return result;
}
```

---

### 10. Check Anagram

**Problem:** Check if two strings are anagrams of each other.

| Input | Output |
|-------|--------|
| `"listen", "silent"` | `true` |

```javascript
function isAnagram(a, b){
  if(a.length !== b.length){
    return false;
  }

  let count = {};

  for(let i = 0; i < a.length; i++){
    let char = a[i];
    if(count[char]){
      count[char]++;
    } else {
      count[char] = 1;
    }
  }

  for(let i = 0; i < b.length; i++){
    let char = b[i];
    if(!count[char]){
      return false;
    }
    count[char]--;
  }

  return true;
}
```

---

### 11. Find Second Largest Number

**Problem:** Find the second largest number in an array.

```javascript
function secondLargest(arr){
  let first = -Infinity;
  let second = -Infinity;

  for(let i = 0; i < arr.length; i++){
    if(arr[i] > first){
      second = first;
      first = arr[i];
    } else if(arr[i] > second && arr[i] !== first){
      second = arr[i];
    }
  }

  return second;
}
```

---

### 12. FizzBuzz

**Problem:** Print numbers 1-100 with rules:
- Divisible by 3 → `"Fizz"`
- Divisible by 5 → `"Buzz"`
- Divisible by both 3 & 5 → `"FizzBuzz"`

```javascript
for(let i = 1; i <= 100; i++){
  if(i % 3 === 0 && i % 5 === 0){
    console.log("FizzBuzz");
  } else if(i % 3 === 0){
    console.log("Fizz");
  } else if(i % 5 === 0){
    console.log("Buzz");
  } else {
    console.log(i);
  }
}
```

---

### 13. Linear Search

**Problem:** Search for a target in an array, return its index.

```javascript
function search(arr, target){
  for(let i = 0; i < arr.length; i++){
    if(arr[i] === target){
      return i;
    }
  }
  return -1;
}
```

---

## Part 2 - Practice Problems

---

### 1. Find the Sum of Array Elements

**Problem:** Return the sum of all numbers in an array.

| Input | Output |
|-------|--------|
| `[1,2,3,4]` | `10` |

```javascript
function arraySum(arr){
  let sum = 0;

  for(let i = 0; i < arr.length; i++){
    sum = sum + arr[i];
  }

  return sum;
}

console.log(arraySum([1,2,3,4]));
```

---

### 2. Count Even Numbers in Array

| Input | Output |
|-------|--------|
| `[1,2,3,4,6]` | `3` |

```javascript
function countEven(arr){
  let count = 0;

  for(let i = 0; i < arr.length; i++){
    if(arr[i] % 2 === 0){
      count++;
    }
  }

  return count;
}
```

---

### 3. Find Smallest Number

| Input | Output |
|-------|--------|
| `[7,3,9,2,5]` | `2` |

```javascript
function findMin(arr){
  let min = arr[0];

  for(let i = 1; i < arr.length; i++){
    if(arr[i] < min){
      min = arr[i];
    }
  }

  return min;
}
```

---

### 4. Reverse Words in Sentence

| Input | Output |
|-------|--------|
| `"hello world"` | `"world hello"` |

```javascript
function reverseWords(str){
  let words = str.split(" ");
  let result = "";

  for(let i = words.length - 1; i >= 0; i--){
    result += words[i];
    if(i !== 0){
      result += " ";
    }
  }

  return result;
}
```

---

### 5. Count Vowels in String

| Input | Output |
|-------|--------|
| `"hello"` | `2` |

```javascript
function countVowels(str){
  let vowels = "aeiou";
  let count = 0;

  for(let i = 0; i < str.length; i++){
    for(let j = 0; j < vowels.length; j++){
      if(str[i] === vowels[j]){
        count++;
      }
    }
  }

  return count;
}
```

---

### 6. Check if Array is Sorted

| Input | Output |
|-------|--------|
| `[1,2,3,4]` | `true` |

```javascript
function isSorted(arr){
  for(let i = 0; i < arr.length - 1; i++){
    if(arr[i] > arr[i + 1]){
      return false;
    }
  }

  return true;
}
```

---

### 7. Find Index of Element

| Input | Output |
|-------|--------|
| `[4,7,1,9], target=1` | `2` |

```javascript
function findIndex(arr, target){
  for(let i = 0; i < arr.length; i++){
    if(arr[i] === target){
      return i;
    }
  }

  return -1;
}
```

---

### 8. Count Words in Sentence

| Input | Output |
|-------|--------|
| `"I love coding"` | `3` |

```javascript
function countWords(str){
  let count = 1;

  for(let i = 0; i < str.length; i++){
    if(str[i] === " "){
      count++;
    }
  }

  return count;
}
```

---

### 9. Find Duplicate Elements

| Input | Output |
|-------|--------|
| `[1,2,3,2,4]` | `[2]` |

```javascript
function findDuplicates(arr){
  let duplicates = [];

  for(let i = 0; i < arr.length; i++){
    for(let j = i + 1; j < arr.length; j++){
      if(arr[i] === arr[j]){
        duplicates.push(arr[i]);
      }
    }
  }

  return duplicates;
}
```

---

### 10. Flatten Simple Nested Array

| Input | Output |
|-------|--------|
| `[1,[2,3],4]` | `[1,2,3,4]` |

```javascript
function flatten(arr){
  let result = [];

  for(let i = 0; i < arr.length; i++){
    if(Array.isArray(arr[i])){
      for(let j = 0; j < arr[i].length; j++){
        result.push(arr[i][j]);
      }
    } else {
      result.push(arr[i]);
    }
  }

  return result;
}
```

---

### 11. Capitalize First Letter

| Input | Output |
|-------|--------|
| `"hello"` | `"Hello"` |

```javascript
function capitalize(str){
  let first = str[0].toUpperCase();
  let rest = "";

  for(let i = 1; i < str.length; i++){
    rest += str[i];
  }

  return first + rest;
}
```

---

### 12. Find Longest Word

| Input | Output |
|-------|--------|
| `"I love programming"` | `"programming"` |

```javascript
function longestWord(str){
  let words = str.split(" ");
  let longest = "";

  for(let i = 0; i < words.length; i++){
    if(words[i].length > longest.length){
      longest = words[i];
    }
  }

  return longest;
}
```

---

### 13. Generate Fibonacci Series

| Input | Output |
|-------|--------|
| `5` | `0 1 1 2 3` |

```javascript
function fibonacci(n){
  let a = 0;
  let b = 1;

  console.log(a);
  console.log(b);

  for(let i = 2; i < n; i++){
    let next = a + b;
    console.log(next);
    a = b;
    b = next;
  }
}
```

---

### 14. Swap Two Numbers

| Input | Output |
|-------|--------|
| `a=5, b=10` | `a=10, b=5` |

```javascript
function swap(a, b){
  let temp = a;
  a = b;
  b = temp;

  console.log(a, b);
}
```

---

### 15. Find Sum of Digits

| Input | Output |
|-------|--------|
| `123` | `6` |

```javascript
function sumDigits(num){
  let sum = 0;

  while(num > 0){
    sum = sum + (num % 10);
    num = Math.floor(num / 10);
  }

  return sum;
}
```

---

## Most Likely Coding Topics in Tests

For frontend developer tests, companies mostly give problems from:

- Arrays
- Strings
- Loops
- Objects
- Frequency counting
- Duplicates
- Reversing
- Sorting logic