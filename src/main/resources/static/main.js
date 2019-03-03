let app = new Vue({
    el: "#root",

    data: {
        books: {},
        bookQuery: "",
        searchResults: []
    },

    mounted() {
        // Make an ajax request

        axios
            .get(
                "https://openlibrary.org/api/books?bibkeys=ISBN:0451526538&format=json&jscmd=data"
            )
            .then(response => (this.books = response.data));
    },

    methods: {
        searchBook() {
            axios
                .get("http://openlibrary.org/search.json?title=" + this.bookQuery)
                .then(response => (this.searchResults = response.data.docs));
        }
    }
});
