1) Math.floor()
2) Math.abs()
3) Math.max()
4) "123" -> console.log(a.split('')) => ['1', '2', '3'] --> console.log(a.split(' ')) => ["123"]
5) "d1f2" -> console.log(a.split('')) => ['d', '1', 'f', '3'] -> console.log(a.split('').map(Number)) => [NaN, 1, NaN, 2] -> console.log(a.split('').map(Number))
6) let a = "d1f4"

const array = a.split('')

console.log(a.split('').map(Number).filter(a => typeof a === 'number' && !Number.isNaN(a))) 

[1, 4]

let a = "d1f4"

const array = a.split('')

console.log(a.split('').filter(a => typeof a === 'string' && !Number.isNaN(a)))

['d','1','f', '4']

7) let a= [1, 0, 6, 4, 9, 2]

console.log(a.sort(a, b) => a-b) => [0, 1, 2, 4, 6, 9]
console.log(a.sort(a,b) => b-a) => [9, 6, 4, 2, 1, 0]