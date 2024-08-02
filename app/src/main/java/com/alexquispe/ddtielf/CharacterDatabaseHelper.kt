package com.alexquispe.ddtielf

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class CharacterDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "characters.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_CHARACTERS = "characters"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_RACE = "race"
        private const val COLUMN_CLASS = "class"
        private const val COLUMN_DESCRIPTION = "description"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE $TABLE_CHARACTERS ("
                + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$COLUMN_NAME TEXT, "
                + "$COLUMN_RACE TEXT, "
                + "$COLUMN_CLASS TEXT, "
                + "$COLUMN_DESCRIPTION TEXT)")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CHARACTERS")
        onCreate(db)
    }

    fun addCharacter(character: Character) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NAME, character.name)
        values.put(COLUMN_RACE, character.race)
        values.put(COLUMN_CLASS, character.characterClass)
        values.put(COLUMN_DESCRIPTION, character.description)

        db.insert(TABLE_CHARACTERS, null, values)
        db.close()
    }

    fun getAllCharacters(): List<Character> {
        val characterList = ArrayList<Character>()
        val selectQuery = "SELECT * FROM $TABLE_CHARACTERS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val character = Character(
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_RACE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CLASS)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION))
                )
                characterList.add(character)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return characterList
    }

    fun deleteAllCharacters() {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_CHARACTERS")
        db.close()
    }
}
