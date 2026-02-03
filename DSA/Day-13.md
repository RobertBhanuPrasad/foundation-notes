**Move zeroes** :

we can use the Math.max(x, y) - to find the maximun value between the two numbers.

**Asecending order** : 
    nums.sort((a, b) => a-b)

**Descending order** :
    nums.sort((a, b) => b-a)


**Bitwise XOR operator** :

🔑 What is XOR ( ^ )?

    XOR is a bitwise operator. It compares bits of two numbers.

    XOR Rules:
    A	B	  A ^ B
    0	0	    0
    0	1	    1
    1	0	    1
    1	1	    0

**Important Properties**:
    ✅ 1. Same numbers cancel out
    5 ^ 5 = 0

    ✅ 2. Any number XOR 0 = same number
    5 ^ 0 = 5

    ✅ 3. Order does NOT matter
    2 ^ 3 = 3 ^ 2


    This is why this trick works!