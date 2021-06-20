package com.example.notesapp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.Activity.UpdateNotesActivity;
import com.example.notesapp.MainActivity;
import com.example.notesapp.Model.Notes;
import com.example.notesapp.R;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.notesViewholder> {
    MainActivity mainActivity;
    List<Notes> notes;
    List<Notes> allNotesitem;

    public NotesAdapter(MainActivity mainActivity, List<Notes> notes) {
        this.mainActivity = mainActivity;
        this.notes = notes;
        allNotesitem= new ArrayList<>(notes);

    }
public void searchNotes(List<Notes> filterredName){

        this.notes=filterredName;
        notifyDataSetChanged();

}
    @NonNull
    @Override
    public notesViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new notesViewholder(LayoutInflater.from(mainActivity).inflate(R.layout.item_notes, parent, false));
    }

    @Override
    public void onBindViewHolder(NotesAdapter.notesViewholder holder, int position) {

        Notes note = notes.get(position);

        switch (note.notesPriority) {
            case "1":
                holder.notesPriority.setBackgroundResource(R.drawable.green_shape);
                break;
            case "2":
                holder.notesPriority.setBackgroundResource(R.drawable.yellow_shape);
                break;
            case "3":
                holder.notesPriority.setBackgroundResource(R.drawable.red_shape);
                break;
        }

        holder.title.setText(note.notesTittle);
        holder.subtitle.setText(note.notesSubTittle);
        holder.notesDate.setText(note.notesDate);
        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(mainActivity, UpdateNotesActivity.class);
            intent.putExtra("id",note.id);
            intent.putExtra("title",note.notesTittle);
            intent.putExtra("subtitle",note.notesSubTittle);
            intent.putExtra("priority",note.notesPriority);
            intent.putExtra("notes",note.notes);




            mainActivity.startActivity(intent);
        });

    }
        @Override
        public int getItemCount () {
            return notes.size();
        }

        static class notesViewholder extends RecyclerView.ViewHolder {

            TextView title, subtitle, notesDate;
            View notesPriority;

            public notesViewholder(View itemView) {

                super(itemView);

                title = itemView.findViewById(R.id.notesTitle);
                notesPriority = itemView.findViewById(R.id.notesPriority);
                subtitle = itemView.findViewById(R.id.notesSubtitle);
                notesDate = itemView.findViewById(R.id.notesDate);


            }
        }

    }


