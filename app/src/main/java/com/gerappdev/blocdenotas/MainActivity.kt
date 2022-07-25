package com.gerappdev.blocdenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gerappdev.blocdenotas.Mundo.Note
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var notes: ArrayList<Note> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initviews()
    }

    private fun initviews() {
        notes_list_vam.setHasFixedSize(true)
        notes_list_vam.adapter = NotesAdapter(this.notes, this)
    }

    private fun initData() {
        for (i in 1 .. 20 ){
            notes.add(Note("Esta es la nota  $i", "$i/11/20", "Este es el contenido de la nota "))
        }
    }


}