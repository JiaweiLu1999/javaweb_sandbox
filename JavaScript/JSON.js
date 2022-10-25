let json01 = {
    id: 103,
    name: "Jay",
    age: 22,
    school: "CU",
    lesson: {
        id: "COMS6156",
        price: 2000,
        students: ["jae", "di", "chen"],
        hw: [
            {id: 0, name: "hw00"},
            {id: 1, name: "hw01"}
        ]
    }
}

let str = JSON.stringify(json01);
console.log(str);

let obj = JSON.parse(str);
console.log(obj);

window.onload = function () {
    // let btn01 = document.getElementById("btn-01");
    // btn01.onclick = function () {
    //     let li = document.createElement("p");
    //     li.innerText = "New List Item";
    //     document.body.appendChild(li);
    //
    // }
    //
    // console.log(btn01.nextSibling + " ");

    // let div01 = document.getElementById("div-01");
    // console.log(div01.innerText);
    //
    // div01.innerText = "change div text..."
}

function foo() {
    alert("f01");
    return 10;
}




