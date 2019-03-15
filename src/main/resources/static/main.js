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
                .then(response => (this.searchResults = response.data.docs));

                for (var i = 0; i < this.searchResults.length; i++) {

//                    var currentBook = {};

                    if (this.searchResults[i].isbn) {
                        axios
                            .get("http://openlibrary.org/api/books?bibkeys=ISBN:" + this.searchResults[i].isbn[0] + "&format=json")
                            .then(response => (currentBook = response.data.docs));

                            this.bookList.push(currentBook);
                    }
                }

            this.showAddBookForm = false;

        }
    }
});