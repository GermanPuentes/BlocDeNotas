package com.gerappdev.blocdenotas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gerappdev.blocdenotas.Mundo.Constants
import com.gerappdev.blocdenotas.R
import kotlinx.android.synthetic.main.activity_note_detail.*

class NoteDetail : AppCompatActivity() {

    var title: String? = null
    var date: String? = null
    var content: String? = null
    
    companion object {
        @JvmStatic
        fun start(context: Context, title: String, creationDate: String, content: String) {
             val starter = Intent(context, NoteDetail::class.java)
                .putExtra(Constants.NOTE_TITLE_KEY, title)
                 .putExtra(Constants.NOTE_DATE_KEY, creationDate)
                 .putExtra(Constants.NOTE_CONTENT_KEY, content)
            context.startActivity(starter)
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)


        if (intent != null) {
            title = intent.getStringExtra(Constants.NOTE_TITLE_KEY)
            date = intent.getStringExtra(Constants.NOTE_TITLE_KEY)
            content = intent.getStringExtra(Constants.NOTE_CONTENT_KEY)

            initViews()
        }
    }

    private fun initViews() {
        noteTitle_an.text = this.title
        noteDate_an.text = this.date
        noteContent_an.text  = this.content
    }
}