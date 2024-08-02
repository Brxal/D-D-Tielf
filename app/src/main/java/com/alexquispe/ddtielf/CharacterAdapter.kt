package com.alexquispe.ddtielf

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter(private val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character: Character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int = characters.size

    class CharacterViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_character, parent, false)) {

        private val characterName: TextView = itemView.findViewById(R.id.characterName)
        private val characterRace: TextView = itemView.findViewById(R.id.characterRace)
        private val characterClass: TextView = itemView.findViewById(R.id.characterClass)
        private val characterDescription: TextView = itemView.findViewById(R.id.characterDescription)

        fun bind(character: Character) {
            characterName.text = character.name
            characterRace.text = character.race
            characterClass.text = character.characterClass
            characterDescription.text = character.description
        }
    }
}
