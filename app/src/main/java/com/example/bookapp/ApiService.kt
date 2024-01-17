import com.example.bookapp.Book
import retrofit2.http.GET

interface ApiService {
    @GET("legacy/books")
    suspend fun getBooks(): List<Book>
}

