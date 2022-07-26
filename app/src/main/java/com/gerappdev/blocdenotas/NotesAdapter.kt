package com.gerappdev.blocdenotas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gerappdev.blocdenotas.Mundo.Note

class NotesAdapter (notes: ArrayList<Note>, context: Context): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>(){

    val notes = notes
    val context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return  NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.note_item, parent, false))
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(this.notes.get(position), context)
    }

    override fun getItemCount(): Int  = this.notes.size


//Este es el viewHolder
    class NotesViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

        var container: LinearLayout? = null
        var title: TextView? = null
        var content: TextView? = null
        var date: TextView? = null

        init {
            container = itemView.findViewById(R.id.item_Container)
            title = itemView.findViewById(R.id.TxtV_noteTitle_am)
            content = itemView.findViewById(R.id.TxtV_noteContent_am)
            date = itemView.findViewById(R.id.TxtV_noteDate_am)
        }

    fun bind(note: Note, contex: Context){
        title?.text = note.title
        content?.text = note.content
        date?.text = note.date

        container?.setOnClickListener{
            NoteDetail.start(contex, note.title, note.date, note.content)
        }

    }

    }


}