import { useState } from 'react'
// import './App.css'

function App() {
  const [count, setCount] = useState(0)
  const [value, setValue] = useState("")
  const [textValue, setTextValue] = useState("")
  const numbers = [1, 3, 4, 6, 5, 9, 15, 9, 11]
  const [visible, setVisible] = useState(false)
  const [input, setInput] = useState("")

  const divisibleNumbers = numbers.filter((n) => n%3 == 0)

  const formatedString = (text) => {
    return text.split(" ").map((word) => {
      if(word.length == 0) return "";
      let lowerCase = word.toLowerCase()
      let lastChar = lowerCase.charAt(lowerCase.length-1).toUpperCase();
      return lowerCase.slice(0, lowerCase.length-1)+lastChar
    }).join(" ");
  }

  return (
    <>
    <div>
      <h1 style={{textAlign: 'center'}}>React Components or Questions practice</h1>
      <h2>Input</h2>
      <input
      value={value}
      placeholder='type something...'
      onChange={(e) => setValue(e.target.value)}
      />
    </div>
      <div>
        <h2>Counter</h2>
        <button onClick={() => setCount(count+1)}>
          Increase
        </button>
        <p>{value} Count {count}</p>
        <button onClick={() => setCount(count-1)}>
          Decrease
        </button>
        <button onClick={() => setCount(0)}>Reset</button>
      </div>
      <div>
        <h2>Text Area(if you enter anything in text area and in below the text will be reversed and shown)</h2>
        <textarea
        value={textValue}
        placeholder='text area...'
        onChange={(e) => setTextValue(e.target.value)}
        />
        <p>Reversed text: {textValue.split("").reverse().join("")}</p>
      </div>
      <div>
      <ul>
        <h2>Numbers divisible by 3(inside array=[1, 3, 4, 6, 5, 9, 15, 9, 11])</h2>

        {/* <p>() => (exression)</p> */}
        <p>In the below arrow function directly receives the jsx and without using the return it directly prints the expression.</p>
        {divisibleNumbers.map((num, index) => (
          <li key={index}>{num}</li>
        ))}

        {/* () => {} */}
        <p>In the below it is like the function body by using the {} so to return the jsx you have to use the return statement otherwise it will give us the undefined.</p>
        {divisibleNumbers.map((num, index) => {
          return <li key={index}>{num}</li>
        })}
      </ul>
      </div>
      <div>
        <h2>Visible or Invisible(using the toggle button)</h2>
        <button onClick={() => setVisible(!visible)}>
          Toggle button
        </button>
        {visible && (<p>Text is visible</p>)}
      </div>
      <div>
        <h2>Format Input String</h2>
        <p>slice(immutable) vs splice(mutable)</p>
        {/* const nums = [0, 1, 2, 3, 4, 5]

console.log(nums.slice(0, 3), nums)

console.log(nums.splice(0, 3), nums) */}
        <input
          value={input}
          placeholder='Type something...'
          onChange={(e) => setInput(e.target.value)}
        />
        <p>
          <span>Formated string: </span> {formatedString(input)}
        </p>
      </div>
    </>
  )
}

export default App
