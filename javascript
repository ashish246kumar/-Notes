argument-jo value hum call karte time pass karte hai
parameter:jo value hum method defination me recieve karte hai 

Explain the concept of "hoisting" in JavaScript?
Hoisting is a JavaScript mechanism where variable and function declarations are moved ("hoisted") to the top of their containing scope during the compile phase.
Variable declarations (var): Declarations are hoisted, but not initializations. The value of the variable is undefined if accessed before initialization.
Variable declarations (let and const): Declarations are hoisted, but not initialized. Accessing them results in ReferenceError until the actual declaration is encountered.
***********************************
What are the differences between JavaScript variables created using let, var or const?

In JavaScript, let, var, and const are all keywords used to declare variables, but they differ significantly in terms of scope, initialization rules, whether they can be redeclared or reassigned and the behavior when they are accessed before declaration:
Behavior	var	let	const
Scope	Function or Global	Block	Block
Initialization	Optional	Optional	Required
Redeclaration	Yes	No	No
Reassignment	Yes	Yes	No
Accessing before declaration	undefined	ReferenceError	ReferenceError
***********************************
What is the difference between == and === in JavaScript?
== is the abstract equality operator while === is the strict equality operator. The == operator will compare for equality after doing any necessary type conversions. 
The === operator will not do type conversion, so if two values are not the same type === will simply return false.

Compares two values for equality without type coercion.
console.log(5 == "5"); // true (string "5" is coerced to number
console.log(5 === "5"); // false (number vs string)

******************************************************************************************************
what is event loop in javascript
since javascript is a single threaded synchronous language.so it means woh ek bar me ek hi kam kar sakti hai .so jo  humra javascript ka execution hota hai woh call stack se hota hai
toh koi bhi code humrara javascript me phele call stack me ata hai then it execute from there. but agar javascript humara single threaded hai then how it is doing asynchrnous task.
like settimeout and fetchApi. toh iske liye hymare pas webapi hai . so jo humara asynchronous wala task hai woh call stack me ayega phele then webapi me chala jayga.uske bad jo humara 
synchronous wala code hai woh one by one execute hote rehega . jaiste humara 2 sec pura hojayga settimeout wala code call back queue me aa jayga  me aa jayga 

***********
JavaScript has an Event Loop that continuously checks the Call Stack and the Callback Queue.
The Call Stack processes synchronous tasks, one by one.
Once the synchronous code in the Call Stack is finished executing, the Event Loop picks up tasks from the Callback Queue and pushes them onto the Call Stack for execution
This allows JavaScript to perform asynchronous tasks without blocking the main execution thread.


******************************************************************
what is Event deligation?
Event delegation is a powerful technique in JavaScript where you attach a single event listener to a parent element to manage events for all of its child elements.
Efficiency:
Instead of attaching event listeners to each child element, you attach a single listener to the parent. This reduces memory usage and improves performance, especially for large lists or dynamically added elements
<ul id="myList">
  <li>Item 1</li>
  <li>Item 2</li>
  <li>Item 3</li>
</ul>
// Get the parent element
var parentList = document.getElementById("myList");

// Attach event handler to the parent element
parentList.addEventListener("click", handleItemClick);

// Event handler function
function handleItemClick(event) {
  // event.target is the element that was clicked
  var target = event.target;

  // Check if the clicked element is an <li>
  if (target.tagName === "LI") {
    console.log("Clicked:", target.textContent);
  }
}
****************************************************************************************************

******************


