let app = new Vue({
    el: "#root",

    data: {
        books: {},
        bookQuery: "",
        searchResults: [],
        showAddBookForm: false,
    },

    mounted() {
        // Make an ajax request

//        axios
//            .get(
//                "https://openlibrary.org/api/books?bibkeys=ISBN:0451526538&format=json&jscmd=data"
//            )
//            .then(response => (this.books = response.data));
    },

    methods: {
        searchBook() {
            axios
                .get("http://openlibrary.org/search.json?jscmd=data&title=" + this.bookQuery)
                .then(response => (this.searchResults = response.data.docs));
        },
//        injectBookData() {
//            axios
//                .get("https://openlibrary.org/api/books?bibkeys=ISBN:"0201558025,LCCN:93005405&format=json")
//
//
//        }
    }
});
