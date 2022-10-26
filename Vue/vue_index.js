window.onload = function () {
    const {createApp} = Vue
    createApp({
        data() {
            return {
                msg: "Hello Vue",
                username: "Input",
                flag: false
            }
        },
        methods: {
            getText: function () {
                alert(this.username);
            },
            setText: function () {
                this.msg = "This is a new division...";
            },
            changeFlag: function () {
                this.flag = !this.flag;
            }
        }
    }).mount("#app02")
}