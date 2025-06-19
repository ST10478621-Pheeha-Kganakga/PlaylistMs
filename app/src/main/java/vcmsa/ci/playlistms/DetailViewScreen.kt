package vcmsa.ci.playlistms

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class DetailViewScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_view_screen)

        val btnRestart: Button = findViewById(R.id.btnRestart)
        val textDisplay: TextView = findViewById(R.id.tvDisplay)
        val avgRating = if(ratings.isNotEmpty())
        ratings.average() else 0.0

        btnRestart.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //Code Attribution rv
        //This method was taken from stack overflow
        //https://stackoverflow.com/questions/78914727/java-for-loop-vs-kotlin-for-loop
        //broot
        //https://stackoverflow.com/user/448875/broot
        //This FOR LOOP calculates the songs information
        val songInfo = buildString {
            for (i in songTitles.indices){
                append("Title: ${songTitles[i]}\n")
                append("Artist: ${artistNames[i]}\n")
                append("Rating: ${ratings[i]}\n")
                append("Comment: ${userComments[i]}\n\n")
            }
            append("Average Rating: %.2f".format(avgRating))
        }
        textDisplay.text = songInfo
    }
}