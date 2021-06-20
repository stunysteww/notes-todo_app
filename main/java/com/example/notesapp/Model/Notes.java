package com.example.notesapp.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notes_Database")
public class Notes {
    @PrimaryKey(autoGenerate = true)
    public  int id;
@ColumnInfo(name = "notes_tittle")
public  String notesTittle;

    @ColumnInfo(name = "notes_subtittle")

    public   String notesSubTittle;

    @ColumnInfo(name = "notes_date")
    public  String notesDate;

    @ColumnInfo(name = "notes")
    public   String notes;

    @ColumnInfo(name = "notes_priority")

    public String notesPriority;


}
