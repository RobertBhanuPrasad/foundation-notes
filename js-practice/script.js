async function gemini() {
    let query = "what is networth of google?"

    let response = await fetch("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=AIzaSyAiH1lJyi4gw3V3FS91g1FzMSSjWIv2k9c", {
        method: "POST",
        Headers: {"Content-Type" : "application/json"},
        body:JSON.stringify({
            contents:[{parts:[{text:query}]}]
        })
    })
    let data = await response.json()
    document.writeln("Question : " + query + "<br><br>")
    document.write("Answer : " + data.candidates[0].content.parts[0].text)
}

gemini()




















// fetch("https://dummyjson.com/quotes")
//     .then(response => response.json())
//     .then(data => {
//         data.quotes.forEach(quote => {
//             document.writeln(`"${quote.quote}" - ${quote.author} "<br>"`)
//         })
//     })
//     .catch(error => console.log("Error fetching the data", error)

// function printTodos(todos) {
//     todos.forEach((todo, index) => {
//         document.writeln(`${index + 1}. ${todo}`)
//     });
// }

// const todos = ["Learn JS", "Do Assignment", "Take Break"];
// printTodos(todos)




















// let totalBill = 1200;
// let people = 4;
// let perPerson = totalBill / people;

// document.write("totalbill: " +  totalBill + "<br>")
// document.write("perPerson: " +  perPerson + "<br>")

// document.write("<br>")

// let principal = 1000;
// let rate = 5;
// let time = 2;

// let SI = (principal * rate * time) / 100;

// document.write("principal: " +  principal + "<br>")
// document.write("rate: " +  rate + "<br>")
// document.write("Time: " +  time + "<br>")
// document.write("Simple Interest: " +  SI + "<br>")


