import { useEffect, useState } from 'react'
// import './App.css'

function App() {
  const [count, setCount] = useState(0)
  const [value, setValue] = useState("")
  const [textValue, setTextValue] = useState("")
  const numbers = [1, 3, 4, 6, 5, 9, 15, 9, 11]
  const fruits = ['apple', 'banana', 'pineapple']
  const [visible, setVisible] = useState(false)
  const [input, setInput] = useState("")
  const [search, setSearch] = useState("")
  const [users, setUsers] = useState([]);
  const [taskInputs, setTaskInputs] = useState("")
  const [tasks, setTasks] = useState([])
  const [formInput, setFormInput] = useState("")
  const [fetchData, setFetchData] = useState([])
  const divisibleNumbers = numbers.filter((n) => n%3 == 0)
  const [loading, setLoading] = useState(false)
  const [fetchInput, setFetchInput] = useState("")
  const [techCount, setTechCount] = useState(0)
  const [techInput, setTechInput] = useState(1)
  const [techhistory, setTechHistory] = useState([])

  const formatedString = (text) => {
    return text.split(" ").map((word) => {
      if(word.length == 0) return "";
      let lowerCase = word.toLowerCase()
      let lastChar = lowerCase.charAt(lowerCase.length-1).toUpperCase();
      return lowerCase.slice(0, lowerCase.length-1)+lastChar
    }).join(" ");
  }

    const filteredFruits = fruits.filter((fruit) => fruit.toLowerCase().includes(search.toLowerCase()))

    useEffect(() => {
      fetch("https://jsonplaceholder.typicode.com/users")
      .then(res => res.json())
      .then(data => setUsers(data));
    }, []);

    function addTask(){
      setTasks([...tasks, taskInputs])
      setTaskInputs("")
    }

    const isLoggedIn = true;

    function submit(e) {
      e.preventDefault(); //  we are using this to stop the page refresh and not loosing the state date because by default the form behavior is when we click submit the form will automatically refresh or navigate the page.
      console.log(formInput, "forminputbhanu")
    }

    useEffect(() => {
      const fetchData = async () => {
        try{
          setLoading(true)
          const data = await fetch("https://jsonplaceholder.typicode.com/posts")
          const response = await data.json();
          setFetchData(response)
        }catch(error){
          console.log(error)
        } finally{
          setLoading(false)
        }
      }

      fetchData();
    }, [])

    const filteredFetchData = fetchData.filter((item) => item.title.toLowerCase().includes(fetchInput.toLowerCase()))

    function setSaveToTechHistory(prevValue) {
      setTechHistory((prev) => [...prev, prevValue])
    }

    function handleIncrement() {
      setSaveToTechHistory(techCount)
      setTechCount(techCount+techInput)
    }

    function handleDecrement() {
      setSaveToTechHistory(techCount)
      setTechCount(techCount-techInput)
    }

    function hanleReset() {
      setSaveToTechHistory(techCount)
      setTechCount(0)
    }

    function handleUndo() {
      if(techhistory.length == 0) return;
      const lastValue = techhistory[techhistory.length-1]
      setTechCount(lastValue)
      setTechHistory((prev) => prev.slice(0, -1));
    }


    function serachInput(value, deplay=500) {
      const [debounce, setDebounce] = useState(value)

      useEffect(() => {
        const timer = setTimeout(() => {
          setDebounce(value)
        }, deplay)

        return  () => {
          clearTimeout(timer)
        }
      }, [value, deplay])

      return debounce
    }
    console.log(techhistory, "techhistorybhanu")
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
      <div>
        <h2>Render a list of items</h2>
        {fruits.map((fruit, index) => (
          <li key={index}>{fruit}</li>
        ))}
        {" "}
        {fruits.map((fruit, index) => {
          return <li key={index}>{fruit}</li>
        })}
      </div>
      <div>
        <h2>Search filter</h2>
        <input
        value={search}
        placeholder='search something...'
        onChange={(e) => setSearch(e.target.value)}
        />
      {filteredFruits.map((fruit, index) => (
        <li key={index}>{fruit}</li>
      ))}
      </div>
      <div>
        <h2>Fetch data from API and display list.</h2>
        {users.map((user) => (
          <p key={user.id}>{user.name}</p>
        ))}
      </div>
      <div>
        <h2>TODO List</h2>
        <input
        value={taskInputs}
        onChange={(e) => setTaskInputs(e.target.value)}
        placeholder='add task..'
        />
        <button onClick={addTask}>
          Add
        </button>
        {tasks.map((task, index) => (
          <p key={index}>{task}</p>
        ))}
      </div>
      <div>
        <h2>Show message if user logged in.</h2>
        {isLoggedIn ? <p>Welcome</p> : <p>Please Login</p>}
      </div>
      <div>
        <h2>Handle Input Form</h2>
        <form onSubmit={submit}>
          <input
          value={formInput}
          onChange={(e) => setFormInput(e.target.value)}
          />
          <button>Submit form</button>
        </form>
      </div>
      <div>
        <h2>Fetch Api using the async and await and search the title in input</h2>
        <input
        value={fetchInput}
        placeholder='search title...'
        onChange={(e) => setFetchInput(e.target.value)}
        />
        {loading ? <p>Loading...</p> : 
        <ul>{filteredFetchData.map((data) => <li key={data.id}>{data.title}</li>)}</ul>}
      </div>
      <div>
        <h2>Techpearl question</h2>
        <p>{techCount}</p>
        <input
        value={techInput}
        onChange={(e) => setTechInput(Number(e.target.value))}
        placeholder='type something...'
        />

        <br></br>
        <button onClick={handleIncrement}>Increment</button>
        <button onClick={handleDecrement}>Decrement</button>
        <button onClick={handleUndo}>Undo</button>
        <button onClick={hanleReset}>Reset</button>
      </div>
    </>
  )
}

export default App
