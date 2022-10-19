const user = {
    username: "junil",
    printUsername: function() {
        console.log("printUsername : " + this.username);
        const testPrint = () => {
            console.log("testPrint : " + this.username);
        }
        testPrint();
    }
};

let username = "test";

user.printUsername();