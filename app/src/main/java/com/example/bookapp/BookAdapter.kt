import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookapp.Book
import com.example.bookapp.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


class BookAdapter (private val context: Context) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    private var books: List<Book> = emptyList()

    fun setData(books: List<Book>) {
        this.books = books
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book)
        if(book.imageUrl.isNullOrBlank()) {
            holder.bookImageView.setImageResource(R.drawable.placeholder)
        } else {
            Glide.with(context)
                .load(book.imageUrl)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(holder.bookImageView)
        }
    }

    override fun getItemCount(): Int = books.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)
        val bookImageView: ImageView = itemView.findViewById(R.id.bookImageView)
        fun bind(book: Book) {
            bookImageView.setImageResource(0)
            titleTextView.text = book.title
            authorTextView.text = book.author

        }
    }
    fun setBooks(books: List<Book>) {
        this.books = books
        notifyDataSetChanged()
    }
}
