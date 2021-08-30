// var - to declare variable
    // should not be used after ES6, because ignores scope (has global scope)
    // use 'let' instead

function test() {
    for (var i = 0; i < 5; i++){
        console.log(i);
    }
    console.log('outside scope ' + i);
}

test();
