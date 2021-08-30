// defines object with custom type properties
interface Dimensions {
    x: number;
    y: number;
}

const draw = (dimes: Dimensions) => {

}

// must pass object in curly bracket
draw ({
    x: 20,
    y: 10
})

class Draw {
    x: number;
    y: number;

    draw() {
        //
    }
}