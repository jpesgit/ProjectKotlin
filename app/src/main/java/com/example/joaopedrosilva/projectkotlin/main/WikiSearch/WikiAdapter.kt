package com.example.joaopedrosilva.projectkotlin.main.WikiSearch

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.joaopedrosilva.projectkotlin.R
import kotlinx.android.synthetic.main.item_wiki.view.*
import java.text.SimpleDateFormat

/**
 * Created by joaopedrosilva on 06/11/17.
 */
class WikiAdapter(val wikis: MutableList<Search>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
//        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_to_do, parent, false)
        // n ha motivo para n ser var!!
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_wiki, parent, false)
        return Item(v)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as Item).bindData(wikis[position])
    }

    fun setAdapterItems(items: List<Search>) {
        this.wikis.clear()
        this.wikis.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = wikis.size

    @Suppress("JoinDeclarationAndAssignment")
    class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title_tv: TextView
        private val date_tv: TextView
        private val page_id_tv: TextView
        private val snippet_tv: TextView

        init {
            this.title_tv = itemView.findViewById(R.id.title_tv)
            this.date_tv = itemView.findViewById(R.id.date_tv)
            this.page_id_tv = itemView.findViewById(R.id.page_id_tv)
            this.snippet_tv = itemView.findViewById(R.id.snippet_tv)
        }

        // vê o bytecode que esta classe gerou.
        // as extensions não funcionam aqui
        // (o código que é gerado é um findViewById, o que só é preciso fazer 1 vez)
        fun bindData(search: Search) = with(itemView) {
            title_tv.text = search.title
            date_tv.text = formatDate(search.timestamp)
            page_id_tv.text = "Page id: ${search.pageid}"
            snippet_tv.text = search.snippet
        }

        fun formatDate(inputText: String): String {
            val outputFormat = SimpleDateFormat("MM/yyyy")
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

            val date = inputFormat.parse(inputText)
            val outputText = outputFormat.format(date)
            return outputText
        }
    }
}