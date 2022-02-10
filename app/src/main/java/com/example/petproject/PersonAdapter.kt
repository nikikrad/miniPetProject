package com.example.petproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.example.petproject.dataClass.dataPerson
import com.example.petproject.servises.Person

class PersonAdapter(
    private val personsList:List<dataPerson>
): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    override fun getItemCount(): Int = personsList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.item_users, parent, false)


        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(personsList[position])
    }


    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val name: TextView = itemView.findViewById(R.id.tv_Name)
        private val avatar: ImageView = itemView.findViewById(R.id.iv_Photo)

        fun bind(item: dataPerson){
            name.text = item.name
            Glide.with(PersonAdapter)
            avatar.setImageURI(avatar)
        }
    }
}