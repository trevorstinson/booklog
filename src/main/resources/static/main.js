let app = new Vue({
    el: "#root",

    data: {
        books: {},
        bookQuery: "",
        searchResults: [],
        showAddBookForm: true,
    },

    methods: {
        searchBook() {
            axios
                .get("http://openlibrary.org/search.json?jscmd=data&title=" + this.bookQuery)
                .then(response => (this.searchResults = response.data.docs));

            this.showAddBookForm = false;

        }
    }
});
