package com.salvatoreacademy.sa_android_nativo_iniciante_app1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

// Boilerpalte -> Trecho de código que a gente não necessariamente precisa saber funcionan no detale, mas precisamos manter
// e saber como usar.

class CreatureListAdapter(private val items: List<Creature>) : RecyclerView.Adapter<CreatureListAdapter.CreatureViewHolder>() {

    class CreatureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Informações para quando criar um ViewHolder novo, saber como exibir as infos do item
        fun bindView(item: Creature) {
            val tvNumber = itemView.findViewById<TextView>(R.id.tvNumber)
            tvNumber.text = item.number.toString()
            val tvName = itemView.findViewById<TextView>(R.id.tvName)
            tvName.text = item.name




            // Buscar elemento pelo id e armanezar em variável (val ou var) - val: não muda - var: pode mudar
            val cvCreature = itemView.findViewById<CardView>(R.id.cvCreature)

            // Criar um listener de click para um elemento
            cvCreature.setOnClickListener {
                // Comportamento que sera executado ao clicar no elemento
                Toast.makeText(itemView.context, "CardView clicado!", Toast.LENGTH_SHORT).show()

                // Abrir uma nova Activity
                // Criamos uma Intent
                val newActivityIntent = Intent(itemView.context, CreatureViewActivity::class.java)

                // Registarmos a Intent com o resultado esperado (abrir uma Activity)
                itemView.context.startActivity(newActivityIntent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_creature_item, parent, false)
        return  CreatureViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CreatureViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }

}
