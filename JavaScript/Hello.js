window.onload = function () {
    let btn01 = document.getElementById("btn-01");
    btn01.onclick = function () {
        // alert("Oops! No!!!")
        let a = NaN;
        if (a) {
            console.log(a);
            let res = confirm("oops!");
            console.log("Output..." + res);
        }

        function foo() {
            alert("f01");
            return 10;
        }

        let ret = foo();
        console.log(ret);

        let obj01 = {
            id: 123,
            name: "Jae",
            log: function () {
                alert("Hey.");
            }
        };

        console.log(obj01.id);

        obj01.foo = function () {
            console.log(this.name + " foo func");
        }
        obj01.foo();

        let arr = [];
        arr[0] = 1;
        arr[1] = "2";
        arr.push(null);

        for (let i = 0; i < arr.length; i++) {
            console.log(arr[i]);
        }

    }
}

