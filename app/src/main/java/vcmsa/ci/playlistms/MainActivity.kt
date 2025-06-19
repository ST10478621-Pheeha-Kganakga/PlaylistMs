package vcmsa.ci.playlistms

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


val songTitles = mutableListOf<String>()
val artistNames = mutableListOf<String>()
val ratings = mutableListOf<Int>()
val userComments = mutableListOf<String>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //I have set variables to their ID's
        val addPlay: Button = findViewById(R.id.addPlay)
        val btnNext: Button = findViewById(R.id.btnNext)
        val btnExit: Button = findViewById(R.id.btnExit)

        //This button is set to give information of the artists and name of songs
        addPlay.setOnClickListener{
           showAddDialog()
        }

        //This button moves from the MainActivity to DetailViewScreen
        btnNext.setOnClickListener{
            val intent = Intent(this, DetailViewScreen::class.java)
            startActivity(intent)
        }

        //This button closes the program
        btnExit.setOnClickListener {
            finishAffinity()
        }
    }


    //This private fun provides the information that has to be set on the addPlay button
    @SuppressLint("MissingInflatedId")
    private fun showAddDialog() {
        val dialogView = layoutInflater.inflate(R.layout.add_song_dialog,null)
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
            .setTitle("Please add a song")
            .setPositiveButton("Save"){_, _ ->
                val titleInput = dialogView.findViewById<EditText>(R.id.edtSongTitle).text.toString()
                val artistName = dialogView.findViewById<EditText>(R.id.edtArtist).text.toString()
                val ratingInput = dialogView.findViewById<EditText>(R.id.edtRating).text.toString().toIntOrNull() ?: 0
                val commentInput = dialogView.findViewById<EditText>(R.id.edtComment).text.toString()

                songTitles.add(titleInput)
                artistNames.add(artistName)
                ratings.add(ratingInput)
                userComments.add(commentInput)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }


}