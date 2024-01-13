# BookApp
This app displays a list of books loaded from a remote API.

Project Setup
The project uses Kotlin and follows MVVM architecture.

The main components are:

ApiService - Interface for Retrofit API calls to fetch book data
Book - Data class to represent a book
BookAdapter - RecyclerView adapter to display a list of books
MainActivity - Displays the list of books
RetrofitInstance - Provides configured Retrofit instance with API url
Steps
Define the Book data class
Create the ApiService interface for API calls
Setup the RetrofitInstance object to provide the Retrofit instance
Make API call from MainActivity using ApiService to fetch list of books
Pass list of books to the BookAdapter
Set the adapter on the RecyclerView in MainActivity to display books
Use Glide in the BookAdapter to load book image thumbnails
Handle loading and error cases
