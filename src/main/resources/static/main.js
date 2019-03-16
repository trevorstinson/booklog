let app = new Vue({
    el: "#root",

    data: {
        bookQuery: "",
        searchResults: [],
        showAddBookForm: true,
        bookList: []
    },

    methods: {
        searchBook() {
            axios
                .get("http://openlibrary.org/search.json?jscmd=data&title=" + this.bookQuery)
                .then(response => {
                    this.searchResults = response.data.docs
                        .filter(searchResult => searchResult.hasOwnProperty("isbn"))
                        .filter(searchResult => searchResult.isbn[0].indexOf(" ") == -1);

                    const isbns = this.searchResults.map(searchResult => `ISBN:${searchResult.isbn[0]}`).join(',');

                    axios
                        .get("http://openlibrary.org/api/books?bibkeys=" + isbns + "&jscmd=data&format=json")
                        .then(response => {
                            console.dir(response.data);
                            this.$set(this, "bookList", Object.values(response.data));
                        });
                })

            this.showAddBookForm = false;

        }
    }
});