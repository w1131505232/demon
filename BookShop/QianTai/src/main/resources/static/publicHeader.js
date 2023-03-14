console.log("--------publicHeaderApp--------")

let publicHeaderApp = new Vue({
    el: "#publicHeaderApp",
    data: {
        bookTypeList: [],
        currentUserAccount:''
    },
    methods: {
        initBookTypeList() {

            let vueObj = this;

            $.get("/booktype/all", function (data) {
                console.log(data)
                vueObj.bookTypeList = data;
            })

        }
        ,
        seeBooksOfType(bookTypeId){
            sessionStorage.setItem("seeBooksOfType",bookTypeId)
            location.href = "/booksOfType.html"
        }
        ,
        initCurrentUserAccount(){
            let vueObj = this;
            $.post("/user/getCurrentUserAccount",function (data) {
                console.log("当前用户名 "+data)
                vueObj.currentUserAccount = data;
            })
        }
        ,
        toLogout(){
            $.post("/user/logout",function (data) {
                location.href="/"
            })
        }
    },
    created() {
        this.initBookTypeList();
        this.initCurrentUserAccount();
    }
})



