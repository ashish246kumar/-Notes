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
Describe the difference between a cookie, sessionStorage and localStorage in browser?
Cookies: Suitable for server-client communication, small storage capacity, can be persistent or session-based, domain-specific. Sent to the server on every request.
localStorage: Suitable for long-term storage, data persists even after the browser is closed, accessible across all tabs and windows of the same origin, highest storage capacity among the three.
sessionStorage: Suitable for temporary data within a single page session, data is cleared when the tab or window is closed, has a higher storage capacity compared to cookies.
*************************
Explain how this keyword works in JavaScript ?

*******************
When this is used inside an object method, it refers to that object.

const person = {
    name: "Ashish",
    greet: function () {
        console.log(this.name); // "Ashish"
    }
};
person.greet();
******
When this is used in the global scope (outside any function), it refers to the global object:

In browser, the global object is window.
Arrow functions do not have their own this. Instead, they inherit this from their surrounding (lexical) scope.
const person = {
    name: "Ashish",
    greet: () => {
        console.log(this.name); // undefined (because arrow function doesn't bind `this`)
    }
};
person.greet();
****************************************************************************************************************
What's the difference between a JavaScript variable that is: null, undefined or undeclared?

undefined
Meaning:

A variable is undefined when it has been declared but not assigned a value.
It is also the default return value of functions that do not explicitly return anything.
Type:
typeof undefined returns 'undefined'.
Equality Comparison:
undefined == null is true (due to type coercion).
undefined === null is false (strict equality checks both value and type


 null
Meaning:
null is a value that is explicitly set by the developer to indicate that a variable has no value or no object.
Type:
typeof null returns 'object' (this is a historical bug in JavaScript).
Equality Comparison:
null == undefined is true (due to type coercion).
null === undefined is false (strict equality checks both value and type).


undeclared
Meaning:
A variable is undeclared if it has not been declared at all using var, let, or const.
Type:
Accessing an undeclared variable throws a ReferenceError.
typeof on an undeclared variable returns 'undefined' (this is a special behavior of typeof).
Equality Comparison:
Trying to compare or access an undeclared variable throws a ReferenceError.
************************************************************************************************
What advantage is there for using the JavaScript arrow syntax for a method in a constructor?

When you use the arrow syntax (=>) for a method inside a constructor in JavaScript, it makes sure that the method always remembers which object it belongs to.
class Person {
  constructor(name) {
    this.name = name;
  }

  greet() {
    console.log(`Hello, my name is ${this.name}`);
  }
}

const p = new Person("Ashish");
const greetFn = p.greet; // Assigning method to a variable
greetFn(); // ❌ This gives "Hello, my name is undefined" because 'this' is lost
**********
class Person {
  constructor(name) {
    this.name = name;
    this.greet = () => {
      console.log(`Hello, my name is ${this.name}`);
    };
  }
}

const p = new Person("Ashish");
const greetFn = p.greet;
greetFn(); // ✅ Works fine! Prints "Hello, my name is Ashish"
***********************************************************************************
What's the difference between .call and .apply in JavaScript?

.call and .apply are both used to invoke functions with a specific this context and arguments. The primary difference lies in how they accept arguments:
.call(thisArg, arg1, arg2, ...): Takes arguments individually.
.apply(thisArg, [argsArray]): Takes arguments as an array.

function add(a, b) {
  return a + b;
}

console.log(add.call(null, 1, 2)); // 3
console.log(add.apply(null, [1, 2])); // 3
**********
Explain Function.prototype.bind in JavaScript  
********
.bind() locks a function to a specific object so that when the function runs, the this keyword inside it always refers to that object, no matter how or where the function is called.
const person = {
  name: "Ashish",
  greet: function () {
    console.log(`Hello, my name is ${this.name}`);
  }
};

const greetFn = person.greet; // Copying the method
greetFn(); // ❌ This gives "Hello, my name is undefined"
const greetFnBound = person.greet.bind(person);
greetFnBound(); // ✅ Works! Prints "Hello, my name is Ashish"
****************************************************************************************************************************


