// Challenge 5: Reverse an array manually

function reverseArray(arr) {
    let reversed = [];

    for (let i = arr.length - 1; i >= 0; i--) {
        reversed.push(arr[i]);
    }

    return reversed;
}

// Test
const myArray = [10, 20, 30, 40, 50];
console.log(reverseArray(myArray));  

// Expected: [50, 40, 30, 20, 10]
